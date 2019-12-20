package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.SpectatorUpdateNotificationListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.SpectatorUpdateNotification;

import javax.annotation.Nonnull;

public class SpectatorUpdateNotificationHandler implements MessageHandler<SpectatorUpdateNotification> {

    @Override
    public void handle(@Nonnull SpectatorUpdateNotification message, @Nonnull Id connectionId) throws GameException {
        for (SpectatorUpdateNotificationListener listener : ListenerHandler.get(SpectatorUpdateNotificationListener.class)){
            listener.onSpectatorUpdateNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof SpectatorUpdateNotification;
    }
}
