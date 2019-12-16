package Fitness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FitnessCenter {
    private List<Trainers> fitnessCenter = new ArrayList<>();
    Set<LocalDate> holidays = new HashSet<>();
    int workDayCounter = 5;
    int firstShiftBegin = 8;
    int secondShiftBegin = 15;
    int shiftCounter = 8;
    Map<LocalDateTime, Integer> training = new HashMap<>();

    boolean recruitTrainer(Trainers newTrainer, int shift) { // нанимаем тренера на работу
        int currentYear = LocalDate.now().getYear();
        LocalDate recruitDate = LocalDate.now();
        LocalDate nextDay = recruitDate;
        boolean checkYear = checkCurrentYear(recruitDate, currentYear);
        while (checkYear) {
            if (checkWorkingDay(nextDay) == true) {
                newTrainer.workSchedule.put(LocalDateTime.of(nextDay, LocalTime.of(shift == 1 ? firstShiftBegin : secondShiftBegin, 0)), newTrainer.trainingDuration);
            }
            nextDay = nextDay.plusDays(1);
            checkYear = checkCurrentYear(nextDay, currentYear);
        }
        System.out.println(newTrainer.workSchedule);
        return fitnessCenter.add(newTrainer);
    }

    private boolean checkWorkingDay(LocalDate recruitDate) { // проверяем рабочий ли день приема на работу
        if (recruitDate.getDayOfWeek().getValue() < workDayCounter) {
            if (!holidays.contains(recruitDate)) {
                return true;
            }
        }
        return false;
    }

    boolean checkCurrentYear(LocalDate someDate, int currentYear) { // проверяем год при приеме на работу
        if (someDate.getYear() == currentYear) {
            return true;
        }
        return false;
    }

    boolean fireTrainer(String lastName) { // увольням тренера
        Iterator<Trainers> iteratorRemoving = fitnessCenter.iterator();
        while (iteratorRemoving.hasNext()) {
            if ((iteratorRemoving.next().getSurname()).equals(lastName)) {
                iteratorRemoving.remove();
                return true;
            }
        }
        return false;
    }

    boolean addHoliday(LocalDate holidayDate) {
        return holidays.add(holidayDate);
    } // возможность добавить праздники

    boolean removeHoliday(LocalDate holidayDate) {
        return holidays.remove(holidayDate);
    } // возможность удалить праздник

    void modeOfTrainerChoose(int mode) { // выбор тренера по фамилиии или по спорт типу (1 - фамилия, 2 - спорт тип)
        switch (mode) {
            case 1:
                for (Trainers temp : fitnessCenter) {
                    System.out.println(temp.getSurname());
                }
                break;
            case 2:
                for (Trainers temp1 : fitnessCenter) {
                    System.out.println(temp1.getSportType() + " " + temp1.getSurname());
                }
                break;
        }
    }

    LocalDateTime checkDateFormat(String dayOfTraining) { // проверка ввода и форматирования даты пользователя
        LocalDateTime dateOfTraining = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MM/dd/yyy, hh:mm a");
        try {
            dateOfTraining = LocalDateTime.parse(dayOfTraining, formatter);
        } catch (IllegalArgumentException iaex) {
            throw new IllegalArgumentException("The string is not parsed!", iaex);
        }
        return dateOfTraining;
    }

    ArrayList<Trainers> chooseFitnessTrainer(String surname) { // проверка тренера по части фамилии
        ArrayList<Trainers> listOfAvailableTrainers = new ArrayList();
        for (int i = 0; i < fitnessCenter.size(); i++) {
            if ((fitnessCenter.get(i).getSurname()).contains(surname)) {
                listOfAvailableTrainers.add(fitnessCenter.get(i));
            } else {
                System.out.println("There is no such trainer. Please try again!");
            }
        }
        return listOfAvailableTrainers;
    }

    ArrayList<Trainers> chooseSportType(String answer) { // проверка тренеров по спорт типу
        ArrayList listOfAvailableTrainers = new ArrayList();
        Enum sportType;
        sportType = SportTypes.valueOf(answer);
        for (int i = 0; i < fitnessCenter.size(); i++) {
            if ((fitnessCenter.get(i).getSportType().equals(answer))) {
                listOfAvailableTrainers.add(fitnessCenter.get(i));
            }
        }
        return listOfAvailableTrainers;
    }

    Trainers chooseOneTrainer(ArrayList<Trainers> listOfAvailableTrainers, String surname) { // выбор одного тренера
        Trainers result = null;
        for (Trainers temp : fitnessCenter) {
            if ((temp.getSurname()).equals(surname)) {
                result = temp;
            }
        }
        return result;
    }

    boolean checkTrainerTime(Trainers myTrainer, LocalDateTime trainingStart) { // проверка свободно ли время у тренера
        Set<Map.Entry<LocalDateTime, Integer>> entrySet = myTrainer.workSchedule.entrySet();
        if (myTrainer.workSchedule.containsKey(trainingStart)) {
            for (Map.Entry<LocalDateTime, Integer> temp : entrySet)
                return !trainingStart.isAfter(temp.getKey());
            //return temp.getKey().equals(trainingStart); // ????
        }
        return false;
    }


    Map<String, Map<LocalDateTime, Integer>> enjoyTraining (LocalDateTime dateOfTraining, String lastName, Trainers myTrainer, int mode) { // запись на тренировку
        if (chooseGroupOrIndividualTraining(myTrainer, dateOfTraining, mode) && checkTrainerIndividualTime(myTrainer, dateOfTraining)) {
            myTrainer.workSchedule.remove(dateOfTraining);
            training.put(dateOfTraining, myTrainer.trainingDuration);
            myTrainer.individualTrainings.put(lastName, training);
            return myTrainer.individualTrainings;
        } else {
            if (checkTrainerGroupTime(myTrainer, dateOfTraining)) {
                myTrainer.workSchedule.remove(dateOfTraining);
                training.put(dateOfTraining, myTrainer.trainingDuration);
                myTrainer.groupTrainings.put(lastName, training);
            }
            return myTrainer.groupTrainings;
        }
    }

    boolean chooseGroupOrIndividualTraining(Trainers myTrainer, LocalDateTime dateOfTraining, int mode) { // выбор групповой или индивидуальной тренировки (1 - групповая, 2 - индивидуальная)
        boolean result = false;
        switch (mode) {
            case 1:
                result = checkTrainerIndividualTime(myTrainer, dateOfTraining);
                break;
            case 2:
                result = checkTrainerGroupTime(myTrainer, dateOfTraining);
                break;
        }
        return result;
    }

    boolean checkTrainerGroupTime(Trainers myTrainer, LocalDateTime dateOfTraining) { // проверка группового времени
        boolean result = false;
        if (myTrainer.groupTrainings.isEmpty() == true && myTrainer.workSchedule.containsKey(dateOfTraining)) {
                result = true;}
        return result;
    }

        boolean checkTrainerIndividualTime (Trainers myTrainer, LocalDateTime dateOfTraining){ // проверка индивидуального времени
            boolean result = false;
            if (!myTrainer.individualTrainings.containsKey(dateOfTraining) && myTrainer.workSchedule.containsKey(dateOfTraining)) {
                result = true;
            }
            return result;
        }

        void receiveTimeInformation (Trainers myTrainer, LocalDateTime dateOfTraining, int mode, String lastName) { // вывод и отображение информации
            Map<String, Map <LocalDateTime, Integer>> result = enjoyTraining(dateOfTraining, lastName, myTrainer, mode);
            for (Map.Entry entry : result.entrySet()) {
                for (Map.Entry temp: training.entrySet()) {
                    System.out.println("Client name: " + entry.getKey() + "\nTraining date: " + temp.getKey() + "\nTraining duration: " + temp.getValue());
                }
            }
        }
    }

