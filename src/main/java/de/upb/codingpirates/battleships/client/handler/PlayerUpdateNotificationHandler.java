package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.PlayerUpdateNotificationListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.PlayerUpdateNotification;

import javax.annotation.Nonnull;

public class PlayerUpdateNotificationHandler implements MessageHandler<PlayerUpdateNotification> {

    @Override
    public void handle(@Nonnull PlayerUpdateNotification message, @Nonnull Id connectionId) throws GameException {
        for (PlayerUpdateNotificationListener listener : ListenerHandler.get(PlayerUpdateNotificationListener.class)){
            listener.onPlayerUpdateNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof PlayerUpdateNotification;
    }
}
