/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.mobs.StalkerMobsHooks;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class wnsl
extends zwat {
    int _a;
    int _b;
    int _c;

    public wnsl(int n, int n2, int n3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
    }

    @Override
    public void processClient(boolean bl) {
        StalkerMobsHooks.INTERP_TICKS_TP = this._a;
        StalkerMobsHooks.INTERP_TICKS_REL = this._b;
        StalkerMobsHooks.TICKS_TP_PERIOD = this._c;
    }

    public wnsl() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
    }
}

