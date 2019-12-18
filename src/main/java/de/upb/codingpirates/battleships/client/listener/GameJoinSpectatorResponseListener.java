package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.response.GameJoinSpectatorResponse;

public interface GameJoinSpectatorResponseListener extends MessageHandlerListener {

    void onGameJoinSpectatorResponse(GameJoinSpectatorResponse message, int clientId);
}
