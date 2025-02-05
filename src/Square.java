import javax.swing.*;
import java.awt.*;
import java.text.AttributedCharacterIterator;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private TicTacToeViewer board;
    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer board) {
        this.row = row;
        this.col = col;
        this.board = board;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g) {
        if (isWinningSquare) {
            g.setColor(Color.GREEN);
            g.fillRect(board.SQUARE_LENGTH * (col + 1), board.SQUARE_LENGTH * (row + 1), board.SQUARE_LENGTH, board.SQUARE_LENGTH);
        }
        g.setColor(Color.black);
        g.drawRect(board.SQUARE_LENGTH * (row + 1), board.SQUARE_LENGTH * (col + 1), board.SQUARE_LENGTH, board.SQUARE_LENGTH);
        if (marker.equals("O")) {
            g.drawImage(board.getoImage(), board.SQUARE_LENGTH * (col + 1), board.SQUARE_LENGTH * (row + 1), board.SQUARE_LENGTH, board.SQUARE_LENGTH, board);
        }
        else if (marker.equals("X")) {
            g.drawImage(board.getxImage(), board.SQUARE_LENGTH * (col + 1), board.SQUARE_LENGTH * (row + 1), board.SQUARE_LENGTH, board.SQUARE_LENGTH, board);
        }
    }
}

