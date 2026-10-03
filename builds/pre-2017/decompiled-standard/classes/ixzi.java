/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.world.ChunkEvent;

public class ixzi {
    public static boolean _a;
    public ujzm[] _b = new ujzm[16];
    public byte[] _c = new byte[256];
    public int[] _d = new int[256];
    public boolean[] _e = new boolean[256];
    public boolean _f;
    public ozlu _g;
    public int[] _h;
    public final int _i;
    public final int _j;
    public boolean _k;
    public Map _l = new HashMap();
    public List[] _m = new List[16];
    public boolean _n;
    public boolean _o;
    public boolean _p;
    public long _q;
    public boolean _r;
    public int _s;
    public long _t;
    public int _u = 4096;

    public ixzi(ozlu ozlu2, int n, int n2) {
        this._g = ozlu2;
        this._i = n;
        this._j = n2;
        this._h = new int[256];
        for (int i = 0; i < this._m.length; ++i) {
            this._m[i] = new ArrayList();
        }
        Arrays.fill(this._d, -999);
        Arrays.fill(this._c, (byte)-1);
    }

    public ixzi(ozlu ozlu2, byte[] byArray, int n, int n2) {
        this(ozlu2, n, n2);
        int n3 = byArray.length / 256;
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < n3; ++k) {
                    int n4 = byArray[i << 11 | j << 7 | k] & 0xFF;
                    if (n4 == 0) continue;
                    int n5 = k >> 4;
                    if (this._b[n5] == null) {
                        this._b[n5] = new ujzm(n5 << 4, !ozlu2.field_73011_w._g);
                    }
                    this._b[n5]._a(i, k & 0xF, j, n4);
                }
            }
        }
    }

    public ixzi(ozlu ozlu2, byte[] byArray, byte[] byArray2, int n, int n2) {
        this(ozlu2, n, n2);
        int n3 = byArray.length / 256;
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < n3; ++k) {
                    int n4 = i << 11 | j << 7 | k;
                    int n5 = byArray[n4] & 0xFF;
                    byte by = byArray2[n4];
                    if (n5 == 0) continue;
                    int n6 = k >> 4;
                    if (this._b[n6] == null) {
                        this._b[n6] = new ujzm(n6 << 4, !ozlu2.field_73011_w._g);
                    }
                    this._b[n6]._a(i, k & 0xF, j, n5);
                    this._b[n6]._b(i, k & 0xF, j, by);
                }
            }
        }
    }

    public ixzi(ozlu ozlu2, short[] sArray, byte[] byArray, int n, int n2) {
        this(ozlu2, n, n2);
        int n3 = sArray.length / 256;
        for (int i = 0; i < n3; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    int n4 = i << 8 | j << 4 | k;
                    int n5 = sArray[n4] & 0xFFFFFF;
                    byte by = byArray[n4];
                    if (n5 == 0) continue;
                    int n6 = i >> 4;
                    if (this._b[n6] == null) {
                        this._b[n6] = new ujzm(n6 << 4, !ozlu2.field_73011_w._g);
                    }
                    this._b[n6]._a(k, i & 0xF, j, n5);
                    this._b[n6]._b(k, i & 0xF, j, by);
                }
            }
        }
    }

    public boolean _a(int n, int n2) {
        return n == this._i && n2 == this._j;
    }

    public int _b(int n, int n2) {
        return this._h[n2 << 4 | n];
    }

    public int _a() {
        for (int i = this._b.length - 1; i >= 0; --i) {
            if (this._b[i] == null) continue;
            return this._b[i]._c();
        }
        return 0;
    }

    public ujzm[] _b() {
        return this._b;
    }

    @SideOnly(value=Side.CLIENT)
    public void _c() {
        int n = this._a();
        for (int i = 0; i < 16; ++i) {
            block1: for (int j = 0; j < 16; ++j) {
                this._d[i + (j << 4)] = -999;
                for (int k = n + 16 - 1; k > 0; --k) {
                    int n2 = this._d(i, k - 1, j);
                    if (this._c(i, k - 1, j) == 0) {
                        continue;
                    }
                    this._h[j << 4 | i] = k;
                    continue block1;
                }
            }
        }
        this._o = true;
    }

    public void _d() {
        int n;
        int n2;
        int n3 = this._a();
        this._s = Integer.MAX_VALUE;
        for (n2 = 0; n2 < 16; ++n2) {
            for (n = 0; n < 16; ++n) {
                int n4;
                this._d[n2 + (n << 4)] = -999;
                for (n4 = n3 + 16 - 1; n4 > 0; --n4) {
                    if (this._c(n2, n4 - 1, n) == 0) {
                        continue;
                    }
                    this._h[n << 4 | n2] = n4;
                    if (n4 >= this._s) break;
                    this._s = n4;
                    break;
                }
                if (this._g.field_73011_w._g) continue;
                n4 = 15;
                int n5 = n3 + 16 - 1;
                do {
                    ujzm ujzm2;
                    if ((n4 -= this._c(n2, n5, n)) <= 0 || (ujzm2 = this._b[n5 >> 4]) == null) continue;
                    ujzm2._c(n2, n5 & 0xF, n, n4);
                    this._g.func_72902_n((this._i << 4) + n2, n5, (this._j << 4) + n);
                } while (--n5 > 0 && n4 > 0);
            }
        }
        this._o = true;
        for (n2 = 0; n2 < 16; ++n2) {
            for (n = 0; n < 16; ++n) {
                this._c(n2, n);
            }
        }
    }

    public void _c(int n, int n2) {
        this._e[n + n2 * 16] = true;
        this._k = true;
    }

    public void _e() {
        this._g.field_72984_F._a("recheckGaps");
        if (this._g.func_72873_a(this._i * 16 + 8, 0, this._j * 16 + 8, 16)) {
            for (int i = 0; i < 16; ++i) {
                for (int j = 0; j < 16; ++j) {
                    if (!this._e[i + j * 16]) continue;
                    this._e[i + j * 16] = false;
                    int n = this._b(i, j);
                    int n2 = this._i * 16 + i;
                    int n3 = this._j * 16 + j;
                    int n4 = this._g.func_82734_g(n2 - 1, n3);
                    int n5 = this._g.func_82734_g(n2 + 1, n3);
                    int n6 = this._g.func_82734_g(n2, n3 - 1);
                    int n7 = this._g.func_82734_g(n2, n3 + 1);
                    if (n5 < n4) {
                        n4 = n5;
                    }
                    if (n6 < n4) {
                        n4 = n6;
                    }
                    if (n7 < n4) {
                        n4 = n7;
                    }
                    this._a(n2, n3, n4);
                    this._a(n2 - 1, n3, n);
                    this._a(n2 + 1, n3, n);
                    this._a(n2, n3 - 1, n);
                    this._a(n2, n3 + 1, n);
                }
            }
            this._k = false;
        }
        this._g.field_72984_F._b();
    }

    public void _a(int n, int n2, int n3) {
        int n4 = this._g.func_72976_f(n, n2);
        if (n4 > n3) {
            this._a(n, n2, n3, n4 + 1);
        } else if (n4 < n3) {
            this._a(n, n2, n4, n3 + 1);
        }
    }

    public void _a(int n, int n2, int n3, int n4) {
        if (n4 > n3 && this._g.func_72873_a(n, 0, n2, 16)) {
            for (int i = n3; i < n4; ++i) {
                this._g.func_72936_c(rrqi._a, n, i, n2);
            }
            this._o = true;
        }
    }

    public void _b(int n, int n2, int n3) {
        int n4;
        int n5 = n4 = this._h[n3 << 4 | n] & 0xFF;
        if (n2 > n4) {
            n5 = n2;
        }
        while (n5 > 0 && this._c(n, n5 - 1, n3) == 0) {
            --n5;
        }
        if (n5 != n4) {
            int n6;
            int n7;
            this._g.func_72975_g(n + this._i * 16, n3 + this._j * 16, n5, n4);
            this._h[n3 << 4 | n] = n5;
            int n8 = this._i * 16 + n;
            int n9 = this._j * 16 + n3;
            if (!this._g.field_73011_w._g) {
                ujzm ujzm2;
                if (n5 < n4) {
                    for (n7 = n5; n7 < n4; ++n7) {
                        ujzm2 = this._b[n7 >> 4];
                        if (ujzm2 == null) continue;
                        ujzm2._c(n, n7 & 0xF, n3, 15);
                        this._g.func_72902_n((this._i << 4) + n, n7, (this._j << 4) + n3);
                    }
                } else {
                    for (n7 = n4; n7 < n5; ++n7) {
                        ujzm2 = this._b[n7 >> 4];
                        if (ujzm2 == null) continue;
                        ujzm2._c(n, n7 & 0xF, n3, 0);
                        this._g.func_72902_n((this._i << 4) + n, n7, (this._j << 4) + n3);
                    }
                }
                n7 = 15;
                while (n5 > 0 && n7 > 0) {
                    ujzm ujzm3;
                    if ((n6 = this._c(n, --n5, n3)) == 0) {
                        n6 = 1;
                    }
                    if ((n7 -= n6) < 0) {
                        n7 = 0;
                    }
                    if ((ujzm3 = this._b[n5 >> 4]) == null) continue;
                    ujzm3._c(n, n5 & 0xF, n3, n7);
                }
            }
            n7 = this._h[n3 << 4 | n];
            n6 = n4;
            int n10 = n7;
            if (n7 < n4) {
                n6 = n7;
                n10 = n4;
            }
            if (n7 < this._s) {
                this._s = n7;
            }
            if (!this._g.field_73011_w._g) {
                this._a(n8 - 1, n9, n6, n10);
                this._a(n8 + 1, n9, n6, n10);
                this._a(n8, n9 - 1, n6, n10);
                this._a(n8, n9 + 1, n6, n10);
                this._a(n8, n9, n6, n10);
            }
            this._o = true;
        }
    }

    public int _c(int n, int n2, int n3) {
        int n4 = (this._i << 4) + n;
        int n5 = (this._j << 4) + n3;
        twgu twgu2 = twgu.field_71973_m[this._d(n, n2, n3)];
        return twgu2 == null ? 0 : twgu2.getLightOpacity(this._g, n4, n2, n5);
    }

    public int _d(int n, int n2, int n3) {
        if (n2 >> 4 >= this._b.length) {
            return 0;
        }
        ujzm ujzm2 = this._b[n2 >> 4];
        return ujzm2 != null ? ujzm2._a(n, n2 & 0xF, n3) : 0;
    }

    public int _e(int n, int n2, int n3) {
        if (n2 >> 4 >= this._b.length) {
            return 0;
        }
        ujzm ujzm2 = this._b[n2 >> 4];
        return ujzm2 != null ? ujzm2._b(n, n2 & 0xF, n3) : 0;
    }

    public boolean _a(int n, int n2, int n3, int n4, int n5) {
        hurg hurg2;
        int n6 = n3 << 4 | n;
        if (n2 >= this._d[n6] - 1) {
            this._d[n6] = -999;
        }
        int n7 = this._h[n6];
        int n8 = this._d(n, n2, n3);
        int n9 = this._e(n, n2, n3);
        if (n8 == n4 && n9 == n5) {
            return false;
        }
        ujzm ujzm2 = this._b[n2 >> 4];
        boolean bl = false;
        if (ujzm2 == null) {
            if (n4 == 0) {
                return false;
            }
            ujzm ujzm3 = new ujzm(n2 >> 4 << 4, !this._g.field_73011_w._g);
            this._b[n2 >> 4] = ujzm3;
            ujzm2 = ujzm3;
            bl = n2 >= n7;
        }
        int n10 = this._i * 16 + n;
        int n11 = this._j * 16 + n3;
        if (n8 != 0 && !this._g.field_72995_K) {
            twgu.field_71973_m[n8].func_71927_h(this._g, n10, n2, n11, n9);
        }
        ujzm2._a(n, n2 & 0xF, n3, n4);
        if (n8 != 0) {
            if (!this._g.field_72995_K) {
                twgu.field_71973_m[n8].func_71852_a(this._g, n10, n2, n11, n8, n9);
            } else if (twgu.field_71973_m[n8] != null && twgu.field_71973_m[n8].hasTileEntity(n9) && (hurg2 = this._j(n10 & 0xF, n2, n11 & 0xF)) != null && hurg2.shouldRefresh(n8, n4, n9, n5, this._g, n10, n2, n11)) {
                this._g.func_72932_q(n10, n2, n11);
            }
        }
        if (ujzm2._a(n, n2 & 0xF, n3) != n4) {
            return false;
        }
        ujzm2._b(n, n2 & 0xF, n3, n5);
        if (bl) {
            this._d();
        } else {
            if (this._c(n, n2, n3) > 0) {
                if (n2 >= n7) {
                    this._b(n, n2 + 1, n3);
                }
            } else if (n2 == n7 - 1) {
                this._b(n, n2, n3);
            }
            this._c(n, n3);
        }
        if (n4 != 0) {
            if (!this._g.field_72995_K) {
                twgu.field_71973_m[n4].func_71861_g(this._g, n10, n2, n11);
            }
            if (twgu.field_71973_m[n4] != null && twgu.field_71973_m[n4].hasTileEntity(n5)) {
                hurg2 = this._g(n, n2, n3);
                if (hurg2 == null) {
                    hurg2 = twgu.field_71973_m[n4].createTileEntity(this._g, n5);
                    this._g.func_72837_a(n10, n2, n11, hurg2);
                }
                if (hurg2 != null) {
                    hurg2.func_70321_h();
                    hurg2.field_70325_p = n5;
                }
            }
        }
        this._o = true;
        return true;
    }

    public boolean _b(int n, int n2, int n3, int n4) {
        hurg hurg2;
        ujzm ujzm2 = this._b[n2 >> 4];
        if (ujzm2 == null) {
            return false;
        }
        int n5 = ujzm2._b(n, n2 & 0xF, n3);
        if (n5 == n4) {
            return false;
        }
        this._o = true;
        ujzm2._b(n, n2 & 0xF, n3, n4);
        int n6 = ujzm2._a(n, n2 & 0xF, n3);
        if (n6 > 0 && twgu.field_71973_m[n6] != null && twgu.field_71973_m[n6].hasTileEntity(n4) && (hurg2 = this._g(n, n2, n3)) != null) {
            hurg2.func_70321_h();
            hurg2.field_70325_p = n4;
        }
        return true;
    }

    public int _a(rrqi rrqi2, int n, int n2, int n3) {
        ujzm ujzm2 = this._b[n2 >> 4];
        return ujzm2 == null ? (this._f(n, n2, n3) ? rrqi2._c : 0) : (rrqi2 == rrqi._a ? (this._g.field_73011_w._g ? 0 : ujzm2._c(n, n2 & 0xF, n3)) : (rrqi2 == rrqi._b ? ujzm2._d(n, n2 & 0xF, n3) : rrqi2._c));
    }

    public void _a(rrqi rrqi2, int n, int n2, int n3, int n4) {
        ujzm ujzm2 = this._b[n2 >> 4];
        if (ujzm2 == null) {
            ujzm ujzm3 = new ujzm(n2 >> 4 << 4, !this._g.field_73011_w._g);
            this._b[n2 >> 4] = ujzm3;
            ujzm2 = ujzm3;
            this._d();
        }
        this._o = true;
        if (rrqi2 == rrqi._a) {
            if (!this._g.field_73011_w._g) {
                ujzm2._c(n, n2 & 0xF, n3, n4);
            }
        } else if (rrqi2 == rrqi._b) {
            ujzm2._d(n, n2 & 0xF, n3, n4);
        }
    }

    public int _c(int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        ujzm ujzm2 = this._b[n2 >> 4];
        if (ujzm2 == null) {
            return !this._g.field_73011_w._g && n4 < rrqi._a._c ? rrqi._a._c - n4 : 0;
        }
        int n7 = n6 = this._g.field_73011_w._g ? 0 : ujzm2._c(n, n2 & 0xF, n3);
        if (n6 > 0) {
            _a = true;
        }
        if ((n5 = ujzm2._d(n, n2 & 0xF, n3)) > (n6 -= n4)) {
            n6 = n5;
        }
        return n6;
    }

    public void _a(Entity entity) {
        int n;
        this._p = true;
        int n2 = sajh._c(entity.field_70165_t / 16.0);
        int n3 = sajh._c(entity.field_70161_v / 16.0);
        if (n2 != this._i || n3 != this._j) {
            this._g.func_98180_V()._c("Wrong location! " + entity);
            Thread.dumpStack();
        }
        if ((n = sajh._c(entity.field_70163_u / 16.0)) < 0) {
            n = 0;
        }
        if (n >= this._m.length) {
            n = this._m.length - 1;
        }
        MinecraftForge.EVENT_BUS.post(new EntityEvent.EnteringChunk(entity, this._i, this._j, entity.field_70176_ah, entity.field_70164_aj));
        entity.field_70175_ag = true;
        entity.field_70176_ah = this._i;
        entity.field_70162_ai = n;
        entity.field_70164_aj = this._j;
        this._m[n].add(entity);
    }

    public void _b(Entity entity) {
        this._a(entity, entity.field_70162_ai);
    }

    public void _a(Entity entity, int n) {
        if (n < 0) {
            n = 0;
        }
        if (n >= this._m.length) {
            n = this._m.length - 1;
        }
        this._m[n].remove(entity);
    }

    public boolean _f(int n, int n2, int n3) {
        return n2 >= this._h[n3 << 4 | n];
    }

    public hurg _g(int n, int n2, int n3) {
        hurg hurg2 = GloomyHooks.getChunkBlockTileEntity(this, n, n2, n3);
        return hurg2;
    }

    public void _a(hurg hurg2) {
        int n = hurg2.field_70329_l - this._i * 16;
        int n2 = hurg2.field_70330_m;
        int n3 = hurg2.field_70327_n - this._j * 16;
        this._a(n, n2, n3, hurg2);
        if (this._f) {
            this._g.addTileEntity(hurg2);
        }
    }

    public void _a(int n, int n2, int n3, hurg hurg2) {
        xtcd xtcd2 = new xtcd(n, n2, n3);
        hurg2.func_70308_a(this._g);
        hurg2.field_70329_l = this._i * 16 + n;
        hurg2.field_70330_m = n2;
        hurg2.field_70327_n = this._j * 16 + n3;
        twgu twgu2 = twgu.field_71973_m[this._d(n, n2, n3)];
        if (twgu2 != null && twgu2.hasTileEntity(this._e(n, n2, n3))) {
            if (this._l.containsKey(xtcd2)) {
                ((hurg)this._l.get(xtcd2)).func_70313_j();
            }
            hurg2.func_70312_q();
            this._l.put(xtcd2, hurg2);
        }
    }

    public void _h(int n, int n2, int n3) {
        hurg hurg2;
        xtcd xtcd2 = new xtcd(n, n2, n3);
        if (this._f && (hurg2 = (hurg)this._l.remove(xtcd2)) != null) {
            hurg2.func_70313_j();
        }
    }

    public void _f() {
        this._f = true;
        this._g.func_72852_a(this._l.values());
        for (int i = 0; i < this._m.length; ++i) {
            for (Entity entity : this._m[i]) {
                entity.func_110123_P();
            }
            this._g.func_72868_a(this._m[i]);
        }
        MinecraftForge.EVENT_BUS.post(new ChunkEvent.Load(this));
    }

    public void _g() {
        this._f = false;
        for (hurg hurg2 : this._l.values()) {
            this._g.func_72928_a(hurg2);
        }
        for (int i = 0; i < this._m.length; ++i) {
            this._g.func_72828_b(this._m[i]);
        }
        MinecraftForge.EVENT_BUS.post(new ChunkEvent.Unload(this));
    }

    public void _h() {
        this._o = true;
    }

    public void _a(Entity entity, eidj eidj2, List list, zhos zhos2) {
        int n = sajh._c((eidj2._c - ozlu.MAX_ENTITY_RADIUS) / 16.0);
        int n2 = sajh._c((eidj2._f + ozlu.MAX_ENTITY_RADIUS) / 16.0);
        if (n < 0) {
            n = 0;
            n2 = Math.max(n, n2);
        }
        if (n2 >= this._m.length) {
            n2 = this._m.length - 1;
            n = Math.min(n, n2);
        }
        for (int i = n; i <= n2; ++i) {
            List list2 = this._m[i];
            for (int j = 0; j < list2.size(); ++j) {
                Entity entity2 = (Entity)list2.get(j);
                if (entity2 == entity || !entity2.field_70121_D._b(eidj2) || zhos2 != null && !zhos2.func_82704_a(entity2)) continue;
                list.add(entity2);
                Entity[] entityArray = entity2.func_70021_al();
                if (entityArray == null) continue;
                for (int k = 0; k < entityArray.length; ++k) {
                    entity2 = entityArray[k];
                    if (entity2 == entity || !entity2.field_70121_D._b(eidj2) || zhos2 != null && !zhos2.func_82704_a(entity2)) continue;
                    list.add(entity2);
                }
            }
        }
    }

    public void _a(Class clazz, eidj eidj2, List list, zhos zhos2) {
        int n = sajh._c((eidj2._c - ozlu.MAX_ENTITY_RADIUS) / 16.0);
        int n2 = sajh._c((eidj2._f + ozlu.MAX_ENTITY_RADIUS) / 16.0);
        if (n < 0) {
            n = 0;
        } else if (n >= this._m.length) {
            n = this._m.length - 1;
        }
        if (n2 >= this._m.length) {
            n2 = this._m.length - 1;
        } else if (n2 < 0) {
            n2 = 0;
        }
        for (int i = n; i <= n2; ++i) {
            List list2 = this._m[i];
            for (int j = 0; j < list2.size(); ++j) {
                Entity entity = (Entity)list2.get(j);
                if (!clazz.isAssignableFrom(entity.getClass()) || !entity.field_70121_D._b(eidj2) || zhos2 != null && !zhos2.func_82704_a(entity)) continue;
                list.add(entity);
            }
        }
    }

    public boolean _a(boolean bl) {
        if (bl ? this._p && this._g.func_82737_E() != this._q || this._o : this._p && this._g.func_82737_E() >= this._q + 600L) {
            return true;
        }
        return this._o;
    }

    public Random _a(long l) {
        return new Random(this._g.func_72905_C() + (long)(this._i * this._i * 4987142) + (long)(this._i * 5947611) + (long)(this._j * this._j) * 4392871L + (long)(this._j * 389711) ^ l);
    }

    public boolean _i() {
        return false;
    }

    public void _a(mccn mccn2, mccn mccn3, int n, int n2) {
        if (!this._n && mccn2._c(n + 1, n2 + 1) && mccn2._c(n, n2 + 1) && mccn2._c(n + 1, n2)) {
            mccn2._a(mccn3, n, n2);
        }
        if (mccn2._c(n - 1, n2) && !mccn2._b((int)(n - 1), (int)n2)._n && mccn2._c(n - 1, n2 + 1) && mccn2._c(n, n2 + 1) && mccn2._c(n - 1, n2 + 1)) {
            mccn2._a(mccn3, n - 1, n2);
        }
        if (mccn2._c(n, n2 - 1) && !mccn2._b((int)n, (int)(n2 - 1))._n && mccn2._c(n + 1, n2 - 1) && mccn2._c(n + 1, n2 - 1) && mccn2._c(n + 1, n2)) {
            mccn2._a(mccn3, n, n2 - 1);
        }
        if (mccn2._c(n - 1, n2 - 1) && !mccn2._b((int)(n - 1), (int)(n2 - 1))._n && mccn2._c(n, n2 - 1) && mccn2._c(n - 1, n2)) {
            mccn2._a(mccn3, n - 1, n2 - 1);
        }
    }

    public int _d(int n, int n2) {
        int n3 = n | n2 << 4;
        int n4 = this._d[n3];
        if (n4 == -999) {
            int n5 = this._a() + 15;
            n4 = -1;
            while (n5 > 0 && n4 == -1) {
                tflj tflj2;
                int n6 = this._d(n, n5, n2);
                tflj tflj3 = tflj2 = n6 == 0 ? tflj._a : twgu.field_71973_m[n6].field_72018_cp;
                if (!tflj2._c() && !tflj2._d()) {
                    --n5;
                    continue;
                }
                n4 = n5 + 1;
            }
            this._d[n3] = n4;
        }
        return n4;
    }

    public void _j() {
        if (this._k && !this._g.field_73011_w._g) {
            this._e();
        }
    }

    public jjym _k() {
        return new jjym(this._i, this._j);
    }

    public boolean _e(int n, int n2) {
        if (n < 0) {
            n = 0;
        }
        if (n2 >= 256) {
            n2 = 255;
        }
        for (int i = n; i <= n2; i += 16) {
            ujzm ujzm2 = this._b[i >> 4];
            if (ujzm2 == null || ujzm2._a()) continue;
            return false;
        }
        return true;
    }

    public void _a(ujzm[] ujzmArray) {
        this._b = ujzmArray;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(byte[] byArray, int n, int n2, boolean bl) {
        Object object;
        int n3;
        for (hurg hurg2 : this._l.values()) {
            hurg2.func_70321_h();
            hurg2.func_70322_n();
            hurg2.func_70311_o();
        }
        int n4 = 0;
        boolean bl2 = !this._g.field_73011_w._g;
        for (n3 = 0; n3 < this._b.length; ++n3) {
            if ((n & 1 << n3) != 0) {
                if (this._b[n3] == null) {
                    this._b[n3] = new ujzm(n3 << 4, bl2);
                }
                object = this._b[n3]._e();
                System.arraycopy(byArray, n4, object, 0, ((byte[])object).length);
                n4 += ((byte[])object).length;
                continue;
            }
            if (!bl || this._b[n3] == null) continue;
            this._b[n3] = null;
        }
        for (n3 = 0; n3 < this._b.length; ++n3) {
            if ((n & 1 << n3) == 0 || this._b[n3] == null) continue;
            object = this._b[n3]._h();
            System.arraycopy(byArray, n4, object._a, 0, object._a.length);
            n4 += object._a.length;
        }
        for (n3 = 0; n3 < this._b.length; ++n3) {
            if ((n & 1 << n3) == 0 || this._b[n3] == null) continue;
            object = this._b[n3]._i();
            System.arraycopy(byArray, n4, object._a, 0, object._a.length);
            n4 += object._a.length;
        }
        if (bl2) {
            for (n3 = 0; n3 < this._b.length; ++n3) {
                if ((n & 1 << n3) == 0 || this._b[n3] == null) continue;
                object = this._b[n3]._j();
                System.arraycopy(byArray, n4, object._a, 0, object._a.length);
                n4 += object._a.length;
            }
        }
        for (n3 = 0; n3 < this._b.length; ++n3) {
            if ((n2 & 1 << n3) != 0) {
                if (this._b[n3] == null) {
                    n4 += 2048;
                    continue;
                }
                object = this._b[n3]._g();
                if (object == null) {
                    object = this._b[n3]._k();
                }
                System.arraycopy(byArray, n4, object._a, 0, object._a.length);
                n4 += object._a.length;
                continue;
            }
            if (!bl || this._b[n3] == null || this._b[n3]._g() == null) continue;
            this._b[n3]._f();
        }
        if (bl) {
            System.arraycopy(byArray, n4, this._c, 0, this._c.length);
            int n5 = n4 + this._c.length;
        }
        for (n3 = 0; n3 < this._b.length; ++n3) {
            if (this._b[n3] == null || (n & 1 << n3) == 0) continue;
            this._b[n3]._d();
        }
        this._c();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (Object object2 : this._l.values()) {
            int n6 = ((hurg)object2).field_70329_l & 0xF;
            int n7 = ((hurg)object2).field_70330_m;
            int n8 = ((hurg)object2).field_70327_n & 0xF;
            twgu twgu2 = ((hurg)object2).func_70311_o();
            if (twgu2 == null || twgu2.field_71990_ca != this._d(n6, n7, n8) || ((hurg)object2).func_70322_n() != this._e(n6, n7, n8)) {
                arrayList.add(object2);
            }
            ((hurg)object2).func_70321_h();
        }
        for (hurg hurg3 : arrayList) {
            hurg3.func_70313_j();
        }
    }

    public foqh _a(int n, int n2, foqg foqg2) {
        int n3 = this._c[n2 << 4 | n] & 0xFF;
        if (n3 == 255) {
            foqh foqh2 = foqg2._a((this._i << 4) + n, (this._j << 4) + n2);
            n3 = foqh2._P;
            this._c[n2 << 4 | n] = (byte)(n3 & 0xFF);
        }
        return foqh._a[n3] == null ? foqh._c : foqh._a[n3];
    }

    public byte[] _l() {
        return this._c;
    }

    public void _a(byte[] byArray) {
        this._c = byArray;
    }

    public void _m() {
        this._u = 0;
    }

    public void _n() {
        for (int i = 0; i < 8; ++i) {
            if (this._u >= 4096) {
                return;
            }
            int n = this._u % 16;
            int n2 = this._u / 16 % 16;
            int n3 = this._u / 256;
            ++this._u;
            int n4 = (this._i << 4) + n2;
            int n5 = (this._j << 4) + n3;
            for (int j = 0; j < 16; ++j) {
                int n6 = (n << 4) + j;
                if ((this._b[n] != null || j != 0 && j != 15 && n2 != 0 && n2 != 15 && n3 != 0 && n3 != 15) && (this._b[n] == null || this._b[n]._a(n2, j, n3) != 0)) continue;
                if (twgu.field_71984_q[this._g.func_72798_a(n4, n6 - 1, n5)] > 0) {
                    this._g.func_72969_x(n4, n6 - 1, n5);
                }
                if (twgu.field_71984_q[this._g.func_72798_a(n4, n6 + 1, n5)] > 0) {
                    this._g.func_72969_x(n4, n6 + 1, n5);
                }
                if (twgu.field_71984_q[this._g.func_72798_a(n4 - 1, n6, n5)] > 0) {
                    this._g.func_72969_x(n4 - 1, n6, n5);
                }
                if (twgu.field_71984_q[this._g.func_72798_a(n4 + 1, n6, n5)] > 0) {
                    this._g.func_72969_x(n4 + 1, n6, n5);
                }
                if (twgu.field_71984_q[this._g.func_72798_a(n4, n6, n5 - 1)] > 0) {
                    this._g.func_72969_x(n4, n6, n5 - 1);
                }
                if (twgu.field_71984_q[this._g.func_72798_a(n4, n6, n5 + 1)] > 0) {
                    this._g.func_72969_x(n4, n6, n5 + 1);
                }
                this._g.func_72969_x(n4, n6, n5);
            }
        }
    }

    public void _i(int n, int n2, int n3) {
        hurg hurg2;
        xtcd xtcd2 = new xtcd(n, n2, n3);
        if (this._f && (hurg2 = (hurg)this._l.get(xtcd2)) != null && hurg2.func_70320_p()) {
            this._l.remove(xtcd2);
        }
    }

    public hurg _j(int n, int n2, int n3) {
        xtcd xtcd2 = new xtcd(n, n2, n3);
        hurg hurg2 = (hurg)this._l.get(xtcd2);
        if (hurg2 != null && hurg2.func_70320_p()) {
            this._l.remove(xtcd2);
            hurg2 = null;
        }
        return hurg2;
    }
}

