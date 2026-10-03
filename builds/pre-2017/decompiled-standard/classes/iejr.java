/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.core.entity.EntityAdvancedThrowable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;

public class iejr
extends zwat {
    public int _a;
    public int _b;

    public iejr(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    @Override
    public void processClient(boolean bl) {
        Entity entity;
        pkix pkix2 = xpzm._E()._r;
        if (pkix2 != null && (entity = ((ozlu)pkix2).func_73045_a(this._a)) instanceof EntityAdvancedThrowable) {
            ((EntityAdvancedThrowable)entity).setAsGuideEntity(this._b);
        }
    }

    public iejr() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
    }
}

