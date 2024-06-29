import java.util.*;

public class Equation2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите уравнение x + n1 =n2:\t");
        String equation = input.nextLine();

        String[] array = equation.split(" "); // Разделителем элементов является пробел

        int x = 0;

        for(int i = 0; i < array.length; i++){
            if(i == 2){
                x -= Integer.parseInt(array[i]);
            }
            if(i == 4){
                x += Integer.parseInt(array[i]);
            }
        }
        System.out.printf("x = %d", x);
    }
}