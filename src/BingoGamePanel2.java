import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BingoGamePanel2 extends JFrame {

    private Font GSBold;

    private Font DMRegular;

    private Font DMItalic;

    private Font JBExtraBold;

    private Font TWLightItalic;

    private BingoCardObj[] bingoCards;

    private int[][] board;

    private JPanel panel;

    private Random rn;

    private JTextArea textArea2;

    private boolean done;

    private Graphics cardGraphics;

    private ArrayList<Integer> drawnNumbers;

    private ArrayList<Integer> cardsWon;

    private int count;

    public BingoGamePanel2(BingoCard bc) {
        super("Bingo3");
        JFrame.setDefaultLookAndFeelDecorated(true);
        setResizable(true);
        setSize(1600, 900);
        try {
            this.JBExtraBold = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/JetBrainsMono-ExtraBold.ttf")).deriveFont(120.0F);
            this.DMItalic = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/DankMono-Italic.ttf")).deriveFont(40.0F);
            this.TWLightItalic = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/TitilliumWeb-LightItalic.ttf")).deriveFont(35.0F);
            this.DMRegular = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/DankMono-Regular.ttf")).deriveFont(25.0F);
            this.GSBold = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/Gill Sans Bold.otf")).deriveFont(12.0F);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(this.JBExtraBold);
            ge.registerFont(this.DMItalic);
            ge.registerFont(this.TWLightItalic);
            ge.registerFont(this.DMRegular);
            ge.registerFont(this.GSBold);
        } catch (IOException|java.awt.FontFormatException e) {
            e.printStackTrace();
        }
        this.bingoCards = bc.getBingoCards();
        this.count = 0;
        this.cardsWon = new ArrayList<>();
        this.drawnNumbers = new ArrayList<>();
        this.rn = new Random(75L);
        this.done = false;
        this.panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                BingoGamePanel2.this.cardGraphics = g;
                makePage(g);
                markNumbers(g);
                fillPage(g);
            }

            public void makePage(Graphics g) {
                Graphics2D card = (Graphics2D)g;
                card.setColor(new Color(238, 153, 37));
                card.drawRect(0, 0, 500, 625);
                card.setColor(new Color(229, 233, 240));
                card.setFont(BingoGamePanel2.this.GSBold);
                int x = BingoGamePanel2.this.count + 1;
                card.drawString("#" + x, 0, 620);
                card.setColor(new Color(238, 153, 37));
                card.drawRect(0, 100, 500, 500);
                card.setColor(new Color(238, 153, 37));
                int i;
                for (i = 100; i < 301; i += 200) {
                    card.setColor(new Color(238, 153, 37));
                    g.drawRect(i, 100, 100, 100);
                    g.drawRect(i, 300, 100, 100);
                    g.drawRect(i, 500, 100, 100);
                }
                for (i = 0; i < 401; i += 200) {
                    g.drawRect(i, 200, 100, 100);
                    g.drawRect(i, 400, 100, 100);
                }
                g.setColor(new Color(194, 98, 28));
                g.fillOval(205, 305, 90, 90);
                card.setColor(new Color(229, 233, 240));
                card.setFont(BingoGamePanel2.this.JBExtraBold);
                card.drawString("B", 13, 93);
                card.drawString("I", 113, 93);
                card.drawString("N", 213, 93);
                card.drawString("G", 313, 93);
                card.drawString("O", 410, 93);
                card.setFont(BingoGamePanel2.this.DMItalic);
                card.drawString("FREE", 205, 365);
            }

            public void markNumbers(Graphics g) {
                int[][] card = BingoGamePanel2.this.bingoCards[BingoGamePanel2.this.count].getBoard();
                for (int r = 1; r <= 5; r++) {
                    for (int c = 0; c < 5; c++) {
                        if (BingoGamePanel2.this.drawnNumbers.contains(Integer.valueOf(card[r - 1][c]))) {
                            g.setColor(new Color(194, 98, 28));
                            g.fillOval(c * 100 + 5, r * 100 + 5, 90, 90);
                        }
                    }
                }
            }

            public void fillPage(Graphics g) {
                g.setFont(BingoGamePanel2.this.DMItalic);
                BingoGamePanel2.this.board = BingoGamePanel2.this.bingoCards[BingoGamePanel2.this.count].getBoard();
                try {
                    for (int i = 0; i < 5; i++) {
                        for (int j = 1; j < 6; j++) {
                            if (i != 2 || j != 3) {
                                g.setColor(new Color(229, 233, 240));
                                g.drawString(String.valueOf(BingoGamePanel2.this.board[j - 1][i]), i * 100 + 25, j * 100 + 65);
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "You are missing an argument! \nPlease go back and enter a number!", "Missing Arguments!", 0);
                }
            }
        };
        this.panel.setSize(500, 625);
        add(this.panel);
        JPanel comps = new JPanel();
        GridLayout layout = new GridLayout(0, 2);
        setLayout(layout);
        GridLayout components = new GridLayout(8, 0);
        comps.setLayout(components);
        components.setVgap(15);
        comps.setSize(500, 625);
        comps.setBorder(BorderFactory.createEmptyBorder(0, 30, 30, 30));
        add(comps);
        JLabel label = new JLabel();
        label.setSize(300, 15);
        label.setLocation(600, 15);
        label.setFont(this.TWLightItalic);
        label.setText("Bingo Card Number:");
        comps.add(label);
        SpinnerModel model = new SpinnerNumberModel(1, 1, this.bingoCards.length, 1);
        JSpinner spinner = new JSpinner(model);
        JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor)spinner.getEditor();
        spinnerEditor.getTextField().setHorizontalAlignment(2);
        spinner.setBounds(800, 100, 250, 30);
        spinner.setSize(new Dimension(150, 30));
        comps.add(spinner);
        JLabel label2 = new JLabel();
        label2.setSize(300, 100);
        label2.setLocation(600, 15);
        label2.setFont(this.TWLightItalic);
        label2.setText("Drawn Numbers:");
        comps.add(label2);
        final JTextArea textArea = new JTextArea();
        textArea.setSize(400, 400);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setVisible(true);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(22);
        scroll.setHorizontalScrollBarPolicy(32);
        textArea.setSize(new Dimension(500, 300));
        comps.add(scroll);
        JLabel label3 = new JLabel();
        label3.setSize(300, 100);
        label3.setLocation(600, 15);
        label3.setFont(this.TWLightItalic);
        label3.setText("Cards Won:");
        comps.add(label3);
        this.textArea2 = new JTextArea();
        this.textArea2.setSize(400, 400);
        this.textArea2.setLineWrap(true);
        this.textArea2.setEditable(false);
        this.textArea2.setVisible(true);
        JScrollPane scroll2 = new JScrollPane(this.textArea2);
        scroll2.setVerticalScrollBarPolicy(22);
        scroll2.setHorizontalScrollBarPolicy(32);
        this.textArea2.setSize(new Dimension(500, 300));
        comps.add(scroll2);
        JLabel label4 = new JLabel();
        label4.setSize(300, 100);
        label4.setLocation(600, 15);
        label4.setFont(this.TWLightItalic);
        label4.setText("Draw a Number:");
        comps.add(label4);
        JButton draw = new JButton("Click");
        draw.setLocation(235, 210);
        draw.setSize(130, 30);
        comps.add(draw);
        setResizable(false);
        setVisible(true);
        draw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (BingoGamePanel2.this.done)
                    return;
                if (BingoGamePanel2.this.drawnNumbers.size() == 75) {
                    BingoGamePanel2.this.done = true;
                    textArea.append("\nAll out of numbers!");
                    return;
                }
                boolean valid = false;
                int tmp = 0;
                while (!valid) {
                    tmp = BingoGamePanel2.this.rn.nextInt(75) + 1;
                    if (!BingoGamePanel2.this.drawnNumbers.contains(Integer.valueOf(tmp)))
                        valid = true;
                }
                if (BingoGamePanel2.this.drawnNumbers.contains(Integer.valueOf(tmp)))
                    System.out.println("how");
                BingoGamePanel2.this.drawnNumbers.add(Integer.valueOf(tmp));
                BingoGamePanel2.this.checkWin();
                System.out.println(tmp);
                textArea.append(String.valueOf(tmp) + "   ");
                BingoGamePanel2.this.panel.repaint();
            }
        });
        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                BingoGamePanel2.this.count = Integer.parseInt("" + ((JSpinner)e.getSource()).getValue()) - 1;
                BingoGamePanel2.this.panel.repaint();
            }
        });
    }

    public void checkWin() {
        for (int i = 0; i < this.bingoCards.length; i++) {
            int[][] card = this.bingoCards[i].getBoard();
            if (!this.cardsWon.contains(Integer.valueOf(i)) && ((this.drawnNumbers
                    .contains(Integer.valueOf(card[0][0])) && this.drawnNumbers.contains(Integer.valueOf(card[0][1])) && this.drawnNumbers.contains(Integer.valueOf(card[0][2])) && this.drawnNumbers.contains(Integer.valueOf(card[0][3])) && this.drawnNumbers.contains(Integer.valueOf(card[0][4]))) || (this.drawnNumbers
                    .contains(Integer.valueOf(card[1][0])) && this.drawnNumbers.contains(Integer.valueOf(card[1][1])) && this.drawnNumbers.contains(Integer.valueOf(card[1][2])) && this.drawnNumbers.contains(Integer.valueOf(card[1][3])) && this.drawnNumbers.contains(Integer.valueOf(card[1][4]))) || (this.drawnNumbers
                    .contains(Integer.valueOf(card[2][0])) && this.drawnNumbers.contains(Integer.valueOf(card[2][1])) && this.drawnNumbers.contains(Integer.valueOf(card[2][3])) && this.drawnNumbers.contains(Integer.valueOf(card[2][4]))) || (this.drawnNumbers
                    .contains(Integer.valueOf(card[3][0])) && this.drawnNumbers.contains(Integer.valueOf(card[3][1])) && this.drawnNumbers.contains(Integer.valueOf(card[3][2])) && this.drawnNumbers.contains(Integer.valueOf(card[3][3])) && this.drawnNumbers.contains(Integer.valueOf(card[3][4]))) || (this.drawnNumbers
                    .contains(Integer.valueOf(card[4][0])) && this.drawnNumbers.contains(Integer.valueOf(card[4][1])) && this.drawnNumbers.contains(Integer.valueOf(card[4][2])) && this.drawnNumbers.contains(Integer.valueOf(card[4][3])) && this.drawnNumbers.contains(Integer.valueOf(card[4][4]))) || (this.drawnNumbers
                    .contains(Integer.valueOf(card[0][0])) && this.drawnNumbers.contains(Integer.valueOf(card[1][0])) && this.drawnNumbers.contains(Integer.valueOf(card[2][0])) && this.drawnNumbers.contains(Integer.valueOf(card[3][0])) && this.drawnNumbers.contains(Integer.valueOf(card[4][0]))) || (this.drawnNumbers
                    .contains(Integer.valueOf(card[0][1])) && this.drawnNumbers.contains(Integer.valueOf(card[1][1])) && this.drawnNumbers.contains(Integer.valueOf(card[2][1])) && this.drawnNumbers.contains(Integer.valueOf(card[3][1])) && this.drawnNumbers.contains(Integer.valueOf(card[4][1]))) || (this.drawnNumbers
                    .contains(Integer.valueOf(card[0][2])) && this.drawnNumbers.contains(Integer.valueOf(card[1][2])) && this.drawnNumbers.contains(Integer.valueOf(card[3][2])) && this.drawnNumbers.contains(Integer.valueOf(card[4][2]))) || (this.drawnNumbers
                    .contains(Integer.valueOf(card[0][3])) && this.drawnNumbers.contains(Integer.valueOf(card[1][3])) && this.drawnNumbers.contains(Integer.valueOf(card[2][3])) && this.drawnNumbers.contains(Integer.valueOf(card[3][3])) && this.drawnNumbers.contains(Integer.valueOf(card[4][3]))) || (this.drawnNumbers
                    .contains(Integer.valueOf(card[0][4])) && this.drawnNumbers.contains(Integer.valueOf(card[1][4])) && this.drawnNumbers.contains(Integer.valueOf(card[2][4])) && this.drawnNumbers.contains(Integer.valueOf(card[3][4])) && this.drawnNumbers.contains(Integer.valueOf(card[4][4]))) || (this.drawnNumbers
                    .contains(Integer.valueOf(card[0][0])) && this.drawnNumbers.contains(Integer.valueOf(card[1][1])) && this.drawnNumbers.contains(Integer.valueOf(card[3][3])) && this.drawnNumbers.contains(Integer.valueOf(card[4][4]))) || (this.drawnNumbers
                    .contains(Integer.valueOf(card[0][4])) && this.drawnNumbers.contains(Integer.valueOf(card[1][3])) && this.drawnNumbers.contains(Integer.valueOf(card[3][1])) && this.drawnNumbers.contains(Integer.valueOf(card[4][0]))))) {
                this.textArea2.append("" + i + 1 + "   ");
                this.cardsWon.add(Integer.valueOf(i));
            }
        }
    }
}
