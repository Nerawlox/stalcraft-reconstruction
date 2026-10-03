/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.jxsn;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.tupg;
import net.minecraft.util.iurq;
import net.minecraft.util.sajh;
import net.minecraft.util.zwaw;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;

public final class xtbl {
    public HashMap _a = new HashMap();

    public static xtcd _a(ozlu ozlu2, int n, int n2) {
        ixzi ixzi2 = ozlu2.func_72964_e(n, n2);
        int n3 = n * 16 + ozlu2.field_73012_v.nextInt(16);
        int n4 = n2 * 16 + ozlu2.field_73012_v.nextInt(16);
        int n5 = ozlu2.field_73012_v.nextInt(ixzi2 == null ? ozlu2.func_72940_L() : ixzi2._a() + 16 - 1);
        return new xtcd(n3, n5, n4);
    }

    public int _a(yfgy yfgy2, boolean bl, boolean bl2, boolean bl3) {
        Object object;
        int n;
        if (!bl && !bl2) {
            return 0;
        }
        this._a.clear();
        for (n = 0; n < yfgy2.field_73010_i.size(); ++n) {
            object = (EntityPlayer)yfgy2.field_73010_i.get(n);
            int n2 = sajh._c(((EntityPlayer)object).field_70165_t / 16.0);
            int n3 = sajh._c(((EntityPlayer)object).field_70161_v / 16.0);
            int n4 = 8;
            for (int i = -n4; i <= n4; ++i) {
                for (int j = -n4; j <= n4; ++j) {
                    boolean bl4 = i == -n4 || i == n4 || j == -n4 || j == n4;
                    jjym jjym2 = new jjym(i + n2, j + n3);
                    if (!bl4) {
                        this._a.put(jjym2, false);
                        continue;
                    }
                    if (this._a.containsKey(jjym2)) continue;
                    this._a.put(jjym2, true);
                }
            }
        }
        n = 0;
        object = yfgy2.func_72861_E();
        for (jxsn jxsn2 : jxsn.values()) {
            if (jxsn2._d() && !bl2 || !jxsn2._d() && !bl || jxsn2._e() && !bl3 || yfgy2.countEntities(jxsn2, true) > jxsn2._b() * this._a.size() / 256) continue;
            Iterator iterator2 = this._a.keySet().iterator();
            ArrayList arrayList = new ArrayList(this._a.keySet());
            Collections.shuffle(arrayList);
            block6: for (jjym jjym2 : arrayList) {
                if (((Boolean)this._a.get(jjym2)).booleanValue()) continue;
                xtcd xtcd2 = xtbl._a(yfgy2, jjym2._a, jjym2._b);
                int n5 = xtcd2._d;
                int n6 = xtcd2._e;
                int n7 = xtcd2._f;
                if (yfgy2.func_72809_s(n5, n6, n7) || yfgy2.func_72803_f(n5, n6, n7) != jxsn2._c()) continue;
                int n8 = 0;
                block7: for (int i = 0; i < 3; ++i) {
                    int n9 = n5;
                    int n10 = n6;
                    int n11 = n7;
                    int n12 = 6;
                    yffo yffo2 = null;
                    tupg tupg2 = null;
                    for (int j = 0; j < 4; ++j) {
                        EntityLiving entityLiving;
                        float f;
                        float f2;
                        float f3;
                        float f4;
                        float f5;
                        float f6;
                        float f7;
                        if (!xtbl._a(jxsn2, yfgy2, n9 += yfgy2.field_73012_v.nextInt(n12) - yfgy2.field_73012_v.nextInt(n12), n10 += yfgy2.field_73012_v.nextInt(1) - yfgy2.field_73012_v.nextInt(1), n11 += yfgy2.field_73012_v.nextInt(n12) - yfgy2.field_73012_v.nextInt(n12)) || yfgy2.func_72977_a(f7 = (float)n9 + 0.5f, f6 = (float)n10, f5 = (float)n11 + 0.5f, 24.0) != null || !((f4 = (f3 = f7 - (float)((zwaw)object)._a) * f3 + (f2 = f6 - (float)((zwaw)object)._b) * f2 + (f = f5 - (float)((zwaw)object)._c) * f) >= 576.0f)) continue;
                        if (yffo2 == null && (yffo2 = yfgy2.func_73057_a(jxsn2, n9, n10, n11)) == null) continue block7;
                        try {
                            entityLiving = (EntityLiving)yffo2._a.getConstructor(ozlu.class).newInstance(yfgy2);
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                            return n;
                        }
                        entityLiving.func_70012_b(f7, f6, f5, yfgy2.field_73012_v.nextFloat() * 360.0f, 0.0f);
                        Event.Result result = ForgeEventFactory.canEntitySpawn(entityLiving, yfgy2, f7, f6, f5);
                        if (result == Event.Result.ALLOW || result == Event.Result.DEFAULT && entityLiving.func_70601_bi()) {
                            ++n8;
                            yfgy2.func_72838_d(entityLiving);
                            if (!ForgeEventFactory.doSpecialSpawn(entityLiving, yfgy2, f7, f6, f5)) {
                                tupg2 = entityLiving.func_110161_a(tupg2);
                            }
                            if (n8 >= ForgeEventFactory.getMaxSpawnPackSize(entityLiving)) continue block6;
                        }
                        n += n8;
                    }
                }
            }
        }
        return n;
    }

