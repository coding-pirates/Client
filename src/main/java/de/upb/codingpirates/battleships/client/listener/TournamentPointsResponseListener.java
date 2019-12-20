package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.response.TournamentPointsResponse;

public interface TournamentPointsResponseListener extends MessageHandlerListener {

    void onTournamentPointsResponse(TournamentPointsResponse message, int clientId);
}
