package Fitness;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FitnessCenter {
    private List<Trainers> fitnessCenter = new ArrayList<>();
    Set <LocalDate> holidays = new HashSet<>();
    int workDayCounter = 5;
    int firstShiftBegin = 8;
    int secondShiftBegin = 15;
    int shiftCounter = 8;

    boolean recruitTrainer (Trainers newTrainer) {
        Scanner scan = new Scanner (System.in);
        System.out.println("What shift do you prefer?");
        int shift = scan.nextInt();
        int currentYear = LocalDate.now().getYear();
        LocalDate recruitDate = LocalDate.now();
        LocalDate nextDay=recruitDate;
        boolean checkYear=checkCurrentYear (recruitDate, currentYear);
        while (checkYear){
            if (checkWorkingDay (nextDay) == true) {
                newTrainer.workSchedule.put(LocalDateTime.of(nextDay, LocalTime.of(shift==1?firstShiftBegin:secondShiftBegin, 0)), newTrainer.trainingDuration);
            }
            nextDay = nextDay.plusDays(1);
            checkYear = checkCurrentYear (nextDay, currentYear);
        }
        System.out.println(newTrainer.workSchedule);
        return fitnessCenter.add(newTrainer);
    }

    private boolean checkWorkingDay(LocalDate recruitDate) {
        if (recruitDate.getDayOfWeek().getValue() < workDayCounter) {
            if (!holidays.contains(recruitDate)) {
                return true;
            }
        }
        return false;
    }

    boolean checkCurrentYear (LocalDate someDate, int currentYear) {
        if (someDate.getYear() == currentYear) {
            return true;
        }
        return false;
    }

    boolean fireTrainer (String lastName) {
        Iterator<Trainers> iteratorRemoving = fitnessCenter.iterator();
        while (iteratorRemoving.hasNext()) {
            if ((iteratorRemoving.next().getSurname()).equals(lastName)) {
                iteratorRemoving.remove();
                return true;
            }
        }
        return false;
    }

    boolean addHoliday (LocalDate holidayDate) {
        return holidays.add(holidayDate);
    }

    boolean removeHoliday (LocalDate holidayDate) {
        return holidays.remove(holidayDate);
    }

    Trainers modeOfTrainerChoose () {
        System.out.println("Do you know your trainer last name?");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine().toLowerCase();
        if (answer.equals("yes")) {
            return chooseFitnessTrainer();
        }
        else {
            return chooseSportType();
        }
    }


    Trainers chooseFitnessTrainer() {
        String fitnessLastName;
        ArrayList<Trainers> listOfAvailableTrainers = new ArrayList();
        System.out.println("Enter your trainer last name: ");
        while (true) {
            Scanner scan1 = new Scanner(System.in);
            if (scan1.hasNextLine()) {
                String st1 = scan1.nextLine();
                for (int i = 0; i < fitnessCenter.size(); i++) {
                    fitnessLastName = st1;
                    if (!(fitnessCenter.get(i).getSurname()).contains(st1) == true) {
                        System.out.println("There is no such trainer in the list! Try again!");
                    } else {
                    do {
                        listOfAvailableTrainers.add(fitnessCenter.get(i));
                       // i++;
                    } while ((fitnessCenter.get(i).getSurname()).contains(st1) == true); }
                }
            }
            return chooseOneTrainer(listOfAvailableTrainers);
        }
    }

    Trainers chooseSportType () {
        ArrayList listOfAvailableTrainers = new ArrayList();
        Enum sportType;
        System.out.println("You can choose one of the following sport types: FITNESS, YOGA, POWERLIFTING, SWIMMING");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine().toUpperCase();
        sportType = SportTypes.valueOf(answer);
        for (int i = 0; i < fitnessCenter.size(); i++) {
            do {
                listOfAvailableTrainers.add(fitnessCenter.get(i));
            } while (fitnessCenter.get(i).getSportType().equals(sportType));
        }
        return chooseOneTrainer(listOfAvailableTrainers);
    }

    Trainers chooseOneTrainer (ArrayList<Trainers> listOfAvailableTrainers) {
        System.out.println(listOfAvailableTrainers + "\nPlease choose the trainer from the list:");
        while (true) {
            Scanner scan1 = new Scanner(System.in);
            String answer1 = scan1.nextLine();
            for (int i = 0; i > listOfAvailableTrainers.size(); i++) {
                if ((fitnessCenter.get(i).getSurname()).equals(answer1) == true) {
                    System.out.println("The name of your trainers is " + fitnessCenter.get(i).getSurname());
                    return fitnessCenter.get(i);
                } else {
                System.out.println("Please enter the exact surname of your trainer!");
                }
            }
        }
    }

    boolean checkTrainerTime (Trainers myTrainer, LocalDateTime trainingStart) {
        Set<Map.Entry<LocalDateTime, Integer>> entrySet = myTrainer.workSchedule.entrySet();
        if (myTrainer.workSchedule.containsKey(trainingStart)) {
            for (Map.Entry<LocalDateTime, Integer> temp : entrySet)
                return !trainingStart.isAfter(temp.getKey());
                //return temp.getKey().equals(trainingStart); // ????
        }
        return false;
   }


    Map<String, LocalDateTime> enjoyTraining () {
        Map<String, LocalDateTime> training = new HashMap<>();
        String lastName = "";
        LocalDateTime dateOfTraining = null;
        Trainers myTrainer = null;
        System.out.println("Please enter your name: ");
        while (true) {
            while (true) {
                Scanner scan = new Scanner(System.in);
                if (scan.hasNextLine()) {
                    lastName = scan.nextLine();
                    break;
                } else {
                    System.out.println("Please enter your last name!");
                }
            }
            myTrainer = modeOfTrainerChoose();
            dateOfTraining = chooseGroupOrIndividualTraining(myTrainer);
            training.put(lastName, dateOfTraining);
            if (checkTrainerTime(myTrainer, dateOfTraining) == true) {
                training.put(lastName, dateOfTraining);
                myTrainer.workSchedule.remove(dateOfTraining);
                System.out.println("You are added to training list successfully!");
                break;
            } else {
                System.out.println("This training time is not available. Try another one!");
            }
        }
        return training;
    }

    LocalDateTime chooseGroupOrIndividualTraining (Trainers myTrainer) {
        LocalDateTime dateOfTraining = null;
        System.out.println("What type of training do you prefer: group(1) or individual(2)?");
        Scanner scan = new Scanner(System.in);
        int answer = scan.nextInt();
        switch (answer) {
            case 1:
                dateOfTraining = checkTrainerGroupTime (myTrainer);
                break;
            case 2:
                dateOfTraining = checkTrainerIndividualTime (myTrainer);
                break;
        }
        return dateOfTraining;
    }

    LocalDateTime checkTrainerGroupTime (Trainers myTrainer) {
        LocalDateTime dateOfTraining = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm:ss a");
        if (myTrainer.groupTrainings.isEmpty() == true) {
            System.out.println("Please enter your training time: ");
            while (true) {
                Scanner scan1 = new Scanner(System.in);
                try {
                    dateOfTraining = LocalDateTime.parse(scan1.nextLine(), formatter);
                    System.out.println(dateOfTraining);
                    break;
                } catch (IllegalArgumentException ex) {
                    System.out.println(String.format("Ooops! Something wrong", ex.getMessage()));
                }
            }
            myTrainer.workSchedule.remove(dateOfTraining);
            myTrainer.groupTrainings.put(dateOfTraining, myTrainer.trainingDuration);
        }
        else {
            System.out.println(myTrainer.groupTrainings + "\nPlease choose the group time from available variants");
            while (true) {
                Scanner scan2 = new Scanner(System.in);
                try {
                    dateOfTraining = LocalDateTime.parse(scan2.nextLine(), formatter);
                    System.out.println(dateOfTraining);
                    break;
                } catch (IllegalArgumentException ex) {
                    System.out.println(String.format("Ooops! Something wrong", ex.getMessage()));
                }
            }
        }
        return dateOfTraining;
    }

    LocalDateTime checkTrainerIndividualTime (Trainers myTrainer) {
        LocalDateTime dateOfTraining = null;
        System.out.println("Please enter your training time: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm:ss a");
        while (true) {
            Scanner scan1 = new Scanner(System.in);
            try {
                dateOfTraining = LocalDateTime.parse(scan1.nextLine(), formatter);
                System.out.println(dateOfTraining);
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(String.format("Ooops! Something wrong", ex.getMessage()));
            }
        }
        myTrainer.workSchedule.remove(dateOfTraining);
        myTrainer.individualTrainings.put(dateOfTraining, myTrainer.trainingDuration);
        return dateOfTraining;
    }

    void enjoyFitness () {
        Map<String, LocalDateTime> training = enjoyTraining();
        for (Map.Entry entry : training.entrySet()) {
                System.out.println("Client name: " + entry.getKey() + "\nTraining date: " + entry.getValue());
            }
        }
}
