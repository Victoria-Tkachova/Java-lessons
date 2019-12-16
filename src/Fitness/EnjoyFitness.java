package Fitness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EnjoyFitness {
    public static void main(String[] args) {
        FitnessCenter obj = new FitnessCenter();
        Trainers trainer1 = new Trainers("Doe", SportTypes.FITNESS, 60);
        obj.addHoliday(LocalDate.of(2019, 12, 25));
        obj.recruitTrainer(trainer1, 1);
        obj.modeOfTrainerChoose(2);
        obj.chooseSportType("FITNESS");
        LocalDateTime dayOfTraining = obj.checkDateFormat("Tuesday, 12/17/2019, 08:00 AM");
        System.out.println(obj.chooseOneTrainer(obj.chooseSportType("FITNESS"), "Doe"));
        System.out.println(obj.enjoyTraining(dayOfTraining, "Smith", obj.chooseOneTrainer(obj.chooseSportType("FITNESS"), "Doe"), 1));


    }
}
