package de.upb.codingpirates.battleships.client.handler;

import com.google.inject.Inject;
import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.PlayerGameStateResponse;

public class PlayerGameStateResponseHandler implements MessageHandler<PlayerGameStateResponse> {

    @Inject
    private Handler handler;

    @Override
    public void handle(PlayerGameStateResponse message, Id connectionId) throws GameException {
        handler.handlePlayerGameStateResponse(message);
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof PlayerGameStateResponse;
    }
}
