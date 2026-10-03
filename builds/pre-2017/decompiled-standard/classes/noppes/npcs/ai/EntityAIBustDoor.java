/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.ugqx;

public class EntityAIBustDoor
extends ugqx {
    private int breakingTime;
    private int field_75358_j = -1;

    public EntityAIBustDoor(EntityLiving entityLiving) {
        super(entityLiving);
    }

    @Override
    public boolean func_75250_a() {
        return !super.func_75250_a() ? false : (!this.field_75356_a.field_70170_p.func_82736_K()._b("mobGriefing") ? false : !this.field_75353_e._b(this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d));
    }

    @Override
    public void func_75249_e() {
        super.func_75249_e();
        this.breakingTime = 0;
    }

    @Override
    public boolean func_75253_b() {
        double d = this.field_75356_a.func_70092_e(this.field_75354_b, this.field_75355_c, this.field_75352_d);
        return this.breakingTime <= 240 && !this.field_75353_e._b(this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d) && d < 4.0;
    }

    @Override
    public void func_75251_c() {
        super.func_75251_c();
        this.field_75356_a.field_70170_p.func_72888_f(this.field_75356_a.field_70157_k, this.field_75354_b, this.field_75355_c, this.field_75352_d, -1);
    }

    @Override
    public void func_75246_d() {
        super.func_75246_d();
        if (this.field_75356_a.func_70681_au().nextInt(20) == 0) {
            this.field_75356_a.field_70170_p.func_72926_e(1010, this.field_75354_b, this.field_75355_c, this.field_75352_d, 0);
            this.field_75356_a.func_71038_i();
        }
        ++this.breakingTime;
        int n = (int)((float)this.breakingTime / 240.0f * 10.0f);
        if (n != this.field_75358_j) {
            this.field_75356_a.field_70170_p.func_72888_f(this.field_75356_a.field_70157_k, this.field_75354_b, this.field_75355_c, this.field_75352_d, n);
            this.field_75358_j = n;
        }
        if (this.breakingTime == 240) {
            this.field_75356_a.field_70170_p.func_94571_i(this.field_75354_b, this.field_75355_c, this.field_75352_d);
            this.field_75356_a.field_70170_p.func_72926_e(1012, this.field_75354_b, this.field_75355_c, this.field_75352_d, 0);
            this.field_75356_a.field_70170_p.func_72926_e(2001, this.field_75354_b, this.field_75355_c, this.field_75352_d, this.field_75353_e.field_71990_ca);
        }
    }
}

