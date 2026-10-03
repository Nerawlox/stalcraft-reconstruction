/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.respawn.RespawnMod;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;

public class yuoj
extends zwat {
    private vlfg _a;

    public yuoj(vlfg vlfg2) {
        this._a = vlfg2;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a._a.ordinal());
        this._a.write(dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        ndni ndni2 = ndni.values()[dataInput.readInt()];
        this._a = ndni2 == ndni._a ? new klfx() : new cupm();
        this._a.read(dataInput);
    }

    @Override
    public void processClient(boolean bl) {
        RespawnMod.instance._e = this._a;
        xpzm xpzm2 = xpzm._E();
        gqjz gqjz2 = xpzm2._B;
        if (gqjz2 instanceof jzaw) {
            ndni ndni2 = this._a._a;
            if (ndni2 == ndni._a && !(gqjz2 instanceof qmsy)) {
                xpzm2._a(new qmsy());
            } else if (!(gqjz2 instanceof cumr)) {
                xpzm2._a(new cumr());
            } else {
                gqjz2.func_73872_a(xpzm2, xpzm2._n / 2, xpzm2._o / 2);
            }
        }
    }

    public yuoj() {
    }
}

