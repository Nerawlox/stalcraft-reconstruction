/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mcoptifine.ChunkVboRenderer;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.util.eidj;
import org.lwjgl.opengl.GL11;

public class nvgj {
    public ozlu field_78924_a;
    public static volatile int field_78922_b = 0;
    public int field_78923_c;
    public int field_78920_d;
    public int field_78921_e;
    public int field_78918_f;
    public int field_78919_g;
    public int field_78931_h;
    public int field_78932_i;
    public int field_78929_j;
    public int field_78930_k;
    public boolean field_78927_l = false;
    public boolean[] field_78928_m = new boolean[2];
    public int field_78925_n;
    public int field_78926_o;
    public int field_78940_p;
    public volatile boolean field_78939_q;
    public eidj field_78938_r;
    public int field_78937_s;
    public boolean field_78936_t = true;
    public boolean field_78935_u;
    public int field_78934_v;
    public boolean field_78933_w;
    public boolean field_78915_A = false;
    public List field_78943_x = new ArrayList();
    public List field_78916_B;
    public int field_78917_C;
    public boolean isVisibleFromPosition = false;
    public double visibleFromX;
    public double visibleFromY;
    public double visibleFromZ;
    public boolean isInFrustrumFully = false;
    public boolean needsBoxUpdate = false;
    public volatile boolean isUpdating = false;
    public long lastTickUpdated = -1L;
    public boolean wasAddedToLoadedList;
    public boolean skipAllRenderPasses;
    public tvlz[] vboBuffers;

    public nvgj(ozlu ozlu2, List list2, int n, int n2, int n3, int n4) {
        this.field_78924_a = ozlu2;
        this.field_78916_B = list2;
        this.field_78923_c = -999;
        this.func_78913_a(n, n2, n3);
        this.field_78939_q = false;
        this.vboBuffers = new tvlz[2];
    }

    public void func_78913_a(int n, int n2, int n3) {
        if (n != this.field_78923_c || n2 != this.field_78920_d || n3 != this.field_78921_e) {
            this.func_78910_b();
            this.field_78923_c = n;
            this.field_78920_d = n2;
            this.field_78921_e = n3;
            this.field_78925_n = n + 8;
            this.field_78926_o = n2 + 8;
            this.field_78940_p = n3 + 8;
            this.field_78932_i = n & 0x3FF;
            this.field_78929_j = n2;
            this.field_78930_k = n3 & 0x3FF;
            this.field_78918_f = n - this.field_78932_i;
            this.field_78919_g = n2 - this.field_78929_j;
            this.field_78931_h = n3 - this.field_78930_k;
            float f = 0.0f;
            this.field_78938_r = eidj._a((float)n - f, (float)n2 - f, (float)n3 - f, (float)(n + 16) + f, (float)(n2 + 16) + f, (float)(n3 + 16) + f);
            this.needsBoxUpdate = true;
            this.func_78914_f();
            this.isVisibleFromPosition = false;
        }
    }

    public void deleteAllBuffers() {
        if (this.vboBuffers != null) {
            for (int i = 0; i < 2; ++i) {
                tvlz tvlz2 = this.vboBuffers[i];
                if (tvlz2 == null) continue;
                tvlz2._e();
                this.vboBuffers[i] = null;
            }
        }
    }

    public void func_78905_g() {
        GL11.glTranslatef(this.field_78932_i, this.field_78929_j, this.field_78930_k);
    }

