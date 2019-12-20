package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.ListenerHandler;
import de.upb.codingpirates.battleships.client.listener.TournamentFinishNotificationListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.handler.MessageHandler;
import de.upb.codingpirates.battleships.network.message.notification.TournamentFinishNotification;

import javax.annotation.Nonnull;

public class TournamentFinishNotificationHandler implements MessageHandler<TournamentFinishNotification> {

    @Override
    public void handle(@Nonnull TournamentFinishNotification message, @Nonnull Id connectionId) throws GameException, ClassCastException {
        for (TournamentFinishNotificationListener listener : ListenerHandler.get(TournamentFinishNotificationListener.class)){
            listener.onTournamentFinishNotification(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(@Nonnull Message message) {
        return message instanceof TournamentFinishNotification;
    }
}
