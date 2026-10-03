/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  nb
 */
public class mz {
    private final nb a;
    private final int b;
    private final float c;
    private final float d;
    private final String e;
    private final float f;

    public mz(nb par1DamageSource, int par2, float par3, float par4, String par5Str, float par6) {
        this.a = par1DamageSource;
        this.b = par2;
        this.c = par4;
        this.d = par3;
        this.e = par5Str;
        this.f = par6;
    }

    public nb a() {
        return this.a;
    }

    public float c() {
        return this.c;
    }

    public boolean f() {
        return this.a.i() instanceof of;
    }

    public String g() {
        return this.e;
    }

    public String h() {
        return this.a().i() == null ? null : this.a().i().ay();
    }

    public float i() {
        return this.a == nb.i ? Float.MAX_VALUE : this.f;
    }
}

