package de.upb.codingpirates.battleships.client.handler;

import com.google.inject.Inject;
import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.GameInitNotification;

public class GameInitNotificationHandler implements MessageHandler<GameInitNotification> {

    @Inject
    private Handler handler;

    @Override
    public void handle(GameInitNotification message, Id connectionId) throws GameException {
        handler.handleGameInitNotification(message);
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof GameInitNotification;
    }
}
