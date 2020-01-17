package de.upb.codingpirates.battleships.client.network;

import java.io.IOException;

import javax.inject.Inject;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.BattleshipsExceptionListener;
import de.upb.codingpirates.battleships.network.ConnectionHandler;
import de.upb.codingpirates.battleships.network.connectionmanager.ClientConnectionManager;
import de.upb.codingpirates.battleships.network.exceptions.BattleshipException;
import de.upb.codingpirates.battleships.network.message.Message;

public class ClientConnector implements ConnectionHandler {

    protected final ClientConnectionManager clientConnector;

    @Inject
    public ClientConnector(ClientConnectionManager clientConnector) {
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
        for (BattleshipsExceptionListener listener : ListenerHandler.get(BattleshipsExceptionListener.class)){
            listener.onBattleshipException(e,clientConnector.getConnection().getId().getInt());
        }
    }
}