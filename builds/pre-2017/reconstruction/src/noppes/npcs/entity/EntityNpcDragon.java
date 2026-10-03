/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.util.sajh;
import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;

public class EntityNpcDragon
extends EntityNPCInterface {
    public double[][] field_40162_d = new double[64][3];
    public int field_40164_e = -1;
    public float field_40173_aw = 0.0f;
    public float field_40172_ax = 0.0f;
    public int field_40178_aA = 0;
    public boolean isFlying = false;
    private boolean exploded = false;

    public EntityNpcDragon(World world) {
        super(world);
        this.scaleX = 0.4f;
        this.scaleY = 0.4f;
        this.scaleZ = 0.4f;
        this.labelOffset = 1.0f;
        this.display.texture = "customnpcs:textures/entity/dragon/BlackDragon.png";
    }

    @Override
    public double getMountedYOffset() {
        return 1.1;
    }

    public double[] func_40160_a(int n, float f) {
        double d;
        f = 1.0f - f;
        int n2 = this.field_40164_e - n * 1 & 0x3F;
        int n3 = this.field_40164_e - n * 1 - 1 & 0x3F;
        double[] dArray = new double[3];
        double d2 = this.field_40162_d[n2][0];
        for (d = this.field_40162_d[n3][0] - d2; d < -180.0; d += 360.0) {
        }
        while (d >= 180.0) {
            d -= 360.0;
        }
        dArray[0] = d2 + d * (double)f;
        d2 = this.field_40162_d[n2][1];
        d = this.field_40162_d[n3][1] - d2;
        dArray[1] = d2 + d * (double)f;
        dArray[2] = this.field_40162_d[n2][2] + (this.field_40162_d[n3][2] - this.field_40162_d[n2][2]) * (double)f;
        return dArray;
    }

    @Override
    public void onLivingUpdate() {
        this.field_40173_aw = this.field_40172_ax;
        if (this.worldObj.isRemote && this.getHealth() <= 0.0f) {
            if (!this.exploded) {
                this.exploded = true;
                float f = (this.rand.nextFloat() - 0.5f) * 8.0f;
                float f2 = (this.rand.nextFloat() - 0.5f) * 4.0f;
                float f3 = (this.rand.nextFloat() - 0.5f) * 8.0f;
                this.worldObj.spawnParticle("largeexplode", this.posX + (double)f, this.posY + 2.0 + (double)f2, this.posZ + (double)f3, 0.0, 0.0, 0.0);
            }
        } else {
            this.exploded = false;
            float f = 0.2f / (sajh._a(this.motionX * this.motionX + this.motionZ * this.motionZ) * 10.0f + 1.0f);
            f = 0.045f;
            this.field_40172_ax += (f *= (float)Math.pow(2.0, this.motionY)) * 0.5f;
        }
        super.onLivingUpdate();
    }

    @Override
    public void updateHitbox() {
        this.width = 1.8f;
        this.height = 1.4f;
        this.width = this.width / 5.0f * (float)this.display.modelSize;
        this.height = this.height / 5.0f * (float)this.display.modelSize;
    }
}

