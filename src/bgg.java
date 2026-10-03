/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bbo
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bgg
extends bhe {
    private static final bjo a = new bjo("textures/entity/creeper/creeper_armor.png");
    private static final bjo f = new bjo("textures/entity/creeper/creeper.png");
    private bbo g = new bbg(2.0f);

    public bgg() {
        super(new bbg(), 0.5f);
    }

    protected void a(tf par1EntityCreeper, float par2) {
        float f1 = par1EntityCreeper.a(par2);
        float f2 = 1.0f + ls.a(f1 * 100.0f) * f1 * 0.01f;
        if (f1 < 0.0f) {
            f1 = 0.0f;
        }
        if (f1 > 1.0f) {
            f1 = 1.0f;
        }
        f1 *= f1;
        f1 *= f1;
        float f3 = (1.0f + f1 * 0.4f) * f2;
        float f4 = (1.0f + f1 * 0.1f) / f2;
        GL11.glScalef((float)f3, (float)f4, (float)f3);
    }

    protected int a(tf par1EntityCreeper, float par2, float par3) {
        float f2 = par1EntityCreeper.a(par3);
        if ((int)(f2 * 10.0f) % 2 == 0) {
            return 0;
        }
        int i2 = (int)(f2 * 0.2f * 255.0f);
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 255) {
            i2 = 255;
        }
        int short1 = 255;
        int short2 = 255;
        int short3 = 255;
        return i2 << 24 | short1 << 16 | short2 << 8 | short3;
    }

    protected int a(tf par1EntityCreeper, int par2, float par3) {
        if (par1EntityCreeper.bT()) {
            if (par1EntityCreeper.aj()) {
                GL11.glDepthMask((boolean)false);
            } else {
                GL11.glDepthMask((boolean)true);
            }
            if (par2 == 1) {
                float f1 = (float)par1EntityCreeper.ac + par3;
                this.a(a);
                GL11.glMatrixMode((int)5890);
                GL11.glLoadIdentity();
                float f2 = f1 * 0.01f;
                float f3 = f1 * 0.01f;
                GL11.glTranslatef((float)f2, (float)f3, (float)0.0f);
                this.a(this.g);
                GL11.glMatrixMode((int)5888);
                GL11.glEnable((int)3042);
                float f4 = 0.5f;
                GL11.glColor4f((float)f4, (float)f4, (float)f4, (float)1.0f);
                GL11.glDisable((int)2896);
                GL11.glBlendFunc((int)1, (int)1);
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

    protected int b(tf par1EntityCreeper, int par2, float par3) {
        return -1;
    }

    protected bjo a(tf par1EntityCreeper) {
        return f;
    }

    @Override
    protected void a(of par1EntityLivingBase, float par2) {
        this.a((tf)par1EntityLivingBase, par2);
    }

    @Override
    protected int a(of par1EntityLivingBase, float par2, float par3) {
        return this.a((tf)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected int a(of par1EntityLivingBase, int par2, float par3) {
        return this.a((tf)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected int b(of par1EntityLivingBase, int par2, float par3) {
        return this.b((tf)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((tf)par1Entity);
    }
}

