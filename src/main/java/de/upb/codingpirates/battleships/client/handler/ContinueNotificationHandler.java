package de.upb.codingpirates.battleships.client.handler;

import com.google.inject.Inject;
import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.client.listener.ContinueNotificationListener;
import de.upb.codingpirates.battleships.client.listener.MessageHandlerListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.ContinueNotification;

public class ContinueNotificationHandler implements MessageHandler<ContinueNotification> {

    @Override
    public void handle(ContinueNotification message, Id connectionId) throws GameException {
        for(ContinueNotificationListener listener : Handler.get(ContinueNotificationListener.class)){
            listener.onContinueNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof ContinueNotification;
    }
}
