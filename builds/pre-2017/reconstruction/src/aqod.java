/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import znw.mods.stalkerguide.StalkerguideMod;

public class aqod
extends ytyx {
    public static final int _a = 0;
    public static final int _b = 1;
    public static final int _c = 2;
    public static final int _d = 3;
    public static final int _e = 4;
    public static final int _f = 5;
    public static final int _g = 6;
    public static final int _h = 7;
    public static final int _i = 8;
    private int _j;

    public aqod(int n) {
        this._j = n;
    }

    @Override
    protected void processClient(EntityPlayer entityPlayer) {
        StalkerguideMod._b._a(this._j);
    }

    public aqod() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._j = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._j);
    }
}

