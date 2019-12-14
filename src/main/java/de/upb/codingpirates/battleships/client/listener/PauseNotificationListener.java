package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.notification.PauseNotification;

public interface PauseNotificationListener extends MessageHandlerListener {

    void onPauseNotification(PauseNotification message, int clientId);
}
