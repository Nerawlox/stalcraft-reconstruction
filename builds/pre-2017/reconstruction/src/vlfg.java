/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

public class vlfg
extends qlgf {
    private List<Class<? extends oxot>> _e = Arrays.asList(oxot.class, zgmg.class, oxoq.class, uzai.class);
    public ndni _a;
    public rpzz _b;
    public int _c;
    public int _d;

    public vlfg() {
    }

    public vlfg(ndni ndni2, rpzz rpzz2, int n) {
        this._a = ndni2;
        this._b = rpzz2;
        this._c = this._d = n;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.ordinal());
        this._b.write(dataOutput);
        dataOutput.writeInt(this._d);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = ndni.values()[dataInput.readInt()];
        this._b = new rpzz(new LinkedHashMap<String, Pair<Object, Object>>());
        this._b.read(dataInput);
        this._c = this._d = dataInput.readInt();
    }

    protected void _a(oxot oxot2, DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._e.indexOf(oxot2.getClass()));
        oxot2.write(dataOutput);
    }

    protected oxot _a(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        try {
            oxot oxot2 = this._e.get(n).newInstance();
            oxot2.read(dataInput);
            return oxot2;
        }
        catch (IllegalAccessException | InstantiationException reflectiveOperationException) {
            reflectiveOperationException.printStackTrace();
            return null;
        }
    }
}

