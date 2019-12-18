package de.upb.codingpirates.battleships.client.handler;

import javax.inject.Inject;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.SpectatorGameStateResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.SpectatorGameStateResponse;

public class SpectatorGameStateResponseHandler implements MessageHandler<SpectatorGameStateResponse> {

    @Override
    public void handle(SpectatorGameStateResponse message, Id connectionId) throws GameException {
        for (SpectatorGameStateResponseListener listener : ListenerHandler.get(SpectatorGameStateResponseListener.class)){
            listener.onSpectatorGameStateResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof SpectatorGameStateResponse;
    }
}