    public void func_78907_a() {
        if (this.field_78924_a != null && this.field_78939_q) {
            Object object;
            this.field_78936_t = true;
            this.isVisibleFromPosition = false;
            this.field_78939_q = false;
            int n = this.field_78923_c;
            int n2 = this.field_78920_d;
            int n3 = this.field_78921_e;
            int n4 = this.field_78923_c + 16;
            int n5 = this.field_78920_d + 16;
            int n6 = this.field_78921_e + 16;
            if (this.field_78920_d == 0) {
                n2 = 1;
            }
            for (int i = 0; i < 2; ++i) {
                this.field_78928_m[i] = true;
            }
            this.deleteAllBuffers();
            ixzi._a = false;
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.field_78943_x);
            this.field_78943_x.clear();
            int n7 = 1;
            zzie zzie2 = new zzie(this.field_78924_a, n - n7, n2 - n7, n3 - n7, n4 + n7, n5 + n7, n6 + n7, n7);
            if (!zzie2.func_72806_N()) {
                ++field_78922_b;
                object = new htvc(zzie2);
                this.field_78917_C = 0;
                htvf htvf2 = ((htvc)object).__aF;
                for (int i = 0; i < 2; ++i) {
                    int n8;
                    boolean bl = false;
                    boolean bl2 = false;
                    boolean bl3 = false;
                    for (n8 = n2; n8 < n5; ++n8) {
                        for (int j = n3; j < n6; ++j) {
                            for (int k = n; k < n4; ++k) {
                                boolean bl4;
                                int n9;
                                hurg hurg2;
                                twgu twgu2;
                                int n10 = zzie2.func_72798_a(k, n8, j);
                                if (n10 <= 0) continue;
                                if (!bl3) {
                                    bl3 = true;
                                    htvf2.setRenderingChunk(true);
                                    htvf2.func_78382_b();
                                    htvf2.func_78373_b(-this.field_78923_c, -this.field_78920_d, -this.field_78921_e);
                                }
                                if ((twgu2 = twgu.field_71973_m[n10]) == null) continue;
                                if (i == 0 && twgu2.func_71887_s() && cekh._b._a(hurg2 = zzie2.func_72796_p(k, n8, j))) {
                                    this.field_78943_x.add(hurg2);
                                }
                                if ((n9 = twgu2.func_71856_s_()) != i) {
                                    bl = true;
                                }
                                if (!(bl4 = twgu2.canRenderInPass(i))) continue;
                                bl2 |= ((htvc)object)._b(twgu2, k, n8, j);
                            }
                        }
                    }
                    if (bl3) {
                        n8 = htvf2.func_78381_a();
                        if (bl2 && n8 > 0) {
                            this.field_78917_C += n8;
                            tvlz tvlz2 = new tvlz(34962, 35044, n8);
                            if (htvf2.vboTesselator != null) {
                                htvf2.vboTesselator.loadDirectly(tvlz2);
                            }
                            this.vboBuffers[i] = tvlz2;
                        }
                        htvf2.setRenderingChunk(false);
                        htvf2.func_78373_b(0.0, 0.0, 0.0);
                    } else {
                        bl2 = false;
                    }
                    if (bl2) {
                        this.lastTickUpdated = this.field_78924_a.field_72986_A._h;
                        this.field_78928_m[i] = false;
                    }
                    if (!bl) break;
                }
            }
            object = new HashSet();
            ((AbstractCollection)object).addAll(this.field_78943_x);
            ((AbstractSet)object).removeAll(hashSet);
            this.field_78916_B.addAll(object);
            hashSet.removeAll(this.field_78943_x);
            this.field_78916_B.removeAll(hashSet);
            this.field_78933_w = ixzi._a;
            this.field_78915_A = true;
            this.updateSkipRenderPasses();
        }
    }

    public void updateSkipRenderPasses() {
        boolean bl;
        this.skipAllRenderPasses = this.field_78928_m[0] && this.field_78928_m[1];
        boolean bl2 = bl = !this.skipAllRenderPasses;
        if (bl != this.wasAddedToLoadedList) {
            if (this.skipAllRenderPasses) {
                xpzm._E()._s._m.add(this);
            } else {
                xpzm._E()._s._l.add(this);
            }
        }
        this.wasAddedToLoadedList = bl;
    }

    public float func_78912_a(Entity entity) {
        float f = (float)(entity.field_70165_t - (double)this.field_78925_n);
        float f2 = (float)(entity.field_70163_u - (double)this.field_78926_o);
        float f3 = (float)(entity.field_70161_v - (double)this.field_78940_p);
        return f * f + f2 * f2 + f3 * f3;
    }

    public void func_78910_b() {
        for (int i = 0; i < 2; ++i) {
            this.field_78928_m[i] = true;
        }
        this.field_78927_l = false;
        this.field_78915_A = false;
        this.skipAllRenderPasses = true;
        this.deleteAllBuffers();
    }

    public void func_78911_c() {
        this.func_78910_b();
        this.field_78924_a = null;
    }

    public void func_78908_a(lpai lpai2) {
        this.field_78927_l = lpai2._a(this.field_78938_r);
    }

    public int callForRenderPass(int n) {
        tvlz tvlz2 = this.vboBuffers[n];
        if (tvlz2 != null) {
            this.drawVboBuffer(tvlz2);
        }
        return -1;
    }

    public void drawVboBuffer(tvlz tvlz2) {
        ChunkVboRenderer.enableVertexAttribsDirectly(tvlz2);
        if (tvlz2._c <= 0) {
            throw new IllegalStateException("wtf, zero-sized VBO for chunk renderer at: x=" + this.field_78923_c + ", y=" + this.field_78920_d + ", z=" + this.field_78921_e);
        }
        try {
            GL11.glDrawArrays(7, 0, tvlz2._c / 16);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }
    }

    public void drawOcclusionQueryAABB() {
        float f = 0.0f;
        xsbj.func_76980_a(eidj._a()._a((float)this.field_78932_i - f, (float)this.field_78929_j - f, (float)this.field_78930_k - f, (float)(this.field_78932_i + 16) + f, (float)(this.field_78929_j + 16) + f, (float)(this.field_78930_k + 16) + f));
    }

    public boolean func_78906_e() {
        if (GloomyHooks.isRendererHidden(this)) {
            return true;
        }
        return this.skipAllRenderPasses;
    }

    public void func_78914_f() {
        this.field_78939_q = true;
    }
}

