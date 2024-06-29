package Massive;

public class Massive {
    public static void main(String[] args) {
        System.out.println("  Одномерный массив: ");
        int[] array1D = {1, 2, 3};
        for (int num : array1D){
            System.out.printf("%d ", num);
        }

        System.out.println("\n\n  Двухмерный массив: ");
        int[][] array2D = {{1, 2, 3}, {4, 5, 6}};
        for (int[] length : array2D){
            for (int num : length){
                System.out.printf("%d ", num);
            }
            System.out.println();
        }

        System.out.println("\n  Зубчатый массив: ");
        int[][] teethArray = {
            {1, 2},
            {3, 4, 5},
            {6, 7, 8, 9, 10}
        };
        for (int[] length : teethArray){
            for (int num : length){
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }
}
