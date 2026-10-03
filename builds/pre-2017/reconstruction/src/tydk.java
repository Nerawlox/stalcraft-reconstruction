/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;

public abstract class tydk
extends ytyx {
    protected transient boolean _l;
    public transient kjui _m;
    public byte _n;

    public boolean _d() {
        return this._l;
    }

    @Override
    protected void processClient(EntityPlayer entityPlayer) {
        this._b();
    }

    @ezey(_a={eidj.CLIENT})
    public abstract void _b();

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._n = dataInput.readByte();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this._n);
    }

    public static abstract class kjui<Simple extends tydk> {
        public abstract Simple _a(Simple var1, EntityPlayer var2);
    }
}

