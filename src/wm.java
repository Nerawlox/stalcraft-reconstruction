/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  ata
 *  atc
 */
import java.util.List;

public class wm
extends yc {
    public wm(int par1) {
        super(par1);
        this.cw = 1;
        this.a(ww.e);
    }

    @Override
    public ye a(ye par1ItemStack, abw par2World, uf par3EntityPlayer) {
        int i2;
        float f8;
        float f6;
        double d3;
        float f5;
        float f2 = 1.0f;
        float f1 = par3EntityPlayer.D + (par3EntityPlayer.B - par3EntityPlayer.D) * f2;
        float f22 = par3EntityPlayer.C + (par3EntityPlayer.A - par3EntityPlayer.C) * f2;
        double d0 = par3EntityPlayer.r + (par3EntityPlayer.u - par3EntityPlayer.r) * (double)f2;
        double d1 = par3EntityPlayer.s + (par3EntityPlayer.v - par3EntityPlayer.s) * (double)f2 + 1.62 - (double)par3EntityPlayer.N;
        double d2 = par3EntityPlayer.t + (par3EntityPlayer.w - par3EntityPlayer.t) * (double)f2;
        atc vec3 = par2World.V().a(d0, d1, d2);
        float f3 = ls.b(-f22 * ((float)Math.PI / 180) - (float)Math.PI);
        float f4 = ls.a(-f22 * ((float)Math.PI / 180) - (float)Math.PI);
        float f7 = f4 * (f5 = -ls.b(-f1 * ((float)Math.PI / 180)));
        atc vec31 = vec3.c((double)f7 * (d3 = 5.0), (double)(f6 = ls.a(-f1 * ((float)Math.PI / 180))) * d3, (double)(f8 = f3 * f5) * d3);
        ata movingobjectposition = par2World.a(vec3, vec31, true);
        if (movingobjectposition == null) {
            return par1ItemStack;
        }
        atc vec32 = par3EntityPlayer.j(f2);
        boolean flag = false;
        float f9 = 1.0f;
        List list = par2World.b((nn)par3EntityPlayer, par3EntityPlayer.E.a(vec32.c * d3, vec32.d * d3, vec32.e * d3).b((double)f9, (double)f9, (double)f9));
        for (i2 = 0; i2 < list.size(); ++i2) {
            float f10;
            asx axisalignedbb;
            nn entity = (nn)list.get(i2);
            if (!entity.L() || !(axisalignedbb = entity.E.b((double)(f10 = entity.Z()), (double)f10, (double)f10)).a(vec3)) continue;
            flag = true;
        }
        if (flag) {
            return par1ItemStack;
        }
        if (movingobjectposition.a == atb.a) {
            i2 = movingobjectposition.b;
            int j2 = movingobjectposition.c;
            int k2 = movingobjectposition.d;
            if (par2World.a(i2, j2, k2) == aqz.aX.cF) {
                --j2;
            }
            sq entityboat = new sq(par2World, (float)i2 + 0.5f, (float)j2 + 1.0f, (float)k2 + 0.5f);
            entityboat.A = ((ls.c((double)(par3EntityPlayer.A * 4.0f / 360.0f) + 0.5) & 3) - 1) * 90;
            if (!par2World.a((nn)entityboat, entityboat.E.b(-0.1, -0.1, -0.1)).isEmpty()) {
                return par1ItemStack;
            }
            if (!par2World.I) {
                par2World.d(entityboat);
            }
            if (!par3EntityPlayer.bG.d) {
                --par1ItemStack.b;
            }
        }
        return par1ItemStack;
    }
}

