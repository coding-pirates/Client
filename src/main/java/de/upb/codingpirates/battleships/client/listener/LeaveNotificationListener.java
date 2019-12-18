package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.notification.LeaveNotification;

public interface LeaveNotificationListener extends MessageHandlerListener {

    void onLeaveNotification(LeaveNotification message, int clientId);
}
