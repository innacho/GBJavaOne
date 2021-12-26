package ru.geekbrains.hw7.windowParts.infoPanelParts;

import ru.geekbrains.hw7.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoArea extends JPanel {
    private int height = 100;
    public PlayerInfoArea(InfoPanel infoPanel){
        setBackground(Color.YELLOW);
        setPreferredSize(new Dimension(infoPanel.getWidth(),height));
        // ВОПРОС: В строке выше я пыталась установить размер панели PlayerInfoArea по вертикали, но мой способ не сработал.
        // Подскажите, пожалуйста, почему именно метод выше не работает?
        // Как можно задать вертикальный размер области Player Info?

        setLayout(new GridLayout(4, 1));

        add(new JLabel("=Player Info=", SwingConstants.CENTER));
        add(new JLabel("HP:  100", SwingConstants.LEFT));
        add(new JLabel("Current score: 0 won/ 0 lost", SwingConstants.LEFT));
    }

}
