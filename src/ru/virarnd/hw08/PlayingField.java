package ru.virarnd.hw08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class PlayingField extends JPanel {
    private JButton playersButton;
    private JButton newGameButton;

    private JPanel mainField;
    private JPanel rootPanel;
    private JLabel tipField;

    static final char EMPTY_DOT = '*';
    static final char X_DOT = 'X';
    static final char O_DOT = 'O';
    private int numberOfCells;
    private int dotsToWin;
    private char[][] gameMap;

    JPanel getRootPanel() {
        return rootPanel;
    }
    JButton getPlayersButton() {
        return playersButton;
    }
    JPanel getMainField() {
        return mainField;
    }
    char[][] getGameMap() {
        return gameMap;
    }
    JLabel getTipField() {
        return tipField;
    }





    PlayingField(int fieldSize, int dotsToWin) {
        this.numberOfCells = fieldSize;
        this.gameMap = new char[fieldSize][fieldSize];
        this.dotsToWin = dotsToWin;
        clear();

        playersButton.setActionCommand(GameControl.PLAYERS);
        newGameButton.setActionCommand(GameControl.NEW_GAME);
        mainField.setBackground(Color.WHITE);
        refresh();

    }

    int getNumberOfCells() {
        return numberOfCells;
    }

    //Проверка, пустая ли ячейка?
    boolean isEmpty(Cell checkedCell) {
        return gameMap[checkedCell.x][checkedCell.y] == EMPTY_DOT;
    }

    //Проверка на выигрыш, через вектор.
    public boolean checkWin(char dotType) {
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
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

    //Проверка что координаты точки не выходят за границы поля. На входе: координаты ячейки.
    public boolean checkXY(int x, int y) {
        return !(x < 0 || x >= numberOfCells || y < 0 || y >= numberOfCells);
    }


    public void addButtonsListener(ActionListener actionListener) {
        playersButton.addActionListener(actionListener);
        newGameButton.addActionListener(actionListener);
    }

    private void createUIComponents() {
        mainField = new BattleField(this);
    }

    void setDot(Cell cell, char dot) {
        gameMap[cell.x][cell.y] = dot;
    }


    boolean trySetDotByMouse(int cellX, int cellY, char dotType) {
        Cell testCell = new Cell(cellY / (mainField.getHeight() / numberOfCells), cellX / (mainField.getWidth() / numberOfCells));
        if (isEmpty(testCell)) {
            setDot(testCell, dotType);
            mainField.repaint();
            return true;
        } else {
            return false;
        }
    }

    void refresh() {
        mainField.revalidate();
        mainField.repaint();
    }

    void clear() {
        for (char[] row : gameMap) {
            Arrays.fill(row, EMPTY_DOT);
        }
    }
}
