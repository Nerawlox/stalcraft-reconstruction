/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.CustomItems;
import noppes.npcs.constants.EnumParticleType;
import noppes.npcs.entity.EntityProjectile;
import noppes.npcs.items.ItemNpcInterface;
import org.lwjgl.opengl.GL11;

public class ItemMusket
extends ItemNpcInterface {
    public ItemMusket(int n) {
        super(n);
        this.func_77656_e(129);
        this.func_77637_a(CustomItems.tabWeapon);
    }

    @Override
    public void func_77615_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer, int n) {
        if (!entityPlayer.field_70170_p.field_72995_K) {
            if (cvzo2._e._f("IsLoaded") != 1 && !entityPlayer.field_71075_bZ._d) {
                entityPlayer.field_70170_p.func_72956_a(entityPlayer, "gun.empty", 1.0f, 1.0f);
            } else {
                if (cvzo2._e._f("Reloading") == 1 && !entityPlayer.field_71075_bZ._d) {
                    cvzo2._e._a("Reloading", 0);
                    return;
                }
                cvzo2._a(1, (EntityLivingBase)entityPlayer);
                EntityProjectile entityProjectile = new EntityProjectile(entityPlayer.field_70170_p, entityPlayer, new cvzo(CustomItems.bulletBlack, 1, 0), false);
                entityProjectile.damage = 16.0f;
                entityProjectile.setSpeed(50);
                entityProjectile.setParticleEffect(EnumParticleType.Smoke);
                entityProjectile.shoot(2.0f);
                if (!entityPlayer.field_71075_bZ._d) {
                    entityPlayer.field_71071_by._c(CustomItems.bulletBlack.field_77779_bT);
                }
                entityPlayer.field_70170_p.func_72956_a(entityPlayer, "random.explode", 0.9f, tgdv.field_77697_d.nextFloat() * 0.3f + 1.8f);
                entityPlayer.field_70170_p.func_72956_a(entityPlayer, "ambient.weather.thunder", 2.0f, tgdv.field_77697_d.nextFloat() * 0.3f + 1.8f);
                entityPlayer.field_70170_p.func_72838_d(entityProjectile);
                cvzo2._e._a("IsLoaded", 0);
            }
        }
    }

    @Override
    public void onUsingItemTick(cvzo cvzo2, EntityPlayer entityPlayer, int n) {
        if (!entityPlayer.field_70170_p.field_72995_K) {
            int n2 = this.func_77626_a(cvzo2) - n;
            if (!entityPlayer.field_71075_bZ._d && cvzo2._e._f("Reloading") == 1 && entityPlayer.field_71071_by._d(CustomItems.bulletBlack.field_77779_bT) && n2 == 60) {
                entityPlayer.field_70170_p.func_72956_a(entityPlayer, "customnpcs:gun.ak47chamberround", 1.0f, 1.0f);
                cvzo2._e._a("IsLoaded", 1);
            }
        }
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.7f, 0.7f, 0.7f);
        GL11.glTranslatef(0.2f, 0.2f, -0.3f);
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (cvzo2._e == null) {
            cvzo2._e = new qoac();
        }
        if (!entityPlayer.field_71075_bZ._d && entityPlayer.field_71071_by._d(CustomItems.bulletBlack.field_77779_bT) && cvzo2._e._f("IsLoaded") == 0) {
            cvzo2._e._a("Reloading", 1);
        }
        entityPlayer.func_71008_a(cvzo2, this.func_77626_a(cvzo2));
        return cvzo2;
    }

    @Override
    public int func_77626_a(cvzo cvzo2) {
        return 72000;
    }

    @Override
    public bsre func_77661_b(cvzo cvzo2) {
        return cvzo2._e != null && cvzo2._e._f("Reloading") != 0 ? bsre._d : bsre._e;
    }
}