    public static boolean _a(jxsn jxsn2, ozlu ozlu2, int n, int n2, int n3) {
        if (jxsn2._c() == tflj._h) {
            return ozlu2.func_72803_f(n, n2, n3)._d() && ozlu2.func_72803_f(n, n2 - 1, n3)._d() && !ozlu2.func_72809_s(n, n2 + 1, n3);
        }
        if (!ozlu2.func_72797_t(n, n2 - 1, n3)) {
            return false;
        }
        int n4 = ozlu2.func_72798_a(n, n2 - 1, n3);
        boolean bl = twgu.field_71973_m[n4] != null && twgu.field_71973_m[n4].canCreatureSpawn(jxsn2, ozlu2, n, n2 - 1, n3);
        return bl && n4 != twgu.field_71986_z.field_71990_ca && !ozlu2.func_72809_s(n, n2, n3) && !ozlu2.func_72803_f(n, n2, n3)._d() && !ozlu2.func_72809_s(n, n2 + 1, n3);
    }

    public static void _a(ozlu ozlu2, foqh foqh2, int n, int n2, int n3, int n4, Random random) {
        List list2 = foqh2._a(jxsn._b);
        if (!list2.isEmpty()) {
            while (random.nextFloat() < foqh2._g()) {
                yffo yffo2 = (yffo)iurq._a(ozlu2.field_73012_v, list2);
                tupg tupg2 = null;
                int n5 = yffo2._b + random.nextInt(1 + yffo2._c - yffo2._b);
                int n6 = n + random.nextInt(n3);
                int n7 = n2 + random.nextInt(n4);
                int n8 = n6;
                int n9 = n7;
                for (int i = 0; i < n5; ++i) {
                    boolean bl = false;
                    for (int j = 0; !bl && j < 4; ++j) {
                        int n10 = ozlu2.func_72825_h(n6, n7);
                        if (xtbl._a(jxsn._b, ozlu2, n6, n10, n7)) {
                            EntityLiving entityLiving;
                            float f = (float)n6 + 0.5f;
                            float f2 = n10;
                            float f3 = (float)n7 + 0.5f;
                            try {
                                entityLiving = (EntityLiving)yffo2._a.getConstructor(ozlu.class).newInstance(ozlu2);
                            }
                            catch (Exception exception) {
                                exception.printStackTrace();
                                continue;
                            }
                            entityLiving.func_70012_b(f, f2, f3, random.nextFloat() * 360.0f, 0.0f);
                            ozlu2.func_72838_d(entityLiving);
                            tupg2 = entityLiving.func_110161_a(tupg2);
                            bl = true;
                        }
                        n6 += random.nextInt(5) - random.nextInt(5);
                        n7 += random.nextInt(5) - random.nextInt(5);
                        while (n6 < n || n6 >= n + n3 || n7 < n2 || n7 >= n2 + n3) {
                            n6 = n8 + random.nextInt(5) - random.nextInt(5);
                            n7 = n9 + random.nextInt(5) - random.nextInt(5);
                        }
                    }
                }
            }
        }
    }
}

