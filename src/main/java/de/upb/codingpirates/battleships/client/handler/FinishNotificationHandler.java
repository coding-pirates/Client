package de.upb.codingpirates.battleships.client.handler;

import javax.inject.Inject;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.FinishNotificationListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.FinishNotification;

public class FinishNotificationHandler implements MessageHandler<FinishNotification> {

    @Override
    public void handle(final FinishNotification message, final Id connectionId) throws GameException {
        for (FinishNotificationListener listener : ListenerHandler.get(FinishNotificationListener.class)){
            listener.onFinishNotification(message, connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(final Message message) {
        return message instanceof FinishNotification;
    }
}
