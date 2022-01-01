package ru.geekbrains.hw7.windowParts.infoPanelParts;

import javax.swing.*;
import java.awt.*;

public class GameInfoArea extends JPanel {

    private String prefixTrapCount = "Traps left: ";
    private String prefixCureCount = "Cures left: ";
    private String prefixLevel = "Level: ";
    private String prefixSizeMap = "Map size: ";

    private JLabel trapCount;
    private JLabel cureCount;
    private JLabel levelGame;
    private JLabel sizeMap;

    public GameInfoArea() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(5, 1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        sizeMap = new JLabel(prefixSizeMap + "-:-");
        levelGame = new JLabel(prefixLevel + "-");
        trapCount = new JLabel(prefixTrapCount + "-");
        cureCount = new JLabel(prefixCureCount + "-");

        add(new JLabel("=Game Info=", SwingConstants.CENTER));
        add(sizeMap);
        add(levelGame);
        add(trapCount);
        add(cureCount);
    }
    public void refresh(String sizeMapInfo, int countLevel, int trapsCount, int curesCount) {
        sizeMap.setText(prefixSizeMap + sizeMapInfo);
        levelGame.setText(prefixLevel + countLevel);
        trapCount.setText(prefixTrapCount + trapsCount);
        cureCount.setText(prefixCureCount + curesCount);
    }
}



