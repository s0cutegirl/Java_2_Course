import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {32, 43, 54, 45, 12, 13, 12};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++){
            int current = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > current){
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;
        }
    }
}
