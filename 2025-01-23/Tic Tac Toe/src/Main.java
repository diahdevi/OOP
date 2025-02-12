import java.util.Scanner;

public class Main {
    private static final int SIZE = 3;
    private static char[][] board = new char[SIZE][SIZE];
    private static char currentPlayer = 'O';

    public static void main(String[] args) {
        initializeBoard();
        playGame();
    }

    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
        int moves = 0;

        while (!gameWon && moves < SIZE * SIZE) {
            System.out.print("Player " + (currentPlayer == 'O' ? "1 (O)" : "2 (X)") + ", enter your move (row and column): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (isValidMove(x, y)) {
                board[x][y] = currentPlayer;
                printBoard();
                moves++;

                if (checkWin(x, y)) {
                    System.out.println("Player " + (currentPlayer == 'O' ? "1 (O)" : "2 (X)") + " wins!");
                    gameWon = true;
                } else {
                    currentPlayer = (currentPlayer == 'O') ? 'X' : 'O';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        if (!gameWon) {
            System.out.println("It's a draw!");
        }

        scanner.close();
    }

    private static boolean isValidMove(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE && board[x][y] == '-';
    }

    private static boolean checkWin(int x, int y) {
        return checkRow(x) || checkColumn(y) || checkDiagonals();
    }

    private static boolean checkRow(int row) {
        for (int j = 0; j < SIZE; j++) {
            if (board[row][j] != currentPlayer) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkColumn(int col) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] != currentPlayer) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDiagonals() {
        boolean diagonal1 = true;
        boolean diagonal2 = true;

        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] != currentPlayer) {
                diagonal1 = false;
            }
            if (board[i][SIZE - 1 - i] != currentPlayer) {
                diagonal2 = false;
            }
        }

        return diagonal1 || diagonal2;
    }
}
