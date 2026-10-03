/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.CustomItems;
import noppes.npcs.entity.EntityProjectile;
import noppes.npcs.items.EnumNpcToolMaterial;
import noppes.npcs.items.ItemBullet;
import noppes.npcs.items.ItemNpcInterface;
import org.lwjgl.opengl.GL11;

public class ItemGun
extends ItemNpcInterface {
    private EnumNpcToolMaterial material;

    public ItemGun(int n, EnumNpcToolMaterial enumNpcToolMaterial) {
        super(n);
        this.field_77777_bU = 1;
        this.material = enumNpcToolMaterial;
        this.func_77656_e(enumNpcToolMaterial.getMaxUses());
        this.func_77637_a(CustomItems.tabWeapon);
    }

    @Override
    public void func_77615_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer, int n) {
        if (!ozlu2.field_72995_K) {
            if (!this.hasBullet(entityPlayer)) {
                ozlu2.func_72956_a(entityPlayer, "customnpcs:gun.empty", 1.0f, 1.0f);
            } else {
                int n2 = this.func_77626_a(cvzo2) - n;
                if (n2 >= 10) {
                    cvzo2._a(1, (EntityLivingBase)entityPlayer);
                    ItemBullet itemBullet = (ItemBullet)this.getBullet(entityPlayer);
                    int n3 = (itemBullet.getBulletDamage() + this.material.getDamageVsEntity() + 1) / 2 + 5;
                    EntityProjectile entityProjectile = new EntityProjectile(ozlu2, entityPlayer, new cvzo(this.getBullet(entityPlayer)), false);
                    entityProjectile.damage = n3;
                    entityProjectile.setSpeed(40);
                    entityProjectile.shoot(this.material.getDamageVsEntity() + 1);
                    if (!entityPlayer.field_71075_bZ._d) {
                        entityPlayer.field_71071_by._c(this.getBullet((EntityPlayer)entityPlayer).field_77779_bT);
                    }
                    ozlu2.func_72956_a(entityPlayer, "customnpcs:gun.pistolshot", 1.0f, tgdv.field_77697_d.nextFloat() * 0.3f + 0.8f);
                    ozlu2.func_72838_d(entityProjectile);
                }
            }
        }
    }

    @Override
    public void onUsingItemTick(cvzo cvzo2, EntityPlayer entityPlayer, int n) {
        int n2 = this.func_77626_a(cvzo2) - n;
        if (n2 == 8 && !entityPlayer.field_70170_p.field_72995_K) {
            entityPlayer.field_70170_p.func_72956_a(entityPlayer, "customnpcs:gun.pistoltrigger", 1.0f, 1.0f / (entityPlayer.field_70170_p.field_73012_v.nextFloat() * 0.4f + 0.8f));
        }
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.7f, 0.7f, 0.7f);
        GL11.glTranslatef(0.0f, 0.3f, 0.0f);
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

    private boolean hasBullet(EntityPlayer entityPlayer) {
        tgdv tgdv2 = this.getBullet(entityPlayer);
        return tgdv2 != null && tgdv2.field_77779_bT >= 0;
    }

    private tgdv getBullet(EntityPlayer entityPlayer) {
        switch (NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[this.material.ordinal()]) {
            case 1: {
                if (entityPlayer.field_71071_by._d(CustomItems.bulletEmerald.field_77779_bT)) {
                    return CustomItems.bulletEmerald;
                }
            }
            case 2: {
                if (entityPlayer.field_71071_by._d(CustomItems.bulletDiamond.field_77779_bT)) {
                    return CustomItems.bulletDiamond;
                }
            }
            case 3: {
                if (entityPlayer.field_71071_by._d(CustomItems.bulletIron.field_77779_bT)) {
                    return CustomItems.bulletIron;
                }
            }
            case 4: {
                if (entityPlayer.field_71071_by._d(CustomItems.bulletBronze.field_77779_bT)) {
                    return CustomItems.bulletBronze;
                }
            }
            case 5: {
                if (entityPlayer.field_71071_by._d(CustomItems.bulletGold.field_77779_bT)) {
                    return CustomItems.bulletGold;
                }
            }
            case 6: {
                if (entityPlayer.field_71071_by._d(CustomItems.bulletStone.field_77779_bT)) {
                    return CustomItems.bulletStone;
                }
            }
            case 7: {
                if (!entityPlayer.field_71071_by._d(CustomItems.bulletWood.field_77779_bT)) break;
                return CustomItems.bulletWood;
            }
        }
        return !entityPlayer.field_71071_by._d(CustomItems.bulletBlack.field_77779_bT) && !entityPlayer.field_71075_bZ._d ? null : CustomItems.bulletBlack;
    }

    @Override
    public bsre func_77661_b(cvzo cvzo2) {
        return bsre._e;
    }

    static class NamelessClass975299564 {
        static final int[] $SwitchMap$noppes$npcs$items$EnumNpcToolMaterial = new int[EnumNpcToolMaterial.values().length];

        NamelessClass975299564() {
        }

        static {
            try {
                NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[EnumNpcToolMaterial.EMERALD.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[EnumNpcToolMaterial.DIA.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[EnumNpcToolMaterial.IRON.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[EnumNpcToolMaterial.BRONZE.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[EnumNpcToolMaterial.GOLD.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[EnumNpcToolMaterial.STONE.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass975299564.$SwitchMap$noppes$npcs$items$EnumNpcToolMaterial[EnumNpcToolMaterial.WOOD.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

