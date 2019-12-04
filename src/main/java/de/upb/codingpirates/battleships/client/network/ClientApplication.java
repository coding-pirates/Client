package de.upb.codingpirates.battleships.client.network;


import de.upb.codingpirates.battleships.network.ConnectionHandler;
import de.upb.codingpirates.battleships.network.NetworkApplication;

import javax.annotation.Nonnull;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientApplication<T extends ConnectionHandler> extends NetworkApplication{
    private static final Logger LOGGER = Logger.getLogger(ClientApplication.class.getName());

    @Nonnull
    private final T clientConnector;
    private ClientApplication(Class<? extends AbstractClientModule<T>> clientModule) throws IllegalAccessException, InstantiationException {
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
        //noinspection TryWithIdenticalCatches
        try {
            return  new ClientApplication<>(clientModule).getClientConnector();
        } catch (IllegalAccessException e) {
            LOGGER.log(Level.INFO,"failed", e);
            throw new IllegalStateException("Could not create ClientApplication " + clientModule.getName());
        } catch (InstantiationException e) {
            LOGGER.log(Level.INFO,"failed", e);
            throw new IllegalStateException("Could not create ClientApplication");
        }
    }

}