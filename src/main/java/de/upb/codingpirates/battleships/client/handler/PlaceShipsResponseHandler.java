package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ClientApplication;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.PlaceShipsResponse;

public class PlaceShipsResponseHandler implements MessageHandler<PlaceShipsResponse> {


    @Override
    public void handle(PlaceShipsResponse message, Id connectionId) throws GameException {
        ClientApplication.handler.handlePlaceShipsResponse(message);
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof PlaceShipsResponse;
    }
}
