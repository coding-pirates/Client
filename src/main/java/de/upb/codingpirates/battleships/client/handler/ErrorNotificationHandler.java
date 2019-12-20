package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.ErrorNotificationListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.ErrorNotification;

import javax.annotation.Nonnull;

public class ErrorNotificationHandler implements MessageHandler<ErrorNotification> {

    @Override
    public void handle(@Nonnull ErrorNotification message, @Nonnull Id connectionId) throws GameException {
        for (ErrorNotificationListener listener : ListenerHandler.get(ErrorNotificationListener.class)){
            listener.onErrorNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof ErrorNotification;
    }
}
