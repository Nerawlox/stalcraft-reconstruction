/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;
import net.minecraft.util.ugqx;

public class woni
extends gqau {
    @SideOnly(value=Side.CLIENT)
    public dwan[] _a;

    public woni(int n) {
        super(n, tflj._k);
        this.func_71907_b(true);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        return this._a[2];
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        int n4;
        int n5;
        if (!this.func_71854_d(ozlu2, n, n2, n3)) {
            this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
            ozlu2.func_72832_d(n, n2, n3, 0, 0, 2);
        } else if (ozlu2.field_73012_v.nextInt(5) == 0 && (n5 = woni._b(n4 = ozlu2.func_72805_g(n, n2, n3))) < 2) {
            ozlu2.func_72921_c(n, n2, n3, ++n5 << 2 | woni._d(n4), 2);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public dwan _a(int n) {
        if (n < 0 || n >= this._a.length) {
            n = this._a.length - 1;
        }
        return this._a[n];
    }

    @Override
    public boolean func_71854_d(ozlu ozlu2, int n, int n2, int n3) {
        int n4;
        int n5;
        return (n5 = ozlu2.func_72798_a(n += ugqx._a[n4 = woni._d(ozlu2.func_72805_g(n, n2, n3))], n2, n3 += ugqx._b[n4])) == twgu.field_71951_J.field_71990_ca && zxyw._c(ozlu2.func_72805_g(n, n2, n3)) == 3;
    }

    @Override
    public int func_71857_b() {
        return 28;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        return super.func_71872_e(ozlu2, n, n2, n3);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public eidj func_71911_a_(ozlu ozlu2, int n, int n2, int n3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        return super.func_71911_a_(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        int n5 = woni._d(n4);
        int n6 = woni._b(n4);
        int n7 = 4 + n6 * 2;
        int n8 = 5 + n6 * 2;
        float f = (float)n7 / 2.0f;
        switch (n5) {
            case 0: {
                this.func_71905_a((8.0f - f) / 16.0f, (12.0f - (float)n8) / 16.0f, (15.0f - (float)n7) / 16.0f, (8.0f + f) / 16.0f, 0.75f, 0.9375f);
                break;
            }
            case 1: {
                this.func_71905_a(0.0625f, (12.0f - (float)n8) / 16.0f, (8.0f - f) / 16.0f, (1.0f + (float)n7) / 16.0f, 0.75f, (8.0f + f) / 16.0f);
                break;
            }
            case 2: {
                this.func_71905_a((8.0f - f) / 16.0f, (12.0f - (float)n8) / 16.0f, 0.0625f, (8.0f + f) / 16.0f, 0.75f, (1.0f + (float)n7) / 16.0f);
                break;
            }
            case 3: {
                this.func_71905_a((15.0f - (float)n7) / 16.0f, (12.0f - (float)n8) / 16.0f, (8.0f - f) / 16.0f, 0.9375f, 0.75f, (8.0f + f) / 16.0f);
            }
        }
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = ((sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 3) + 0) % 4;
        ozlu2.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        if (n4 == 1 || n4 == 0) {
            n4 = 2;
        }
        return ugqx._f[ugqx._e[n4]];
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!this.func_71854_d(ozlu2, n, n2, n3)) {
            this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
            ozlu2.func_72832_d(n, n2, n3, 0, 0, 2);
        }
    }

    public static int _b(int n) {
        return (n & 0xC) >> 2;
    }

    @Override
    public void func_71914_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, int n5) {
        super.func_71914_a(ozlu2, n, n2, n3, n4, f, 0);
    }

    @Override
    public ArrayList<cvzo> getBlockDropped(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        ArrayList<cvzo> arrayList = super.getBlockDropped(ozlu2, n, n2, n3, n4, n5);
        int n6 = woni._b(n4);
        int n7 = 1;
        if (n6 >= 2) {
            n7 = 3;
        }
        for (int i = 0; i < n7; ++i) {
            arrayList.add(new cvzo(tgdv.field_77756_aW, 1, 3));
        }
        return arrayList;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return tgdv.field_77756_aW.field_77779_bT;
    }

    @Override
    public int func_71873_h(ozlu ozlu2, int n, int n2, int n3) {
        return 3;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this._a = new dwan[3];
        for (int i = 0; i < this._a.length; ++i) {
            this._a[i] = nege2._b(this.func_111023_E() + "_stage_" + i);
        }
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return 0;
    }
}

