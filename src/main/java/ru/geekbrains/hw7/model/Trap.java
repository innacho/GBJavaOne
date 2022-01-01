package ru.geekbrains.hw7.model;

import ru.geekbrains.hw7.tools.Tools;

public class Trap {
    private int attack;
    private int count;

    private int valueMin = 5;
    private int valueMax = 25;

    public Trap(int count) {
        this.attack = Tools.randomValue(valueMin, valueMax);
        this.count = count;
    }

    public void decreaseTrapCount() {
        --count;
    }

     public int getCount() {
        return count;
    }

    public boolean isExistTrap() {
        return count > 0;
    }

    public int getAttack() {
        return attack;
    }

}
