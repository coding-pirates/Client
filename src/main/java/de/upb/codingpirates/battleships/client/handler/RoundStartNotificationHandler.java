package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.RoundStartNotificationListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.RoundStartNotification;

import javax.annotation.Nonnull;

public class RoundStartNotificationHandler implements MessageHandler<RoundStartNotification> {

    @Override
    public void handle(@Nonnull RoundStartNotification message, @Nonnull Id connectionId) throws GameException {
        for (RoundStartNotificationListener listener : ListenerHandler.get(RoundStartNotificationListener.class)){
            listener.onRoundStartNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof RoundStartNotification;
    }
}
