package de.upb.codingpirates.battleships.client.handler;

import com.google.inject.Inject;
import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.client.listener.PlaceShipsResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.PlaceShipsResponse;

public class PlaceShipsResponseHandler implements MessageHandler<PlaceShipsResponse> {

    @Override
    public void handle(PlaceShipsResponse message, Id connectionId) throws GameException {
        for(PlaceShipsResponseListener listener : Handler.get(PlaceShipsResponseListener.class)){
            listener.onPlaceShipsResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof PlaceShipsResponse;
    }
}
