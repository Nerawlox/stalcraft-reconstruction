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

public class ivai
extends ytyx {
    private int _a;
    private int _b;
    private int _c;
    private int _d;
    private float _e;
    private float _f;
    private float _g;

    public ivai(flwn flwn2, flwn.kjui kjui2) {
        this._a = flwn2.field_70329_l;
        this._b = flwn2.field_70330_m;
        this._c = flwn2.field_70327_n;
        this._d = kjui2._g;
        this._e = kjui2._a;
        this._f = kjui2._b;
        this._g = kjui2._e;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        flwn flwn2 = (flwn)xpzm._E()._r.func_72796_p(this._a, this._b, this._c);
        flwn2._a(this._d, this._e, this._f, this._g);
    }

    public ivai() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readFloat();
        this._f = dataInput.readFloat();
        this._g = dataInput.readFloat();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeFloat(this._e);
        dataOutput.writeFloat(this._f);
        dataOutput.writeFloat(this._g);
    }
}

