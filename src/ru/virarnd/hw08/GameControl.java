package ru.virarnd.hw08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class GameControl extends JFrame {

    static final String FIRST_HUMAN = "1Human";
    static final String FIRST_AI = "1Ai";
    static final String SECOND_HUMAN = "2Human";
    static final String SECOND_AI = "2Ai";
    static final String START = "Start";
    static final String PLAYERS = "Players";
    static final String NEW_GAME = "NG";

    private static final int FIELD_SIZE = 5;
    private static final int DOTS_TO_WIN = 4;

    // Счетчик количества ходов.
    private int turnCounter;
    // Следующая ячейка для хода.
    Cell nextCell;
    // Признак того что игра началась.
    private boolean gameStared;
    private boolean gameFinished;

    // Игровое поле, задаем размер и количество точек для выигрыша.
    private PlayingField playingField = new PlayingField(FIELD_SIZE, DOTS_TO_WIN);

    private Player playerOne = new Player("Игрок 1", true, PlayingField.X_DOT, playingField);
    private Player playerTwo = new Player("ПК 2", false, PlayingField.O_DOT, playingField);

    // Игрок, чей ход сейчас
    private Player currentPlayer = playerOne;

    private SelectPlayer selectPlayer = new SelectPlayer(playerOne, playerTwo);

    GameControl() {
        setTitle("Крестики-нолики v.1.0");
        setContentPane(playingField.getRootPanel());
        setSize(450, 500);
        setMinimumSize(new Dimension(300, 350));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        repaint();

        selectPlayer.addButtonsListener(new UpdatePlayerInfo());
        playingField.addButtonsListener(new PlayFieldControl());
        playingField.getMainField().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (gameStared) {
                    super.mouseReleased(e);
                    int cellX = e.getX();
                    int cellY = e.getY();
                    if (playingField.trySetDotByMouse(cellX, cellY, currentPlayer.getDotType())) {
                        playingField.refresh();
                        turnCounter++;
                        checkFinish();
                        changePlayer();
                        nextMove();
                    }
                } else if (gameFinished) {
                    playingField.getTipField().setText("Переопределите игроков или нажмите \"Новая игра\"");
                } else {
                    playingField.getTipField().setText("Сначала определите игроков!");
                }
            }
        });

        setVisible(true);
    }


    private void changePlayer() {
        currentPlayer = (currentPlayer == playerOne) ? playerTwo : playerOne;
    }

    private void startGame() {
        System.out.println("Старт игры");
        currentPlayer = playerOne;
        turnCounter = 0;
        gameStared = true;
        gameFinished = false;
        playingField.clear();
        playingField.getTipField().setText("");
        playingField.getPlayersButton().setEnabled(false);
        setContentPane(playingField.getRootPanel());
        nextMove();
    }

    private void nextMove() {
        if (gameStared) {
            if (!currentPlayer.isHuman()) {
                playingField.setDot(currentPlayer.nextAiTurn(), currentPlayer.getDotType());
                turnCounter++;
                checkFinish();
                changePlayer();
                playingField.refresh();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!currentPlayer.isHuman()) {
                    nextMove();
                } else {
                    playingField.getTipField().setText("Ход игрока " + currentPlayer.getName());
                }
            } else {
                playingField.getTipField().setText("Ход игрока " + currentPlayer.getName());
            }
        }
    }

    private void checkFinish() {
        if (playingField.checkWin(currentPlayer.getDotType())) {
            winGame(currentPlayer);
        }
        if (turnCounter == playingField.getNumberOfCells() * playingField.getNumberOfCells()) {
            drawGame();
        }
    }

    private void winGame(Player currentPlayer) {
        gameStared = false;
        gameFinished = true;
        playingField.getPlayersButton().setEnabled(true);
        System.out.println("Сделано ходов: " + turnCounter);
        System.out.println("Игра окончена, выиграл " + currentPlayer.getName());
        playingField.getTipField().setText("Выиграл " + currentPlayer.getName());
        playingField.refresh();
    }

    private void drawGame() {
        gameStared = false;
        gameFinished = true;
        System.out.println("Сделано ходов: " + turnCounter);
        System.out.println("Игра окончена, никто не выиграл");
        playingField.getPlayersButton().setEnabled(true);
        playingField.getTipField().setText("НИЧЬЯ !");
        playingField.refresh();
    }

    private class UpdatePlayerInfo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
                case FIRST_HUMAN:
                    selectPlayer.getTextField1().setText("Игрок 1");
                    selectPlayer.getTextField1().setEnabled(true);
                    playerOne.setHuman(true);
                    break;
                case FIRST_AI:
                    selectPlayer.getTextField1().setText("ПК 1");
                    selectPlayer.getTextField1().setEnabled(false);
                    playerOne.setHuman(false);
                    break;
                case SECOND_HUMAN:
                    selectPlayer.getTextField2().setText("Игрок 2");
                    selectPlayer.getTextField2().setEnabled(true);
                    playerTwo.setHuman(true);
                    break;
                case SECOND_AI:
                    selectPlayer.getTextField2().setText("ПК 2");
                    selectPlayer.getTextField2().setEnabled(false);
                    playerTwo.setHuman(false);
                    break;
                case START:
                    playerOne.setName(selectPlayer.getTextField1().getText());
                    playerTwo.setName(selectPlayer.getTextField2().getText());
                    startGame();
                    break;
                default:
                    System.out.println(event.getActionCommand());
            }
        }
    }

    private class PlayFieldControl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent eventP) {
            switch (eventP.getActionCommand()) {
                case PLAYERS:
                    setContentPane(selectPlayer.getRootPanel());
                    setVisible(true);
                    break;
                case NEW_GAME:
                    playingField.getPlayersButton().setEnabled(false);
                    startGame();
                    break;
            }
        }
    }
}
