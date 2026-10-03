/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  amx
 */
public class arq
extends amx {
    private final int a;

    protected arq(int par1, String par2Str, akc par3Material, int par4) {
        super(par1, par2Str, par3Material);
        this.a = par4;
    }

    protected int e(abw par1World, int par2, int par3, int par4) {
        int l = 0;
        for (ss entityitem : par1World.a(ss.class, this.a(par2, par3, par4))) {
            if ((l += entityitem.d().b) < this.a) continue;
            break;
        }
        if (l <= 0) {
            return 0;
        }
        float f = (float)Math.min(this.a, l) / (float)this.a;
        return ls.f(f * 15.0f);
    }

    protected int c(int par1) {
        return par1;
    }

    protected int d(int par1) {
        return par1;
    }

    public int a(abw par1World) {
        return 10;
    }
}

