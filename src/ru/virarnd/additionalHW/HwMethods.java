package ru.virarnd.additionalHW;

import java.util.Arrays;

public class HwMethods {
    public static void main(String[] args) {
        task01("Вася");
        task02("Строка1", "Строка2");
        task03(11, 67);
        System.out.println(task04(6));

        System.out.println(task11(new int[]{1, 2, 3, 4, 5, 6, 8}));
        task12("Строка ", 3);

        int[] arr21 = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(task21(arr21));

        int[] arr22 = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println("Исходный массив: " + Arrays.toString(arr22));
        System.out.println("Получилось: " + Arrays.toString(task22(arr22)));

        int[][][] arr23 = new int[][][]{{{0, 1, 2}, {2, 3, 4}, {4, 5, 6}}, {{0, 1, 2}, {2, 3, 4}, {4, 5, 6}}};
        System.out.println("Количество элементов в трехмерном массиве: " + task23(arr23));

        String[] arr01 = {"a", "b", "c"};
        String[] arr02 = {"d", "e", "f"};
        String[] arr03 = {"g", "h", "i"};
        System.out.println("Новый массив из трёх одномерных: " + Arrays.toString(task24(arr01, arr02, arr03)));

    }

    private static void task01(String name) {
        System.out.println("Привет, " + name);
    }

    private static void task02(String s1, String s2) {
        System.out.println(s1 + " " + s2);
    }

    private static void task03(int i, int k) {
        System.out.println("Сумма = " + (i + k));

    }

    private static boolean task04(int i) {
        return (i > 5);
    }

    private static int task11(int[] arr) {
        int counter = 0;
        for (int item : arr) {
            if (item % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }

    private static void task12(String sss, int quantity) {
        for (int i = 0; i < quantity; i++) {
            System.out.println(sss);
        }
    }

    private static boolean task21(int[] testArr) {
        int sum = 0;
        for (int item : testArr) {
            sum += item;
        }
        return (sum >= 20 && sum <= 30);
    }

    private static int[] task22(int[] testArr) {
        int[] newArr = new int[testArr.length];
        for (int i = 0; i < testArr.length; i++) {
            newArr[i] = 2 * testArr[i];
        }
        return newArr;
    }

    private static int task23(int[][][] testArr) {
        int counter = 0;
        for (int[][] a : testArr) {
            for (int[] b : a) {
                for (int number : b) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static String[] task24(String[] nArr1, String[] nArr2, String[] nArr3) {
        String[] newArray = new String[nArr1.length + nArr2.length + nArr3.length];
        int pointer = 0;
        for (String a1 : nArr1) {
            newArray[pointer] = a1;
            pointer++;
        }
        for (String a2 : nArr2) {
            newArray[pointer] = a2;
            pointer++;
        }
        for (String a3 : nArr3) {
            newArray[pointer] = a3;
            pointer++;
        }
        return newArray;
    }


}
