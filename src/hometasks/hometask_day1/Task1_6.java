package hometask_day1;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Task1_6 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in) ;
        System.out.println("Print array size:");

        int size = in.nextInt();
        IntStream.range(0, size).boxed().filter(value -> value%2 == 0 && value > 10 && value < 21).collect(Collectors.toList())
                .forEach(x -> System.out.print(x + " "));



        /*Scanner in = new Scanner(System.in) ;
        Integer [] integerArray = new Integer [in.nextInt()];

        System.out.print("Заданный массив:    ");
        for (int i=0; i<integerArray.length; i++) {
            integerArray [i] = (int) (Math.random()*20);
            System.out.print(integerArray[i]+ " ");
        }

        List <Integer> integerList = Arrays.asList(integerArray);
        System.out.println("\nКоллекция:   " + integerList);

        integerList.sort(Comparator.naturalOrder());

        Stream <Integer> stream = integerList.stream();

                stream.filter(value -> value%2 == 0 & value > 10)
                .forEach(x -> System.out.print(x + " "));*/


    }
}
