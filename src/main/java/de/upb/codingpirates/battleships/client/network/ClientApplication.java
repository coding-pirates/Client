package de.upb.codingpirates.battleships.client.network;


import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.network.NetworkApplication;

import javax.annotation.Nonnull;
import java.util.logging.Logger;

public class ClientApplication extends NetworkApplication{
    private static final Logger LOGGER = Logger.getLogger(ClientApplication.class.getName());
    @Nonnull
    private final ClientConnector clientConnector;
    public ClientApplication() throws IllegalAccessException, InstantiationException {
        LOGGER.info("Start client network module");

        this.useModule(ClientModule.class).run();
        this.clientConnector = (ClientConnector) this.getHandler();
    }

    @Nonnull
    public ClientConnector getClientConnector() {
        return clientConnector;
    }

    public static ClientConnector create(Class<? extends Handler> messageHandler) {
        try {
            return  new ClientApplication().getClientConnector();
        }
        catch (IllegalAccessException | InstantiationException e) {
            System.out.println(e);
        }
        return null;
    }
}