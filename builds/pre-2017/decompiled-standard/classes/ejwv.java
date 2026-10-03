/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.weapon.trace.EntityTracer;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;

public class ejwv
extends ytyx {
    private byte _a;

    public ejwv() {
    }

    public ejwv(EntityTracer.eidj eidj2) {
        this._a = (byte)eidj2.ordinal();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this._a);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readByte();
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        EntityTracer.eidj eidj2 = EntityTracer.eidj.values()[this._a];
        sbzn._b._c = new nuoa.kjui(eidj2);
    }
}

