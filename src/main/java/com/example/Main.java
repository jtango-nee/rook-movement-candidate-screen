package com.example;

import java.util.Random;

/*
--------------------------------------------------------------------------------
A Rook can move horizontally or vertically on a Chess Board (an 8x8 grid).
This code checks if it is possible or not for a Rook to reach a given
destination in a single move from its current position. If found to be true,
it prints “POSSIBLE” otherwise, it prints “NOT POSSIBLE”.
It handles other checks, such as invalid positions and same positions as well.
--------------------------------------------------------------------------------
Write a Unit Test against the method "check" that uses the following Positions:
[1,2] & destination: [6,1]. This should be an impossible move, but the code
is returning "POSSIBLE". Then, identify the bug that causes the code to
return POSSIBLE when it should not be a possible move and, refactor this code
to ensure maximum maintainability and readability by humans who will maintain
this code in the future.
--------------------------------------------------------------------------------
Instructions for refactoring:
- Ensure working code before refactoring, fix the bug first.
- Strive for readability and maintainability over code performance
- Use Domain Language where it makes sense to do so.
- Extract classes and methods to provide better / meaningful names
--------------------------------------------------------------------------------
*/

class RookMovement {
    // Function to validate if the position is on a standard 8x8 chessboard
    static boolean validPosition(int row, int col) {
        return row >= 1 && row <= 8 && col >= 1 && col <= 8;
    }

    // Function to generate a random position on the chessboard
    static int[] generateRandomPosition() {
        Random random = new Random();
        return new int[]{random.nextInt(8) + 1, random.nextInt(8) + 1};
    }

    // Function to check if it is possible to reach the destination in a single move by a rook
    static String check(int current_row, int current_col, int destination_row, int destination_col) {
        if (!validPosition(current_row, current_col) || !validPosition(destination_row, destination_col)) {
            return "INVALID POSITION(S)";
        }
        if (current_row == destination_row || current_row == destination_col) {
            if (destination_row == current_row && destination_col == current_col) {
                return "SAME POSITION";
            }
            return "POSSIBLE";
        }
        return "NOT POSSIBLE";
    }

    // Enhanced Driver code
    public static void main(String[] args) {
        int current_row = 1;
        int current_col = 2;
        int[] destination = {6, 1};
        String output = check(current_row, current_col, destination[0], destination[1]);
        System.out.println(output);
    }

}
