/*
 * Decompiled with CFR 0.152.
 */
public class ald {
    private ale[] a = new ale[1024];
    private int b;

    public ale a(ale par1PathPoint) {
        if (par1PathPoint.d >= 0) {
            throw new IllegalStateException("OW KNOWS!");
        }
        if (this.b == this.a.length) {
            ale[] apathpoint = new ale[this.b << 1];
            System.arraycopy(this.a, 0, apathpoint, 0, this.b);
            this.a = apathpoint;
        }
        this.a[this.b] = par1PathPoint;
        par1PathPoint.d = this.b;
        this.a(this.b++);
        return par1PathPoint;
    }

    public void a() {
        this.b = 0;
    }

    public ale c() {
        ale pathpoint = this.a[0];
        this.a[0] = this.a[--this.b];
        this.a[this.b] = null;
        if (this.b > 0) {
            this.b(0);
        }
        pathpoint.d = -1;
        return pathpoint;
    }

    public void a(ale par1PathPoint, float par2) {
        float f1 = par1PathPoint.g;
        par1PathPoint.g = par2;
        if (par2 < f1) {
            this.a(par1PathPoint.d);
        } else {
            this.b(par1PathPoint.d);
        }
    }

    private void a(int par1) {
        ale pathpoint = this.a[par1];
        float f = pathpoint.g;
        while (par1 > 0) {
            int j2 = par1 - 1 >> 1;
            ale pathpoint1 = this.a[j2];
            if (f >= pathpoint1.g) break;
            this.a[par1] = pathpoint1;
            pathpoint1.d = par1;
            par1 = j2;
        }
        this.a[par1] = pathpoint;
        pathpoint.d = par1;
    }

    private void b(int par1) {
        ale pathpoint = this.a[par1];
        float f = pathpoint.g;
        while (true) {
            float f2;
            ale pathpoint2;
            int j2 = 1 + (par1 << 1);
            int k = j2 + 1;
            if (j2 >= this.b) break;
            ale pathpoint1 = this.a[j2];
            float f1 = pathpoint1.g;
            if (k >= this.b) {
                pathpoint2 = null;
                f2 = Float.POSITIVE_INFINITY;
            } else {
                pathpoint2 = this.a[k];
                f2 = pathpoint2.g;
            }
            if (f1 < f2) {
                if (f1 >= f) break;
                this.a[par1] = pathpoint1;
                pathpoint1.d = par1;
                par1 = j2;
                continue;
            }
            if (f2 >= f) break;
            this.a[par1] = pathpoint2;
            pathpoint2.d = par1;
            par1 = k;
        }
        this.a[par1] = pathpoint;
        pathpoint.d = par1;
    }

    public boolean e() {
        return this.b == 0;
    }
}

