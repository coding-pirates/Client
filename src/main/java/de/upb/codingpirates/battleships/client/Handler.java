package de.upb.codingpirates.battleships.client;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;

import org.apache.logging.log4j.LogManager;
import org.roboguice.shaded.goole.common.collect.Maps;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import de.upb.codingpirates.battleships.client.listener.MessageHandlerListener;

@SuppressWarnings("UnstableApiUsage")
public class Handler {
    private static final List EMPTY = ImmutableList.of();

    private static Map<TypeToken<?>, List<MessageHandlerListener>> listeners = Collections.synchronizedMap(Maps.newHashMap());

    public static <T extends MessageHandlerListener> void registerListener(MessageHandlerListener listener){

        for (TypeToken<?> token:TypeToken.of(listener.getClass()).getTypes().interfaces()){
            if(!listeners.containsKey(token)){
                listeners.put(token,Lists.newArrayList());
            }
            listeners.get(token).add(listener);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends MessageHandlerListener> List<T> get(Class<T> listener){
        return listeners.containsKey(TypeToken.of(listener)) ? (List<T>)listeners.get(TypeToken.of(listener)):EMPTY;
    }

}
