package de.upb.codingpirates.battleships.client;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;
import de.upb.codingpirates.battleships.client.listener.MessageHandlerListener;
import org.roboguice.shaded.goole.common.collect.Maps;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@SuppressWarnings("UnstableApiUsage")
public class ListenerHandler {
    private static final List EMPTY = ImmutableList.of();

    private static Map<TypeToken<?>, List<MessageHandlerListener>> listeners = Collections.synchronizedMap(Maps.newHashMap());
    private static List<MessageHandlerListener> allListener = Collections.synchronizedList(Lists.newArrayList());

    public static void registerListener(MessageHandlerListener listener) {
        if(allListener.contains(listener))
            return;
        allListener.add(listener);
        for (TypeToken<?> token:TypeToken.of(listener.getClass()).getTypes().interfaces()){
            if (!listeners.containsKey(token)) {
                listeners.put(token, Lists.newArrayList());
            }
            if (!listeners.get(token).contains(listener))
                listeners.get(token).add(listener);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends MessageHandlerListener> List<T> get(Class<T> listener){
        return listeners.containsKey(TypeToken.of(listener)) ? (List<T>)listeners.get(TypeToken.of(listener)):EMPTY;
    }

}
