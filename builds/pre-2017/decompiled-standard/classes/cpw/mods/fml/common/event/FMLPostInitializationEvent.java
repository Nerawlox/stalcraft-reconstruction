/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.event;

import com.google.common.base.Throwables;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderState;
import cpw.mods.fml.common.event.FMLStateEvent;

public class FMLPostInitializationEvent
extends FMLStateEvent {
    public FMLPostInitializationEvent(Object ... objectArray) {
        super(objectArray);
    }

    @Override
    public LoaderState.ModState getModState() {
        return LoaderState.ModState.POSTINITIALIZED;
    }

    public Object buildSoftDependProxy(String string, String string2) {
        if (Loader.isModLoaded(string)) {
            try {
                Class<?> clazz = Class.forName(string2, true, Loader.instance().getModClassLoader());
                return clazz.newInstance();
            }
            catch (Exception exception) {
                Throwables.propagateIfPossible(exception);
                return null;
            }
        }
        return null;
    }
}

