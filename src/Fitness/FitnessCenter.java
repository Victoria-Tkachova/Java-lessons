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


    Trainers chooseFitnessTrainer() {
        String fitnessLastName;
        String typeOfSport;
        System.out.println("Do you know your trainer last name?");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine().toLowerCase();
        if (answer.equals("yes")) {
            System.out.println("Enter your trainer last name: ");
            while (true) {
                Scanner scan1 = new Scanner(System.in);
                if (scan1.hasNextLine()) {
                    String st1 = scan1.nextLine();
                    for (int i = 0; i < fitnessCenter.size(); i++) {
                        if ((fitnessCenter.get(i).getSurname()).contains(st1) == true) {
                            fitnessLastName = st1;
                            return fitnessCenter.get(i);
                        } else {
                            System.out.println("There is no such trainer in the list! Try again!");
                        }
                    }
                }
            }
        }
        else {
            System.out.println("Please enter the type of sport you are interested in: ");
            while (true) {
                Scanner scan2 = new Scanner(System.in);
                if (scan2.hasNextLine()) {
                    String st2 = scan2.nextLine();
                    for (int i = 0; i < fitnessCenter.size(); i++) {
                        if ((fitnessCenter.get(i).getSportType()).contains(st2) == true) {
                            System.out.println("Fitness trainer for your sport type is " + fitnessCenter.get(i).getSurname());
                            return fitnessCenter.get(i);
                        }
                        else {
                            System.out.println("We do not have trainings in this sport!");
                        }
                    }
                }
            }
        }
    }

    boolean checkTrainerTime (Trainers myTrainer, LocalDateTime trainingStart) {
        Set<Map.Entry<LocalDateTime, Integer>> entrySet = myTrainer.workSchedule.entrySet();
        if (myTrainer.workSchedule.containsKey(trainingStart)) {
            for (Map.Entry<LocalDateTime, Integer> temp : entrySet)
            return !trainingStart.isAfter(temp.getKey());
        }
        return false;
   }


    Map<String, LocalDateTime> enjoyTraining (Trainers myTrainer) {
        Map<String, LocalDateTime> training = new HashMap<>();
        String lastName = "";
        LocalDateTime dateOfTraining = null;
        int trainingDuration = 0;
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


    void enjoyFitness () {
        Trainers myTrainer = chooseFitnessTrainer();
        Map<String, LocalDateTime> training = enjoyTraining(myTrainer);
        for (Map.Entry entry : training.entrySet()) {
                System.out.println("Trainer name: " + myTrainer.getSurname() + "\nClient name: " + entry.getKey() + "\nTraining date: " + entry.getValue());
            }
        }


    public static void main(String[] args) {
        FitnessCenter obj = new FitnessCenter();
        Trainers trainer1 = new Trainers("Doe", "Fitness", 60);
        obj.addHoliday(LocalDate.of(2019, 12, 25));
        obj.recruitTrainer(trainer1);
        obj.enjoyFitness();
        obj.enjoyFitness();

    }
}
