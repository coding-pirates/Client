package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.FinishNotificationListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.FinishNotification;

import javax.annotation.Nonnull;

public class FinishNotificationHandler implements MessageHandler<FinishNotification> {

    @Override
    public void handle(@Nonnull final FinishNotification message, @Nonnull final Id connectionId) throws GameException {
        for (FinishNotificationListener listener : ListenerHandler.get(FinishNotificationListener.class)){
            listener.onFinishNotification(message, connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull final Message message) {
        return message instanceof FinishNotification;
    }
}
