/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.zwat;
import noppes.npcs.EntityNPCInterface;

public class EntityAIWaterNav
extends zwat {
    private EntityNPCInterface theEntity;

    public EntityAIWaterNav(EntityNPCInterface entityNPCInterface) {
        this.theEntity = entityNPCInterface;
        this.func_75248_a(4);
        entityNPCInterface.func_70661_as()._e(true);
    }

    @Override
    public boolean func_75250_a() {
        if (this.theEntity.func_70090_H() || this.theEntity.func_70058_J()) {
            if (this.theEntity.aiData.canSwim) {
                return true;
            }
            if (this.theEntity.field_70123_F) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void func_75246_d() {
        if (this.theEntity.func_70681_au().nextFloat() < 0.8f) {
            this.theEntity.func_70683_ar()._a();
        }
    }
}

