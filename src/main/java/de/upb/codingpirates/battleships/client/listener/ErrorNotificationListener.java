package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.notification.ErrorNotification;

public interface ErrorNotificationListener extends MessageHandlerListener {

    void onErrorNotification(ErrorNotification message, int clientId);
}
