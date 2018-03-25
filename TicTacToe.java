import comp124graphics.CanvasWindow;

public class TicTacToe extends CanvasWindow {

    private static final int CANVAS_WIDTH = 800;
    public static final int CANVAS_HEIGHT = 900;
    private int numX, numO;

    public TicTacToe(String title, int width, int height){
        super(title, width, height);
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe("Tic Tac Toe", CANVAS_WIDTH, CANVAS_HEIGHT);
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

    public void newGame(){

    }
}
