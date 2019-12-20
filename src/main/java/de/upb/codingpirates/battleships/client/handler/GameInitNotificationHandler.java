package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.GameInitNotificationListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.GameInitNotification;

import javax.annotation.Nonnull;

public class GameInitNotificationHandler implements MessageHandler<GameInitNotification> {

    @Override
    public void handle(@Nonnull GameInitNotification message, @Nonnull Id connectionId) throws GameException {
        for (GameInitNotificationListener listener : ListenerHandler.get(GameInitNotificationListener.class)){
            listener.onGameInitNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle( @Nonnull Message message) {
        return message instanceof GameInitNotification;
    }
}
