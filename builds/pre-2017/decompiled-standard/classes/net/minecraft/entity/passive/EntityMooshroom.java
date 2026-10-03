/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import java.util.ArrayList;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.IShearable;

public class EntityMooshroom
extends EntityCow
implements IShearable {
    public EntityMooshroom(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.9f, 1.3f);
    }

    @Override
    public boolean func_70085_c(EntityPlayer entityPlayer) {
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        if (cvzo2 != null && cvzo2._d == tgdv.field_77670_E.field_77779_bT && this.func_70874_b() >= 0) {
            if (cvzo2._b == 1) {
                entityPlayer.field_71071_by.func_70299_a(entityPlayer.field_71071_by._c, new cvzo(tgdv.field_77671_F));
                return true;
            }
            if (entityPlayer.field_71071_by._c(new cvzo(tgdv.field_77671_F)) && !entityPlayer.field_71075_bZ._d) {
                entityPlayer.field_71071_by.func_70298_a(entityPlayer.field_71071_by._c, 1);
                return true;
            }
        }
        return super.func_70085_c(entityPlayer);
    }

    public EntityMooshroom func_94900_c(EntityAgeable entityAgeable) {
        return new EntityMooshroom(this.field_70170_p);
    }

    @Override
    public EntityCow func_70879_a(EntityAgeable entityAgeable) {
        return this.func_94900_c(entityAgeable);
    }

    @Override
    public EntityAgeable func_90011_a(EntityAgeable entityAgeable) {
        return this.func_94900_c(entityAgeable);
    }

    @Override
    public boolean isShearable(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3) {
        return this.func_70874_b() >= 0;
    }

    @Override
    public ArrayList<cvzo> onSheared(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3, int n4) {
        this.func_70106_y();
        EntityCow entityCow = new EntityCow(this.field_70170_p);
        entityCow.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
        entityCow.func_70606_j(this.func_110143_aJ());
        entityCow.field_70761_aq = this.field_70761_aq;
        this.field_70170_p.func_72838_d(entityCow);
        this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t, this.field_70163_u + (double)(this.field_70131_O / 2.0f), this.field_70161_v, 0.0, 0.0, 0.0);
        ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
        for (int i = 0; i < 5; ++i) {
            arrayList.add(new cvzo(twgu.field_72103_ag));
        }
        return arrayList;
    }
}

