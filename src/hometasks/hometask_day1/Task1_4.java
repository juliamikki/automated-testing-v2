package hometask_day1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task1_4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in) ;
        System.out.println("Print array size:");

        int size = in.nextInt();

        int [] mas = IntStream.range(0,size).toArray();

        System.out.println(String.join("\n", "Array:", Arrays.toString(mas)));


        for (int i=0; i<mas.length-1; i+=2) {
            int a = mas[i];
            mas[i] = mas[i + 1];
            mas[i + 1] = a;
        }

        System.out.println(String.join("\n", "Converted Array:", Arrays.toString(mas)));



          /*Scanner in = new Scanner(System.in) ;
        System.out.println("Введите размер массива:");

        int [] mas = new int [in.nextInt()];

        System.out.print("Заданный массив:    ");
        for (int i=0; i<mas.length; i++) {
            mas [i] = (int) (Math.random()*10);
            System.out.print(mas[i]+ " ");
        }

        System.out.print("\nИзменённый массив:  ");
        for (int i=0; i<mas.length-1; i+=2) {
            int a = mas[i];
            mas [i] = mas [i+1];
            mas [i+1] = a;
            System.out.print(mas[i] + " " + mas [i+1] + " ");
        }
        if (mas.length%2!=0) {
            System.out.print(mas[mas.length-1]);
        }*/
    }
}
