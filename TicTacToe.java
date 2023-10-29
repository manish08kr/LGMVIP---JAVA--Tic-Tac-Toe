import java.util.Scanner;

public class TicTacToe {

    private static char[] board = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        printBoard();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = scanner.nextInt() - 1;

            if (move >= 0 && move < 9 && board[move] == ' ') {
                board[move] = currentPlayer;
                printBoard();

                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (checkDraw()) {
                    System.out.println("It's a draw!");
                    break;
                }

                switchPlayer();
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    private static void printBoard() {
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("-----------");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("-----------");
        System.out.println(" 7 | 8 | 9 ");
        System.out.println();
        for (int i = 0; i < 9; i++) {
            System.out.print(board[i]);
            if (i % 3 == 2) {
                System.out.println();
            } else {
                System.out.print(" | ");
            }
        }
    }

    private static boolean checkWin() {
        int[][] winningCombination = {
                { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, // rows
                { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, // columns
                { 0, 4, 8 }, { 2, 4, 6 } // diagonals
        };

        for (int[] combination : winningCombination) {
            if (board[combination[0]] == currentPlayer &&
                    board[combination[1]] == currentPlayer &&
                    board[combination[2]] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDraw() {
        for (char cell : board) {
            if (cell == ' ') {
                return false;
            }
        }
        return true;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
