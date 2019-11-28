package de.upb.codingpirates.battleships.client.network;

import de.upb.codingpirates.battleships.client.Handler;
import de.upb.codingpirates.battleships.client.MessageHandler;

public class ClientModule extends AbstractClientModule {
    @Override
    protected void configure() {
        super.configure();

        this.bind(Handler.class).toInstance(new MessageHandler());
    }
}
