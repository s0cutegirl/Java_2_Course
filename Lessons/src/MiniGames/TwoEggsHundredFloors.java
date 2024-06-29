package MiniGames;

import java.util.*;

public class TwoEggsHundredFloors {
    public static void main(String[] args) {
        int eggs = 2;
        int eggBroke = new Random().nextInt(100);

        for (int i = 0; eggs > 0; i++) {
            System.out.print("Введите этаж, с которого бросить яйцо: ");
            int input = new Scanner(System.in).nextInt();

            if (input < eggBroke) {
                System.out.println("    Яйцо не разбилось");
            }
            else if (input == eggBroke){
                eggs = 0;
                System.out.println("    Яйцо разбилось! Вы угадали этаж с " + (i + 1) + " раз(-а)!");
            }
            else if (input > eggBroke && eggs > 0) {
                eggs--;
                System.out.println("    Яйцо разбилось! У вас осталось: " + eggs + " шт.");
            }
            else if(input > eggBroke){
                eggs--;
                System.out.println("    Яйцо разбилось! Вы не угадали этаж. Попыток: " + i);
            }


        }
    }
}
