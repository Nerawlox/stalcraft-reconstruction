/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class sszo
extends zwat {
    private boolean _a;

    public sszo(boolean bl) {
        this._a = bl;
    }

    @Override
    public void processClient(boolean bl) {
        StalkerMiscMod._Y._a(this._a);
    }

    public sszo() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeBoolean(this._a);
    }
}

