import java.util.*;
import java.util.regex.*;

public class Equation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите уравнение типа x+n1=n2:\t");
        String equation = input.nextLine();
        equation = equation.replace(" ", ""); // Удаление всех пробелов в уравнении

        Pattern equationPattern = Pattern.compile("^\\w(-|\\+)\\d+=-?\\d+$"); // Шаблон уравнения
        Matcher matcher = equationPattern.matcher(equation);

        if(matcher.matches()){
            Pattern numberPattern = Pattern.compile("-?\\d+"); // Шаблон для чисел
            Matcher numberMatcher = numberPattern.matcher(equation);

            int x = 0;
            // Поиск двух чисел
            for(int count = 0; numberMatcher.find() && count < 2; count++){
                String numberStr = numberMatcher.group(); // Формируем найденное число в группу
                int number = Integer.parseInt(numberStr); // Преобразуем полученную строку в число

                if(count == 0) // Условие для первого числа
                    x -= number;
                else if(count == 1) // Условие для второго числа
                    x += number;
            }

            System.out.printf("x = %d", x);
        }
        else{
            System.out.println("Неправильная запись уравнения (x+n1=n2)");
        }
    }
}
