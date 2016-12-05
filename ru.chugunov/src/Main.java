import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final char[][] gameTable = new char[][]{
            {'#', '#', '#'},
            {'#', '#', '#'},
            {'#', '#', '#'}
    };

    public static int moves = 0;

    public static void showTable() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(gameTable[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void enemyMove() {
        int x = (int) (Math.random() * 3);
        int y = (int) (Math.random() * 3);
        while (gameTable[x][y] == 'O' || gameTable[x][y] == 'X') {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
        }
        gameTable[x][y] = 'X';

        showTable();
        moves++;
        System.out.println("Ход № " + moves);
        System.out.println();
    }

    public static void yourMove() {

        boolean d = true;
        while (d == true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Ваш ход! Введите координату Х: ");
                int a = scanner.nextInt() - 1;
                System.out.print("Ваш ход! Введите координату Y: ");
                int b = scanner.nextInt() - 1;


                if ((a >= 0 && a < 3) && (b >= 0 && b < 3) && (gameTable[b][a] != 'X') && (gameTable[b][a] != 'O')) {
                    gameTable[b][a] = 'O';
                    break;
                }


                while (a != 0 || a != 1 || a != 2 || b != 0 || b != 1 || b != 2) {

                    System.out.println("Нужно задать корректные координаты!");
                    System.out.println("Введите заново координату Х: ");
                    a = scanner.nextInt() - 1;
                    System.out.println("Введите заново координату Y: ");
                    b = scanner.nextInt() - 1;

                    if (a >= 0 && a < 3 && b >= 0 && b < 3 && (gameTable[b][a] != 'X') && (gameTable[b][a] != 'O')) {
                        gameTable[b][a] = 'O';
                        d = false;
                        break;
                    }

                }
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели недопустимые символы!");
                continue;
            }
        }

        showTable();

        moves++;
        System.out.println("Ход № " + moves);
        System.out.println();
    }

    public static void main(String[] args) {

        boolean gameContinues = true;
        char winner = ' ';

        while (gameContinues == true) {
            enemyMove();
            yourMove();

            if(moves>9) {
                gameContinues = false;
            }

            for (int n = 0; n < 3; n++) {
                if (gameTable[n][0] == gameTable[n][1] && gameTable[n][1] == gameTable[n][2]
                        && gameTable[n][0] != '#') {
                    winner = gameTable[n][0];
                    gameContinues = false;
                    break;
                }
            }

            for (int n = 0; n < 3; n++) {
                if (gameTable[0][n] == gameTable[1][n] && gameTable[1][n] == gameTable[2][n]
                        && gameTable[0][n] != '#') {
                    winner = gameTable[0][n];
                    gameContinues = false;
                    break;
                }
            }

            if (gameTable[0][0] == gameTable[1][1] && gameTable[1][1] == gameTable[2][2]
                    && gameTable[0][0] != '#') {
                winner = gameTable[0][0];
                gameContinues = false;
                break;
            }

            if (gameTable[0][2] == gameTable[1][1] && gameTable[1][1] == gameTable[2][0]
                    && gameTable[0][2] != '#') {
                winner = gameTable[0][2];
                gameContinues = false;
                break;
            }

        }

        if (gameContinues == false)
            if (winner == 'X') {
                System.out.println("Вы проиграли :(");
            } else if (winner == 'O') {
                System.out.println("Вы выйграли!");
            } else if (winner == ' ') {
                System.out.println("Ничья!");

            }
    }
}