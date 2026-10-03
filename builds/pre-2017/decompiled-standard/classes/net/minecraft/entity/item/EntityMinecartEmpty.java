/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.minecart.MinecartInteractEvent;

public class EntityMinecartEmpty
extends EntityMinecart {
    public EntityMinecartEmpty(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityMinecartEmpty(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2, d, d2, d3);
    }

    @Override
    public boolean func_130002_c(EntityPlayer entityPlayer) {
        if (MinecraftForge.EVENT_BUS.post(new MinecartInteractEvent(this, entityPlayer))) {
            return true;
        }
        if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != entityPlayer) {
            return true;
        }
        if (this.field_70153_n != null && this.field_70153_n != entityPlayer) {
            return false;
        }
        if (!this.field_70170_p.field_72995_K) {
            entityPlayer.func_70078_a(this);
        }
        return true;
    }

    @Override
    public int func_94087_l() {
        return 0;
    }
}

