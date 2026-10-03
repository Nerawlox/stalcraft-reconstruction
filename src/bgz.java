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
public class bgz
extends bgm {
    private static final bjo a = new bjo("textures/entity/lead_knot.png");
    private bbm f = new bbm();

    public void a(oe par1EntityLeashKnot, double par2, double par4, double par6, float par8, float par9) {
        GL11.glPushMatrix();
        GL11.glDisable((int)2884);
        GL11.glTranslatef((float)((float)par2), (float)((float)par4), (float)((float)par6));
        float f2 = 0.0625f;
        GL11.glEnable((int)32826);
        GL11.glScalef((float)-1.0f, (float)-1.0f, (float)1.0f);
        GL11.glEnable((int)3008);
        this.b((nn)((Object)par1EntityLeashKnot));
        this.f.a((nn)((Object)par1EntityLeashKnot), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f2);
        GL11.glPopMatrix();
    }

    protected bjo a(oe par1EntityLeashKnot) {
        return a;
    }

    @Override
    protected bjo a(nn par1Entity) {
        return this.a((oe)((Object)par1Entity));
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.a((oe)((Object)par1Entity), par2, par4, par6, par8, par9);
    }
}

