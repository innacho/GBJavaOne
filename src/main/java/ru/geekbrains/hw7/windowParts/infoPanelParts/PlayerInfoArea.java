package ru.geekbrains.hw7.windowParts.infoPanelParts;

import ru.geekbrains.hw7.model.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoArea extends JPanel {
    private String prefixHP = "Health: ";
    private String prefixPosition = "Position: ";
    private String prefixScore = "Current score: ";

    private JLabel playerHP;
    private JLabel playerPosition;
    private JLabel score;

    public PlayerInfoArea(){
        setBackground(Color.YELLOW);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
 //       setPreferredSize(new Dimension(infoPanel.getWidth(),height));
        // ВОПРОС: В строке выше я пыталась установить размер панели PlayerInfoArea по вертикали, но мой способ не сработал.
        // Подскажите, пожалуйста, почему именно метод выше не работает?

     //   потому что вы указали new GridLayout(4, 1), т.е. все компоненты по вертикале будут набиватся автоматически в равных долях.
        // Как можно задать вертикальный размер области Player Info?
//        выбрать другой менеджер расположения. Но и я и разработчики swing не рекомендуют устанавливать четкие размеры
//        компонентов иначе у вас весь интерфейс поплывет и вам все придется в ручную обсчитывать

        setLayout(new GridLayout(4, 1));

        add(new JLabel("=Player Info=", SwingConstants.CENTER));

        playerHP = new JLabel(prefixHP + "-");
        playerPosition = new JLabel(prefixPosition + "-:-");
        score = new JLabel(prefixScore + "-");
        add(playerHP);
        add(playerPosition);
        add(score);
    }

    public void refresh(Player player, int levelCount) {
        playerHP.setText(prefixHP + player.getHp());
        playerPosition.setText(prefixPosition + player.getPosition());
        score.setText(prefixScore + player.getTotalWins()  + " won");
    }
}
