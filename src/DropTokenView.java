/*
Copyright 2018. Written by Timothy Nguyen
 */

/**
 * Displays game information to the players through the command-line terminal
 */
public class DropTokenView {
    /**
     * Prints an entire board to the command line.
     * @param board A 2-D int array where 1 represents player 1's tokens and 2 player 2's tokens.
     *              0 represents no tokens. Columns are the outer array, Rows the inner array
     */
    public void printBoard(int[][] board) {
        for(int row = board.length - 1; row >= 0; row--) {
            String currLine = "|";
            for(int col = 0; col < board.length; col++) {
                currLine += " " + board[col][row];
            }
            System.out.println(currLine);
        }
        System.out.println("+--------");
        System.out.println("  1 2 3 4");
    }

    /**
     * Prints a sequence of given moves
     * @param moves An int array of moves into columns. First move in index 0 at column moves[0],
     *              Second move in index 1 into column moves[1] and so on...
     */
    public void printMoves(int[] moves) {
        for (int i : moves) {
            System.out.println(i);
        }
    }
}
