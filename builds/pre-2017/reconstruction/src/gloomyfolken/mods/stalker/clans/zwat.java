/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.clans;

import com.google.common.collect.ImmutableMap;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.mods.stalker.clans.jgro;
import gloomyfolken.mods.stalker.clans.pidb;
import java.lang.invoke.LambdaMetafactory;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;

public class zwat
extends tehy {
    public static final String _a = "StalcraftClans";
    private static final long _h = 300000L;
    private static final long _i = 2500L;
    private static Map<Integer, Integer> _j = ImmutableMap.builder().put(2793, 1).put(2794, 10).put(2795, 50).put(2796, 100).put(2797, 500).put(2798, 1000).put(2799, 5000).build();
    public int _b = 0;
    public bqwg<String> _c;
    private bqwg<Long> _k;
    private bqwg<tupg> _l;
    public List<Long> _d = new ArrayList<Long>();
    public kjui _e;
    private boolean _m = false;
    private boolean _n = false;
    public long _f = 0L;
    public boolean _g;
    private boolean _o = false;

    public zwat(ccxr ccxr2) {
        super(ccxr2);
        this._c = new bqwg.kjui<Class<String>>(ccxr2, "clan", String.class)._a()._f();
        this._k = new bqwg.kjui<Long>(ccxr2, "lft", 0L)._b()._f();
        this._l = new bqwg.kjui<Class<tupg>>(ccxr2, "pfct", tupg.class)._b()._f();
    }

    @Override
    public void resetHandler() {
        this._g = false;
        if (!this.player.worldObj.isRemote) {
            InvokeSideOnly.frontend((InvokeSideOnly.InvokeFrontendOnly)LambdaMetafactory.metafactory(null, null, null, ()V, initServer(), ()V)((zwat)this));
        }
    }

    @Override
    public void tick() {
        if (!this.player.worldObj.isRemote) {
            InvokeSideOnly.frontend((InvokeSideOnly.InvokeFrontendOnly)LambdaMetafactory.metafactory(null, null, null, ()V, serverTick(), ()V)((zwat)this));
        }
    }

    public boolean _a() {
        return this._k._b() + 300000L > System.currentTimeMillis();
    }

    public boolean _b() {
        return gloomyfolken.mods.money.zwat._a(this.player)._e(2500L);
    }

    public jgro _a(EntityPlayer entityPlayer) {
        pidb pidb2 = this._c();
        if (pidb2 != null) {
            boolean bl = this._c._b() != null && this._c._b().equals(zwat._b((EntityPlayer)entityPlayer)._c._b());
            return bl ? jgro._d : jgro._a;
        }
        if (entityPlayer.worldObj.isRemote) {
            return InvokeWithResult.client(() -> this._c(entityPlayer));
        }
        return InvokeWithResult.frontend(() -> null);
    }

    @ezey(_a={eidj.CLIENT})
    private jgro _c(EntityPlayer entityPlayer) {
        String string = zwat._b((EntityPlayer)entityPlayer)._c._b();
        jgro jgro2 = zwat._a(yuch._a._t.get(string));
        if (jgro2 != null) {
            return jgro2;
        }
        return this._a(gloomyfolken.mods.faction.pidb._a(entityPlayer)._a());
    }

    private pidb _c() {
        if (this.player.worldObj.isRemote) {
            return InvokeWithResult.client(() -> yuch._c);
        }
        return InvokeWithResult.frontend(() -> null);
    }

    public jgro _a(tupg tupg2) {
        tupg tupg3 = gloomyfolken.mods.faction.pidb._a(this.player)._a();
        return zwat._a(tupg3, tupg2);
    }

    public static jgro _a(tupg tupg2, tupg tupg3) {
        if (tupg2 != tupg._a && tupg3 != tupg._a) {
            return tupg3 == tupg2 ? jgro._c : jgro._a;
        }
        if (tupg3 == tupg._c) {
            return jgro._a;
        }
        if (tupg3 == tupg._b) {
            return jgro._e;
        }
        return jgro._e;
    }

    public static jgro _a(owak owak2) {
        if (owak2 != null) {
            if (owak2._h) {
                return jgro._a;
            }
            if (owak2 == owak._d) {
                return jgro._d;
            }
        }
        return null;
    }

    public static zwat _b(EntityPlayer entityPlayer) {
        return (zwat)ncwh._a((EntityPlayer)entityPlayer)._h.get(_a);
    }

    public static class kjui {
        public einh _a;
        public einh _b;
        public einh _c;
        public einh _d;
        public DayOfWeek _e;
        public LocalTime _f;
        public Duration _g;
        public String _h;
        public String _i;
        public int _j;
        public String _k;
        public boolean _l = true;

        public String toString() {
            return "FlagProps{warningFirstSelected=" + this._a + ", warningSecondSelected=" + this._b + ", captureFirstSelected=" + this._c + ", captureSecondSelected=" + this._d + ", captureDay=" + this._e + ", captureTime=" + this._f + ", captureDuration=" + this._g + ", flagName='" + this._h + '\'' + ", rentName='" + this._i + '\'' + ", resourcePoints='" + this._j + '\'' + ", serverName='" + this._k + '\'' + ", capture='" + this._l + '\'' + '}';
        }
    }
}

