/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.matmos.conv.Processor;
import eu.ha3.matmos.engine.implem.IntegerData;
import eu.ha3.matmos.game.data.MAtProcessorModel;
import eu.ha3.matmos.game.system.MAtMod;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.jgro;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;

public class MAtProcessorEntityDetector
implements Processor {
    private eidj bbox;
    private int max;
    private MAtProcessorModel mindistModel;
    private Map<Integer, Double> mindistMappy;
    private MAtProcessorModel[] radiModels;
    private int[] radi;
    private Map<Integer, Integer>[] mappies;
    private int maxel;
    private boolean isRequired;

    public MAtProcessorEntityDetector(MAtMod mAtMod, IntegerData integerData, String string, String string2, String string3, int n, int ... nArray) {
        this.mindistModel = new MAtProcessorModel(mAtMod, integerData, string, string + string3){

            @Override
            protected void doProcess() {
            }
        };
        this.mindistMappy = new HashMap<Integer, Double>();
        this.radiModels = new MAtProcessorModel[nArray.length];
        this.mappies = new Map[nArray.length];
        this.radi = Arrays.copyOf(nArray, nArray.length);
        Arrays.sort(this.radi);
        this.maxel = this.radi[this.radi.length - 1] + 10;
        for (int i = 0; i < this.radi.length; ++i) {
            int n2 = this.radi[i];
            this.radiModels[i] = new MAtProcessorModel(mAtMod, integerData, string2 + n2, string2 + n2 + string3){

                @Override
                protected void doProcess() {
                }
            };
            this.mappies[i] = new HashMap<Integer, Integer>();
        }
        this.bbox = eidj._a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        this.max = n;
    }

    public void refresh() {
        this.isRequired = false;
        this.mindistModel.process();
        this.isRequired = this.mindistModel.isRequired();
        for (MAtProcessorModel object : this.radiModels) {
            object.process();
            this.isRequired = this.isRequired || object.isRequired();
        }
        for (Map<Integer, Integer> map : this.mappies) {
            map.clear();
        }
        this.mindistMappy.clear();
    }

    @Override
    public void process() {
        this.refresh();
        if (!this.isRequired) {
            return;
        }
        xpzm xpzm2 = xpzm._E();
        double d = xpzm2._t.field_70165_t;
        double d2 = xpzm2._t.field_70163_u;
        double d3 = xpzm2._t.field_70161_v;
        this.bbox._b(d - (double)this.maxel, d2 - (double)this.maxel, d3 - (double)this.maxel, d + (double)this.maxel, d2 + (double)this.maxel, d3 + (double)this.maxel);
        List list = xpzm2._r.func_72872_a(Entity.class, this.bbox);
        for (Entity entity : list) {
            int n;
            if (entity == null || entity == xpzm2._t) continue;
            double d4 = entity.field_70165_t - d;
            double d5 = entity.field_70163_u - d2;
            double d6 = entity.field_70161_v - d3;
            double d7 = Math.sqrt(d4 * d4 + d5 * d5 + d6 * d6);
            if (entity instanceof EntityPlayer) {
                this.mindist(0, d7);
            } else {
                n = jgro._a(entity);
                if (n != 0) {
                    this.mindist(n, d7);
                }
            }
            n = 0;
            while (n < this.radi.length) {
                if (d7 <= (double)this.radi[n]) {
                    for (int i = n; i < this.radi.length; ++i) {
                        if (entity instanceof EntityPlayer) {
                            this.add(i, 0, 1);
                            continue;
                        }
                        int n2 = jgro._a(entity);
                        if (n2 == 0) continue;
                        this.add(i, n2, 1);
                    }
                    n = this.radi.length;
                    continue;
                }
                ++n;
            }
        }
        for (int i = 0; i < this.max; ++i) {
            for (int j = 0; j < this.radi.length; ++j) {
                if (!this.radiModels[j].isRequired()) continue;
                if (this.mappies[j].containsKey(i)) {
                    this.radiModels[j].setValue(i, this.mappies[j].get(i));
                    continue;
                }
                this.radiModels[j].setValue(i, 0);
            }
            if (!this.mindistModel.isRequired()) continue;
            if (this.mindistMappy.containsKey(i)) {
                this.mindistModel.setValue(i, (int)Math.floor(this.mindistMappy.get(i) * 1000.0));
                continue;
            }
            this.mindistModel.setValue(i, Integer.MAX_VALUE);
        }
    }

    protected void add(int n, int n2, int n3) {
        if (this.mappies[n].containsKey(n2)) {
            this.mappies[n].put(n2, this.mappies[n].get(n2) + n3);
        } else {
            this.mappies[n].put(n2, n3);
        }
    }

    protected void mindist(int n, double d) {
        if (!this.mindistMappy.containsKey(n) || this.mindistMappy.get(n) > d) {
            this.mindistMappy.put(n, d);
        }
    }
}

