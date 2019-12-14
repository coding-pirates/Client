package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.response.LobbyResponse;

public interface LobbyResponseListener extends MessageHandlerListener {

    void onLobbyResponse(LobbyResponse message, int clientId);
}
