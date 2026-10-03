/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  org.lwjgl.opengl.GL11
 *  zp
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bgx
extends bgm {
    private yc a;
    private int f;

    public bgx(yc par1Item, int par2) {
        this.a = par1Item;
        this.f = par2;
    }

    public bgx(yc par1Item) {
        this(par1Item, 0);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        ms icon = this.a.b_(this.f);
        if (icon != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
            GL11.glEnable((int)32826);
            GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
            this.b(par1Entity);
            bfq tessellator = bfq.a;
            if (icon == yp.e("bottle_splash")) {
                int i2 = zp.a((int)((uu)par1Entity).i(), (boolean)false);
                float f2 = (float)(i2 >> 16 & 0xFF) / 255.0f;
                float f3 = (float)(i2 >> 8 & 0xFF) / 255.0f;
                float f4 = (float)(i2 & 0xFF) / 255.0f;
                GL11.glColor3f((float)f2, (float)f3, (float)f4);
                GL11.glPushMatrix();
                this.a(tessellator, yp.e("overlay"));
                GL11.glPopMatrix();
                GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
            }
            this.a(tessellator, icon);
            GL11.glDisable((int)32826);
            GL11.glPopMatrix();
        }
    }

    @Override
    protected bjo a(nn par1Entity) {
        return bik.c;
    }

    private void a(bfq par1Tessellator, ms par2Icon) {
        float f2 = par2Icon.c();
        float f1 = par2Icon.d();
        float f22 = par2Icon.e();
        float f3 = par2Icon.f();
        float f4 = 1.0f;
        float f5 = 0.5f;
        float f6 = 0.25f;
        GL11.glRotatef((float)(180.0f - this.b.j), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-this.b.k), (float)1.0f, (float)0.0f, (float)0.0f);
        par1Tessellator.b();
        par1Tessellator.b(0.0f, 1.0f, 0.0f);
        par1Tessellator.a(0.0f - f5, 0.0f - f6, 0.0, f2, f3);
        par1Tessellator.a(f4 - f5, 0.0f - f6, 0.0, f1, f3);
        par1Tessellator.a(f4 - f5, f4 - f6, 0.0, f1, f22);
        par1Tessellator.a(0.0f - f5, f4 - f6, 0.0, f2, f22);
        par1Tessellator.a();
    }
}

