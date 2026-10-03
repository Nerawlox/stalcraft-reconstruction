/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.event;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.FMLModContainer;
import cpw.mods.fml.common.LoaderState;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.event.FMLStateEvent;
import java.io.File;
import java.security.CodeSource;
import java.security.cert.Certificate;
import java.util.Properties;
import java.util.logging.Logger;

public class FMLPreInitializationEvent
extends FMLStateEvent {
    private ModMetadata modMetadata;
    private File sourceFile;
    private File configurationDir;
    private File suggestedConfigFile;
    private ASMDataTable asmData;
    private ModContainer modContainer;

    public FMLPreInitializationEvent(Object ... objectArray) {
        super(objectArray);
        this.asmData = (ASMDataTable)objectArray[0];
        this.configurationDir = (File)objectArray[1];
    }

    @Override
    public LoaderState.ModState getModState() {
        return LoaderState.ModState.PREINITIALIZED;
    }

    @Override
    public void applyModContainer(ModContainer modContainer) {
        this.modContainer = modContainer;
        this.modMetadata = modContainer.getMetadata();
        this.sourceFile = modContainer.getSource();
        this.suggestedConfigFile = new File(this.configurationDir, modContainer.getModId() + ".cfg");
    }

    public File getSourceFile() {
        return this.sourceFile;
    }

    public ModMetadata getModMetadata() {
        return this.modMetadata;
    }

    public File getModConfigurationDirectory() {
        return this.configurationDir;
    }

    public File getSuggestedConfigurationFile() {
        return this.suggestedConfigFile;
    }

    public ASMDataTable getAsmData() {
        return this.asmData;
    }

    public Properties getVersionProperties() {
        if (this.modContainer instanceof FMLModContainer) {
            return ((FMLModContainer)this.modContainer).searchForVersionProperties();
        }
        return null;
    }

    public Logger getModLog() {
        Logger logger = Logger.getLogger(this.modContainer.getModId());
        logger.setParent(FMLLog.getLogger());
        return logger;
    }

    @Deprecated
    public Certificate[] getFMLSigningCertificates() {
        CodeSource codeSource = this.getClass().getClassLoader().getParent().getClass().getProtectionDomain().getCodeSource();
        Certificate[] certificateArray = codeSource.getCertificates();
        if (certificateArray == null) {
            return new Certificate[0];
        }
        return certificateArray;
    }
}

