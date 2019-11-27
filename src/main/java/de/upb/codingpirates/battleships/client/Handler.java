package de.upb.codingpirates.battleships.client;

import de.upb.codingpirates.battleships.network.message.notification.GameInitNotification;

public interface Handler {

    void handleGameInit(GameInitNotification message);
}
