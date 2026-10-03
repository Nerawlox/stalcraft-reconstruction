/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.sajz;

public class EntityGiantZombie
extends EntityMob {
    public EntityGiantZombie(ozlu ozlu2) {
        super(ozlu2);
        this.field_70129_M *= 6.0f;
        this.func_70105_a(this.field_70130_N * 6.0f, this.field_70131_O * 6.0f);
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(100.0);
        this.func_110148_a(sajz._d)._a(0.5);
        this.func_110148_a(sajz._e)._a(50.0);
    }

    @Override
    public float func_70783_a(int n, int n2, int n3) {
        return this.field_70170_p.func_72801_o(n, n2, n3) - 0.5f;
    }
}

