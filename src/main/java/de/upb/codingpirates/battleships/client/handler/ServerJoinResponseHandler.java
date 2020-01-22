package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.ServerJoinResponseListener;
import de.upb.codingpirates.battleships.network.connectionmanager.ClientConnectionManager;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.ServerJoinResponse;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.io.IOException;

public class ServerJoinResponseHandler implements MessageHandler<ServerJoinResponse> {

    @Inject
    private ClientConnectionManager clientConnector;

    @Override
    public void handle(@Nonnull ServerJoinResponse message, @Nonnull Id connectionId) throws GameException, IOException {
        this.clientConnector.getConnection().setId(new Id(message.getClientId()));
        for (ServerJoinResponseListener listener : ListenerHandler.get(ServerJoinResponseListener.class)) {
            listener.onServerJoinResponse(message, connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof ServerJoinResponse;
    }
}
