/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  amx
 */
import java.util.List;

public class apw
extends amx {
    private apx a;

    protected apw(int par1, String par2Str, akc par3Material, apx par4EnumMobType) {
        super(par1, par2Str, par3Material);
        this.a = par4EnumMobType;
    }

    protected int d(int par1) {
        return par1 > 0 ? 1 : 0;
    }

    protected int c(int par1) {
        return par1 == 1 ? 15 : 0;
    }

    protected int e(abw par1World, int par2, int par3, int par4) {
        List list = null;
        if (this.a == apx.a) {
            list = par1World.b((nn)null, this.a(par2, par3, par4));
        }
        if (this.a == apx.b) {
            list = par1World.a(of.class, this.a(par2, par3, par4));
        }
        if (this.a == apx.c) {
            list = par1World.a(uf.class, this.a(par2, par3, par4));
        }
        if (list != null && !list.isEmpty()) {
            for (nn entity : list) {
                if (entity.au()) continue;
                return 15;
            }
        }
        return 0;
    }
}

