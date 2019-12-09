package Fitness;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


public class Trainers {
    private String surname;
    private String sportType;
    private LocalDateTime workingScheduleStart;
    private LocalDateTime workingScheduleEnd;
    int trainingDuration;
    Map<LocalDateTime,Integer> workSchedule = new HashMap<>();

    Trainers (String surname, String sportType, int trainingDuration) {
        this.surname = surname;
        this.sportType = sportType;
        this.trainingDuration = trainingDuration;
    }

    String getSurname () { return surname; }
    String getSportType () {return sportType; }


    void setTraining (LocalDateTime trainingTime, int duration) {
        workSchedule.put(trainingTime, duration);
    }

    Integer removeTraining (LocalDateTime trainingTime) {
        return workSchedule.remove(trainingTime);
    }


    public static void main(String[] args) {
        Trainers trainer1 = new Trainers("Smith", "Fitness", 60);
        LocalDateTime localTime1 = LocalDateTime.of(2019, 12, 3, 9, 00);
        LocalDateTime localTime2 = LocalDateTime.of(2019, 12, 3, 9, 00);
        trainer1.workSchedule.put(localTime1, 9);
        trainer1.workSchedule.put(localTime2, 9);
        System.out.println(trainer1.workSchedule.toString());

    }



}
