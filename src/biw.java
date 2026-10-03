/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
public class biw
extends bje {
    private static final bjo a = new bjo("textures/entity/enchanting_table_book.png");
    private bbc c = new bbc();

    public void a(ase par1TileEntityEnchantmentTable, double par2, double par4, double par6, float par8) {
        float f2;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)par2 + 0.5f), (float)((float)par4 + 0.75f), (float)((float)par6 + 0.5f));
        float f1 = (float)par1TileEntityEnchantmentTable.a + par8;
        GL11.glTranslatef((float)0.0f, (float)(0.1f + ls.a(f1 * 0.1f) * 0.01f), (float)0.0f);
        for (f2 = par1TileEntityEnchantmentTable.h - par1TileEntityEnchantmentTable.i; f2 >= (float)Math.PI; f2 -= (float)Math.PI * 2) {
        }
        while (f2 < (float)(-Math.PI)) {
            f2 += (float)Math.PI * 2;
        }
        float f3 = par1TileEntityEnchantmentTable.i + f2 * par8;
        GL11.glRotatef((float)(-f3 * 180.0f / (float)Math.PI), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)80.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        this.a(a);
        float f4 = par1TileEntityEnchantmentTable.c + (par1TileEntityEnchantmentTable.b - par1TileEntityEnchantmentTable.c) * par8 + 0.25f;
        float f5 = par1TileEntityEnchantmentTable.c + (par1TileEntityEnchantmentTable.b - par1TileEntityEnchantmentTable.c) * par8 + 0.75f;
        f4 = (f4 - (float)ls.b((double)f4)) * 1.6f - 0.3f;
        f5 = (f5 - (float)ls.b((double)f5)) * 1.6f - 0.3f;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        float f6 = par1TileEntityEnchantmentTable.g + (par1TileEntityEnchantmentTable.f - par1TileEntityEnchantmentTable.g) * par8;
        GL11.glEnable((int)2884);
        this.c.a(null, f1, f4, f5, f6, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        this.a((ase)par1TileEntity, par2, par4, par6, par8);
    }
}

