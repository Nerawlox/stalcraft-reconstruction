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

public class kldm
extends ytyx {
    private int _a;

    public kldm(int n) {
        this._a = n;
    }

    public kldm() {
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        tupg tupg2 = tupg._a(entityPlayer);
        tupg2._i = System.currentTimeMillis();
        tupg2._h = this._a;
    }
}

