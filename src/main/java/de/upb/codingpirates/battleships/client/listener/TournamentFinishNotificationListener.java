package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.notification.TournamentFinishNotification;

public interface TournamentFinishNotificationListener extends MessageHandlerListener {

    void onTournamentFinishNotification(TournamentFinishNotification message, int clientId);
}
