package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.response.GameJoinPlayerResponse;

public interface GameJoinPlayerResponseListener extends MessageHandlerListener {

    void onGameJoinPlayerResponse(GameJoinPlayerResponse message, int clientId);
}
