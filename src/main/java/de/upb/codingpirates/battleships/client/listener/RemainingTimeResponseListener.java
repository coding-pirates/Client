package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.response.RemainingTimeResponse;

public interface RemainingTimeResponseListener extends MessageHandlerListener {

    void onRemainingTimeResponse(RemainingTimeResponse message, int clientId);
}
