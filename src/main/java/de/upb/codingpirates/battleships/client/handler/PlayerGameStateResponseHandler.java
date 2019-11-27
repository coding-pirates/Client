package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ClientApplication;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.PlayerGameStateResponse;

public class PlayerGameStateResponseHandler implements MessageHandler<PlayerGameStateResponse> {


    @Override
    public void handle(PlayerGameStateResponse message, Id connectionId) throws GameException {
        ClientApplication.handler.handlePlayerGameStateResponse(message);
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof PlayerGameStateResponse;
    }
}
