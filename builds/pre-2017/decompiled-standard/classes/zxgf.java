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

public class zxgf
extends ytyx {
    private int _a;

    public zxgf(int n) {
        this._a = n;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    protected void processClient(EntityPlayer entityPlayer) {
        gqjz gqjz2 = xpzm._E()._B;
        if (gqjz2 instanceof kjui) {
            ((kjui)((Object)gqjz2)).setBalance(this._a);
        }
    }

    public zxgf() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
    }

    public static interface kjui {
        public void setBalance(int var1);
    }
}

