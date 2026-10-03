/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;

public class idwy
extends zwat {
    public List<String> _a;
    public List<String> _b;
    public List<String> _c;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        idwy.writeStringList(this._a, dataOutput);
        idwy.writeStringList(this._b, dataOutput);
        idwy.writeStringList(this._c, dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = idwy.readStringList(dataInput);
        this._b = idwy.readStringList(dataInput);
        this._c = idwy.readStringList(dataInput);
    }

    @Override
    public void processClient(boolean bl) {
        gloomyfolken.mods.party.zwat._a._a(this._a, this._b, this._c);
    }
}

