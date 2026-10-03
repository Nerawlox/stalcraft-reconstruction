/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityAIOccupyBed
extends EntityAIBase {
    private final EntityNPCInterface npc;
    private int maxSleepingTicks = 0;
    private int bedX = 0;
    private int bedY = 0;
    private int bedZ = 0;

    public EntityAIOccupyBed(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
        this.setMutexBits(5);
    }

    @Override
    public boolean shouldExecute() {
        return !this.npc.isSleeping() && this.getNearbyBedDistance() && !this.npc.worldObj.isDaytime();
    }

    @Override
    public boolean continueExecuting() {
        return !this.npc.worldObj.isDaytime() && this.isSittableBlock(this.npc.worldObj, this.bedX, this.bedY, this.bedZ);
    }

    @Override
    public void startExecuting() {
        this.npc.getNavigator()._a((double)this.bedX + 0.5, this.bedY + 1, (double)this.bedZ + 0.5, 1.0);
        this.npc.setSleeping(false);
    }

    @Override
    public void resetTask() {
        this.npc.setSleeping(false);
        this.occupyBed(this.npc.worldObj, this.bedX, this.bedY, this.bedZ, false);
    }

    @Override
    public void updateTask() {
        if (this.npc.getDistanceSq(this.bedX, this.bedY + 1, this.bedZ) > 1.5) {
            this.npc.setSleeping(false);
            this.npc.getNavigator()._a(this.bedX, this.bedY + 1, this.bedZ, 1.0);
        } else if (!this.npc.isSleeping()) {
            this.npc.prevRenderYawOffset = this.npc.renderYawOffset = (float)this.getDirection(this.npc.worldObj, this.bedX, this.bedY, this.bedZ);
            this.npc.rotationYaw = this.npc.renderYawOffset;
            this.npc.prevRotationYaw = this.npc.renderYawOffset;
            this.npc.setSleeping(true);
            this.occupyBed(this.npc.worldObj, this.bedX, this.bedY, this.bedZ, true);
        }
    }

    protected boolean getNearbyBedDistance() {
        int n = (int)this.npc.posY;
        double d = 2.147483647E9;
        int n2 = (int)this.npc.posX - 8;
        while ((double)n2 < this.npc.posX + 8.0) {
            int n3 = (int)this.npc.posZ - 8;
            while ((double)n3 < this.npc.posZ + 8.0) {
                double d2;
                if (this.isSittableBlock(this.npc.worldObj, n2, n, n3) && this.npc.worldObj.isAirBlock(n2, n + 1, n3) && (d2 = this.npc.getDistanceSq(n2, n, n3)) < d) {
                    this.bedX = n2;
                    this.bedY = n;
                    this.bedZ = n3;
                    d = d2;
                }
                ++n3;
            }
            ++n2;
        }
        return d < 2.147483647E9;
    }

    protected boolean isSittableBlock(World world, int n, int n2, int n3) {
        int n4 = world.getBlockId(n, n2, n3);
        int n5 = world.getBlockMetadata(n, n2, n3);
        return n4 == Block.bed.blockID && !BlockBed._a(n5);
    }

    protected int getDirection(World world, int n, int n2, int n3) {
        int n4 = -1;
        int n5 = world.getBlockMetadata(n, n2, n3);
        int n6 = BlockBed._d(n5);
        switch (n6) {
            case 0: {
                n4 = 180;
                break;
            }
            case 1: {
                n4 = 270;
                break;
            }
            case 2: {
                n4 = 0;
                break;
            }
            case 3: {
                n4 = 90;
            }
        }
        return n4;
    }

    protected void occupyBed(World world, int n, int n2, int n3, boolean bl) {
        int n4 = world.getBlockId(n, n2, n3);
        if (n4 == Block.bed.blockID) {
            BlockBed._a(world, n, n2, n3, bl);
        }
    }
}

