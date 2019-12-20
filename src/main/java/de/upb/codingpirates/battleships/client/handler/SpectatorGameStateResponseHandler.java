package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.SpectatorGameStateResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.SpectatorGameStateResponse;

import javax.annotation.Nonnull;

public class SpectatorGameStateResponseHandler implements MessageHandler<SpectatorGameStateResponse> {

    @Override
    public void handle(@Nonnull SpectatorGameStateResponse message, @Nonnull Id connectionId) throws GameException {
        for (SpectatorGameStateResponseListener listener : ListenerHandler.get(SpectatorGameStateResponseListener.class)){
            listener.onSpectatorGameStateResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof SpectatorGameStateResponse;
    }
}
