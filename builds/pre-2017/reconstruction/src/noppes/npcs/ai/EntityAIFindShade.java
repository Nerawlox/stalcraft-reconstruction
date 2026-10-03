/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import java.util.Random;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityAIFindShade
extends EntityAIBase {
    private EntityCreature theCreature;
    private double shelterX;
    private double shelterY;
    private double shelterZ;
    private World theWorld;

    public EntityAIFindShade(EntityCreature entityCreature) {
        this.theCreature = entityCreature;
        this.theWorld = entityCreature.worldObj;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (!this.theWorld.isDaytime()) {
            return false;
        }
        if (!this.theWorld.canBlockSeeTheSky(sajh._c(this.theCreature.posX), (int)this.theCreature.boundingBox._c, sajh._c(this.theCreature.posZ))) {
            return false;
        }
        Vec3 vec3 = this.findPossibleShelter();
        if (vec3 == null) {
            return false;
        }
        this.shelterX = vec3._c;
        this.shelterY = vec3._d;
        this.shelterZ = vec3._e;
        return true;
    }

    @Override
    public boolean continueExecuting() {
        return !this.theCreature.getNavigator()._g();
    }

    @Override
    public void startExecuting() {
        this.theCreature.getNavigator()._a(this.shelterX, this.shelterY, this.shelterZ, 1.0);
    }

    private Vec3 findPossibleShelter() {
        Random random = this.theCreature.getRNG();
        for (int i = 0; i < 10; ++i) {
            int n;
            int n2;
            int n3 = sajh._c(this.theCreature.posX + (double)random.nextInt(20) - 10.0);
            if (this.theWorld.canBlockSeeTheSky(n3, n2 = sajh._c(this.theCreature.boundingBox._c + (double)random.nextInt(6) - 3.0), n = sajh._c(this.theCreature.posZ + (double)random.nextInt(20) - 10.0)) || !(this.theCreature.getBlockPathWeight(n3, n2, n) < 0.0f)) continue;
            return this.theWorld.getWorldVec3Pool()._a(n3, n2, n);
        }
        return null;
    }
}

