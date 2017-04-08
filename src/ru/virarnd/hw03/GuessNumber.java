package ru.virarnd.hw03;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        final int max = 9;
        final int maxAttempt = 3;

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        boolean repeat = true;
        int humanNumber;

        while (repeat) {
            int tryCounter = maxAttempt;
            int numberPC = rnd.nextInt(10);
            System.out.println("Загадано число от 0 до " + max + ". Вам нужно угадать его максимум за " + maxAttempt + " попытки.");
            do {
                System.out.print("Осталось попыток: " + tryCounter + ". Введите число >> ");
                humanNumber = sc.nextInt();
                if (humanNumber < 0 || humanNumber > max) {
                    System.out.println("Вы ввели число вне диапазона, повторите ввод.");
                    continue;
                } else if (humanNumber == numberPC) {
                    System.out.println("Вы угадали число!");
                    break;
                } else if (humanNumber < numberPC) {
                    System.out.println("Ваше число меньше загаданного.");
                } else {
                    System.out.println("Ваше число больше загаданного.");
                }
                tryCounter--;
                if (tryCounter == 0) {
                    System.out.println("Вы использовали все попытки и не угадали число.");
                    break;
                }
            } while (true);

            System.out.print("Повторить игру еще раз? (1 – повторить, 0 – нет) >> ");
            int repeatAnswer = sc.nextInt();
            repeat = (repeatAnswer == 1);
        }
    }
}
