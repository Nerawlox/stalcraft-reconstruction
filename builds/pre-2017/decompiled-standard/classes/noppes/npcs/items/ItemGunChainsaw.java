/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.EntityLivingBase;
import noppes.npcs.items.ItemNpcWeaponInterface;

public class ItemGunChainsaw
extends ItemNpcWeaponInterface {
    public ItemGunChainsaw(int n, txfz txfz2) {
        super(n, txfz2);
    }

    @Override
    public boolean func_77644_a(cvzo cvzo2, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        if (entityLivingBase.func_110143_aJ() <= 0.0f) {
            return false;
        }
        double d = entityLivingBase.field_70165_t;
        double d2 = entityLivingBase.field_70163_u + (double)(entityLivingBase.field_70131_O / 2.0f);
        double d3 = entityLivingBase.field_70161_v;
        entityLivingBase2.field_70170_p.func_72908_a(d, d2, d3, "random.explode", 0.8f, (1.0f + (entityLivingBase2.field_70170_p.field_73012_v.nextFloat() - entityLivingBase2.field_70170_p.field_73012_v.nextFloat()) * 0.2f) * 0.7f);
        entityLivingBase2.field_70170_p.func_72869_a("largeexplode", d, d2, d3, 0.0, 0.0, 0.0);
        return super.func_77644_a(cvzo2, entityLivingBase, entityLivingBase2);
    }
}

