package ru.virarnd.hw01;

public class Main {
    public static void main(String[] args) {

        byte myByte = 15;
        short myShort = 127;
        int myInt = 543444442;
        long myLong = 6546546541235468798L;
        float myFloat = 2.15f;
        double myDouble = 122.2354654;
        char myChar = 'y';
        boolean yesNo = true;
        String mySlogan = "GeekBrains is the best";

        System.out.println(simpleCalculate(15, 55, 152.4, 11.8));
        System.out.println(sumCheck(5, 11));
        checkSign(0);
        checkSign(-15);
        System.out.println(checkNegative(-5));
        System.out.println(checkNegative(5));
        printHello("Вася");
        checkLeap(2000);
        checkLeap(2100);
        checkLeap(2104);
    }

    private static double simpleCalculate(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    private static boolean sumCheck(int a, int b) {
        return ((a + b) <= 20 && (a + b) >= 10);
    }

    private static void checkSign(int checked) {
        String answer;
        answer = (checked < 0) ? "negative" : "positive";
        System.out.println("Number is " + answer + ".");
    }

    private static boolean checkNegative(int checked) {
        return (checked < 0);
    }

    private static void printHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    private static void checkLeap(int year) {
        String isLeap;
        if (year % 4 != 0) {
            isLeap = "не ";
        } else if (year % 400 == 0) {
            isLeap = "";
        } else if (year % 100 == 0) {
            isLeap = "не ";
        } else {
            isLeap = "";
        }
        System.out.println(year + " -- " + isLeap + "високосный год");
    }
}
