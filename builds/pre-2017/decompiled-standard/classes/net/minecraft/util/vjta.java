/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.jxtc;
import net.minecraft.util.tdpx;
import net.minecraft.util.zwat;

public class vjta
extends jxtc {
    public Entity field_76386_o;

    public vjta(String string, Entity entity) {
        super(string);
        this.field_76386_o = entity;
    }

    @Override
    public Entity func_76346_g() {
        return this.field_76386_o;
    }

    @Override
    public zwat func_76360_b(EntityLivingBase entityLivingBase) {
        cvzo cvzo2 = this.field_76386_o instanceof EntityLivingBase ? ((EntityLivingBase)this.field_76386_o).func_70694_bm() : null;
        String string = "death.attack." + this.field_76373_n;
        String string2 = string + ".item";
        if (cvzo2 != null && cvzo2._u() && tdpx._b(string2)) {
            return zwat._b(string2, entityLivingBase.func_96090_ax(), this.field_76386_o.func_96090_ax(), cvzo2._s());
        }
        return zwat._b(string, entityLivingBase.func_96090_ax(), this.field_76386_o.func_96090_ax());
    }

    @Override
    public boolean func_76350_n() {
        return this.field_76386_o != null && this.field_76386_o instanceof EntityLivingBase && !(this.field_76386_o instanceof EntityPlayer);
    }
}

