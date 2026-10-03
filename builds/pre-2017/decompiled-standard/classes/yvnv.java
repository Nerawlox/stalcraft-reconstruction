/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.sajh;
import net.minecraft.util.zwat;

public class yvnv
extends ohnk {
    @Override
    public String func_71517_b() {
        return "spreadplayers";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.spreadplayers.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length < 6) {
            throw new pksd("commands.spreadplayers.usage", new Object[0]);
        }
        int n = 0;
        double d = yvnv.func_110666_a(nemo2, Double.NaN, stringArray[n++]);
        double d2 = yvnv.func_110666_a(nemo2, Double.NaN, stringArray[n++]);
        double d3 = yvnv.func_110664_a(nemo2, stringArray[n++], 0.0);
        double d4 = yvnv.func_110664_a(nemo2, stringArray[n++], d3 + 1.0);
        boolean bl = yvnv.func_110662_c(nemo2, stringArray[n++]);
        ArrayList<EntityPlayerMP[]> arrayList = Lists.newArrayList();
        while (n < stringArray.length) {
            Object object;
            String string;
            if (zhop._b(string = stringArray[n++])) {
                object = zhop._c(nemo2, string);
                if (object != null && ((EntityPlayerMP[])object).length != 0) {
                    Collections.addAll(arrayList, object);
                    continue;
                }
                throw new mskk();
            }
            object = dzfd._I().__ag()._h(string);
            if (object != null) {
                arrayList.add((EntityPlayerMP[])object);
                continue;
            }
            throw new mskk();
        }
        if (arrayList.isEmpty()) {
            throw new mskk();
        }
        nemo2.func_70006_a(zwat._b("commands.spreadplayers.spreading." + (bl ? "teams" : "players"), yvnv.func_110663_b(arrayList), d, d2, d3, d4));
        this._a(nemo2, arrayList, new zhpf(d, d2), d3, d4, ((EntityLivingBase)arrayList.get((int)0)).field_70170_p, bl);
    }

    public void _a(nemo nemo2, List list, zhpf zhpf2, double d, double d2, ozlu ozlu2, boolean bl) {
        Random random = new Random();
        double d3 = zhpf2._a - d2;
        double d4 = zhpf2._b - d2;
        double d5 = zhpf2._a + d2;
        double d6 = zhpf2._b + d2;
        zhpf[] zhpfArray = this._a(random, bl ? this._a(list) : list.size(), d3, d4, d5, d6);
        int n = this._a(zhpf2, d, ozlu2, random, d3, d4, d5, d6, zhpfArray, bl);
        double d7 = this._a(list, ozlu2, zhpfArray, bl);
        yvnv.func_71522_a(nemo2, "commands.spreadplayers.success." + (bl ? "teams" : "players"), zhpfArray.length, zhpf2._a, zhpf2._b);
        if (zhpfArray.length > 1) {
            nemo2.func_70006_a(zwat._b("commands.spreadplayers.info." + (bl ? "teams" : "players"), String.format("%.2f", d7), n));
        }
    }

    public int _a(List list) {
        HashSet<cwci> hashSet = Sets.newHashSet();
        for (EntityLivingBase entityLivingBase : list) {
            if (entityLivingBase instanceof EntityPlayer) {
                hashSet.add(((EntityPlayer)entityLivingBase).func_96124_cp());
                continue;
            }
            hashSet.add(null);
        }
        return hashSet.size();
    }

    public int _a(zhpf zhpf2, double d, ozlu ozlu2, Random random, double d2, double d3, double d4, double d5, zhpf[] zhpfArray, boolean bl) {
        int n;
        boolean bl2 = true;
        double d6 = 3.4028234663852886E38;
        for (n = 0; n < 10000 && bl2; ++n) {
            bl2 = false;
            d6 = 3.4028234663852886E38;
            for (int i = 0; i < zhpfArray.length; ++i) {
                zhpf zhpf3 = zhpfArray[i];
                int n2 = 0;
                zhpf zhpf4 = new zhpf();
                for (int j = 0; j < zhpfArray.length; ++j) {
                    if (i == j) continue;
                    zhpf zhpf5 = zhpfArray[j];
                    double d7 = zhpf3._a(zhpf5);
                    d6 = Math.min(d7, d6);
                    if (!(d7 < d)) continue;
                    ++n2;
                    zhpf4._a += zhpf5._a - zhpf3._a;
                    zhpf4._b += zhpf5._b - zhpf3._b;
                }
                if (n2 > 0) {
                    zhpf4._a /= (double)n2;
                    zhpf4._b /= (double)n2;
                    double d8 = zhpf4._b();
                    if (d8 > 0.0) {
                        zhpf4._a();
                        zhpf3._b(zhpf4);
                    } else {
                        zhpf3._a(random, d2, d3, d4, d5);
                    }
                    bl2 = true;
                }
                if (!zhpf3._a(d2, d3, d4, d5)) continue;
                bl2 = true;
            }
            if (bl2) continue;
            for (zhpf zhpf4 : zhpfArray) {
                if (zhpf4._b(ozlu2)) continue;
                zhpf4._a(random, d2, d3, d4, d5);
                bl2 = true;
            }
        }
        if (n >= 10000) {
            throw new cekk("commands.spreadplayers.failure." + (bl ? "teams" : "players"), zhpfArray.length, zhpf2._a, zhpf2._b, String.format("%.2f", d6));
        }
        return n;
    }

    public double _a(List list, ozlu ozlu2, zhpf[] zhpfArray, boolean bl) {
        double d = 0.0;
        int n = 0;
        HashMap<cwci, zhpf> hashMap = Maps.newHashMap();
        for (int i = 0; i < list.size(); ++i) {
            zhpf zhpf2;
            EntityLivingBase entityLivingBase = (EntityLivingBase)list.get(i);
            if (bl) {
                cwci cwci2;
                cwci cwci3 = cwci2 = entityLivingBase instanceof EntityPlayer ? ((EntityPlayer)entityLivingBase).func_96124_cp() : null;
                if (!hashMap.containsKey(cwci2)) {
                    hashMap.put(cwci2, zhpfArray[n++]);
                }
                zhpf2 = (zhpf)hashMap.get(cwci2);
            } else {
                zhpf2 = zhpfArray[n++];
            }
            entityLivingBase.func_70634_a((float)sajh._c(zhpf2._a) + 0.5f, zhpf2._a(ozlu2), (double)sajh._c(zhpf2._b) + 0.5);
            double d2 = Double.MAX_VALUE;
            for (int j = 0; j < zhpfArray.length; ++j) {
                if (zhpf2 == zhpfArray[j]) continue;
                double d3 = zhpf2._a(zhpfArray[j]);
                d2 = Math.min(d3, d2);
            }
            d += d2;
        }
        return d /= (double)list.size();
    }

    public zhpf[] _a(Random random, int n, double d, double d2, double d3, double d4) {
        zhpf[] zhpfArray = new zhpf[n];
        for (int i = 0; i < zhpfArray.length; ++i) {
            zhpf zhpf2 = new zhpf();
            zhpf2._a(random, d, d2, d3, d4);
            zhpfArray[i] = zhpf2;
        }
        return zhpfArray;
    }
}

