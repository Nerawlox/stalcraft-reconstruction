/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import com.google.common.base.Throwables;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.event.FMLStateEvent;

public enum LoaderState {
    NOINIT("Uninitialized", null),
    LOADING("Loading", null),
    CONSTRUCTING("Constructing mods", FMLConstructionEvent.class),
    PREINITIALIZATION("Pre-initializing mods", FMLPreInitializationEvent.class),
    INITIALIZATION("Initializing mods", FMLInitializationEvent.class),
    POSTINITIALIZATION("Post-initializing mods", FMLPostInitializationEvent.class),
    AVAILABLE("Mod loading complete", FMLLoadCompleteEvent.class),
    SERVER_ABOUT_TO_START("Server about to start", FMLServerAboutToStartEvent.class),
    SERVER_STARTING("Server starting", FMLServerStartingEvent.class),
    SERVER_STARTED("Server started", FMLServerStartedEvent.class),
    SERVER_STOPPING("Server stopping", FMLServerStoppingEvent.class),
    SERVER_STOPPED("Server stopped", FMLServerStoppedEvent.class),
    ERRORED("Mod Loading errored", null);

    private Class<? extends FMLStateEvent> eventClass;
    private String name;

    private LoaderState(String string2, Class<? extends FMLStateEvent> clazz) {
        this.name = string2;
        this.eventClass = clazz;
    }

    public LoaderState transition(boolean bl) {
        if (bl) {
            return ERRORED;
        }
        if (this == SERVER_STOPPED) {
            return AVAILABLE;
        }
        return LoaderState.values()[this.ordinal() < LoaderState.values().length ? this.ordinal() + 1 : this.ordinal()];
    }

    public boolean hasEvent() {
        return this.eventClass != null;
    }

    public FMLStateEvent getEvent(Object ... objectArray) {
        try {
            return this.eventClass.getConstructor(Object[].class).newInstance(new Object[]{objectArray});
        }
        catch (Exception exception) {
            throw Throwables.propagate(exception);
        }
    }

    public LoaderState requiredState() {
        if (this == NOINIT) {
            return NOINIT;
        }
        return LoaderState.values()[this.ordinal() - 1];
    }

    public static enum ModState {
        UNLOADED("Unloaded"),
        LOADED("Loaded"),
        CONSTRUCTED("Constructed"),
        PREINITIALIZED("Pre-initialized"),
        INITIALIZED("Initialized"),
        POSTINITIALIZED("Post-initialized"),
        AVAILABLE("Available"),
        DISABLED("Disabled"),
        ERRORED("Errored");

        private String label;

        private ModState(String string2) {
            this.label = string2;
        }

        public String toString() {
            return this.label;
        }
    }
}

