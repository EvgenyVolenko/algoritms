import java.lang.reflect.Array;
import java.util.Arrays;
import Lesson2.SortUtils;
import Lesson2.ArrayUtils;

public class Program {

    public static void main(String[] args) {
        
        int[] array = ArrayUtils.prepareArray(100_000_000);

        long startTime = System.currentTimeMillis();
        // SortUtils.directSort(array.clone());
        long endTime = System.currentTimeMillis();
        // System.out.printf("Время выполнения сортировки выбором: %d мс.\n", endTime - startTime);


        startTime = System.currentTimeMillis();
        SortUtils.quickSort(array.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время выполнения быстрой сортировки: %d мс.\n", endTime - startTime);


        startTime = System.currentTimeMillis();
        Arrays.sort(array.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время выполнения системной сортировки: %d мс.\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        SortUtils.heapSort(array.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время выполнения сортировки кучей: %d мс.\n", endTime - startTime);

        // int[] array3 = new int[] { - 5, 100, 4, -6, 12, 44, 6, 0, -9, 88};
        // ArrayUtils.printArray(array3);
        // SortUtils.quickSort(array3);
        // ArrayUtils.printArray(array3);
        // int searchElement = 12;
        // int res = SearchUtils.binarySearch(searchElement, array3);
        // // int res = Arrays.binarySearch(array3, searchElement);
        // System.out.printf("Элемент %d %s\n", searchElement,
        //         res >= 0 ? String.format("найден в массиве по индексу %d", res) : "не найден");
    }
}
