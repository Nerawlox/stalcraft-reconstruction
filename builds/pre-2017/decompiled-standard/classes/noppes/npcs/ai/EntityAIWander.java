/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.zwat;
import net.minecraft.util.ofbx;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.ai.RandomPositionGeneratorAlt;

public class EntityAIWander
extends zwat {
    private EntityNPCInterface entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;

    public EntityAIWander(EntityNPCInterface entityNPCInterface) {
        this.entity = entityNPCInterface;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        if (this.entity.func_70654_ax() >= 100) {
            return false;
        }
        if (this.entity.func_70681_au().nextInt(80) != 0) {
            return false;
        }
        ofbx ofbx2 = this.getVec();
        if (ofbx2 == null) {
            return false;
        }
        this.xPosition = ofbx2._c;
        this.yPosition = ofbx2._d;
        this.zPosition = ofbx2._e;
        return true;
    }

    private ofbx getVec() {
        if (this.entity.aiData.walkingRange > 0) {
            double d = this.entity.func_70011_f(this.entity.getStartXPos(), this.entity.getStartYPos(), this.entity.getStartZPos());
            int n = (int)((double)this.entity.aiData.walkingRange - d);
            if (n > CustomNpcs.NpcNavRange) {
                n = CustomNpcs.NpcNavRange;
            }
            if (n < 3) {
                n = this.entity.aiData.walkingRange;
                if (n > CustomNpcs.NpcNavRange) {
                    n = CustomNpcs.NpcNavRange;
                }
                ofbx ofbx2 = this.entity.field_70170_p.func_82732_R()._a(this.entity.getStartXPos(), this.entity.getStartYPos(), this.entity.getStartZPos());
                return RandomPositionGeneratorAlt.findRandomTargetBlockTowards(this.entity, n / 2, 7, ofbx2);
            }
            return RandomPositionGeneratorAlt.findRandomTarget(this.entity, n, 7);
        }
        return RandomPositionGeneratorAlt.findRandomTarget(this.entity, CustomNpcs.NpcNavRange, 7);
    }

    @Override
    public boolean func_75253_b() {
        return !this.entity.func_70661_as()._g();
    }

    @Override
    public void func_75249_e() {
        this.entity.func_70661_as()._a(this.xPosition, this.yPosition, this.zPosition, 0.7);
    }
}

