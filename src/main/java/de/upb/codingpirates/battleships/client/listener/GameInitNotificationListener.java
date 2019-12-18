package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.notification.GameInitNotification;

public interface GameInitNotificationListener extends MessageHandlerListener {

    void onGameInitNotification(GameInitNotification message, int clientId);
}
