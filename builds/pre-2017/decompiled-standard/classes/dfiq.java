/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class dfiq
extends zwat {
    private ofgy _a;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        this._a.write(dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = new ofgy();
        this._a.read(dataInput);
    }
}

