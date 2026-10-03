/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ast
 *  asw
 *  bje
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class biz
extends bje {
    private bfr a;

    public void a(asw par1TileEntityPiston, double par2, double par4, double par6, float par8) {
        aqz block = aqz.s[par1TileEntityPiston.a()];
        if (block != null && par1TileEntityPiston.a(par8) < 1.0f) {
            bfq tessellator = bfq.a;
            this.a(bik.b);
            att.a();
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glEnable((int)3042);
            GL11.glDisable((int)2884);
            if (atv.t()) {
                GL11.glShadeModel((int)7425);
            } else {
                GL11.glShadeModel((int)7424);
            }
            tessellator.b();
            tessellator.b((double)((float)par2 - (float)par1TileEntityPiston.l + par1TileEntityPiston.b(par8)), (double)((float)par4 - (float)par1TileEntityPiston.m + par1TileEntityPiston.c(par8)), (double)((float)par6 - (float)par1TileEntityPiston.n + par1TileEntityPiston.d(par8)));
            tessellator.a(1, 1, 1);
            if (block == aqz.af && par1TileEntityPiston.a(par8) < 0.5f) {
                this.a.a(block, par1TileEntityPiston.l, par1TileEntityPiston.m, par1TileEntityPiston.n, false);
            } else if (par1TileEntityPiston.d() && !par1TileEntityPiston.b()) {
                aqz.af.a(((ast)block).q());
                this.a.a((aqz)aqz.af, par1TileEntityPiston.l, par1TileEntityPiston.m, par1TileEntityPiston.n, par1TileEntityPiston.a(par8) < 0.5f);
                aqz.af.q();
                tessellator.b((double)((float)par2 - (float)par1TileEntityPiston.l), (double)((float)par4 - (float)par1TileEntityPiston.m), (double)((float)par6 - (float)par1TileEntityPiston.n));
                this.a.d(block, par1TileEntityPiston.l, par1TileEntityPiston.m, par1TileEntityPiston.n);
            } else {
                this.a.a(block, par1TileEntityPiston.l, par1TileEntityPiston.m, par1TileEntityPiston.n);
            }
            tessellator.b(0.0, 0.0, 0.0);
            tessellator.a();
            att.b();
        }
    }

    public void a(abw par1World) {
        this.a = new bfr(par1World);
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        this.a((asw)par1TileEntity, par2, par4, par6, par8);
    }
}

