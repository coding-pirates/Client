package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.response.TournamentParticipantsResponse;

public interface TournamentParticipantsResponseListener extends MessageHandlerListener {

    void onTournamentParticipantsResponse(TournamentParticipantsResponse message, int clientId);
}
