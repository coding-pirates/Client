package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.notification.RoundStartNotification;

public interface RoundStartNotificationListener extends MessageHandlerListener {

    void onRoundStartNotification(RoundStartNotification message, int clientId);
}
