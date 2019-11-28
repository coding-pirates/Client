package de.upb.codingpirates.battleships.client;

import de.upb.codingpirates.battleships.network.message.notification.*;
import de.upb.codingpirates.battleships.network.message.report.ConnectionClosedReport;
import de.upb.codingpirates.battleships.network.message.response.*;

public interface Handler {

    void handleGameInitNotification(GameInitNotification message);

    void handleContinueNotification(ContinueNotification message);

    void handleConnectionClosedReport(ConnectionClosedReport message);

    void handleErrorNotification(ErrorNotification message);

    void handleFinishNotification(FinishNotification message);

    void handleGameJoinPlayer(GameJoinPlayerResponse message);

    void handleGameJoinSpectator(GameJoinSpectatorResponse message);

    void handleGameStartNotification(GameStartNotification message);

    void handleLeaveNotification(LeaveNotification message);

    void handleLobbyResponse(LobbyResponse message);

    void handlePauseNotification(PauseNotification message);

    void handlePlaceShipsResponse(PlaceShipsResponse message);

    void handlePlayerUpdateNotification(PlayerUpdateNotification message);

    void handleSpectatorUpdateNotification(SpectatorUpdateNotification message);

    void handlePointsResponse(PointsResponse message);

    void handleRemainingTimeResponse(RemainingTimeResponse message);

    void handleRoundStartNotification(RoundStartNotification message);

    void handleServerJoinResponse(ServerJoinResponse message);

    void handleShotsResponse(ShotsResponse message);

    void handleSpectatorGameStateResponse(SpectatorGameStateResponse message);

    void handlePlayerGameStateResponse(PlayerGameStateResponse message);
}
