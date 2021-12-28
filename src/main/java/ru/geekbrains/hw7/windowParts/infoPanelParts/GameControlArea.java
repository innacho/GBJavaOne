package ru.geekbrains.hw7.windowParts.infoPanelParts;

import ru.geekbrains.hw7.MainWindow;
import ru.geekbrains.hw7.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class GameControlArea extends JPanel {
    private JButton startGame;
    private JButton exitGame;

    private InfoPanel infoPanel;
    private MainWindow mainWindow;

    public GameControlArea(InfoPanel infoPanel, MainWindow mainWindow) {
        this.infoPanel = infoPanel;
        this.mainWindow = mainWindow;
        setLayout(new GridLayout(3, 1));
        startGame = new JButton("START GAME");

        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setTitle("Hi, " + InfoPanel.playerName);
            }
        });

        exitGame = new JButton("EXIT GAME");
        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit(1);
            }
        });

        add(new JLabel("=Game Controls=", SwingConstants.CENTER));
        add(startGame);
        add(exitGame);
    }
}
