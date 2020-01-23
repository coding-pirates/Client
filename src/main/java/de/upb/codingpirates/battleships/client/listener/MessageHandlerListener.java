package de.upb.codingpirates.battleships.client.listener;

public interface MessageHandlerListener {

    default boolean invalidated(){
        return false;
    }
}
