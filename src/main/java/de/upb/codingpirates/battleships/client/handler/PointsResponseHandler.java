package de.upb.codingpirates.battleships.client.handler;

import com.google.inject.Inject;
import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.client.listener.PointsResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.PointsResponse;

public class PointsResponseHandler implements MessageHandler<PointsResponse> {

    @Override
    public void handle(PointsResponse message, Id connectionId) throws GameException {
        for(PointsResponseListener listener : Handler.get(PointsResponseListener.class)){
            listener.onPointsResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof PointsResponse;
    }
}
