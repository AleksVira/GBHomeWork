package ru.virarnd.hw08;

import java.util.Random;
import java.util.Scanner;

class Player {
    /** Имя игрока. */
    private String name;
    /** Тип его фишек. */
    private char dotType;
    /** Тип фишек соперника. */
    private char opponentDotType;

    /** Человек или нет. */
    private boolean human;
    /** Ссылка на игровое поле. */
    private PlayingField playingField;

    Player(String name, boolean isHuman, char dotType, PlayingField playingField) {
        this.name = name;
        this.human = isHuman;
        this.dotType = dotType;
        this.playingField = playingField;
        this.opponentDotType = (dotType == PlayingField.X_DOT) ? PlayingField.O_DOT : PlayingField.X_DOT;
    }

    char getDotType() {
        return dotType;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    void setHuman(boolean human) {
        this.human = human;
    }

    boolean isHuman() {
        return human;
    }


    // Компьютер пытается выиграть последним ходом, блокирует другого игрока или ходит случайно.
    Cell nextAiTurn() {
        Cell testCell;
        Cell blockCell = null;
        for (int i = 0; i < playingField.getNumberOfCells(); i++) {
            for (int j = 0; j < playingField.getNumberOfCells(); j++) {
                testCell = new Cell(j, i);
                if (playingField.isEmpty(testCell)) {
                    //Есть где атаковать?
                    playingField.setDot(testCell, dotType);
                    if (playingField.checkWin(dotType)) {
                        return testCell;
                    } else {
                        // А есть что блокировать?
                        playingField.setDot(testCell, opponentDotType);
                        if (playingField.checkWin(opponentDotType)) {
                            blockCell = testCell;
                        }
                    }
                    playingField.setDot(testCell, PlayingField.EMPTY_DOT);
                }
            }
        }

        // Были ли найдены точки для блокирования?
        if (blockCell != null) {
            return blockCell;
        }

        //Если блокировать и атаковать некуда, выбирает точку случайно.
        Random rnd = new Random();
        do {
            int x = rnd.nextInt(playingField.getNumberOfCells());
            int y = rnd.nextInt(playingField.getNumberOfCells());
            testCell = new Cell(y, x);
        } while (!playingField.isEmpty(testCell));
        return testCell;
    }

}
