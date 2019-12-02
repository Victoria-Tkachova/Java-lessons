package Fitness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Trainers {
    private String surname;
    private String sportType;
    private LocalDateTime workingScheduleStart;
    private LocalDateTime workingScheduleEnd;

    Trainers (String surname, String sportType) {
        this.surname = surname;
        this.sportType = sportType;

    }

    String getSurname () { return surname; }
    LocalDateTime getWorkingScheduleStart () {return workingScheduleStart; }
    LocalDateTime getWorkingScheduleEnd () {return workingScheduleEnd; }


    LocalDateTime setWorkingStartTime(String surname, String startWorkingTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, d MM yyyy, hh:mm a");
        LocalDateTime workingScheduleStart = LocalDateTime.parse(startWorkingTime, formatter);
        return workingScheduleStart;
    }

    LocalDateTime setWorkingEndTime (String surname, LocalDateTime workingScheduleStart) {
        LocalDateTime workingScheduleEnd = workingScheduleStart.plusHours(8);
        return workingScheduleEnd;
    }



}
