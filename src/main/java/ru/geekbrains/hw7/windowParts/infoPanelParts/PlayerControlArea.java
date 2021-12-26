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

        JButton emptyButton = new JButton();
        emptyButton.setBackground(Color.WHITE);
        add(emptyButton);

        up = new JButton("UP");
        up.setIcon(new javax.swing.ImageIcon("ru.geekbrains.hw7.windowParts.infoPanelParts.pics.up_triangle.png"));
        //ВОПРОС: Подскажите, пожалуйста, как добавить иконку на кнопку из файла с картинкой. Пробовала указывать путь разными способами, но не получается

        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.printToLog("Up button pressed\n");
            }
        });
        add(up);

        JButton emptyButton2 = new JButton();
        emptyButton2.setBackground(Color.WHITE);
        add(emptyButton2);

        left = new JButton("LEFT");
        left.setIcon(new javax.swing.ImageIcon("pics/left_triangle.png"));

        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.printToLog("Left button pressed\n");
            }
        });
        add(left);

        JButton emptyButton3 = new JButton();
        emptyButton3.setBackground(Color.WHITE);
        add(emptyButton3);

        right = new JButton("RIGHT");
        //ВОПРОС: Текст на кнопке не умещается, обрезался троеточием, хотя вокруг текста до границы кнопки кажется еще много места.
        // Подскажите, пожалуйста, способ разместить на кнопке подпись "RIGHT" полностью.
        right.setIcon(new javax.swing.ImageIcon("pics/right_triangle.png"));

        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.printToLog("Right button pressed\n");
            }
        });
        add(right);

        JButton emptyButton4 = new JButton();
        emptyButton4.setBackground(Color.WHITE);
        add(emptyButton4);

        down = new JButton("DOWN");
        down.setIcon(new javax.swing.ImageIcon("pics/down_triangle.png"));

        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.printToLog("Down button pressed\n");
            }
        });
        add(down);
        JButton emptyButton5 = new JButton();
        emptyButton5.setBackground(Color.WHITE);
        add(emptyButton5);
    }
}
