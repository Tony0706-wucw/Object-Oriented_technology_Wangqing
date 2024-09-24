package com.example;
import java.util.*;

public class Sudoku {
    private int[][] board;

    // Constructor
    public Sudoku(String input) {
        this.board = new int[9][9];
        boardInitialize(input);
    }

    // Initialize board
    private void boardInitialize(String input) {
        for (int i = 0; i < 81; i++) {
            board[i / 9][i % 9] = Character.getNumericValue(input.charAt(i)); // char->int
        }
    }

    // Clone
    @Override
    public Sudoku clone() {
        Sudoku clone = new Sudoku(this.toString());
        return clone;
    }

    // Serialization, turning the board into a series of numbers
    public String serialize() {
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) { // Iterate through each line of the board
            for (int num : row) { // Iterate through each number in each row
                sb.append(num);
            }
        }
        return sb.toString();
    }

    // Externalization, turning a string of numbers into a board
    public static Sudoku deserialize(String data) {
        return new Sudoku(data);
    }

    // Find the numbers that can be filled in the blanks
    public List<Integer> getCandidates(int row, int col) {
        // If the numbers have been filled in, there is no need to find candidate numbers.
        if (board[row][col] != 0)
            return Collections.emptyList();

        boolean[] used = new boolean[10]; // 0-9
        // There are no repeated numbers 0-9 in each column, each row, and each 3*3 square.
        for (int i = 0; i < 9; i++) {
            used[board[row][i]] = true;
            used[board[i][col]] = true;
            used[board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3]] = true;
        }

        List<Integer> candidates = new ArrayList<>();
        for (int num = 1; num <= 9; num++) {
            if (!used[num])
                candidates.add(num);
        }
        return candidates;
    }

    @Override
    public boolean equals(Object obj) {
        // The same memory address means the same Sudoku
        if (this == obj) 
            return true;

        // Different types must be different 
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        // Different from equals, it will recursively compare the contents of multi-dimensional arrays
        Sudoku sudoku = (Sudoku) obj;
        return Arrays.deepEquals(board, sudoku.board); 
    }

    // print the board
    public void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
