/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class qoqn {
    public ozlu field_76815_a;
    public Random field_76813_b;
    public int field_76814_c;
    public int field_76811_d;
    public foqh field_76812_e;
    public zzpm field_76809_f = new xcez(4);
    public zzpm field_76810_g;
    public zzpm field_76822_h;
    public zzpm field_76823_i;
    public zzpm field_76820_j;
    public zzpm field_76821_k;
    public zzpm field_76818_l;
    public zzpm field_76819_m;
    public zzpm field_76816_n;
    public zzpm field_76817_o;
    public zzpm field_76831_p;
    public zzpm field_76830_q;
    public zzpm field_76829_r;
    public zzpm field_76828_s;
    public zzpm field_76827_t;
    public zzpm field_76826_u;
    public zzpm field_76825_v;
    public zzpm field_76824_w;
    public zzpm field_76834_x;
    public int field_76833_y;
    public int field_76832_z;
    public int field_76802_A;
    public int field_76803_B;
    public int field_76804_C;
    public int field_76798_D;
    public int field_76799_E;
    public int field_76800_F;
    public int field_76801_G;
    public int field_76805_H;
    public int field_76806_I;
    public int field_76807_J;
    public boolean field_76808_K;

    public qoqn(foqh foqh2) {
        this.field_76810_g = new gatb(7, twgu.field_71939_E.field_71990_ca);
        this.field_76822_h = new gatb(6, twgu.field_71940_F.field_71990_ca);
        this.field_76823_i = new qoqx(twgu.field_71979_v.field_71990_ca, 32);
        this.field_76820_j = new qoqx(twgu.field_71940_F.field_71990_ca, 32);
        this.field_76821_k = new qoqx(twgu.field_71950_I.field_71990_ca, 16);
        this.field_76818_l = new qoqx(twgu.field_71949_H.field_71990_ca, 8);
        this.field_76819_m = new qoqx(twgu.field_71941_G.field_71990_ca, 8);
        this.field_76816_n = new qoqx(twgu.field_72047_aN.field_71990_ca, 7);
        this.field_76817_o = new qoqx(twgu.field_72073_aw.field_71990_ca, 7);
        this.field_76831_p = new qoqx(twgu.field_71947_N.field_71990_ca, 6);
        this.field_76830_q = new xces(twgu.field_72097_ad.field_71990_ca);
        this.field_76829_r = new xces(twgu.field_72107_ae.field_71990_ca);
        this.field_76828_s = new xces(twgu.field_72109_af.field_71990_ca);
        this.field_76827_t = new xces(twgu.field_72103_ag.field_71990_ca);
        this.field_76826_u = new foso();
        this.field_76825_v = new wqci();
        this.field_76824_w = new cfka();
        this.field_76834_x = new cwnd();
        this.field_76802_A = 2;
        this.field_76803_B = 1;
        this.field_76801_G = 1;
        this.field_76805_H = 3;
        this.field_76806_I = 1;
        this.field_76808_K = true;
        this.field_76812_e = foqh2;
    }

    public void func_76796_a(ozlu ozlu2, Random random, int n, int n2) {
        if (this.field_76815_a != null) {
            throw new RuntimeException("Already decorating!!");
        }
        this.field_76815_a = ozlu2;
        this.field_76813_b = random;
        this.field_76814_c = n;
        this.field_76811_d = n2;
        this.func_76794_a();
        this.field_76815_a = null;
        this.field_76813_b = null;
    }

    public void func_76794_a() {
        int n;
        int n2;
        int n3;
        int n4;
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d));
        this.func_76797_b();
        boolean bl = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.SAND);
        for (n4 = 0; bl && n4 < this.field_76805_H; ++n4) {
            n3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n2 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76810_g._a(this.field_76815_a, this.field_76813_b, n3, this.field_76815_a.func_72825_h(n3, n2), n2);
        }
        bl = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.CLAY);
        for (n4 = 0; bl && n4 < this.field_76806_I; ++n4) {
            n3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n2 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76809_f._a(this.field_76815_a, this.field_76813_b, n3, this.field_76815_a.func_72825_h(n3, n2), n2);
        }
        bl = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.SAND_PASS2);
        for (n4 = 0; bl && n4 < this.field_76801_G; ++n4) {
            n3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n2 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76810_g._a(this.field_76815_a, this.field_76813_b, n3, this.field_76815_a.func_72825_h(n3, n2), n2);
        }
        n4 = this.field_76832_z;
        if (this.field_76813_b.nextInt(10) == 0) {
            ++n4;
        }
        bl = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.TREE);
        for (n3 = 0; bl && n3 < n4; ++n3) {
            n2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            zzpm zzpm2 = this.field_76812_e._a(this.field_76813_b);
            zzpm2._a(1.0, 1.0, 1.0);
            zzpm2._a(this.field_76815_a, this.field_76813_b, n2, this.field_76815_a.func_72976_f(n2, n), n);
        }
        bl = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM);
        for (n3 = 0; bl && n3 < this.field_76807_J; ++n3) {
            n2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76826_u._a(this.field_76815_a, this.field_76813_b, n2, this.field_76815_a.func_72976_f(n2, n), n);
        }
        bl = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.FLOWERS);
        for (n3 = 0; bl && n3 < this.field_76802_A; ++n3) {
            n2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n = this.field_76813_b.nextInt(128);
            int n5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76830_q._a(this.field_76815_a, this.field_76813_b, n2, n, n5);
            if (this.field_76813_b.nextInt(4) != 0) continue;
            n2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n = this.field_76813_b.nextInt(128);
            n5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76829_r._a(this.field_76815_a, this.field_76813_b, n2, n, n5);
        }
        bl = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.GRASS);
        for (n3 = 0; bl && n3 < this.field_76803_B; ++n3) {
            n2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n = this.field_76813_b.nextInt(128);
            int n6 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            zzpm zzpm3 = this.field_76812_e._b(this.field_76813_b);
            zzpm3._a(this.field_76815_a, this.field_76813_b, n2, n, n6);
        }
        bl = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.DEAD_BUSH);
        for (n3 = 0; bl && n3 < this.field_76804_C; ++n3) {
            n2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n = this.field_76813_b.nextInt(128);
            int n7 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            new grvt(twgu.field_71961_Y.field_71990_ca)._a(this.field_76815_a, this.field_76813_b, n2, n, n7);
        }
        bl = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.LILYPAD);
        for (n3 = 0; bl && n3 < this.field_76833_y; ++n3) {
            int n8;
            n2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            for (n8 = this.field_76813_b.nextInt(128); n8 > 0 && this.field_76815_a.func_72798_a(n2, n8 - 1, n) == 0; --n8) {
            }
            this.field_76834_x._a(this.field_76815_a, this.field_76813_b, n2, n8, n);
        }
        bl = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.SHROOM);
        for (n3 = 0; bl && n3 < this.field_76798_D; ++n3) {
            int n9;
            if (this.field_76813_b.nextInt(4) == 0) {
                n2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
                n = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
                n9 = this.field_76815_a.func_72976_f(n2, n);
                this.field_76828_s._a(this.field_76815_a, this.field_76813_b, n2, n9, n);
            }
            if (this.field_76813_b.nextInt(8) != 0) continue;
            n2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            n9 = this.field_76813_b.nextInt(128);
            this.field_76827_t._a(this.field_76815_a, this.field_76813_b, n2, n9, n);
        }
        if (bl && this.field_76813_b.nextInt(4) == 0) {
            n3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n2 = this.field_76813_b.nextInt(128);
            n = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76828_s._a(this.field_76815_a, this.field_76813_b, n3, n2, n);
        }
        if (bl && this.field_76813_b.nextInt(8) == 0) {
            n3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n2 = this.field_76813_b.nextInt(128);
            n = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76827_t._a(this.field_76815_a, this.field_76813_b, n3, n2, n);
        }
        bl = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.REED);
        for (n3 = 0; bl && n3 < this.field_76799_E; ++n3) {
            n2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            int n10 = this.field_76813_b.nextInt(128);
            this.field_76825_v._a(this.field_76815_a, this.field_76813_b, n2, n10, n);
        }
        for (n3 = 0; bl && n3 < 10; ++n3) {
            n2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n = this.field_76813_b.nextInt(128);
            int n11 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76825_v._a(this.field_76815_a, this.field_76813_b, n2, n, n11);
        }
        bl = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.PUMPKIN);
        if (bl && this.field_76813_b.nextInt(32) == 0) {
            n3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n2 = this.field_76813_b.nextInt(128);
            n = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            new knaa()._a(this.field_76815_a, this.field_76813_b, n3, n2, n);
        }
        bl = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.CACTUS);
        for (n3 = 0; bl && n3 < this.field_76800_F; ++n3) {
            n2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            n = this.field_76813_b.nextInt(128);
            int n12 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76824_w._a(this.field_76815_a, this.field_76813_b, n2, n, n12);
        }
        bl = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.LAKE);
        if (bl && this.field_76808_K) {
            for (n3 = 0; n3 < 50; ++n3) {
                n2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
                n = this.field_76813_b.nextInt(this.field_76813_b.nextInt(120) + 8);
                int n13 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
                new xtgb(twgu.field_71942_A.field_71990_ca)._a(this.field_76815_a, this.field_76813_b, n2, n, n13);
            }
            for (n3 = 0; n3 < 20; ++n3) {
                n2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
                n = this.field_76813_b.nextInt(this.field_76813_b.nextInt(this.field_76813_b.nextInt(112) + 8) + 8);
                int n14 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
                new xtgb(twgu.field_71944_C.field_71990_ca)._a(this.field_76815_a, this.field_76813_b, n2, n, n14);
            }
        }
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d));
    }

    public void func_76795_a(int n, zzpm zzpm2, int n2, int n3) {
        for (int i = 0; i < n; ++i) {
            int n4 = this.field_76814_c + this.field_76813_b.nextInt(16);
            int n5 = this.field_76813_b.nextInt(n3 - n2) + n2;
            int n6 = this.field_76811_d + this.field_76813_b.nextInt(16);
            zzpm2._a(this.field_76815_a, this.field_76813_b, n4, n5, n6);
        }
    }

    public void func_76793_b(int n, zzpm zzpm2, int n2, int n3) {
        for (int i = 0; i < n; ++i) {
            int n4 = this.field_76814_c + this.field_76813_b.nextInt(16);
            int n5 = this.field_76813_b.nextInt(n3) + this.field_76813_b.nextInt(n3) + (n2 - n3);
            int n6 = this.field_76811_d + this.field_76813_b.nextInt(16);
            zzpm2._a(this.field_76815_a, this.field_76813_b, n4, n5, n6);
        }
    }

    public void func_76797_b() {
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d));
        if (TerrainGen.generateOre(this.field_76815_a, this.field_76813_b, this.field_76823_i, this.field_76814_c, this.field_76811_d, OreGenEvent.GenerateMinable.EventType.DIRT)) {
            this.func_76795_a(20, this.field_76823_i, 0, 128);
        }
        if (TerrainGen.generateOre(this.field_76815_a, this.field_76813_b, this.field_76820_j, this.field_76814_c, this.field_76811_d, OreGenEvent.GenerateMinable.EventType.GRAVEL)) {
            this.func_76795_a(10, this.field_76820_j, 0, 128);
        }
        if (TerrainGen.generateOre(this.field_76815_a, this.field_76813_b, this.field_76821_k, this.field_76814_c, this.field_76811_d, OreGenEvent.GenerateMinable.EventType.COAL)) {
            this.func_76795_a(20, this.field_76821_k, 0, 128);
        }
        if (TerrainGen.generateOre(this.field_76815_a, this.field_76813_b, this.field_76818_l, this.field_76814_c, this.field_76811_d, OreGenEvent.GenerateMinable.EventType.IRON)) {
            this.func_76795_a(20, this.field_76818_l, 0, 64);
        }
        if (TerrainGen.generateOre(this.field_76815_a, this.field_76813_b, this.field_76819_m, this.field_76814_c, this.field_76811_d, OreGenEvent.GenerateMinable.EventType.GOLD)) {
            this.func_76795_a(2, this.field_76819_m, 0, 32);
        }
        if (TerrainGen.generateOre(this.field_76815_a, this.field_76813_b, this.field_76816_n, this.field_76814_c, this.field_76811_d, OreGenEvent.GenerateMinable.EventType.REDSTONE)) {
            this.func_76795_a(8, this.field_76816_n, 0, 16);
        }
        if (TerrainGen.generateOre(this.field_76815_a, this.field_76813_b, this.field_76817_o, this.field_76814_c, this.field_76811_d, OreGenEvent.GenerateMinable.EventType.DIAMOND)) {
            this.func_76795_a(1, this.field_76817_o, 0, 16);
        }
        if (TerrainGen.generateOre(this.field_76815_a, this.field_76813_b, this.field_76831_p, this.field_76814_c, this.field_76811_d, OreGenEvent.GenerateMinable.EventType.LAPIS)) {
            this.func_76793_b(1, this.field_76831_p, 16, 16);
        }
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d));
    }
}

