package ru.geekbrains.hw5;
/**
 * На JAVA НЕ!!!! ПИШУТ на русском языке *
 * 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 * 2. Конструктор класса должен заполнять эти поля при создании объекта.
 * 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 * 4. Создать массив из 5 сотрудников.
 * Пример:
 * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 * persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
 * 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */

public class Emploee {
    private String name;
    private String ocupation;
    private String email;
    private String phone;
    private float salary;
    private int age;

    public Emploee (String name, String ocupation, String email, String phone, float salary, int age){
        this.name = name;
        this.ocupation = ocupation;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info(){
        System.out.println("Name " + name + ", ocupation " + ocupation + ", email " + email + ", phone " + phone + ", salary " + salary + ", age " + age );
    }

    public int getAge(){
        return age;
    }
}
