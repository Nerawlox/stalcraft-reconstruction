/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ps
 */
public class ql
extends ps {
    private og a;
    private double b;
    private double c;
    private int d;

    public ql(og par1EntityLiving) {
        this.a = par1EntityLiving;
        this.a(3);
    }

    public boolean a() {
        return this.a.aD().nextFloat() < 0.02f;
    }

    public boolean b() {
        return this.d >= 0;
    }

    public void c() {
        double d0 = Math.PI * 2 * this.a.aD().nextDouble();
        this.b = Math.cos(d0);
        this.c = Math.sin(d0);
        this.d = 20 + this.a.aD().nextInt(20);
    }

    public void e() {
        --this.d;
        this.a.h().a(this.a.u + this.b, this.a.v + (double)this.a.f(), this.a.w + this.c, 10.0f, this.a.bp());
    }
}

