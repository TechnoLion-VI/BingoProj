public class BingoCardObj {
    private int[][] board;

    private boolean won;

    private int roundWon;

    private int id;

    public BingoCardObj(int x, int[][] b) {
        this.id = x;
        this.board = b;
    }

    public void setWon(boolean b, int x) {
        this.won = b;
        this.roundWon = x;
    }

    public int[][] getBoard() {
        return this.board;
    }
}
