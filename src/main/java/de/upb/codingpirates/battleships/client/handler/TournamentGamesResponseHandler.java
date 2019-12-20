package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.TournamentGamesResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.TournamentGamesResponse;

import javax.annotation.Nonnull;

public class TournamentGamesResponseHandler implements MessageHandler<TournamentGamesResponse> {

    @Override
    public void handle(@Nonnull TournamentGamesResponse message, @Nonnull Id connectionId) throws GameException, ClassCastException {
        for (TournamentGamesResponseListener listener : ListenerHandler.get(TournamentGamesResponseListener.class)){
            listener.onTournamentGamesResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof TournamentGamesResponse;
    }
}
