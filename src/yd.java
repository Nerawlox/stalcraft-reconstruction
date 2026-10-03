/*
 * Decompiled with CFR 0.152.
 */
public enum yd {
    a(0, 59, 2.0f, 0.0f, 15),
    b(1, 131, 4.0f, 1.0f, 5),
    c(2, 250, 6.0f, 2.0f, 14),
    d(3, 1561, 8.0f, 3.0f, 10),
    e(0, 32, 12.0f, 0.0f, 22);

    private final int f;
    private final int g;
    private final float h;
    private final float i;
    private final int j;
    public yc customCraftingMaterial = null;

    private yd(int par3, int par4, float par5, float par6, int par7) {
        this.f = par3;
        this.g = par4;
        this.h = par5;
        this.i = par6;
        this.j = par7;
    }

    public int a() {
        return this.g;
    }

    public float b() {
        return this.h;
    }

    public float c() {
        return this.i;
    }

    public int d() {
        return this.f;
    }

    public int e() {
        return this.j;
    }

    public int f() {
        switch (this) {
            case a: {
                return aqz.C.cF;
            }
            case b: {
                return aqz.B.cF;
            }
            case e: {
                return yc.r.cv;
            }
            case c: {
                return yc.q.cv;
            }
            case d: {
                return yc.p.cv;
            }
        }
        return this.customCraftingMaterial == null ? 0 : this.customCraftingMaterial.cv;
    }
}

