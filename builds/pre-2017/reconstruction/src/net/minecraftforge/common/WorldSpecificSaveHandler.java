/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import java.io.File;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;

public class WorldSpecificSaveHandler
implements ISaveHandler {
    private WorldServer world;
    private ISaveHandler parent;
    private File dataDir;

    public WorldSpecificSaveHandler(WorldServer worldServer, ISaveHandler iSaveHandler) {
        this.world = worldServer;
        this.parent = iSaveHandler;
        this.dataDir = new File(worldServer.getChunkSaveLocation(), "data");
        this.dataDir.mkdirs();
    }

    @Override
    public WorldInfo loadWorldInfo() {
        return this.parent.loadWorldInfo();
    }

    @Override
    public void checkSessionLock() throws xcad {
        this.parent.checkSessionLock();
    }

    @Override
    public bcgt getChunkLoader(WorldProvider worldProvider) {
        return this.parent.getChunkLoader(worldProvider);
    }

    @Override
    public void saveWorldInfoWithPlayer(WorldInfo worldInfo, NBTTagCompound nBTTagCompound) {
        this.parent.saveWorldInfoWithPlayer(worldInfo, nBTTagCompound);
    }

    @Override
    public void saveWorldInfo(WorldInfo worldInfo) {
        this.parent.saveWorldInfo(worldInfo);
    }

    @Override
    public lqjs func_75756_e() {
        return this.parent.func_75756_e();
    }

    @Override
    public void flush() {
        this.parent.flush();
    }

    @Override
    public String getWorldDirectoryName() {
        return this.parent.getWorldDirectoryName();
    }

    @Override
    public File getMapFileFromName(String string) {
        return new File(this.dataDir, string + ".dat");
    }
}

