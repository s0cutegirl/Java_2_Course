package Example1;

import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        System.out.print("Введите границу: ");
        Scanner input = new Scanner(System.in);
        double length = input.nextDouble();
        double result = 0;

        for (double i = 0; i <= length; i++){
            result += Math.pow(-1, i) / (2 * i + 1);
        }

        System.out.println(result);
    }
}
