/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IFMLHandledException;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.LoaderState;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.event.FMLEvent;
import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLStateEvent;
import cpw.mods.fml.common.functions.ArtifactVersionNameFunction;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadController {
    private Loader loader;
    private EventBus masterChannel;
    private ImmutableMap<String, EventBus> eventChannels;
    private LoaderState state;
    private Multimap<String, LoaderState.ModState> modStates = ArrayListMultimap.create();
    private Multimap<String, Throwable> errors = ArrayListMultimap.create();
    private Map<String, ModContainer> modList;
    private List<ModContainer> activeModList = Lists.newArrayList();
    private ModContainer activeContainer;
    private BiMap<ModContainer, Object> modObjectList;

    public LoadController(Loader loader) {
        this.loader = loader;
        this.masterChannel = new EventBus("FMLMainChannel");
        this.masterChannel.register(this);
        this.state = LoaderState.NOINIT;
    }

    @Subscribe
    public void buildModList(FMLLoadEvent fMLLoadEvent) {
        this.modList = this.loader.getIndexedModList();
        ImmutableMap.Builder<String, EventBus> builder = ImmutableMap.builder();
        for (ModContainer modContainer : this.loader.getModList()) {
            FMLRelaunchLog.makeLog(modContainer.getModId());
            Logger logger = Logger.getLogger(modContainer.getModId());
            Logger logger2 = Logger.getLogger(EventBus.class.getName() + "." + modContainer.getModId());
            logger2.setParent(logger);
            EventBus eventBus = new EventBus(modContainer.getModId());
            boolean bl = modContainer.registerBus(eventBus, this);
            if (bl) {
                Level level = Logger.getLogger(modContainer.getModId()).getLevel();
                FMLLog.log(modContainer.getModId(), Level.FINE, "Mod Logging channel %s configured at %s level.", modContainer.getModId(), level == null ? "default" : level);
                FMLLog.log(modContainer.getModId(), Level.INFO, "Activating mod %s", modContainer.getModId());
                this.activeModList.add(modContainer);
                this.modStates.put(modContainer.getModId(), LoaderState.ModState.UNLOADED);
                builder.put(modContainer.getModId(), eventBus);
                FMLCommonHandler.instance().addModToResourcePack(modContainer);
                continue;
            }
            FMLLog.log(modContainer.getModId(), Level.WARNING, "Mod %s has been disabled through configuration", modContainer.getModId());
            this.modStates.put(modContainer.getModId(), LoaderState.ModState.UNLOADED);
            this.modStates.put(modContainer.getModId(), LoaderState.ModState.DISABLED);
        }
        this.eventChannels = builder.build();
        FMLCommonHandler.instance().updateResourcePackList();
    }

    public void distributeStateMessage(LoaderState loaderState, Object ... objectArray) {
        if (loaderState.hasEvent()) {
            this.masterChannel.post(loaderState.getEvent(objectArray));
        }
    }

    public void transition(LoaderState loaderState, boolean bl) {
        LoaderState loaderState2 = this.state;
        this.state = this.state.transition(!this.errors.isEmpty());
        if (this.state != loaderState && !bl) {
            Throwable throwable = null;
            FMLLog.severe("Fatal errors were detected during the transition from %s to %s. Loading cannot continue", new Object[]{loaderState2, loaderState});
            StringBuilder stringBuilder = new StringBuilder();
            this.printModStates(stringBuilder);
            FMLLog.getLogger().severe(stringBuilder.toString());
            if (this.errors.size() > 0) {
                FMLLog.severe("The following problems were captured during this phase", new Object[0]);
                for (Map.Entry<String, Throwable> entry : this.errors.entries()) {
                    FMLLog.log(Level.SEVERE, entry.getValue(), "Caught exception from %s", entry.getKey());
                    if (entry.getValue() instanceof IFMLHandledException) {
                        throwable = entry.getValue();
                        continue;
                    }
                    if (throwable != null) continue;
                    throwable = entry.getValue();
                }
            } else {
                FMLLog.severe("The ForgeModLoader state engine has become corrupted. Probably, a state was missed by and invalid modification to a base classForgeModLoader depends on. This is a critical error and not recoverable. Investigate any modifications to base classes outside ofForgeModLoader, especially Optifine, to see if there are fixes available.", new Object[0]);
                throw new RuntimeException("The ForgeModLoader state engine is invalid");
            }
            if (throwable != null && throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            throw new LoaderException(throwable);
        }
        if (this.state != loaderState && bl) {
            FMLLog.info("The state engine was in incorrect state %s and forced into state %s. Errors may have been discarded.", new Object[]{this.state, loaderState});
            this.forceState(loaderState);
        }
    }

    public ModContainer activeContainer() {
        return this.activeContainer;
    }

    @Subscribe
    public void propogateStateMessage(FMLEvent fMLEvent) {
        if (fMLEvent instanceof FMLPreInitializationEvent) {
            this.modObjectList = this.buildModObjectList();
        }
        for (ModContainer modContainer : this.activeModList) {
            this.sendEventToModContainer(fMLEvent, modContainer);
        }
    }

    private void sendEventToModContainer(FMLEvent fMLEvent, ModContainer modContainer) {
        String string = modContainer.getModId();
        Collection<String> collection = Collections2.transform(modContainer.getRequirements(), new ArtifactVersionNameFunction());
        for (ArtifactVersion artifactVersion : modContainer.getDependencies()) {
            if (artifactVersion.getLabel() == null || !collection.contains(artifactVersion.getLabel()) || !this.modStates.containsEntry(artifactVersion.getLabel(), (Object)LoaderState.ModState.ERRORED)) continue;
            FMLLog.log(string, Level.SEVERE, "Skipping event %s and marking errored mod %s since required dependency %s has errored", fMLEvent.getEventType(), string, artifactVersion.getLabel());
            this.modStates.put(string, LoaderState.ModState.ERRORED);
            return;
        }
        this.activeContainer = modContainer;
        fMLEvent.applyModContainer(this.activeContainer());
        FMLLog.log(string, Level.FINEST, "Sending event %s to mod %s", fMLEvent.getEventType(), string);
        this.eventChannels.get(string).post(fMLEvent);
        FMLLog.log(string, Level.FINEST, "Sent event %s to mod %s", fMLEvent.getEventType(), string);
        this.activeContainer = null;
        if (fMLEvent instanceof FMLStateEvent) {
            if (!this.errors.containsKey(string)) {
                this.modStates.put(string, ((FMLStateEvent)fMLEvent).getModState());
            } else {
                this.modStates.put(string, LoaderState.ModState.ERRORED);
            }
        }
    }

    public ImmutableBiMap<ModContainer, Object> buildModObjectList() {
        ImmutableBiMap.Builder builder = ImmutableBiMap.builder();
        for (ModContainer modContainer : this.activeModList) {
            if (!modContainer.isImmutable() && modContainer.getMod() != null) {
                builder.put(modContainer, modContainer.getMod());
            }
            if (modContainer.getMod() != null || modContainer.isImmutable() || this.state == LoaderState.CONSTRUCTING) continue;
            FMLLog.severe("There is a severe problem with %s - it appears not to have constructed correctly", modContainer.getModId());
            if (this.state == LoaderState.CONSTRUCTING) continue;
            this.errorOccurred(modContainer, new RuntimeException());
        }
        return builder.build();
    }

    public void errorOccurred(ModContainer modContainer, Throwable throwable) {
        if (throwable instanceof InvocationTargetException) {
            this.errors.put(modContainer.getModId(), ((InvocationTargetException)throwable).getCause());
        } else {
            this.errors.put(modContainer.getModId(), throwable);
        }
    }

    public void printModStates(StringBuilder stringBuilder) {
        for (ModContainer modContainer : this.loader.getModList()) {
            stringBuilder.append("\n\t").append(modContainer.getModId()).append("{").append(modContainer.getVersion()).append("} [").append(modContainer.getName()).append("] (").append(modContainer.getSource().getName()).append(") ");
            Joiner.on("->").appendTo(stringBuilder, (Iterable<?>)this.modStates.get(modContainer.getModId()));
        }
    }

    public List<ModContainer> getActiveModList() {
        return this.activeModList;
    }

    public LoaderState.ModState getModState(ModContainer modContainer) {
        return Iterables.getLast(this.modStates.get(modContainer.getModId()), LoaderState.ModState.AVAILABLE);
    }

    public void distributeStateMessage(Class<?> clazz) {
        try {
            this.masterChannel.post(clazz.newInstance());
        }
        catch (Exception exception) {
            FMLLog.log(Level.SEVERE, exception, "An unexpected exception", new Object[0]);
            throw new LoaderException(exception);
        }
    }

    public BiMap<ModContainer, Object> getModObjectList() {
        if (this.modObjectList == null) {
            FMLLog.severe("Detected an attempt by a mod %s to perform game activity during mod construction. This is a serious programming error.", this.activeContainer);
            return this.buildModObjectList();
        }
        return ImmutableBiMap.copyOf(this.modObjectList);
    }

    public boolean isInState(LoaderState loaderState) {
        return this.state == loaderState;
    }

    boolean hasReachedState(LoaderState loaderState) {
        return this.state.ordinal() >= loaderState.ordinal() && this.state != LoaderState.ERRORED;
    }

    void forceState(LoaderState loaderState) {
        this.state = loaderState;
    }
}

