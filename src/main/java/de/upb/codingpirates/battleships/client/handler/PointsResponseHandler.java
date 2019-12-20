package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.PointsResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.PointsResponse;

import javax.annotation.Nonnull;

public class PointsResponseHandler implements MessageHandler<PointsResponse> {

    @Override
    public void handle(@Nonnull PointsResponse message, @Nonnull Id connectionId) throws GameException {
        for (PointsResponseListener listener : ListenerHandler.get(PointsResponseListener.class)){
            listener.onPointsResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof PointsResponse;
    }
}
