/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.entity.EntityProjectile;
import noppes.npcs.items.ItemNpcWeaponInterface;
import org.lwjgl.opengl.GL11;

public class ItemKunai
extends ItemNpcWeaponInterface {
    public ItemKunai(int n, txfz txfz2) {
        super(n, txfz2);
    }

    @Override
    public void func_77615_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer, int n) {
        if (ozlu2.field_72995_K) {
            entityPlayer.func_71038_i();
        } else {
            EntityProjectile entityProjectile = new EntityProjectile(ozlu2, entityPlayer, cvzo2, false);
            entityProjectile.damage = this.func_82803_g();
            entityProjectile.destroyedOnEntityHit = false;
            entityProjectile.canBePickedUp = !entityPlayer.field_71075_bZ._d;
            entityProjectile.setIs3D(true);
            entityProjectile.setStickInWall(true);
            entityProjectile.setHasGravity(true);
            entityProjectile.setSpeed(12);
            entityProjectile.shoot(1.0f);
            if (!entityPlayer.field_71075_bZ._d) {
                cvzo2._a(1, (EntityLivingBase)entityPlayer);
                if (cvzo2._b == 0) {
                    return;
                }
                entityPlayer.field_71071_by._a[entityPlayer.field_71071_by._c] = null;
            }
            ozlu2.func_72956_a(entityPlayer, "customnpcs:misc.swosh", 1.0f, 1.0f);
            ozlu2.func_72838_d(entityProjectile);
        }
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        entityPlayer.func_71008_a(cvzo2, this.func_77626_a(cvzo2));
        return cvzo2;
    }

    @Override
    public int func_77626_a(cvzo cvzo2) {
        return 72000;
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.4f, 0.4f, 0.4f);
        GL11.glTranslatef(-0.2f, 0.3f, 0.2f);
    }

    @Override
    public boolean func_77629_n_() {
        return true;
    }
}

