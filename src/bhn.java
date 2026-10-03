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
public class bhn
extends bhe {
    private static final bjo a = new bjo("textures/entity/slime/slime.png");
    private bbo f;

    public bhn(bbo par1ModelBase, bbo par2ModelBase, float par3) {
        super(par1ModelBase, par3);
        this.f = par2ModelBase;
    }

    protected int a(ts par1EntitySlime, int par2, float par3) {
        if (par1EntitySlime.aj()) {
            return 0;
        }
        if (par2 == 0) {
            this.a(this.f);
            GL11.glEnable((int)2977);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            return 1;
        }
        if (par2 == 1) {
            GL11.glDisable((int)3042);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        }
        return -1;
    }

    protected void a(ts par1EntitySlime, float par2) {
        float f1 = par1EntitySlime.bR();
        float f2 = (par1EntitySlime.j + (par1EntitySlime.i - par1EntitySlime.j) * par2) / (f1 * 0.5f + 1.0f);
        float f3 = 1.0f / (f2 + 1.0f);
        GL11.glScalef((float)(f3 * f1), (float)(1.0f / f3 * f1), (float)(f3 * f1));
    }

    protected bjo a(ts par1EntitySlime) {
        return a;
    }

    @Override
    protected void a(of par1EntityLivingBase, float par2) {
        this.a((ts)par1EntityLivingBase, par2);
    }

    @Override
    protected int a(of par1EntityLivingBase, int par2, float par3) {
        return this.a((ts)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((ts)par1Entity);
    }
}

