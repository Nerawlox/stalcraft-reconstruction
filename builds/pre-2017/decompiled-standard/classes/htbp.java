/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;

public class htbp
extends ytyx {
    private float _a;
    private float _b;

    public htbp(float f, float f2) {
        this._a = f;
        this._b = f2;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        nuoa.pidb pidb2;
        sbzn._b._d = pidb2 = new nuoa.pidb(this._a, this._b);
        jysc._c(new wnky(7));
    }

    public htbp() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readFloat();
        this._b = dataInput.readFloat();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeFloat(this._a);
        dataOutput.writeFloat(this._b);
    }
}

