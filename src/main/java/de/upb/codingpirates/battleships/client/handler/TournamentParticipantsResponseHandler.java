package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.TournamentParticipantsResponseListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.response.TournamentParticipantsResponse;

import javax.annotation.Nonnull;

public class TournamentParticipantsResponseHandler implements MessageHandler<TournamentParticipantsResponse> {

    @Override
    public void handle(@Nonnull TournamentParticipantsResponse message, @Nonnull Id connectionId) throws GameException, ClassCastException {
        for (TournamentParticipantsResponseListener listener : ListenerHandler.get(TournamentParticipantsResponseListener.class)){
            listener.onTournamentParticipantsResponse(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof TournamentParticipantsResponse;
    }
}
