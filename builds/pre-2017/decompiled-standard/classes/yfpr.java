/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import znw.mods.auction.pidb;

public class yfpr
extends wnsd {
    private pidb _a;

    public yfpr(pidb pidb2) {
        this._a = pidb2;
    }

    @Override
    protected zybc createGuiContainer(EntityPlayer entityPlayer) {
        return this._a._a(this._a._a(entityPlayer));
    }

    public yfpr() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._a = pidb.values()[dataInput.readInt()];
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeInt(this._a.ordinal());
    }
}

