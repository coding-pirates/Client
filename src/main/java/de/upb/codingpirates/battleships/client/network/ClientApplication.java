package de.upb.codingpirates.battleships.client.network;

import org.apache.logging.log4j.LogManager;

import java.io.IOException;

import javax.annotation.Nonnull;

import de.upb.codingpirates.battleships.network.NetworkApplication;

public class ClientApplication extends NetworkApplication{
    @Nonnull
    private final ClientConnector clientConnector;
    //private static final Logger LOGGER = LogManager.getLogger();
    public ClientApplication() throws IllegalAccessException, IOException, InstantiationException {
      // LOGGER.info("Start client network module");

        this.useModule(ClientModule.class).run();
        this.clientConnector = (ClientConnector) this.getHandler();
    }

    @Nonnull
    public ClientConnector getClientConnector() {
        return clientConnector;
    }

    public static ClientConnector create() {
        try {
            return  new ClientApplication().getClientConnector();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}