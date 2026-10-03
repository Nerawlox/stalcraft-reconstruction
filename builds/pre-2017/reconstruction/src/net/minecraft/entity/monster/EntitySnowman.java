/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tdmn;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntitySnowman
extends EntityGolem
implements tdmn {
    public EntitySnowman(World world) {
        super(world);
        this.setSize(0.4f, 1.8f);
        this.getNavigator()._a(true);
        this.tasks._a(1, new EntityAIArrowAttack(this, 1.25, 20, 10.0f));
        this.tasks._a(2, new iurn(this, 1.0));
        this.tasks._a(3, new iurq(this, EntityPlayer.class, 6.0f));
        this.tasks._a(4, new net.minecraft.entity.ai.tdmn(this));
        this.targetTasks._a(1, new pibk(this, EntityLiving.class, 0, true, false, ezey._a));
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(4.0);
        this.getEntityAttribute(sajz._d)._a(0.2f);
    }

    @Override
    public void onLivingUpdate() {
        int n;
        int n2;
        super.onLivingUpdate();
        if (this.isWet()) {
            this.attackEntityFrom(DamageSource.drown, 1.0f);
        }
        if (this.worldObj.getBiomeGenForCoords(n2 = sajh._c(this.posX), n = sajh._c(this.posZ))._k() > 1.0f) {
            this.attackEntityFrom(DamageSource.onFire, 1.0f);
        }
        for (n2 = 0; n2 < 4; ++n2) {
            int n3;
            int n4;
            n = sajh._c(this.posX + (double)((float)(n2 % 2 * 2 - 1) * 0.25f));
            if (this.worldObj.getBlockId(n, n4 = sajh._c(this.posY), n3 = sajh._c(this.posZ + (double)((float)(n2 / 2 % 2 * 2 - 1) * 0.25f))) != 0 || !(this.worldObj.getBiomeGenForCoords(n, n3)._k() < 0.8f) || !Block.snow.canPlaceBlockAt(this.worldObj, n, n4, n3)) continue;
            this.worldObj.setBlock(n, n4, n3, Block.snow.blockID);
        }
    }

    @Override
    public int getDropItemId() {
        return Item.snowball.itemID;
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        int n2 = this.rand.nextInt(16);
        for (int i = 0; i < n2; ++i) {
            this.dropItem(Item.snowball.itemID, 1);
        }
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase entityLivingBase, float f) {
        EntitySnowball entitySnowball = new EntitySnowball(this.worldObj, this);
        double d = entityLivingBase.posX - this.posX;
        double d2 = entityLivingBase.posY + (double)entityLivingBase.getEyeHeight() - (double)1.1f - entitySnowball.posY;
        double d3 = entityLivingBase.posZ - this.posZ;
        float f2 = sajh._a(d * d + d3 * d3) * 0.2f;
        entitySnowball.setThrowableHeading(d, d2 + (double)f2, d3, 1.6f, 12.0f);
        this.playSound("random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        this.worldObj.spawnEntityInWorld(entitySnowball);
    }
}

