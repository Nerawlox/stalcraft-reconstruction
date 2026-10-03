/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.terraingen.BiomeEvent;

public abstract class lqhx
extends zztd {
    public int _a = -1;
    public int _b;
    public boolean _c;
    public fovt _d;

    public lqhx() {
    }

    public lqhx(fovt fovt2, int n) {
        super(n);
        if (fovt2 != null) {
            this._c = fovt2._f;
            this._d = fovt2;
        }
    }

    @Override
    public void _a(qoac qoac2) {
        qoac2._a("HPos", this._a);
        qoac2._a("VCount", this._b);
        qoac2._a("Desert", this._c);
    }

    @Override
    public void _b(qoac qoac2) {
        this._a = qoac2._f("HPos");
        this._b = qoac2._f("VCount");
        this._c = qoac2._o("Desert");
    }

    public zztd _a(fovt fovt2, List list2, Random random, int n, int n2) {
        switch (this._n) {
            case 0: {
                return tybp._d(fovt2, list2, random, this._m._a - 1, this._m._b + n, this._m._c + n2, 1, this._e());
            }
            case 1: {
                return tybp._d(fovt2, list2, random, this._m._a + n2, this._m._b + n, this._m._c - 1, 2, this._e());
            }
            case 2: {
                return tybp._d(fovt2, list2, random, this._m._a - 1, this._m._b + n, this._m._c + n2, 1, this._e());
            }
            case 3: {
                return tybp._d(fovt2, list2, random, this._m._a + n2, this._m._b + n, this._m._c - 1, 2, this._e());
            }
        }
        return null;
    }

    public zztd _b(fovt fovt2, List list2, Random random, int n, int n2) {
        switch (this._n) {
            case 0: {
                return tybp._d(fovt2, list2, random, this._m._d + 1, this._m._b + n, this._m._c + n2, 3, this._e());
            }
            case 1: {
                return tybp._d(fovt2, list2, random, this._m._a + n2, this._m._b + n, this._m._f + 1, 0, this._e());
            }
            case 2: {
                return tybp._d(fovt2, list2, random, this._m._d + 1, this._m._b + n, this._m._c + n2, 3, this._e());
            }
            case 3: {
                return tybp._d(fovt2, list2, random, this._m._a + n2, this._m._b + n, this._m._f + 1, 0, this._e());
            }
        }
        return null;
    }

    public int _a(ozlu ozlu2, uken uken2) {
        int n = 0;
        int n2 = 0;
        for (int i = this._m._c; i <= this._m._f; ++i) {
            for (int j = this._m._a; j <= this._m._d; ++j) {
                if (!uken2._b(j, 64, i)) continue;
                n += Math.max(ozlu2.func_72825_h(j, i), ozlu2.field_73011_w._i());
                ++n2;
            }
        }
        if (n2 == 0) {
            return -1;
        }
        return n / n2;
    }

    public static boolean _a(uken uken2) {
        return uken2 != null && uken2._b > 10;
    }

    public void _a(ozlu ozlu2, uken uken2, int n, int n2, int n3, int n4) {
        if (this._b < n4) {
            int n5;
            int n6;
            int n7;
            for (int i = this._b; i < n4 && uken2._b(n7 = this._c(n + i, n3), n6 = this._b(n2), n5 = this._d(n + i, n3)); ++i) {
                ++this._b;
                EntityVillager entityVillager = new EntityVillager(ozlu2, this._a(i));
                entityVillager.func_70012_b((double)n7 + 0.5, n6, (double)n5 + 0.5, 0.0f, 0.0f);
                ozlu2.func_72838_d(entityVillager);
            }
        }
    }

    public int _a(int n) {
        return 0;
    }

    public int _a(int n, int n2) {
        BiomeEvent.GetVillageBlockID getVillageBlockID = new BiomeEvent.GetVillageBlockID(this._d == null ? null : this._d._g, n, n2);
        MinecraftForge.TERRAIN_GEN_BUS.post(getVillageBlockID);
        if (getVillageBlockID.getResult() == Event.Result.DENY) {
            return getVillageBlockID.replacement;
        }
        if (this._c) {
            if (n == twgu.field_71951_J.field_71990_ca) {
                return twgu.field_71957_Q.field_71990_ca;
            }
            if (n == twgu.field_71978_w.field_71990_ca) {
                return twgu.field_71957_Q.field_71990_ca;
            }
            if (n == twgu.field_71988_x.field_71990_ca) {
                return twgu.field_71957_Q.field_71990_ca;
            }
            if (n == twgu.field_72063_at.field_71990_ca) {
                return twgu.field_72088_bQ.field_71990_ca;
            }
            if (n == twgu.field_72057_aH.field_71990_ca) {
                return twgu.field_72088_bQ.field_71990_ca;
            }
            if (n == twgu.field_71940_F.field_71990_ca) {
                return twgu.field_71957_Q.field_71990_ca;
            }
        }
        return n;
    }

    public int _b(int n, int n2) {
        BiomeEvent.GetVillageBlockMeta getVillageBlockMeta = new BiomeEvent.GetVillageBlockMeta(this._d == null ? null : this._d._g, n, n2);
        MinecraftForge.TERRAIN_GEN_BUS.post(getVillageBlockMeta);
        if (getVillageBlockMeta.getResult() == Event.Result.DENY) {
            return getVillageBlockMeta.replacement;
        }
        if (this._c) {
            if (n == twgu.field_71951_J.field_71990_ca) {
                return 0;
            }
            if (n == twgu.field_71978_w.field_71990_ca) {
                return 0;
            }
            if (n == twgu.field_71988_x.field_71990_ca) {
                return 2;
            }
        }
        return n2;
    }

    @Override
    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5, uken uken2) {
        int n6 = this._a(n, n2);
        int n7 = this._b(n, n2);
        super._a(ozlu2, n6, n7, n3, n4, n5, uken2);
    }

    @Override
    public void _a(ozlu ozlu2, uken uken2, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl) {
        int n9 = this._a(n7, 0);
        int n10 = this._b(n7, 0);
        int n11 = this._a(n8, 0);
        int n12 = this._b(n8, 0);
        super._a(ozlu2, uken2, n, n2, n3, n4, n5, n6, n9, n10, n11, n12, bl);
    }

    @Override
    public void _b(ozlu ozlu2, int n, int n2, int n3, int n4, int n5, uken uken2) {
        int n6 = this._a(n, n2);
        int n7 = this._b(n, n2);
        super._b(ozlu2, n6, n7, n3, n4, n5, uken2);
    }
}

