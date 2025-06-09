import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    static char[] board = {'1','2','3','4','5','6','7','8','9'};
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        // === Droid Hub Banner ===
        System.out.println("====================================");
        System.out.println("=== Tic Tac Toe ✖️⭕              ===");
        System.out.println("=== Rating: E (Everyone)          ===");
        System.out.println("=== Developed by:                 ===");
        System.out.println("=== Legendary Games Studios       ===");
        System.out.println("====================================\n");

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        while (true) {
            playerMove();
            printBoard();
            if (checkWin('X')) {
                System.out.println("You win! 🎉");
                break;
            }
            if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }

            aiMove();
            printBoard();
            if (checkWin('O')) {
                System.out.println("AI wins! 🤖");
                break;
            }
            if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }
        }

        System.out.println("Thanks for playing! 👋");
    }

    static void printBoard() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    static void playerMove() {
        int move;
        while (true) {
            System.out.print("Enter a number (1-9) to place your X: ");
            move = scanner.nextInt();
            if (move < 1 || move > 9) {
                System.out.println("Invalid number! Try again.");
            } else if (board[move - 1] == 'X' || board[move - 1] == 'O') {
                System.out.println("Spot already taken! Try again.");
            } else {
                board[move - 1] = 'X';
                break;
            }
        }
    }

    static void aiMove() {
        int move;
        while (true) {
            move = random.nextInt(9);
            if (board[move] != 'X' && board[move] != 'O') {
                board[move] = 'O';
                System.out.println("AI places O in position " + (move + 1));
                break;
            }
        }
    }

    static boolean checkWin(char player) {
        return (board[0] == player && board[1] == player && board[2] == player) ||
               (board[3] == player && board[4] == player && board[5] == player) ||
               (board[6] == player && board[7] == player && board[8] == player) ||
               (board[0] == player && board[3] == player && board[6] == player) ||
               (board[1] == player && board[4] == player && board[7] == player) ||
               (board[2] == player && board[5] == player && board[8] == player) ||
               (board[0] == player && board[4] == player && board[8] == player) ||
               (board[2] == player && board[4] == player && board[6] == player);
    }

    static boolean isBoardFull() {
        for (char c : board) {
            if (c != 'X' && c != 'O') return false;
        }
        return true;
    }
}