import comp124graphics.CanvasWindow;
import comp124graphics.GraphicsText;
import comp124graphics.Rectangle;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TicTacToe extends CanvasWindow implements MouseListener, MouseMotionListener{

    public static final int CANVAS_WIDTH = 800;
    public static final int CANVAS_HEIGHT = 900;

    private Rectangle button;
    private GraphicsText text;
    private Square square;

    private int numX, numO;
    private char mark;
    private char[] turn = {'X', 'O'};
    private int turnCounter = 0;

    public TicTacToe(String title, int width, int height){
        super(title, width, height);
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe("Tic Tac Toe", CANVAS_WIDTH, CANVAS_HEIGHT);
        game.newGame();
    }

    private void newGame(){
        for(int i = 0; i < 9; i++) {
            if (turn[i] == 'X') {
                mark = 'X';
                numX++;
            }
            if (turn[i] == 'O') {
                mark = 'O';
                numO++;
            }
        }
        newGameButton();
    }

    private char changeTurn(){
        return turn[turnCounter % turn.length];
    }

    public boolean checkCat(){
        return numX == numO;
    }

    public char checkWin(){
        if(!checkCat()) {
            if (numX > numO)
                return 'X';
            else
                return 'O';
        }
        return 'C';
    }

    public void newGameButton(){
        button = new Rectangle(710, 10, 80, 30);
        button.setFillColor(Color.cyan);
        button.setFilled(true);

        text = new GraphicsText("New Game", 715, 30);

        add(button);
        add(text);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX() >= button.getX() && e.getY() <= button.getY()) {
            System.out.println("clicked");
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(e.getX() <= square.getX())
            square.highlight(true);
        if(square.canMark())
            square.makeMark(mark);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
}
