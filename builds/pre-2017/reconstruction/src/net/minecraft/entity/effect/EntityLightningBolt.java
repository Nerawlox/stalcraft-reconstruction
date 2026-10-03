/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.effect;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityWeatherEffect;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;

public class EntityLightningBolt
extends EntityWeatherEffect {
    public int lightningState;
    public long boltVertex;
    public int boltLivingTime;

    public EntityLightningBolt(World world, double d, double d2, double d3) {
        super(world);
        this.setLocationAndAngles(d, d2, d3, 0.0f, 0.0f);
        this.lightningState = 2;
        this.boltVertex = this.rand.nextLong();
        this.boltLivingTime = this.rand.nextInt(3) + 1;
        if (!world.isRemote && world.getGameRules()._b("doFireTick") && world.difficultySetting >= 2 && world.doChunksNearChunkExist(sajh._c(d), sajh._c(d2), sajh._c(d3), 10)) {
            int n;
            int n2;
            int n3 = sajh._c(d);
            if (world.getBlockId(n3, n2 = sajh._c(d2), n = sajh._c(d3)) == 0 && Block.fire.canPlaceBlockAt(world, n3, n2, n)) {
                world.setBlock(n3, n2, n, Block.fire.blockID);
            }
            for (n3 = 0; n3 < 4; ++n3) {
                int n4;
                n2 = sajh._c(d) + this.rand.nextInt(3) - 1;
                if (world.getBlockId(n2, n = sajh._c(d2) + this.rand.nextInt(3) - 1, n4 = sajh._c(d3) + this.rand.nextInt(3) - 1) != 0 || !Block.fire.canPlaceBlockAt(world, n2, n, n4)) continue;
                world.setBlock(n2, n, n4, Block.fire.blockID);
            }
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.lightningState == 2) {
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0f, 0.8f + this.rand.nextFloat() * 0.2f);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 2.0f, 0.5f + this.rand.nextFloat() * 0.2f);
        }
        --this.lightningState;
        if (this.lightningState < 0) {
            if (this.boltLivingTime == 0) {
                this.setDead();
            } else if (this.lightningState < -this.rand.nextInt(10)) {
                int n;
                int n2;
                int n3;
                --this.boltLivingTime;
                this.lightningState = 1;
                this.boltVertex = this.rand.nextLong();
                if (!this.worldObj.isRemote && this.worldObj.getGameRules()._b("doFireTick") && this.worldObj.doChunksNearChunkExist(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ), 10) && this.worldObj.getBlockId(n3 = sajh._c(this.posX), n2 = sajh._c(this.posY), n = sajh._c(this.posZ)) == 0 && Block.fire.canPlaceBlockAt(this.worldObj, n3, n2, n)) {
                    this.worldObj.setBlock(n3, n2, n, Block.fire.blockID);
                }
            }
        }
        if (this.lightningState >= 0) {
            if (this.worldObj.isRemote) {
                this.worldObj.lastLightningBolt = 2;
            } else {
                double d = 3.0;
                List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, AxisAlignedBB._a()._a(this.posX - d, this.posY - d, this.posZ - d, this.posX + d, this.posY + 6.0 + d, this.posZ + d));
                for (int i = 0; i < list2.size(); ++i) {
                    Entity entity = (Entity)list2.get(i);
                    if (MinecraftForge.EVENT_BUS.post(new EntityStruckByLightningEvent(entity, this))) continue;
                    entity.onStruckByLightning(this);
                }
            }
        }
    }

    @Override
    public void entityInit() {
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean isInRangeToRenderVec3D(Vec3 vec3) {
        return this.lightningState >= 0;
    }
}

