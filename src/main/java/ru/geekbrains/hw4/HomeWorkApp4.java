package ru.geekbrains.hw4;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

// добавить переход на следующий уровень с сохранением здоровья
// добавить ячейки, восполняющие здоровье

public class HomeWorkApp4 {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    //Map
    public static char[][] map;
    public static int mapWight;
    public static int mapHeight;
    public static int mapSizeMin = 3;
    public static int mapSizeMax = 6;
    public static char empty = '_';
    public static char ready = '*';

    //Player
    public static char player = '@';
    public static String playerName = "Inna";
    public static int playerHP = 100;
    public static int playerX;
    public static int playerY;
    public static final int playerMoveUp = 8;
    public static final int playerMoveLeft = 4;
    public static final int playerMoveRight = 6;
    public static final int playerMoveDown = 2;
    public static int totalWins = 0;

    //Trap
    public static char trap = 'T';
    public static int trapAttack;
    public static int trapCount;
    public static int trapValueMin = 5;
    public static int trapValueMax = 15;

    //Cure
    public static char cure = 'C';
    public static int curePower;
    public static int cureCount;
    public static int cureValueMin = 5;
    public static int cureValueMax = 15;


    public static void main(String[] args) {
        System.out.println("WELCOME TO THE GAME!");
        int levelCount = 1;
        do{
            if(playLevel()) {
                totalWins++;
                System.out.println("Player " + playerName + " won level " + levelCount + ". Player's HP is " + playerHP);
            }
            else System.out.println("Player " + playerName + " lost level " + levelCount + ". Player's HP is " + playerHP);

            System.out.println("Current score is "+ totalWins +" won/"+ (levelCount - totalWins) + " lost." + " Do you want to play another level? (yes/no)");
            String playMore = scanner.next();
            switch(playMore){
                case "yes":
                    levelCount++;
                    continue;
                case "no":
                    System.out.println("GAME OVER");
                    return;
            }
        }while(true);
    }

        // для добавления нескольких уровней игры вынесем прохождение одного уровня в отдельный метод
    public static boolean playLevel(){
        createMap();
        spawnPlayer();
        spawnTrap();
        spawnCure();


        while (true) {
            showMap();
            movePlayer();

            if (!isPlayerAlive()) {
                System.out.println(playerName + " is dead");
                return false;
            }

            if (isFullMap()) {
                System.out.println(playerName + " wins this map");
                return true;
            }
        }
    }

        public static void createMap() {
            mapWight = randomValue(mapSizeMin, mapSizeMax);
            mapHeight = randomValue(mapSizeMin, mapSizeMax);
            map = new char[mapHeight][mapWight];

            for (int y = 0; y < mapHeight; y++) {
                for (int x = 0; x < mapWight; x++) {
                    map[y][x] = empty;
                }
            }

            System.out.println("Map has been created. Map size is " + mapWight + "x" + mapHeight);
        }

        // добавлено скрытие ловушек, игрок на карте видит пустые ячейки и ячейки с ловушками одинаково
        public static void showMap() {
            System.out.println("==========> MAP <==========");
            for (int y = 0; y < mapHeight; y++) {
                for (int x = 0; x < mapWight; x++) {
                    if(map[y][x] == trap || map[y][x] == cure) System.out.print(empty + "|");
                    else System.out.print(map[y][x] + "|");
                }
                System.out.println();
            }
            System.out.println("===========================");
        }

        public static void spawnPlayer() {
            playerX = randomValue(0, mapWight - 1);
            playerY = randomValue(0, mapHeight - 1);
            map[playerY][playerX] = player;
            System.out.println(playerName + " has spawn in [" + (playerX + 1) + ":" + (playerY + 1) + "]");
        }

    public static void spawnTrap() {
        // изменен рассчет урона от ловушки, чтобы повысить вероятность не пройти уровень
        trapCount = (mapWight + mapHeight) / 2;
        trapAttack = randomValue(trapValueMin, playerHP/trapCount + trapValueMax);


        int trapX;
        int trapY;

        for (int i = 1; i <= trapCount; i++) {

            do {
                trapX = random.nextInt(mapWight);
                trapY = random.nextInt(mapHeight);
            } while (!isEmpty(trapX, trapY));

            map[trapY][trapX] = trap;
        }
        System.out.println(trapCount + " traps created. Trap's Attack = " + trapAttack);
    }

    public static void spawnCure() {
        // добавление ячеек, увеличивающих здоровье игрока, чтобы продлить игру
        cureCount = randomValue(1, trapCount);
        curePower = randomValue(cureValueMin, cureValueMax);

        int cureX;
        int cureY;

        for (int i = 1; i <= cureCount; i++) {

            do {
                cureX = random.nextInt(mapWight);
                cureY = random.nextInt(mapHeight);
            } while (!isEmpty(cureX, cureY));

            map[cureY][cureX] = cure;
        }
        System.out.println(cureCount + " cures created. Cure's Power = " + curePower);
    }


    public static void movePlayer() {

        int currentPlayerX = playerX;
        int currentPlayerY = playerY;

        int playerDestination;

        do {
            System.out.print("Enter your move: (Up: " + playerMoveUp + " | Down: " + playerMoveDown +
                        " | Left: " + playerMoveLeft + " | Right: " + playerMoveRight + ") >>> ");

            playerDestination = scanner.nextInt();

            switch (playerDestination) {
                case playerMoveUp:
                    playerY -= 1;
                    break;
                case playerMoveDown:
                    playerY += 1;
                    break;
                case playerMoveLeft:
                    playerX -= 1;
                    break;
                case playerMoveRight:
                    playerX += 1;
                    break;
            }

        } while (!checkValidMove(currentPlayerX, currentPlayerY, playerX, playerY));

        playerMoveAction(currentPlayerX, currentPlayerY, playerX, playerY);

    }

    public static boolean isEmpty(int x, int y) {
            return map[y][x] == empty;
        }

    // добавлена проверка на оставшиеся на карте ловушки, карта не считается пройденной, если
    // есть пустые ячейки, непройденные ловушки или несобранное исцеление
    public static boolean isFullMap() {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWight; x++) {
                if (map[y][x] == empty || map[y][x] == trap || map[y][x] == cure) return false;
            }
        }
        return true;
    }

        public static boolean checkValidMove(int pastX, int pastY, int nextX, int nextY) {
            if (nextX >= 0 && nextX < mapWight && nextY >= 0 && nextY < mapHeight) {
                System.out.println(playerName + " move to [" + (nextX + 1) + ":" + (nextY + 1) + "] success");
                return true;
            } else {
                System.out.println(playerName + " move is invalid! Please try again!");
                playerX = pastX;
                playerY = pastY;
                return false;
            }
        }

        public static void playerMoveAction(int pastX, int pastY, int nextX, int nextY) {
            if (map[nextY][nextX] == trap) {
                playerHP -= trapAttack;
                trapCount--;
                System.out.println("Alarm! " + playerName + " has been attacked. HP = " + playerHP);
            }

            if (map[nextY][nextX] == cure) {
                playerHP += curePower;
                cureCount--;
                System.out.println(playerName + " found a cure! HP = " + playerHP);
            }
            map[nextY][nextX] = player;
            map[pastY][pastX] = ready;

        }

        public static int randomValue(int min, int max) {
            return min + random.nextInt(max - min + 1);
        }

        public static boolean isPlayerAlive() {
            return playerHP > 0;
        }

}


