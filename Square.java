import comp124graphics.GraphicsGroup;
import comp124graphics.GraphicsText;
import comp124graphics.Rectangle;

public class Square extends GraphicsGroup {

    /**
     * The character representing no mark on a square
     */
    public static final char BLANK_MARK = ' ';

    private final Rectangle square;
    private final GraphicsText label;
    private char mark = BLANK_MARK;

    /**
     * Makes a new square object at x, y with width and height
     * and a blank mark
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Square(double x, double y, double width, double height) {
        super(x, y);

        square = new Rectangle(x, y, width, height);
        label = new GraphicsText("" + mark, (float)x, (float)y);
    }

    /**
     * Highlights this square (for when the cursor's on it)
     *
     * @param doHighlight true if highlighted
     */
    public void highlight(boolean doHighlight) {
        //TODO
    }

    /**
     * Sets the mark on this square to be mark,
     * makes the square unplayable until cleared
     *
     * @param mark char representing the mark
     */
    public void makeMark(char mark) {
        //TODO
    }

    /**
     * Returns true if this square can be played on
     *
     * @return true if the squre can be played on
     */
    public boolean canMark() {
        return getMark() == BLANK_MARK;
    }

    /**
     * Returns the mark on this square
     *
     * @return mark on the square
     */
    public char getMark() {
        return mark;
    }

    /**
     * Resets this square to the new game state
     */
    public void resetSquare() {
        makeMark(BLANK_MARK);
        //TODO
    }
}
