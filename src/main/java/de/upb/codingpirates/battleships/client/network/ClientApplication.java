package de.upb.codingpirates.battleships.client.network;


import de.upb.codingpirates.battleships.network.NetworkApplication;
import de.upb.codingpirates.battleships.network.util.ClientReaderMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ClientApplication extends NetworkApplication{
    private static final Logger LOGGER = LogManager.getLogger();

    @Nonnull
    private final ClientConnector clientConnector;
    private <T extends ClientModule> ClientApplication(T clientModule) {
        LOGGER.info("Start client network module");

        this.useModule(clientModule).run();
        //noinspection ConstantConditions
        this.clientConnector =  (ClientConnector) this.getHandler();
    }

    @Nonnull
    public ClientConnector getClientConnector() {
        return clientConnector;
    }

    public static ClientConnector create(){
        return ClientApplication.create((Class<? extends ClientReaderMethod>)null);
    }

    public static <T extends ClientModule> ClientConnector create(T module){
        return new ClientApplication(module).getClientConnector();
    }

    public static ClientConnector create(@Nullable Class<? extends ClientReaderMethod> readerMethod) {
        return new ClientApplication(new ClientModule(null, readerMethod)).getClientConnector();
    }

}