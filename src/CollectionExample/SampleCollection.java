package CollectionExample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.function.Consumer;

public class SampleCollection {

    public static void main(String[] args) {
        ArrayList <Integer> List = new ArrayList<>();
            List.add(7);
            List.add(3);
            List.add(4);
            List.add(5);
            List.add(9);
       // System.out.println(List);
        Iterator<Integer> it1=List.iterator();
        int i=0;
        while(it1.hasNext()){
            System.out.print(it1.next()+" , ");
        if (i % 2==0){
            it1.remove();
        }
            i++;
        }
        System.out.println(List);

List.forEach(new Consumer<Integer>() {
    @Override
    public void accept(Integer olo) {
        System.out.println(olo+10);
    }
});

    }

    }

