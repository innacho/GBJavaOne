package ru.geekbrains.hw7.windowParts.infoPanelParts;

import ru.geekbrains.hw7.MainWindow;
import ru.geekbrains.hw7.model.Player;
import ru.geekbrains.hw7.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerControlArea extends JPanel {
    private JButton left;
    private JButton up;
    private JButton right;
    private JButton down;

    private InfoPanel infoPanel;
    private MainWindow mainWindow;

    public PlayerControlArea(InfoPanel infoPanel) {
        this.infoPanel = infoPanel;
        this.mainWindow = mainWindow;
        setLayout(new GridLayout(3, 3));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // ВОПРОС: можно ли добавить конкретную кнопку в определенное место в сетке, чтобы не создавать кнопки-заглушки emptyButton?
        // То есть мне хотелось оставить части сетки пустыми прямоугольниками, а в другие добавить кнопки. Как это можно сделать?

        JPanel buttonsArea[] = new JPanel[9];
        for (int i=0; i<9; i++){
            buttonsArea[i] = new JPanel();
            add(buttonsArea[i]);
        }

//        Icon iconUp = new ImageIcon("C:\\up_triangle.png");
//        up = new JButton(iconUp);
        up = new JButton("⮝"); //\uD83E\uDC45

        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.recordLog("Up button pressed");
                infoPanel.updatePlayer(Player.playerMoveUp);
            }
        });
        buttonsArea[1].add(up);

//        Icon iconLeft = new ImageIcon("C:\\left_triangle.png");
//        left = new JButton(iconLeft);
//        left = new JButton("  LEFT  ");
        left = new JButton("⮜"); //\uD83E\uDC44
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.recordLog("Left button pressed");
                infoPanel.updatePlayer(Player.playerMoveLeft);
            }
        });
        buttonsArea[3].add(left);

//        Icon iconRight = new ImageIcon("C:\\right_triangle.png");
//        right = new JButton(iconRight);
//        right = new JButton("  RIGHT ");
        //ВОПРОС: Текст на кнопке не умещается, обрезался троеточием, хотя вокруг текста до границы кнопки кажется еще много места.
        // Подскажите, пожалуйста, способ разместить на кнопке подпись "RIGHT" полностью.
//        на самом деле Swing автоматически выбирает размеры по контенту, но если вы ограничили сам компонент,
//                то тут либо шрифт меньше делать, либо выбирать другое расположение.
//        right.setIcon(new javax.swing.ImageIcon("pics/right_triangle.png"));
//        очень плохая идея такое в коде делать new javax.swing.ImageIcon
//        импорт же сделан библиотеки - вызывайте напрямую класс
        right = new JButton("⮞"); //\uD83E\uDC46
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.recordLog("Right button pressed");
                infoPanel.updatePlayer(Player.playerMoveRight);
            }
        });
        buttonsArea[5].add(right);

//        Icon iconDown = new ImageIcon("C:\\down_triangle.png");
//        down = new JButton(iconDown);
//        down = new JButton("DOWN  ");
        down = new JButton("⮟"); //\uD83E\uDC47
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.recordLog("Down button pressed");
                infoPanel.updatePlayer(Player.playerMoveDown);
            }
        });
        buttonsArea[7].add(down);
    }
}
