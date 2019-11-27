package de.upb.codingpirates.battleships.client;


import de.upb.codingpirates.battleships.network.NetworkApplication;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.logging.Logger;

public class ClientApplication extends NetworkApplication{
    private static final Logger LOGGER = Logger.getLogger(ClientApplication.class.getName());
    public static Handler handler;
    @Nonnull
    private final ClientConnector clientConnector;
    public ClientApplication() throws IllegalAccessException, IOException, InstantiationException {
        LOGGER.info("Start client network module");

        this.useModule(ClientModule.class).run();
        this.clientConnector = (ClientConnector) this.getHandler();
    }

    @Nonnull
    public ClientConnector getClientConnector() {
        return clientConnector;
    }

    public static ClientConnector create(Handler messageHandler) {
        handler = messageHandler;
        try {
            return  new ClientApplication().getClientConnector();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}