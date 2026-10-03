/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  any
 *  asx
 *  bf
 *  bh
 *  nw
 *  nz
 */
import java.util.List;

final class wi
extends bh {
    wi() {
    }

    protected ye b(bf par1IBlockSource, ye par2ItemStack) {
        bl enumfacing = any.l_((int)par1IBlockSource.h());
        int i2 = par1IBlockSource.d() + enumfacing.c();
        int j2 = par1IBlockSource.e() + enumfacing.d();
        int k2 = par1IBlockSource.f() + enumfacing.e();
        asx axisalignedbb = asx.a().a((double)i2, (double)j2, (double)k2, (double)(i2 + 1), (double)(j2 + 1), (double)(k2 + 1));
        List list = par1IBlockSource.k().a(of.class, axisalignedbb, (nw)new nz(par2ItemStack));
        if (list.size() > 0) {
            of entitylivingbase = (of)list.get(0);
            boolean l2 = entitylivingbase instanceof uf;
            int i1 = og.b(par2ItemStack);
            ye itemstack1 = par2ItemStack.m();
            itemstack1.b = 1;
            entitylivingbase.c(i1, itemstack1);
            if (entitylivingbase instanceof og) {
                ((og)entitylivingbase).a(i1, 2.0f);
            }
            --par2ItemStack.b;
            return par2ItemStack;
        }
        return super.b(par1IBlockSource, par2ItemStack);
    }
}

