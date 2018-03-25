import comp124graphics.GraphicsGroup;
import comp124graphics.GraphicsText;
import comp124graphics.Rectangle;

import java.awt.Color;
import java.awt.Graphics2D;

public class Square extends GraphicsGroup {

    private enum State {
        rest, highlighted, pressed
    }

    /**
     * The character representing no mark on a square
     */
    private static final char BLANK_MARK = ' ';
    private static final Color REST = new Color(200,200,200);
    private static final Color HIGHLIGHTED = new Color(80,80,80);
    private static final Color PRESSED = new Color(160,160,160);

    private final Rectangle square;
    private final GraphicsText label;
    private State state = State.rest;
    private char mark = BLANK_MARK;

    /**
     * Makes a new square object at x, y with width and height
     * and a blank mark
     *
     * @param x x position for square
     * @param y y position for square
     * @param width width of square
     * @param height height of square
     */
    public Square(double x, double y, double width, double height) {
        super(x, y);

        square = new Rectangle(x, y, width, height);
        label = new GraphicsText(
                markToString(),
                (float)(x + width/3),
                (float)(y + height/3));

        square.setFilled(true);
    }

    @Override
    public void draw(Graphics2D gc) {
        super.draw(gc);

        removeAll();

        square.setFillColor(currentColor());

        add(square);
        add(label);
    }

    /**
     * Proper background color for the square with
     * regards to its state
     *
     * @return the color for the state of the square
     */
    private Color currentColor() {
        switch (state) {
            case rest:
                return REST;
            case highlighted:
                return HIGHLIGHTED;
            case pressed:
                return PRESSED;
        }
        throw new IllegalStateException("state field not properly set " + state);
    }

    /**
     * Highlights this square (for when the cursor's on it)
     *
     * @param doHighlight true if highlighted
     */
    public void highlight(boolean doHighlight) {
        if (!canMark()) return;

        state = doHighlight? State.highlighted : State.rest;
    }

    /**
     * Sets the mark on this square to be mark,
     * makes the square unplayable until cleared
     *
     * @param mark char representing the mark
     */
    public void makeMark(char mark) {
        this.mark = mark;
        label.setText(markToString());
        state = State.pressed;
    }

    private String markToString() {
        return "" + mark;
    }

    /**
     * Returns true if this square can be played on
     *
     * @return true if the square can be played on
     */
    public boolean canMark() {
        return getMark() == BLANK_MARK;
    }

    /**
     * Returns the character representing the
     * mark on this square
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
    }
}
