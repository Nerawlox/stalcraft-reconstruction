/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;

public class owfa
extends zwat {
    public qoac _a;

    public owfa(srli srli2) {
        this._a = new qoac();
        this._a._a("list", srli2._b());
    }

    @Override
    public void processClient(boolean bl) {
        if (xpzm._E()._B instanceof ejiw) {
            bsyv bsyv2 = this._a._n("list");
            srli srli2 = new srli(bsyv2);
            ((ejiw)((Object)xpzm._E()._B)).apply(srli2);
        }
    }

    public owfa() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = qlgf.readNBTTagCompound(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        qlgf.writeNBTTagCompound(this._a, dataOutput);
    }
}

