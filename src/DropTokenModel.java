/*
Copyright 2018. Written by Timothy Nguyen
 */
import java.util.*;
/**
 * Contains the state for a game of 9dt or 98point6 drop token. This game is similar to
 * connect 4 played on a 4x4 board. Only 2 players can play.
 *
 * Moves can be made until a draw (when all spaces are filled and there is no winner) or
 * when a player has 4 tokens in a vertical, horizontal, or diagonal line.
 *
 * The history of every move made can be retrieved by using getMoves()
 *
 * Moves can be made into a certain column with putToken(int)
 *
 * The board state is retrieved with getBoard()
 *
 * And we can check a games is over with isGameOver()
 */
public class DropTokenModel {
    private static int BOARD_SIZE = 4;

    private List<List<Integer>> board;
    private boolean gameOver;
    private boolean playerOneTurn;
    private List<Integer> moves;

    /**
     * Constracts a {@code DropTokenModel} that maintains the state of a 98point6 drop token
     * game. No moves have been made.
     */
    public DropTokenModel() {
        board = new ArrayList<List<Integer>>();
        for(int i = 1; i <= BOARD_SIZE + 1; i++) {
            List<Integer> initialList = new ArrayList<>();
            initialList.add(-1);  // add dummy value to have indexing starting at 1
            board.add(initialList);
        }
        gameOver = false;
        playerOneTurn = true;
        moves = new ArrayList<>();
    }

    /**
     * Returns an array of columns in the order which tokens were played starting with
     * player 1 and alternating every turn with player 2.
     *
     * @return  the array of column numbers representing moves in order
     */
    public int[] getMoves() {
        int[] movesCopy = new int[moves.size()];
        int index = 0;
        for (int i : moves) {
            movesCopy[index] = i;
            index++;
        }
        return movesCopy;
    }

    /**
     * Put a token in column col for the current player. If the column is full of tokens,
     * return "ERROR". If the token fills the last spot on the board and there is no winner,
     * return "DRAW". If the token that is placed results in 4 in a row for the current player,
     * return "WIN". If the token was placed in a valid spot but there was no winner, return
     * "OK".
     *
     * @param col an int representing the column to place the current player's token
     * @return a String that is either "ERROR", "DRAW", "WIN", or "OK"
     */
    public String putToken(int col) {
        if (gameOver) {
            return "GAME OVER";
        }

        int player = playerOneTurn ? 1 : 2;

        List<Integer> column = board.get(col);
        if (column.size() == BOARD_SIZE + 1) {
            return "ERROR";
        }

        column.add(player);
        moves.add(col);

        // switch to other player for next turn
        playerOneTurn = !playerOneTurn;


        // check for wins at the added location...
        // check colum for win
        boolean colWin = true;
        boolean rowWin = true;
        boolean diagWin = true;

        // check colWin
        if (column.size() == BOARD_SIZE + 1) {
            for(int i = 1; i <= BOARD_SIZE; i++) {
                if (column.get(i) != player) {
                    colWin = false;
                    break;
                }
            }
        } else {
            colWin = false;
        }

        // check rowWin
        int row = column.size() - 1;
        for(int i = 1; i <= BOARD_SIZE; i++) {
            if (board.get(i).size() > row) {  // there exists a token in column i at row row
                if (board.get(i).get(row) != player) {  // that token does not match what was played
                    rowWin = false;
                    break;
                }
            } else {  // no token exists at column i, row row
                rowWin = false;
                break;
            }
        }

        // check diag
        boolean positiveDiagWin = true;
        boolean negativeDiagWin = true;
        if ((col == row) || (col + row == 1 + BOARD_SIZE)) {
            for(int i = 1; i <= BOARD_SIZE; i++) {
                column = board.get(i);
                if (column.size() > i) {  // check positive sloping diagonal
                    if (column.get(i) != player) {
                        positiveDiagWin = false;
                    }
                } else {
                    positiveDiagWin = false;
                }

                if (column.size() > BOARD_SIZE - i + 1) {  // check negative sloping diagonal
                    if (column.get(1 + BOARD_SIZE - i) != player) {
                        negativeDiagWin = false;
                    }
                } else {
                    negativeDiagWin = false;
                }
            }
            diagWin &= positiveDiagWin || negativeDiagWin;
        } else {
            diagWin = false;
        }

        boolean win = colWin || rowWin || diagWin;
        if (!win) {
            if (moves.size() == BOARD_SIZE * BOARD_SIZE) {
                gameOver = true;
                return "DRAW";
            } else {
                return "OK";
            }
        }
        gameOver = true;
        return "WIN";
    }

    /**
     * Returns a representation of the board
     * @return A 2-D int array where columns are the 1st index and rows the 2nd.
     *         A 1 in the array represents player 1's tokens and 2 is player 2's.
     *         A 0 means no token has been played there.
     */
    public int[][] getBoard() {
        int[][] boardCopy = new int[BOARD_SIZE][BOARD_SIZE];
        for(int i = 1; i <= BOARD_SIZE; i++) {
            List<Integer> currCol = board.get(i);
            for(int j = 1; j <= BOARD_SIZE; j++) {
                if (currCol.size() <= j) {   // indicates empty column
                    boardCopy[i-1][j-1] = 0;
                } else {
                    boardCopy[i-1][j-1] = currCol.get(j);
                }
            }
        }
        return boardCopy;
    }

    /**
     * A game is over if it is a draw or somebody has won
     * @return true if game is over, false otherwise
     */
    public boolean isGameOver() {
        return gameOver;
    }



}
