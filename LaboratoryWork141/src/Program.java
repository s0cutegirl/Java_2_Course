import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Pattern pattern = Pattern.compile(
                "\\b(((\\d\\d?)|1\\d\\d|2([0-4]\\d|5[0-5]))\\.){3}(1\\d\\d|2([0-4]\\d|5[0-5])|(\\d\\d?))\\b");

        for(byte i = 0; i < 128; i++){
            System.out.print("Введите адрес IPv4: ");
            String ip = input.nextLine();

            Matcher matcher = pattern.matcher(ip);

            if(matcher.matches())
                System.out.println("Действителен");
            else
                System.out.println("Не действителен");
        }

//        \b((\d|[a-fA-F]){4}:){7}(\d|[a-fA-F]){4}\b
    }
}
