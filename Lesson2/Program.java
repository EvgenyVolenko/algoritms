package ru.geekbrains.lesson2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        int[] array = ArrayUtils.prepareArray();
        ArrayUtils.printArray(array);
        SortUtils.directSort(array);
        ArrayUtils.printArray(array);

        array = ArrayUtils.prepareArray();
        ArrayUtils.printArray(array);
        SortUtils.quickSort(array);
        ArrayUtils.printArray(array);

        array = new int[]{5, 1, 2, 4};
        SortUtils.quickSort(array);
        ArrayUtils.printArray(array);

        int[] array2 = ArrayUtils.prepareArray(100000);

        long startTime = System.currentTimeMillis();
        SortUtils.directSort(array2.clone());
        long endTime = System.currentTimeMillis();
        System.out.printf("Время выполнения сортировки выбором: %d мс.\n", endTime - startTime);


        startTime = System.currentTimeMillis();
        SortUtils.quickSort(array2.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время выполнения быстрой сортировки: %d мс.\n", endTime - startTime);


        startTime = System.currentTimeMillis();
        Arrays.sort(array2.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время выполнения системной сортировки: %d мс.\n", endTime - startTime);


        int[] array3 = new int[] { - 5, 100, 4, -6, 12, 44, 6, 0, -9, 88};
        ArrayUtils.printArray(array3);
        SortUtils.quickSort(array3);
        ArrayUtils.printArray(array3);
        int searchElement = 12;
        //int res = SearchUtils.binarySearch(searchElement, array3);
        int res = Arrays.binarySearch(array3, searchElement);
        System.out.printf("Элемент %d %s\n", searchElement,
                res >= 0 ? String.format("найден в массиве по индексу %d", res) : "не найден");



    }

}
