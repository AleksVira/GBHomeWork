package ru.virarnd.hw04;

import java.util.Arrays;

public class GameField {
    static final char EMPTY_DOT = '*';
    static final char X_DOT = 'X';
    static final char O_DOT = 'O';
    private int size;
    private int dotsToWin;
    private char[][] gameMap;

    public GameField(int size, int dotsToWin) {
        this.size = size;
        this.gameMap = new char[size][size];
        this.dotsToWin = dotsToWin;
        for (char[] row : gameMap) {
            Arrays.fill(row, EMPTY_DOT);
        }
    }

    public int getSize() {
        return size;
    }

    public void setDot(Cell cell, char dot) {
        gameMap[cell.x][cell.y] = dot;
    }

    public void printMap() {
        for (int i = 0; i < size + 1; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < size; j++) {
                System.out.printf("%2c ", gameMap[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    //Проверка, пустая ли ячейка?
    public boolean isEmpty(Cell checkedCell) {
        return gameMap[checkedCell.x][checkedCell.y] == EMPTY_DOT;
    }

    //Проверка что координаты точки не выходят за границы поля. На входе: ячейка
    public boolean checkRangeIsGood(Cell checkedCell) {
        return (checkXY(checkedCell.x, checkedCell.y));
    }

    //Проверка что координаты точки не выходят за границы поля. На входе: координаты ячейки.
    public boolean checkXY(int x, int y) {
        return !(x < 0 || x >= size || y < 0 || y >= size);
    }

    //Проверка на выигрыш, через вектор.
    public boolean checkWin(char dotType) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((gameMap[i][j] == dotType) && (winVector(i, j, 0, 1) || winVector(i, j, 1, 1) || winVector(i, j, 1, 0) || winVector(i, j, 1, -1))) {
                    return true;
                }
            }
        }
        return false;
    }

    //Построение непрерывного вектора из точек.
    private boolean winVector(int x, int y, int dx, int dy) {
        if (!checkXY(x + dx * (dotsToWin - 1), y + dy * (dotsToWin - 1))) {
            return false;
        }
        char dotType = gameMap[x][y];
        for (int i = 0; i < dotsToWin; i++) {
            if (dotType != gameMap[x + dx * i][y + dy * i]) {
                return false;
            }
        }
        return true;
    }

}
