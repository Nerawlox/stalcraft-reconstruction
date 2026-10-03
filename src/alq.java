/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aca
 *  adw
 *  als
 *  amc
 *  amq
 *  cl
 *  cpw.mods.fml.common.FMLCommonHandler
 *  net.minecraft.server.MinecraftServer
 */
import cpw.mods.fml.common.FMLCommonHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import net.minecraft.server.MinecraftServer;

public class alq
implements amc,
amq {
    private final File a;
    private final File b;
    private final File c;
    private final long d = MinecraftServer.aq();
    private final String e;

    public alq(File par1File, String par2Str, boolean par3) {
        this.a = new File(par1File, par2Str);
        this.a.mkdirs();
        this.b = new File(this.a, "players");
        this.c = new File(this.a, "data");
        this.c.mkdirs();
        this.e = par2Str;
        if (par3) {
            this.b.mkdirs();
        }
        this.h();
    }

    private void h() {
        try {
            File file1 = new File(this.a, "session.lock");
            DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file1));
            try {
                dataoutputstream.writeLong(this.d);
            }
            finally {
                dataoutputstream.close();
            }
        }
        catch (IOException ioexception) {
            ioexception.printStackTrace();
            throw new RuntimeException("Failed to check session lock, aborting");
        }
    }

    public File b() {
        return this.a;
    }

    public void c() throws aca {
        try {
            File file1 = new File(this.a, "session.lock");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file1));
            try {
                if (datainputstream.readLong() != this.d) {
                    throw new aca("The save is being accessed from another location, aborting");
                }
            }
            finally {
                datainputstream.close();
            }
        }
        catch (IOException ioexception) {
            throw new aca("Failed to check session lock, aborting");
        }
    }

    public adw a(aei par1WorldProvider) {
        throw new RuntimeException("Old Chunk Storage is no longer supported.");
    }

    public als d() {
        File file1 = new File(this.a, "level.dat");
        als worldInfo = null;
        if (file1.exists()) {
            try {
                by nbttagcompound = ci.a(new FileInputStream(file1));
                by nbttagcompound1 = nbttagcompound.l("Data");
                worldInfo = new als(nbttagcompound1);
                FMLCommonHandler.instance().handleWorldDataLoad(this, worldInfo, nbttagcompound);
                return worldInfo;
            }
            catch (Exception exception) {
                if (FMLCommonHandler.instance().shouldServerBeKilledQuietly()) {
                    throw (RuntimeException)exception;
                }
                exception.printStackTrace();
            }
        }
        if ((file1 = new File(this.a, "level.dat_old")).exists()) {
            try {
                by nbttagcompound = ci.a(new FileInputStream(file1));
                by nbttagcompound1 = nbttagcompound.l("Data");
                worldInfo = new als(nbttagcompound1);
                FMLCommonHandler.instance().handleWorldDataLoad(this, worldInfo, nbttagcompound);
                return worldInfo;
            }
            catch (Exception exception1) {
                exception1.printStackTrace();
            }
        }
        return null;
    }

    public void a(als par1WorldInfo, by par2NBTTagCompound) {
        by nbttagcompound1 = par1WorldInfo.a(par2NBTTagCompound);
        by nbttagcompound2 = new by();
        nbttagcompound2.a("Data", (cl)nbttagcompound1);
        FMLCommonHandler.instance().handleWorldDataSave(this, par1WorldInfo, nbttagcompound2);
        try {
            File file1 = new File(this.a, "level.dat_new");
            File file2 = new File(this.a, "level.dat_old");
            File file3 = new File(this.a, "level.dat");
            ci.a(nbttagcompound2, new FileOutputStream(file1));
            if (file2.exists()) {
                file2.delete();
            }
            file3.renameTo(file2);
            if (file3.exists()) {
                file3.delete();
            }
            file1.renameTo(file3);
            if (file1.exists()) {
                file1.delete();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void a(als par1WorldInfo) {
        by nbttagcompound = par1WorldInfo.a();
        by nbttagcompound1 = new by();
        nbttagcompound1.a("Data", (cl)nbttagcompound);
        FMLCommonHandler.instance().handleWorldDataSave(this, par1WorldInfo, nbttagcompound1);
        try {
            File file1 = new File(this.a, "level.dat_new");
            File file2 = new File(this.a, "level.dat_old");
            File file3 = new File(this.a, "level.dat");
            ci.a(nbttagcompound1, new FileOutputStream(file1));
            if (file2.exists()) {
                file2.delete();
            }
            file3.renameTo(file2);
            if (file3.exists()) {
                file3.delete();
            }
            file1.renameTo(file3);
            if (file1.exists()) {
                file1.delete();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void a(uf par1EntityPlayer) {
        try {
            by nbttagcompound = new by();
            par1EntityPlayer.e(nbttagcompound);
            File file1 = new File(this.b, par1EntityPlayer.c_() + ".dat.tmp");
            File file2 = new File(this.b, par1EntityPlayer.c_() + ".dat");
            ci.a(nbttagcompound, new FileOutputStream(file1));
            if (file2.exists()) {
                file2.delete();
            }
            file1.renameTo(file2);
        }
        catch (Exception exception) {
            MinecraftServer.F().an().b("Failed to save player data for " + par1EntityPlayer.c_());
        }
    }

    public by b(uf par1EntityPlayer) {
        by nbttagcompound = this.a(par1EntityPlayer.c_());
        if (nbttagcompound != null) {
            par1EntityPlayer.f(nbttagcompound);
        }
        return nbttagcompound;
    }

    public by a(String par1Str) {
        try {
            File file1 = new File(this.b, par1Str + ".dat");
            if (file1.exists()) {
                return ci.a(new FileInputStream(file1));
            }
        }
        catch (Exception exception) {
            MinecraftServer.F().an().b("Failed to load player data for " + par1Str);
        }
        return null;
    }

    public amq e() {
        return this;
    }

    public String[] f() {
        String[] astring = this.b.list();
        for (int i = 0; i < astring.length; ++i) {
            if (!astring[i].endsWith(".dat")) continue;
            astring[i] = astring[i].substring(0, astring[i].length() - 4);
        }
        return astring;
    }

    public void a() {
    }

    public File b(String par1Str) {
        return new File(this.c, par1Str + ".dat");
    }

    public String g() {
        return this.e;
    }
}

