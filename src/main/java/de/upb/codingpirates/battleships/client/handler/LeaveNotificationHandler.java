package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.LeaveNotificationListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.LeaveNotification;

import javax.annotation.Nonnull;

public class LeaveNotificationHandler implements MessageHandler<LeaveNotification> {

    @Override
    public void handle(@Nonnull LeaveNotification message, @Nonnull Id connectionId) throws GameException {
        for (LeaveNotificationListener listener : ListenerHandler.get(LeaveNotificationListener.class)){
            listener.onLeaveNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof LeaveNotification;
    }
}
