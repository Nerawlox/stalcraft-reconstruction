/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.entity;

import gloomyfolken.mods.anticheat.pidb;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.hanr;
import net.minecraft.util.jxtc;
import net.minecraft.util.sajh;

public class EntityClientPlayerMP
extends EntityPlayerSP {
    public bscn field_71174_a;
    public double field_71179_j;
    public double field_71177_cg;
    public double field_71178_ch;
    public double field_71175_ci;
    public float field_71176_cj;
    public float field_71172_ck;
    public boolean field_71173_cl;
    public boolean field_71170_cm;
    public boolean field_71171_cn;
    public int field_71168_co;
    public boolean field_71169_cp;
    public String field_142022_ce;

    public EntityClientPlayerMP(xpzm xpzm2, ozlu ozlu2, hanr hanr2, bscn bscn2) {
        super(xpzm2, ozlu2, hanr2, 0);
        this.field_71174_a = bscn2;
    }

    @Override
    public boolean func_70097_a(jxtc jxtc2, float f) {
        return false;
    }

    @Override
    public void func_70691_i(float f) {
    }

    @Override
    public void func_70071_h_() {
        if (!this.field_70170_p.func_72899_e(sajh._c(this.field_70165_t), 0, sajh._c(this.field_70161_v))) {
            return;
        }
        super.func_70071_h_();
        if (this.func_70115_ae()) {
            this.field_71174_a._b(new ixmg(this.field_70177_z, this.field_70125_A, this.field_70122_E));
            this.field_71174_a._b(new lpvs(this.field_70702_br, this.field_70701_bs, this.field_71158_b._c, this.field_71158_b._d));
        } else {
            this.func_71166_b();
        }
    }

    public void func_71166_b() {
        gloomyfolken.mods.weapon.xpzm._a(this);
        pidb._a(this);
    }

    @Override
    public EntityItem func_71040_bB(boolean bl) {
        int n = bl ? 3 : 4;
        this.field_71174_a._b(new sdkq(n, 0, 0, 0, 0));
        return null;
    }

    @Override
    public void func_71012_a(EntityItem entityItem) {
    }

    public void func_71165_d(String string) {
        this.field_71174_a._b(new cwaz(string));
    }

    @Override
    public void func_71038_i() {
        super.func_71038_i();
        this.field_71174_a._b(new jjrh(this, 1));
    }

    @Override
    public void func_71004_bE() {
        this.field_71174_a._b(new hdkw(1));
    }

    @Override
    public void func_70665_d(jxtc jxtc2, float f) {
        if (this.func_85032_ar()) {
            return;
        }
        this.func_70606_j(this.func_110143_aJ() - f);
    }

    @Override
    public void func_71053_j() {
        this.field_71174_a._b(new txlx(this.field_71070_bA.field_75152_c));
        this.func_92015_f();
    }

    public void func_92015_f() {
        this.field_71071_by._d(null);
        super.func_71053_j();
    }

    @Override
    public void func_71150_b(float f) {
        if (this.field_71169_cp) {
            super.func_71150_b(f);
        } else {
            this.func_70606_j(f);
            this.field_71169_cp = true;
        }
    }

    @Override
    public void func_71064_a(rann rann2, int n) {
        if (rann2 == null) {
            return;
        }
        if (rann2.field_75972_f) {
            super.func_71064_a(rann2, n);
        }
    }

    public void func_71167_b(rann rann2, int n) {
        if (rann2 == null) {
            return;
        }
        if (!rann2.field_75972_f) {
            super.func_71064_a(rann2, n);
        }
    }

    @Override
    public void func_71016_p() {
        this.field_71174_a._b(new ragy(this.field_71075_bZ));
    }

    @Override
    public void func_110318_g() {
        this.field_71174_a._b(new diaa(this, 6, (int)(this.func_110319_bJ() * 100.0f)));
    }

    public void func_110322_i() {
        this.field_71174_a._b(new diaa(this, 7));
    }

    public void func_142020_c(String string) {
        this.field_142022_ce = string;
    }

    public String func_142021_k() {
        return this.field_142022_ce;
    }
}

