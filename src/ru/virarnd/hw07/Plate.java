package ru.virarnd.hw07;

public class Plate {
    private int capacity;
    private int food;

    public Plate(int capacity, int food) {
        this.capacity = capacity;
        this.food = 0;
        addFood(food);
    }

    public boolean decreaseFood(int n) {
        if (food < n) {
            System.out.println("\tЕды мало, кот не поел");
            return false;
        } else {
            food -= n;
            return true;
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void addFood(int newFood) {
        food += newFood;
        if (food > capacity) {
            food = capacity;
            System.out.println("Часть еды просыпалась мимо тарелки");
        }
    }

}