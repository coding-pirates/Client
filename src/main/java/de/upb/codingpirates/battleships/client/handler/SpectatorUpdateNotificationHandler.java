package de.upb.codingpirates.battleships.client.handler;

import com.google.inject.Inject;
import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.client.listener.SpectatorUpdateNotificationListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.SpectatorUpdateNotification;

public class SpectatorUpdateNotificationHandler implements MessageHandler<SpectatorUpdateNotification> {

    @Override
    public void handle(SpectatorUpdateNotification message, Id connectionId) throws GameException {
        for(SpectatorUpdateNotificationListener listener : Handler.get(SpectatorUpdateNotificationListener.class)){
            listener.onSpectatorUpdateNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof SpectatorUpdateNotification;
    }
}
