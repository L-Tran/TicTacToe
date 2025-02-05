import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 500;
    public static final int SQUARE_LENGTH = 100;
    public final int TITLE_BAR_HEIGHT = 23;
    private  Image xImage, oImage;
    private TicTacToe game;

    public TicTacToeViewer(TicTacToe game) {

        this.game = game;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        createBufferStrategy(2);

        xImage = new ImageIcon("Resources/X.png").getImage();
        oImage = new ImageIcon("Resources/O.png").getImage();
    }

    public Image getxImage() {
        return xImage;
    }

    public Image getoImage() {
        return oImage;
    }

    public void setxImage(Image xImage) {
        this.xImage = xImage;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(Color.black);
        for(int i = 0; i < game.getBoard().length; i++) {
            g.setColor(Color.RED);
            Font stringFont = new Font( "PLAIN", Font.ITALIC, 18 );
            g.setFont(stringFont);
            g.drawString(Integer.toString(i), SQUARE_LENGTH * (i + 1) + SQUARE_LENGTH / 2, SQUARE_LENGTH / 2 + TITLE_BAR_HEIGHT);
            g.drawString(Integer.toString(i), SQUARE_LENGTH / 2, SQUARE_LENGTH * (i + 1) + SQUARE_LENGTH / 2 + TITLE_BAR_HEIGHT);
            g.setColor(Color.black);
            for(int j = 0; j < game.getBoard()[i].length; j++) {
                game.getBoard()[i][j].draw(g);
            }
        }
        if(game.getGameOver() == true) {
            Font stringFont = new Font( "PLAIN", Font.BOLD, 35 );
            g.setFont(stringFont);
            if (game.getWinner() == "O") {
                g.drawString("O Wins!", SQUARE_LENGTH  + SQUARE_LENGTH, SQUARE_LENGTH * 4 + SQUARE_LENGTH / 2);
            }
            else if (game.getWinner() == "X"){
                g.drawString("X Wins!", SQUARE_LENGTH  + SQUARE_LENGTH, SQUARE_LENGTH * 4 + SQUARE_LENGTH / 2);
            }
            else {
                g.drawString("It's a Tie!", SQUARE_LENGTH  + SQUARE_LENGTH, SQUARE_LENGTH * 4 + SQUARE_LENGTH / 2);
            }
        }
    }
}
