/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;

public class tejk
extends gloomyfolken.bundle.common.core.zwat {
    private int _b;
    private double _c;
    private double _d;
    private double _e;
    private float _f;
    private scai _g;
    public float _a;
    private boolean _h;

    public tejk(int n, double d, double d2, double d3, float f, scai scai2, float f2, boolean bl) {
        this._b = n;
        this._c = d;
        this._d = d2;
        this._e = d3;
        this._f = f;
        this._g = scai2;
        this._a = f2;
        this._h = bl;
    }

    @Override
    public void processClient(boolean bl) {
        Minecraft minecraft = Minecraft._E();
        if (minecraft._r != null && minecraft._t != null) {
            zwat zwat2 = new zwat(minecraft._r, this._c, this._d, this._e, this._f)._b(this._g)._b(this._b);
            zwat2._a(this._h);
            zwat2._a(this._a);
        }
    }

    public tejk() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._b = dataInput.readInt();
        this._c = dataInput.readDouble();
        this._d = dataInput.readDouble();
        this._e = dataInput.readDouble();
        this._f = dataInput.readFloat();
        this._g = scai.values()[dataInput.readInt()];
        this._a = dataInput.readFloat();
        this._h = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._b);
        dataOutput.writeDouble(this._c);
        dataOutput.writeDouble(this._d);
        dataOutput.writeDouble(this._e);
        dataOutput.writeFloat(this._f);
        dataOutput.writeInt(this._g.ordinal());
        dataOutput.writeFloat(this._a);
        dataOutput.writeBoolean(this._h);
    }
}

