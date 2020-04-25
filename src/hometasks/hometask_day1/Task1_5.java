package hometask_day1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task1_5 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in) ;
        System.out.println("Print array size:");

        int [] mas = IntStream.range(0,in.nextInt()).toArray();

        System.out.println(String.join("\n","Array:", Arrays.toString(mas)));

        int [] newMas = new int [mas.length];
        System.arraycopy(mas, 0, newMas, 2, mas.length-2);
        System.arraycopy(mas,mas.length-2,newMas, 0, 2);

        System.out.println(String.join("\n","New Array:", Arrays.toString(newMas)));



        /*System.out.print("Заданный массив:    ");
        for (int i=0; i<mas.length; i++) {
            mas [i] = (int) (Math.random()*10);
            System.out.print(mas[i]+ " ");
        }
        for (int i=mas.length-1; i>=0; i--) {
            if (i>=2) {
                mas[i] = mas[i - 2];
            } else {
                mas [i] = 0;
            }
        }
        System.out.print("\nИзменённый массив:  ");
        for (int i=0; i<mas.length; i++) {
            System.out.print(mas[i] + " ");
        }*/
    }
}
