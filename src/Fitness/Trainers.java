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
    private Enum sportType;
    private LocalDateTime workingScheduleStart;
    private LocalDateTime workingScheduleEnd;
    int trainingDuration;
    Map<LocalDateTime,Integer> workSchedule = new HashMap<>();
    Map<LocalDateTime, Integer> individualTrainings = new HashMap<>();
    Map<LocalDateTime, Integer> groupTrainings = new HashMap<>();

    Trainers (String surname, Enum sportType, int trainingDuration) {
        this.surname = surname;
        this.sportType = sportType;
        this.trainingDuration = trainingDuration;
    }

    String getSurname () { return surname; }
    Enum getSportType () {return sportType; }


    void setTraining (LocalDateTime trainingTime, int duration) {
        workSchedule.put(trainingTime, duration);
    }

    Integer removeTraining (LocalDateTime trainingTime) {
        return workSchedule.remove(trainingTime);
    }


    @Override
    public String toString() {
        return "Trainers{" +
                "surname='" + surname + '\'' +
                ", sportType=" + sportType +
                ", trainingDuration=" + trainingDuration +
                ", workSchedule=" + workSchedule +
                '}';
    }
}
