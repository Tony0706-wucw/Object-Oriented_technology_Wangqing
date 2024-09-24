package com.example;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;


public class SudokuTest {
    @Test
    public void testInitialization() {
        String input =
                "017903600000080000900000507072010430000402070064370250701000065000030000005601720";
        Sudoku sudoku = new Sudoku(input);
        assertEquals(input, sudoku.toString());
    }

    @Test
    public void testClone() {
        String input =
                "017903600000080000900000507072010430000402070064370250701000065000030000005601720";
        Sudoku sudoku = new Sudoku(input);
        Sudoku clone = sudoku.clone();
        assertEquals(sudoku, clone); // Call the equals method of the Sudoku class
    }

    @Test
    public void testSerialization() {
        String input =
                "017903600000080000900000507072010430000402070064370250701000065000030000005601720";
        Sudoku sudoku = new Sudoku(input);
        String serialized = sudoku.serialize();
        Sudoku deserialized = new Sudoku(serialized);
        assertEquals(sudoku, deserialized); // Call the equals method of the Sudoku class
    }

    @Test
    public void testGetCandidates() {
        String input =
                "017903600000080000900000507072010430000402070064370250701000065000030000005601720";
        Sudoku sudoku = new Sudoku(input);
        List<Integer> candidates = sudoku.getCandidates(0, 0);
        List<Integer> expected = Arrays.asList(2, 4, 5, 8);
        assertEquals(candidates, expected);
    }
}
