package Example_Interface;

import java.util.Arrays;

public class Tutorial1 {
    public static void main(String[] args) {
        Sportable var=new Sportable() {
        @Override
        public void doExercise() {
            System.out.println("anonimus");
        }
    };
        Sportable[] sportMen = {new Boxer("qwer"),new Swimmer(),new Two(),var};
       // System.out.println( ((Boxer) sportMen[1]).name); !!!! Attention
        Tutorial1  tut=new Tutorial1();

        tut.commonExercise(sportMen);
        int [] arrayOne = {1,1,1,1,1,1};
        tut.changeArray(arrayOne, new OneAlgor());
        System.out.println(Arrays.toString(arrayOne));

    }
void commonExercise (Sportable[] grup){
        for (int i=0; i < grup.length; i++) {
            grup[i].doExercise();
        }
}

 void changeArray(int[] array, Algoritmic algoritmic){
        for (int i=0; i < array.length; i++) {
            array[i] = algoritmic.function(array[i]);
        }
 }
}


interface Algoritmic{
    int function(int element);
}

class OneAlgor implements  Algoritmic{

    @Override
    public int function(int element) {
        return 5*element*element+23;
    }
}