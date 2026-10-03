/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumStandingType;

public class EntityAILook
extends EntityAIBase {
    private final EntityNPCInterface npc;
    boolean rotatebody;
    private int idle = 0;
    private double lookX;
    private double lookZ;

    public EntityAILook(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        return !this.npc.isAttacking() && this.npc.getNavigator()._g() && !this.npc.isPlayerSleeping() && !this.npc.isKilled();
    }

    @Override
    public void startExecuting() {
        this.rotatebody = this.npc.aiData.standingType == EnumStandingType.RotateBody || this.npc.aiData.standingType == EnumStandingType.HeadRotation;
    }

    @Override
    public void resetTask() {
        this.rotatebody = false;
    }

    @Override
    public void updateTask() {
        if (this.npc.aiData.standingType == EnumStandingType.Stalking) {
            EntityPlayer entityPlayer = this.npc.worldObj.getClosestPlayerToEntity(this.npc, 16.0);
            if (entityPlayer == null) {
                this.rotatebody = true;
            } else {
                this.npc.getLookHelper()._a(entityPlayer, 10.0f, (float)this.npc.getVerticalFaceSpeed());
            }
        }
        if (this.rotatebody) {
            if (this.idle == 0 && this.npc.getRNG().nextFloat() < 0.02f) {
                double d = Math.PI * 2 * this.npc.getRNG().nextDouble();
                if (this.npc.aiData.standingType == EnumStandingType.HeadRotation) {
                    d = Math.PI / 180 * (double)this.npc.aiData.orientation + 0.6283185307179586 + 1.8849555921538759 * this.npc.getRNG().nextDouble();
                }
                this.lookX = Math.cos(d);
                this.lookZ = Math.sin(d);
                this.idle = 20 + this.npc.getRNG().nextInt(20);
            }
            if (this.idle > 0) {
                --this.idle;
                this.npc.getLookHelper()._a(this.npc.posX + this.lookX, this.npc.posY + (double)this.npc.getEyeHeight(), this.npc.posZ + this.lookZ, 10.0f, this.npc.getVerticalFaceSpeed());
            }
        }
        if (this.npc.aiData.standingType == EnumStandingType.NoRotation) {
            this.npc.rotationYaw = this.npc.renderYawOffset = (float)this.npc.aiData.orientation;
            this.npc.rotationYawHead = this.npc.renderYawOffset;
        }
    }
}

