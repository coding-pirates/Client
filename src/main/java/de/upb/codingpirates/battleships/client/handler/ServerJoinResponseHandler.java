package de.upb.codingpirates.battleships.client.handler;

import javax.inject.Inject;

import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.network.connectionmanager.ClientConnectionManager;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.id.IntId;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.ServerJoinResponse;

public class ServerJoinResponseHandler implements MessageHandler<ServerJoinResponse> {

    @Inject
    private Handler handler;

    @Inject
    private ClientConnectionManager clientConnector;

    @Override
    public void handle(ServerJoinResponse message, Id connectionId) throws GameException {
        this.clientConnector.getConnection().setId(new IntId(message.getClientId()));
        this.handler.handleServerJoinResponse(message, message.getClientId());
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof ServerJoinResponse;
    }
}
