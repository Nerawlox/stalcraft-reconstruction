/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.CustomItems;
import noppes.npcs.entity.EntityProjectile;
import noppes.npcs.items.ItemNpcInterface;
import org.lwjgl.opengl.GL11;

public class ItemMachineGun
extends ItemNpcInterface {
    public ItemMachineGun(int n) {
        super(n);
        this.func_77656_e(80);
        this.func_77637_a(CustomItems.tabWeapon);
    }

    @Override
    public void func_77615_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer, int n) {
        if (!entityPlayer.field_71075_bZ._d) {
            int n2 = this.func_77626_a(cvzo2) - n;
            int n3 = cvzo2._e._f("ShotsLeft") - n2 / 6;
            if (cvzo2._e._f("Reloading") == 1) {
                n3 = n2 / 3;
                if (n2 > 24) {
                    n3 = 8;
                }
                if (n3 > 1) {
                    cvzo2._e._a("ShotsLeft", n3);
                    cvzo2._e._a("Reloading", 0);
                }
            } else if (n3 <= 0) {
                cvzo2._e._a("Reloading", 1);
                cvzo2._a(1, (EntityLivingBase)entityPlayer);
            } else {
                cvzo2._e._a("ShotsLeft", n3);
            }
        }
    }

    @Override
    public void onUsingItemTick(cvzo cvzo2, EntityPlayer entityPlayer, int n) {
        int n2;
        if (!entityPlayer.field_70170_p.field_72995_K && (n2 = this.func_77626_a(cvzo2) - n) % 6 == 0) {
            int n3 = cvzo2._e._f("ShotsLeft") - n2 / 6;
            if (!entityPlayer.field_71075_bZ._d) {
                if (cvzo2._e._f("Reloading") == 1 && entityPlayer.field_71071_by._d(CustomItems.bulletBlack.field_77779_bT)) {
                    if (n2 > 0 && n2 <= 24) {
                        entityPlayer.field_70170_p.func_72956_a(entityPlayer, "customnpcs:gun.ak47chamberround", 1.0f, 1.0f);
                    }
                    return;
                }
                if (n3 <= 0 || !entityPlayer.field_71071_by._d(CustomItems.bulletBlack.field_77779_bT)) {
                    entityPlayer.field_70170_p.func_72956_a(entityPlayer, "customnpcs:gun.empty", 1.0f, 1.0f);
                    return;
                }
            }
            EntityProjectile entityProjectile = new EntityProjectile(entityPlayer.field_70170_p, entityPlayer, new cvzo(CustomItems.bulletBlack, 1, 0), false);
            entityProjectile.damage = 4.0f;
            entityProjectile.setSpeed(40);
            entityProjectile.shoot(2.0f);
            if (!entityPlayer.field_71075_bZ._d) {
                entityPlayer.field_71071_by._c(CustomItems.bulletBlack.field_77779_bT);
            }
            entityPlayer.field_70170_p.func_72956_a(entityPlayer, "customnpcs:gun.pistolshot", 0.9f, tgdv.field_77697_d.nextFloat() * 0.3f + 0.8f);
            entityPlayer.field_70170_p.func_72838_d(entityProjectile);
        }
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.7f, 0.7f, 0.7f);
        GL11.glTranslatef(0.0f, 0.2f, 0.0f);
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (cvzo2._e == null) {
            cvzo2._e = new qoac();
        }
        if (!entityPlayer.field_71075_bZ._d && !entityPlayer.field_71071_by._d(CustomItems.bulletBlack.field_77779_bT)) {
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

