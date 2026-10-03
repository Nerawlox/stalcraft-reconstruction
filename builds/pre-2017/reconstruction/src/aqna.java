/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;

public class aqna
implements ISaveHandler {
    @Override
    public WorldInfo loadWorldInfo() {
        return null;
    }

    @Override
    public void checkSessionLock() {
    }

    @Override
    public bcgt getChunkLoader(WorldProvider worldProvider) {
        return null;
    }

    @Override
    public void saveWorldInfoWithPlayer(WorldInfo worldInfo, NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void saveWorldInfo(WorldInfo worldInfo) {
    }

    @Override
    public lqjs func_75756_e() {
        return null;
    }

    @Override
    public void flush() {
    }

    @Override
    public File getMapFileFromName(String string) {
        return null;
    }

    @Override
    public String getWorldDirectoryName() {
        return "none";
    }
}

