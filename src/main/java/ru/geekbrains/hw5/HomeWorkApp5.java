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
public class HomeWorkApp5 {
    public static void main(String[] args) {
        Emploee emploees[] = new Emploee[5];
        emploees[0] = new Emploee("Petrov Petr Petrovich", "CEO", "petrov@mail.ru", "+79101111111", 210000.5f, 55);
        emploees[1] = new Emploee("Sidorov Sidor Sidorovich", "manager", "sidorov@mail.ru", "+79102222222", 192000.7f, 50);
        emploees[2] = new Emploee("Schetovod Marta Pavlovna", "bugalter", "marta@mail.ru", "+79103333333", 255000.1f, 65);
        emploees[3] = new Emploee("Dokumentova Anna Evgenievna", "analist", "anna@mail.ru", "+79104444444", 100340.1f, 35);
        emploees[4] = new Emploee("Karlov Victor Evgenyevich", "analist", "karlov@mail.ru", "+79105555555", 100340.1f, 25);

        for(int i = 0; i < emploees.length; i++){
            if(emploees[i].getAge() > 40) emploees[i].info();
        }
    }
}
