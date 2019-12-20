package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.PauseNotificationListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.PauseNotification;

import javax.annotation.Nonnull;

public class PauseNotificationHandler implements MessageHandler<PauseNotification> {

    @Override
    public void handle(@Nonnull PauseNotification message, @Nonnull Id connectionId) throws GameException {
        for (PauseNotificationListener listener : ListenerHandler.get(PauseNotificationListener.class)){
            listener.onPauseNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof PauseNotification;
    }
}
