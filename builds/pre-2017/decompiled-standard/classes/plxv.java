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

public class plxv
implements lqjs,
mtms {
    public final File _a;
    public final File _b;
    public final File _c;
    public final long _d = dzfd.__aq();
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
    public void func_75762_c() throws xcad {
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
    public bcgt func_75763_a(rrte rrte2) {
        throw new RuntimeException("Old Chunk Storage is no longer supported.");
    }

    @Override
    public iyev func_75757_d() {
        File file = new File(this._a, "level.dat");
        iyev iyev2 = null;
        if (file.exists()) {
            try {
                qoac qoac2 = bsvf._a(new FileInputStream(file));
                qoac qoac3 = qoac2._m("Data");
                iyev2 = new iyev(qoac3);
                FMLCommonHandler.instance().handleWorldDataLoad(this, iyev2, qoac2);
                return iyev2;
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
                qoac qoac4 = bsvf._a(new FileInputStream(file));
                qoac qoac5 = qoac4._m("Data");
                iyev2 = new iyev(qoac5);
                FMLCommonHandler.instance().handleWorldDataLoad(this, iyev2, qoac4);
                return iyev2;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void func_75755_a(iyev iyev2, qoac qoac2) {
        qoac qoac3 = iyev2._a(qoac2);
        qoac qoac4 = new qoac();
        qoac4._a("Data", (huhy)qoac3);
        FMLCommonHandler.instance().handleWorldDataSave(this, iyev2, qoac4);
        try {
            File file = new File(this._a, "level.dat_new");
            File file2 = new File(this._a, "level.dat_old");
            File file3 = new File(this._a, "level.dat");
            bsvf._a(qoac4, new FileOutputStream(file));
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
    public void func_75761_a(iyev iyev2) {
        qoac qoac2 = iyev2._a();
        qoac qoac3 = new qoac();
        qoac3._a("Data", (huhy)qoac2);
        FMLCommonHandler.instance().handleWorldDataSave(this, iyev2, qoac3);
        try {
            File file = new File(this._a, "level.dat_new");
            File file2 = new File(this._a, "level.dat_old");
            File file3 = new File(this._a, "level.dat");
            bsvf._a(qoac3, new FileOutputStream(file));
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
            qoac qoac2 = new qoac();
            entityPlayer.func_70109_d(qoac2);
            File file = new File(this._b, entityPlayer.func_70005_c_() + ".dat.tmp");
            File file2 = new File(this._b, entityPlayer.func_70005_c_() + ".dat");
            bsvf._a(qoac2, new FileOutputStream(file));
            if (file2.exists()) {
                file2.delete();
            }
            file.renameTo(file2);
        }
        catch (Exception exception) {
            dzfd._I()._O()._b("Failed to save player data for " + entityPlayer.func_70005_c_());
        }
    }

    @Override
    public qoac _b(EntityPlayer entityPlayer) {
        qoac qoac2 = this._a(entityPlayer.func_70005_c_());
        if (qoac2 != null) {
            entityPlayer.func_70020_e(qoac2);
        }
        return qoac2;
    }

    public qoac _a(String string) {
        try {
            File file = new File(this._b, string + ".dat");
            if (file.exists()) {
                return bsvf._a(new FileInputStream(file));
            }
        }
        catch (Exception exception) {
            dzfd._I()._O()._b("Failed to load player data for " + string);
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
    public void func_75759_a() {
    }

    @Override
    public File func_75758_b(String string) {
        return new File(this._c, string + ".dat");
    }

    @Override
    public String func_75760_g() {
        return this._e;
    }
}

