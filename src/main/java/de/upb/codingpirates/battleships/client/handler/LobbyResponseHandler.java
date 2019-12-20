package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.LobbyResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.LobbyResponse;

import javax.annotation.Nonnull;

public class LobbyResponseHandler implements MessageHandler<LobbyResponse> {

    @Override
    public void handle(@Nonnull LobbyResponse message,@Nonnull  Id connectionId) throws GameException {
        for (LobbyResponseListener listener : ListenerHandler.get(LobbyResponseListener.class)){
            listener.onLobbyResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof LobbyResponse;
    }
}
