package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.PlaceShipsResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.PlaceShipsResponse;

import javax.annotation.Nonnull;

public class PlaceShipsResponseHandler implements MessageHandler<PlaceShipsResponse> {

    @Override
    public void handle(@Nonnull PlaceShipsResponse message,@Nonnull  Id connectionId) throws GameException {
        for (PlaceShipsResponseListener listener : ListenerHandler.get(PlaceShipsResponseListener.class)){
            listener.onPlaceShipsResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof PlaceShipsResponse;
    }
}
