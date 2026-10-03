/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bje
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class biu
extends bje {
    private static final bjo a = new bjo("textures/entity/beacon_beam.png");

    public void a(arw par1TileEntityBeacon, double par2, double par4, double par6, float par8) {
        float f1 = par1TileEntityBeacon.v_();
        if (f1 > 0.0f) {
            bfq tessellator = bfq.a;
            this.a(a);
            GL11.glTexParameterf((int)3553, (int)10242, (float)10497.0f);
            GL11.glTexParameterf((int)3553, (int)10243, (float)10497.0f);
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2884);
            GL11.glDisable((int)3042);
            GL11.glDepthMask((boolean)true);
            GL11.glBlendFunc((int)770, (int)1);
            float f2 = (float)par1TileEntityBeacon.az().I() + par8;
            float f3 = -f2 * 0.2f - (float)ls.d(-f2 * 0.1f);
            boolean b0 = true;
            double d3 = (double)f2 * 0.025 * (1.0 - (double)(b0 & true) * 2.5);
            tessellator.b();
            tessellator.a(255, 255, 255, 32);
            double d4 = (double)b0 * 0.2;
            double d5 = 0.5 + Math.cos(d3 + 2.356194490192345) * d4;
            double d6 = 0.5 + Math.sin(d3 + 2.356194490192345) * d4;
            double d7 = 0.5 + Math.cos(d3 + 0.7853981633974483) * d4;
            double d8 = 0.5 + Math.sin(d3 + 0.7853981633974483) * d4;
            double d9 = 0.5 + Math.cos(d3 + 3.9269908169872414) * d4;
            double d10 = 0.5 + Math.sin(d3 + 3.9269908169872414) * d4;
            double d11 = 0.5 + Math.cos(d3 + 5.497787143782138) * d4;
            double d12 = 0.5 + Math.sin(d3 + 5.497787143782138) * d4;
            double d13 = 256.0f * f1;
            double d14 = 0.0;
            double d15 = 1.0;
            double d16 = -1.0f + f3;
            double d17 = (double)(256.0f * f1) * (0.5 / d4) + d16;
            tessellator.a(par2 + d5, par4 + d13, par6 + d6, d15, d17);
            tessellator.a(par2 + d5, par4, par6 + d6, d15, d16);
            tessellator.a(par2 + d7, par4, par6 + d8, d14, d16);
            tessellator.a(par2 + d7, par4 + d13, par6 + d8, d14, d17);
            tessellator.a(par2 + d11, par4 + d13, par6 + d12, d15, d17);
            tessellator.a(par2 + d11, par4, par6 + d12, d15, d16);
            tessellator.a(par2 + d9, par4, par6 + d10, d14, d16);
            tessellator.a(par2 + d9, par4 + d13, par6 + d10, d14, d17);
            tessellator.a(par2 + d7, par4 + d13, par6 + d8, d15, d17);
            tessellator.a(par2 + d7, par4, par6 + d8, d15, d16);
            tessellator.a(par2 + d11, par4, par6 + d12, d14, d16);
            tessellator.a(par2 + d11, par4 + d13, par6 + d12, d14, d17);
            tessellator.a(par2 + d9, par4 + d13, par6 + d10, d15, d17);
            tessellator.a(par2 + d9, par4, par6 + d10, d15, d16);
            tessellator.a(par2 + d5, par4, par6 + d6, d14, d16);
            tessellator.a(par2 + d5, par4 + d13, par6 + d6, d14, d17);
            tessellator.a();
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glDepthMask((boolean)false);
            tessellator.b();
            tessellator.a(255, 255, 255, 32);
            double d18 = 0.2;
            double d19 = 0.2;
            double d20 = 0.8;
            double d21 = 0.2;
            double d22 = 0.2;
            double d23 = 0.8;
            double d24 = 0.8;
            double d25 = 0.8;
            double d26 = 256.0f * f1;
            double d27 = 0.0;
            double d28 = 1.0;
            double d29 = -1.0f + f3;
            double d30 = (double)(256.0f * f1) + d29;
            tessellator.a(par2 + d18, par4 + d26, par6 + d19, d28, d30);
            tessellator.a(par2 + d18, par4, par6 + d19, d28, d29);
            tessellator.a(par2 + d20, par4, par6 + d21, d27, d29);
            tessellator.a(par2 + d20, par4 + d26, par6 + d21, d27, d30);
            tessellator.a(par2 + d24, par4 + d26, par6 + d25, d28, d30);
            tessellator.a(par2 + d24, par4, par6 + d25, d28, d29);
            tessellator.a(par2 + d22, par4, par6 + d23, d27, d29);
            tessellator.a(par2 + d22, par4 + d26, par6 + d23, d27, d30);
            tessellator.a(par2 + d20, par4 + d26, par6 + d21, d28, d30);
            tessellator.a(par2 + d20, par4, par6 + d21, d28, d29);
            tessellator.a(par2 + d24, par4, par6 + d25, d27, d29);
            tessellator.a(par2 + d24, par4 + d26, par6 + d25, d27, d30);
            tessellator.a(par2 + d22, par4 + d26, par6 + d23, d28, d30);
            tessellator.a(par2 + d22, par4, par6 + d23, d28, d29);
            tessellator.a(par2 + d18, par4, par6 + d19, d27, d29);
            tessellator.a(par2 + d18, par4 + d26, par6 + d19, d27, d30);
            tessellator.a();
            GL11.glEnable((int)2896);
            GL11.glEnable((int)3553);
            GL11.glDepthMask((boolean)true);
        }
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        this.a((arw)par1TileEntity, par2, par4, par6, par8);
    }
}

