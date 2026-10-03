/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import noppes.npcs.EntityNPCInterface;

public class EntityAIStalkTarget
extends zwat {
    private EntityNPCInterface theEntity;
    private EntityLivingBase targetEntity;
    private ofbx movePosition;
    private double distance;
    private boolean overRide;
    private ozlu theWorld;
    private int delay;
    private int tick = 0;

    public EntityAIStalkTarget(EntityNPCInterface entityNPCInterface, double d) {
        this.theEntity = entityNPCInterface;
        this.theWorld = entityNPCInterface.field_70170_p;
        this.distance = d * d;
        this.overRide = false;
        this.delay = 0;
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        this.targetEntity = this.theEntity.func_70638_az();
        if (this.targetEntity == null) {
            return false;
        }
        if (this.tick > 0) {
            --this.tick;
            return false;
        }
        return this.targetEntity.func_70068_e(this.theEntity) > this.distance;
    }

    @Override
    public void func_75251_c() {
        this.theEntity.func_70661_as()._h();
        if (this.theEntity.func_70638_az() == null && this.targetEntity != null) {
            this.theEntity.func_70624_b(this.targetEntity);
        }
        if (this.theEntity.inventory.getFirearm() != null) {
            this.theEntity.getRangedTask().navOverride(false);
        }
    }

    @Override
    public void func_75249_e() {
        if (this.theEntity.inventory.getFirearm() != null) {
            this.theEntity.getRangedTask().navOverride(true);
        }
    }

    @Override
    public void func_75246_d() {
        this.theEntity.func_70671_ap()._a(this.targetEntity, 30.0f, 30.0f);
        if (this.theEntity.func_70661_as()._g() || this.overRide) {
            if (this.isLookingAway()) {
                this.movePosition = this.stalkTarget();
                if (this.movePosition != null) {
                    this.theEntity.func_70661_as()._a(this.movePosition._c, this.movePosition._d, this.movePosition._e, 1.0);
                    this.overRide = false;
                } else {
                    this.tick = 100;
                }
            } else if (this.targetEntity.func_70685_l(this.theEntity)) {
                this.movePosition = this.hideFromTarget();
                if (this.movePosition != null) {
                    this.theEntity.func_70661_as()._a(this.movePosition._c, this.movePosition._d, this.movePosition._e, 1.33);
                    this.overRide = false;
                } else {
                    this.tick = 100;
                }
            }
        }
        if (this.delay > 0) {
            --this.delay;
        }
        if (!this.isLookingAway() && this.targetEntity.func_70685_l(this.theEntity) && this.delay == 0) {
            this.overRide = true;
            this.delay = 60;
        }
    }

    private ofbx hideFromTarget() {
        for (int i = 1; i <= 8; ++i) {
            ofbx ofbx2 = this.findSecludedXYZ(i, false);
            if (ofbx2 == null) continue;
            return ofbx2;
        }
        return null;
    }

    private ofbx stalkTarget() {
        for (int i = 8; i >= 1; --i) {
            ofbx ofbx2 = this.findSecludedXYZ(i, true);
            if (ofbx2 == null) continue;
            return ofbx2;
        }
        return null;
    }

    private ofbx findSecludedXYZ(int n, boolean bl) {
        ofbx ofbx2 = null;
        double d = this.targetEntity.func_70068_e(this.theEntity);
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        if (this.movePosition != null) {
            d2 = this.movePosition._c;
            d3 = this.movePosition._d;
            d4 = this.movePosition._e;
        }
        for (int i = -2; i <= 2; ++i) {
            for (int j = -n; j <= n; ++j) {
                for (int k = -n; k <= n; ++k) {
                    boolean bl2;
                    ofbx ofbx3;
                    ofbx ofbx4;
                    hank hank2;
                    double d5;
                    double d6;
                    double d7 = (double)sajh._c(this.theEntity.field_70165_t + (double)j) + 0.5;
                    if (this.theWorld.func_72799_c((int)d7, (int)(d6 = (double)sajh._c(this.theEntity.field_70121_D._c + (double)i) + 0.5), (int)(d5 = (double)sajh._c(this.theEntity.field_70161_v + (double)k) + 0.5)) || !this.theWorld.func_72799_c((int)d7, (int)d6 + 1, (int)d5) || !this.theWorld.func_72799_c((int)d7, (int)d6 + 2, (int)d5) || (hank2 = this.theWorld.func_72933_a(ofbx4 = this.theWorld.func_82732_R()._a(this.targetEntity.field_70165_t, this.targetEntity.field_70163_u + (double)this.targetEntity.func_70047_e(), this.targetEntity.field_70161_v), ofbx3 = this.theWorld.func_82732_R()._a(d7, d6 + (double)this.theEntity.func_70047_e(), d5))) == null) continue;
                    boolean bl3 = bl ? this.targetEntity.func_70092_e(d7, d6, d5) <= d : (bl2 = true);
                    if (!bl2 || d7 == d2 && d6 == d3 && d5 == d4) continue;
                    ofbx2 = this.theWorld.func_82732_R()._a(d7, d6, d5);
                    if (!bl) continue;
                    d = this.targetEntity.func_70092_e(d7, d6, d5);
                }
            }
        }
        return ofbx2;
    }

    private boolean isLookingAway() {
        ofbx ofbx2 = this.targetEntity.func_70676_i(1.0f)._a();
        ofbx ofbx3 = this.theWorld.func_82732_R()._a(this.theEntity.field_70165_t - this.targetEntity.field_70165_t, this.theEntity.field_70121_D._c + (double)(this.theEntity.field_70131_O / 2.0f) - (this.targetEntity.field_70163_u + (double)this.targetEntity.func_70047_e()), this.theEntity.field_70161_v - this.targetEntity.field_70161_v);
        double d = ofbx3._b();
        double d2 = ofbx2._b(ofbx3 = ofbx3._a());
        return d2 < 0.6;
    }
}

