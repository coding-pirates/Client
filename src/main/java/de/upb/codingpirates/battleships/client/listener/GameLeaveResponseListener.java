package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.response.GameLeaveResponse;

public interface GameLeaveResponseListener extends MessageHandlerListener {

    void onGameLeaveResponse(GameLeaveResponse message, int clientId);
}
