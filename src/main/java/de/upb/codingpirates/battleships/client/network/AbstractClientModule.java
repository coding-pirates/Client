package de.upb.codingpirates.battleships.client.network;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import de.upb.codingpirates.battleships.network.ConnectionHandler;
import de.upb.codingpirates.battleships.network.network.module.ClientNetworkModule;

public abstract class AbstractClientModule<T extends ConnectionHandler> extends AbstractModule {

    private Class<T> connection;

    public AbstractClientModule(Class<T> connection) {
        this.connection = connection;
    }

    @Override
    protected void configure() {
        this.install(new ClientNetworkModule());

        this.bind(ConnectionHandler.class).to(connection).in(Singleton.class);
    }
}