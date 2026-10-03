/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import znw.mods.stalkerguide.StalkerguideMod;

public class nwuf
extends ytyx {
    private boolean _a;
    private int _b;

    public nwuf(int n, boolean bl) {
        this._b = 0;
        this._b = n;
        this._a = bl;
    }

    @Override
    protected void processClient(EntityPlayer entityPlayer) {
        if (entityPlayer != null) {
            StalkerguideMod._b._a(this._a, this._b);
        }
    }

    public nwuf() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readBoolean();
        this._b = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeBoolean(this._a);
        dataOutput.writeInt(this._b);
    }
}

