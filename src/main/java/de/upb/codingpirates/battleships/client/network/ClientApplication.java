package de.upb.codingpirates.battleships.client.network;


import de.upb.codingpirates.battleships.network.ConnectionHandler;
import de.upb.codingpirates.battleships.network.NetworkApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

public class ClientApplication<T extends ConnectionHandler> extends NetworkApplication{
    private static final Logger LOGGER = LogManager.getLogger();

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
            LOGGER.info("failed", e);
            throw new IllegalStateException("Could not create ClientApplication " + clientModule.getName());
        } catch (InstantiationException e) {
            LOGGER.info("failed", e);
            throw new IllegalStateException("Could not create ClientApplication");
        }
    }

}