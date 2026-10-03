/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.amxi;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.turb;

public class DataWatcher {
    public boolean _a = true;
    public static final HashMap _b = new HashMap();
    public final Map _c = new HashMap();
    public boolean _d;
    public ReadWriteLock _e = new ReentrantReadWriteLock();

    public void _a(int n, Object object) {
        Integer n2 = (Integer)_b.get(object.getClass());
        if (n2 == null) {
            throw new IllegalArgumentException("Unknown data type: " + object.getClass());
        }
        if (n > 31) {
            throw new IllegalArgumentException("Data value id is too big with " + n + "! (Max is " + 31 + ")");
        }
        if (this._c.containsKey(n)) {
            throw new IllegalArgumentException("Duplicate id value for " + n + "!");
        }
        amxi amxi2 = new amxi(n2, n, object);
        this._e.writeLock().lock();
        this._c.put(n, amxi2);
        this._e.writeLock().unlock();
        this._a = false;
    }

    public void _a(int n, int n2) {
        amxi amxi2 = new amxi(n2, n, null);
        this._e.writeLock().lock();
        this._c.put(n, amxi2);
        this._e.writeLock().unlock();
        this._a = false;
    }

    public byte _a(int n) {
        return (Byte)this._g(n)._b();
    }

    public short _b(int n) {
        return (Short)this._g(n)._b();
    }

    public int _c(int n) {
        return (Integer)this._g(n)._b();
    }

    public float _d(int n) {
        return ((Float)this._g(n)._b()).floatValue();
    }

    public String _e(int n) {
        return (String)this._g(n)._b();
    }

    public ItemStack _f(int n) {
        return (ItemStack)this._g(n)._b();
    }

    public amxi _g(int n) {
        amxi amxi2;
        this._e.readLock().lock();
        try {
            amxi2 = (amxi)this._c.get(n);
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Getting synched entity data");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Synched entity data");
            crashReportCategory._a("Data ID", n);
            throw new turb(crashReport);
        }
        this._e.readLock().unlock();
        return amxi2;
    }

    public void _b(int n, Object object) {
        amxi amxi2 = this._g(n);
        if (!object.equals(amxi2._b())) {
            amxi2._a(object);
            amxi2._a(true);
            this._d = true;
        }
    }

    public void _h(int n) {
        amxi._a(this._g(n), true);
        this._d = true;
    }

    public boolean _a() {
        return this._d;
    }

    public static void _a(List list2, DataOutput dataOutput) {
        if (list2 != null) {
            for (amxi amxi2 : list2) {
                DataWatcher._a(dataOutput, amxi2);
            }
        }
        dataOutput.writeByte(127);
    }

    public List _b() {
        ArrayList<amxi> arrayList = null;
        if (this._d) {
            this._e.readLock().lock();
            for (amxi amxi2 : this._c.values()) {
                if (!amxi2._d()) continue;
                amxi2._a(false);
                if (arrayList == null) {
                    arrayList = new ArrayList<amxi>();
                }
                arrayList.add(amxi2);
            }
            this._e.readLock().unlock();
        }
        this._d = false;
        return arrayList;
    }

    public void _a(DataOutput dataOutput) {
        this._e.readLock().lock();
        for (amxi amxi2 : this._c.values()) {
            DataWatcher._a(dataOutput, amxi2);
        }
        this._e.readLock().unlock();
        dataOutput.writeByte(127);
    }

    public List _c() {
        ArrayList<amxi> arrayList = null;
        this._e.readLock().lock();
        for (amxi amxi2 : this._c.values()) {
            if (arrayList == null) {
                arrayList = new ArrayList<amxi>();
            }
            arrayList.add(amxi2);
        }
        this._e.readLock().unlock();
        return arrayList;
    }

    public static void _a(DataOutput dataOutput, amxi amxi2) {
        int n = (amxi2._c() << 5 | amxi2._a() & 0x1F) & 0xFF;
        dataOutput.writeByte(n);
        switch (amxi2._c()) {
            case 0: {
                dataOutput.writeByte(((Byte)amxi2._b()).byteValue());
                break;
            }
            case 1: {
                dataOutput.writeShort(((Short)amxi2._b()).shortValue());
                break;
            }
            case 2: {
                dataOutput.writeInt((Integer)amxi2._b());
                break;
            }
            case 3: {
                dataOutput.writeFloat(((Float)amxi2._b()).floatValue());
                break;
            }
            case 4: {
                Packet.writeString((String)amxi2._b(), dataOutput);
                break;
            }
            case 5: {
                ItemStack itemStack = (ItemStack)amxi2._b();
                Packet.writeItemStack(itemStack, dataOutput);
                break;
            }
            case 6: {
                ChunkCoordinates chunkCoordinates = (ChunkCoordinates)amxi2._b();
                dataOutput.writeInt(chunkCoordinates._a);
                dataOutput.writeInt(chunkCoordinates._b);
                dataOutput.writeInt(chunkCoordinates._c);
            }
        }
    }

    public static List _a(DataInput dataInput) {
        ArrayList<amxi> arrayList = null;
        byte by = dataInput.readByte();
        while (by != 127) {
            if (arrayList == null) {
                arrayList = new ArrayList<amxi>();
            }
            int n = (by & 0xE0) >> 5;
            int n2 = by & 0x1F;
            amxi amxi2 = null;
            switch (n) {
                case 0: {
                    amxi2 = new amxi(n, n2, dataInput.readByte());
                    break;
                }
                case 1: {
                    amxi2 = new amxi(n, n2, dataInput.readShort());
                    break;
                }
                case 2: {
                    amxi2 = new amxi(n, n2, dataInput.readInt());
                    break;
                }
                case 3: {
                    amxi2 = new amxi(n, n2, Float.valueOf(dataInput.readFloat()));
                    break;
                }
                case 4: {
                    amxi2 = new amxi(n, n2, Packet.readString(dataInput, 64));
                    break;
                }
                case 5: {
                    amxi2 = new amxi(n, n2, Packet.readItemStack(dataInput));
                    break;
                }
                case 6: {
                    int n3 = dataInput.readInt();
                    int n4 = dataInput.readInt();
                    int n5 = dataInput.readInt();
                    amxi2 = new amxi(n, n2, new ChunkCoordinates(n3, n4, n5));
                }
            }
            arrayList.add(amxi2);
            by = dataInput.readByte();
        }
        return arrayList;
    }

    public void _a(List list2) {
        this._e.writeLock().lock();
        for (amxi amxi2 : list2) {
            amxi amxi3 = (amxi)this._c.get(amxi2._a());
            if (amxi3 == null) continue;
            amxi3._a(amxi2._b());
        }
        this._e.writeLock().unlock();
        this._d = true;
    }

    public boolean _d() {
        return this._a;
    }

    public void _e() {
        this._d = false;
    }

    static {
        _b.put(Byte.class, 0);
        _b.put(Short.class, 1);
        _b.put(Integer.class, 2);
        _b.put(Float.class, 3);
        _b.put(String.class, 4);
        _b.put(ItemStack.class, 5);
        _b.put(ChunkCoordinates.class, 6);
    }
}

