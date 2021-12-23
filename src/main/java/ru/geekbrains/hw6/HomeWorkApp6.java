package ru.geekbrains.hw6;

//1. Создать классы Собака и Кот с наследованием от класса Животное.
//2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//4. * Добавить подсчет созданных котов, собак и животных.

public class HomeWorkApp6 {
    public static int animalCount = 0;
    public static int dogsCount = 0;
    public static int catsCount = 0;
    public static void main(String[] args) {
        Dog BobicDog = new Dog("Bobic");
        BobicDog.run(200.5f);
        BobicDog.run(505.4f);
        BobicDog.swim(0.8f);
        BobicDog.swim(12);

        Dog SharikDog = new Dog("Sharik");
        SharikDog.run(200.5f);
        SharikDog.run(505.4f);
        SharikDog.swim(0.8f);
        SharikDog.swim(12);

        Cat BarsicCat = new Cat("Barsic");
        BarsicCat.run(20.5f);
        BarsicCat.run(505.4f);
        BarsicCat.swim(2);

        Cat MurzikCat = new Cat("Murzik");
        MurzikCat.run(20.5f);
        MurzikCat.run(505.4f);
        MurzikCat.swim(2);

        Cat PushokCat = new Cat("Pushok");
        PushokCat.run(199.5f);
        PushokCat.run(505.4f);
        PushokCat.swim(0.8f);

        System.out.println("Number of dogs is " + dogsCount);
        System.out.println("Number of cats is " + catsCount);
        System.out.println("Number of animals is " + animalCount);
    }
}
