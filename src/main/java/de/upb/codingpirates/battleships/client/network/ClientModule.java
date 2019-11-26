package de.upb.codingpirates.battleships.client.network;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import de.upb.codingpirates.battleships.network.ConnectionHandler;
import de.upb.codingpirates.battleships.network.network.module.ClientNetworkModule;

public class ClientModule extends AbstractModule {
    @Override
    protected void configure() {
        this.install(new ClientNetworkModule());

        this.bind(ConnectionHandler.class).to(ClientConnector.class).in(Singleton.class);
    }
}