package de.upb.codingpirates.battleships.client.network;


import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.network.ConnectionHandler;
import de.upb.codingpirates.battleships.network.NetworkApplication;

import javax.annotation.Nonnull;
import java.util.logging.Logger;

public class ClientApplication<T extends ConnectionHandler> extends NetworkApplication{
    private static final Logger LOGGER = Logger.getLogger(ClientApplication.class.getName());
    @Nonnull
    private final T clientConnector;
    public ClientApplication(Class<? extends AbstractClientModule> clientModule) throws IllegalAccessException, InstantiationException {
        LOGGER.info("Start client network module");

        this.useModule(clientModule).run();
        //noinspection ConstantConditions,unchecked
        this.clientConnector = (T) this.getHandler();
    }

    @Nonnull
    public T getClientConnector() {
        return clientConnector;
    }

    public static <T extends ConnectionHandler> T create(Class<? extends AbstractClientModule<T>> clientModule) {
        try {
            return  new ClientApplication<T>(clientModule).getClientConnector();
        }
        catch (IllegalAccessException | InstantiationException e) {
            throw new IllegalStateException("Could not create ClientApplication");
        }
    }
}