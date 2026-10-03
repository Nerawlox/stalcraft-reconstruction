/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  bkb
 *  bma
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  kp
 *  ku
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class axv
extends axp {
    private float t;
    private float u;

    public axv(uf par1EntityPlayer) {
        super(par1EntityPlayer.bo);
        this.j = true;
        par1EntityPlayer.a((ku)kp.f, 1);
    }

    @Override
    public void c() {
        if (this.f.c.h()) {
            this.f.a(new axm((uf)this.f.h));
        }
    }

    @Override
    public void A_() {
        this.i.clear();
        if (this.f.c.h()) {
            this.f.a(new axm((uf)this.f.h));
        } else {
            super.A_();
        }
    }

    @Override
    protected void b(int par1, int par2) {
        this.o.b(bkb.a((String)"container.crafting"), 86, 16, 0x404040);
    }

    @Override
    public void a(int par1, int par2, float par3) {
        super.a(par1, par2, par3);
        this.t = par1;
        this.u = par2;
    }

    @Override
    protected void a(float par1, int par2, int par3) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.f.J().a(a);
        int k = this.p;
        int l = this.q;
        this.b(k, l, 0, 0, this.c, this.d);
        axv.a(k + 51, l + 75, 30, (float)(k + 51) - this.t, (float)(l + 75 - 50) - this.u, (of)this.f.h);
    }

    public static void a(int par0, int par1, int par2, float par3, float par4, of par5EntityLivingBase) {
        GL11.glEnable((int)2903);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par0, (float)par1, (float)50.0f);
        GL11.glScalef((float)(-par2), (float)par2, (float)par2);
        GL11.glRotatef((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        float f2 = par5EntityLivingBase.aN;
        float f3 = par5EntityLivingBase.A;
        float f4 = par5EntityLivingBase.B;
        float f5 = par5EntityLivingBase.aQ;
        float f6 = par5EntityLivingBase.aP;
        GL11.glRotatef((float)135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        att.b();
        GL11.glRotatef((float)-135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-((float)Math.atan(par4 / 40.0f)) * 20.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        par5EntityLivingBase.aN = (float)Math.atan(par3 / 40.0f) * 20.0f;
        par5EntityLivingBase.A = (float)Math.atan(par3 / 40.0f) * 40.0f;
        par5EntityLivingBase.B = -((float)Math.atan(par4 / 40.0f)) * 20.0f;
        par5EntityLivingBase.aP = par5EntityLivingBase.A;
        par5EntityLivingBase.aQ = par5EntityLivingBase.A;
        GL11.glTranslatef((float)0.0f, (float)par5EntityLivingBase.N, (float)0.0f);
        bgl.a.j = 180.0f;
        bgl.a.a(par5EntityLivingBase, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        par5EntityLivingBase.aN = f2;
        par5EntityLivingBase.A = f3;
        par5EntityLivingBase.B = f4;
        par5EntityLivingBase.aQ = f5;
        par5EntityLivingBase.aP = f6;
        GL11.glPopMatrix();
        att.a();
        GL11.glDisable((int)32826);
        bma.a((int)bma.b);
        GL11.glDisable((int)3553);
        bma.a((int)bma.a);
    }

    @Override
    protected void a(aut par1GuiButton) {
        if (par1GuiButton.g == 0) {
            this.f.a(new awq(this.f.y));
        }
        if (par1GuiButton.g == 1) {
            this.f.a(new awr(this, this.f.y));
        }
    }
}

