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
    public static final int MARGIN = CANVAS_WIDTH / 15;

    private Rectangle button;
    private GraphicsText text;
    private Square[][] squares;

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
        int y = MARGIN;
        for(int i = 0; i < 3; i++){
            int x = MARGIN;
            for(int j = 0; j < 3; j++){
                add(squares[i][j] = new Square(x, y));
                x += Square.SIDE_LENGTH + MARGIN;
            }
            y += Square.SIDE_LENGTH + MARGIN;
        }
        mark = changeTurn();
        newGameButton();
    }

    private char changeTurn(){
        return turn[turnCounter % turn.length];
    }

    private boolean checkCat(){
        return turnCounter == 9 && checkWin() == Square.BLANK_MARK;
    }

    private char checkWin(){
        for (int i = 0; i < 3; i++){
            if (checkRow(i) != Square.BLANK_MARK)
                return checkRow(i);
            if (checkColumn(i) != Square.BLANK_MARK)
                return checkColumn(i);
        }
        char center = getMarkAt(1, 1);
        if (center == Square.BLANK_MARK) return Square.BLANK_MARK;
        if ((getMarkAt(0, 0) == center && getMarkAt(2, 2) == center) ||
                (getMarkAt(0, 2) == center && getMarkAt(2, 0) == center))
            return center;
        return Square.BLANK_MARK;
    }

    private char checkRow(int rowPos){
        if (getMarkAt(rowPos, 0) == getMarkAt(rowPos, 1) &&
                getMarkAt(rowPos, 0) == getMarkAt(rowPos, 2))
            return getMarkAt(rowPos, 0);
        return Square.BLANK_MARK;
    }

    private char checkColumn(int colPos){
        if (getMarkAt(0, colPos) == getMarkAt(1, colPos) &&
                getMarkAt(0, colPos) == getMarkAt(2, colPos))
            return getMarkAt(0, colPos);
        return Square.BLANK_MARK;
    }

    private char getMarkAt(int rowPos, int colPos){
        return squares[rowPos][colPos].getMark();
    }

    private void newGameButton(){
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
//        if(e.getX() <= square.getX())
//            square.highlight(true);
//        if(square.canMark())
//            square.makeMark(mark);
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
