package de.upb.codingpirates.battleships.client.handler;

import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.client.listener.ConnectionClosedReportListener;
import de.upb.codingpirates.battleships.client.listener.MessageHandlerListener;
import de.upb.codingpirates.battleships.network.exceptions.game.GameException;
import de.upb.codingpirates.battleships.network.id.Id;
import de.upb.codingpirates.battleships.network.message.Message;
import de.upb.codingpirates.battleships.network.message.MessageHandler;
import de.upb.codingpirates.battleships.network.message.report.ConnectionClosedReport;

public class ConnectionClosedReportHandler implements MessageHandler<ConnectionClosedReport> {

    @Override
    public void handle(ConnectionClosedReport message, Id connectionId) throws GameException {
        for(ConnectionClosedReportListener listener : Handler.get(ConnectionClosedReportListener.class)){
            listener.onConnectionClosedReport(message,connectionId.getInt());
        }
    }

    @Override
    public boolean canHandle(Message message) {
        return message instanceof ConnectionClosedReport;
    }
}
