/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class EntityAIZigZagTarget
extends zwat {
    private EntityCreature theEntity;
    private EntityLivingBase targetEntity;
    private double movePosX;
    private double movePosY;
    private double movePosZ;
    private int entityPosX;
    private int entityPosY;
    private int entityPosZ;
    private double field_75425_f;
    private float field_75426_g;

    public EntityAIZigZagTarget(EntityCreature entityCreature, double d, float f) {
        this.theEntity = entityCreature;
        this.field_75425_f = d;
        this.field_75426_g = f;
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        this.targetEntity = this.theEntity.func_70638_az();
        if (this.targetEntity == null) {
            return false;
        }
        if (this.targetEntity.func_70068_e(this.theEntity) < (double)(this.field_75426_g * this.field_75426_g)) {
            return false;
        }
        suqn suqn2 = this.theEntity.func_70661_as()._a(this.targetEntity);
        if (suqn2 != null && (float)suqn2._g() >= this.field_75426_g) {
            elhc elhc2 = suqn2._c(sajh._c((double)this.field_75426_g / 2.0));
            this.entityPosX = elhc2._a;
            this.entityPosY = elhc2._b;
            this.entityPosZ = elhc2._c;
            ofbx ofbx2 = ofaz._a(this.theEntity, (int)this.field_75426_g, 3, this.theEntity.field_70170_p.func_82732_R()._a(this.entityPosX, this.entityPosY, this.entityPosZ));
            if (ofbx2 != null && this.targetEntity.func_70092_e(ofbx2._c, ofbx2._d, ofbx2._e) < this.targetEntity.func_70092_e(this.entityPosX, this.entityPosY, this.entityPosZ)) {
                this.movePosX = ofbx2._c;
                this.movePosY = ofbx2._d;
                this.movePosZ = ofbx2._e;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean func_75253_b() {
        return !this.theEntity.func_70661_as()._g() && this.targetEntity.func_70089_S() && this.targetEntity.func_70068_e(this.theEntity) > (double)(this.field_75426_g * this.field_75426_g) && this.theEntity.func_70635_at()._a(this.targetEntity);
    }

    @Override
    public void func_75251_c() {
        this.targetEntity = null;
    }

    @Override
    public void func_75249_e() {
        this.theEntity.func_70661_as()._a(this.movePosX, this.movePosY, this.movePosZ, this.field_75425_f);
    }

    @Override
    public void func_75246_d() {
        this.theEntity.func_70671_ap()._a(this.targetEntity, 30.0f, 30.0f);
    }
}

