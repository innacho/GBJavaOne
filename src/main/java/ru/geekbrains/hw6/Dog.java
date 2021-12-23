package ru.geekbrains.hw6;

public class Dog extends Animal {


    public Dog(String name){
        super(name);
        HomeWorkApp6.dogsCount++;
        setAnimalType("Dog ");
    }

    @Override
    public void run(float distance){
        if(distance > 500) System.out.println(getAnimalType() + getName() + " cannot run " + distance + " meters.");
        else super.run(distance);
    }

    @Override
    public void swim(float distance){
        if(distance > 10) System.out.println(getAnimalType() + getName() + " cannot swim " + distance + " meters.");
        else super.swim(distance);
    }
}
