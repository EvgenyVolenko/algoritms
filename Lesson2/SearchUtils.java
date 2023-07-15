package ru.geekbrains.lesson2;

public class SearchUtils {

    public static int binarySearch(int value, int[] array){
        return binarySearch(value, array,  0 , array.length - 1);
    }

    public static int binarySearch(int value, int[] array, int min, int max){

        if (max < min)
            return -1;

        int middle = (max - min) / 2 + min;

        if (array[middle] == value){
            return middle;
        }
        else if (array[middle] < value){
            return binarySearch(value, array, middle + 1, max);
        }
        else {
            return binarySearch(value, array, min, middle - 1);
        }

    }


}
