import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BingoCard {
    private Random rn;

    public static final int LENGTH = 6;

    private int[][] card;

    private int count;

    private int winners;

    private BingoCardObj[] bingoCards;

    public BingoCard(int s, int a) throws IOException {
        this.bingoCards = new BingoCardObj[a];
        int seed = 1;
        this.count = 0;
        this.rn = new Random(s);
        for (int i = 0; i < a; i++)
            refill();
    }

    public BingoCard(int s, int a, int w) throws IOException {
        this.bingoCards = new BingoCardObj[a];
        int seed = 1;
        this.count = 0;
        this.rn = new Random(s);
        this.winners = w;
        for (int i = 0; i < a; i++)
            refill();
    }

    public BingoCardObj[] getBingoCards() {
        return this.bingoCards;
    }

    public int getAmtWinners() {
        return this.winners;
    }

    public int getPos(int x, int y) {
        if (x >= this.card.length || y >= this.card.length)
            return -1;
        return this.card[x][y];
    }

    public void refill() {
        this.card = new int[5][5];
        ArrayList<Integer> alreadyUsed = new ArrayList<>();
        boolean valid = false;
        int tmp = 0;
        int i;
        for (i = 0; i <= 4; i++) {
            for (int row = 0; row < this.card.length; row++)
                this.card[row][i] = 0;
        }
        for (i = 0; i <= 4; i++) {
            for (int row = 0; row < this.card.length; row++) {
                while (!valid) {
                    tmp = this.rn.nextInt(15) + 1 + 15 * i;
                    if (!alreadyUsed.contains(Integer.valueOf(tmp))) {
                        valid = true;
                        alreadyUsed.add(Integer.valueOf(tmp));
                    }
                }
                this.card[row][i] = tmp;
                valid = false;
            }
        }
        this.card[2][2] = 0;
        this.bingoCards[this.count] = new BingoCardObj(this.count, this.card);
        this.count++;
    }
}
