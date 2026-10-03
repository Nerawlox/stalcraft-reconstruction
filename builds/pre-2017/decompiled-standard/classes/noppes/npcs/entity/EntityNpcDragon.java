/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.util.sajh;
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

    public EntityNpcDragon(ozlu ozlu2) {
        super(ozlu2);
        this.scaleX = 0.4f;
        this.scaleY = 0.4f;
        this.scaleZ = 0.4f;
        this.labelOffset = 1.0f;
        this.display.texture = "customnpcs:textures/entity/dragon/BlackDragon.png";
    }

    @Override
    public double func_70042_X() {
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
    public void func_70636_d() {
        this.field_40173_aw = this.field_40172_ax;
        if (this.field_70170_p.field_72995_K && this.func_110143_aJ() <= 0.0f) {
            if (!this.exploded) {
                this.exploded = true;
                float f = (this.field_70146_Z.nextFloat() - 0.5f) * 8.0f;
                float f2 = (this.field_70146_Z.nextFloat() - 0.5f) * 4.0f;
                float f3 = (this.field_70146_Z.nextFloat() - 0.5f) * 8.0f;
                this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t + (double)f, this.field_70163_u + 2.0 + (double)f2, this.field_70161_v + (double)f3, 0.0, 0.0, 0.0);
            }
        } else {
            this.exploded = false;
            float f = 0.2f / (sajh._a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y) * 10.0f + 1.0f);
            f = 0.045f;
            this.field_40172_ax += (f *= (float)Math.pow(2.0, this.field_70181_x)) * 0.5f;
        }
        super.func_70636_d();
    }

    @Override
    public void updateHitbox() {
        this.field_70130_N = 1.8f;
        this.field_70131_O = 1.4f;
        this.field_70130_N = this.field_70130_N / 5.0f * (float)this.display.modelSize;
        this.field_70131_O = this.field_70131_O / 5.0f * (float)this.display.modelSize;
    }
}

