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

    boolean fireTrainer (String lastName) { // переделать на булевое значение
        Iterator<Trainers> iteratorRemoving = fitnessCenter.iterator();
        while (iteratorRemoving.hasNext()) {
            if ((iteratorRemoving.next().getSurname()).equals(lastName)) {
                iteratorRemoving.remove();
                break;
            }
        }
        return true;
    }

    boolean addHoliday (LocalDate holidayDate) {
        return holidays.add(holidayDate);
    }

    boolean removeHoliday (LocalDate holidayDate) {
        return holidays.remove(holidayDate);
    }




    String chooseFitnessTrainer(ArrayList<Trainers> fitnessCenter) { // расширить поиск и по виду спорта
        String fitnessLastName = "";
        System.out.println("Enter your trainer last name: ");
        while (true) {
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextLine()) {
                String st1 = scan.nextLine();
                for (int i = 0; i < fitnessCenter.size(); i++) {
                    if ((fitnessCenter.get(i).getSurname()).contains(st1) == true) {
                        fitnessLastName = st1;
                        break;
                    }
                } if(!fitnessLastName.isEmpty()) {
                    return fitnessLastName;
                }
                else {
                    System.out.println("There is no such trainer in the list! Try again!");
                }
            }
        }
    }

    boolean checkTrainerTime (String trainerLastName, String lastName, LocalDateTime trainingStart, int trainingDuration, LocalDateTime workingScheduleStart, LocalDateTime workingScheduleEnd) {
        boolean available = false;
        Duration workingDayDuration = Duration.between(workingScheduleStart, workingScheduleEnd);
      //  Duration trainingDuration1 = (trainingStart.plusHours((long) trainingDuration);
        if (false) { // проверка содержит ли рабочее время время тренировки?????????!!!!!
          //  workingDayDuration.minus(trainingDuration1);
            available = true;

        }return available;
   }


    Map<String, LocalDateTime> enjoyTraining (String trainerLastName, LocalDateTime workingScheduleStart, LocalDateTime workingScheduleEnd) {
        Map<String, LocalDateTime> training = new HashMap<>();
        String lastName = "";
        LocalDateTime dateOfTraining = null;
        int trainingDuration = 0;
        System.out.println("Please enter your name: ");
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextLine()) {
            lastName = scan.nextLine();
        }
        else {
            System.out.println("Please enter your last name!");
        }
        System.out.println("Please enter your training time: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm:ss a");
        Scanner scan1 = new Scanner(System.in);
        try {
            dateOfTraining = LocalDateTime.parse(scan1.nextLine(), formatter);
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println(String.format("Ooops! Something wrong", ex.getMessage()));
        }
        if (checkTrainerTime(trainerLastName, lastName, dateOfTraining, trainingDuration, workingScheduleStart, workingScheduleEnd) == true) {
            training.put (lastName, dateOfTraining);
            System.out.println("You are added to training list successfully!");
        }
        else {
            System.out.println("This training time is not available. Try another one!");
        }
        return training;
    }

//    void enjoyFitness (ArrayList<Trainers> fitnessCenter) {
//        Map <String, Map<String, LocalDateTime>> fitnessClub = new HashMap<>();
//        String fitnessName = chooseFitnessTrainer (fitnessCenter);
//        Map<String, LocalDateTime> training = enjoyTraining(fitnessName, fitnessCenter.get(1).getWorkingScheduleStart(), fitnessCenter.get(1).getWorkingScheduleEnd());
//        fitnessClub.put(fitnessName, training);
//        for (Map.Entry entry : fitnessClub.entrySet()) {
//            for (Map.Entry temp : training.entrySet()) {
//                System.out.println("Trainer name: " + entry.getKey() + "\nClient name: " + temp.getKey() + "\nTraining date: " + temp.getValue());
//            }
//        }
//    }

    public static void main(String[] args) {
        FitnessCenter obj = new FitnessCenter();
        Trainers trainer1 = new Trainers("Doe", "Fitness", 60);
        obj.addHoliday(LocalDate.of(2019, 12, 25));
        obj.recruitTrainer(trainer1);
    }
}
