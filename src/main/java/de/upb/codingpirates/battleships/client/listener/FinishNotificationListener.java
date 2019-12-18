package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.notification.FinishNotification;

public interface FinishNotificationListener extends MessageHandlerListener {

    void onFinishNotification(FinishNotification message, int clientId);
}
