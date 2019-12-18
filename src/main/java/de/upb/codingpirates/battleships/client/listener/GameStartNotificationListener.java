package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.notification.GameStartNotification;

public interface GameStartNotificationListener extends MessageHandlerListener {

    void onGameStartNotification(GameStartNotification message, int clientId);
}
