/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.core.main.ClientProxy;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ycxm
extends zwat {
    public long _a;

    public ycxm(long l) {
        this._a = l;
    }

    @Override
    public void processClient(boolean bl) {
        ClientProxy.PING = (int)(System.currentTimeMillis() - this._a);
    }

    @Override
    public boolean _a() {
        return true;
    }

    public ycxm() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readLong();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this._a);
    }
}

