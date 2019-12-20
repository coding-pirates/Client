package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.TournamentPointsResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.TournamentPointsResponse;

import javax.annotation.Nonnull;

public class TournamentPointsResponseHandler implements MessageHandler<TournamentPointsResponse> {

    @Override
    public void handle(@Nonnull TournamentPointsResponse message, @Nonnull Id connectionId) throws GameException, ClassCastException {
        for (TournamentPointsResponseListener listener : ListenerHandler.get(TournamentPointsResponseListener.class)){
            listener.onTournamentPointsResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof TournamentPointsResponse;
    }
}
