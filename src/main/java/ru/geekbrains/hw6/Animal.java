package ru.geekbrains.hw6;

public class Animal {

    private String name;
    private String animalType;

    public Animal(String name) {
        HomeWorkApp6.animalCount++;
        this.name = name;
    }
    public void setAnimalType(String type){
        animalType = type;
    }
    public String getAnimalType(){
        return animalType;
    }
    public String getName(){
        return name;
    }
    public void run(float distance){
        System.out.println(animalType + name + " runs " + distance + " meters.");
    }
    public void swim(float distance){
        System.out.println(animalType + name + " swims " + distance + " meters.");
    }
}
