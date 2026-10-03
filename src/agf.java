/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ce
 */
public class agf {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    public agf() {
    }

    public agf(int[] par1ArrayOfInteger) {
        if (par1ArrayOfInteger.length == 6) {
            this.a = par1ArrayOfInteger[0];
            this.b = par1ArrayOfInteger[1];
            this.c = par1ArrayOfInteger[2];
            this.d = par1ArrayOfInteger[3];
            this.e = par1ArrayOfInteger[4];
            this.f = par1ArrayOfInteger[5];
        }
    }

    public static agf a() {
        return new agf(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public static agf a(int par0, int par1, int par2, int par3, int par4, int par5, int par6, int par7, int par8, int par9) {
        switch (par9) {
            case 0: {
                return new agf(par0 + par3, par1 + par4, par2 + par5, par0 + par6 - 1 + par3, par1 + par7 - 1 + par4, par2 + par8 - 1 + par5);
            }
            case 1: {
                return new agf(par0 - par8 + 1 + par5, par1 + par4, par2 + par3, par0 + par5, par1 + par7 - 1 + par4, par2 + par6 - 1 + par3);
            }
            case 2: {
                return new agf(par0 + par3, par1 + par4, par2 - par8 + 1 + par5, par0 + par6 - 1 + par3, par1 + par7 - 1 + par4, par2 + par5);
            }
            case 3: {
                return new agf(par0 + par5, par1 + par4, par2 + par3, par0 + par8 - 1 + par5, par1 + par7 - 1 + par4, par2 + par6 - 1 + par3);
            }
        }
        return new agf(par0 + par3, par1 + par4, par2 + par5, par0 + par6 - 1 + par3, par1 + par7 - 1 + par4, par2 + par8 - 1 + par5);
    }

    public agf(agf par1StructureBoundingBox) {
        this.a = par1StructureBoundingBox.a;
        this.b = par1StructureBoundingBox.b;
        this.c = par1StructureBoundingBox.c;
        this.d = par1StructureBoundingBox.d;
        this.e = par1StructureBoundingBox.e;
        this.f = par1StructureBoundingBox.f;
    }

    public agf(int par1, int par2, int par3, int par4, int par5, int par6) {
        this.a = par1;
        this.b = par2;
        this.c = par3;
        this.d = par4;
        this.e = par5;
        this.f = par6;
    }

    public agf(int par1, int par2, int par3, int par4) {
        this.a = par1;
        this.c = par2;
        this.d = par3;
        this.f = par4;
        this.b = 1;
        this.e = 512;
    }

    public boolean a(agf par1StructureBoundingBox) {
        return this.d >= par1StructureBoundingBox.a && this.a <= par1StructureBoundingBox.d && this.f >= par1StructureBoundingBox.c && this.c <= par1StructureBoundingBox.f && this.e >= par1StructureBoundingBox.b && this.b <= par1StructureBoundingBox.e;
    }

    public boolean a(int par1, int par2, int par3, int par4) {
        return this.d >= par1 && this.a <= par3 && this.f >= par2 && this.c <= par4;
    }

    public void b(agf par1StructureBoundingBox) {
        this.a = Math.min(this.a, par1StructureBoundingBox.a);
        this.b = Math.min(this.b, par1StructureBoundingBox.b);
        this.c = Math.min(this.c, par1StructureBoundingBox.c);
        this.d = Math.max(this.d, par1StructureBoundingBox.d);
        this.e = Math.max(this.e, par1StructureBoundingBox.e);
        this.f = Math.max(this.f, par1StructureBoundingBox.f);
    }

    public void a(int par1, int par2, int par3) {
        this.a += par1;
        this.b += par2;
        this.c += par3;
        this.d += par1;
        this.e += par2;
        this.f += par3;
    }

    public boolean b(int par1, int par2, int par3) {
        return par1 >= this.a && par1 <= this.d && par3 >= this.c && par3 <= this.f && par2 >= this.b && par2 <= this.e;
    }

    public int b() {
        return this.d - this.a + 1;
    }

    public int c() {
        return this.e - this.b + 1;
    }

    public int d() {
        return this.f - this.c + 1;
    }

    public int e() {
        return this.a + (this.d - this.a + 1) / 2;
    }

    public int f() {
        return this.b + (this.e - this.b + 1) / 2;
    }

    public int g() {
        return this.c + (this.f - this.c + 1) / 2;
    }

    public String toString() {
        return "(" + this.a + ", " + this.b + ", " + this.c + "; " + this.d + ", " + this.e + ", " + this.f + ")";
    }

    public ce a(String par1Str) {
        return new ce(par1Str, new int[]{this.a, this.b, this.c, this.d, this.e, this.f});
    }
}

