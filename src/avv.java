/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ake
 *  ali
 *  alk
 *  bib
 *  bim
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class avv {
    private static final bjo a = new bjo("textures/map/map_icons.png");
    private final bib b;
    private int[] c = new int[16384];
    private aul d;
    private final bjo e;

    public avv(aul par1GameSettings, bim par2TextureManager) {
        this.d = par1GameSettings;
        this.b = new bib(128, 128);
        this.e = par2TextureManager.a("map", this.b);
        this.c = this.b.c();
        for (int i = 0; i < this.c.length; ++i) {
            this.c[i] = 0;
        }
    }

    public void a(uf par1EntityPlayer, bim par2TextureManager, ali par3MapData) {
        for (int i = 0; i < 16384; ++i) {
            byte b0 = par3MapData.e[i];
            if (b0 / 4 == 0) {
                this.c[i] = (i + i / 128 & 1) * 8 + 16 << 24;
                continue;
            }
            int j2 = ake.a[b0 / 4].p;
            int k = b0 & 3;
            int short1 = 220;
            if (k == 2) {
                short1 = 255;
            }
            if (k == 0) {
                short1 = 180;
            }
            int l = (j2 >> 16 & 0xFF) * short1 / 255;
            int i1 = (j2 >> 8 & 0xFF) * short1 / 255;
            int j1 = (j2 & 0xFF) * short1 / 255;
            this.c[i] = 0xFF000000 | l << 16 | i1 << 8 | j1;
        }
        this.b.a();
        int b1 = 0;
        int b2 = 0;
        bfq tessellator = bfq.a;
        float f = 0.0f;
        par2TextureManager.a(this.e);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)1, (int)771);
        GL11.glDisable((int)3008);
        tessellator.b();
        tessellator.a((float)(b1 + 0) + f, (float)(b2 + 128) - f, -0.01f, 0.0, 1.0);
        tessellator.a((float)(b1 + 128) - f, (float)(b2 + 128) - f, -0.01f, 1.0, 1.0);
        tessellator.a((float)(b1 + 128) - f, (float)(b2 + 0) + f, -0.01f, 1.0, 0.0);
        tessellator.a((float)(b1 + 0) + f, (float)(b2 + 0) + f, -0.01f, 0.0, 0.0);
        tessellator.a();
        GL11.glEnable((int)3008);
        GL11.glDisable((int)3042);
        par2TextureManager.a(a);
        int k1 = 0;
        for (alk mapcoord : par3MapData.g.values()) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((float)b1 + (float)mapcoord.b / 2.0f + 64.0f), (float)((float)b2 + (float)mapcoord.c / 2.0f + 64.0f), (float)-0.02f);
            GL11.glRotatef((float)((float)(mapcoord.d * 360) / 16.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glScalef((float)4.0f, (float)4.0f, (float)3.0f);
            GL11.glTranslatef((float)-0.125f, (float)0.125f, (float)0.0f);
            float f1 = (float)(mapcoord.a % 4 + 0) / 4.0f;
            float f2 = (float)(mapcoord.a / 4 + 0) / 4.0f;
            float f3 = (float)(mapcoord.a % 4 + 1) / 4.0f;
            float f4 = (float)(mapcoord.a / 4 + 1) / 4.0f;
            tessellator.b();
            tessellator.a(-1.0, 1.0, (float)k1 * 0.001f, f1, f2);
            tessellator.a(1.0, 1.0, (float)k1 * 0.001f, f3, f2);
            tessellator.a(1.0, -1.0, (float)k1 * 0.001f, f3, f4);
            tessellator.a(-1.0, -1.0, (float)k1 * 0.001f, f1, f4);
            tessellator.a();
            GL11.glPopMatrix();
            ++k1;
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-0.04f);
        GL11.glScalef((float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPopMatrix();
    }
}

