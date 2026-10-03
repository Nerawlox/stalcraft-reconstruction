/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.zwat;
import noppes.npcs.EntityNPCInterface;

public class EntityAISprintToTarget
extends zwat {
    EntityNPCInterface runner;
    EntityLivingBase runTarget;

    public EntityAISprintToTarget(EntityNPCInterface entityNPCInterface) {
        this.runner = entityNPCInterface;
        this.func_75248_a(8);
    }

    @Override
    public boolean func_75250_a() {
        this.runTarget = this.runner.func_70638_az();
        if (this.runTarget == null) {
            return false;
        }
        if (this.runner.func_70661_as()._g()) {
            return false;
        }
        switch (this.runner.aiData.onAttack) {
            case 0: {
                return this.runner.func_70068_e(this.runTarget) >= 64.0 && this.runner.field_70122_E;
            }
            case 2: {
                return this.runner.func_70068_e(this.runTarget) <= 49.0 && this.runner.field_70122_E;
            }
        }
        return false;
    }

    @Override
    public boolean func_75253_b() {
        return this.runner.func_70089_S() && this.runner.field_70122_E && this.runner.field_70737_aN <= 0 && this.runner.field_70159_w != 0.0 && this.runner.field_70179_y != 0.0;
    }

    @Override
    public void func_75249_e() {
        this.runner.func_70031_b(true);
    }

    @Override
    public void func_75251_c() {
        this.runner.func_70031_b(false);
    }
}

