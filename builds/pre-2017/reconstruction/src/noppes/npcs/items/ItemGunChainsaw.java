/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import noppes.npcs.items.ItemNpcWeaponInterface;

public class ItemGunChainsaw
extends ItemNpcWeaponInterface {
    public ItemGunChainsaw(int n, txfz txfz2) {
        super(n, txfz2);
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        if (entityLivingBase.getHealth() <= 0.0f) {
            return false;
        }
        double d = entityLivingBase.posX;
        double d2 = entityLivingBase.posY + (double)(entityLivingBase.height / 2.0f);
        double d3 = entityLivingBase.posZ;
        entityLivingBase2.worldObj.playSoundEffect(d, d2, d3, "random.explode", 0.8f, (1.0f + (entityLivingBase2.worldObj.rand.nextFloat() - entityLivingBase2.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
        entityLivingBase2.worldObj.spawnParticle("largeexplode", d, d2, d3, 0.0, 0.0, 0.0);
        return super.hitEntity(itemStack, entityLivingBase, entityLivingBase2);
    }
}

