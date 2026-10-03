/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bhs
extends bgm {
    private bfr a = new bfr();

    public bhs() {
        this.d = 0.5f;
    }

    public void a(tc par1EntityTNTPrimed, double par2, double par4, double par6, float par8, float par9) {
        float f2;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
        if ((float)par1EntityTNTPrimed.a - par9 + 1.0f < 10.0f) {
            f2 = 1.0f - ((float)par1EntityTNTPrimed.a - par9 + 1.0f) / 10.0f;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            f2 *= f2;
            f2 *= f2;
            float f3 = 1.0f + f2 * 0.3f;
            GL11.glScalef((float)f3, (float)f3, (float)f3);
        }
        f2 = (1.0f - ((float)par1EntityTNTPrimed.a - par9 + 1.0f) / 100.0f) * 0.8f;
        this.b(par1EntityTNTPrimed);
        this.a.a(aqz.ar, 0, par1EntityTNTPrimed.d(par9));
        if (par1EntityTNTPrimed.a / 5 % 2 == 0) {
            GL11.glDisable((int)3553);
            GL11.glDisable((int)2896);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)772);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)f2);
            this.a.a(aqz.ar, 0, 1.0f);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDisable((int)3042);
            GL11.glEnable((int)2896);
            GL11.glEnable((int)3553);
        }
        GL11.glPopMatrix();
    }

    protected bjo a(tc par1EntityTNTPrimed) {
        return bik.b;
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((tc)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((tc)par1Entity, par2, par4, par6, par8, par9);
    }
}

