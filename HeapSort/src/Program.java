public class Program {
    public static void main(String[] args) {
        int[] arr = { 13, 9, -3, -4, -2, 6, 12, 33, 2, 0, -4, 5};

        heapSort(arr);

        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void heapSort(int[] array) {
        int n = array.length;

        // Построение кучи
        for(int i = n / 2 - 1; i >= 0; i--)
            heapify(array, i, n);

        // Корень меняется с последним элементом
        for(int i = n - 1; i >= 0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            heapify(array, 0, i);
        }
    }

    // Преобразование в кучу
    private static void heapify(int[] array, int i, int n) {
        int left = i * 2 + 1;   // левый дочерний от i элемента
        int right = i * 2 + 2;  // правый дочерний от i элемента
        int largest = i;        // наибольший элемент, как корень

        // если левый дочерний элемент меньше корня
        if(left < n && array[left] > array[largest])
            largest = left;

        // если правый дочерний элемент меньше корня
        if(right < n && array[right] > array[largest])
            largest = right;

        // если наибольший элемент не корень
        if(i != largest){
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            // рекурсивно преобразуем поддерево в двоичную кучу
            heapify(array, largest, n);
        }
    }
}
