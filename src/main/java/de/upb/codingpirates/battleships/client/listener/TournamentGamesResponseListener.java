package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.response.TournamentGamesResponse;

public interface TournamentGamesResponseListener extends MessageHandlerListener {

    void onTournamentGamesResponse(TournamentGamesResponse message, int clientId);
}
