/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 *  uv
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bhx
extends bgm {
    private static final bjo a = new bjo("textures/entity/wither/wither_invulnerable.png");
    private static final bjo f = new bjo("textures/entity/wither/wither.png");
    private final bby g = new bby();

    private float a(float par1, float par2, float par3) {
        float f3;
        for (f3 = par2 - par1; f3 < -180.0f; f3 += 360.0f) {
        }
        while (f3 >= 180.0f) {
            f3 -= 360.0f;
        }
        return par1 + par3 * f3;
    }

    public void a(uv par1EntityWitherSkull, double par2, double par4, double par6, float par8, float par9) {
        GL11.glPushMatrix();
        GL11.glDisable((int)2884);
        float f2 = this.a(par1EntityWitherSkull.C, par1EntityWitherSkull.A, par9);
        float f3 = par1EntityWitherSkull.D + (par1EntityWitherSkull.B - par1EntityWitherSkull.D) * par9;
        GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
        float f4 = 0.0625f;
        GL11.glEnable((int)32826);
        GL11.glScalef((float)-1.0f, (float)-1.0f, (float)1.0f);
        GL11.glEnable((int)3008);
        this.b((nn)par1EntityWitherSkull);
        this.g.a((nn)par1EntityWitherSkull, 0.0f, 0.0f, 0.0f, f2, f3, f4);
        GL11.glPopMatrix();
    }

    protected bjo a(uv par1EntityWitherSkull) {
        return par1EntityWitherSkull.d() ? a : f;
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((uv)par1Entity);
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((uv)par1Entity, par2, par4, par6, par8, par9);
    }
}

