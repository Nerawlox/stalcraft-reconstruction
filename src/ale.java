/*
 * Decompiled with CFR 0.152.
 */
public class ale {
    public final int a;
    public final int b;
    public final int c;
    private final int j;
    int d = -1;
    float e;
    float f;
    float g;
    ale h;
    public boolean i;

    public ale(int par1, int par2, int par3) {
        this.a = par1;
        this.b = par2;
        this.c = par3;
        this.j = ale.a(par1, par2, par3);
    }

    public static int a(int par0, int par1, int par2) {
        return par1 & 0xFF | (par0 & Short.MAX_VALUE) << 8 | (par2 & Short.MAX_VALUE) << 24 | (par0 < 0 ? Integer.MIN_VALUE : 0) | (par2 < 0 ? 32768 : 0);
    }

    public float a(ale par1PathPoint) {
        float f = par1PathPoint.a - this.a;
        float f1 = par1PathPoint.b - this.b;
        float f2 = par1PathPoint.c - this.c;
        return ls.c(f * f + f1 * f1 + f2 * f2);
    }

    public float b(ale par1PathPoint) {
        float f = par1PathPoint.a - this.a;
        float f1 = par1PathPoint.b - this.b;
        float f2 = par1PathPoint.c - this.c;
        return f * f + f1 * f1 + f2 * f2;
    }

    public boolean equals(Object par1Obj) {
        if (!(par1Obj instanceof ale)) {
            return false;
        }
        ale pathpoint = (ale)par1Obj;
        return this.j == pathpoint.j && this.a == pathpoint.a && this.b == pathpoint.b && this.c == pathpoint.c;
    }

    public int hashCode() {
        return this.j;
    }

    public boolean a() {
        return this.d >= 0;
    }

    public String toString() {
        return this.a + ", " + this.b + ", " + this.c;
    }
}

