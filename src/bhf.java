/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bbo
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 *  rw
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bhf
extends bhe {
    private static final bjo a = new bjo("textures/entity/cow/mooshroom.png");

    public bhf(bbo par1ModelBase, float par2) {
        super(par1ModelBase, par2);
    }

    public void a(rw par1EntityMooshroom, double par2, double par4, double par6, float par8, float par9) {
        super.a((og)par1EntityMooshroom, par2, par4, par6, par8, par9);
    }

    protected bjo a(rw par1EntityMooshroom) {
        return a;
    }

    protected void a(rw par1EntityMooshroom, float par2) {
        super.c((of)par1EntityMooshroom, par2);
        if (!par1EntityMooshroom.g_()) {
            this.a(bik.b);
            GL11.glEnable((int)2884);
            GL11.glPushMatrix();
            GL11.glScalef((float)1.0f, (float)-1.0f, (float)1.0f);
            GL11.glTranslatef((float)0.2f, (float)0.4f, (float)0.5f);
            GL11.glRotatef((float)42.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            this.c.a((aqz)aqz.al, 0, 1.0f);
            GL11.glTranslatef((float)0.1f, (float)0.0f, (float)-0.6f);
            GL11.glRotatef((float)42.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            this.c.a((aqz)aqz.al, 0, 1.0f);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            ((bbt)this.i).a.c(0.0625f);
            GL11.glScalef((float)1.0f, (float)-1.0f, (float)1.0f);
            GL11.glTranslatef((float)0.0f, (float)0.75f, (float)-0.2f);
            GL11.glRotatef((float)12.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            this.c.a((aqz)aqz.al, 0, 1.0f);
            GL11.glPopMatrix();
            GL11.glDisable((int)2884);
        }
    }

    @Override
    public void a(og par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.a((rw)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    @Override
    protected void c(of par1EntityLivingBase, float par2) {
        this.a((rw)par1EntityLivingBase, par2);
    }

    @Override
    public void a(of par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
        this.a((rw)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((rw)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((rw)par1Entity, par2, par4, par6, par8, par9);
    }
}

