package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.response.ShotsResponse;

public interface ShotsResponseListener extends MessageHandlerListener {

    void onShotsResponse(ShotsResponse message, int clientId);
}
