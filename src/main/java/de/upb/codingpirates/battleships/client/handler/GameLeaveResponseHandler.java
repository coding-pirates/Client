package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.GameLeaveResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.GameLeaveResponse;

import javax.annotation.Nonnull;

public class GameLeaveResponseHandler implements MessageHandler<GameLeaveResponse> {

    @Override
    public void handle(@Nonnull GameLeaveResponse message, @Nonnull Id connectionId) throws GameException, ClassCastException {
        for (GameLeaveResponseListener listener : ListenerHandler.get(GameLeaveResponseListener.class)){
            listener.onGameLeaveResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof GameLeaveResponse;
    }
}
