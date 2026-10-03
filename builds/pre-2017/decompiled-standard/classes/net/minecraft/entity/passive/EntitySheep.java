/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.ezfc;
import net.minecraft.entity.ai.ezhm;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.kjwj;
import net.minecraft.entity.ai.srli;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.ai.xpzm;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.kjui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tupg;
import net.minecraft.util.sajh;
import net.minecraftforge.common.IShearable;

public class EntitySheep
extends EntityAnimal
implements IShearable {
    public final bsse field_90016_e = new bsse(new kjui(this), 2, 1);
    public static final float[][] field_70898_d = new float[][]{{1.0f, 1.0f, 1.0f}, {0.85f, 0.5f, 0.2f}, {0.7f, 0.3f, 0.85f}, {0.4f, 0.6f, 0.85f}, {0.9f, 0.9f, 0.2f}, {0.5f, 0.8f, 0.1f}, {0.95f, 0.5f, 0.65f}, {0.3f, 0.3f, 0.3f}, {0.6f, 0.6f, 0.6f}, {0.3f, 0.5f, 0.6f}, {0.5f, 0.25f, 0.7f}, {0.2f, 0.3f, 0.7f}, {0.4f, 0.3f, 0.2f}, {0.4f, 0.5f, 0.2f}, {0.6f, 0.2f, 0.2f}, {0.1f, 0.1f, 0.1f}};
    public int field_70899_e;
    public xpzm field_70897_f = new xpzm(this);

    public EntitySheep(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.9f, 1.3f);
        this.func_70661_as()._a(true);
        this.field_70714_bg._a(0, new tdpx(this));
        this.field_70714_bg._a(1, new kjwj(this, 1.25));
        this.field_70714_bg._a(2, new srli(this, 1.0));
        this.field_70714_bg._a(3, new ezhm(this, 1.1, tgdv.field_77685_T.field_77779_bT, false));
        this.field_70714_bg._a(4, new ezfc(this, 1.1));
        this.field_70714_bg._a(5, this.field_70897_f);
        this.field_70714_bg._a(6, new iurn(this, 1.0));
        this.field_70714_bg._a(7, new iurq(this, EntityPlayer.class, 6.0f));
        this.field_70714_bg._a(8, new tdmn(this));
        this.field_90016_e.func_70299_a(0, new cvzo(tgdv.field_77756_aW, 1, 0));
        this.field_90016_e.func_70299_a(1, new cvzo(tgdv.field_77756_aW, 1, 0));
    }

    @Override
    public boolean func_70650_aV() {
        return true;
    }

    @Override
    public void func_70619_bc() {
        this.field_70899_e = this.field_70897_f._a();
        super.func_70619_bc();
    }

    @Override
    public void func_70636_d() {
        if (this.field_70170_p.field_72995_K) {
            this.field_70899_e = Math.max(0, this.field_70899_e - 1);
        }
        super.func_70636_d();
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(8.0);
        this.func_110148_a(sajz._d)._a(0.23f);
    }

    @Override
    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af._a(16, new Byte(0));
    }

    @Override
    public void func_70628_a(boolean bl, int n) {
        if (!this.func_70892_o()) {
            this.func_70099_a(new cvzo(twgu.field_72101_ab.field_71990_ca, 1, this.func_70896_n()), 0.0f);
        }
    }

    @Override
    public int func_70633_aT() {
        return twgu.field_72101_ab.field_71990_ca;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70103_a(byte by) {
        if (by == 10) {
            this.field_70899_e = 40;
        } else {
            super.func_70103_a(by);
        }
    }

    @Override
    public boolean func_70085_c(EntityPlayer entityPlayer) {
        return super.func_70085_c(entityPlayer);
    }

    @SideOnly(value=Side.CLIENT)
    public float func_70894_j(float f) {
        return this.field_70899_e <= 0 ? 0.0f : (this.field_70899_e >= 4 && this.field_70899_e <= 36 ? 1.0f : (this.field_70899_e < 4 ? ((float)this.field_70899_e - f) / 4.0f : -((float)(this.field_70899_e - 40) - f) / 4.0f));
    }

    @SideOnly(value=Side.CLIENT)
    public float func_70890_k(float f) {
        if (this.field_70899_e > 4 && this.field_70899_e <= 36) {
            float f2 = ((float)(this.field_70899_e - 4) - f) / 32.0f;
            return 0.62831855f + 0.2199115f * sajh._a(f2 * 28.7f);
        }
        return this.field_70899_e > 0 ? 0.62831855f : this.field_70125_A / 57.295776f;
    }

    @Override
    public void func_70014_b(qoac qoac2) {
        super.func_70014_b(qoac2);
        qoac2._a("Sheared", this.func_70892_o());
        qoac2._a("Color", (byte)this.func_70896_n());
    }

    @Override
    public void func_70037_a(qoac qoac2) {
        super.func_70037_a(qoac2);
        this.func_70893_e(qoac2._o("Sheared"));
        this.func_70891_b(qoac2._d("Color"));
    }

    @Override
    public String func_70639_aQ() {
        return "mob.sheep.say";
    }

    @Override
    public String func_70621_aR() {
        return "mob.sheep.say";
    }

    @Override
    public String func_70673_aS() {
        return "mob.sheep.say";
    }

    @Override
    public void func_70036_a(int n, int n2, int n3, int n4) {
        this.func_85030_a("mob.sheep.step", 0.15f, 1.0f);
    }

    public int func_70896_n() {
        return this.field_70180_af._a(16) & 0xF;
    }

    public void func_70891_b(int n) {
        byte by = this.field_70180_af._a(16);
        this.field_70180_af._b(16, (byte)(by & 0xF0 | n & 0xF));
    }

    public boolean func_70892_o() {
        return (this.field_70180_af._a(16) & 0x10) != 0;
    }

    public void func_70893_e(boolean bl) {
        byte by = this.field_70180_af._a(16);
        if (bl) {
            this.field_70180_af._b(16, (byte)(by | 0x10));
        } else {
            this.field_70180_af._b(16, (byte)(by & 0xFFFFFFEF));
        }
    }

    public static int func_70895_a(Random random) {
        int n = random.nextInt(100);
        return n < 5 ? 15 : (n < 10 ? 7 : (n < 15 ? 8 : (n < 18 ? 12 : (random.nextInt(500) == 0 ? 6 : 0))));
    }

    public EntitySheep func_90015_b(EntityAgeable entityAgeable) {
        EntitySheep entitySheep = (EntitySheep)entityAgeable;
        EntitySheep entitySheep2 = new EntitySheep(this.field_70170_p);
        int n = this.func_90014_a(this, entitySheep);
        entitySheep2.func_70891_b(15 - n);
        return entitySheep2;
    }

    @Override
    public void func_70615_aA() {
        this.func_70893_e(false);
        if (this.func_70631_g_()) {
            this.func_110195_a(60);
        }
    }

    @Override
    public tupg func_110161_a(tupg tupg2) {
        tupg2 = super.func_110161_a(tupg2);
        this.func_70891_b(EntitySheep.func_70895_a(this.field_70170_p.field_73012_v));
        return tupg2;
    }

    public int func_90014_a(EntityAnimal entityAnimal, EntityAnimal entityAnimal2) {
        int n = this.func_90013_b(entityAnimal);
        int n2 = this.func_90013_b(entityAnimal2);
        this.field_90016_e.func_70301_a(0)._b(n);
        this.field_90016_e.func_70301_a(1)._b(n2);
        cvzo cvzo2 = igjl._a()._a(this.field_90016_e, ((EntitySheep)entityAnimal).field_70170_p);
        int n3 = cvzo2 != null && cvzo2._a().field_77779_bT == tgdv.field_77756_aW.field_77779_bT ? cvzo2._j() : (this.field_70170_p.field_73012_v.nextBoolean() ? n : n2);
        return n3;
    }

    public int func_90013_b(EntityAnimal entityAnimal) {
        return 15 - ((EntitySheep)entityAnimal).func_70896_n();
    }

    @Override
    public EntityAgeable func_90011_a(EntityAgeable entityAgeable) {
        return this.func_90015_b(entityAgeable);
    }

    @Override
    public boolean isShearable(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3) {
        return !this.func_70892_o() && !this.func_70631_g_();
    }

    @Override
    public ArrayList<cvzo> onSheared(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3, int n4) {
        ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
        this.func_70893_e(true);
        int n5 = 1 + this.field_70146_Z.nextInt(3);
        for (int i = 0; i < n5; ++i) {
            arrayList.add(new cvzo(twgu.field_72101_ab.field_71990_ca, 1, this.func_70896_n()));
        }
        this.field_70170_p.func_72956_a(this, "mob.sheep.shear", 1.0f, 1.0f);
        return arrayList;
    }
}

