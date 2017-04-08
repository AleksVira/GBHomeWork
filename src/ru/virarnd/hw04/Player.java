package ru.virarnd.hw04;

import java.util.Random;
import java.util.Scanner;

public class Player {
    /** Имя игрока. */
    private String name;
    /** Тип его фишек. */
    private char dotType;
    /** Тип фишек оперника. */
    private char opponentDotType;
    /** Человек или нет. */
    private boolean human;
    /** Ссылка на игровое поле. */
    private GameField gameField;

    public Player(String name, boolean isHuman, char dotType, GameField gameField) {
        this.name = name;
        this.human = isHuman;
        this.dotType = dotType;
        this.gameField = gameField;
        this.opponentDotType = (dotType == GameField.X_DOT) ? GameField.O_DOT : GameField.X_DOT;
    }

    public char getDotType() {
        return dotType;
    }

    public String getName() {
        return name;
    }


    // Если человек -- запрашиваем в консоли куда ходить.
    public Cell askMove() {
        Scanner sc = new Scanner(System.in);
        int answerX;
        int answerY;
        System.out.print("Введите через пробел координаты X и Y точки: ");

        do {
            answerY = sc.nextInt() - 1;
            answerX = sc.nextInt() - 1;
            Cell testCell = new Cell(answerX, answerY);
            System.out.println("X = " + answerX + ", Y = " + answerY);
            if (!gameField.checkRangeIsGood(testCell)) {
                System.out.print("Вы ввели неправильные координаты! Повторите ввод: ");
            } else if (!gameField.isEmpty(testCell)) {
                System.out.print("Эта ячейка занята! Повторите ввод: ");
            } else {
                return new Cell(answerX, answerY);
            }
        } while (true);
    }

    // Если компьютер -- пытается выиграть последним ходом, блокирует другого игрока или ходит случайно.
    public Cell nextAiTurn() {
        Cell testCell;

        //Есть где атаковать?
        for (int i = 0; i < gameField.getSize(); i++) {
            for (int j = 0; j < gameField.getSize(); j++) {
                testCell = new Cell(j, i);
                if (gameField.isEmpty(testCell)) {
                    gameField.setDot(testCell, dotType);
                    boolean result = gameField.checkWin(dotType);
                    gameField.setDot(testCell, GameField.EMPTY_DOT);
                    if (result) {
                        return testCell;
                    }
                }
            }
        }

        //Есть что блокировать?
        for (int i = 0; i < gameField.getSize(); i++) {
            for (int j = 0; j < gameField.getSize(); j++) {
                testCell = new Cell(j, i);
                if (gameField.isEmpty(testCell)) {
                    gameField.setDot(testCell, opponentDotType);
                    boolean result = gameField.checkWin(opponentDotType);
                    gameField.setDot(testCell, GameField.EMPTY_DOT);
                    if (result) {
                        return testCell;
                    }
                }
            }
        }

        //Если блокировать нечего, выбирает точку случайно.
        Random rnd = new Random();
        do {
            int x = rnd.nextInt(gameField.getSize());
            int y = rnd.nextInt(gameField.getSize());
            testCell = new Cell(y, x);
        } while (!gameField.isEmpty(testCell));
//        System.out.println("X = " + testCell.x + ", Y = " + testCell.y);
        return testCell;
    }

    //Выбор, как получить следующую точку: запросить с консоли или сгенерировать компьютеру.
    public Cell nextTurn() {
        Cell newCell;
        if (this.human) {
            newCell = askMove();
        } else {
            newCell = nextAiTurn();
        }
        return newCell;
    }
}
