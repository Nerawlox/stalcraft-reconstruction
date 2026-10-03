/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.ofbx;
import noppes.npcs.EntityNPCInterface;

public class EntityAIDodgeShoot
extends zwat {
    private EntityNPCInterface entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;

    public EntityAIDodgeShoot(EntityNPCInterface entityNPCInterface) {
        this.entity = entityNPCInterface;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        EntityLivingBase entityLivingBase = this.entity.func_70638_az();
        if (entityLivingBase != null && entityLivingBase.func_70089_S()) {
            ofbx ofbx2;
            if (this.entity.inventory.getFirearm() == null) {
                return false;
            }
            if (this.entity.getRangedTask() == null) {
                return false;
            }
            ofbx ofbx3 = ofbx2 = this.entity.getRangedTask().hasFired() ? ofaz._a(this.entity, 4, 1) : null;
            if (ofbx2 == null) {
                return false;
            }
            this.xPosition = ofbx2._c;
            this.yPosition = ofbx2._d;
            this.zPosition = ofbx2._e;
            return true;
        }
        return false;
    }

    @Override
    public boolean func_75253_b() {
        return !this.entity.func_70661_as()._g();
    }

    @Override
    public void func_75249_e() {
        this.entity.func_70661_as()._a(this.xPosition, this.yPosition, this.zPosition, 1.2);
    }

    @Override
    public void func_75246_d() {
        if (this.entity.func_70638_az() != null) {
            this.entity.func_70671_ap()._a(this.entity.func_70638_az(), 30.0f, 30.0f);
        }
    }
}

