package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.response.PlayerGameStateResponse;

public interface PlayerGameStateResponseListener extends MessageHandlerListener {

    void onPlayerGameStateResponse(PlayerGameStateResponse message, int clientId);
}
