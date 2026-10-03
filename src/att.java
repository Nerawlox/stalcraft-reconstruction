/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  atc
 *  atu
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class att {
    private static FloatBuffer a = atu.h((int)16);
    private static final atc b = atc.a((double)0.2f, (double)1.0, (double)-0.7f).a();
    private static final atc c = atc.a((double)-0.2f, (double)1.0, (double)0.7f).a();

    public static void a() {
        GL11.glDisable((int)2896);
        GL11.glDisable((int)16384);
        GL11.glDisable((int)16385);
        GL11.glDisable((int)2903);
    }

    public static void b() {
        GL11.glEnable((int)2896);
        GL11.glEnable((int)16384);
        GL11.glEnable((int)16385);
        GL11.glEnable((int)2903);
        GL11.glColorMaterial((int)1032, (int)5634);
        float f = 0.4f;
        float f1 = 0.6f;
        float f2 = 0.0f;
        GL11.glLight((int)16384, (int)4611, (FloatBuffer)att.a(att.b.c, att.b.d, att.b.e, 0.0));
        GL11.glLight((int)16384, (int)4609, (FloatBuffer)att.a(f1, f1, f1, 1.0f));
        GL11.glLight((int)16384, (int)4608, (FloatBuffer)att.a(0.0f, 0.0f, 0.0f, 1.0f));
        GL11.glLight((int)16384, (int)4610, (FloatBuffer)att.a(f2, f2, f2, 1.0f));
        GL11.glLight((int)16385, (int)4611, (FloatBuffer)att.a(att.c.c, att.c.d, att.c.e, 0.0));
        GL11.glLight((int)16385, (int)4609, (FloatBuffer)att.a(f1, f1, f1, 1.0f));
        GL11.glLight((int)16385, (int)4608, (FloatBuffer)att.a(0.0f, 0.0f, 0.0f, 1.0f));
        GL11.glLight((int)16385, (int)4610, (FloatBuffer)att.a(f2, f2, f2, 1.0f));
        GL11.glShadeModel((int)7424);
        GL11.glLightModel((int)2899, (FloatBuffer)att.a(f, f, f, 1.0f));
    }

    private static FloatBuffer a(double par0, double par2, double par4, double par6) {
        return att.a((float)par0, (float)par2, (float)par4, (float)par6);
    }

    private static FloatBuffer a(float par0, float par1, float par2, float par3) {
        a.clear();
        a.put(par0).put(par1).put(par2).put(par3);
        a.flip();
        return a;
    }

    public static void c() {
        GL11.glPushMatrix();
        GL11.glRotatef((float)-30.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)165.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        att.b();
        GL11.glPopMatrix();
    }
}

