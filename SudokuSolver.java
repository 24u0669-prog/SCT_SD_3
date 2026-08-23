import java.util.Scanner;

/**
 * SudokuSolver.java
 * ------------------
 * Solves a 9x9 Sudoku puzzle automatically using a backtracking algorithm.
 *
 * Input format:
 *   The unsolved grid is represented as a 9x9 int array.
 *   Empty cells are represented by 0.
 *
 * Algorithm:
 *   Backtracking (constraint satisfaction):
 *   1. Find the next empty cell.
 *   2. Try placing digits 1-9 in that cell.
 *   3. For each digit, check if it's valid (not repeated in the same
 *      row, column, or 3x3 sub-grid).
 *   4. If valid, place it and recursively try to solve the rest of the grid.
 *   5. If a later step fails, backtrack (undo the placement) and try the
 *      next digit.
 *   6. If no digit works, backtrack further up the recursion tree.
 */
public class SudokuSolver {

    private static final int SIZE = 9;       // 9x9 grid
    private static final int BOX_SIZE = 3;   // 3x3 sub-grid
    private static final int EMPTY = 0;
    public static void main(String[] args) {

        // ---- Sample unsolved Sudoku puzzle (0 = empty cell) ----
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println("Unsolved Sudoku Puzzle:");
        printBoard(board);

        long startTime = System.nanoTime();

        if (solveSudoku(board)) {
            long endTime = System.nanoTime();
            System.out.println("\nSolved Sudoku Puzzle:");
            printBoard(board);
            System.out.printf("%nSolved in %.3f ms%n", (endTime - startTime) / 1_000_000.0);
        } else {
            System.out.println("\nNo solution exists for the given puzzle.");
        }

        // Optionally allow the user to input their own puzzle
        // Uncomment the line below to enable manual input mode instead of the sample.
        // int[][] userBoard = readBoardFromUser();
    }

    /**
     * Solves the Sudoku board in-place using backtracking.
     * @param board the 9x9 grid (0 = empty cell)
     * @return true if a solution was found, false otherwise
     */
    public static boolean solveSudoku(int[][] board) {
        int[] emptyCell = findEmptyCell(board);

        // No empty cells left -> puzzle solved
        if (emptyCell == null) {
            return true;
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        for (int digit = 1; digit <= SIZE; digit++) {
            if (isValidPlacement(board, row, col, digit)) {
                board[row][col] = digit;

                if (solveSudoku(board)) {
                    return true; // Success — propagate back up
                }

                board[row][col] = EMPTY; // Backtrack
            }
        }

        return false; // Trigger backtracking in the caller
    }

    /**
     * Finds the next empty cell (value == 0), scanning row by row.
     * @return int[]{row, col} of the empty cell, or null if none remain.
     */
    private static int[] findEmptyCell(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    /**
     * Checks whether placing 'digit' at board[row][col] is valid
     * according to Sudoku rules (unique in row, column, and 3x3 box).
     */
    private static boolean isValidPlacement(int[][] board, int row, int col, int digit) {
        // Check row and column simultaneously
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == digit || board[i][col] == digit) {
                return false;
            }
        }

        // Check the 3x3 box
        int boxRowStart = (row / BOX_SIZE) * BOX_SIZE;
        int boxColStart = (col / BOX_SIZE) * BOX_SIZE;

        for (int r = boxRowStart; r < boxRowStart + BOX_SIZE; r++) {
            for (int c = boxColStart; c < boxColStart + BOX_SIZE; c++) {
                if (board[r][c] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Prints the Sudoku board in a readable grid format with box separators.
     */
    private static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            if (row % BOX_SIZE == 0 && row != 0) {
                System.out.println("------+-------+------");
            }
            for (int col = 0; col < SIZE; col++) {
                if (col % BOX_SIZE == 0 && col != 0) {
                    System.out.print("| ");
                }
                System.out.print((board[row][col] == EMPTY ? "." : board[row][col]) + " ");
            }
            System.out.println();
        }
    }

    /**
     * Reads a 9x9 Sudoku grid from user input (space-separated digits,
     * one row per line, 0 for empty cells). Useful for custom puzzles.
     */
    private static int[][] readBoardFromUser() {
        int[][] board = new int[SIZE][SIZE];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Sudoku grid row by row (9 numbers per row, 0 for empty):");
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = scanner.nextInt();
            }
        }
        return board;
    }
}