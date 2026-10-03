/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.weapon.ugqx;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;

public class klis
extends zwat {
    public float _a;

    public klis(float f) {
        this._a = f;
    }

    @Override
    public void processClient(boolean bl) {
        ugqx._a(Minecraft._E()._t)._a(this._a);
    }

    public klis() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readFloat();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeFloat(this._a);
    }
}

