/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.weapon.jgro;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class xams
extends ytyx {
    private jgro _a;

    public xams(jgro jgro2) {
        this._a = jgro2;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        this._a._a(dataOutput);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = new jgro();
        this._a._a(dataInput);
    }

    public xams() {
    }
}

