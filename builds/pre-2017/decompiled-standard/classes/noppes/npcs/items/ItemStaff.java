/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.entity.EntityMagicProjectile;
import noppes.npcs.entity.EntityProjectile;
import noppes.npcs.items.EnumNpcToolMaterial;
import noppes.npcs.items.ItemNpcInterface;

public class ItemStaff
extends ItemNpcInterface {
    private EnumNpcToolMaterial material;

    public ItemStaff(int n, EnumNpcToolMaterial enumNpcToolMaterial) {
        super(n);
        this.material = enumNpcToolMaterial;
        this.func_77637_a(CustomItems.tabWeapon);
    }

    @Override
    public void renderSpecial() {
    }

    @Override
    public void func_77615_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer, int n) {
        Entity entity;
        if (!ozlu2.field_72995_K && cvzo2._e != null && (entity = ((yfgy)entityPlayer.field_70170_p).func_73045_a(cvzo2._e._f("MagicProjectile"))) != null && entity instanceof EntityProjectile) {
            EntityProjectile entityProjectile = (EntityProjectile)entity;
            entityProjectile.field_70126_B = entityProjectile.field_70177_z = entityPlayer.field_70177_z;
            entityProjectile.field_70127_C = entityProjectile.field_70125_A = entityPlayer.field_70125_A;
            entityProjectile.shoot(2.0f);
            entityPlayer.field_70170_p.func_72956_a(entityPlayer, "customnpcs:magic.shot", 1.0f, 1.0f);
        }
    }

    @Override
    public void onUsingItemTick(cvzo cvzo2, EntityPlayer entityPlayer, int n) {
        int n2 = this.func_77626_a(cvzo2) - n;
        if (entityPlayer.field_70170_p.field_72995_K) {
            this.spawnParticle(cvzo2, entityPlayer);
        } else {
            double d;
            double d2;
            EntityProjectile entityProjectile;
            int n3 = 20 + this.material.getHarvestLevel() * 8;
            if (n2 == n3) {
                if (!entityPlayer.field_71075_bZ._d) {
                    if (!entityPlayer.field_71071_by._d(CustomItems.mana.field_77779_bT)) {
                        return;
                    }
                    entityPlayer.field_71071_by._c(CustomItems.mana.field_77779_bT);
                }
                entityPlayer.field_70170_p.func_72956_a(entityPlayer, "customnpcs:magic.charge", 1.0f, 1.0f);
                if (cvzo2._e == null) {
                    cvzo2._e = new qoac();
                }
                int n4 = 6 + this.material.getDamageVsEntity() + entityPlayer.field_70170_p.field_73012_v.nextInt(4);
                entityProjectile = new EntityMagicProjectile(entityPlayer.field_70170_p, entityPlayer, this.getProjectile(cvzo2), false);
                entityProjectile.damage = n4;
                entityProjectile.setSpeed(25);
                d2 = -sajh._a((float)((double)(entityPlayer.field_70177_z / 180.0f) * Math.PI)) * sajh._b((float)((double)(entityPlayer.field_70125_A / 180.0f) * Math.PI));
                d = sajh._b((float)((double)(entityPlayer.field_70177_z / 180.0f) * Math.PI)) * sajh._b((float)((double)(entityPlayer.field_70125_A / 180.0f) * Math.PI));
                entityProjectile.func_70107_b(entityPlayer.field_70165_t + d2 * 0.8, entityPlayer.field_70163_u + 1.5 - (double)(entityPlayer.field_70125_A / 40.0f), entityPlayer.field_70161_v + d * 0.8);
                entityPlayer.field_70170_p.func_72838_d(entityProjectile);
                cvzo2._e._a("MagicProjectile", entityProjectile.field_70157_k);
            }
            if (n2 > n3 && cvzo2._e != null) {
                Entity entity = ((yfgy)entityPlayer.field_70170_p).func_73045_a(cvzo2._e._f("MagicProjectile"));
                if (entity == null || !(entity instanceof EntityProjectile)) {
                    return;
                }
                entityProjectile = (EntityProjectile)entity;
                entityProjectile.ticksInAir = 0;
                d2 = -sajh._a((float)((double)(entityPlayer.field_70177_z / 180.0f) * Math.PI)) * sajh._b((float)((double)(entityPlayer.field_70125_A / 180.0f) * Math.PI));
                d = sajh._b((float)((double)(entityPlayer.field_70177_z / 180.0f) * Math.PI)) * sajh._b((float)((double)(entityPlayer.field_70125_A / 180.0f) * Math.PI));
                entityProjectile.func_70107_b(entityPlayer.field_70165_t + d2 * 0.8, entityPlayer.field_70163_u + 1.5 - (double)(entityPlayer.field_70125_A / 40.0f), entityPlayer.field_70161_v + d * 0.8);
            }
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
    public bsre func_77661_b(cvzo cvzo2) {
        return bsre._e;
    }

    public cvzo getProjectile(cvzo cvzo2) {
        return cvzo2._a() == CustomItems.staffWood ? new cvzo(CustomItems.spellNature) : (cvzo2._a() == CustomItems.staffStone ? new cvzo(CustomItems.spellDark) : (cvzo2._a() == CustomItems.staffIron ? new cvzo(CustomItems.spellHoly) : (cvzo2._a() == CustomItems.staffBronze ? new cvzo(CustomItems.spellLightning) : (cvzo2._a() == CustomItems.staffGold ? new cvzo(CustomItems.spellFire) : (cvzo2._a() == CustomItems.staffDiamond ? new cvzo(CustomItems.spellIce) : (cvzo2._a() == CustomItems.staffEmerald ? new cvzo(CustomItems.spellArcane) : new cvzo(CustomItems.orb, 1, cvzo2._j())))))));
    }

    public void spawnParticle(cvzo cvzo2, EntityPlayer entityPlayer) {
        if (cvzo2._a() == CustomItems.staffWood) {
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 5, 2);
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 12, 2);
        }
        if (cvzo2._a() == CustomItems.staffStone) {
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 5649239, 2);
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 4400964, 2);
        }
        if (cvzo2._a() == CustomItems.staffBronze) {
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 8648694, 2);
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 6091007, 2);
        }
        if (cvzo2._a() == CustomItems.staffIron) {
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 0xFCFFC9, 2);
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 15728535, 2);
        }
        if (cvzo2._a() == CustomItems.staffGold) {
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 1, 2);
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 14, 2);
        }
        if (cvzo2._a() == CustomItems.staffDiamond) {
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 9756653, 2);
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 4503295, 2);
        }
        if (cvzo2._a() == CustomItems.staffEmerald) {
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 16761831, 2);
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 16487167, 2);
        }
    }
}

