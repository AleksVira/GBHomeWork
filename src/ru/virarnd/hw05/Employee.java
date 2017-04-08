package ru.virarnd.hw05;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;

    }

    public int getAge() {
        return age;
    }

    public void info() {
        System.out.println("ФИО:\t\t" + fullName + "\nдолжность:\t" + position + "\nemail:\t\t" + email + "\nтелефон:\t" + phoneNumber + "\nзарплата:\t" + salary + "\nвозраст:\t" + age + "\n");
    }


}
