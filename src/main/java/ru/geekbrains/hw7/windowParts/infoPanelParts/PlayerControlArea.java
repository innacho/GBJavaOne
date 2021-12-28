package ru.geekbrains.hw7.windowParts.infoPanelParts;

import ru.geekbrains.hw7.MainWindow;
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

    public PlayerControlArea(InfoPanel infoPanel, MainWindow mainWindow) {
        this.infoPanel = infoPanel;
        this.mainWindow = mainWindow;
        setLayout(new GridLayout(3, 3));
        // ВОПРОС: можно ли добавить конкретную кнопку в определенное место в сетке, чтобы не создавать кнопки-заглушки emptyButton?
        // То есть мне хотелось оставить части сетки пустыми прямоугольниками, а в другие добавить кнопки. Как это можно сделать?

        JPanel buttonsArea[] = new JPanel[9];
        for (int i=0; i<9; i++){
            buttonsArea[i] = new JPanel();
            add(buttonsArea[i]);
        }

        Icon iconUp = new ImageIcon("C:\\up_triangle.png");
        up = new JButton(iconUp);
//        up = new JButton("   UP   ");
//        up.setIcon(new javax.swing.ImageIcon("ru.geekbrains.hw7.windowParts.infoPanelParts.pics.up_triangle.png"));
//        //ВОПРОС: Подскажите, пожалуйста, как добавить иконку на кнопку из файла с картинкой. Пробовала указывать путь разными способами, но не получается
//
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.printToLog("Up button pressed\n");
            }
        });
        buttonsArea[1].add(up);

        Icon iconLeft = new ImageIcon("C:\\left_triangle.png");
        left = new JButton(iconLeft);
//        left = new JButton("  LEFT  ");
//        left.setIcon(new javax.swing.ImageIcon("pics/left_triangle.png"));

        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.printToLog("Left button pressed\n");
            }
        });
        buttonsArea[3].add(left);

        Icon iconRight = new ImageIcon("C:\\right_triangle.png");
        right = new JButton(iconRight);
//        right = new JButton("  RIGHT ");
        //ВОПРОС: Текст на кнопке не умещается, обрезался троеточием, хотя вокруг текста до границы кнопки кажется еще много места.
        // Подскажите, пожалуйста, способ разместить на кнопке подпись "RIGHT" полностью.
//        на самом деле Swing автоматически выбирает размеры по контенту, но если вы ограничили сам компонент,
//                то тут либо шрифт меньше делать, либо выбирать другое расположение.
//        right.setIcon(new javax.swing.ImageIcon("pics/right_triangle.png"));
//        очень плохая идея такое в коде делать new javax.swing.ImageIcon
//        импорт же сделан библиотеки - вызывайте напрямую класс

        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.printToLog("Right button pressed\n");
            }
        });
        buttonsArea[5].add(right);

        Icon iconDown = new ImageIcon("C:\\down_triangle.png");
        down = new JButton(iconDown);
//        down = new JButton("DOWN  ");
//        down.setIcon(new javax.swing.ImageIcon("pics/down_triangle.png"));

        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.printToLog("Down button pressed\n");
            }
        });
        buttonsArea[7].add(down);
    }
}
