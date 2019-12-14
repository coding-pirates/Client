package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.RemainingTimeResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.RemainingTimeResponse;

public class RemainingTimeResponseHandler implements MessageHandler<RemainingTimeResponse> {

    @Override
    public void handle(RemainingTimeResponse message, Id connectionId) throws GameException {
        for(RemainingTimeResponseListener listener : ListenerHandler.get(RemainingTimeResponseListener.class)){
            listener.onRemainingTimeResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof RemainingTimeResponse;
    }
}
