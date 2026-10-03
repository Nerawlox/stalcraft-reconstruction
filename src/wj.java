/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  wh
 */
public enum wj {
    a(5, new int[]{1, 3, 2, 1}, 15),
    b(15, new int[]{2, 5, 4, 1}, 12),
    c(15, new int[]{2, 6, 5, 2}, 9),
    d(7, new int[]{2, 5, 3, 1}, 25),
    e(33, new int[]{3, 8, 6, 3}, 10);

    private int f;
    private int[] g;
    private int h;
    public yc customCraftingMaterial = null;

    private wj(int par3, int[] par4ArrayOfInteger, int par5) {
        this.f = par3;
        this.g = par4ArrayOfInteger;
        this.h = par5;
    }

    public int a(int par1) {
        return wh.e()[par1] * this.f;
    }

    public int b(int par1) {
        return this.g[par1];
    }

    public int a() {
        return this.h;
    }

    public int b() {
        switch (this) {
            case a: {
                return yc.aH.cv;
            }
            case b: {
                return yc.q.cv;
            }
            case d: {
                return yc.r.cv;
            }
            case c: {
                return yc.q.cv;
            }
            case e: {
                return yc.p.cv;
            }
        }
        return this.customCraftingMaterial == null ? 0 : this.customCraftingMaterial.cv;
    }
}

