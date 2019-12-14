package de.upb.codingpirates.battleships.client.handler;

import com.google.inject.Inject;
import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.client.listener.LeaveNotificationListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.LeaveNotification;

public class LeaveNotificationHandler implements MessageHandler<LeaveNotification> {

    @Override
    public void handle(LeaveNotification message, Id connectionId) throws GameException {
        for(LeaveNotificationListener listener : Handler.get(LeaveNotificationListener.class)){
            listener.onLeaveNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof LeaveNotification;
    }
}
