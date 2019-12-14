package de.upb.codingpirates.battleships.client.listener;

import de.upb.codingpirates.battleships.network.message.report.ConnectionClosedReport;

public interface ConnectionClosedReportListener extends MessageHandlerListener {

    void onConnectionClosedReport(ConnectionClosedReport message, int clientId);
}
