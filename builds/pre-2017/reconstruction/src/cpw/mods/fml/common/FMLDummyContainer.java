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
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.storage.WorldInfo;

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
    public NBTTagCompound getDataForWriting(plxv plxv2, WorldInfo worldInfo) {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        NBTTagList nBTTagList = new NBTTagList();
        for (ModContainer modContainer : Loader.instance().getActiveModList()) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("ModId", modContainer.getModId());
            nBTTagCompound2._a("ModVersion", modContainer.getVersion());
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("ModList", nBTTagList);
        NBTTagList nBTTagList2 = new NBTTagList();
        GameData.writeItemData(nBTTagList2);
        nBTTagCompound._a("ModItemData", nBTTagList2);
        return nBTTagCompound;
    }

    @Override
    public void readData(plxv plxv2, WorldInfo worldInfo, Map<String, NBTBase> map, NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList;
        if (nBTTagCompound._c("ModList")) {
            nBTTagList = nBTTagCompound._n("ModList");
            for (int i = 0; i < nBTTagList._d(); ++i) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
                String string = nBTTagCompound2._j("ModId");
                String string2 = nBTTagCompound2._j("ModVersion");
                ModContainer modContainer = Loader.instance().getIndexedModList().get(string);
                if (modContainer == null) {
                    FMLLog.log("fml.ModTracker", Level.SEVERE, "This world was saved with mod %s which appears to be missing, things may not work well", string);
                    continue;
                }
                if (string2.equals(modContainer.getVersion())) continue;
                FMLLog.log("fml.ModTracker", Level.INFO, "This world was saved with mod %s version %s and it is now at version %s, things may not work well", string, string2, modContainer.getVersion());
            }
        }
        if (nBTTagCompound._c("ModItemData")) {
            nBTTagList = nBTTagCompound._n("ModItemData");
            Set<ItemData> set = GameData.buildWorldItemData(nBTTagList);
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

