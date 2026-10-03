/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  op
 *  t
 *  u
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class oo {
    private boolean a = true;
    private static final HashMap b = new HashMap();
    private final Map c = new HashMap();
    private boolean d;
    private ReadWriteLock e = new ReentrantReadWriteLock();

    public void a(int par1, Object par2Obj) {
        Integer integer = (Integer)b.get(par2Obj.getClass());
        if (integer == null) {
            throw new IllegalArgumentException("Unknown data type: " + par2Obj.getClass());
        }
        if (par1 > 31) {
            throw new IllegalArgumentException("Data value id is too big with " + par1 + "! (Max is " + 31 + ")");
        }
        if (this.c.containsKey(par1)) {
            throw new IllegalArgumentException("Duplicate id value for " + par1 + "!");
        }
        op watchableobject = new op(integer.intValue(), par1, par2Obj);
        this.e.writeLock().lock();
        this.c.put(par1, watchableobject);
        this.e.writeLock().unlock();
        this.a = false;
    }

    public void a(int par1, int par2) {
        op watchableobject = new op(par2, par1, null);
        this.e.writeLock().lock();
        this.c.put(par1, watchableobject);
        this.e.writeLock().unlock();
        this.a = false;
    }

    public byte a(int par1) {
        return (Byte)this.i(par1).b();
    }

    public short b(int par1) {
        return (Short)this.i(par1).b();
    }

    public int c(int par1) {
        return (Integer)this.i(par1).b();
    }

    public float d(int par1) {
        return ((Float)this.i(par1).b()).floatValue();
    }

    public String e(int par1) {
        return (String)this.i(par1).b();
    }

    public ye f(int par1) {
        return (ye)this.i(par1).b();
    }

    private op i(int par1) {
        op watchableobject;
        this.e.readLock().lock();
        try {
            watchableobject = (op)this.c.get(par1);
        }
        catch (Throwable throwable) {
            b crashreport = b.a(throwable, "Getting synched entity data");
            m crashreportcategory = crashreport.a("Synched entity data");
            crashreportcategory.a("Data ID", par1);
            throw new u(crashreport);
        }
        this.e.readLock().unlock();
        return watchableobject;
    }

    public void b(int par1, Object par2Obj) {
        op watchableobject = this.i(par1);
        if (!par2Obj.equals(watchableobject.b())) {
            watchableobject.a(par2Obj);
            watchableobject.a(true);
            this.d = true;
        }
    }

    public void h(int par1) {
        op.a((op)this.i(par1), (boolean)true);
        this.d = true;
    }

    public boolean a() {
        return this.d;
    }

    public static void a(List par0List, DataOutput par1DataOutput) throws IOException {
        if (par0List != null) {
            for (op watchableobject : par0List) {
                oo.a(par1DataOutput, watchableobject);
            }
        }
        par1DataOutput.writeByte(127);
    }

    public List b() {
        ArrayList<op> arraylist = null;
        if (this.d) {
            this.e.readLock().lock();
            for (op watchableobject : this.c.values()) {
                if (!watchableobject.d()) continue;
                watchableobject.a(false);
                if (arraylist == null) {
                    arraylist = new ArrayList<op>();
                }
                arraylist.add(watchableobject);
            }
            this.e.readLock().unlock();
        }
        this.d = false;
        return arraylist;
    }

    public void a(DataOutput par1DataOutput) throws IOException {
        this.e.readLock().lock();
        for (op watchableobject : this.c.values()) {
            oo.a(par1DataOutput, watchableobject);
        }
        this.e.readLock().unlock();
        par1DataOutput.writeByte(127);
    }

    public List c() {
        ArrayList<op> arraylist = null;
        this.e.readLock().lock();
        for (op watchableobject : this.c.values()) {
            if (arraylist == null) {
                arraylist = new ArrayList<op>();
            }
            arraylist.add(watchableobject);
        }
        this.e.readLock().unlock();
        return arraylist;
    }

    private static void a(DataOutput par0DataOutput, op par1WatchableObject) throws IOException {
        int i2 = (par1WatchableObject.c() << 5 | par1WatchableObject.a() & 0x1F) & 0xFF;
        par0DataOutput.writeByte(i2);
        switch (par1WatchableObject.c()) {
            case 0: {
                par0DataOutput.writeByte(((Byte)par1WatchableObject.b()).byteValue());
                break;
            }
            case 1: {
                par0DataOutput.writeShort(((Short)par1WatchableObject.b()).shortValue());
                break;
            }
            case 2: {
                par0DataOutput.writeInt((Integer)par1WatchableObject.b());
                break;
            }
            case 3: {
                par0DataOutput.writeFloat(((Float)par1WatchableObject.b()).floatValue());
                break;
            }
            case 4: {
                ey.a((String)par1WatchableObject.b(), par0DataOutput);
                break;
            }
            case 5: {
                ye itemstack = (ye)par1WatchableObject.b();
                ey.a(itemstack, par0DataOutput);
                break;
            }
            case 6: {
                t chunkcoordinates = (t)par1WatchableObject.b();
                par0DataOutput.writeInt(chunkcoordinates.a);
                par0DataOutput.writeInt(chunkcoordinates.b);
                par0DataOutput.writeInt(chunkcoordinates.c);
            }
        }
    }

    public static List a(DataInput par0DataInput) throws IOException {
        ArrayList<op> arraylist = null;
        byte b0 = par0DataInput.readByte();
        while (b0 != 127) {
            if (arraylist == null) {
                arraylist = new ArrayList<op>();
            }
            int i2 = (b0 & 0xE0) >> 5;
            int j2 = b0 & 0x1F;
            op watchableobject = null;
            switch (i2) {
                case 0: {
                    watchableobject = new op(i2, j2, (Object)par0DataInput.readByte());
                    break;
                }
                case 1: {
                    watchableobject = new op(i2, j2, (Object)par0DataInput.readShort());
                    break;
                }
                case 2: {
                    watchableobject = new op(i2, j2, (Object)par0DataInput.readInt());
                    break;
                }
                case 3: {
                    watchableobject = new op(i2, j2, (Object)Float.valueOf(par0DataInput.readFloat()));
                    break;
                }
                case 4: {
                    watchableobject = new op(i2, j2, (Object)ey.a(par0DataInput, 64));
                    break;
                }
                case 5: {
                    watchableobject = new op(i2, j2, (Object)ey.c(par0DataInput));
                    break;
                }
                case 6: {
                    int k2 = par0DataInput.readInt();
                    int l2 = par0DataInput.readInt();
                    int i1 = par0DataInput.readInt();
                    watchableobject = new op(i2, j2, (Object)new t(k2, l2, i1));
                }
            }
            arraylist.add(watchableobject);
            b0 = par0DataInput.readByte();
        }
        return arraylist;
    }

    @SideOnly(value=Side.CLIENT)
    public void a(List par1List) {
        this.e.writeLock().lock();
        for (op watchableobject : par1List) {
            op watchableobject1 = (op)this.c.get(watchableobject.a());
            if (watchableobject1 == null) continue;
            watchableobject1.a(watchableobject.b());
        }
        this.e.writeLock().unlock();
        this.d = true;
    }

    public boolean d() {
        return this.a;
    }

    public void e() {
        this.d = false;
    }

    static {
        b.put(Byte.class, 0);
        b.put(Short.class, 1);
        b.put(Integer.class, 2);
        b.put(Float.class, 3);
        b.put(String.class, 4);
        b.put(ye.class, 5);
        b.put(t.class, 6);
    }
}

