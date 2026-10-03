/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.hank;
import net.minecraft.util.jxtc;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityEnderPearl
extends EntityThrowable {
    public EntityEnderPearl(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityEnderPearl(ozlu ozlu2, EntityLivingBase entityLivingBase) {
        super(ozlu2, entityLivingBase);
    }

    @SideOnly(value=Side.CLIENT)
    public EntityEnderPearl(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2, d, d2, d3);
    }

    @Override
    public void func_70184_a(hank hank2) {
        if (hank2._i != null) {
            hank2._i.func_70097_a(jxtc.func_76356_a(this, this.func_85052_h()), 0.0f);
        }
        for (int i = 0; i < 32; ++i) {
            this.field_70170_p.func_72869_a("portal", this.field_70165_t, this.field_70163_u + this.field_70146_Z.nextDouble() * 2.0, this.field_70161_v, this.field_70146_Z.nextGaussian(), 0.0, this.field_70146_Z.nextGaussian());
        }
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_85052_h() != null && this.func_85052_h() instanceof EntityPlayerMP) {
                EnderTeleportEvent enderTeleportEvent;
                EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this.func_85052_h();
                if (!entityPlayerMP.field_71135_a.field_72576_c && entityPlayerMP.field_70170_p == this.field_70170_p && !MinecraftForge.EVENT_BUS.post(enderTeleportEvent = new EnderTeleportEvent(entityPlayerMP, this.field_70165_t, this.field_70163_u, this.field_70161_v, 5.0f))) {
                    if (this.func_85052_h().func_70115_ae()) {
                        this.func_85052_h().func_70078_a(null);
                    }
                    this.func_85052_h().func_70634_a(enderTeleportEvent.targetX, enderTeleportEvent.targetY, enderTeleportEvent.targetZ);
                    this.func_85052_h().field_70143_R = 0.0f;
                    this.func_85052_h().func_70097_a(jxtc.field_76379_h, enderTeleportEvent.attackDamage);
                }
            }
            this.func_70106_y();
        }
    }
}

