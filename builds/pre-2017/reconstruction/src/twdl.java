/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.weapon.ugqx;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;

public class twdl
extends ytyx {
    private int _a;

    public twdl(int n) {
        this._a = n;
    }

    @Override
    public void processClient(EntityPlayer entityPlayer) {
        ugqx._a((EntityPlayer)entityPlayer)._h = this._a;
    }

    public twdl() {
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

