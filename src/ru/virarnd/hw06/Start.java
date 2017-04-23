package ru.virarnd.hw06;

import java.util.ArrayList;
import java.util.Random;

public class Start {
    private static final double MAX_RUN_DISTANCE = 1000.0;
    private static final double MAX_JUMP_DISTANCE = 1.0;
    private static final double MAX_SWIM_DISTANCE = 200.0;

    public static void main(String[] args) {
        Random rnd = new Random();

        Cat cat1 = new Cat("Джоник", 5);
        Cat cat2 = new Cat("Дарси", 9);
        Cat cat3 = new Cat("Задира", 2);
        Dog dog1 = new Dog("Дадли", 4);
        Dog dog2 = new Dog("Мускат", 2);
        Dog dog3 = new Dog("Легенда", 7);

        ArrayList<Animal> petList = new ArrayList<>();
        petList.add(cat1);
        petList.add(cat2);
        petList.add(cat3);
        petList.add(dog1);
        petList.add(dog2);
        petList.add(dog3);


        double runDistance = rnd.nextDouble() * MAX_RUN_DISTANCE;
        double jumpDistance = rnd.nextDouble() * MAX_JUMP_DISTANCE;
        double swimDistance = rnd.nextDouble() * MAX_SWIM_DISTANCE;

        System.out.println("Первый этап, бег.");
        for (Animal animal : petList) {
            animal.setRunLimit(rnd.nextDouble() * 2 * MAX_RUN_DISTANCE);
            animal.setJumpLimit(rnd.nextDouble() * 2 * MAX_JUMP_DISTANCE);
            animal.setSwimLimit(rnd.nextDouble() * 2 * MAX_SWIM_DISTANCE);

            System.out.printf("результат: %s, run: %s%n", animal.getName(), animal.run(runDistance));
            animal.setStillGoing(animal.run(runDistance));
        }

        System.out.println("\nВторой этап, прыжки.");
        for (Animal animal : petList) {
            if (animal.isStillGoing()) {
                System.out.printf("результат: %s, jump: %s%n", animal.getName(), animal.jump(jumpDistance));
                animal.setStillGoing(animal.jump(jumpDistance));
            }
        }

        System.out.println("\nТретий этап, плавание.");
        for (Animal animal : petList) {
            if (animal.isStillGoing()) {
                System.out.printf("результат: %s, swim: %s%n", animal.getName(), animal.swim(swimDistance));
                animal.setStillGoing(animal.swim(swimDistance));
            }
        }

        System.out.println();
        for (Animal animal : petList) {
            if (animal.isStillGoing()) {
                System.out.println(animal.getName() + " прошел всю дистанцию!");
            }
        }
    }
}
