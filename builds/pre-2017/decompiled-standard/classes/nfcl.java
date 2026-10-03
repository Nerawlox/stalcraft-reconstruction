/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.tdpx;

public class nfcl
extends rann {
    public final int field_75993_a;
    public final int field_75991_b;
    public final nfcl field_75992_c;
    public final String field_75996_k;
    public sdqb field_75994_l;
    public final cvzo field_75990_d;
    public boolean field_75995_m;

    public nfcl(int n, String string, int n2, int n3, tgdv tgdv2, nfcl nfcl2) {
        this(n, string, n2, n3, new cvzo(tgdv2), nfcl2);
    }

    public nfcl(int n, String string, int n2, int n3, twgu twgu2, nfcl nfcl2) {
        this(n, string, n2, n3, new cvzo(twgu2), nfcl2);
    }

    public nfcl(int n, String string, int n2, int n3, cvzo cvzo2, nfcl nfcl2) {
        super(0x500000 + n, "achievement." + string);
        this.field_75990_d = cvzo2;
        this.field_75996_k = "achievement." + string + ".desc";
        this.field_75993_a = n2;
        this.field_75991_b = n3;
        if (n2 < sdqa._a) {
            sdqa._a = n2;
        }
        if (n3 < sdqa._b) {
            sdqa._b = n3;
        }
        if (n2 > sdqa._c) {
            sdqa._c = n2;
        }
        if (n3 > sdqa._d) {
            sdqa._d = n3;
        }
        this.field_75992_c = nfcl2;
    }

    public nfcl func_75986_a() {
        this.field_75972_f = true;
        return this;
    }

    public nfcl func_75987_b() {
        this.field_75995_m = true;
        return this;
    }

    public nfcl func_75985_c() {
        super.func_75971_g();
        sdqa._e.add(this);
        return this;
    }

    @Override
    public boolean func_75967_d() {
        return true;
    }

    public String func_75989_e() {
        if (this.field_75994_l != null) {
            return this.field_75994_l._a(tdpx._a(this.field_75996_k));
        }
        return tdpx._a(this.field_75996_k);
    }

    public nfcl func_75988_a(sdqb sdqb2) {
        this.field_75994_l = sdqb2;
        return this;
    }

    public boolean func_75984_f() {
        return this.field_75995_m;
    }

    @Override
    public /* synthetic */ rann func_75971_g() {
        return this.func_75985_c();
    }

    @Override
    public /* synthetic */ rann func_75966_h() {
        return this.func_75986_a();
    }
}

