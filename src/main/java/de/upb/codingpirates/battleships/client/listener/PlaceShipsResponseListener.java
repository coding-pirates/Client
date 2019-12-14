package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.response.PlaceShipsResponse;

public interface PlaceShipsResponseListener extends MessageHandlerListener {

    void onPlaceShipsResponse(PlaceShipsResponse message, int clientId);
}
