/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.ai.piev;
import net.minecraft.entity.item.EntityMinecart;

public class EntityMinecartMobSpawner
extends EntityMinecart {
    public final qokq field_98040_a = new piev(this);

    public EntityMinecartMobSpawner(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityMinecartMobSpawner(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2, d, d2, d3);
    }

    @Override
    public int func_94087_l() {
        return 4;
    }

    @Override
    public twgu func_94093_n() {
        return twgu.field_72065_as;
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.field_98040_a._a(qoac2);
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        this.field_98040_a._b(qoac2);
    }

    @Override
    public void func_70103_a(byte by) {
        this.field_98040_a._b(by);
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_98040_a._g();
    }

    public qokq func_98039_d() {
        return this.field_98040_a;
    }
}

