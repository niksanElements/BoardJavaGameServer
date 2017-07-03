package game.board;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;
import protocol.Message_Board_MoveFigures;
import test.BoardGame.controller.UserController;

public class Board_Clientside_Cell extends Polygon {

	/*
    // цветове за различните играчи:
    public static final ImagePattern[] COLOR_PLAYERS = 
    	{
    			Color.CRIMSON, 
    			Color.DARKORANGE, 
    			Color.DARKVIOLET, 
    			Color.FORESTGREEN, 
    			Color.MAGENTA, 
    			Color.MEDIUMBLUE
		};
	*/
    // цвят за дъската:
    public static final Color COLOR_BOARD = Color.LIGHTGOLDENRODYELLOW;
    // цвят на мрежата:
    public static final Color COLOR_GRID = Color.BLACK;

    // дължина на страната на триъгълника от мрежата:
    public static final double SIDE_3 = 50.;
    // дължина на страната на квадрата от мрежата:
    public static final double SIDE_4 = 50.;
    // дължина на страната на шестоъгълника от мрежата:
    public static final double SIDE_6 = 50.;
    // дебелина на линиите от мрежата:
    public static final double GRID_WIDTH = 1;

    // координати на върховете на триъгълника - с връх нагоре:
    public static final double[] COORDS_3_UP
            = {-Board_Clientside_Cell.SIDE_3 * 0.500, Board_Clientside_Cell.SIDE_3 * 0.433,
                Board_Clientside_Cell.SIDE_3 * 0.500, Board_Clientside_Cell.SIDE_3 * 0.433,
                0.000, -Board_Clientside_Cell.SIDE_3 * 0.433};
    // координати на върховете на триъгълника - с връх надолу:
    public static final double[] COORDS_3_DOWN
            = {-Board_Clientside_Cell.SIDE_3 * 0.500, - Board_Clientside_Cell.SIDE_3 * 0.433,
                Board_Clientside_Cell.SIDE_3 * 0.500, - Board_Clientside_Cell.SIDE_3 * 0.433,
                0.000, Board_Clientside_Cell.SIDE_3 * 0.433};
    // координати на върховете на квадрата
    public static final double[] COORDS_4
            = {-Board_Clientside_Cell.SIDE_4 * 0.500, Board_Clientside_Cell.SIDE_4 * 0.500,
                Board_Clientside_Cell.SIDE_4 * 0.500, Board_Clientside_Cell.SIDE_4 * 0.500,
                Board_Clientside_Cell.SIDE_4 * 0.500, -Board_Clientside_Cell.SIDE_4 * 0.500,
                -Board_Clientside_Cell.SIDE_4 * 0.500, -Board_Clientside_Cell.SIDE_4 * 0.500
            };
    public static final double[] COORDS_2
    = {-Board_Clientside_Cell.SIDE_4 * 0.500, Board_Clientside_Cell.SIDE_4 * 0.500,
        Board_Clientside_Cell.SIDE_4 * 0.500, Board_Clientside_Cell.SIDE_4 * 0.500,
        Board_Clientside_Cell.SIDE_4 * 0.500, -Board_Clientside_Cell.SIDE_4 * 0.500,
        -Board_Clientside_Cell.SIDE_4 * 0.500, -Board_Clientside_Cell.SIDE_4 * 0.500
    };
    // координати на върховете на шестоъгълника
    public static final double[] COORDS_6
            = {-Board_Clientside_Cell.SIDE_6 * 0.866, Board_Clientside_Cell.SIDE_6 * 0.500,
                0.000, Board_Clientside_Cell.SIDE_6 * 1.000,
                Board_Clientside_Cell.SIDE_6 * 0.866, Board_Clientside_Cell.SIDE_6 * 0.500,
                Board_Clientside_Cell.SIDE_6 * 0.866, -Board_Clientside_Cell.SIDE_6 * 0.500,
                0.000, -Board_Clientside_Cell.SIDE_6 * 1.000,
                -Board_Clientside_Cell.SIDE_6 * 0.866, -Board_Clientside_Cell.SIDE_6 * 0.500
            };

    public final int rowId;
    public final int colId;
    public final Board_Clientside board;
    public Color color;

    public Board_Clientside_Cell(int rowId, int colId, Board_Clientside board) {
        // генерира се полигон със съответната форма и координати на върховете:
        super((board.boardShape == 3) ? ((colId % 2 == 0) ? COORDS_3_UP : COORDS_3_DOWN) : ((board.boardShape == 4) ? (COORDS_4) : (board.boardShape == 2) ? COORDS_2 : (COORDS_6)));
        this.setFill(Board_Clientside_Cell.COLOR_BOARD);
        this.setStrokeType(StrokeType.INSIDE);
        this.setStrokeWidth(Board_Clientside_Cell.GRID_WIDTH);
        this.setStroke(Board_Clientside_Cell.COLOR_GRID);
        this.rowId = rowId;
        this.colId = colId;
        this.board = board;
        this.color = Board_Clientside_Cell.COLOR_BOARD;
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (board.from == null) {
                    if (board.boardFigures[rowId][colId] != null) {
                        board.from = new BoardCoords(rowId, colId);
                		colorCell(Color.RED,4, board.from);
                    }
                } else {
                    board.to = new BoardCoords(rowId, colId);
                    ArrayList<BoardCoords> from = new ArrayList<>();
                    ArrayList<BoardCoords> to = new ArrayList<>();
                    from.add(board.from);
                    colorCell(Color.RED,4, board.to);
                    to.add(board.to);
                    board.sendMessage(new Message_Board_MoveFigures(null, board.boardId, from, to));
                    colorCell(Color.BLACK,1, board.from);
                    colorCell(Color.BLACK,1, board.to);
                    board.from = null;
                    board.to = null;
                }
                //JOptionPane.showMessageDialog(null, "row: " + rowId + ", col: " + colId);
            }
        });
    }
    
	public void colorCell(Color color,int width, BoardCoords coard){
	    	Board_Clientside_Cell cell = this.board.getCell(coard);
	    	cell.setStroke(color);
	    	cell.setStrokeWidth(width);
    }
}
