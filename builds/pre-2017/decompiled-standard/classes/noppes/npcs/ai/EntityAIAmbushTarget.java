/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import java.util.Random;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class EntityAIAmbushTarget
extends zwat {
    private EntityCreature theEntity;
    private EntityLivingBase targetEntity;
    private double shelterX;
    private double shelterY;
    private double shelterZ;
    private double movementSpeed;
    private double distance;
    private int delay = 0;
    private ozlu theWorld;
    private int tick;
    private boolean attackFromBehind;

    public EntityAIAmbushTarget(EntityCreature entityCreature, double d, double d2, boolean bl) {
        this.theEntity = entityCreature;
        this.movementSpeed = d;
        this.theWorld = entityCreature.field_70170_p;
        this.distance = d2 * d2;
        this.attackFromBehind = bl;
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        this.targetEntity = this.theEntity.func_70638_az();
        if (this.targetEntity == null) {
            return false;
        }
        if (this.delay > 0) {
            --this.delay;
            return false;
        }
        if (this.targetEntity.func_70068_e(this.theEntity) > this.distance && this.targetEntity.func_70685_l(this.theEntity)) {
            ofbx ofbx2 = this.findHidingSpot();
            if (ofbx2 == null) {
                return false;
            }
            this.shelterX = ofbx2._c;
            this.shelterY = ofbx2._d;
            this.shelterZ = ofbx2._e;
            return true;
        }
        return false;
    }

    @Override
    public boolean func_75253_b() {
        if (this.targetEntity.func_70089_S()) {
            boolean bl;
            if (this.attackFromBehind) {
                this.theEntity.func_70661_as()._g();
            } else {
                bl = true;
            }
            bl = this.attackFromBehind ? this.isLookingAway() && !this.targetEntity.func_70685_l(this.theEntity) : false;
            return this.targetEntity.func_70068_e(this.theEntity) > this.distance && (!this.theEntity.func_70661_as()._g() || !this.targetEntity.func_70685_l(this.theEntity));
        }
        return false;
    }

    @Override
    public void func_75249_e() {
        this.theEntity.func_70661_as()._a(this.shelterX, this.shelterY, this.shelterZ, this.movementSpeed);
    }

    @Override
    public void func_75251_c() {
        this.theEntity.func_70661_as()._h();
        if (this.theEntity.func_70638_az() == null && this.targetEntity != null) {
            this.theEntity.func_70624_b(this.targetEntity);
        }
    }

    private ofbx findHidingSpot() {
        Random random = this.theEntity.func_70681_au();
        ofbx ofbx2 = null;
        for (int i = 1; i <= 8; ++i) {
            for (int j = -2; j <= 2; ++j) {
                for (int k = -i; k <= i; ++k) {
                    for (int i2 = -i; i2 <= i; ++i2) {
                        ofbx ofbx3;
                        ofbx ofbx4;
                        hank hank2;
                        double d;
                        double d2;
                        double d3 = (double)sajh._c(this.theEntity.field_70165_t + (double)k) + 0.5;
                        if (this.theWorld.func_72799_c((int)d3, (int)(d2 = (double)sajh._c(this.theEntity.field_70121_D._c + (double)j) + 0.5), (int)(d = (double)sajh._c(this.theEntity.field_70161_v + (double)i2) + 0.5)) || !this.theWorld.func_72799_c((int)d3, (int)d2 + 1, (int)d) || (hank2 = this.theWorld.func_72933_a(ofbx4 = this.theWorld.func_82732_R()._a(this.targetEntity.field_70165_t, this.targetEntity.field_70163_u + (double)this.targetEntity.func_70047_e(), this.targetEntity.field_70161_v), ofbx3 = this.theWorld.func_82732_R()._a(d3, d2 + (double)this.theEntity.func_70047_e(), d))) == null || this.shelterX == d3 || this.shelterY == d2 || this.shelterZ == d) continue;
                        ofbx2 = this.theWorld.func_82732_R()._a(d3, d2, d);
                    }
                }
            }
            if (ofbx2 == null) continue;
            return ofbx2;
        }
        this.delay = 60;
        return null;
    }

    private boolean isLookingAway() {
        ofbx ofbx2 = this.targetEntity.func_70676_i(1.0f)._a();
        ofbx ofbx3 = this.theWorld.func_82732_R()._a(this.theEntity.field_70165_t - this.targetEntity.field_70165_t, this.theEntity.field_70121_D._c + (double)(this.theEntity.field_70131_O / 2.0f) - (this.targetEntity.field_70163_u + (double)this.targetEntity.func_70047_e()), this.theEntity.field_70161_v - this.targetEntity.field_70161_v);
        double d = ofbx3._b();
        double d2 = ofbx2._b(ofbx3 = ofbx3._a());
        return d2 < 0.6;
    }
}

