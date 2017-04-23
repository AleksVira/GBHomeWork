package ru.virarnd.hw07;

public class MainClass {
    public static void main(String[] args) {
        Plate plate = new Plate(40, 50);
        Cat[] pets = new Cat[6];
        pets[0] = new Cat("Хорт", 5);
        pets[1] = new Cat("Байкал", 9);
        pets[2] = new Cat("Клайд", 10);
        pets[3] = new Cat("Гуня", 19);
        pets[4] = new Cat("Реджи", 13);
        pets[5] = new Cat("Анчар", 7);

        plate.info();

        for (Cat cat : pets) {
            cat.eat(plate);
            cat.info();
        }
        plate.info();

        plate.addFood(40);
        plate.info();
    }
}