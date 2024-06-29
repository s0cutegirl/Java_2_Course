import java.util.*;

public class Equation3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите уравнение:\t");
        String equation = input.nextLine();

        String[] array = equation.split("");

        int x;
        switch (array[1]){
            case "+":
                x = Integer.parseInt(array[4]) - Integer.parseInt(array[2]);
                System.out.printf("\nx = %d", x);
                break;
            case "-":
                x = Integer.parseInt(array[4]) + Integer.parseInt(array[2]);
                System.out.printf("\nx = %d", x);
                break;
            case "*":
                x = Integer.parseInt(array[4]) / Integer.parseInt(array[2]);
                System.out.printf("\nx = %d", x);
                break;
            case "/":
                x = Integer.parseInt(array[4]) * Integer.parseInt(array[2]);
                System.out.printf("\nx = %d", x);
                break;
            default:
                System.out.printf("Неизвестный оператор (%s)", array[1]);
        }
    }
}
