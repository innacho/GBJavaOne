package ru.geekbrains.hw6;

//1. Создать классы Собака и Кот с наследованием от класса Животное.
//2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//4. * Добавить подсчет созданных котов, собак и животных.

import java.io.Serializable;

public class HomeWorkApp6 {

    public static void main(String[] args) {

        String tempWinEvent = ". Attempt succeeded";
        String tempLossEvent = ". Attempt failed";
        String eventName;
        String eventResult;

        Dog dog1 = new Dog("Bobic", 502.3f, 10);
        Dog dog2 = new Dog("Sharik", 400, 11.5f);
        Cat cat1 = new Cat("Barsic", 193.5f, 0);
        Cat cat2 = new Cat("Murzik", 201.4f, 0);
        Cat cat3 = new Cat("Pushok", 200, 0);

        Animal[] animals = {dog1, dog2, cat1, cat2, cat3};

        float runLength = 250;
        float swimLength = 8;

        for (int i = 0; i < animals.length; i++) {
            String nameString = animals[i].getType() + " " + animals[i].getName() + " can ";

            eventName = "run " + animals[i].getMaxRun() + " m. Tries to run ";
            eventResult = animals[i].run(runLength) ? tempWinEvent : tempLossEvent;
            result(nameString, eventName, runLength, eventResult);

            int swimResult = animals[i].swim(swimLength);
            eventName = "swim " + animals[i].getMaxSwim() + " m. Tries to swim ";
            eventResult = (swimResult == Animal.SWIM_OK) ? tempWinEvent : tempLossEvent;

            if (swimResult == Animal.SWIM_NONE)
                eventResult = ". Attempt failed, because cats can't swim";
            result(nameString, eventName, swimLength, eventResult);
        }

        System.out.println("Number of dogs is " + Dog.countDog);
        System.out.println("Number of cats is " + Cat.countCat);
        System.out.println("Number of animals is " + Animal.countAnimal);
    }

    private static void result(String nameAnimal, String event, float eventLength, String resultEvent) {
        System.out.println(nameAnimal + event + eventLength + "" +  resultEvent);
    }
}
