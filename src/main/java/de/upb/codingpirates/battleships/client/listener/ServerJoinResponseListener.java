package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.response.ServerJoinResponse;

public interface ServerJoinResponseListener extends MessageHandlerListener {

    void onServerJoinResponse(ServerJoinResponse message, int clientId);
}
