/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import java.util.List;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecartContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.jxtc;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.minecart.MinecartInteractEvent;

public class EntityMinecartHopper
extends EntityMinecartContainer
implements sdpc {
    public boolean field_96113_a = true;
    public int field_98044_b = -1;

    public EntityMinecartHopper(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityMinecartHopper(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2, d, d2, d3);
    }

    @Override
    public int func_94087_l() {
        return 5;
    }

    @Override
    public twgu func_94093_n() {
        return twgu.field_94340_cs;
    }

    @Override
    public int func_94085_r() {
        return 1;
    }

    @Override
    public int func_70302_i_() {
        return 5;
    }

    @Override
    public boolean func_130002_c(EntityPlayer entityPlayer) {
        if (MinecraftForge.EVENT_BUS.post(new MinecartInteractEvent(this, entityPlayer))) {
            return true;
        }
        if (!this.field_70170_p.field_72995_K) {
            entityPlayer.func_96125_a(this);
        }
        return true;
    }

    @Override
    public void func_96095_a(int n, int n2, int n3, boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = !bl;
        if (bl2 != this.func_96111_ay()) {
            this.func_96110_f(bl2);
        }
    }

    public boolean func_96111_ay() {
        return this.field_96113_a;
    }

    public void func_96110_f(boolean bl) {
        this.field_96113_a = bl;
    }

    @Override
    public ozlu func_70314_l() {
        return this.field_70170_p;
    }

    @Override
    public double func_96107_aA() {
        return this.field_70165_t;
    }

    @Override
    public double func_96109_aB() {
        return this.field_70163_u;
    }

    @Override
    public double func_96108_aC() {
        return this.field_70161_v;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K && this.func_70089_S() && this.func_96111_ay()) {
            --this.field_98044_b;
            if (!this.func_98043_aE()) {
                this.func_98042_n(0);
                if (this.func_96112_aD()) {
                    this.func_98042_n(4);
                    this.func_70296_d();
                }
            }
        }
    }

    public boolean func_96112_aD() {
        if (cffd._a(this)) {
            return true;
        }
        List list2 = this.field_70170_p.func_82733_a(EntityItem.class, this.field_70121_D._b(0.25, 0.0, 0.25), zhos._a);
        if (list2.size() > 0) {
            cffd._a(this, (EntityItem)list2.get(0));
        }
        return false;
    }

    @Override
    public void func_94095_a(jxtc jxtc2) {
        super.func_94095_a(jxtc2);
        this.func_70054_a(twgu.field_94340_cs.field_71990_ca, 1, 0.0f);
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("TransferCooldown", this.field_98044_b);
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.field_98044_b = qoac2._f("TransferCooldown");
    }

    public void func_98042_n(int n) {
        this.field_98044_b = n;
    }

    public boolean func_98043_aE() {
        return this.field_98044_b > 0;
    }
}

