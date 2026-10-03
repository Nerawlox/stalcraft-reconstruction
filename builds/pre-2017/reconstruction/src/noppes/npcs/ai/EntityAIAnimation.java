/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.EntityAIBase;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumAnimation;
import noppes.npcs.constants.EnumMovingType;

public class EntityAIAnimation
extends EntityAIBase {
    private EntityNPCInterface npc;
    private boolean isAttacking = false;
    private boolean isDead = false;
    private boolean isAtStartpoint = false;
    private boolean hasPath = false;

    public EntityAIAnimation(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
    }

    @Override
    public boolean shouldExecute() {
        boolean bl;
        this.isDead = this.npc.isKilled();
        if (this.isDead) {
            return this.npc.currentAnimation != EnumAnimation.LYING;
        }
        if (this.npc.aiData.animationType == EnumAnimation.NONE) {
            return this.npc.currentAnimation != EnumAnimation.NONE;
        }
        this.isAttacking = this.npc.isAttacking();
        this.isAtStartpoint = this.npc.isVeryNearAssignedPlace();
        this.hasPath = !this.npc.getNavigator()._g();
        boolean bl2 = bl = this.npc.currentAnimation == this.npc.aiData.animationType;
        return this.npc.aiData.movingType == EnumMovingType.Standing && this.hasNavigation() ? bl : !bl;
    }

    @Override
    public void startExecuting() {
        EnumAnimation enumAnimation = this.npc.aiData.animationType;
        if (!this.isDead && !this.npc.isSleeping()) {
            if (this.npc.aiData.movingType == EnumMovingType.Standing && this.hasNavigation() && (this.npc.aiData.animationType == EnumAnimation.SITTING || this.npc.aiData.animationType == EnumAnimation.LYING)) {
                enumAnimation = EnumAnimation.NONE;
            }
        } else {
            enumAnimation = EnumAnimation.LYING;
        }
        this.setAnimation(enumAnimation);
    }

    private void setAnimation(EnumAnimation enumAnimation) {
        this.npc.currentAnimation = enumAnimation;
        this.npc.getDataWatcher()._b(14, enumAnimation.ordinal());
        this.npc.updateHitbox();
        this.npc.setPosition(this.npc.posX, this.npc.posY, this.npc.posZ);
    }

    private boolean hasNavigation() {
        return this.isAttacking || !this.isAtStartpoint || this.hasPath;
    }
}

