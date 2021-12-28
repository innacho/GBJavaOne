package ru.geekbrains.hw7.windowParts.infoPanelParts;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GameInfoArea extends JPanel {
    //начальные значения для отображения в Инфо до старта игры
    int[] mapSize = {2,2};
    int level = 0;
    int trapsCount = 0;
    int curesCount = 0;

    public GameInfoArea() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(5, 1));

        add(new JLabel("=Game Info=", SwingConstants.CENTER));
        add(new JLabel("Map size: " + Arrays.toString(mapSize), SwingConstants.LEFT));
        add(new JLabel("Current level: " + level, SwingConstants.LEFT));
        add(new JLabel("Traps left: " + trapsCount, SwingConstants.LEFT));
        add(new JLabel("Cures left: " + curesCount, SwingConstants.LEFT));
    }
}
