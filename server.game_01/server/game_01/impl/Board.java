package server.game_01.impl;

import server.game.IGameBoardAction;

public class Board implements IGameBoardAction {
	/**
	 * Class which contains all id on the figures
	 * 
	 * @author Nikolay
	 *
	 */
	public static class Figures{
		public static int ORC = 1;
		// TODO insert more minions 
	}
	/**
	 * Shapes for the Board
	 * @author Nikolay
	 *
	 */
	public static enum Shape {
        TRI,
        QUAD,
        HEX
    }
	
	private static final String EXCEPTION_MESSAGE_INCORRECT_SHAPE = null;
	private static final String EXCEPTION_MESSAGE_INCORRECT_SEGMENTS = null;
	/**
	 * Contains the shape type of all cells
	 */
	private Shape shape;
	private Cell board[][];
	private int segments;
	private int X;
	private int Y;
	
	public Board(Shape shape,int segments){
		this.shape = shape;
		this.segments = segments;
		
		if (segments < 1) {
            throw new NullPointerException(Board.EXCEPTION_MESSAGE_INCORRECT_SEGMENTS);
        } else {
            // sizes of the board
            switch (this.shape) {
                case TRI: {
                    X = this.segments;
                    Y = 2 * this.segments - 1;
                }
                break;
                case QUAD: {
                    X = this.segments;
                    Y = this.segments;
                }
                break;
                case HEX: {
                    X = 2 * this.segments - 1;
                    Y = 2 * this.segments - 1;
                }
                break;
                default: {
                    throw new NullPointerException(Board.EXCEPTION_MESSAGE_INCORRECT_SHAPE);
                }
            }
            this.board = new Cell[X][Y];
            for (int i = 0; i < X; i++) {
                for (int j = 0; j < Y; j++) {
                    this.board[i][j] = null;
                }
            }
        }
	}
	
	/**
	 * Function for setting up the figures on the board.
	 * 
	 * @param cells: figures data
	 * @param coordinates: figures coordinates
	 * @return true if the cells size and coordinates size are equal and if each one
	 * of the coordinate is in the board otherwise false
	 */
	public boolean setCells(Cell cells[],Coordinate coordinates[]){
		boolean result = true;
		if(true == result && cells.length == coordinates.length){
			result = false;
		}
		else{
			for(int i = 0;i < coordinates.length;i++){
				if(false == result){
					break;
				}
				
				if(checkCoordinates(coordinates[i].X, coordinates[i].Y))
				{
					board[coordinates[i].X][coordinates[i].Y] = cells[i];
				}
				else{
					result = false;
				}
			}
		}
		return result;
	}

	@Override
	public boolean attack(int x, int y, int x1, int y1) {
		boolean result = true;
		if(!checkCoordinates(x, y) && !checkCoordinates(x1, y1)){
			result = false;
		}
		
		if(result && board[x][y] == null && board[x1][y1] == null){
			result = false;
		}
		
		if(result && board[x][y].getIdPlayer() == board[x1][y1].getIdPlayer()){
			result = false;
		}
		
		if(result){
			int health1 = board[x1][y1].getHealth();
			int defence1 = board[x1][y1].getDefence();
			int attack = board[x][y].getAttack();
			
			health1 = health1 + defence1 - attack;
			board[x1][y1].setHealth(health1);
			
			int health = board[x][y].getHealth();
			int defence = board[x][y].getDefence();
			int attack1 = board[x1][y1].getAttack();
			
			health = health + defence - attack1/2;
			board[x][y].setHealth(health);
		}
		return result;
	}

	@Override
	public boolean move(int x, int y, int x1, int y1) {
		boolean result = true;
		if(!checkCoordinates(x, y) && !checkCoordinates(x1, y1)){
			result = false;
		}
		if(result && board[x][y] == null){
			result = false;
		}
		
		if(result && board[x1][y1] != null){
			result = false;
		}
		
		if(result){
			board[x1][y1] = board[x][y];
			board[x][y] = null;
		}
		return result;
	}

	@Override
	public boolean shoot(int x, int y, int x1, int y1) {
		
		boolean result = true;
		if(!checkCoordinates(x, y) && !checkCoordinates(x1, y1)){
			result = false;
		}
		
		if(result && board[x][y] == null && board[x1][y1] == null){
			result = false;
		}
		
		if(result && board[x][y].getIdPlayer() == board[x1][y1].getIdPlayer()){
			result = false;
		}
		
		if(result){
			int health1 = board[x1][y1].getHealth();
			int defence1 = board[x1][y1].getDefence();
			int shot = board[x][y].getShot();
			
			health1 = health1 + defence1 - shot;
			board[x1][y1].setHealth(health1);
		}
		return result;
	}

	@Override
	public boolean curse(int x, int y, int x1, int x2) {
		// TODO Not supported yet.
		return false;
	}
	
	
	// private methods
	private boolean checkCoordinates(int x,int y){
		if(
			x >= 0 && x < this.X &&
			y >= 0 && y < this.Y
		)
		{
			return true;
		}
		return false;
	}
	
}
