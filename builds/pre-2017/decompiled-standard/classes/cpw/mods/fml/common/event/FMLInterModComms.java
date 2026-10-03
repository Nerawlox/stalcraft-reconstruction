/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.event;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderState;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.event.FMLEvent;

public class FMLInterModComms {
    private static final ImmutableList<IMCMessage> emptyIMCList = ImmutableList.of();
    private static ArrayListMultimap<String, IMCMessage> modMessages = ArrayListMultimap.create();

    public static boolean sendMessage(String string, String string2, qoac qoac2) {
        return FMLInterModComms.enqueueStartupMessage(string, new IMCMessage(string2, qoac2));
    }

    public static boolean sendMessage(String string, String string2, cvzo cvzo2) {
        return FMLInterModComms.enqueueStartupMessage(string, new IMCMessage(string2, cvzo2));
    }

    public static boolean sendMessage(String string, String string2, String string3) {
        return FMLInterModComms.enqueueStartupMessage(string, new IMCMessage(string2, string3));
    }

    public static void sendRuntimeMessage(Object object, String string, String string2, qoac qoac2) {
        FMLInterModComms.enqueueMessage(object, string, new IMCMessage(string2, qoac2));
    }

    public static void sendRuntimeMessage(Object object, String string, String string2, cvzo cvzo2) {
        FMLInterModComms.enqueueMessage(object, string, new IMCMessage(string2, cvzo2));
    }

    public static void sendRuntimeMessage(Object object, String string, String string2, String string3) {
        FMLInterModComms.enqueueMessage(object, string, new IMCMessage(string2, string3));
    }

    private static boolean enqueueStartupMessage(String string, IMCMessage iMCMessage) {
        if (Loader.instance().activeModContainer() == null) {
            return false;
        }
        FMLInterModComms.enqueueMessage(Loader.instance().activeModContainer(), string, iMCMessage);
        return Loader.isModLoaded(string) && !Loader.instance().hasReachedState(LoaderState.POSTINITIALIZATION);
    }

    private static void enqueueMessage(Object object, String string, IMCMessage iMCMessage) {
        ModContainer modContainer = object instanceof ModContainer ? (ModContainer)object : FMLCommonHandler.instance().findContainerFor(object);
        if (modContainer != null && Loader.isModLoaded(string)) {
            iMCMessage.setSender(modContainer);
            modMessages.put((Object)string, (Object)iMCMessage);
        }
    }

    public static ImmutableList<IMCMessage> fetchRuntimeMessages(Object object) {
        ModContainer modContainer = FMLCommonHandler.instance().findContainerFor(object);
        if (modContainer != null) {
            return ImmutableList.copyOf(modMessages.removeAll(modContainer.getModId()));
        }
        return emptyIMCList;
    }

    public static final class IMCMessage {
        private String sender;
        public final String key;
        private Object value;

        private IMCMessage(String string, Object object) {
            this.key = string;
            this.value = object;
        }

        public String toString() {
            return this.sender;
        }

        public String getSender() {
            return this.sender;
        }

        void setSender(ModContainer modContainer) {
            this.sender = modContainer.getModId();
        }

        public String getStringValue() {
            return (String)this.value;
        }

        public qoac getNBTValue() {
            return (qoac)this.value;
        }

        public cvzo getItemStackValue() {
            return (cvzo)this.value;
        }

        public Class<?> getMessageType() {
            return this.value.getClass();
        }

        public boolean isStringMessage() {
            return String.class.isAssignableFrom(this.getMessageType());
        }

        public boolean isItemStackMessage() {
            return cvzo.class.isAssignableFrom(this.getMessageType());
        }

        public boolean isNBTMessage() {
            return qoac.class.isAssignableFrom(this.getMessageType());
        }
    }

    public static class IMCEvent
    extends FMLEvent {
        private ModContainer activeContainer;
        private ImmutableList<IMCMessage> currentList;

        @Override
        public void applyModContainer(ModContainer modContainer) {
            this.activeContainer = modContainer;
            this.currentList = null;
            FMLLog.finest("Attempting to deliver %d IMC messages to mod %s", modMessages.get(modContainer.getModId()).size(), modContainer.getModId());
        }

        public ImmutableList<IMCMessage> getMessages() {
            if (this.currentList == null) {
                this.currentList = ImmutableList.copyOf(modMessages.removeAll(this.activeContainer.getModId()));
            }
            return this.currentList;
        }
    }
}

