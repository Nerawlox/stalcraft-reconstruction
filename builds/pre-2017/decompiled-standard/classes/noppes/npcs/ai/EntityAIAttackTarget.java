/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.sajh;
import noppes.npcs.EntityNPCInterface;

public class EntityAIAttackTarget
extends zwat {
    ozlu worldObj;
    EntityNPCInterface attacker;
    int attackTick = 0;
    boolean field_75437_f;
    suqn entityPathEntity;
    private int field_75445_i;

    public EntityAIAttackTarget(EntityNPCInterface entityNPCInterface, boolean bl) {
        this.attacker = entityNPCInterface;
        this.worldObj = entityNPCInterface.field_70170_p;
        this.field_75437_f = bl;
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        EntityLivingBase entityLivingBase = this.attacker.func_70638_az();
        if (entityLivingBase == null) {
            return false;
        }
        if (!entityLivingBase.func_70089_S()) {
            return false;
        }
        if (this.attacker.inventory.getFirearm() != null && this.attacker.aiData.useRangeMelee == 0) {
            return false;
        }
        double d = this.attacker.func_70092_e(entityLivingBase.field_70165_t, entityLivingBase.field_70121_D._c, entityLivingBase.field_70161_v);
        double d2 = this.attacker.aiData.distanceToMelee * this.attacker.aiData.distanceToMelee;
        if (this.attacker.aiData.useRangeMelee == 1 && d > d2) {
            return false;
        }
        this.entityPathEntity = this.attacker.func_70661_as()._a(entityLivingBase);
        return this.entityPathEntity != null;
    }

    @Override
    public boolean func_75253_b() {
        EntityLivingBase entityLivingBase = this.attacker.func_70638_az();
        if (entityLivingBase != null && this.attacker.func_70068_e(entityLivingBase) <= this.attacker.func_70068_e(entityLivingBase)) {
            if (this.attacker.aiData.useRangeMelee == 1 && this.attacker.func_70068_e(entityLivingBase) > (double)(this.attacker.aiData.distanceToMelee * this.attacker.aiData.distanceToMelee)) {
                return false;
            }
            if (!entityLivingBase.func_70089_S()) {
                return false;
            }
            if (!this.field_75437_f) {
                return !this.attacker.func_70661_as()._g();
            }
            return this.attacker.func_110176_b(sajh._c(entityLivingBase.field_70165_t), sajh._c(entityLivingBase.field_70163_u), sajh._c(entityLivingBase.field_70161_v));
        }
        return false;
    }

    @Override
    public void func_75249_e() {
        this.attacker.func_70661_as()._a(this.entityPathEntity, 1.0);
        this.field_75445_i = 0;
    }

    @Override
    public void func_75251_c() {
        this.entityPathEntity = null;
        this.attacker.func_70624_b(null);
        this.attacker.func_70661_as()._h();
    }

    @Override
    public void func_75246_d() {
        EntityLivingBase entityLivingBase = this.attacker.func_70638_az();
        if (entityLivingBase == null) {
            return;
        }
        this.attacker.func_70671_ap()._a(entityLivingBase, 30.0f, 30.0f);
        if ((this.field_75437_f || this.attacker.func_70635_at()._a(entityLivingBase)) && --this.field_75445_i <= 0) {
            this.field_75445_i = 4 + this.attacker.func_70681_au().nextInt(7);
            this.attacker.func_70661_as()._a(entityLivingBase, 1.0);
        }
        this.attackTick = Math.max(this.attackTick - 1, 0);
        if (this.attacker.func_70011_f(entityLivingBase.field_70165_t, entityLivingBase.field_70121_D._c, entityLivingBase.field_70161_v) <= (double)this.attacker.stats.attackRange && this.attacker.func_70685_l(entityLivingBase) && this.attackTick <= 0) {
            this.attackTick = this.attacker.stats.attackSpeed;
            this.attacker.func_71038_i();
            this.attacker.func_70652_k(entityLivingBase);
        }
    }
}

