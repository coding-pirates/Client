package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.ShotsResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.ShotsResponse;

import javax.annotation.Nonnull;

public class ShotsResponseHandler implements MessageHandler<ShotsResponse> {

    @Override
    public void handle(@Nonnull ShotsResponse message, @Nonnull Id connectionId) throws GameException {
        for (ShotsResponseListener listener : ListenerHandler.get(ShotsResponseListener.class)){
            listener.onShotsResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof ShotsResponse;
    }
}
