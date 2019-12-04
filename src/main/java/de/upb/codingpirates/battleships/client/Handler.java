package de.upb.codingpirates.battleships.client;

import de.upb.codingpirates.battleships.network.exceptions.BattleshipException;
import de.upb.codingpirates.battleships.network.message.notification.*;
import de.upb.codingpirates.battleships.network.message.report.ConnectionClosedReport;
import de.upb.codingpirates.battleships.network.message.response.*;

public interface Handler {

    void handleGameInitNotification(GameInitNotification message, int clientId);

    void handleContinueNotification(ContinueNotification message, int clientId);

    void handleConnectionClosedReport(ConnectionClosedReport message, int clientId);

    void handleErrorNotification(ErrorNotification message, int clientId);

    void handleFinishNotification(FinishNotification message, int clientId);

    void handleGameJoinPlayer(GameJoinPlayerResponse message, int clientId);

    void handleGameJoinSpectator(GameJoinSpectatorResponse message, int clientId);

    void handleGameStartNotification(GameStartNotification message, int clientId);

    void handleLeaveNotification(LeaveNotification message, int clientId);

    void handleLobbyResponse(LobbyResponse message, int clientId);

    void handlePauseNotification(PauseNotification message, int clientId);

    void handlePlaceShipsResponse(PlaceShipsResponse message, int clientId);

    void handlePlayerUpdateNotification(PlayerUpdateNotification message, int clientId);

    void handleSpectatorUpdateNotification(SpectatorUpdateNotification message, int clientId);

    void handlePointsResponse(PointsResponse message, int clientId);

    void handleRemainingTimeResponse(RemainingTimeResponse message, int clientId);

    void handleRoundStartNotification(RoundStartNotification message, int clientId);

    void handleServerJoinResponse(ServerJoinResponse message, int clientId);

    void handleShotsResponse(ShotsResponse message, int clientId);

    void handleSpectatorGameStateResponse(SpectatorGameStateResponse message, int clientId);

    void handlePlayerGameStateResponse(PlayerGameStateResponse message, int clientId);

    void handleBattleshipException(BattleshipException exception, int clientId);
}
