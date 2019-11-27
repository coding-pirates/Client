package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ClientApplication;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.ShotsResponse;

public class ShotsResponseHandler implements MessageHandler<ShotsResponse> {


    @Override
    public void handle(ShotsResponse message, Id connectionId) throws GameException {
        ClientApplication.handler.handleShotsResponse(message);
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof ShotsResponse;
    }
}
