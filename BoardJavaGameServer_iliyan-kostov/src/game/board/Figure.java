package game.board;

import javafx.scene.control.Tooltip;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;

/**
 * Клас за фигурите в играта.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public class Figure {

    /**
     * координати на фигурата в рамките на дъската
     */
    public BoardCoords boardCoords;

    /**
     * собственик на фигурата
     */
    public final String username;
    
    private final ImagePattern imagePattern;
    private final Tooltip t;

    public Figure(BoardCoords boardCoords, String username,ImagePattern imagePattern,String t) {
        this.boardCoords = new BoardCoords(boardCoords.row, boardCoords.col);
        this.username = username;
        this.imagePattern = imagePattern;
        this.t= new Tooltip(t);
    }

	public Paint getImagePattern() {
		return this.imagePattern;
	}
	
	public Tooltip getTooltip(){
		return this.t;
	}
}
