package ru.virarnd.hw06;

public class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean swim(double distance) {
        return false;
    }


}
