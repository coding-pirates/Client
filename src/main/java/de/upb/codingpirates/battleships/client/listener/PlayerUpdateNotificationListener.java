package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.notification.PlayerUpdateNotification;

public interface PlayerUpdateNotificationListener extends MessageHandlerListener {

    void onPlayerUpdateNotification(PlayerUpdateNotification message, int clientId);
}
