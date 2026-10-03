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
public class bhp
extends bhe {
    private static final bjo a = new bjo("textures/entity/spider_eyes.png");
    private static final bjo f = new bjo("textures/entity/spider/spider.png");

    public bhp() {
        super(new bcd(), 1.0f);
        this.a(new bcd());
    }

    protected float b(tt par1EntitySpider) {
        return 180.0f;
    }

    protected int a(tt par1EntitySpider, int par2, float par3) {
        if (par2 != 0) {
            return -1;
        }
        this.a(a);
        float f1 = 1.0f;
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3008);
        GL11.glBlendFunc((int)1, (int)1);
        if (par1EntitySpider.aj()) {
            GL11.glDepthMask((boolean)false);
        } else {
            GL11.glDepthMask((boolean)true);
        }
        int c0 = 61680;
        int j2 = c0 % 65536;
        int k = c0 / 65536;
        bma.a((int)bma.b, (float)((float)j2 / 1.0f), (float)((float)k / 1.0f));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)f1);
        return 1;
    }

    protected bjo a(tt par1EntitySpider) {
        return f;
    }

    @Override
    protected float a(of par1EntityLivingBase) {
        return this.b((tt)par1EntityLivingBase);
    }

    @Override
    protected int a(of par1EntityLivingBase, int par2, float par3) {
        return this.a((tt)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((tt)par1Entity);
    }
}

