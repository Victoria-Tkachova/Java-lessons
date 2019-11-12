package CollectionExample;

import java.time.LocalDate;
import java.util.*;

class Transport {
        int price;
        int horses;
        List<LocalDate> list=new ArrayList<>();

        void comparePriceHorses() {
            System.out.println("За " + price + " $ США Вы получите " + horses + " лошадиных сил.");
        }

        double length;
        double weight;
        double high;

        Transport(Transport ob) {
            length = ob.length;
            weight = ob.weight;
            high = ob.high;
            for (LocalDate temp:ob.list ) {
                this.list.add(temp);
            }
        }

        Transport(double length, double w, double h) {
            this.length = length;
            weight = w;
            high = h;
            parameters();
            Iterator<Integer> qwe= new Iterator<Integer>() {
                @Override
                public boolean hasNext() {

                    return false;
                }

                @Override
                public Integer next() {
                    return null;
                }
            };
        }

        Transport() {
            System.out.println("Это конструктор по умолчанию");
        }

        void parameters() {
            System.out.println("Параментры транспорта: длинна - " + length + "; высота - " + high + "; вес - " + weight);
        }


    public static void main(String[] args) {
           Auto myAuto1 = new Auto(10, 20, 2.5, 4);
           Ship myShip1 = new Ship (35, 12, 2.7, 35); // конструкторы вызываются в порядке наследования; если метод super не вызывается, то используется конструктор по умолчанию
           Airplane myAirplane1 = new Airplane (57, 45, 5.6, 300);
           myAirplane1.parameters();
           Transport myTransport1 = new Transport();
           myTransport1 = myAuto1; // но у этого объекта нет доступа к полю doors, так как он не определён в суперклассе
           myTransport1.parameters();

           Car myCar1 = new Car (5, 2, 1.5, 5, "Beetle");
           Transport trans;
           trans = myAuto1;
           trans.parameters();
           trans = myShip1;
           trans.parameters();

        Set <String> newSet= new HashSet<>();
                Collections.addAll(newSet,"sw","qwqwq","sdsd","sw");
        System.out.println(newSet);
String str=new String("sw");
String qwe="sw";
String asd="sw";
newSet.add(str);
        System.out.println(newSet);
        }
    }




class Auto extends Transport {
    double doors;
    Auto (double l, double w, double h, double d) {
        super (l,w,h); // при вызове должен быть в первом операторе в конструкторе подкласса
        doors = d;
        System.out.println("Это параметры автомобиля: длинна - " + l + " высота - " + h + " вес - " + w + " количество дверей - " +d);
    }
    Auto () {
        System.out.println("Конструктор по молчанию для автотранспорта"); // от этого подкласса нельзя наследовать пока нет конструктора по умолчанию
    }
    void parameters() {
        System.out.println("Параментры автомобильного транспорта: длинна - " + length + "; высота - " + high + "; вес - " + weight);
    }
}

class Ship extends Transport {
    int speed;
    Ship (double l, double w, double h, int s) {
        length = l;
        weight = w;
        high = h;
        speed = s;
        System.out.println("Это параментры судна: длинна - " + l + " высота - " + h + " вес - " + w + " скорость - " + s);
    }
    void parameters() {
        System.out.println("Параментры водного транспорта: длинна - " + length + "; высота - " + high + "; вес - " + weight);
    }
}

class Airplane extends Transport {
    int passengers;
    Airplane (double l, double w, double h, int p) {
        length = l;
        weight = w;
        high = h;
        passengers = p;
        System.out.println("Это параментры самолёта: длинна - " + l + " высота - " + h + " вес - " + w + " количество пассажиров - " + p);
    }
    void parameters() {
        System.out.println("Параментры воздушного транспорта: длинна - " + length + "; высота - " + high + "; вес - " + weight);
    }
}

class Car extends Auto {
    String model;
    Car (double l, double w, double h, double d, String m) {
        super (l,w,h,d);
        model = m;
        System.out.println("Это параметры автомобиля: длинна - " + l + " высота - " + h + " вес - " + w + " количество дверей - " +d +
                "\nа для легкового автомобиля ещё и модель - " + m);
    }
}
