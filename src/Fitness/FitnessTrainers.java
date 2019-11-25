package Fitness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FitnessTrainers {
    static ArrayList<String> listOfTrainers = new ArrayList<>();

    static {
        Collections.addAll(listOfTrainers, "Smith", "Tailor", "Daniels", "Kruz", "Kidman", "Harvey");
    }

    void enjoyFitness (ArrayList listOfTrainers) {
        Map <String, Map<String, LocalDateTime>> fitnessClub = new HashMap<>();
        String fitnessName = fitnessLastName(listOfTrainers);
        Map<String, LocalDateTime> training = enjoyTraining();
        fitnessClub.put(fitnessName, training);
        for (Map.Entry entry : fitnessClub.entrySet()) {
            for (Map.Entry temp : training.entrySet()) {
                System.out.println("Trainer name: " + entry.getKey() + "\nClient name: " + temp.getKey() + "\nTraining date: " + temp.getValue());
            }
        }

    }

    String fitnessLastName(ArrayList listOfTrainers) {
        String fitnessLastName = "";
        System.out.println("Choose the trainer!");
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextLine()) {
            String st1 = scan.nextLine();
            for (int i = 0; i < listOfTrainers.size(); i++) {
                if (listOfTrainers.contains(st1) == true) {
                    fitnessLastName = st1;
                } else {
                    System.out.println("There is no such trainer in the list!");
                    // scan.nextLine();
                }
            }
        }
        return fitnessLastName;
    }

    Map<String, LocalDateTime> enjoyTraining () {
        Map<String, LocalDateTime> training = new HashMap<>();
        String lastName = "";
        LocalDateTime dateOfTraining = null;
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
        training.put (lastName, dateOfTraining);
        return training;
    }

    public static void main(String[] args) {
        System.out.println(listOfTrainers);
        FitnessTrainers obj = new FitnessTrainers();
        obj.enjoyFitness(listOfTrainers);
    }

}
