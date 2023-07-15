package ru.geekbrains.lesson1;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Program {

    public static void main(String[] args) {

        //int a = 3 % 2;
        //int b = 5 % 7;

        int lastNumber = 20;
        AtomicInteger counter = new AtomicInteger();
        System.out.printf("Сумма всех чисел до %d равна %d\n", lastNumber, sum(lastNumber, counter ));
        System.out.println("Кол-во итераций: " + counter);
        System.out.printf("Сумма всех чисел до %d равна %d\n", lastNumber, sum2(lastNumber));

        counter.set(0);

        System.out.println("Простые числа: " + findSimpleNumbers(lastNumber, counter));
        System.out.println("Кол-во итераций: " + counter);

        f(4);
        counter.set(0);
        long startTime = System.currentTimeMillis();
        int num = 5;
        System.out.printf("Число Фибоначчи для последовательности %d чисел: %d (рекурсия)\n",
                num, fb1(num, counter));
        long endTime = System.currentTimeMillis();
        System.out.println("Кол-во итераций: " + counter);
        System.out.println("Операция выполнена за " + (endTime - startTime) + "мс.");


        counter.set(0);
        startTime = System.currentTimeMillis();
        System.out.printf("Число Фибоначчи для последовательности %d чисел: %d\n",
                num, fb2(num, counter));
        endTime = System.currentTimeMillis();
        System.out.println("Кол-во итераций: " + counter);
        System.out.println("Операция выполнена за " + (endTime - startTime) + "мс.");

        /*int a = 0;
        while (true) {
            a++;
            if (a == 100)
                break;
        }

        System.out.println("Hello!");*/

    }

    /**
     * [1] Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N.
     * @param lastNumber
     * @return
     */
    public static int sum(int lastNumber, AtomicInteger counter){
        int sum = 0;
        for (int i = 1; i <= lastNumber; i++){
            counter.getAndIncrement(); // + 1
            sum += i;
        }
        return sum;
    }

    public static int sum2(int lastNumber){
        return ((1 + lastNumber) * lastNumber)/ 2;
    }

    public static ArrayList<Integer> findSimpleNumbers(int lastNumber, AtomicInteger counter){
        ArrayList<Integer> result  = new ArrayList<>();
        boolean simple;
        for (int i = 1; i <= lastNumber; i++){
            simple = true;
            for (int j = 2; j < i; j++){
                counter.getAndIncrement();
                if (i % j == 0){
                    simple = false;
                    break;
                }
            }

            if (simple){
                result.add(i);
            }

        }
        return result;
    }

    /**
     * n = 4
     * @param n
     */
    static void f(int n){
        System.out.println(n);
        if (n >= 3){
            f(n - 1);
            f(n - 2);
            f(n - 2);
        }
    }

    /**
     * 0 1 2 3 4 5 6  7  8  9 10
     * 0 1 1 2 3 5 8 13 21 34 55 ....
     * @return
     */
    static long fb1(int num, AtomicInteger counter) {
        counter.getAndIncrement();
        if (num == 0 || num == 1)
            return num;
        return fb1(num - 1, counter) + fb1(num - 2, counter);

    }

    static long fb2(int num, AtomicInteger counter){
        if (num == 0 || num == 1)
            return num;
        long[] array = new long[num + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++ ){
            counter.getAndIncrement();
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[num];
    }







}
