package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.response.PointsResponse;

public interface PointsResponseListener extends MessageHandlerListener {

    void onPointsResponse(PointsResponse message, int clientId);
}
