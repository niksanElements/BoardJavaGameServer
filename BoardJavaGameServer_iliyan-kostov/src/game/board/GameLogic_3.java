package game.board;

import apps.GameManager;

public class GameLogic_3 extends GameLogic {

    public GameLogic_3(Board_Serverside board, GameManager gameManager) {
        super(board, gameManager);
    }

    @Override
    public synchronized boolean isNextTo(BoardCoords from, BoardCoords to) {
        int row1 = from.row;
        int col1 = from.col;
        int row2 = to.row;
        int col2 = to.col;

        if (row2 == row1) {
            // move - same row sideways:
            if ((col2 == col1 + 1) || (col2 == col1 - 1)) {
                return true;
            }
        } else if ((row2 == row1 + 1) && (col1 % 2 == 0)) {
            // move down requested and triangle points up - can move down:
            if (col2 == col1 + 1) {
                return true;
            }
        } else if ((row2 == row1 - 1) && (col1 % 2 == 1)) {
            // move up requested and triangle points down - can move up:
            if (col2 == col1 - 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public synchronized boolean isInsideBoard(BoardCoords boardCoords) {
        int row = boardCoords.row;
        int col = boardCoords.col;
        if ((0 <= row) && (row < this.board.boardSizeRows)) {
            if ((0 <= col) && (col <= 2 * row)) {
                return true;
            }
        }
        return false;
    }
}
