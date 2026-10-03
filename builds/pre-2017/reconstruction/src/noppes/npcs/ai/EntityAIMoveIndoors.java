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

public class EntityAIMoveIndoors
extends EntityAIBase {
    private EntityCreature theCreature;
    private double shelterX;
    private double shelterY;
    private double shelterZ;
    private World theWorld;

    public EntityAIMoveIndoors(EntityCreature entityCreature) {
        this.theCreature = entityCreature;
        this.theWorld = entityCreature.worldObj;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        int n = sajh._c(this.theCreature.posX);
        int n2 = (int)this.theCreature.boundingBox._c;
        int n3 = sajh._c(this.theCreature.posZ);
        if (!(this.theCreature.worldObj.isDaytime() && !this.theCreature.worldObj.isRaining() || this.theCreature.worldObj.provider._g)) {
            if (!this.theWorld.canBlockSeeTheSky(n, n2, n3) && this.theWorld.getFullBlockLightValue(n, n2, n3) > 8) {
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
        return false;
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
            if (this.theWorld.canBlockSeeTheSky(n3, n2 = sajh._c(this.theCreature.boundingBox._c + (double)random.nextInt(6) - 3.0), n = sajh._c(this.theCreature.posZ + (double)random.nextInt(20) - 10.0)) || this.theWorld.getFullBlockLightValue(n3, n2, n) <= 8) continue;
            return this.theWorld.getWorldVec3Pool()._a(n3, n2, n);
        }
        return null;
    }
}

