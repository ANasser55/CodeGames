package com.catatoes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String word = read.next();

        char[][] grid = new char[10][10];
        int[][] location = new int[100][2];
        int n = 0; //number of letters that match the first letter in the word
        boolean f = false;


        //search for the first letter
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    location[n][0] = i;
                    location[n][1] = j;
                    n++;
                }
            }
        }

        for (int i = 0; i < n; i++) {

            //searching horizontally left to right
            for (int k = 1; k < word.length(); k++) {
                if (!(grid[(location[i][0] + k) % 10][location[i][1]] == word.charAt(k))) {
                    break;
                } else if (word.length() - 1 == k) {
                    f = true;
                    System.out.println("Found horizontally, left to right at index: " + location[i][0] + ", " + location[i][1]);
                    break;
                }
            }

            //searching horizontally right to left
            for (int k = 1; k < word.length(); k++) {
                if (!(grid[((location[i][0] + k) % 10) - (((location[i][0] + k) % 10) - 1)][location[i][1]] == word.charAt(k))) {
                    break;
                } else if (word.length() - 1 == k) {
                    f = true;
                    System.out.println("Found horizontally, right to left at index: " + location[i][0] + ", " + location[i][1]);
                    break;
                }
            }

            //searching vertically downwards
            for (int k = 1; k < word.length(); k++) {
                if (!(grid[location[i][0]][(location[i][1] + k) % 10] == word.charAt(k))) {
                    break;
                } else if (word.length() - 1 == k) {
                    f = true;
                    System.out.println("Found vertically, up to down at index: " + location[i][0] + ", " + location[i][1]);
                    break;
                }
            }

            //searching vertically upwards
            for (int k = 1; k < word.length(); k++) {
                if (!(grid[location[i][0]][((location[i][1] + k) % 10) - (((location[i][1] + k) % 10) - 1)] == word.charAt(k))) {
                    break;
                } else if (word.length() - 1 == k) {
                    f = true;
                    System.out.println("Found vertically, bottom to top at index: " + location[i][0] + ", " + location[i][1]);
                    break;
                }
            }

            //searching diagonally
            for (int k = 1; k < word.length(); k++) {
                if (!(grid[(location[i][0] + k)][(location[i][1] + k)] == word.charAt(k))) {
                    break;
                } else if (word.length() - 1 == k) {
                    f = true;
                    System.out.println("Found diagonally at index: " + location[i][0] + ", " + location[i][1]);
                    break;
                }
            }
        }

        if (!f) {
            System.out.println("NOT FOUND :(");
        }
    }
}

