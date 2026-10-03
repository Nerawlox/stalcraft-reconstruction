/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.hud.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;

public class htbo
extends zwat {
    public int _a;

    public htbo(int n) {
        this._a = n;
    }

    @Override
    public void processClient(boolean bl) {
        stiq stiq2 = xpzm._E()._J;
        if (stiq2 instanceof pidb) {
            ((pidb)stiq2)._a(this._a);
        }
    }

    public htbo() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
    }
}

