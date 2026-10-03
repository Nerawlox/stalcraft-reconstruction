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

public class nudm
extends ytyx {
    private int _a;
    private uhvt _b;

    public nudm(int n, uhvt uhvt2) {
        this._a = n;
        this._b = uhvt2;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    protected void processClient(EntityPlayer entityPlayer) {
        gqjz gqjz2 = xpzm._E()._B;
        if (gqjz2 instanceof ivwa) {
            ((ivwa)gqjz2).setBalance(this._a);
        }
    }

    public nudm() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = uhvt.values()[dataInput.readInt()];
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b.ordinal());
    }
}

