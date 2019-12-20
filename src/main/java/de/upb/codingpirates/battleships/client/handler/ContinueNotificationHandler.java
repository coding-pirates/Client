package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.ContinueNotificationListener;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.ContinueNotification;

import javax.annotation.Nonnull;

public class ContinueNotificationHandler implements MessageHandler<ContinueNotification> {

    @Override
    public void handle(@Nonnull ContinueNotification message, @Nonnull Id connectionId) {
        for (ContinueNotificationListener listener : ListenerHandler.get(ContinueNotificationListener.class)){
            listener.onContinueNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof ContinueNotification;
    }
}
