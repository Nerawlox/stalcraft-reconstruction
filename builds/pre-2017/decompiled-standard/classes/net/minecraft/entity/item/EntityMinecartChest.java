/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.item.EntityMinecartContainer;
import net.minecraft.util.jxtc;

public class EntityMinecartChest
extends EntityMinecartContainer {
    public EntityMinecartChest(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityMinecartChest(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2, d, d2, d3);
    }

    @Override
    public void func_94095_a(jxtc jxtc2) {
        super.func_94095_a(jxtc2);
        this.func_70054_a(twgu.field_72077_au.field_71990_ca, 1, 0.0f);
    }

    @Override
    public int func_70302_i_() {
        return 27;
    }

    @Override
    public int func_94087_l() {
        return 1;
    }

    @Override
    public twgu func_94093_n() {
        return twgu.field_72077_au;
    }

    @Override
    public int func_94085_r() {
        return 8;
    }
}

