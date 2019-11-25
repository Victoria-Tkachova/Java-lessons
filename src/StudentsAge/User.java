package StudentsAge;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class User implements Comparable <User> {
    String name;
    LocalDate dateOfBirth;

    User (String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    int ageCounter () {
        int result = 0;
        result = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }



    public static void main(String[] args) {
        HashMap <User, Integer> userMap = new HashMap<>();
        User user1 = new User ("Smith", LocalDate.of(1988, 02, 23));
        User user2 = new User ("Doe", LocalDate.of(2000, 12, 23));
        User user3 = new User ("Doe", LocalDate.of(2000, 03, 23));
        User user4 = new User ("Bond", LocalDate.of(1989,12,06));



        userMap.put (user1, user1.ageCounter());
        userMap.put (user2, user2.ageCounter());
        userMap.put (user3, 10);
        userMap.put (user3, 100);

        System.out.println(userMap);

        TreeMap <User, Integer> userTreeMap = new TreeMap<>();
        userTreeMap.put(user1, user1.ageCounter());
        userTreeMap.put(user2, user2.ageCounter());
        userTreeMap.put(user3, user3.ageCounter());
        userTreeMap.put(user4, user4.ageCounter());

       // for(Map.Entry<User,Integer> temp: userTreeMap.entrySet()){
    //        int plusYear = temp.getValue() + 1;
    //        userTreeMap.replace(temp.getKey(), plusYear);
    //    }
    //    for (User temp:userTreeMap.keySet()) {
    //        int plusYear1 = userTreeMap.get(temp) +1 ;
   //         userTreeMap.replace(temp, plusYear1);
    //    }

        System.out.println(userTreeMap);

    }



    @Override
    public int compareTo(User user) {
        return this.dateOfBirth.compareTo(user.dateOfBirth);
    }
}
