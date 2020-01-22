package de.upb.codingpirates.battleships.client.network;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import de.upb.codingpirates.battleships.network.ConnectionHandler;
import de.upb.codingpirates.battleships.network.network.module.ClientNetworkModule;
import de.upb.codingpirates.battleships.network.util.ClientReaderMethod;
import de.upb.codingpirates.battleships.network.util.DefaultReaderMethod;

import javax.annotation.Nullable;

public class ClientModule extends AbstractModule {

    private final Class<? extends ClientConnector> clientCollector;
    private final Class<? extends ClientReaderMethod> clientReaderMethod;

    public ClientModule(@Nullable Class<? extends ClientConnector> clientCollector, @Nullable Class<? extends ClientReaderMethod> readerMethod) {
        if(clientCollector != null)
            this.clientCollector = clientCollector;
        else
            this.clientCollector = ClientConnector.class;
        if(readerMethod != null)
            this.clientReaderMethod = readerMethod;
        else
            this.clientReaderMethod = DefaultReaderMethod.class;
    }

    @Override
    protected void configure() {
        this.install(new ClientNetworkModule());

        this.bind(ConnectionHandler.class).to(clientCollector).in(Singleton.class);
        this.bind(ClientConnector.class).in(Singleton.class);
        this.bind(ClientReaderMethod.class).to(clientReaderMethod);
    }

}