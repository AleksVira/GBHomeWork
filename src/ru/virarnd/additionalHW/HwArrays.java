package ru.virarnd.additionalHW;

import java.util.Arrays;

public class HwArrays {
    public static void main(String[] args) {
        task01();
        task02();

        task11();
        task12();
        task13();
        task14();
        task15();

        task21();
        task22();



    }

    private static void task22() {
        int[][] arrLevel22 = new int[3][3];
        int moveCounter = 0;
        int turnCounter = 0;
        int i = 0;
        int j = -1;
        int directionI = 0;
        int directionJ = 1;
        while (true) {
            // Пробуем "походить" в следующую ячейку, в соответствии с направлением.
            int testI = (int) (i + Math.round(Math.sin(directionI * Math.PI / 2)));
            int testJ = (int) (j + Math.round(Math.sin(directionJ * Math.PI / 2)));
            if (testI < 3 && testI > -1 && testJ < 3 && testJ > -1 && arrLevel22[testI][testJ] == 0) {
                // Если удалось найти свободную ячейку, ставим туда число и обновляем текущие координаты.
                i = testI;
                j = testJ;
                moveCounter++;
                arrLevel22[i][j] = moveCounter;
                turnCounter = 0;
            } else {
                // Если не удалось сходить в выбранном направлении, меняем направление поворотом по часовой стрелке.
                // Счетчик поворотов увеличиваем.
                directionI++;
                directionJ++;
                turnCounter++;
            }
            // Если два поворота подряд, значит пришли в центр.
            if (turnCounter > 1) {
                break;
            }
        }

        System.out.println("task22");
        for (int k = 0; i < 3; k++) {
            System.out.println(Arrays.toString(arrLevel22[k]));
        }


    }

    private static void task01() {
        int[] arrLevel0 = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        System.out.println("task01\n" + Arrays.toString(arrLevel0));
    }

    private static void task02() {
        int[] arrLevel02 = new int[10];
        for (int i = 0; i < 10; i++) {
            arrLevel02[i] = 5;
        }
        System.out.println("task02\n" + Arrays.toString(arrLevel02));
    }

    private static void task11() {
        int[][] arrLevel11 = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arrLevel11[i][j] = 1;
            }
        }
        System.out.println("task11\n" + Arrays.deepToString(arrLevel11));
    }

    private static void task12() {
        int[] arrLevel12 = {1, 3, 2, 1, 3, 1, 1};
        int sum = 0;
        for (int item : arrLevel12) {
            sum += item;
        }
        System.out.println("task12: " + sum);
    }

    private static void task13() {
        System.out.println("task13");
        int[] arrLevel13 = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < arrLevel13.length; i++) {
            if (arrLevel13[i] > 3) {
                System.out.println(arrLevel13[i]);
            }
        }
    }

    private static void task14() {
        System.out.println("task14");
        int[] arrLevel14 = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < arrLevel14.length; i++) {
            if (i % 2 != 0) {
                System.out.println(arrLevel14[i]);
            }
        }
    }

    private static void task15() {
        int[] arrLevel15 = {1, 2, 3, 4, 3, 2, 3, 4, 2, 1};
        int counter = 0;
        for (int i = 0; i < arrLevel15.length; i++) {
            if (arrLevel15[i] == 3) {
                counter++;
            }
        }
        System.out.println("task15: " + counter);
    }

    private static void task21() {
        int[][] arrLevel21 = new int[5][5];
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arrLevel21[i][j] = (counter % 2 == 0) ? 1 : 2;
                counter++;
            }
        }
        System.out.println("task21");
        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(arrLevel21[i]));
        }
    }


}
