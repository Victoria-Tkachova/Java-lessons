package CollectionExample;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FishModel {
    public static void main(String[] args) {
        Fish fish1 = new Fish (FishType.Shark, 5.6f);
        Fish fish2 = new Fish (FishType.Shuka, 5.7f);
    }
    private ArrayList <Fisher> fisherSociety = new ArrayList<>();

    boolean addFisher (Fisher obj) {
        return fisherSociety.add (obj);
    }

    Fisher getWinner (LocalDate date1, LocalDate date2, FishType fishType) {
        Fisher result = null;
        if (date1.isAfter(date2)) {
            Period tutor = date1.until(date2);
        }
        else {
            Period tutor = date2.until(date1);
        }


        return result;

    }
}

class Fish {
    FishType name;
    float weight;

    Fish (FishType name, float weight) {
        this.name = name;
        this.weight = weight;
    }
}

enum FishType {
    Shark, Sudak, Shuka, Karp;
}

class Fisher {
    String name;
    Map<LocalDate, ArrayList<Fish>> setka = new HashMap<>();

    void catchFish (Fish newFish, LocalDate catchDate) {
        ArrayList <Fish> temp = setka.get(catchDate);
        if (temp == null) {
            ArrayList<Fish> daySetka = new ArrayList<>();
            daySetka.add (newFish);
            setka.put(catchDate, daySetka);
         }
        else {
            temp.add(newFish);
         }
    }
}
