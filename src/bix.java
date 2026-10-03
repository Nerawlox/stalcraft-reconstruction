/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asf
 *  bbd
 *  bje
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bix
extends bje {
    private static final bjo a = new bjo("textures/entity/chest/ender.png");
    private bbd c = new bbd();

    public void a(asf par1TileEntityEnderChest, double par2, double par4, double par6, float par8) {
        int i2 = 0;
        if (par1TileEntityEnderChest.o()) {
            i2 = par1TileEntityEnderChest.p();
        }
        this.a(a);
        GL11.glPushMatrix();
        GL11.glEnable((int)32826);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glTranslatef((float)((float)par2), (float)((float)par4 + 1.0f), (float)((float)par6 + 1.0f));
        GL11.glScalef((float)1.0f, (float)-1.0f, (float)-1.0f);
        GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
        int short1 = 0;
        if (i2 == 2) {
            short1 = 180;
        }
        if (i2 == 3) {
            short1 = 0;
        }
        if (i2 == 4) {
            short1 = 90;
        }
        if (i2 == 5) {
            short1 = -90;
        }
        GL11.glRotatef((float)short1, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
        float f1 = par1TileEntityEnderChest.b + (par1TileEntityEnderChest.a - par1TileEntityEnderChest.b) * par8;
        f1 = 1.0f - f1;
        f1 = 1.0f - f1 * f1 * f1;
        this.c.a.f = -(f1 * (float)Math.PI / 2.0f);
        this.c.a();
        GL11.glDisable((int)32826);
        GL11.glPopMatrix();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        this.a((asf)par1TileEntity, par2, par4, par6, par8);
    }
}

