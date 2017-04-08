package ru.virarnd.hw03;

import java.util.Scanner;

public class GuessWord {
    public static void main(String[] args) {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
                "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String pcWord = words[(int) (Math.random() * words.length)];
        Scanner sc = new Scanner(System.in);
        int humanMove = 0;

        System.out.println("Компьютер загадал слово, попробуйте его угадать.");
        System.out.println("После каждой ошибки будет открываться одна буква слова. Если слово открыто полностью, Вы проиграли.\n");

        do {
            System.out.print("Введите слово >> ");
            String humanWord = sc.next();
            humanMove++;
            if (humanWord.equals(pcWord)) {
                System.out.println("Вы угадали слово, ура!");
                break;
            } else {
                if (humanMove == pcWord.length()) {
                    System.out.printf("Было загадано слово: " + pcWord + ". Вы прогирали... ;(");
                    break;
                }
                System.out.print("Вы пока не угадали слово, вот подсказка: ");
                printWord(pcWord, humanMove);
            }
        } while (true);

    }

    private static void printWord(String pcWord, int charCounter) {
        StringBuilder sb = new StringBuilder(pcWord.substring(0, charCounter));
        for (int i = 0; i < 15 - charCounter; i++) {
            sb = sb.append('#');
        }
        System.out.println(sb);

    }
}
