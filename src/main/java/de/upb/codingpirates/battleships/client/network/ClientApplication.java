package de.upb.codingpirates.battleships.client.network;


import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.network.ConnectionHandler;
import de.upb.codingpirates.battleships.network.NetworkApplication;

import javax.annotation.Nonnull;
import java.util.logging.Logger;

public class ClientApplication extends NetworkApplication{
    private static final Logger LOGGER = Logger.getLogger(ClientApplication.class.getName());
    @Nonnull
    private final ConnectionHandler clientConnector;
    public ClientApplication(Class<? extends AbstractClientModule> clientModule) throws IllegalAccessException, InstantiationException {
        LOGGER.info("Start client network module");

        this.useModule(clientModule).run();
        this.clientConnector = (ConnectionHandler) this.getHandler();
    }

    @Nonnull
    public ConnectionHandler getClientConnector() {
        return clientConnector;
    }

    public static ConnectionHandler create(Class<? extends AbstractClientModule> clientModule) {
        try {
            return  new ClientApplication(clientModule).getClientConnector();
        }
        catch (IllegalAccessException | InstantiationException e) {
            System.out.println(e);
        }
        return null;
    }
}