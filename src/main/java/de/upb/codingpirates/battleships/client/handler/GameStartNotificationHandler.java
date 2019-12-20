package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.GameStartNotificationListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.GameStartNotification;

import javax.annotation.Nonnull;

public class GameStartNotificationHandler implements MessageHandler<GameStartNotification> {

    @Override
    public void handle(@Nonnull GameStartNotification message, @Nonnull Id connectionId) throws GameException {
        for (GameStartNotificationListener listener : ListenerHandler.get(GameStartNotificationListener.class)){
            listener.onGameStartNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof GameStartNotification;
    }
}
