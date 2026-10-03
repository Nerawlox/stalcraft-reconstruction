/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.owak;

public class hcdp
extends twgu {
    public dwan _a;

    public hcdp(int n) {
        super(n, tflj._G);
        this.func_71884_a(field_71976_h);
        this.func_71848_c(0.5f);
    }

    public void _a(dwan dwan2) {
        this._a = dwan2;
    }

    public void _a() {
        this._a = null;
    }

    @Override
    public void func_71846_a(ozlu ozlu2, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        int n5;
        int n6;
        if (entityPlayer.field_71075_bZ._d && ((n6 = ozlu2.func_72798_a(n - owak._b[n5 = hcdp._a(n4)], n2 - owak._c[n5], n3 - owak._d[n5])) == twgu.field_71963_Z.field_71990_ca || n6 == twgu.field_71956_V.field_71990_ca)) {
            ozlu2.func_94571_i(n - owak._b[n5], n2 - owak._c[n5], n3 - owak._d[n5]);
        }
        super.func_71846_a(ozlu2, n, n2, n3, n4, entityPlayer);
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
        int n6 = owak._a[hcdp._a(n5)];
        int n7 = ozlu2.func_72798_a(n += owak._b[n6], n2 += owak._c[n6], n3 += owak._d[n6]);
        if ((n7 == twgu.field_71963_Z.field_71990_ca || n7 == twgu.field_71956_V.field_71990_ca) && cdvp._b(n5 = ozlu2.func_72805_g(n, n2, n3))) {
            twgu.field_71973_m[n7].func_71897_c(ozlu2, n, n2, n3, n5, 0);
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        int n3 = hcdp._a(n2);
        if (n == n3) {
            if (this._a != null) {
                return this._a;
            }
            if ((n2 & 8) != 0) {
                return cdvp._a("piston_top_sticky");
            }
            return cdvp._a("piston_top_normal");
        }
        if (n3 < 6 && n == owak._a[n3]) {
            return cdvp._a("piston_top_normal");
        }
        return cdvp._a("piston_side");
    }

    @Override
    public void func_94332_a(nege nege2) {
    }

    @Override
    public int func_71857_b() {
        return 17;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return false;
    }

    @Override
    public boolean func_71850_a_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return false;
    }

    @Override
    public int func_71925_a(Random random) {
        return 0;
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list2, Entity entity) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        float f = 0.25f;
        float f2 = 0.375f;
        float f3 = 0.625f;
        float f4 = 0.25f;
        float f5 = 0.75f;
        switch (hcdp._a(n4)) {
            case 0: {
                this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.25f, 1.0f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
                this.func_71905_a(0.375f, 0.25f, 0.375f, 0.625f, 1.0f, 0.625f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
                break;
            }
            case 1: {
                this.func_71905_a(0.0f, 0.75f, 0.0f, 1.0f, 1.0f, 1.0f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
                this.func_71905_a(0.375f, 0.0f, 0.375f, 0.625f, 0.75f, 0.625f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
                break;
            }
            case 2: {
                this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.25f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
                this.func_71905_a(0.25f, 0.375f, 0.25f, 0.75f, 0.625f, 1.0f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
                break;
            }
            case 3: {
                this.func_71905_a(0.0f, 0.0f, 0.75f, 1.0f, 1.0f, 1.0f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
                this.func_71905_a(0.25f, 0.375f, 0.0f, 0.75f, 0.625f, 0.75f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
                break;
            }
            case 4: {
                this.func_71905_a(0.0f, 0.0f, 0.0f, 0.25f, 1.0f, 1.0f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
                this.func_71905_a(0.375f, 0.25f, 0.25f, 0.625f, 0.75f, 1.0f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
                break;
            }
            case 5: {
                this.func_71905_a(0.75f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
                this.func_71905_a(0.0f, 0.375f, 0.25f, 0.75f, 0.625f, 0.75f);
                super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
            }
        }
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        float f = 0.25f;
        switch (hcdp._a(n4)) {
            case 0: {
                this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.25f, 1.0f);
                break;
            }
            case 1: {
                this.func_71905_a(0.0f, 0.75f, 0.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case 2: {
                this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.25f);
                break;
            }
            case 3: {
                this.func_71905_a(0.0f, 0.0f, 0.75f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case 4: {
                this.func_71905_a(0.0f, 0.0f, 0.0f, 0.25f, 1.0f, 1.0f);
                break;
            }
            case 5: {
                this.func_71905_a(0.75f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            }
        }
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = hcdp._a(ozlu2.func_72805_g(n, n2, n3));
        int n6 = ozlu2.func_72798_a(n - owak._b[n5], n2 - owak._c[n5], n3 - owak._d[n5]);
        if (n6 != twgu.field_71963_Z.field_71990_ca && n6 != twgu.field_71956_V.field_71990_ca) {
            ozlu2.func_94571_i(n, n2, n3);
        } else {
            twgu.field_71973_m[n6].func_71863_a(ozlu2, n - owak._b[n5], n2 - owak._c[n5], n3 - owak._d[n5], n4);
        }
    }

    public static int _a(int n) {
        return n & 7;
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        if ((n4 & 8) != 0) {
            return twgu.field_71956_V.field_71990_ca;
        }
        return twgu.field_71963_Z.field_71990_ca;
    }
}

