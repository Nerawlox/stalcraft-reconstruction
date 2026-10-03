/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;

public abstract class scgt
extends twgu {
    public final boolean _b;
    public int _c = 9;

    public static final boolean _a(ozlu ozlu2, int n, int n2, int n3) {
        return scgt._a(ozlu2.func_72798_a(n, n2, n3));
    }

    public static final boolean _a(int n) {
        return twgu.field_71973_m[n] instanceof scgt;
    }

    public scgt(int n, boolean bl) {
        super(n, tflj._q);
        this._b = bl;
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        this.func_71849_a(tgbl.field_78029_e);
    }

    public boolean _a() {
        return this._b;
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public hank func_71878_a(ozlu ozlu2, int n, int n2, int n3, ofbx ofbx2, ofbx ofbx3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        return super.func_71878_a(ozlu2, n, n2, n3, ofbx2, ofbx3);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        if (n4 >= 2 && n4 <= 5) {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.625f, 1.0f);
        } else {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        }
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public int func_71857_b() {
        return this._c;
    }

    @Override
    public int func_71925_a(Random random) {
        return 1;
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.func_72797_t(n, n2 - 1, n3);
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        if (!ozlu2.field_72995_K) {
            this._a(ozlu2, n, n2, n3, true);
            if (this._b) {
                this.func_71863_a(ozlu2, n, n2, n3, this.field_71990_ca);
            }
        }
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (!ozlu2.field_72995_K) {
            int n5;
            int n6 = n5 = ozlu2.func_72805_g(n, n2, n3);
            if (this._b) {
                n6 = n5 & 7;
            }
            boolean bl = false;
            if (!ozlu2.func_72797_t(n, n2 - 1, n3)) {
                bl = true;
            }
            if (n6 == 2 && !ozlu2.func_72797_t(n + 1, n2, n3)) {
                bl = true;
            }
            if (n6 == 3 && !ozlu2.func_72797_t(n - 1, n2, n3)) {
                bl = true;
            }
            if (n6 == 4 && !ozlu2.func_72797_t(n, n2, n3 - 1)) {
                bl = true;
            }
            if (n6 == 5 && !ozlu2.func_72797_t(n, n2, n3 + 1)) {
                bl = true;
            }
            if (bl) {
                this.func_71897_c(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0);
                ozlu2.func_94571_i(n, n2, n3);
            } else {
                this._a(ozlu2, n, n2, n3, n5, n6, n4);
            }
        }
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, boolean bl) {
        if (!ozlu2.field_72995_K) {
            new hcdc(this, ozlu2, n, n2, n3)._a(ozlu2.func_72864_z(n, n2, n3), bl);
        }
    }

    @Override
    public int func_71915_e() {
        return 0;
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        int n6 = n5;
        if (this._b) {
            n6 = n5 & 7;
        }
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
        if (n6 == 2 || n6 == 3 || n6 == 4 || n6 == 5) {
            ozlu2.func_72898_h(n, n2 + 1, n3, n4);
        }
        if (this._b) {
            ozlu2.func_72898_h(n, n2, n3, n4);
            ozlu2.func_72898_h(n, n2 - 1, n3, n4);
        }
    }

    public boolean _b(ozlu ozlu2, int n, int n2, int n3) {
        return !this._b;
    }

    public boolean _c(ozlu ozlu2, int n, int n2, int n3) {
        return true;
    }

    public int _a(sdrg sdrg2, EntityMinecart entityMinecart, int n, int n2, int n3) {
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        if (this._b) {
            n4 &= 7;
        }
        return n4;
    }

    public float _a(ozlu ozlu2, EntityMinecart entityMinecart, int n, int n2, int n3) {
        return 0.4f;
    }

    public void _b(ozlu ozlu2, EntityMinecart entityMinecart, int n, int n2, int n3) {
    }

    public void _b(int n) {
        this._c = n;
    }
}

