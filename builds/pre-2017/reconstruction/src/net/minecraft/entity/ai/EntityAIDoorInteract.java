/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.sajh;

public abstract class EntityAIDoorInteract
extends EntityAIBase {
    public EntityLiving theEntity;
    public int entityPosX;
    public int entityPosY;
    public int entityPosZ;
    public BlockDoor targetDoor;
    public boolean hasStoppedDoorInteraction;
    public float entityPositionX;
    public float entityPositionZ;

    public EntityAIDoorInteract(EntityLiving entityLiving) {
        this.theEntity = entityLiving;
    }

    @Override
    public boolean shouldExecute() {
        if (!this.theEntity.isCollidedHorizontally) {
            return false;
        }
        PathNavigate pathNavigate = this.theEntity.getNavigator();
        PathEntity pathEntity = pathNavigate._d();
        if (pathEntity == null || pathEntity._e() || !pathNavigate._b()) {
            return false;
        }
        for (int i = 0; i < Math.min(pathEntity._h() + 2, pathEntity._g()); ++i) {
            elhc elhc2 = pathEntity._c(i);
            this.entityPosX = elhc2._a;
            this.entityPosY = elhc2._b + 1;
            this.entityPosZ = elhc2._c;
            if (this.theEntity.getDistanceSq(this.entityPosX, this.theEntity.posY, this.entityPosZ) > 2.25) continue;
            this.targetDoor = this.findUsableDoor(this.entityPosX, this.entityPosY, this.entityPosZ);
            if (this.targetDoor == null) continue;
            return true;
        }
        this.entityPosX = sajh._c(this.theEntity.posX);
        this.entityPosY = sajh._c(this.theEntity.posY + 1.0);
        this.entityPosZ = sajh._c(this.theEntity.posZ);
        this.targetDoor = this.findUsableDoor(this.entityPosX, this.entityPosY, this.entityPosZ);
        return this.targetDoor != null;
    }

    @Override
    public boolean continueExecuting() {
        return !this.hasStoppedDoorInteraction;
    }

    @Override
    public void startExecuting() {
        this.hasStoppedDoorInteraction = false;
        this.entityPositionX = (float)((double)((float)this.entityPosX + 0.5f) - this.theEntity.posX);
        this.entityPositionZ = (float)((double)((float)this.entityPosZ + 0.5f) - this.theEntity.posZ);
    }

    @Override
    public void updateTask() {
        float f = (float)((double)((float)this.entityPosX + 0.5f) - this.theEntity.posX);
        float f2 = (float)((double)((float)this.entityPosZ + 0.5f) - this.theEntity.posZ);
        float f3 = this.entityPositionX * f + this.entityPositionZ * f2;
        if (f3 < 0.0f) {
            this.hasStoppedDoorInteraction = true;
        }
    }

    public BlockDoor findUsableDoor(int n, int n2, int n3) {
        int n4 = this.theEntity.worldObj.getBlockId(n, n2, n3);
        if (n4 != Block.doorWood.blockID) {
            return null;
        }
        return (BlockDoor)Block.blocksList[n4];
    }
}

