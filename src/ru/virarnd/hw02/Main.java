package ru.virarnd.hw02;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] testArray01 = {0, 1, 1, 0, 1, 0};
        task01(testArray01);
        System.out.println(Arrays.toString(testArray01) + "\n");

        int[] testArray02 = new int[8];
        task02(testArray02);
        System.out.println(Arrays.toString(testArray02) + "\n");

        int[] testArray03 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        task03(testArray03);
        System.out.println(Arrays.toString(testArray03) + "\n");

        int size = (int) ((Math.random() * 9) + 1);
        int[][] testArray04 = new int[size][size];
        task04(testArray04);
        for (int[] partOfArray : testArray04) {
            System.out.println(Arrays.toString(partOfArray));
        }

        int[] testArray05 = createArray(20);
        System.out.println("\n" + Arrays.toString(testArray05));
        int[] answer = task05(testArray05);
        System.out.println("Минимум: " + answer[0] + ", максимум: " + answer[1] + "\n");

        int[] testArray06 = new int[]{1, 1, 1, 2, 1};
        System.out.println(checkBalance(testArray06));
        testArray06 = new int[]{2, 1, 1, 2, 1};
        System.out.println(checkBalance(testArray06));
        testArray06 = new int[]{10, 10};
        System.out.println(checkBalance(testArray06) + "\n");

        int[] testArray07 = createArray(7);
        System.out.println(Arrays.toString(testArray07));
        int shift = createShift(25);
        System.out.println("Сдвиг: " + shift + " (" + (shift % testArray07.length) + ")");
        makeShift(testArray07, shift);
        System.out.println(Arrays.toString(testArray07));
    }

    private static void task01(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }
        }
    }

    private static void task02(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }
    }

    private static void task03(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    private static void task04(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
        }
    }

    private static int[] createArray(int size) {
        int[] newArray = new int[size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = (int) ((Math.random() * 100));
        }
        return newArray;
    }

    private static int[] task05(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int anArray : array) {
            if (anArray < min) {
                min = anArray;
            }
            if (anArray > max) {
                max = anArray;
            }
        }
        return new int[]{min, max};
    }

    private static boolean checkBalance(int[] array) {
        for (int i = 1; i <= array.length - 1; i++) {
            int sumLeft = partialArraySum(array, 0, i - 1);
            int sumRight = partialArraySum(array, i, array.length - 1);
            if (sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }

    private static int partialArraySum(int[] array, int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            sum += array[i];
        }
        return sum;
    }

    private static int createShift(int i) {
        int newShift = (int) (Math.random() * i + 1);
        double sign = Math.random();
        if (sign < 0.5) {
            newShift *= -1;
        }
        return newShift;
    }

    private static void makeShift(int[] array, int shift) {
        int realShift = shift % array.length;
        if (realShift < 0) {
            realShift += array.length;
        }
        int tmp = array[0];
        int point = 0;
        int nextPoint;
        for (int i = 0; i < array.length; i++) {
            nextPoint = point - realShift;
            if (nextPoint < 0) {
                nextPoint += array.length;
            }
            if (nextPoint == 0) {
                array[point] = tmp;
            } else {
                array[point] = array[nextPoint];
                point = nextPoint;
            }
        }
    }
}
