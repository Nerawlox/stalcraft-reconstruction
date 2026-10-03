/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import com.google.common.eventbus.EventBus;
import cpw.mods.fml.client.FMLFileResourcePack;
import cpw.mods.fml.client.FMLFolderResourcePack;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.WorldAccessContainer;
import cpw.mods.fml.common.asm.FMLSanityChecker;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;
import java.io.File;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

public class FMLDummyContainer
extends DummyModContainer
implements WorldAccessContainer {
    public FMLDummyContainer() {
        super(new ModMetadata());
        ModMetadata modMetadata = this.getMetadata();
        modMetadata.modId = "FML";
        modMetadata.name = "Forge Mod Loader";
        modMetadata.version = Loader.instance().getFMLVersionString();
        modMetadata.credits = "Made possible with help from many people";
        modMetadata.authorList = Arrays.asList("cpw, LexManos");
        modMetadata.description = "The Forge Mod Loader provides the ability for systems to load mods from the file system. It also provides key capabilities for mods to be able to cooperate and provide a good modding environment. The mod loading system is compatible with ModLoader, all your ModLoader mods should work.";
        modMetadata.url = "https://github.com/MinecraftForge/FML/wiki";
        modMetadata.updateUrl = "https://github.com/MinecraftForge/FML/wiki";
        modMetadata.screenshots = new String[0];
        modMetadata.logoFile = "";
    }

    @Override
    public boolean registerBus(EventBus eventBus, LoadController loadController) {
        return true;
    }

    @Override
    public qoac getDataForWriting(plxv plxv2, iyev iyev2) {
        qoac qoac2 = new qoac();
        bsyv bsyv2 = new bsyv();
        for (ModContainer modContainer : Loader.instance().getActiveModList()) {
            qoac qoac3 = new qoac();
            qoac3._a("ModId", modContainer.getModId());
            qoac3._a("ModVersion", modContainer.getVersion());
            bsyv2._a(qoac3);
        }
        qoac2._a("ModList", bsyv2);
        bsyv bsyv3 = new bsyv();
        GameData.writeItemData(bsyv3);
        qoac2._a("ModItemData", bsyv3);
        return qoac2;
    }

    @Override
    public void readData(plxv plxv2, iyev iyev2, Map<String, huhy> map, qoac qoac2) {
        bsyv bsyv2;
        if (qoac2._c("ModList")) {
            bsyv2 = qoac2._n("ModList");
            for (int i = 0; i < bsyv2._d(); ++i) {
                qoac qoac3 = (qoac)bsyv2._b(i);
                String string = qoac3._j("ModId");
                String string2 = qoac3._j("ModVersion");
                ModContainer modContainer = Loader.instance().getIndexedModList().get(string);
                if (modContainer == null) {
                    FMLLog.log("fml.ModTracker", Level.SEVERE, "This world was saved with mod %s which appears to be missing, things may not work well", string);
                    continue;
                }
                if (string2.equals(modContainer.getVersion())) continue;
                FMLLog.log("fml.ModTracker", Level.INFO, "This world was saved with mod %s version %s and it is now at version %s, things may not work well", string, string2, modContainer.getVersion());
            }
        }
        if (qoac2._c("ModItemData")) {
            bsyv2 = qoac2._n("ModItemData");
            Set<ItemData> set = GameData.buildWorldItemData(bsyv2);
            GameData.validateWorldSave(set);
        } else {
            GameData.validateWorldSave(null);
        }
    }

    @Override
    public Certificate getSigningCertificate() {
        Certificate[] certificateArray = this.getClass().getProtectionDomain().getCodeSource().getCertificates();
        return certificateArray != null ? certificateArray[0] : null;
    }

    @Override
    public File getSource() {
        return FMLSanityChecker.fmlLocation;
    }

    @Override
    public Class<?> getCustomResourcePackClass() {
        return this.getSource().isDirectory() ? FMLFolderResourcePack.class : FMLFileResourcePack.class;
    }
}

