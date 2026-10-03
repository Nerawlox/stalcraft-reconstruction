/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.jxtc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class elkd {
    public boolean _a;
    public boolean _b = true;
    public int _c = 16;
    public Random _d = new Random();
    public ozlu _e;
    public double _f;
    public double _g;
    public double _h;
    public Entity _i;
    public float _j;
    public List _k = new ArrayList();
    public Map _l = new HashMap();

    public elkd(ozlu ozlu2, Entity entity, double d, double d2, double d3, float f) {
        this._e = ozlu2;
        this._i = entity;
        this._j = f;
        this._f = d;
        this._g = d2;
        this._h = d3;
    }

    public void _a() {
        double d;
        double d2;
        double d3;
        int n;
        int n2;
        int n3;
        float f = this._j;
        HashSet<xtcd> hashSet = new HashSet<xtcd>();
        for (n3 = 0; n3 < this._c; ++n3) {
            for (n2 = 0; n2 < this._c; ++n2) {
                for (n = 0; n < this._c; ++n) {
                    if (n3 != 0 && n3 != this._c - 1 && n2 != 0 && n2 != this._c - 1 && n != 0 && n != this._c - 1) continue;
                    double d4 = (float)n3 / ((float)this._c - 1.0f) * 2.0f - 1.0f;
                    double d5 = (float)n2 / ((float)this._c - 1.0f) * 2.0f - 1.0f;
                    double d6 = (float)n / ((float)this._c - 1.0f) * 2.0f - 1.0f;
                    double d7 = Math.sqrt(d4 * d4 + d5 * d5 + d6 * d6);
                    d4 /= d7;
                    d5 /= d7;
                    d6 /= d7;
                    d3 = this._f;
                    d2 = this._g;
                    d = this._h;
                    float f2 = 0.3f;
                    for (float f3 = this._j * (0.7f + this._e.field_73012_v.nextFloat() * 0.6f); f3 > 0.0f; f3 -= f2 * 0.75f) {
                        int n4;
                        int n5;
                        int n6 = sajh._c(d3);
                        int n7 = this._e.func_72798_a(n6, n5 = sajh._c(d2), n4 = sajh._c(d));
                        if (n7 > 0) {
                            twgu twgu2 = twgu.field_71973_m[n7];
                            float f4 = this._i != null ? this._i.func_82146_a(this, this._e, n6, n5, n4, twgu2) : twgu2.getExplosionResistance(this._i, this._e, n6, n5, n4, this._f, this._g, this._h);
                            f3 -= (f4 + 0.3f) * f2;
                        }
                        if (f3 > 0.0f && (this._i == null || this._i.func_96091_a(this, this._e, n6, n5, n4, n7, f3))) {
                            hashSet.add(new xtcd(n6, n5, n4));
                        }
                        d3 += d4 * (double)f2;
                        d2 += d5 * (double)f2;
                        d += d6 * (double)f2;
                    }
                }
            }
        }
        this._k.addAll(hashSet);
        this._j *= 2.0f;
        n3 = sajh._c(this._f - (double)this._j - 1.0);
        n2 = sajh._c(this._f + (double)this._j + 1.0);
        n = sajh._c(this._g - (double)this._j - 1.0);
        int n8 = sajh._c(this._g + (double)this._j + 1.0);
        int n9 = sajh._c(this._h - (double)this._j - 1.0);
        int n10 = sajh._c(this._h + (double)this._j + 1.0);
        List list2 = this._e.func_72839_b(this._i, eidj._a()._a(n3, n, n9, n2, n8, n10));
        ofbx ofbx2 = this._e.func_82732_R()._a(this._f, this._g, this._h);
        for (int i = 0; i < list2.size(); ++i) {
            double d8;
            Entity entity = (Entity)list2.get(i);
            double d9 = entity.func_70011_f(this._f, this._g, this._h) / (double)this._j;
            if (!(d9 <= 1.0) || (d8 = (double)sajh._a((d3 = entity.field_70165_t - this._f) * d3 + (d2 = entity.field_70163_u + (double)entity.func_70047_e() - this._g) * d2 + (d = entity.field_70161_v - this._h) * d)) == 0.0) continue;
            d3 /= d8;
            d2 /= d8;
            d /= d8;
            double d10 = this._e.func_72842_a(ofbx2, entity.field_70121_D);
            double d11 = (1.0 - d9) * d10;
            entity.func_70097_a(jxtc.func_94539_a(this), (int)((d11 * d11 + d11) / 2.0 * 8.0 * (double)this._j + 1.0));
            double d12 = igdi._a(entity, d11);
            entity.field_70159_w += d3 * d12;
            entity.field_70181_x += d2 * d12;
            entity.field_70179_y += d * d12;
            if (!(entity instanceof EntityPlayer)) continue;
            this._l.put((EntityPlayer)entity, this._e.func_82732_R()._a(d3 * d11, d2 * d11, d * d11));
        }
        this._j = f;
    }

    public void _a(boolean bl) {
        GloomyHooks.doExplosionB(this, bl);
    }

    public Map _b() {
        return this._l;
    }

    public EntityLivingBase _c() {
        return this._i == null ? null : (this._i instanceof EntityTNTPrimed ? ((EntityTNTPrimed)this._i).func_94083_c() : (this._i instanceof EntityLivingBase ? (EntityLivingBase)this._i : null));
    }
}

