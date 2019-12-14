package de.upb.codingpirates.battleships.client.handler;

import com.google.inject.Inject;
import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.client.listener.SpectatorGameStateResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.SpectatorGameStateResponse;

public class SpectatorGameStateResponseHandler implements MessageHandler<SpectatorGameStateResponse> {

    @Override
    public void handle(SpectatorGameStateResponse message, Id connectionId) throws GameException {
        for(SpectatorGameStateResponseListener listener : Handler.get(SpectatorGameStateResponseListener.class)){
            listener.onSpectatorGameStateResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof SpectatorGameStateResponse;
    }
}
