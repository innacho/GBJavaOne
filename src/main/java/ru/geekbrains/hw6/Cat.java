package ru.geekbrains.hw6;

public class Cat extends Animal {

    public Cat(String name){
        super(name);
        HomeWorkApp6.catsCount++;
        setAnimalType("Cat ");
    }

    @Override
    public void run(float distance){
        if(distance > 200) System.out.println(getAnimalType() + getName() + " cannot run " + distance  + " meters.");
        else super.run(distance);
    }

    public void swim(float distance){
        System.out.println(getAnimalType() + getName() + " cannot swim " + distance + " meters, because it cannot swim at all.");
    }
}
