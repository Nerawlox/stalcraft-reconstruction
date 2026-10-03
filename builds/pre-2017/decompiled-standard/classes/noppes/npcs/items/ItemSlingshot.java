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

public class ItemSlingshot
extends ItemNpcInterface {
    public ItemSlingshot(int n) {
        super(n);
        this.field_77777_bU = 1;
        this.func_77656_e(384);
        this.func_77637_a(CustomItems.tabWeapon);
    }

    @Override
    public void func_77615_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer, int n) {
        int n2;
        if (!ozlu2.field_72995_K && (n2 = this.func_77626_a(cvzo2) - n) >= 6 && (entityPlayer.field_71075_bZ._d || entityPlayer.field_71071_by._c(twgu.field_71978_w.field_71990_ca))) {
            cvzo2._a(1, (EntityLivingBase)entityPlayer);
            EntityProjectile entityProjectile = new EntityProjectile(ozlu2, entityPlayer, new cvzo(twgu.field_71978_w), false);
            entityProjectile.damage = 3.0f;
            entityProjectile.punch = 1;
            entityProjectile.setRotating(true);
            if (n2 > 24) {
                entityProjectile.setParticleEffect(EnumParticleType.Crit);
                entityProjectile.punch = 2;
            }
            entityProjectile.setHasGravity(true);
            entityProjectile.setSpeed(14);
            entityProjectile.shoot(1.0f);
            ozlu2.func_72956_a(entityPlayer, "random.bow", 1.0f, tgdv.field_77697_d.nextFloat() * 0.3f + 0.8f);
            ozlu2.func_72838_d(entityProjectile);
        }
    }

    @Override
    public void renderSpecial() {
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
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

    @Override
    public bsre func_77661_b(cvzo cvzo2) {
        return bsre._e;
    }
}

