package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.exceptions.BattleshipException;

public interface BattleshipsExceptionListener extends MessageHandlerListener {

    void onBattleshipException(BattleshipException error, int clientId);
}
