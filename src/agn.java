/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acr
 *  ago
 *  tl
 *  tn
 */
import java.util.ArrayList;
import java.util.List;

public class agn
extends ain {
    private List e = new ArrayList();

    public agn() {
        this.e.add(new acr(td.class, 10, 2, 3));
        this.e.add(new acr(tn.class, 5, 4, 4));
        this.e.add(new acr(tr.class, 10, 4, 4));
        this.e.add(new acr(tl.class, 3, 4, 4));
    }

    @Override
    public String a() {
        return "Fortress";
    }

    public List b() {
        return this.e;
    }

    @Override
    protected boolean a(int par1, int par2) {
        int k = par1 >> 4;
        int l = par2 >> 4;
        this.b.setSeed((long)(k ^ l << 4) ^ this.c.H());
        this.b.nextInt();
        return this.b.nextInt(3) != 0 ? false : (par1 != (k << 4) + 4 + this.b.nextInt(8) ? false : par2 == (l << 4) + 4 + this.b.nextInt(8));
    }

    @Override
    protected aiv b(int par1, int par2) {
        return new ago(this.c, this.b, par1, par2);
    }
}

