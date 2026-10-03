/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.Logger;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;

public class tvkv
extends ytyx {
    private int _a;
    private String _b;
    private byte[] _c;

    public tvkv() {
    }

    public tvkv(bqwg bqwg2) {
        this._a = bqwg2._a._a.field_70157_k;
        this._b = bqwg2._b;
        this._c = bqwg2._c();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeUTF(this._b);
        dataOutput.writeShort(this._c.length);
        dataOutput.write(this._c);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readUTF();
        this._c = new byte[dataInput.readShort()];
        dataInput.readFully(this._c);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        EntityPlayer entityPlayer2 = (EntityPlayer)xpzm._E()._r.func_73045_a(this._a);
        if (entityPlayer2 != null) {
            ccxr ccxr2 = ncwh._a(entityPlayer2);
            bqwg bqwg2 = ccxr2._g.get(this._b);
            bqwg2._a(this._c);
        } else {
            Logger.warning("Received player attribute " + this._b + " for invalid player " + this._a, new Object[0]);
        }
    }
}

