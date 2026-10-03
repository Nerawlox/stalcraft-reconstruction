/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.CustomItems;
import noppes.npcs.entity.EntityProjectile;
import noppes.npcs.items.ItemNpcInterface;

public class ItemThrowingWeapon
extends ItemNpcInterface {
    private boolean rotating = false;
    private int damage = 2;
    private boolean dropItem = false;

    public ItemThrowingWeapon(int n) {
        super(n);
        this.func_77637_a(CustomItems.tabWeapon);
    }

    @Override
    public void func_77615_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer, int n) {
        if (ozlu2.field_72995_K) {
            entityPlayer.func_71038_i();
        } else {
            EntityProjectile entityProjectile = new EntityProjectile(ozlu2, entityPlayer, new cvzo(cvzo2._a(), 1, cvzo2._j()), false);
            entityProjectile.damage = this.damage;
            entityProjectile.canBePickedUp = !entityPlayer.field_71075_bZ._d && this.dropItem;
            entityProjectile.setRotating(this.rotating);
            entityProjectile.setIs3D(true);
            entityProjectile.setStickInWall(true);
            entityProjectile.setHasGravity(true);
            entityProjectile.setSpeed(12);
            if (!entityPlayer.field_71075_bZ._d) {
                entityPlayer.field_71071_by._c(this.field_77779_bT);
            }
            entityProjectile.shoot(1.0f);
            ozlu2.func_72956_a(entityPlayer, "customnpcs:misc.swosh", 1.0f, 1.0f);
            ozlu2.func_72838_d(entityProjectile);
        }
    }

    public ItemThrowingWeapon setRotating() {
        this.rotating = true;
        return this;
    }

    public ItemThrowingWeapon setDamage(int n) {
        this.damage = n;
        return this;
    }

    public ItemThrowingWeapon setDropItem() {
        this.dropItem = true;
        return this;
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
}

