/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;

public class oxyd
extends ytyx {
    public cvzo _a;

    public oxyd(cvzo cvzo2) {
        this._a = cvzo2;
    }

    @Override
    protected void processClient(EntityPlayer entityPlayer) {
    }

    public oxyd() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = qlgf.readItemStack(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        qlgf.writeItemStack(this._a, dataOutput);
    }
}

