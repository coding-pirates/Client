package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ClientApplication;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.GameInitNotification;

public class GameInitNotificationHandler implements MessageHandler<GameInitNotification> {


    @Override
    public void handle(GameInitNotification message, Id connectionId) throws GameException {
        ClientApplication.handler.handleGameInit(message);
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof GameInitNotification;
    }
}
