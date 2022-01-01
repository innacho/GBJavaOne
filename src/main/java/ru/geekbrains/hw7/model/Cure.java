package ru.geekbrains.hw7.model;

import ru.geekbrains.hw7.tools.Tools;

public class Cure {
    private int healValue;
    private int count;

    private int valueMin = 5;
    private int valueMax = 15;

    public Cure(int count) {
        this.healValue = Tools.randomValue(valueMin, valueMax);
        this.count = count;
    }

    public void decreaseCureCount() {
        --count;
    }

    public int getCount() {
        return count;
    }

    public boolean isExistCure() {
        return count > 0;
    }

    public int getHealValue() {
        return healValue;
    }
}
