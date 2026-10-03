/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.sajh;
import noppes.npcs.EntityNPCInterface;

public class EntityAIOrbitTarget
extends zwat {
    private EntityNPCInterface theEntity;
    private EntityLivingBase targetEntity;
    private double movePosX;
    private double movePosY;
    private double movePosZ;
    private double speed;
    private float distance;
    private int delay = 0;
    private float angle = 0.0f;
    private int direction = 1;
    private float targetDistance;
    private boolean decay;
    private boolean canNavigate = true;
    private float decayRate = 1.0f;
    private int tick = 0;

    public EntityAIOrbitTarget(EntityNPCInterface entityNPCInterface, double d, float f, boolean bl) {
        this.theEntity = entityNPCInterface;
        this.speed = d;
        this.distance = f;
        this.decay = bl;
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        if (--this.delay > 0) {
            return false;
        }
        this.targetEntity = this.theEntity.func_70638_az();
        if (this.targetEntity == null) {
            return false;
        }
        double d = this.theEntity.func_70032_d(this.targetEntity);
        return d >= (double)(this.distance / 2.0f) && (this.theEntity.inventory.getFirearm() != null || d <= (double)this.distance);
    }

    @Override
    public boolean func_75253_b() {
        double d = this.targetEntity.func_70032_d(this.theEntity);
        return this.targetEntity.func_70089_S() && d >= (double)(this.distance / 2.0f) && d <= (double)(this.distance * 1.5f) && !this.theEntity.func_70090_H() && this.canNavigate;
    }

    @Override
    public void func_75251_c() {
        this.theEntity.func_70661_as()._h();
        this.delay = 60;
        if (this.theEntity.inventory.getFirearm() != null) {
            this.theEntity.getRangedTask().navOverride(false);
        }
    }

    @Override
    public void func_75249_e() {
        this.canNavigate = true;
        Random random = this.theEntity.func_70681_au();
        this.direction = random.nextInt(10) > 5 ? 1 : -1;
        this.decayRate = random.nextFloat() + this.distance / 16.0f;
        this.targetDistance = this.theEntity.func_70032_d(this.targetEntity);
        double d = this.theEntity.field_70165_t - this.targetEntity.field_70165_t;
        double d2 = this.theEntity.field_70161_v - this.targetEntity.field_70161_v;
        this.angle = (float)(Math.atan2(d2, d) * 180.0 / Math.PI);
        if (this.theEntity.inventory.getFirearm() != null) {
            this.theEntity.getRangedTask().navOverride(true);
        }
    }

    @Override
    public void func_75246_d() {
        this.theEntity.func_70671_ap()._a(this.targetEntity, 30.0f, 30.0f);
        if (this.theEntity.func_70661_as()._g() && this.tick >= 0 && this.theEntity.field_70122_E && !this.theEntity.func_70090_H()) {
            double d = (double)this.targetDistance * (double)sajh._b(this.angle / 180.0f * (float)Math.PI);
            double d2 = (double)this.targetDistance * (double)sajh._a(this.angle / 180.0f * (float)Math.PI);
            this.movePosX = this.targetEntity.field_70165_t + d;
            this.movePosY = this.targetEntity.field_70121_D._f;
            this.movePosZ = this.targetEntity.field_70161_v + d2;
            this.theEntity.func_70661_as()._a(this.movePosX, this.movePosY, this.movePosZ, this.speed);
            this.angle += 15.0f * (float)this.direction;
            this.tick = sajh._e(this.theEntity.func_70011_f(this.movePosX, this.movePosY, this.movePosZ) / (double)(this.theEntity.getSpeed() / 20.0f));
            if (this.decay) {
                this.targetDistance -= this.decayRate;
            }
        }
        if (this.tick >= 0) {
            --this.tick;
        }
    }
}

