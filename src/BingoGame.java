import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class BingoGame extends JFrame {
    private Dimension size;

    private Container win;

    private JPanel buttonPanel;

    private JPanel buttonPanel2;

    private JButton button;

    private JButton button2;

    private JLabel input;

    private JLabel input2;

    private JLabel input3;

    private JLabel heading;

    private JTextField inputField;

    private JTextField inputFieldTwo;

    private JTextField inputFieldThree;

    private Font TWBlack;

    private Font TWBold;

    private Font GSBold;

    private Font DMRegular;

    private Font DMRegular2;

    private Font DMItalic;

    private Font JBExtraBold;

    private Font TWBoldItalic;

    private Font TWExtraLight;

    private Font TWExtraLightItalic;

    private Font TWItalic;

    private Font TWLight;

    private Font TWLightItalic;

    private Font TWRegular;

    private Font TWSemiBold;

    private Font TWSemiBoldItalic;

    public BingoGame() throws IOException {
        super("Start Menu");
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.size = new Dimension(600, 500);
        setSize(this.size);
        setPreferredSize(this.size);
        setMinimumSize(this.size);
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            this.TWBlack = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/TitilliumWeb-Black.ttf")).deriveFont(12.0F);
            this.TWBold = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/TitilliumWeb-Bold.ttf")).deriveFont(12.0F);
            this.TWBoldItalic = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/TitilliumWeb-BoldItalic.ttf")).deriveFont(12.0F);
            this.TWExtraLight = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/TitilliumWeb-ExtraLight.ttf")).deriveFont(12.0F);
            this.TWExtraLightItalic = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/TitilliumWeb-ExtraLightItalic.ttf")).deriveFont(12.0F);
            this.TWItalic = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/TitilliumWeb-Italic.ttf")).deriveFont(12.0F);
            this.TWLight = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/TitilliumWeb-Light.ttf")).deriveFont(12.0F);
            this.TWLightItalic = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/TitilliumWeb-LightItalic.ttf")).deriveFont(12.0F);
            this.TWRegular = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/TitilliumWeb-Regular.ttf")).deriveFont(30.0F);
            this.TWSemiBold = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/TitilliumWeb-SemiBold.ttf")).deriveFont(12.0F);
            this.TWSemiBoldItalic = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/TitilliumWeb-SemiBoldItalic.ttf")).deriveFont(24.0F);
            this.JBExtraBold = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/JetBrainsMono-ExtraBold.ttf")).deriveFont(24.0F);
            this.DMItalic = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/DankMono-Italic.ttf")).deriveFont(12.0F);
            this.DMRegular = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/DankMono-Regular.ttf")).deriveFont(24.0F);
            this.DMRegular2 = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/DankMono-Regular.ttf")).deriveFont(12.0F);
            this.GSBold = Font.createFont(0, getClass().getClassLoader().getResourceAsStream("resources/Gill Sans Bold.otf")).deriveFont(24.0F);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(this.TWBlack);
            ge.registerFont(this.TWBold);
            ge.registerFont(this.TWBoldItalic);
            ge.registerFont(this.TWExtraLight);
            ge.registerFont(this.TWExtraLightItalic);
            ge.registerFont(this.TWItalic);
            ge.registerFont(this.TWLight);
            ge.registerFont(this.TWLightItalic);
            ge.registerFont(this.TWRegular);
            ge.registerFont(this.TWSemiBold);
            ge.registerFont(this.TWSemiBoldItalic);
            ge.registerFont(this.JBExtraBold);
            ge.registerFont(this.DMItalic);
            ge.registerFont(this.DMRegular);
            ge.registerFont(this.GSBold);
        } catch (IOException|java.awt.FontFormatException e) {
            System.out.println("Error");
        }
        this.win = getContentPane();
        this.win.setLayout((LayoutManager)null);
        this.input = new JLabel("Game Code*");
        this.input.setSize(100, 20);
        this.input.setLocation(20, 180);
        this.win.add(this.input);
        this.input2 = new JLabel("Number of Cards*");
        this.input2.setSize(150, 20);
        this.input2.setLocation(getWidth() / 2 - 60, 180);
        this.win.add(this.input2);
        this.input3 = new JLabel("Number of Winners");
        this.input3.setSize(150, 20);
        this.input3.setLocation(getWidth() - 140, 180);
        this.win.add(this.input3);
        this.heading = new JLabel("Bingo", 0);
        this.heading.setSize(80, 65);
        this.heading.setLocation(getWidth() / 2 - 45, 20);
        SpinnerModel value = new SpinnerNumberModel(0, 0, 10000, 1);
        final JSpinner jSpinner = new JSpinner(value);
        jSpinner.setBounds(getWidth() / 2 - 60, 150, 100, 30);
        this.buttonPanel = new JPanel();
        this.buttonPanel.setLocation(125, 370);
        this.buttonPanel.setSize(100, 30);
        this.button = new JButton("Print Cards");
        this.button.setLocation(125, 370);
        this.button.setSize(100, 30);
        this.win.add(this.buttonPanel);
        this.buttonPanel.add(this.button);
        this.buttonPanel2 = new JPanel();
        this.buttonPanel2.setLocation(250, 370);
        this.buttonPanel2.setSize(130, 30);
        this.button2 = new JButton("Play Simulation");
        this.button2.setLocation(235, 370);
        this.button2.setSize(130, 30);
        this.win.add(this.buttonPanel2);
        this.buttonPanel2.add(this.button2);
        this.win.add(jSpinner);
        this.win.add(this.heading);
        this.input2.setFont(this.TWLightItalic);
        this.input3.setFont(this.TWLightItalic);
        this.heading.setFont(this.TWRegular);
        this.input.setFont(this.TWLightItalic);
        this.inputField = new JTextField("", 10);
        this.inputField.setSize(100, 30);
        this.inputField.setLocation(20, 150);
        this.win.add(this.inputField);
        this.inputFieldThree = new JTextField("", 10);
        this.inputFieldThree.setSize(100, 30);
        this.inputFieldThree.setLocation(getWidth() - 140, 150);
        this.win.add(this.inputFieldThree);
        setDefaultCloseOperation(3);
        setVisible(true);
        setResizable(false);
        this.button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BingoGame.this.button = (JButton)e.getSource();
                String seed = BingoGame.this.inputField.getText();
                int amount = ((Integer)jSpinner.getValue()).intValue();
                try {
                    if (amount == 0)
                        throw new NumberFormatException();
                    BingoBoard bingoBoard = new BingoBoard(Integer.parseInt(seed), Math.round((amount / 4)) * 4 + 4);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(BingoGame.this.getContentPane(), "You are missing an argument! \nPlease go back and enter a number!", "Missing Arguments!", 0);
                    throw ex;
                }
                BingoGame.this.dispose();
                System.out.println("Frame Closed.");
            }
        });
        this.button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BingoGame.this.button2 = (JButton)e.getSource();
                String seed = BingoGame.this.inputField.getText();
                String winners = BingoGame.this.inputFieldThree.getText();
                int amount = ((Integer)jSpinner.getValue()).intValue();
                try {
                    if (seed.isBlank())
                        throw new NumberFormatException();
                    if (winners.isBlank())
                        throw new NumberFormatException();
                    if (amount == 0)
                        throw new NumberFormatException();
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(BingoGame.this.getContentPane(), "You are missing an argument! \nPlease go back and enter a number!", "Missing Arguments!", 0);
                    throw ex;
                }
                BingoCard bc = null;
                try {
                    bc = new BingoCard(Integer.parseInt(seed), amount);
                    (new BingoGamePanel2(bc)).setVisible(true);
                } catch (IOException ex) {
                    System.out.println("It's me");
                    ex.printStackTrace();
                }
                BingoGame.this.setVisible(false);
                System.out.println("Frame Closed.");
            }
        });
    }
}
