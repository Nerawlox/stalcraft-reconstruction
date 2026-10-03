/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public abstract class EntityImmovableLiving
extends EntityLiving {
    public EntityImmovableLiving(World world) {
        super(world);
    }

    @Override
    protected void updatePotionEffects() {
    }

    @Override
    protected void collideWithNearbyEntities() {
    }

    @Override
    public boolean handleLavaMovement() {
        return false;
    }

    @Override
    public boolean handleWaterMovement() {
        return false;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    protected boolean isMovementBlocked() {
        return true;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public boolean isEntityInvulnerable() {
        return true;
    }

    @Override
    protected void addRandomArmor() {
    }

    @Override
    protected boolean isAIEnabled() {
        return false;
    }

    public void fallDown() {
        super.moveEntityWithHeading(0.0f, 0.0f);
    }

    @Override
    public void moveEntityWithHeading(float f, float f2) {
    }
}

