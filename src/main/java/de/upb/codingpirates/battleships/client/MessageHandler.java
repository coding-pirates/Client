package de.upb.codingpirates.battleships.client;

import de.upb.codingpirates.battleships.network.message.notification.*;
import de.upb.codingpirates.battleships.network.message.report.ConnectionClosedReport;
import de.upb.codingpirates.battleships.network.message.response.*;

public class MessageHandler implements Handler {
    @Override
    public void handleGameInitNotification(GameInitNotification message) {

    }

    @Override
    public void handleContinueNotification(ContinueNotification message) {

    }

    @Override
    public void handleConnectionClosedReport(ConnectionClosedReport message) {

    }

    @Override
    public void handleErrorNotification(ErrorNotification message) {

    }

    @Override
    public void handleFinishNotification(FinishNotification message) {

    }

    @Override
    public void handleGameJoinPlayer(GameJoinPlayerResponse message) {

    }

    @Override
    public void handleGameJoinSpectator(GameJoinSpectatorResponse message) {

    }

    @Override
    public void handleGameStartNotification(GameStartNotification message) {

    }

    @Override
    public void handleLeaveNotification(LeaveNotification message) {

    }

    @Override
    public void handleLobbyResponse(LobbyResponse message) {

    }

    @Override
    public void handlePauseNotification(PauseNotification message) {

    }

    @Override
    public void handlePlaceShipsResponse(PlaceShipsResponse message) {

    }

    @Override
    public void handlePlayerUpdateNotification(PlayerUpdateNotification message) {

    }

    @Override
    public void handleSpectatorUpdateNotification(SpectatorUpdateNotification message) {

    }

    @Override
    public void handlePointsResponse(PointsResponse message) {

    }

    @Override
    public void handleRemainingTimeResponse(RemainingTimeResponse message) {

    }

    @Override
    public void handleRoundStartNotification(RoundStartNotification message) {

    }

    @Override
    public void handleServerJoinResponse(ServerJoinResponse message) {

    }

    @Override
    public void handleShotsResponse(ShotsResponse message) {

    }

    @Override
    public void handleSpectatorGameStateResponse(SpectatorGameStateResponse message) {

    }

    @Override
    public void handlePlayerGameStateResponse(PlayerGameStateResponse message) {

    }
}
