/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.weapon.ugqx;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class dgtt
extends ytyx {
    private int _a;

    public dgtt(int n) {
        this._a = n;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        Entity entity = Minecraft._E()._r.getEntityByID(this._a);
        if (entity instanceof EntityPlayer && entityPlayer.getCurrentEquippedItem() != null && entityPlayer.getCurrentEquippedItem()._a() instanceof wolf) {
            ItemStack itemStack = entityPlayer.getCurrentEquippedItem();
            wolf wolf2 = (wolf)itemStack._a();
            xrox xrox2 = wolf2._a(itemStack, dxwc.pidb._b, xrox.class);
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

