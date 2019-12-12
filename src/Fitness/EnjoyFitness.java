package Fitness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EnjoyFitness {
    public static void main(String[] args) {
        FitnessCenter obj = new FitnessCenter();
        Trainers trainer1 = new Trainers("Doe", SportTypes.FITNESS, 60);
        obj.addHoliday(LocalDate.of(2019, 12, 25));
        obj.recruitTrainer(trainer1);
        obj.enjoyFitness();
        obj.enjoyFitness();

    }
}
