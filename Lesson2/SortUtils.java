
/**
 * Утилиты для сортировки массива
 */
public class SortUtils {


    /**
     * Сортировка выбором
     *
     *  0 1 2 3 4
     *  =========
     *  5 4 1 0 1
     *
     *
     *
     * @param array массив
     */
    public static void directSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            int saveIndex = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[saveIndex]){
                    saveIndex = j;
                }
            }
            if (i != saveIndex){
                int buf = array[i];
                array[i] = array[saveIndex];
                array[saveIndex] = buf;
            }
        }
    }

    public static void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int start, int end){
        int left = start;
        int right = end;
        int middle = array[(start + end) / 2];

        do{
            while (array[left] < middle){
                left++;
            }

            while (array[right] > middle){
                right--;
            }

            if (left <= right){
                if (left < right){
                    int buf = array[left];
                    array[left] = array[right];
                    array[right] = buf;
                }
                left++;
                right--;
            }
        }
        while (left <= right);

        if (left < end){
            quickSort(array, left, end);
        }

        if (start < right){
            quickSort(array, start, right);
        }
    }

    public static void heapSort(int[] array) {
        // Построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        // Один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // Вызывем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int heapSize, int rootIndex) {
        
        int largest = rootIndex; // Инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // левый = 2 * rootINdex + 1 
        int rightChild = 2 * rootIndex + 2; // правый = 2 * rootINdex + 2
        
        // Если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
        // Если самый большой элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }
}
