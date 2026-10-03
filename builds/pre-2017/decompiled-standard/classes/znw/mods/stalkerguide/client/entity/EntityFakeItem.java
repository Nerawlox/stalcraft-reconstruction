/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.stalkerguide.client.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;

public class EntityFakeItem
extends EntityItem {
    public EntityFakeItem(ozlu ozlu2, double d, double d2, double d3, cvzo cvzo2) {
        super(ozlu2, d, d2, d3, cvzo2);
    }

    @Override
    public boolean func_130002_c(EntityPlayer entityPlayer) {
        this.field_70292_b = 0;
        return true;
    }

    @Override
    public void func_70100_b_(EntityPlayer entityPlayer) {
    }

    @Override
    public boolean func_70067_L() {
        return true;
    }
}

