/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;

public abstract class wnsd
extends zwat {
    public int windowId;

    @Override
    public final void processClient(boolean bl) {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        zybc zybc2 = this.createGuiContainer(entityClientPlayerMP);
        if (zybc2 == null) {
            ((EntityPlayerSP)entityClientPlayerMP).func_71053_j();
        } else {
            zybc2.field_74193_d.field_75152_c = this.windowId;
            entityClientPlayerMP.field_71070_bA = zybc2.field_74193_d;
            xpzm._E()._a(zybc2);
        }
    }

    @ezey(_a={eidj.CLIENT})
    protected abstract zybc createGuiContainer(EntityPlayer var1);

    @Override
    public void read(DataInput dataInput) throws IOException {
        this.windowId = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.windowId);
    }
}

