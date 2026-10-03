/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 *  tb
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bhr
extends bhc {
    protected void a(tb par1EntityMinecartTNT, float par2, aqz par3Block, int par4) {
        int j2 = par1EntityMinecartTNT.e();
        if (j2 > -1 && (float)j2 - par2 + 1.0f < 10.0f) {
            float f1 = 1.0f - ((float)j2 - par2 + 1.0f) / 10.0f;
            if (f1 < 0.0f) {
                f1 = 0.0f;
            }
            if (f1 > 1.0f) {
                f1 = 1.0f;
            }
            f1 *= f1;
            f1 *= f1;
            float f2 = 1.0f + f1 * 0.3f;
            GL11.glScalef((float)f2, (float)f2, (float)f2);
        }
        super.a((st)par1EntityMinecartTNT, par2, par3Block, par4);
        if (j2 > -1 && j2 / 5 % 2 == 0) {
            GL11.glDisable((int)3553);
            GL11.glDisable((int)2896);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)772);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)((1.0f - ((float)j2 - par2 + 1.0f) / 100.0f) * 0.8f));
            GL11.glPushMatrix();
            this.f.a(aqz.ar, 0, 1.0f);
            GL11.glPopMatrix();
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDisable((int)3042);
            GL11.glEnable((int)2896);
            GL11.glEnable((int)3553);
        }
    }

    @Override
    protected void a(st par1EntityMinecart, float par2, aqz par3Block, int par4) {
        this.a((tb)par1EntityMinecart, par2, par3Block, par4);
    }
}

