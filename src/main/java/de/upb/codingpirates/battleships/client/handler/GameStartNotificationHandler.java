package de.upb.codingpirates.battleships.client.handler;

import com.google.inject.Inject;
import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.client.listener.GameStartNotificationListener;
import de.upb.codingpirates.battleships.client.listener.MessageHandlerListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.GameStartNotification;

public class GameStartNotificationHandler implements MessageHandler<GameStartNotification> {

    @Override
    public void handle(GameStartNotification message, Id connectionId) throws GameException {
        for(GameStartNotificationListener listener : Handler.get(GameStartNotificationListener.class)){
            listener.onGameStartNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof GameStartNotification;
    }
}
