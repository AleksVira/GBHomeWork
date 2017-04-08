package ru.virarnd.hw05;

public class Loader {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Фёдор Юдин", "директор", "fedor@gmail.com", "8923-111-22-33", 75000, 50);
        employees[1] = new Employee("Татьяна Брагина", "бухгалтер", "tanya@gmail.com", "8923-111-22-11", 60000, 45);
        employees[2] = new Employee("Антонина Лукина", "экономист", "antonina@gmail.com", "8923-222-11-11", 55000, 42);
        employees[3] = new Employee("Богдан Васильев", "водитель", "bogdan@gmail.com", "8923-333-77-55", 25000, 30);
        employees[4] = new Employee("Герман Гончарук", "охранник", "german@gmail.com", "8923-444-00-33", 20000, 25);

        for (Employee employee: employees) {
            if (employee.getAge() > 40) {
                employee.info();
            }
        }
    }
}
