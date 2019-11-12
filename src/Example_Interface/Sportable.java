package Example_Interface;

@FunctionalInterface
public interface Sportable {
     int r=89;
    void doExercise ();

     default void doExercise1 (){
         System.out.println("defa");
     }

}

class Boxer implements Sportable {
String name;
    Boxer(String name){
        this.name=name;
        doExercise1();
        System.out.println(r);
    }

    @Override
    public void doExercise() {
        System.out.println("Boxing");
        doExercise1();
    }

    @Override
    public void doExercise1() {
        System.out.println("Boxer realization");
    }
}

class Swimmer  implements Sportable
{

    @Override
    public void doExercise() {
        System.out.println("Swimming");

    }
}

interface  ProfiSportable extends Sportable{
    void championGame();
}

abstract class One implements  Sportable{

}

class Two implements ProfiSportable{
    Two(){
        System.out.println(Sportable.r);
    }

    @Override
    public void doExercise() {

    }

    @Override
    public void championGame() {

    }
}