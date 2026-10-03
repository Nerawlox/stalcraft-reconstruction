/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import mcoptifine.Config;
import mcoptifine.NextTickHashSet;

public class WorldServerOF
extends yfgy {
    private NextTickHashSet nextTickHashSet = null;
    private TreeSet pendingTickList = null;

    public WorldServerOF(dzfd dzfd2, mtms mtms2, String string, int n, nfhj nfhj2, fokl fokl2, jjmf jjmf2) {
        super(dzfd2, mtms2, string, n, nfhj2, fokl2, jjmf2);
        this.fixSetNextTicks();
    }

    private void fixSetNextTicks() {
        try {
            Field[] fieldArray = yfgy.class.getDeclaredFields();
            if (fieldArray.length > 5) {
                Field field = fieldArray[3];
                field.setAccessible(true);
                if (field.getType() == Set.class) {
                    Set set = (Set)field.get(this);
                    NextTickHashSet nextTickHashSet = new NextTickHashSet(set);
                    field.set(this, nextTickHashSet);
                    Field field2 = fieldArray[4];
                    field2.setAccessible(true);
                    this.pendingTickList = (TreeSet)field2.get(this);
                    this.nextTickHashSet = nextTickHashSet;
                }
            }
        }
        catch (Exception exception) {
            Config.warn("Error setting WorldServer.nextTickSet: " + exception.getMessage());
        }
    }

    @Override
    public List func_72920_a(ixzi ixzi2, boolean bl) {
        if (this.nextTickHashSet != null && this.pendingTickList != null) {
            ArrayList<cfex> arrayList = null;
            jjym jjym2 = ixzi2._k();
            int n = jjym2._a << 4;
            int n2 = n + 16;
            int n3 = jjym2._b << 4;
            int n4 = n3 + 16;
            Iterator iterator2 = this.nextTickHashSet.getNextTickEntries(jjym2._a, jjym2._b);
            while (iterator2.hasNext()) {
                cfex cfex2 = (cfex)iterator2.next();
                if (cfex2._b >= n && cfex2._b < n2 && cfex2._d >= n3 && cfex2._d < n4) {
                    if (bl) {
                        this.pendingTickList.remove(cfex2);
                        iterator2.remove();
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList<cfex>();
                    }
                    arrayList.add(cfex2);
                    continue;
                }
                Config.warn("Not matching: " + n + "," + n3);
            }
            return arrayList;
        }
        return super.func_72920_a(ixzi2, bl);
    }

    @Override
    public void func_72835_b() {
        super.func_72835_b();
        if (!Config.isTimeDefault()) {
            this.fixWorldTime();
        }
        if (Config.waterOpacityChanged) {
            Config.waterOpacityChanged = false;
            this.updateWaterOpacity();
        }
    }

    @Override
    protected void func_72979_l() {
        if (Config.isWeatherEnabled()) {
            super.func_72979_l();
        } else {
            this.fixWorldWeather();
        }
    }

    private void fixWorldWeather() {
        if (this.field_72986_A._p() || this.field_72986_A._n()) {
            this.field_72986_A._f(0);
            this.field_72986_A._b(false);
            this.func_72894_k(0.0f);
            this.field_72986_A._e(0);
            this.field_72986_A._a(false);
            this.func_73046_m().__ag()._a(new tgph(2, 0));
        }
    }

    private void fixWorldTime() {
        if (this.field_72986_A._r()._a() == 1) {
            long l = this.func_72820_D();
            long l2 = l % 24000L;
            if (Config.isTimeDayOnly()) {
                if (l2 <= 1000L) {
                    this.func_72877_b(l - l2 + 1001L);
                }
                if (l2 >= 11000L) {
                    this.func_72877_b(l - l2 + 24001L);
                }
            }
            if (Config.isTimeNightOnly()) {
                if (l2 <= 14000L) {
                    this.func_72877_b(l - l2 + 14001L);
                }
                if (l2 >= 22000L) {
                    this.func_72877_b(l - l2 + 24000L + 14001L);
                }
            }
        }
    }

    public void updateWaterOpacity() {
        int n = 3;
        if (Config.isClearWater()) {
            n = 1;
        }
        twgu.field_71943_B.func_71868_h(n);
        twgu.field_71942_A.func_71868_h(n);
        mccn mccn2 = this.field_73020_y;
        if (mccn2 != null) {
            for (int i = -512; i < 512; ++i) {
                for (int j = -512; j < 512; ++j) {
                    ixzi ixzi2;
                    if (!mccn2._c(i, j) || (ixzi2 = mccn2._b(i, j)) == null || ixzi2 instanceof raqi) continue;
                    ujzm[] ujzmArray = ixzi2._b();
                    for (int k = 0; k < ujzmArray.length; ++k) {
                        wqak wqak2;
                        ujzm ujzm2 = ujzmArray[k];
                        if (ujzm2 == null || (wqak2 = ujzm2._j()) == null) continue;
                        byte[] byArray = wqak2._a;
                        for (int i2 = 0; i2 < byArray.length; ++i2) {
                            byArray[i2] = 0;
                        }
                    }
                    ixzi2._d();
                }
            }
        }
    }
}

