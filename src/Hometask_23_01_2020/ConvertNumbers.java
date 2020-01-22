package Hometask_23_01_2020;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertNumbers {

    Stream<Integer> convertNumbers (Stream<Integer> stream) {
        return stream.flatMap(num -> Stream.of(num, num*2, num*3, num*4, num*5));
    }

    public static void main(String[] args) {
        ConvertNumbers obj = new ConvertNumbers();
        Stream<Integer> stream = Stream.of(2,3,4,5);
        Stream<Integer> result = obj.convertNumbers(stream);
        result.forEach(System.out::println);
    }
}
