/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  bma
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bht
extends bhe {
    private static final bjo a = new bjo("textures/entity/iron_golem.png");
    private final bcg f;

    public bht() {
        super(new bcg(), 0.5f);
        this.f = (bcg)this.i;
    }

    public void a(sd par1EntityIronGolem, double par2, double par4, double par6, float par8, float par9) {
        super.a((og)((Object)par1EntityIronGolem), par2, par4, par6, par8, par9);
    }

    protected bjo a(sd par1EntityIronGolem) {
        return a;
    }

    protected void a(sd par1EntityIronGolem, float par2, float par3, float par4) {
        super.a((of)((Object)par1EntityIronGolem), par2, par3, par4);
        if ((double)par1EntityIronGolem.aG >= 0.01) {
            float f3 = 13.0f;
            float f4 = par1EntityIronGolem.aH - par1EntityIronGolem.aG * (1.0f - par4) + 6.0f;
            float f5 = (Math.abs(f4 % f3 - f3 * 0.5f) - f3 * 0.25f) / (f3 * 0.25f);
            GL11.glRotatef((float)(6.5f * f5), (float)0.0f, (float)0.0f, (float)1.0f);
        }
    }

    protected void a(sd par1EntityIronGolem, float par2) {
        super.c((of)((Object)par1EntityIronGolem), par2);
        if (par1EntityIronGolem.bV() != 0) {
            GL11.glEnable((int)32826);
            GL11.glPushMatrix();
            GL11.glRotatef((float)(5.0f + 180.0f * this.f.c.f / (float)Math.PI), (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glTranslatef((float)-0.6875f, (float)1.25f, (float)-0.9375f);
            GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            float f1 = 0.8f;
            GL11.glScalef((float)f1, (float)(-f1), (float)f1);
            int i2 = par1EntityIronGolem.c(par2);
            int j2 = i2 % 65536;
            int k = i2 / 65536;
            bma.a((int)bma.b, (float)((float)j2 / 1.0f), (float)((float)k / 1.0f));
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.a(bik.b);
            this.c.a((aqz)aqz.aj, 0, 1.0f);
            GL11.glPopMatrix();
            GL11.glDisable((int)32826);
        }
    }

    @Override
    public void a(og par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.a((sd)((Object)par1EntityLiving), par2, par4, par6, par8, par9);
    }

    @Override
    protected void c(of par1EntityLivingBase, float par2) {
        this.a((sd)((Object)par1EntityLivingBase), par2);
    }

    @Override
    protected void a(of par1EntityLivingBase, float par2, float par3, float par4) {
        this.a((sd)((Object)par1EntityLivingBase), par2, par3, par4);
    }

    @Override
    public void a(of par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
        this.a((sd)((Object)par1EntityLivingBase), par2, par4, par6, par8, par9);
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((sd)((Object)par1Entity));
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((sd)((Object)par1Entity), par2, par4, par6, par8, par9);
    }
}

