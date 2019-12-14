package de.upb.codingpirates.battleships.client.handler;

import com.google.inject.Inject;
import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.client.listener.LobbyResponseListener;
import de.upb.codingpirates.battleships.client.listener.MessageHandlerListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.LobbyResponse;

public class LobbyResponseHandler implements MessageHandler<LobbyResponse> {

    @Override
    public void handle(LobbyResponse message, Id connectionId) throws GameException {
        for(LobbyResponseListener listener : Handler.get(LobbyResponseListener.class)){
            listener.onLobbyResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof LobbyResponse;
    }
}
