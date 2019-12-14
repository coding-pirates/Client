package de.upb.codingpirates.battleships.client.handler;

import com.google.inject.Inject;
import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.client.listener.ShotsResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.ShotsResponse;

public class ShotsResponseHandler implements MessageHandler<ShotsResponse> {

    @Override
    public void handle(ShotsResponse message, Id connectionId) throws GameException {
        for(ShotsResponseListener listener : Handler.get(ShotsResponseListener.class)){
            listener.onShotsResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof ShotsResponse;
    }
}
