
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BingoBoard extends JPanel {
    private BingoCard bc;
    private int count;
    private BingoCardObj[] bingoCardObjs;
    private int seed;
    private int amount;
    private String formattedDate;
    private String dir;

    public BingoBoard(int s, int a) throws IOException {
        this.seed = s;
        this.amount = a;
        this.count = 0;
        try {
            this.bc = new BingoCard(this.seed, a);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("error");
        }
        this.bingoCardObjs = this.bc.getBingoCards();
        paint(getGraphics());
    }

    public void makePage(Graphics g2, BufferedImage image) {
        g2.setColor(new Color(0, 0, 0));
        g2.drawRect(0, 0, 500, 625);
        g2.setColor(new Color(229, 233, 240));
        g2.drawString("#" + this.count + 1, 0, 620);
        g2.setColor(new Color(255, 255, 255));
        g2.setColor(new Color(255, 255, 255));
        int i;
        for (i = 100; i < 301; i += 200) {
            g2.drawRect(i, 100, 100, 100);
            g2.drawRect(i, 300, 100, 100);
            g2.drawRect(i, 500, 100, 100);
        }
        for (i = 0; i < 401; i += 200) {
            g2.drawRect(i, 200, 100, 100);
            g2.drawRect(i, 400, 100, 100);
        }
        g2.setColor(new Color(229, 233, 240));
        g2.drawString("B", 13, 93);
        g2.drawString("I", 113, 93);
        g2.drawString("N", 213, 93);
        g2.drawString("G", 313, 93);
        g2.drawString("O", 410, 93);
        g2.drawString("FREE", 205, 365);
        int[][] board = this.bingoCardObjs[this.count].getBoard();
        for (i = 0; i < 5; i++) {
            for (int x = 1; x < 6; x++) {
                if (i != 2 || x != 3)
                    g2.drawString(String.valueOf(board[x - 1][i]), i * 100 + 5, x * 100 + 78);
            }
        }
        this.count++;
        g2.setColor(new Color(0, 0, 0));
        g2.drawRect(600, 0, 500, 625);
        g2.setColor(new Color(229, 233, 240));
        g2.drawString("#" + this.count + 1, 600, 620);
        g2.setColor(new Color(255, 255, 255));
        g2.drawRect(600, 100, 500, 500);
        g2.setColor(new Color(255, 255, 255));
        g2.drawRect(600, 200, 100, 100);
        g2.drawRect(600, 400, 100, 100);
        g2.drawRect(700, 100, 100, 100);
        g2.drawRect(700, 300, 100, 100);
        g2.drawRect(700, 500, 100, 100);
        g2.drawRect(800, 200, 100, 100);
        g2.drawRect(800, 400, 100, 100);
        g2.drawRect(900, 100, 100, 100);
        g2.drawRect(900, 300, 100, 100);
        g2.drawRect(900, 500, 100, 100);
        g2.drawRect(1000, 200, 100, 100);
        g2.drawRect(1000, 400, 100, 100);
        g2.setColor(new Color(229, 233, 240));
        g2.drawString("B", 613, 93);
        g2.drawString("I", 713, 93);
        g2.drawString("N", 813, 93);
        g2.drawString("G", 913, 93);
        g2.drawString("O", 1010, 93);
        g2.drawString("FREE", 805, 365);
        board = this.bingoCardObjs[this.count].getBoard();
        for (i = 0; i < 5; i++) {
            for (int x = 1; x < 6; x++) {
                if (i != 2 || x != 3)
                    g2.drawString(String.valueOf(board[x - 1][i]), i * 100 + 605, x * 100 + 78);
            }
        }
        this.count++;
        g2.setColor(new Color(0, 0, 0));
        g2.drawRect(0, 700, 500, 625);
        g2.setColor(new Color(229, 233, 240));
        g2.drawString("#" + this.count + 1, 0, 1320);
        g2.setColor(new Color(255, 255, 255));
        g2.drawRect(0, 800, 500, 500);
        g2.setColor(new Color(255, 255, 255));
        g2.drawRect(0, 900, 100, 100);
        g2.drawRect(0, 1100, 100, 100);
        g2.drawRect(100, 800, 100, 100);
        g2.drawRect(100, 1000, 100, 100);
        g2.drawRect(100, 1200, 100, 100);
        g2.drawRect(200, 900, 100, 100);
        g2.drawRect(200, 1100, 100, 100);
        g2.drawRect(300, 800, 100, 100);
        g2.drawRect(300, 1000, 100, 100);
        g2.drawRect(300, 1200, 100, 100);
        g2.drawRect(400, 900, 100, 100);
        g2.drawRect(400, 1100, 100, 100);
        g2.setColor(new Color(229, 233, 240));
        g2.drawString("B", 13, 793);
        g2.drawString("I", 113, 793);
        g2.drawString("N", 213, 793);
        g2.drawString("G", 313, 793);
        g2.drawString("O", 410, 793);
        g2.drawString("FREE", 205, 1065);
        board = this.bingoCardObjs[this.count].getBoard();
        for (i = 0; i < 5; i++) {
            for (int x = 1; x < 6; x++) {
                if (i != 2 || x != 3)
                    g2.drawString(String.valueOf(board[x - 1][i]), i * 100 + 5, x * 100 + 778);
            }
        }
        this.count++;
        g2.setColor(new Color(0, 0, 0));
        g2.drawRect(600, 700, 500, 625);
        g2.setColor(new Color(229, 233, 240));
        g2.drawString("#" + this.count + 1, 600, 1320);
        g2.setColor(new Color(255, 255, 255));
        g2.drawRect(600, 800, 500, 500);
        g2.setColor(new Color(255, 255, 255));
        g2.drawRect(600, 900, 100, 100);
        g2.drawRect(600, 1100, 100, 100);
        g2.drawRect(700, 800, 100, 100);
        g2.drawRect(700, 1000, 100, 100);
        g2.drawRect(700, 1200, 100, 100);
        g2.drawRect(800, 900, 100, 100);
        g2.drawRect(800, 1100, 100, 100);
        g2.drawRect(900, 800, 100, 100);
        g2.drawRect(900, 1000, 100, 100);
        g2.drawRect(900, 1200, 100, 100);
        g2.drawRect(1000, 900, 100, 100);
        g2.drawRect(1000, 1100, 100, 100);
        g2.setColor(new Color(229, 233, 240));
        g2.drawString("B", 613, 793);
        g2.drawString("I", 713, 793);
        g2.drawString("N", 813, 793);
        g2.drawString("G", 913, 793);
        g2.drawString("O", 1010, 793);
        g2.drawString("FREE", 805, 1065);
        board = this.bingoCardObjs[this.count].getBoard();
        for (i = 0; i < 5; i++) {
            for (int x = 1; x < 6; x++) {
                if (i != 2 || x != 3)
                    g2.drawString(String.valueOf(board[x - 1][i]), i * 100 + 605, x * 100 + 778);
            }
        }
        this.count++;
        try {
            ImageIO.write(image, "png", new File(this.dir + "/card" + this.dir + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        BufferedImage image = new BufferedImage(1100, 1325, 2);
        Graphics g2 = image.getGraphics();
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
        this.formattedDate = localDate.format(myFormatObj);
        System.out.println(this.formattedDate);
        String lettuce = String.valueOf(((new File("BingoCards/")).listFiles()).length + 1);
        this.dir = "BingoCards/cards";
        File theDir = new File(this.dir);
        theDir.mkdirs();
        for (int i = 0; i < this.amount; i += 4) {
            makePage(g2, image);
            System.out.println(i);
        }
    }
}
