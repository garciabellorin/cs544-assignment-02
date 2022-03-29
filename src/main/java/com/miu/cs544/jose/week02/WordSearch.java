package com.miu.cs544.jose.week02;

import java.util.Arrays;

public class WordSearch {

    public static int findCoincidences(char[][] puzzle, String word) {
        int counter = 0;
        //1. Create words - only search horizontally (first scenario)
        //second scenario - Create words vertically (you do this)
        //third scenario - find words diagonally (forward diagonal and reverse diagonal) (you do this)
        counter += countHorizontalWords(puzzle, word);
        counter += countVerticalWords(puzzle, word);
        counter += countSecondaryDiagonal(puzzle, word);

        System.out.println(Arrays.deepToString(puzzle));
        return counter;
    }

    private static int countSecondaryDiagonal(char[][] puzzle, String word) {
        int counter = 0;
        int column = 0;
        int row = 0;
        int aux = 0;


       while(column < puzzle[0].length){
           StringBuilder sb = new StringBuilder();
           for (int i = row; i < puzzle[0].length && aux < puzzle.length; i++) {
               sb.append(puzzle[aux][i]);
               aux++;
           }
           row++;
       }
        System.out.println("Expected: sos, oo, ss, o" );
        //soso
        //soos
        //ssss

////I am stuck here with diagonal logic
//        while (row < puzzle.length && column < puzzle[0].length) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = column; i < puzzle[0].length; i++) {
//                sb.append(puzzle[i][i]);
//            }
//            column++;
//            System.out.println(sb.toString());
//        }

        return counter;
    }

    private static int countVerticalWords(char[][] puzzle, String word) {
        int counter = 0;
        int column = 0;
        int row = 0;

        while (column < puzzle[0].length) {
            StringBuilder sb = new StringBuilder();
            while (row < puzzle.length) {
                sb.append(puzzle[row][column]);
                row++;
            }
            if (word.equals(sb.toString())) {
                counter++;
            }
            row = 0;
            column++;
        }
        return counter;
    }

    public static int countHorizontalWords(char[][] puzzle, String word) {
        int counter = 0;
        for (int i = 0; i < puzzle.length; i++) {
            String w = String.valueOf(puzzle[i]);
            for (int j = 0; j < w.length(); j++) {
                if (w.length() >= j + word.length()) {
                    if (word.equals(w.substring(j, j + word.length()))) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }


    public static void main(String[] args) {
        char[][] puzzleArray = new char[][]{
                {'s', 'o', 's', 'o'},
                {'s', 'o', 'o', 's'},
                {'s', 's', 's', 's'},
        };
        /**
         * based on puzzle array:
         * horizontal words are: soso, soos, ssss 1 sos here
         * vertical words are: sss, oos, sos, oss 1 sos here
         * diagonal forward: sos, oos, ss, o 1 sos here
         * diagonal backwards: oos, sos, os, s 1 sos here NOT CONSIDERED
         * expected output
         *
         * to traverse horizontally is natural
         * for (int i = 0; i < allWords.size(); i++) { //traverse all words we found
         *     String w = allWords.get(i);
         *     }
         *
         * to traverse vertically
         *
         */
        String word = "sos";

        System.out.println("coincidences: " + findCoincidences(puzzleArray, word));
    }
}
