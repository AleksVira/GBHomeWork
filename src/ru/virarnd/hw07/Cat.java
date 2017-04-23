package ru.virarnd.hw07;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) {
            satiety = true;
        }
    }

    public void info() {
        String state = " голодный";
        if (satiety) {
            state = " покушал и сыт";
        }
        System.out.println("Кот " + name + state);
    }
}