package game.board;

import apps.NetClient;
import game.lobby.PlayerStat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import protocol.ChatMessage;
import protocol.Message;
import protocol.Message_Board_EndGame;
import protocol.Message_Board_EndTurn;
import protocol.Message_Board_GameStarted;
import protocol.Message_Board_GameSync;
import protocol.Message_Board_MoveFigures;
import protocol.Message_Board_RemoveFigures;
import protocol.Message_Board_Surrender;
import protocol.interfaces.IMessageHandler;
import protocol.interfaces.IMessageSender;
import test.BoardGame.controller.ChatController;
import test.BoardGame.controller.UserController;

public class Board_Clientside extends Board implements IMessageHandler, IMessageSender {

    public final NetClient client;
    public final Group boardView;
    public final Board_Clientside_Cell[][] boardCells;
    public BoardCoords from;
    public BoardCoords to;
    public ImageLoader imgLoader;
    
    public ChatController chat;
    public UserController usercontrol;
    

    public Board_Clientside(int boardShape, int boardId, String[] usernames, NetClient client) {
        super(boardShape, boardId, usernames);
        this.client = client;
        this.boardView = new Group();
        this.boardCells = new Board_Clientside_Cell[this.boardSizeRows][this.boardSizeCols];
        this.imgLoader = new ImageLoader();
        for (int i = 0; i < this.boardSizeRows; i++) {
            for (int j = 0; j < this.boardSizeCols; j++) {
                this.boardCells[i][j] = new Board_Clientside_Cell(i, j, this);
            }
        }
        this.from = null;
        this.to = null;
        // поставяне на клетките от дъската по местата им:
        switch (boardShape) {
        	case 2:{
        		for (int i = 0; i < this.boardSizeRows; i++) {
                    for (int j = 0; j < this.boardSizeCols; j++) {
                        this.boardView.getChildren().add(this.boardCells[i][j]);
                        //this.boardCells[i][j].setRotate(0.);
                        this.boardCells[i][j].setTranslateX(j * Board_Clientside_Cell.SIDE_4);
                        this.boardCells[i][j].setTranslateY(i * Board_Clientside_Cell.SIDE_4);
                    }
                }
        	}
        	break;
            case 3: {
                for (int i = 0; i < this.boardSizeRows; i++) {
                    for (int j = 0; j < this.boardSizeCols; j++) {
                        // ако полето е от дъската:
                        if (j <= 2 * i) {
                            this.boardView.getChildren().add(this.boardCells[i][j]);
                            this.boardCells[i][j].setRotate((j % 2) * 180.);
                            this.boardCells[i][j].setTranslateX((j - i) * Board_Clientside_Cell.SIDE_3 * 0.500);
                            this.boardCells[i][j].setTranslateY(i * Board_Clientside_Cell.SIDE_3 * 0.866);
                        }
                    }
                }
            }
            break;
            case 4: {
                for (int i = 0; i < this.boardSizeRows; i++) {
                    for (int j = 0; j < this.boardSizeCols; j++) {
                        this.boardView.getChildren().add(this.boardCells[i][j]);
                        //this.boardCells[i][j].setRotate(0.);
                        this.boardCells[i][j].setTranslateX(j * Board_Clientside_Cell.SIDE_4);
                        this.boardCells[i][j].setTranslateY(i * Board_Clientside_Cell.SIDE_4);
                    }
                }
            }
            break;
            case 6: {
                int rowLength = (this.boardSizeCols + 1) / 2;
                int dx = 0;
                int midRowId = (this.boardSizeRows - 1) / 2;
                // горна половина:
                for (int i = 0; i < midRowId + 1; i++, rowLength++, dx--) {
                    for (int j = 0; j < rowLength; j++) {
                        this.boardView.getChildren().add(this.boardCells[i][j]);
                        //this.boardCells[i][j].setRotate(0.);
                        this.boardCells[i][j].setTranslateX((2 * j + dx) * Board_Clientside_Cell.SIDE_6 * 0.866);
                        this.boardCells[i][j].setTranslateY(i * Board_Clientside_Cell.SIDE_6 * 1.500);
                    }
                }
                rowLength = rowLength - 2;
                dx = dx + 2;
                // долна половина:
                {
                    for (int i = midRowId + 1; i < this.boardSizeCols; i++, rowLength--, dx++) {
                        for (int j = 0; j < rowLength; j++) {
                            this.boardView.getChildren().add(this.boardCells[i][j]);
                            //this.boardCells[i][j].setRotate(0.);
                            this.boardCells[i][j].setTranslateX((2 * j + dx) * Board_Clientside_Cell.SIDE_6 * 0.866);
                            this.boardCells[i][j].setTranslateY(i * Board_Clientside_Cell.SIDE_6 * 1.500);
                        }
                    }
                }
            }
            break;
            default: {
                throw new IllegalArgumentException();
            }
        }
        // отразяване на позициите на фигурите по дъската:
        for (Map.Entry<String, HashSet<Figure>> entry : this.playerFigures.entrySet()) {
            String playerName = entry.getKey();
            int playerId = 0;
            while (!(this.usernames[playerId].equals(playerName))) {
                playerId++;
            }
            HashSet<Figure> figures = entry.getValue();
            if (figures != null) {
                Iterator<Figure> it = figures.iterator();
                while (it.hasNext()) {
                    Figure f = it.next();
                    this.boardCells[f.boardCoords.row][f.boardCoords.col].setFill(f.getImagePattern());
                    Tooltip.install(this.boardCells[f.boardCoords.row][f.boardCoords.col],f.getTooltip());
                }
            }
        }
    }

