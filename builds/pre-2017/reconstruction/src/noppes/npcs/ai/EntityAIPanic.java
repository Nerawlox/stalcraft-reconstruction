/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.util.Vec3;

public class EntityAIPanic
extends EntityAIBase {
    private EntityCreature theEntityCreature;
    private float speed;
    private double randPosX;
    private double randPosY;
    private double randPosZ;

    public EntityAIPanic(EntityCreature entityCreature, float f) {
        this.theEntityCreature = entityCreature;
        this.speed = f;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (this.theEntityCreature.getAttackTarget() == null && !this.theEntityCreature.isBurning()) {
            return false;
        }
        Vec3 vec3 = ofaz._a(this.theEntityCreature, 5, 4);
        if (vec3 == null) {
            return false;
        }
        this.randPosX = vec3._c;
        this.randPosY = vec3._d;
        this.randPosZ = vec3._e;
        return true;
    }

    @Override
    public void startExecuting() {
        this.theEntityCreature.getNavigator()._a(this.randPosX, this.randPosY, this.randPosZ, this.speed);
    }

    @Override
    public boolean continueExecuting() {
        return !this.theEntityCreature.getNavigator()._g();
    }
}

