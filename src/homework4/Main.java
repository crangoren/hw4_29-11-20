package homework4;


import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X, DOTS_TO_WIN)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O, DOTS_TO_WIN)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb, int toWin) {

        for (int i = 0; i < SIZE; i++) {
            int counter = 0;
            for (int j = 0; j < SIZE; j++) {

                if (map[i][j] == symb) {
                    counter++;


                }
            } if (counter == DOTS_TO_WIN) {
                return true;
            }
        }

        for (int j = 0; j < SIZE; j++) {
            int counter = 0;
            for (int i = 0; i < SIZE; i++) {

                if (map[i][j] == symb) {
                    counter++;
                }
            } if (counter == DOTS_TO_WIN) {
                return true;
            }

        }

        int diagonalFromLeft = 0;
        for (int i = 0, j = 0; i < SIZE; i++, j++) {

            if (map[i][j] == symb) {
                diagonalFromLeft++;

            } if (diagonalFromLeft == DOTS_TO_WIN) {
                return true;
            }
        }

//        int diagonalFromLeft1 = 0;
//        for (int i = 0, j; i < SIZE; i++) {
//            for (int k = 0; k < SIZE; k++) {
//                j = k;
//                if (map[i][j] == symb) {
//                    diagonalFromLeft1++;
//
//                }
//                if (diagonalFromLeft1 == DOTS_TO_WIN) {
//                    return true;
//                }
//            }
//        }

        int diagonalFromRight = 0;
        for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {

            if (map[i][j] == symb) {
                diagonalFromRight++;

            } if (diagonalFromRight == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
//        int diagonalFromRight1 = 0;
//        for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
//            for (int k = SIZE - 1; k > 0; k--) {
//                j = k;
//                if (map[i][j] == symb) {
//                diagonalFromRight1++;
//
//            } if (diagonalFromRight1 == DOTS_TO_WIN) {
//                return true;
//            }
//        }

//        if(map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
//        if(map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
//        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
//        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
//        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
//        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
//        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void initMap() { //инициализ поля
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) { //х
            for (int j = 0; j < SIZE; j++) { //у
                map[i][j] = DOT_EMPTY; // заполнение точками поля
            }
        }
    }
    public static void printMap() { // печать поля
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