    public Group getBoardView() {
        return this.boardView;
    }

    @Override
    public synchronized void handleGameStarted(Message_Board_GameStarted message) {
        // boardView is generated in constructor !!!
    }

    @Override
    public synchronized void handleGameSync(Message_Board_GameSync message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized void handleMoveFigures(Message_Board_MoveFigures message) {
        if (message != null) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    ArrayList<BoardCoords> from = message.from;
                    ArrayList<BoardCoords> to = message.to;
                    if ((from != null) && (to != null)) {
                        Iterator<BoardCoords> itFrom = from.iterator();
                        Iterator<BoardCoords> itTo = to.iterator();
                        while (itFrom.hasNext() && itTo.hasNext()) {
                            BoardCoords c1 = itFrom.next();
                            BoardCoords c2 = itTo.next();
                            String playerMoves = boardFigures[c1.row][c1.col].username;
                            int playerId = 0;
                            while (!(usernames[playerId].equals(playerMoves))) {
                                playerId++;
                            }
                            boardCells[c1.row][c1.col].setFill(Board_Clientside_Cell.COLOR_BOARD);
                            boardCells[c2.row][c2.col].setFill(boardFigures[c1.row][c1.col].getImagePattern());
                            
                            Tooltip.uninstall(boardCells[c1.row][c1.col],boardFigures[c1.row][c1.col].getTooltip());
                            Tooltip.install( boardCells[c2.row][c2.col], boardFigures[c1.row][c1.col].getTooltip());
                            
                            boardFigures[c2.row][c2.col] = boardFigures[c1.row][c1.col];
                            boardFigures[c1.row][c1.col] = null;
                        }
                    }
                }
            });
        }
    }

    @Override
    public synchronized void handleRemoveFigures(Message_Board_RemoveFigures message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized void handleEndTurn(Message_Board_EndTurn message) {
        // TODO
        System.out.println("[Client] Received Message_Board_EndTurn : " + message.playerTurnEnds);
        System.out.flush();
        if(this.usercontrol.getUsername().equals(message.playerTurnStarts))
        	this.usercontrol.isMyTurn(true);
        else{
        	this.usercontrol.isMyTurn(false);
        }
        // =======================================================================================
        // =======================================================================================
    }

    @Override
    public synchronized void handleEndGame(Message_Board_EndGame message) {
        // TODO
        System.out.println("[Client] Received Message_Board_EndGame : ");
        System.out.println("[Client]          Stats before game: Player // Won // Lost");
        for (int i = 0; i < message.playerStatsOld.length; i++) {
            PlayerStat psOld = message.playerStatsOld[i];
            System.out.println("[Client]              " + psOld.playerName + " // " + psOld.gamesWon + " // " + psOld.gamesLost);
        }
        System.out.println("[Client]          Stats after game: Player // Won // Lost");
        for (int i = 0; i < message.playerStatsOld.length; i++) {
            PlayerStat psNew = message.playerStatsNew[i];
            System.out.println("[Client]              " + psNew.playerName + " // " + psNew.gamesWon + " // " + psNew.gamesLost);
        }
        System.out.flush();
        // изобразяване на резултата върху дъската:
        {
            GridPane endgameInfo = new GridPane();
            // поздравление:
            String infoStr = "Game finished!\nNew player stats after the game:\n";
            Label labelInfo = new Label(infoStr);
            labelInfo.setTextFill(Color.WHITE);

            GridPane results = new GridPane();
            // заглавие на таблицата:
            {
                Label headerName = new Label("Player name");
                Label headerWon = new Label("Games won");
                Label headerLost = new Label("Games lost");

                headerName.setTextFill(Color.WHITE);
                headerWon.setTextFill(Color.WHITE);
                headerLost.setTextFill(Color.WHITE);

                results.add(headerName, 0, 0);
                results.add(headerWon, 1, 0);
                results.add(headerLost, 2, 0);
            }
            // нови статистики на играчите:
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < message.playerStatsNew.length; i++) {
                        Label playerName = new Label(message.playerStatsNew[i].playerName);
                        Label gamesWon = new Label(String.valueOf(message.playerStatsNew[i].gamesWon));
                        Label gamesLost = new Label(String.valueOf(message.playerStatsNew[i].gamesLost));

                        playerName.setTextFill(Color.WHITE);
                        gamesWon.setTextFill(Color.WHITE);
                        gamesLost.setTextFill(Color.WHITE);

                        results.add(playerName, 0, i + 1);
                        results.add(gamesWon, 1, i + 1);
                        results.add(gamesLost, 2, i + 1);
                    }
                    results.setHgap(10);
                    results.setVgap(5);
                    
                    endgameInfo.add(labelInfo, 0, 0);
                    endgameInfo.add(results, 0, 1);
                    endgameInfo.setStyle("-fx-background-color: rgba(0, 100, 100, 0.9); -fx-background-radius: 5;");
                    endgameInfo.setHgap(10);
                    endgameInfo.setVgap(5);
                    boardView.getChildren().add(endgameInfo);
                    endgameInfo.setAlignment(Pos.CENTER);
                }
            });
        }
        // =======================================================================================
        // =======================================================================================
    }

    @Override
    public synchronized void handleSurrender(Message_Board_Surrender message) {
        // TODO
        System.out.println("[Client] Received Message_Board_Surrender : " + message.playerSurrenders);
        System.out.flush();
        // =======================================================================================
        // =======================================================================================
    }

    @Override
    public synchronized void sendMessage(Message message) {
        this.client.sendMessage(message);
    }

	public NetClient getClient() {
		return client;
	}

	public Board_Clientside_Cell getCell(BoardCoords coard) {
		return this.boardCells[coard.row][coard.col];
		
	}

	@Override
	public void handleChatMessage(ChatMessage msg) {
		this.chat.hendaleMessage(msg);
		
	}

	public ChatController getChat() {
		return chat;
	}

	public void setChat(ChatController chat) {
		this.chat = chat;
	}

	public UserController getUsercontrol() {
		return usercontrol;
	}

	public void setUsercontrol(UserController usercontrol) {
		this.usercontrol = usercontrol;
	}
	
	
    
}
