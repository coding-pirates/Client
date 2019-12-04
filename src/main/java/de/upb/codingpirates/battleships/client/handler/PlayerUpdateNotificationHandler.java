package de.upb.codingpirates.battleships.client.handler;

import com.google.inject.Inject;
import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.PlayerUpdateNotification;

public class PlayerUpdateNotificationHandler implements MessageHandler<PlayerUpdateNotification> {

    @Inject
    private Handler handler;

    @Override
    public void handle(PlayerUpdateNotification message, Id connectionId) throws GameException {
        handler.handlePlayerUpdateNotification(message, connectionId.getInt());
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof PlayerUpdateNotification;
    }
}
