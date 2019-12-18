package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.response.SpectatorGameStateResponse;

public interface SpectatorGameStateResponseListener extends MessageHandlerListener {

    void onSpectatorGameStateResponse(SpectatorGameStateResponse message, int clientId);
}
