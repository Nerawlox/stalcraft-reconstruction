/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine;

import gloomyfolken.mods.core.client.gui.engine.GuiActionHandler;
import gloomyfolken.mods.core.client.gui.engine.IActionHandler;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.action.GuiAction;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.tuple.ImmutablePair;

public class ActionManager {
    private static HashMap<Class<? extends IAdvancedGui>, HashMap<Class<? extends GuiAction>, Method>> globalActionHandlers = new HashMap();
    private HashMap<ImmutablePair<GuiComponent, Class<? extends GuiAction>>, List<IActionHandler>> componentActionHandlers = new HashMap();
    private final IAdvancedGui gui;
    private boolean loaded;

    public ActionManager(IAdvancedGui iAdvancedGui) {
        this.gui = iAdvancedGui;
        this.loadHandlersMap();
    }

    protected void loadHandlersMap() {
        if (!globalActionHandlers.containsKey(this.gui.getClass())) {
            HashMap hashMap = new HashMap();
            for (Method method : this.gui.getClass().getMethods()) {
                boolean bl = false;
                for (Annotation annotation : method.getAnnotations()) {
                    if (!annotation.annotationType().equals(GuiActionHandler.class)) continue;
                    bl = true;
                }
                if (!bl || method.getParameterTypes().length != 1 || !GuiAction.class.isAssignableFrom(method.getParameterTypes()[0])) continue;
                method.setAccessible(true);
                hashMap.put(method.getParameterTypes()[0], method);
            }
            globalActionHandlers.put(this.gui.getClass(), hashMap);
        }
    }

    public <R extends GuiComponent, T extends GuiAction<R>> void registerActionHandler(R r, Class<T> clazz, IActionHandler<T> iActionHandler) {
        ImmutablePair<Class<T>, Class<T>> immutablePair = new ImmutablePair<Class<T>, Class<T>>(r, clazz);
        if (this.componentActionHandlers.containsKey(immutablePair)) {
            this.componentActionHandlers.get(immutablePair).add(iActionHandler);
        } else {
            ArrayList<IActionHandler<T>> arrayList = new ArrayList<IActionHandler<T>>();
            arrayList.add(iActionHandler);
            this.componentActionHandlers.put(immutablePair, arrayList);
        }
    }

    public void processAction(GuiAction guiAction) {
        ImmutablePair immutablePair;
        List<IActionHandler> list2;
        if (!this.loaded) {
            return;
        }
        Method method = globalActionHandlers.get(this.gui.getClass()).get(guiAction.getClass());
        if (method != null) {
            try {
                method.invoke(this.gui, guiAction);
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
            catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
        }
        if ((list2 = this.componentActionHandlers.get(immutablePair = new ImmutablePair(guiAction.component, guiAction.getClass()))) != null) {
            for (IActionHandler iActionHandler : list2) {
                iActionHandler.processAction(guiAction);
            }
        }
    }

    public void setLoaded(boolean bl) {
        this.loaded = bl;
    }
}

