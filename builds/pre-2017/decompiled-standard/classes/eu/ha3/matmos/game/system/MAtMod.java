/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.system;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eu.ha3.easy.TimeStatistic;
import eu.ha3.matmos.conv.CustomVolume;
import eu.ha3.matmos.conv.Expansion;
import eu.ha3.matmos.conv.ExpansionManager;
import eu.ha3.matmos.conv.MAtmosConvLogger;
import eu.ha3.matmos.game.data.MAtCatchAllRequirements;
import eu.ha3.matmos.game.data.MAtDataGatherer;
import eu.ha3.matmos.game.system.Chatter;
import eu.ha3.matmos.game.system.MAtCacheRegistry;
import eu.ha3.matmos.game.system.MAtModPhase;
import eu.ha3.matmos.game.system.MAtSoundManagerMaster;
import eu.ha3.matmos.game.user.MAtUserControl;
import eu.ha3.matmos.requirem.Requirements;
import eu.ha3.mc.haddon.Identity;
import eu.ha3.mc.haddon.OperatorCaster;
import eu.ha3.mc.haddon.SupportsFrameEvents;
import eu.ha3.mc.haddon.SupportsKeyEvents;
import eu.ha3.mc.haddon.SupportsTickEvents;
import eu.ha3.mc.haddon.implem.Ha3SoundCommunicator;
import eu.ha3.mc.haddon.implem.HaddonIdentity;
import eu.ha3.mc.haddon.implem.HaddonImpl;
import eu.ha3.util.property.simple.ConfigProperty;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import net.minecraft.client.settings.eidj;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class MAtMod
extends HaddonImpl
implements cvkw,
SupportsFrameEvents,
SupportsKeyEvents,
SupportsTickEvents {
    public static final int VERSION = 26;
    public static final String FOR = "1.6.4";
    public static final String MOD_RAW_NAME = "MAtmos";
    public static final String MOD_VERSIONNED_NAME = "MAtmos r26 for 1.6.4";
    protected final String ADDRESS = "http://matmos.ha3.eu";
    protected final Identity identity = new HaddonIdentity("MAtmos", 26, "1.6.4", this.ADDRESS);
    public static final MAtmosConvLogger LOGGER = new MAtmosConvLogger();
    private File matmosFolder;
    private File packsFolder;
    private MAtModPhase phase = MAtModPhase.NOT_INITIALIZED;
    private ConfigProperty config;
    private ExpansionManager expansionManager;
    private boolean dataRoll;
    private Ha3SoundCommunicator sndComm;
    private MAtUserControl userControl;
    private MAtDataGatherer dataGatherer;
    private MAtSoundManagerMaster soundManagerMaster;
    private boolean isFatalError;
    private boolean isRunning;
    private TimeStatistic timeStatistic;
    private boolean dumpReady = false;
    private Chatter chatter;

    public MAtMod() {
        MAtmosConvLogger.setRefinedness(1);
    }

    @Override
    public void onLoad() {
        this.util().registerPrivateGetter("currentServerData", xpzm.class, -1, "currentServerData", "_g", "M");
        this.util().registerPrivateGetter("sndSystem", jzqf.class, -1, "sndSystem", "_c", "b");
        this.util().registerPrivateGetter("soundPoolSounds", jzqf.class, -1, "soundPoolSounds", "_e", "d");
        this.util().registerPrivateGetter("isJumping", EntityLivingBase.class, -1, "isJumping", "field_70703_bu", "bd");
        this.util().registerPrivateGetter("isInWeb", Entity.class, -1, "isInWeb", "field_70134_J", "K");
        this.chatter = new Chatter(this, MOD_RAW_NAME);
        ((OperatorCaster)this.op()).setTickEnabled(true);
        ((OperatorCaster)this.op()).setFrameEnabled(true);
        this.matmosFolder = new File(this.util().getModsFolder(), "matmos/");
        if (!this.matmosFolder.exists()) {
            this.isFatalError = true;
            return;
        }
        this.packsFolder = new File(this.matmosFolder, "packs/");
        if (!this.packsFolder.exists()) {
            this.isFatalError = true;
            return;
        }
        this.timeStatistic = new TimeStatistic(Locale.ENGLISH);
        this.sndComm = new Ha3SoundCommunicator(this, "MAtmos_");
        this.userControl = new MAtUserControl(this);
        this.dataGatherer = new MAtDataGatherer(this);
        this.expansionManager = new ExpansionManager("expansions_r25/", new File(this.matmosFolder, "expansions_r25_userconfig/"), this.packsFolder, new MAtCacheRegistry());
        this.config = new ConfigProperty();
        this.config.setProperty("world.height", 256);
        this.config.setProperty("dump.sheets.enabled", false);
        this.config.setProperty("start.enabled", true);
        this.config.setProperty("reversed.controls", false);
        this.config.setProperty("sound.autopreview", true);
        this.config.setProperty("globalvolume.scale", Float.valueOf(1.0f));
        this.config.setProperty("key.code", 65);
        this.config.setProperty("useroptions.altitudes.high", true);
        this.config.setProperty("useroptions.altitudes.low", true);
        this.config.setProperty("useroptions.biome.override", -1);
        this.config.setProperty("debug.mode", 0);
        this.config.setProperty("minecraftsound.ambient.volume", Float.valueOf(1.0f));
        this.config.setProperty("update_found.enabled", true);
        this.config.setProperty("update_found.version", 26);
        this.config.setProperty("update_found.display.remaining.value", 0);
        this.config.setProperty("update_found.display.count.value", 3);
        this.config.commit();
        try {
            this.config.setSource(new File(this.util().getModsFolder(), "matmos/userconfig.cfg").getCanonicalPath());
            this.config.load();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            throw new RuntimeException("Error caused config not to work: " + iOException.getMessage());
        }
        this.createSoundManagerMaster();
        this.userControl.load();
        MAtmosConvLogger.info("Took " + this.timeStatistic.getSecondsAsString(3) + " seconds to setup MAtmos base.");
        this.phase = MAtModPhase.NOT_YET_ENABLED;
        if (this.config.getBoolean("start.enabled")) {
            this.initializeAndEnable();
        }
    }

    private void appendResourcePacks() {
        for (File file : this.packsFolder.listFiles()) {
            if (!file.isDirectory()) continue;
            MAtmosConvLogger.info("Adding resource pack at " + file.getAbsolutePath());
        }
        xpzm._E()._c();
    }

    public void initializeAndEnable() {
        Object object;
        if (this.phase != MAtModPhase.NOT_YET_ENABLED) {
            return;
        }
        this.phase = MAtModPhase.CONSTRUCTING;
        this.timeStatistic = new TimeStatistic(Locale.ENGLISH);
        MAtmosConvLogger.info("Constructing.");
        if (!this.config.getBoolean("dump.sheets.enabled")) {
            this.dataGatherer.load(this.expansionManager.getCollation());
        } else {
            object = new MAtCatchAllRequirements();
            this.dataGatherer.load((Requirements)object);
            ((MAtCatchAllRequirements)object).setData(this.dataGatherer.getData());
            this.dumpReady = true;
        }
        this.expansionManager.setMaster(this.soundManagerMaster);
        this.expansionManager.setData(this.dataGatherer.getData());
        this.expansionManager.loadExpansions();
        object = xpzm._E()._S();
        if (object instanceof ifzx) {
            MAtmosConvLogger.info("Adding resource reloading listener");
            ((ifzx)object)._a(this);
        } else {
            MAtmosConvLogger.severe("The base Resource Manager is not a reloadable instance. Unpredictable results will be caused by switching resource packs.");
        }
        this.phase = MAtModPhase.READY;
        MAtmosConvLogger.info("Ready.");
        this.startRunning();
        MAtmosConvLogger.info("Took " + this.timeStatistic.getSecondsAsString(3) + " seconds to enable MAtmos.");
    }

    private void createSoundManagerMaster() {
        this.soundManagerMaster = new MAtSoundManagerMaster(this);
        this.soundManagerMaster.setVolume(this.config.getFloat("globalvolume.scale"));
    }

    public void reloadAndStart() {
        if (!this.isReady()) {
            return;
        }
        if (this.isRunning) {
            return;
        }
        this.expansionManager.clearExpansions();
        TimeStatistic timeStatistic = new TimeStatistic(Locale.ENGLISH);
        this.expansionManager.loadExpansions();
        MAtmosConvLogger.info("Expansions loaded (" + timeStatistic.getSecondsAsString(1) + "s).");
        this.startRunning();
    }

    public void startRunning() {
        if (!this.isReady()) {
            return;
        }
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        MAtmosConvLogger.fine("Loading...");
        this.expansionManager.activate();
        MAtmosConvLogger.fine("Loaded.");
    }

    public void stopRunning() {
        if (!this.isReady()) {
            return;
        }
        if (!this.isRunning) {
            return;
        }
        this.isRunning = false;
        MAtmosConvLogger.fine("Stopping...");
        this.expansionManager.deactivate();
        MAtmosConvLogger.fine("Stopped.");
        this.createDataDump(false);
    }

    public boolean isDumpReady() {
        return this.dumpReady;
    }

    public void createDataDump(boolean bl) {
        Object object;
        Serializable serializable;
        String string2;
        if (!bl && !this.isDumpReady()) {
            if (this.config.getBoolean("dump.sheets.enabled")) {
                this.chatter.printChat("Warning: Data dumps requires Minecraft to be restarted, because data dumps must be already enabled when Minecraft starts to work.");
            }
            return;
        }
        if (bl) {
            this.chatter.printChat("\u00a7c", "Warning: Generating PARTIAL data dumps will normally yield the value 0 for every unused data by the currently loaded expansions. Only use PARTIAL data dumps to debug errors!");
        }
        MAtmosConvLogger.fine("Dumping data.");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap<String, Serializable> linkedHashMap2 = new LinkedHashMap<String, Serializable>();
        for (String string2 : this.dataGatherer.getData().getSheetNames()) {
            serializable = new ArrayList<Integer>();
            object = this.dataGatherer.getData().getSheet(string2);
            for (int i = 0; i < object.getSize(); ++i) {
                serializable.add(object.get(i));
            }
            linkedHashMap2.put(string2, serializable);
        }
        linkedHashMap.put("sheets", linkedHashMap2);
        Gson gson2 = new GsonBuilder().create();
        string2 = gson2.toJson(linkedHashMap);
        try {
            serializable = new File(this.matmosFolder, "matmos_dump.json");
            ((File)serializable).createNewFile();
            object = new FileWriter((File)serializable);
            ((Writer)object).write(string2);
            ((OutputStreamWriter)object).close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void saveConfig() {
        if (this.config.commit()) {
            MAtmosConvLogger.info("Saving configuration...");
            this.config.save();
        }
    }

    @Override
    public void onKey(eidj eidj2) {
        this.userControl.communicateKeyBindingEvent(eidj2);
    }

    @Override
    public void onFrame(float f) {
        if (this.isFatalError) {
            return;
        }
        if (!this.isRunning) {
            return;
        }
        this.expansionManager.soundRoutine();
        this.soundManagerMaster.routine();
        this.userControl.onFrame(f);
    }

    @Override
    public void onTick() {
        if (this.isFatalError) {
            this.chatter.printChat("\u00a7e", "A fatal error has occured. MAtmos will not load.");
            if (!new File(this.util().getModsFolder(), "matmos/").exists()) {
                this.chatter.printChat("\u00a7f", "Are you sure you installed MAtmos correctly?");
                this.chatter.printChat("\u00a7f", "The folder at (.minecraft/)", "\u00a7e", xpzm._E()._P.toURI().relativize(this.matmosFolder.toURI()).getPath(), "\u00a7e", " was NOT found. This folder should exist on a normal installation.");
            }
            ((OperatorCaster)this.op()).setTickEnabled(false);
            return;
        }
        this.userControl.onTick();
        if (this.isRunning) {
            if (!this.dataRoll) {
                this.dataRoll = true;
                this.dataGatherer.dataRoll();
            }
            this.dataGatherer.tickRoutine();
            this.expansionManager.dataRoutine();
        }
    }

    @Override
    public void func_110549_a(xsfs xsfs2) {
        MAtmosConvLogger.warning("ResourceManager has changed. Unintended side-effects results may happen.");
        if (this.isReady() && this.isRunning()) {
            this.expansionManager.neutralizeSoundManagers();
            this.stopRunning();
            this.createSoundManagerMaster();
            this.expansionManager.setMaster(this.soundManagerMaster);
            this.reloadAndStart();
        }
    }

    public MAtModPhase getPhase() {
        return this.phase;
    }

    public boolean isFatalError() {
        return this.isFatalError;
    }

    public boolean isReady() {
        return this.phase == MAtModPhase.READY;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public ConfigProperty getConfig() {
        return this.config;
    }

    public CustomVolume getGlobalVolumeControl() {
        return this.soundManagerMaster;
    }

    public Map<String, Expansion> getExpansionList() {
        return this.expansionManager.getExpansions();
    }

    public Ha3SoundCommunicator getSoundCommunicator() {
        return this.sndComm;
    }

    @Override
    public Identity getIdentity() {
        return this.identity;
    }

    public Chatter getChatter() {
        return this.chatter;
    }
}

