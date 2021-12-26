package ru.geekbrains.hw6;

public class Dog extends Animal {

    public static int countDog = 0;
    public static String typeThisClass = "Dog";

    Dog(String name, float maxRun, float maxSwim){
        super(typeThisClass, name, maxRun, maxSwim);
        ++countDog;
    }

}
