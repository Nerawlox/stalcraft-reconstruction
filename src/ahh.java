/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acr
 *  ahi
 *  ahp
 *  ait
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ahh
extends ain {
    private static List e = Arrays.asList(acq.d, acq.s, acq.w, acq.x, acq.h);
    private List f = new ArrayList();
    private int g = 32;
    private int h = 8;

    public ahh() {
        this.f.add(new acr(tv.class, 1, 1, 1));
    }

    public ahh(Map par1Map) {
        this();
        for (Map.Entry entry : par1Map.entrySet()) {
            if (!((String)entry.getKey()).equals("distance")) continue;
            this.g = ls.a((String)entry.getValue(), this.g, this.h + 1);
        }
    }

    @Override
    public String a() {
        return "Temple";
    }

    @Override
    protected boolean a(int par1, int par2) {
        int k = par1;
        int l = par2;
        if (par1 < 0) {
            par1 -= this.g - 1;
        }
        if (par2 < 0) {
            par2 -= this.g - 1;
        }
        int i1 = par1 / this.g;
        int j1 = par2 / this.g;
        Random random = this.c.H(i1, j1, 14357617);
        i1 *= this.g;
        j1 *= this.g;
        if (k == (i1 += random.nextInt(this.g - this.h)) && l == (j1 += random.nextInt(this.g - this.h))) {
            acq biomegenbase = this.c.u().a(k * 16 + 8, l * 16 + 8);
            for (acq biomegenbase1 : e) {
                if (biomegenbase != biomegenbase1) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    protected aiv b(int par1, int par2) {
        return new ahi(this.c, this.b, par1, par2);
    }

    public boolean a(int par1, int par2, int par3) {
        aiv structurestart = this.c(par1, par2, par3);
        if (structurestart != null && structurestart instanceof ahi && !structurestart.a.isEmpty()) {
            ait structurecomponent = (ait)structurestart.a.getFirst();
            return structurecomponent instanceof ahp;
        }
        return false;
    }

    public List b() {
        return this.f;
    }
}

