package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.notification.ContinueNotification;

public interface ContinueNotificationListener extends MessageHandlerListener {

    void onContinueNotification(ContinueNotification message, int clientId);
}
