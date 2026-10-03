/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.ListenerList;

public class Event {
    private boolean isCanceled = false;
    private final boolean isCancelable;
    private Result result = Result.DEFAULT;
    private final boolean hasResult;
    private static ListenerList listeners = new ListenerList();
    private static final Map<Class, Map<Class, Boolean>> annotationMap = new ConcurrentHashMap<Class, Map<Class, Boolean>>();

    public Event() {
        this.setup();
        this.isCancelable = this.hasAnnotation(Cancelable.class);
        this.hasResult = this.hasAnnotation(HasResult.class);
    }

    private boolean hasAnnotation(Class clazz) {
        Boolean bl;
        Class<?> clazz2 = this.getClass();
        Map<Class, Boolean> map = annotationMap.get(clazz2);
        if (map == null) {
            map = new ConcurrentHashMap<Class, Boolean>();
            annotationMap.put(clazz2, map);
        }
        if ((bl = map.get(clazz)) != null) {
            return bl;
        }
        for (Class<?> clazz3 = clazz2; clazz3 != Event.class; clazz3 = clazz3.getSuperclass()) {
            if (!clazz3.isAnnotationPresent(clazz)) continue;
            map.put(clazz, true);
            return true;
        }
        map.put(clazz, false);
        return false;
    }

    public boolean isCancelable() {
        return this.isCancelable;
    }

    public boolean isCanceled() {
        return this.isCanceled;
    }

    public void setCanceled(boolean bl) {
        if (!this.isCancelable()) {
            throw new IllegalArgumentException("Attempted to cancel a uncancelable event");
        }
        this.isCanceled = bl;
    }

    public boolean hasResult() {
        return this.hasResult;
    }

    public Result getResult() {
        return this.result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    protected void setup() {
    }

    public ListenerList getListenerList() {
        return listeners;
    }

    public static enum Result {
        DENY,
        DEFAULT,
        ALLOW;

    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.TYPE})
    public static @interface HasResult {
    }
}

