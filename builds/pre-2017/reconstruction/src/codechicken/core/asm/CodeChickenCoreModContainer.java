/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.asm;

import codechicken.core.CommonUtils;
import codechicken.core.internal.ClientTickHandler;
import codechicken.core.launch.CodeChickenCorePlugin;
import codechicken.lib.config.ConfigFile;
import codechicken.nei.ClientHandler;
import codechicken.nei.IDConflictReporter;
import codechicken.nei.ServerHandler;
import codechicken.nei.api.IConfigureNEI;
import codechicken.packager.Packager;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import cpw.mods.fml.client.FMLFileResourcePack;
import cpw.mods.fml.client.FMLFolderResourcePack;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.VersionParser;
import cpw.mods.fml.common.versioning.VersionRange;
import cpw.mods.fml.relauncher.Side;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Packager(getBaseDirectories={"CodeChickenCore"}, getName="CodeChickenCore", getVersion="0.9.0.9")
public class CodeChickenCoreModContainer
extends DummyModContainer {
    public static ConfigFile config;
    public static LinkedList<IConfigureNEI> plugins;
    private LoadController controller;

    public static void loadConfig() {
        File file = new File(CodeChickenCorePlugin.minecraftDir + "/config");
        if (!file.exists()) {
            file.mkdirs();
        }
        config = new ConfigFile(new File(file, "CodeChickenCore.cfg")).setComment("CodeChickenCore configuration file.");
    }

    public CodeChickenCoreModContainer() {
        super(new ModMetadata());
        ModMetadata modMetadata = this.getMetadata();
        modMetadata.modId = "CodeChickenCore";
        modMetadata.name = "CodeChicken Core";
        modMetadata.version = this.getClass().getAnnotation(Packager.class).getVersion();
        modMetadata.authorList = Arrays.asList("ChickenBones");
        modMetadata.description = "Base common code for all chickenbones mods.";
        modMetadata.url = "http://www.minecraftforum.net/topic/909223-";
    }

    @Override
    public List<ArtifactVersion> getDependants() {
        LinkedList<ArtifactVersion> linkedList = new LinkedList<ArtifactVersion>();
        linkedList.add(VersionParser.parseVersionReference("NotEnoughItems@[1.6.1.9,)"));
        linkedList.add(VersionParser.parseVersionReference("EnderStorage@[1.4.3.6,)"));
        linkedList.add(VersionParser.parseVersionReference("ChickenChunks@[1.3.3.4,)"));
        linkedList.add(VersionParser.parseVersionReference("Translocator@[1.1.0.15,)"));
        linkedList.add(VersionParser.parseVersionReference("WR-CBE|Core@[1.4.0.7,)"));
        return linkedList;
    }

    @Override
    public boolean registerBus(EventBus eventBus, LoadController loadController) {
        eventBus.register(this);
        this.controller = loadController;
        return true;
    }

    @Subscribe
    public void preInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
    }

    @Subscribe
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        if (fMLInitializationEvent.getSide().isClient()) {
            TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
        }
        if (CommonUtils.isClient()) {
            ClientHandler.load();
        }
        ServerHandler.load();
    }

    @Subscribe
    public void postInit(FMLPostInitializationEvent fMLPostInitializationEvent) {
        try {
            IDConflictReporter.postInit();
        }
        catch (Throwable throwable) {
            this.controller.errorOccurred(this, throwable);
        }
    }

    @Override
    public VersionRange acceptableMinecraftVersionRange() {
        return VersionParser.parseRange("[1.6.4]");
    }

    @Override
    public File getSource() {
        return CodeChickenCorePlugin.location;
    }

    @Override
    public Class<?> getCustomResourcePackClass() {
        System.out.println("CCC resource pack: " + this.getSource());
        if (this.getSource() == null) {
            return null;
        }
        return this.getSource().isDirectory() ? FMLFolderResourcePack.class : FMLFileResourcePack.class;
    }

    static {
        plugins = new LinkedList();
    }
}

