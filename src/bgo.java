/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  amv
 *  aob
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 *  sr
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bgo
extends bgm {
    private final bfr a = new bfr();

    public bgo() {
        this.d = 0.5f;
    }

    public void a(sr par1EntityFallingSand, double par2, double par4, double par6, float par8, float par9) {
        abw world = par1EntityFallingSand.c();
        aqz block = aqz.s[par1EntityFallingSand.a];
        if (world.a(ls.c(par1EntityFallingSand.u), ls.c(par1EntityFallingSand.v), ls.c(par1EntityFallingSand.w)) != par1EntityFallingSand.a) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
            this.b((nn)par1EntityFallingSand);
            GL11.glDisable((int)2896);
            if (block instanceof amv && block.d() == 35) {
                this.a.a = world;
                bfq tessellator = bfq.a;
                tessellator.b();
                tessellator.b((double)((float)(-ls.c(par1EntityFallingSand.u)) - 0.5f), (double)((float)(-ls.c(par1EntityFallingSand.v)) - 0.5f), (double)((float)(-ls.c(par1EntityFallingSand.w)) - 0.5f));
                this.a.a((amv)block, ls.c(par1EntityFallingSand.u), ls.c(par1EntityFallingSand.v), ls.c(par1EntityFallingSand.w), par1EntityFallingSand.b);
                tessellator.b(0.0, 0.0, 0.0);
                tessellator.a();
            } else if (block.d() == 27) {
                this.a.a = world;
                bfq tessellator = bfq.a;
                tessellator.b();
                tessellator.b((double)((float)(-ls.c(par1EntityFallingSand.u)) - 0.5f), (double)((float)(-ls.c(par1EntityFallingSand.v)) - 0.5f), (double)((float)(-ls.c(par1EntityFallingSand.w)) - 0.5f));
                this.a.a((aob)block, ls.c(par1EntityFallingSand.u), ls.c(par1EntityFallingSand.v), ls.c(par1EntityFallingSand.w));
                tessellator.b(0.0, 0.0, 0.0);
                tessellator.a();
            } else if (block != null) {
                this.a.a(block);
                this.a.a(block, world, ls.c(par1EntityFallingSand.u), ls.c(par1EntityFallingSand.v), ls.c(par1EntityFallingSand.w), par1EntityFallingSand.b);
            }
            GL11.glEnable((int)2896);
            GL11.glPopMatrix();
        }
    }

    protected bjo a(sr par1EntityFallingSand) {
        return bik.b;
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((sr)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((sr)par1Entity, par2, par4, par6, par8, par9);
    }
}

