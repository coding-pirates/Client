package de.upb.codingpirates.battleships.client.handler;

import com.google.inject.Inject;
import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.client.listener.GameJoinSpectatorResponseListener;
import de.upb.codingpirates.battleships.client.listener.MessageHandlerListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.GameJoinSpectatorResponse;

public class GameJoinSpectatorResponseHandler implements MessageHandler<GameJoinSpectatorResponse> {

    @Override
    public void handle(GameJoinSpectatorResponse message, Id connectionId) throws GameException {
        for(GameJoinSpectatorResponseListener listener : Handler.get(GameJoinSpectatorResponseListener.class)){
            listener.onGameJoinSpectatorResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof GameJoinSpectatorResponse;
    }
}
