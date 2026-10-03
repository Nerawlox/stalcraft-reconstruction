/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import com.google.common.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraftforge.event.ASMEventHandler;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.ListenerList;

public class EventBus {
    private static int maxID = 0;
    private ConcurrentHashMap<Object, ArrayList<IEventListener>> listeners = new ConcurrentHashMap();
    private final int busID = maxID++;

    public EventBus() {
        ListenerList.resize(this.busID + 1);
    }

    public void register(Object object) {
        if (this.listeners.containsKey(object)) {
            return;
        }
        Set set = TypeToken.of(object.getClass()).getTypes().rawTypes();
        block2: for (Method method : object.getClass().getMethods()) {
            for (Class clazz : set) {
                try {
                    Method method2 = clazz.getDeclaredMethod(method.getName(), method.getParameterTypes());
                    if (!method2.isAnnotationPresent(ForgeSubscribe.class)) continue;
                    Class<?>[] classArray = method.getParameterTypes();
                    if (classArray.length != 1) {
                        throw new IllegalArgumentException("Method " + method + " has @ForgeSubscribe annotation, but requires " + classArray.length + " arguments.  Event handler methods must require a single argument.");
                    }
                    Class<?> clazz2 = classArray[0];
                    if (!Event.class.isAssignableFrom(clazz2)) {
                        throw new IllegalArgumentException("Method " + method + " has @ForgeSubscribe annotation, but takes a argument that is not a Event " + clazz2);
                    }
                    this.register(clazz2, object, method);
                    continue block2;
                }
                catch (NoSuchMethodException noSuchMethodException) {
                }
            }
        }
    }

    private void register(Class<?> clazz, Object object, Method method) {
        try {
            Constructor<?> constructor = clazz.getConstructor(new Class[0]);
            constructor.setAccessible(true);
            Event event = (Event)constructor.newInstance(new Object[0]);
            ASMEventHandler aSMEventHandler = new ASMEventHandler(object, method);
            event.getListenerList().register(this.busID, aSMEventHandler.getPriority(), aSMEventHandler);
            ArrayList<IEventListener> arrayList = this.listeners.get(object);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.listeners.put(object, arrayList);
            }
            arrayList.add(aSMEventHandler);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void unregister(Object object) {
        ArrayList<IEventListener> arrayList = this.listeners.remove(object);
        for (IEventListener iEventListener : arrayList) {
            ListenerList.unregiterAll(this.busID, iEventListener);
        }
    }

    public boolean post(Event event) {
        IEventListener[] iEventListenerArray;
        for (IEventListener iEventListener : iEventListenerArray = event.getListenerList().getListeners(this.busID)) {
            iEventListener.invoke(event);
        }
        return event.isCancelable() ? event.isCanceled() : false;
    }
}

