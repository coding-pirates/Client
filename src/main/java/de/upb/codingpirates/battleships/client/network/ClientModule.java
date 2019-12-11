package de.upb.codingpirates.battleships.client.network;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.network.ConnectionHandler;
import de.upb.codingpirates.battleships.network.network.module.ClientNetworkModule;
import de.upb.codingpirates.battleships.network.util.ClientReaderMethod;
import de.upb.codingpirates.battleships.network.util.DefaultReaderMethod;

public class ClientModule<T extends ConnectionHandler> extends AbstractModule {

    private final Class<T> connectionHandler;
    private final Class<? extends ClientReaderMethod> clientReaderMethod;
    private final Class<? extends Handler> messageHandler;

    public ClientModule(Class<T> connectionHandler, Class<? extends Handler> messageHandler){
        this.connectionHandler = connectionHandler;
        this.clientReaderMethod = DefaultReaderMethod.class;
        this.messageHandler = messageHandler;
    }

    public ClientModule(Class<T> connectionHandler, Class<? extends ClientReaderMethod> readerMethod, Class<? extends Handler> messageHandler) {
        this.connectionHandler = connectionHandler;
        this.clientReaderMethod = readerMethod;
        this.messageHandler = messageHandler;
    }

    @Override
    protected void configure() {
        this.install(new ClientNetworkModule());

        this.bind(ConnectionHandler.class).to(connectionHandler).in(Singleton.class);
        this.bind(ClientReaderMethod.class).to(clientReaderMethod);
        this.bind(Handler.class).to(messageHandler);
    }

    public Class<T> getConnectionHandlerClass(){
        return connectionHandler;
    }

    public Class<? extends ClientReaderMethod> getClientReadeMethodClass(){
        return clientReaderMethod;
    }
}