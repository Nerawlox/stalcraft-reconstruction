/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.weapon.ugqx;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class dgtt
extends ytyx {
    private int _a;

    public dgtt(int n) {
        this._a = n;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        Entity entity = xpzm._E()._r.func_73045_a(this._a);
        if (entity instanceof EntityPlayer && entityPlayer.func_71045_bC() != null && entityPlayer.func_71045_bC()._a() instanceof wolf) {
            cvzo cvzo2 = entityPlayer.func_71045_bC();
            wolf wolf2 = (wolf)cvzo2._a();
            xrox xrox2 = wolf2._a(cvzo2, dxwc.pidb._b, xrox.class);
            ugqx._a((EntityPlayer)entity)._a(xrox2);
        }
    }

    public dgtt() {
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

