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

    Fisher getWinner (LocalDate date1, LocalDate date2, FishType fishType) {
        Fisher result = null;
        if (date1.isAfter(date2)) {
            Period tutor = date2.until(date1);
        }
        else {
            Period tutor = date1.until(date2);
        }
        for (LocalDate temp: setka.keySet()) {
            float tutorFishWeight = 0;
            ArrayList<Fish> setkaOfPeriod=setka.get(temp);
            for(Fish tempFish:setkaOfPeriod){
                if(tempFish.name.equals(fishType)){
                    tutorFishWeight +=tempFish.weight;
                }
        }
        return result;
    }
  //  int one (LocalDate start,LocalDate end, FishType fishType){
    //    int result=0;
      //  for(LocalDate temp:setka.keySet()){
        //    if(isDiapazon(start,end)){
          //      ArrayList<Fish> setkaOdDay=setka.get(temp);
            //    for(Fish tempFish:setkaOdDay){
              //      if(tempFish.name.equals(fishType)){
                //        result+=tempFish.weight;
              //      }
              //  }
           // }
       // }
        return  result;
    }

}
