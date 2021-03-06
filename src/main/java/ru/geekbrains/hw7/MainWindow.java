package ru.geekbrains.hw7;

import ru.geekbrains.hw7.windowParts.GamePanel;
import ru.geekbrains.hw7.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;


public class MainWindow extends JFrame {

        private int widthW = 1024;
        private int heightW = 768;
        private int posXW = 100;
        private int posYW = 50;
        private String titleW  = "Game Stay Alive Player";
        public static String playerName = "Inna";

        private InfoPanel infoPanel;
        private GamePanel map;

        MainWindow() {
            setupWindow();
            map = new GamePanel(this);
            infoPanel = new InfoPanel(this);
            add(map);
            add(infoPanel, BorderLayout.EAST);
            setVisible(true);
        }

        private void setupWindow() {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(widthW,heightW);
            setLocation(posXW, posYW);
            setTitle(titleW);
            setResizable(false);
        }

    public void launchGame() {
        map.launchGame();
    }

    public void refreshInfo(GamePanel map) {
        infoPanel.refreshInfo(map);
    }

    public void recordLog(String str) {
        infoPanel.recordLog(str);
    }

    public void updatePlayer(int key) {
        map.updatePlayer(key);
    }

}

