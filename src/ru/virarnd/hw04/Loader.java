package ru.virarnd.hw04;

import java.util.Scanner;

public class Loader {

    private static final String NAME_ONE = "первого";
    private static final String NAME_TWO = "второго";

    public static void main(String[] args) {
        // Счетчик количества ходов.
        int turnCounter = 1;
        // Следующая ячейка для хода.
        Cell nextCell;
        // Игровое поле, задаем размер и количество точек для выигрыша.
        GameField gf = new GameField(5, 4);

        System.out.println("Крестики начинают игру.");
        // Задаём игроков: указываем тип (человек / компьютер), даём имя.
        Player playerOne = selectPlayer(NAME_ONE, GameField.X_DOT, gf);
        Player playerTwo = selectPlayer(NAME_TWO, GameField.O_DOT, gf);

        gf.printMap();

        while (true) {
            //Чей сейчас ход? Нечетные -- ходит крестик, четные -- ходит нолик.
            Player currentPlayer = (turnCounter % 2 == 1) ? playerOne : playerTwo;
            nextCell = currentPlayer.nextTurn();
            gf.setDot(nextCell, currentPlayer.getDotType());
            gf.printMap();

            if (gf.checkWin(currentPlayer.getDotType())) {
                System.out.println("Игрок " + currentPlayer.getName() + " выиграл!");
                break;
            }

            // Если счетчик равен количеству всех возможных ячеек, то ничья.
            turnCounter++;
            if (turnCounter > gf.getSize() * gf.getSize()) {
                System.out.println("Ничья!");
                break;
            }
        }
        System.out.println("Игра окончена.");
    }

    private static Player selectPlayer(String nik, char dotType, GameField gf) {
        int answer;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Выберите тип " + nik + " игрока: 0 - человек, 1 - компьютер >> ");
            answer = sc.nextInt();
            if (answer == 0 || answer == 1) {
                break;
            } else {
                System.out.println("Повторите ввод.");
            }
        }
        System.out.print("Введите имя: ");
        String name = sc.next();
        return new Player(name, (answer == 0), dotType, gf);
    }
}
