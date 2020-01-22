package de.upb.codingpirates.battleships.client.network;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.BattleshipsExceptionListener;
import de.upb.codingpirates.battleships.network.ConnectionHandler;
import de.upb.codingpirates.battleships.network.connectionmanager.ClientConnectionManager;
import de.upb.codingpirates.battleships.network.exceptions.BattleshipException;
import de.upb.codingpirates.battleships.network.message.Message;

import javax.inject.Inject;

public class ClientConnector implements ConnectionHandler {

    protected final ClientConnectionManager clientConnector;

    @Inject
    public ClientConnector(ClientConnectionManager clientConnector) {
        this.clientConnector = clientConnector;
    }

    public void connect(String host, int port) {
        this.clientConnector.create(host, port);
    }

    public void connect(String host, int port, Runnable onSuccess, Runnable onFail) {
        this.clientConnector.create(host, port, onSuccess, onFail);
    }

    public void sendMessageToServer(Message message) {
        this.clientConnector.send(message);
    }

    public void disconnect() {
        this.clientConnector.disconnect();
    }

    public void disconnect(Runnable onSuccess, Runnable onFailure){
        this.clientConnector.disconnect(onSuccess, onFailure);
    }

    @Override
    public void handleBattleshipException(BattleshipException e) {
        for (BattleshipsExceptionListener listener : ListenerHandler.get(BattleshipsExceptionListener.class)){
            listener.onBattleshipException(e,clientConnector.getConnection().getId().getInt());
        }
    }
}