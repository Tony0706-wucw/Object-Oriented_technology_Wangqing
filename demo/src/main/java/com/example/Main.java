package com.example;

public class Main {
    public static void main(String[] args) {
        String input = "017903600000080000900000507072010430000402070064370250701000065000030000005601720";
        Sudoku sudoku = new Sudoku(input);
        sudoku.printBoard();
    }
}
