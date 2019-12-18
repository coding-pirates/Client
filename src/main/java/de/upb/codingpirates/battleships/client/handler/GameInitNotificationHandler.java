package de.upb.codingpirates.battleships.client.handler;

import javax.inject.Inject;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.GameInitNotificationListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.GameInitNotification;

public class GameInitNotificationHandler implements MessageHandler<GameInitNotification> {

    @Override
    public void handle(GameInitNotification message, Id connectionId) throws GameException {
        for (GameInitNotificationListener listener : ListenerHandler.get(GameInitNotificationListener.class)){
            listener.onGameInitNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof GameInitNotification;
    }
}
