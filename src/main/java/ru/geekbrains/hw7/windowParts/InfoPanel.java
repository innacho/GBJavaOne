package ru.geekbrains.hw7.windowParts;

import ru.geekbrains.hw7.MainWindow;
import ru.geekbrains.hw7.windowParts.infoPanelParts.GameControlArea;
import ru.geekbrains.hw7.windowParts.infoPanelParts.GameInfoArea;
import ru.geekbrains.hw7.windowParts.infoPanelParts.PlayerControlArea;
import ru.geekbrains.hw7.windowParts.infoPanelParts.PlayerInfoArea;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    public static String playerName = "Inna";

    private GameControlArea gameControlArea;
    private GameInfoArea gameInfoArea;
    private PlayerInfoArea playerInfoArea;
    private PlayerControlArea playerControlArea;

    private JTextArea log;
    private JScrollPane scroll;

    private MainWindow mainWindow;

    public InfoPanel(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        preparePanel();
        createParts();
        prepareLogs();

        add(gameControlArea);
        add(gameInfoArea);
        add(playerInfoArea);
        add(playerControlArea);
        add(scroll);
    }

    private void preparePanel() {
        setBackground(Color.YELLOW);
        setLayout(new GridLayout(5, 1));
    }

    private void createParts() {
        gameControlArea = new GameControlArea(this, mainWindow);
        gameInfoArea = new GameInfoArea();
        playerInfoArea = new PlayerInfoArea(this);
        playerControlArea = new PlayerControlArea(this, mainWindow);
    }

    private void prepareLogs() {
        log = new JTextArea();
        scroll = new JScrollPane(log);
    }

    public void printToLog(String message){
        log.append(message);
    }

}
