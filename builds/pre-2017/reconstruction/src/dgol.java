/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.stalker.misc.tupg;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;

public class dgol
extends ytyx {
    private String _a;
    private float _b;
    private float _c;

    public dgol(String string, float f, float f2) {
        this._a = string;
        this._b = f;
        this._c = f2;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        tupg tupg2 = tupg._a(entityPlayer);
        tupg2._b._a(this._a)._a(this._b, this._c);
    }

    public dgol() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readFloat();
        this._c = dataInput.readFloat();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeFloat(this._b);
        dataOutput.writeFloat(this._c);
    }
}

