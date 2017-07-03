package apps;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import protocol.Message;
import protocol.Message_Auth_Login;
import protocol.interfaces.IMessageHandler;
import protocol.interfaces.IMessageSender;

public class NetServersideConnection extends Thread implements IMessageSender, IMessageHandler {

    private final NetServer server;
    protected final Socket socket;
    protected String username;
    protected int id;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public NetServersideConnection(NetServer server, Socket socket, String username, int id) {
        super();
        this.server = server;
        this.socket = socket;
        this.username = username;
        this.id = id;
        this.outputStream = null;
        this.inputStream = null;
    }

    @Override
    public void run() {
        try {
            this.outputStream = new ObjectOutputStream(this.socket.getOutputStream());
            this.inputStream = new ObjectInputStream(this.socket.getInputStream());
            // authenticate:
            try {
                Message_Auth_Login loginMessage = (Message_Auth_Login) (this.inputStream.readObject());
                this.server.authenticateConnection(this, loginMessage);
                // continue:
                while ((this.inputStream != null) && (!(this.socket.isClosed()))) {
                    try {
                        Message input = (Message) this.inputStream.readObject();
                        if (input.messageType == Message.MESSAGETYPE.AUTH_LOGIN) {
                            throw new IllegalArgumentException("Client attempting a double log in!");
                        }
                        input.username = this.username;
                        this.handleMessage(input);
                    } catch (IOException | ClassNotFoundException | IllegalArgumentException ex) {
                        Logger.getLogger(NetServersideConnection.class.getName()).log(Level.SEVERE, null, ex);
                        this.server.stopConnection(this);
                    }
                }
            } catch (IOException | ClassNotFoundException | ClassCastException ex) {
                Logger.getLogger(NetServersideConnection.class.getName()).log(Level.SEVERE, null, ex);
                this.server.stopConnection(this);
            }
        } catch (IOException ex) {
            Logger.getLogger(NetServersideConnection.class.getName()).log(Level.SEVERE, null, ex);
            this.server.stopConnection(this);
        }
        // stop connection:
        this.server.stopConnection(this);
    }

    @Override
    public synchronized void sendMessage(Message message) {
        try {
            this.outputStream.writeObject(message);
            this.outputStream.flush();
        } catch (IOException ex) {
            Logger.getLogger(NetServersideConnection.class.getName()).log(Level.SEVERE, null, ex);
            this.server.stopConnection(this);
        }
    }

    @Override
    public synchronized void handleMessage(Message message) {
        this.server.handleMessage(message);
    }
}
