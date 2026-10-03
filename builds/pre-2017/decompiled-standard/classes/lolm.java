/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.weapon.ugqx;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class lolm
extends ytyx {
    private int _a;
    private int _b;
    private int _c;
    private boolean _d;
    private String _e;

    public lolm(int n, int n2, int n3, boolean bl, String string) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = bl;
        this._e = string;
    }

    @Override
    public void processClient(EntityPlayer entityPlayer) {
        Entity entity = xpzm._E()._t.field_70170_p.func_73045_a(this._a);
        if (entity instanceof EntityPlayer) {
            ugqx._a((EntityPlayer)entity)._a(this._b, this._c, this._d, this._e);
        }
    }

    public lolm() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readBoolean();
        this._e = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeBoolean(this._d);
        dataOutput.writeUTF(this._e);
    }
}

