package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.GameJoinSpectatorResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.GameJoinSpectatorResponse;

import javax.annotation.Nonnull;

public class GameJoinSpectatorResponseHandler implements MessageHandler<GameJoinSpectatorResponse> {

    @Override
    public void handle(@Nonnull GameJoinSpectatorResponse message, @Nonnull Id connectionId) throws GameException {
        for (GameJoinSpectatorResponseListener listener : ListenerHandler.get(GameJoinSpectatorResponseListener.class)){
            listener.onGameJoinSpectatorResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof GameJoinSpectatorResponse;
    }
}
