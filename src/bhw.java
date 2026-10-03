/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bez
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 *  sg
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bhw
extends bhe {
    private static final bjo a = new bjo("textures/entity/wither/wither_invulnerable.png");
    private static final bjo f = new bjo("textures/entity/wither/wither.png");
    private int g;

    public bhw() {
        super(new bck(), 1.0f);
        this.g = ((bck)this.i).a();
    }

    public void a(sm par1EntityWither, double par2, double par4, double par6, float par8, float par9) {
        bez.a((sg)par1EntityWither, (boolean)true);
        int i2 = ((bck)this.i).a();
        if (i2 != this.g) {
            this.g = i2;
            this.i = new bck();
        }
        super.a(par1EntityWither, par2, par4, par6, par8, par9);
    }

    protected bjo a(sm par1EntityWither) {
        int i2 = par1EntityWither.bU();
        return i2 > 0 && (i2 > 80 || i2 / 5 % 2 != 1) ? a : f;
    }

    protected void a(sm par1EntityWither, float par2) {
        int i2 = par1EntityWither.bU();
        if (i2 > 0) {
            float f1 = 2.0f - ((float)i2 - par2) / 220.0f * 0.5f;
            GL11.glScalef((float)f1, (float)f1, (float)f1);
        } else {
            GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
        }
    }

    protected int a(sm par1EntityWither, int par2, float par3) {
        if (par1EntityWither.bV()) {
            if (par1EntityWither.aj()) {
                GL11.glDepthMask((boolean)false);
            } else {
                GL11.glDepthMask((boolean)true);
            }
            if (par2 == 1) {
                float f1 = (float)par1EntityWither.ac + par3;
                this.a(a);
                GL11.glMatrixMode((int)5890);
                GL11.glLoadIdentity();
                float f2 = ls.b(f1 * 0.02f) * 3.0f;
                float f3 = f1 * 0.01f;
                GL11.glTranslatef((float)f2, (float)f3, (float)0.0f);
                this.a(this.i);
                GL11.glMatrixMode((int)5888);
                GL11.glEnable((int)3042);
                float f4 = 0.5f;
                GL11.glColor4f((float)f4, (float)f4, (float)f4, (float)1.0f);
                GL11.glDisable((int)2896);
                GL11.glBlendFunc((int)1, (int)1);
                GL11.glTranslatef((float)0.0f, (float)-0.01f, (float)0.0f);
                GL11.glScalef((float)1.1f, (float)1.1f, (float)1.1f);
                return 1;
            }
            if (par2 == 2) {
                GL11.glMatrixMode((int)5890);
                GL11.glLoadIdentity();
                GL11.glMatrixMode((int)5888);
                GL11.glEnable((int)2896);
                GL11.glDisable((int)3042);
            }
        }
        return -1;
    }

    protected int b(sm par1EntityWither, int par2, float par3) {
        return -1;
    }

    @Override
    public void a(og par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.a((sm)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    @Override
    protected void a(of par1EntityLivingBase, float par2) {
        this.a((sm)par1EntityLivingBase, par2);
    }

    @Override
    protected int a(of par1EntityLivingBase, int par2, float par3) {
        return this.a((sm)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected int b(of par1EntityLivingBase, int par2, float par3) {
        return this.b((sm)par1EntityLivingBase, par2, par3);
    }

    @Override
    public void a(of par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
        this.a((sm)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((sm)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((sm)par1Entity, par2, par4, par6, par8, par9);
    }
}

