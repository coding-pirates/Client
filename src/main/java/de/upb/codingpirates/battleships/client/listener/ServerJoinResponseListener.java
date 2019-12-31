package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.response.ServerJoinResponse;

import java.io.IOException;

public interface ServerJoinResponseListener extends MessageHandlerListener {

    void onServerJoinResponse(ServerJoinResponse message, int clientId) throws IOException;
}
