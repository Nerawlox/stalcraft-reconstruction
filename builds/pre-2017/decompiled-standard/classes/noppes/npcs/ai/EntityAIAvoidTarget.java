/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ofbx;
import noppes.npcs.EntityNPCInterface;

public class EntityAIAvoidTarget
extends zwat {
    private EntityNPCInterface theEntity;
    private Entity closestLivingEntity;
    private float distanceFromEntity;
    private suqn entityPathEntity;
    private ujuz entityPathNavigate;
    private Class targetEntityClass;

    public EntityAIAvoidTarget(EntityNPCInterface entityNPCInterface) {
        this.theEntity = entityNPCInterface;
        this.distanceFromEntity = this.theEntity.stats.aggroRange;
        this.entityPathNavigate = entityNPCInterface.func_70661_as();
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        Object object;
        EntityLivingBase entityLivingBase = this.theEntity.func_70638_az();
        if (entityLivingBase == null) {
            return false;
        }
        this.targetEntityClass = entityLivingBase.getClass();
        if (this.targetEntityClass == EntityPlayer.class) {
            this.closestLivingEntity = this.theEntity.field_70170_p.func_72890_a(this.theEntity, this.distanceFromEntity);
            if (this.closestLivingEntity == null) {
                return false;
            }
        } else {
            object = this.theEntity.field_70170_p.func_72872_a(this.targetEntityClass, this.theEntity.field_70121_D._b(this.distanceFromEntity, 3.0, this.distanceFromEntity));
            if (object.isEmpty()) {
                return false;
            }
            this.closestLivingEntity = (Entity)object.get(0);
        }
        if (!this.theEntity.func_70635_at()._a(this.closestLivingEntity)) {
            return false;
        }
        object = ofaz._b(this.theEntity, 16, 7, this.theEntity.field_70170_p.func_82732_R()._a(this.closestLivingEntity.field_70165_t, this.closestLivingEntity.field_70163_u, this.closestLivingEntity.field_70161_v));
        if (object == null) {
            return false;
        }
        if (this.closestLivingEntity.func_70092_e(((ofbx)object)._c, ((ofbx)object)._d, ((ofbx)object)._e) < this.closestLivingEntity.func_70068_e(this.theEntity)) {
            return false;
        }
        this.entityPathEntity = this.entityPathNavigate._a(((ofbx)object)._c, ((ofbx)object)._d, ((ofbx)object)._e);
        return this.entityPathEntity == null ? false : this.entityPathEntity._a((ofbx)object);
    }

    @Override
    public boolean func_75253_b() {
        return !this.entityPathNavigate._g();
    }

    @Override
    public void func_75249_e() {
        this.entityPathNavigate._a(this.entityPathEntity, 1.0);
    }

    @Override
    public void func_75251_c() {
        this.closestLivingEntity = null;
        this.theEntity.func_70624_b(null);
    }

    @Override
    public void func_75246_d() {
        if (this.theEntity.func_70068_e(this.closestLivingEntity) < 49.0) {
            this.theEntity.func_70661_as()._a(1.2);
        } else {
            this.theEntity.func_70661_as()._a(1.0);
        }
    }
}

