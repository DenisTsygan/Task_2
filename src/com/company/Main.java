
package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Task_44();
        //Task_69();
        //Task_94();
        Task_119();
        //Task_144();
    }

    /
     * Дан целочисленный массив с количеством элементов n. Напечатать те его элементы,
     * индексы которых являются степенями двойки (1, 2, 4, 8, 16, ...).
     */
    private static void Task_44() {
        Random random = new Random();
        final int N = random.nextInt(100) + 1;
        System.out.println("Количество елементов " + N + "\n");
        int[] array = new int[N];
        int power_dva = 1;
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(1000);
            if (i == power_dva) {
                System.out.printf(array[i] + ",");
                power_dva = power_dva * 2;
            }
        }
    }

    /
     * Найти произведение элементов массива вещественных чисел, меньших заданного числа.
     */
    private static void Task_69() {
        Random random = new Random();
        final int SIZE = 50;
        double result = 1;
        double[] array = new double[SIZE];
        final double NUMBER = 5;
        for (int i = 0; i < SIZE; i++) {
            array[i] = (random.nextDouble() * (10 - (-10)) + (-10));
            if (array[i] != 0 && array[i] < NUMBER) {
                result *= array[i];
            }
        }
        System.out.println("\nПроизведение элементов массива меньшех " + NUMBER + " равно=" + result);
    }

    /
     * Удалить элемент массива целых чисел, равный квадрату 5-го элемента.
     * Если таких элементов нет, выдать сообщение «элементы для удаления не найдены».
     */
    private static void Task_94() {
        Random random = new Random();
        final int SIZE = 100;
        int[] array = new int[SIZE];
        byte needtoprint = 0;
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(100) + 1;
        }
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < SIZE; i++) {
            if (array[i] == array[4] * array[4]) {
                int currentLength = array.length;
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                currentLength--;
                array = Arrays.copyOf(array, currentLength);
                needtoprint++;
                break;
            }
        }
        if (needtoprint == 1) {
            System.out.println("Массив после");
            System.out.println(Arrays.toString(array));
        } else {
            System.out.println("Элементы для удаления не найдены");
        }
    }

    /
     * Из заданного массива создать три массива,
     * в одном из которых содержатся элементы кратные 2,
     * в другом кратные 5, в третьем оставшиеся элементы.
     */
    private static void Task_119() {
        Random random = new Random();
        final int SIZE1 = 10;//данный массив
        int size2 = 0;//массив где элементы кратные 2
        int size3 = 0;//массив где кратные 5
        int size4 = 0;// массив где оставшиеся елементы
        int povtor = 0;
        int[] array1 = new int[SIZE1];
        for (int i = 0; i < SIZE1; i++) {
            array1[i] = random.nextInt(10) + 1;
            if (array1[i] % 2 == 0 && array1[i] % 5 == 0) {
                size2++;
                size3++;
                povtor++;
                continue;
            }
            if (array1[i] % 2 == 0) {
                size2++;
            }
            if (array1[i] % 5 == 0) {
                size3++;
            }
        }
        System.out.println("Данный массив");
        System.out.println(Arrays.toString(array1));
        size4 = (SIZE1 - (size2 + size3)) + povtor;
        int[] array2 = new int[size2];
        int[] array3 = new int[size3];
        int[] array4 = new int[size4];
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;
        for (int i = 0; i < SIZE1; i++) {
            if (array1[i] % 2 == 0) {
                array2[index2] = array1[i];
                index2++;
            }
            if (array1[i] % 5 == 0) {
                array3[index3] = array1[i];
                index3++;
            }
            if (array1[i] % 2 != 0 && array1[i] % 5 != 0) {
                array4[index4] = array1[i];
                index4++;
            }
        }
        System.out.println("Массив где элементы кратные 2:");
        System.out.println(Arrays.toString(array2));
        System.out.println("Массив где элементы кратные 5:");
        System.out.println(Arrays.toString(array3));
        System.out.println("Массив где оставшиеся елементы:");
        System.out.println(Arrays.toString(array4));
    }


    /**
     * Дана последовательность n различных целых чисел.
     * Найти сумму ее членов, расположенных между максимальным и
     * минимальным значениями (в сумму включить и оба этих числа).
     */
    private static void Task_144() {
        Random random = new Random();
        final int SIZE = 10;
        int[] array = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(100) + 1;
        }
        System.out.println("Массив:");
        System.out.println(Arrays.toString(array));
        int min = array[0];
        int max = array[0];
        int indexMin = 0;
        int indexMax = 0;
        for (int i = 0; i < SIZE; i++) {
            if (array[i] < min) {
                min = array[i];
                indexMin = i;
            }
            else {
                if (array[i] > max) {
                    max = array[i];
                    indexMax = i;
                }
            }
        }
        System.out.println("Min=" + min + "(" + (indexMin + 1) + ")");
        System.out.println("Max=" + max + "(" + (indexMax + 1) + ")");
        boolean min_max = true;
        int sum = 0;
        if (indexMin > indexMax) min_max = false;
        if (min_max) {
            for (int i = indexMin; i <= indexMax; i++) {
                sum += array[i];
            }
        } else {
            for (int i = indexMax; i <= indexMin; i++) {
                sum += array[i];
            }
        }
        System.out.println("Сумма=" + sum);
    }

}
