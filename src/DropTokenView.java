public class DropTokenView {

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

    public void printMoves(int[] moves) {
        for (int i : moves) {
            System.out.println(i);
        }
    }

    public void printPutResult(String result) {
        System.out.println(result);
    }
}
