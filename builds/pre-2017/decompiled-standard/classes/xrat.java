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

public class xrat
extends ytyx {
    private int _a;
    private int _b;

    @Override
    @ezey(_a={eidj.CLIENT})
    protected void processClient(EntityPlayer entityPlayer) {
        gqjz gqjz2 = xpzm._E()._B;
        if (gqjz2 instanceof oxhq) {
            ((oxhq)gqjz2)._a(this._a);
            ((oxhq)gqjz2).setBalance(this._b);
        }
    }

    public xrat(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    public xrat() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
    }
}

