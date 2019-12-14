package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.GameJoinPlayerResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.GameJoinPlayerResponse;

public class GameJoinPlayerResponseHandler implements MessageHandler<GameJoinPlayerResponse> {

    @Override
    public void handle(GameJoinPlayerResponse message, Id connectionId) throws GameException {
        for(GameJoinPlayerResponseListener listener : ListenerHandler.get(GameJoinPlayerResponseListener.class)){
            listener.onGameJoinPlayerResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof GameJoinPlayerResponse;
    }
}
