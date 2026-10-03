/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import net.minecraft.nbt.NBTTagCompound;

public class bqdo
extends qlgf {
    private String _b;
    private long _c;
    private long _d;
    private NBTTagCompound _e;
    public transient long _a;

    public bqdo() {
    }

    public bqdo(String string, NBTTagCompound nBTTagCompound) {
        this._b = string;
        this._e = nBTTagCompound;
        this._c = System.currentTimeMillis();
        this._d = this._c + iuww.DEFAULT_EXPIRATION_TIME;
    }

    public bqdo(String string, long l, long l2, NBTTagCompound nBTTagCompound) {
        this._b = string;
        this._c = l;
        this._d = l2;
        this._e = nBTTagCompound;
    }

    public String _a() {
        return this._b;
    }

    public long _b() {
        return this._c;
    }

    public long _c() {
        return this._d;
    }

    public NBTTagCompound _d() {
        return this._e;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a());
        dataOutput.writeLong(this._b());
        dataOutput.writeLong(this._c());
        bsvf._a(this._d(), dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._b = dataInput.readUTF();
        this._c = dataInput.readLong();
        this._d = dataInput.readLong();
        this._e = bsvf._a(dataInput);
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public iuww _e() {
        return ycdg._a().get(this._b);
    }

    public static Collection<bqdo> _a(DataInput dataInput) {
        ArrayList<bqdo> arrayList = new ArrayList<bqdo>();
        try {
            int n = dataInput.readInt();
            for (int i = 0; i < n; ++i) {
                bqdo bqdo2 = new bqdo();
                bqdo2.read(dataInput);
                arrayList.add(bqdo2);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return arrayList;
    }

    public static void _a(Collection<bqdo> collection, DataOutput dataOutput) {
        try {
            dataOutput.writeInt(collection.size());
            for (bqdo bqdo2 : collection) {
                bqdo2.write(dataOutput);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

