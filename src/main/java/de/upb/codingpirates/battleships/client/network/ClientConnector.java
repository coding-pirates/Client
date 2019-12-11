package de.upb.codingpirates.battleships.client.network;

import com.google.inject.Inject;
import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.network.ConnectionHandler;
import de.upb.codingpirates.battleships.network.connectionmanager.ClientConnectionManager;
import de.upb.codingpirates.battleships.network.exceptions.BattleshipException;
import de.upb.codingpirates.battleships.network.message.Message;

import java.io.IOException;

public class ClientConnector implements ConnectionHandler {

    protected final Handler handler;

    protected final ClientConnectionManager clientConnector;

    @Inject
    public ClientConnector(Handler handler, ClientConnectionManager clientConnector) {
        this.handler = handler;
        this.clientConnector = clientConnector;
    }

    public void connect(String host, int port) throws IOException {
        this.clientConnector.create(host, port);
    }

    public void sendMessageToServer(Message message) throws IOException {
        this.clientConnector.send(message);
    }

    public void disconnect() throws IOException {
        this.clientConnector.disconnect();
    }

    @Override
    public void handleBattleshipException(BattleshipException e) {
        this.handler.handleBattleshipException(e, clientConnector.getConnection().getId().getInt());
    }
}