package ru.geekbrains.hw7.model;

public class Player {

    private String name;
    private int hp;
    private int x;
    private int y;
    public static final int playerMoveUp = 8;
    public static final int playerMoveLeft = 4;
    public static final int playerMoveRight = 6;
    public static final int playerMoveDown = 2;
    private int totalWins = 0;

    public Player(String name) {
        this.name = name;
        hp = 100;
    }

    public void moveUp() {
        y -= 1;
    }

    public void moveDown() {
        y += 1;
    }

    public void moveLeft() {
        x -= 1;
    }

    public void moveRight() {
        x += 1;
    }

    public void decreaseHP(int value) {
        hp -= value;
    }

    public void increaseHP(int value) {
        hp += value;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void increaseTotalWins() {
       totalWins++;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getPosition() {
        return (x + 1) + ":" + (y + 1);
    }
}
