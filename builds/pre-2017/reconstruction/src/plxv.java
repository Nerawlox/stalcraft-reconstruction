/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLCommonHandler;
import gloomyfolken.mods.asm.FileWriteBlocker;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;

public class plxv
implements lqjs,
ISaveHandler {
    public final File _a;
    public final File _b;
    public final File _c;
    public final long _d = MinecraftServer.__aq();
    public final String _e;

    public plxv(File file, String string, boolean bl) {
        this._a = new File(file, string);
        this._a.mkdirs();
        this._b = new File(this._a, "players");
        this._c = new File(this._a, "data");
        this._c.mkdirs();
        this._e = string;
        if (bl) {
            this._b.mkdirs();
        }
        this._b();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _b() {
        boolean bl = FileWriteBlocker.setSessionLock(this);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        try {
            File file = new File(this._a, "session.lock");
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeLong(this._d);
            }
            finally {
                dataOutputStream.close();
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            throw new RuntimeException("Failed to check session lock, aborting");
        }
    }

    public File _c() {
        return this._a;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void checkSessionLock() throws xcad {
        FileWriteBlocker.checkSessionLock(this);
        try {
            File file = new File(this._a, "session.lock");
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                if (dataInputStream.readLong() != this._d) {
                    throw new xcad("The save is being accessed from another location, aborting");
                }
            }
            finally {
                dataInputStream.close();
            }
        }
        catch (IOException iOException) {
            throw new xcad("Failed to check session lock, aborting");
        }
    }

    @Override
    public bcgt getChunkLoader(WorldProvider worldProvider) {
        throw new RuntimeException("Old Chunk Storage is no longer supported.");
    }

    @Override
    public WorldInfo loadWorldInfo() {
        File file = new File(this._a, "level.dat");
        WorldInfo worldInfo = null;
        if (file.exists()) {
            try {
                NBTTagCompound nBTTagCompound = bsvf._a(new FileInputStream(file));
                NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("Data");
                worldInfo = new WorldInfo(nBTTagCompound2);
                FMLCommonHandler.instance().handleWorldDataLoad(this, worldInfo, nBTTagCompound);
                return worldInfo;
            }
            catch (Exception exception) {
                if (FMLCommonHandler.instance().shouldServerBeKilledQuietly()) {
                    throw (RuntimeException)exception;
                }
                exception.printStackTrace();
            }
        }
        if ((file = new File(this._a, "level.dat_old")).exists()) {
            try {
                NBTTagCompound nBTTagCompound = bsvf._a(new FileInputStream(file));
                NBTTagCompound nBTTagCompound3 = nBTTagCompound._m("Data");
                worldInfo = new WorldInfo(nBTTagCompound3);
                FMLCommonHandler.instance().handleWorldDataLoad(this, worldInfo, nBTTagCompound);
                return worldInfo;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void saveWorldInfoWithPlayer(WorldInfo worldInfo, NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2 = worldInfo._a(nBTTagCompound);
        NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
        nBTTagCompound3._a("Data", (NBTBase)nBTTagCompound2);
        FMLCommonHandler.instance().handleWorldDataSave(this, worldInfo, nBTTagCompound3);
        try {
            File file = new File(this._a, "level.dat_new");
            File file2 = new File(this._a, "level.dat_old");
            File file3 = new File(this._a, "level.dat");
            bsvf._a(nBTTagCompound3, new FileOutputStream(file));
            if (file2.exists()) {
                file2.delete();
            }
            file3.renameTo(file2);
            if (file3.exists()) {
                file3.delete();
            }
            file.renameTo(file3);
            if (file.exists()) {
                file.delete();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void saveWorldInfo(WorldInfo worldInfo) {
        NBTTagCompound nBTTagCompound = worldInfo._a();
        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
        nBTTagCompound2._a("Data", (NBTBase)nBTTagCompound);
        FMLCommonHandler.instance().handleWorldDataSave(this, worldInfo, nBTTagCompound2);
        try {
            File file = new File(this._a, "level.dat_new");
            File file2 = new File(this._a, "level.dat_old");
            File file3 = new File(this._a, "level.dat");
            bsvf._a(nBTTagCompound2, new FileOutputStream(file));
            if (file2.exists()) {
                file2.delete();
            }
            file3.renameTo(file2);
            if (file3.exists()) {
                file3.delete();
            }
            file.renameTo(file3);
            if (file.exists()) {
                file.delete();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void _a(EntityPlayer entityPlayer) {
        try {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            entityPlayer.writeToNBT(nBTTagCompound);
            File file = new File(this._b, entityPlayer.getCommandSenderName() + ".dat.tmp");
            File file2 = new File(this._b, entityPlayer.getCommandSenderName() + ".dat");
            bsvf._a(nBTTagCompound, new FileOutputStream(file));
            if (file2.exists()) {
                file2.delete();
            }
            file.renameTo(file2);
        }
        catch (Exception exception) {
            MinecraftServer._I()._O()._b("Failed to save player data for " + entityPlayer.getCommandSenderName());
        }
    }

    @Override
    public NBTTagCompound _b(EntityPlayer entityPlayer) {
        NBTTagCompound nBTTagCompound = this._a(entityPlayer.getCommandSenderName());
        if (nBTTagCompound != null) {
            entityPlayer.readFromNBT(nBTTagCompound);
        }
        return nBTTagCompound;
    }

    public NBTTagCompound _a(String string) {
        try {
            File file = new File(this._b, string + ".dat");
            if (file.exists()) {
                return bsvf._a(new FileInputStream(file));
            }
        }
        catch (Exception exception) {
            MinecraftServer._I()._O()._b("Failed to load player data for " + string);
        }
        return null;
    }

    @Override
    public lqjs func_75756_e() {
        return this;
    }

    @Override
    public String[] _a() {
        String[] stringArray = this._b.list();
        for (int i = 0; i < stringArray.length; ++i) {
            if (!stringArray[i].endsWith(".dat")) continue;
            stringArray[i] = stringArray[i].substring(0, stringArray[i].length() - 4);
        }
        return stringArray;
    }

    @Override
    public void flush() {
    }

    @Override
    public File getMapFileFromName(String string) {
        return new File(this._c, string + ".dat");
    }

    @Override
    public String getWorldDirectoryName() {
        return this._e;
    }
}

