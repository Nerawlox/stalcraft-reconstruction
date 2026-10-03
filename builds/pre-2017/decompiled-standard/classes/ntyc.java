/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;

public class ntyc
extends ytyx {
    private int _a;
    private int _b;
    private int _c;
    private int _d;
    private int _e;

    public ntyc(hurg hurg2, int n, int n2) {
        this._a = hurg2.field_70329_l;
        this._b = hurg2.field_70330_m;
        this._c = hurg2.field_70327_n;
        this._d = n;
        this._e = n2;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        hurg hurg2 = xpzm._E()._r.func_72796_p(this._a, this._b, this._c);
        hurg2.func_70315_b(this._d, this._e);
    }

    public ntyc() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeInt(this._e);
    }
}

