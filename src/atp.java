/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aco
 *  atc
 *  atu
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.glu.GLU
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

@SideOnly(value=Side.CLIENT)
public class atp {
    public static float a;
    public static float b;
    public static float c;
    private static IntBuffer i;
    private static FloatBuffer j;
    private static FloatBuffer k;
    private static FloatBuffer l;
    public static float d;
    public static float e;
    public static float f;
    public static float g;
    public static float h;

    public static void a(uf par0EntityPlayer, boolean par1) {
        GL11.glGetFloat((int)2982, (FloatBuffer)j);
        GL11.glGetFloat((int)2983, (FloatBuffer)k);
        GL11.glGetInteger((int)2978, (IntBuffer)i);
        float f = (i.get(0) + i.get(2)) / 2;
        float f1 = (i.get(1) + i.get(3)) / 2;
        GLU.gluUnProject((float)f, (float)f1, (float)0.0f, (FloatBuffer)j, (FloatBuffer)k, (IntBuffer)i, (FloatBuffer)l);
        a = l.get(0);
        b = l.get(1);
        c = l.get(2);
        int i = par1 ? 1 : 0;
        float f2 = par0EntityPlayer.B;
        float f3 = par0EntityPlayer.A;
        d = ls.b(f3 * (float)Math.PI / 180.0f) * (float)(1 - i * 2);
        atp.f = ls.a(f3 * (float)Math.PI / 180.0f) * (float)(1 - i * 2);
        g = -atp.f * ls.a(f2 * (float)Math.PI / 180.0f) * (float)(1 - i * 2);
        h = d * ls.a(f2 * (float)Math.PI / 180.0f) * (float)(1 - i * 2);
        e = ls.b(f2 * (float)Math.PI / 180.0f);
    }

    public static atc b(of par0EntityLivingBase, double par1) {
        double d1 = par0EntityLivingBase.r + (par0EntityLivingBase.u - par0EntityLivingBase.r) * par1;
        double d2 = par0EntityLivingBase.s + (par0EntityLivingBase.v - par0EntityLivingBase.s) * par1 + (double)par0EntityLivingBase.f();
        double d3 = par0EntityLivingBase.t + (par0EntityLivingBase.w - par0EntityLivingBase.t) * par1;
        double d4 = d1 + (double)(a * 1.0f);
        double d5 = d2 + (double)(b * 1.0f);
        double d6 = d3 + (double)(c * 1.0f);
        return par0EntityLivingBase.q.V().a(d4, d5, d6);
    }

    public static int a(abw par0World, of par1EntityLivingBase, float par2) {
        float f1;
        float f2;
        atc vec3 = atp.b(par1EntityLivingBase, par2);
        aco chunkposition = new aco(vec3);
        int i = par0World.a(chunkposition.a, chunkposition.b, chunkposition.c);
        if (i != 0 && aqz.s[i].cU.d() && vec3.d >= (double)(f2 = (float)(chunkposition.b + 1) - (f1 = apc.d(par0World.h(chunkposition.a, chunkposition.b, chunkposition.c)) - 0.11111111f))) {
            i = par0World.a(chunkposition.a, chunkposition.b + 1, chunkposition.c);
        }
        return i;
    }

    static {
        i = atu.f((int)16);
        j = atu.h((int)16);
        k = atu.h((int)16);
        l = atu.h((int)3);
    }
}

