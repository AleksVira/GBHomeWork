package ru.virarnd.hw08;

import javax.swing.*;
import java.awt.*;

public class BattleField extends JPanel {
    private PlayingField pf;

    BattleField(PlayingField playingField) {
        this.pf = playingField;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellWidth = getWidth() / pf.getNumberOfCells();
        int cellHeight = getHeight() / pf.getNumberOfCells();
        Graphics2D g2D = ((Graphics2D) g);
        int lineWidt = Math.min(getWidth(), getHeight()) / 100;
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(lineWidt));
        for (int i = 0; i < pf.getNumberOfCells(); i++) {
            g.drawLine(cellWidth * i, 0, cellWidth * i, getHeight());
            g.drawLine(0, cellHeight * i, getWidth(), cellHeight * i);
        }


        g2D.setStroke(new BasicStroke(2 * lineWidt));
        for (int i = 0; i < pf.getNumberOfCells(); i++) {
            for (int j = 0; j < pf.getNumberOfCells(); j++) {
                if (pf.getGameMap()[j][i] == PlayingField.X_DOT) {
                    g2D.setColor(Color.RED);
                    g2D.drawLine(i * cellWidth + 4 * lineWidt, j * cellHeight + 4 * lineWidt, (i + 1) * cellWidth - 4 * lineWidt, (j + 1) * cellHeight - 4 * lineWidt);
                    g2D.drawLine(i * cellWidth + 4 * lineWidt, (j + 1) * cellHeight - 4 * lineWidt, (i + 1) * cellWidth - 4 * lineWidt, j * cellHeight + 4 * lineWidt);
                }
                if (pf.getGameMap()[j][i] == PlayingField.O_DOT) {
                    g2D.setColor(Color.GREEN);
                    g2D.drawOval(i* cellWidth + 4 * lineWidt, j * cellHeight + 4 * lineWidt, cellWidth - 8 * lineWidt, cellHeight - 8 * lineWidt);
                }
            }
        }
    }
}
