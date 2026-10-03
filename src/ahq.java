/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abp
 *  aco
 *  ahr
 *  aii
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ahq
extends ain {
    public static ArrayList<acq> allowedBiomes = new ArrayList<acq>(Arrays.asList(acq.d, acq.f, acq.e, acq.h, acq.g, acq.n, acq.o, acq.s, acq.t, acq.v, acq.w, acq.x));
    private acq[] e = allowedBiomes.toArray(new acq[0]);
    private boolean f;
    private abp[] g = new abp[3];
    private double h = 32.0;
    private int i = 3;

    public ahq() {
    }

    public ahq(Map par1Map) {
        for (Map.Entry entry : par1Map.entrySet()) {
            if (((String)entry.getKey()).equals("distance")) {
                this.h = ls.a((String)entry.getValue(), this.h, 1.0);
                continue;
            }
            if (((String)entry.getKey()).equals("count")) {
                this.g = new abp[ls.a((String)entry.getValue(), this.g.length, 1)];
                continue;
            }
            if (!((String)entry.getKey()).equals("spread")) continue;
            this.i = ls.a((String)entry.getValue(), this.i, 1);
        }
    }

    @Override
    public String a() {
        return "Stronghold";
    }

    @Override
    protected boolean a(int par1, int par2) {
        if (!this.f) {
            Random random = new Random();
            random.setSeed(this.c.H());
            double d0 = random.nextDouble() * Math.PI * 2.0;
            int k = 1;
            for (int l = 0; l < this.g.length; ++l) {
                double d1 = (1.25 * (double)k + random.nextDouble()) * this.h * (double)k;
                int i1 = (int)Math.round(Math.cos(d0) * d1);
                int j1 = (int)Math.round(Math.sin(d0) * d1);
                ArrayList arraylist = new ArrayList();
                Collections.addAll(arraylist, this.e);
                aco chunkposition = this.c.u().a((i1 << 4) + 8, (j1 << 4) + 8, 112, arraylist, random);
                if (chunkposition != null) {
                    i1 = chunkposition.a >> 4;
                    j1 = chunkposition.c >> 4;
                }
                this.g[l] = new abp(i1, j1);
                d0 += Math.PI * 2 * (double)k / (double)this.i;
                if (l != this.i) continue;
                k += 2 + random.nextInt(5);
                this.i += 1 + random.nextInt(2);
            }
            this.f = true;
        }
        for (abp chunkcoordintpair : this.g) {
            if (par1 != chunkcoordintpair.a || par2 != chunkcoordintpair.b) continue;
            return true;
        }
        return false;
    }

    @Override
    protected List p_() {
        ArrayList<aco> arraylist = new ArrayList<aco>();
        for (abp chunkcoordintpair : this.g) {
            if (chunkcoordintpair == null) continue;
            arraylist.add(chunkcoordintpair.a(64));
        }
        return arraylist;
    }

    @Override
    protected aiv b(int par1, int par2) {
        ahr structurestrongholdstart = new ahr(this.c, this.b, par1, par2);
        while (structurestrongholdstart.b().isEmpty() || ((aii)structurestrongholdstart.b().get((int)0)).b == null) {
            structurestrongholdstart = new ahr(this.c, this.b, par1, par2);
        }
        return structurestrongholdstart;
    }
}

