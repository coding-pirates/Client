package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.notification.SpectatorUpdateNotification;

public interface SpectatorUpdateNotificationListener extends MessageHandlerListener {

    void onSpectatorUpdateNotification(SpectatorUpdateNotification message, int clientId);
}
