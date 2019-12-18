package de.upb.codingpirates.battleships.client.handler;

import javax.inject.Inject;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.PauseNotificationListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.PauseNotification;

public class PauseNotificationHandler implements MessageHandler<PauseNotification> {

    @Override
    public void handle(PauseNotification message, Id connectionId) throws GameException {
        for (PauseNotificationListener listener : ListenerHandler.get(PauseNotificationListener.class)){
            listener.onPauseNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof PauseNotification;
    }
}
