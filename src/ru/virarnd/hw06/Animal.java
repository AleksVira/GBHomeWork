package ru.virarnd.hw06;

public class Animal {
    private String name;
    private int age;
    private boolean stillGoing;

    private double runLimit;
    private double jumpLimit;
    private double swimLimit;


    Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.stillGoing = true;
    }

    String getName() {
        return name;
    }

    boolean isStillGoing() {
        return stillGoing;
    }

    void setStillGoing(boolean stillGoing) {
        this.stillGoing = stillGoing;
    }

    public double getRunLimit() {
        return runLimit;
    }

    void setRunLimit(double runLimit) {
        this.runLimit = runLimit;
    }

    public double getJumpLimit() {
        return jumpLimit;
    }

    void setJumpLimit(double jumpLimit) {
        this.jumpLimit = jumpLimit;
    }

    public double getSwimLimit() {
        return swimLimit;
    }

    void setSwimLimit(double swimLimit) {
        this.swimLimit = swimLimit;
    }

    boolean run(double distance) {
        return distance < runLimit;
    }

    boolean jump(double height) {
        return height < jumpLimit;
    }

    boolean swim(double distance) {
        return distance < swimLimit;
    }


}
