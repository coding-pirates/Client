package de.upb.codingpirates.battleships.client.handler;

import javax.inject.Inject;

import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.FinishNotification;

public class FinishNotificationHandler implements MessageHandler<FinishNotification> {

    @Inject
    private Handler handler;

    @Override
    public void handle(FinishNotification message, Id connectionId) throws GameException {
        handler.handleFinishNotification(message, connectionId.getInt());
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof FinishNotification;
    }
}
