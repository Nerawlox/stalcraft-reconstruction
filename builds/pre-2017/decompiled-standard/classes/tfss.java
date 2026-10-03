/*
 * Decompiled with CFR 0.152.
 */
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class tfss {
    public static float _a;
    public static float _b;
    public static float _c;
    public static IntBuffer _d;
    public static FloatBuffer _e;
    public static FloatBuffer _f;
    public static FloatBuffer _g;
    public static float _h;
    public static float _i;
    public static float _j;
    public static float _k;
    public static float _l;

    public static void _a(EntityPlayer entityPlayer, boolean bl) {
        GL11.glGetFloat(2982, _e);
        GL11.glGetFloat(2983, _f);
        GL11.glGetInteger(2978, _d);
        float f = (_d.get(0) + _d.get(2)) / 2;
        float f2 = (_d.get(1) + _d.get(3)) / 2;
        GLU.gluUnProject(f, f2, 0.0f, _e, _f, _d, _g);
        _a = _g.get(0);
        _b = _g.get(1);
        _c = _g.get(2);
        int n = bl ? 1 : 0;
        float f3 = entityPlayer.field_70125_A;
        float f4 = entityPlayer.field_70177_z;
        _h = sajh._b(f4 * (float)Math.PI / 180.0f) * (float)(1 - n * 2);
        _j = sajh._a(f4 * (float)Math.PI / 180.0f) * (float)(1 - n * 2);
        _k = -_j * sajh._a(f3 * (float)Math.PI / 180.0f) * (float)(1 - n * 2);
        _l = _h * sajh._a(f3 * (float)Math.PI / 180.0f) * (float)(1 - n * 2);
        _i = sajh._b(f3 * (float)Math.PI / 180.0f);
    }

    public static ofbx _a(EntityLivingBase entityLivingBase, double d) {
        double d2 = entityLivingBase.field_70169_q + (entityLivingBase.field_70165_t - entityLivingBase.field_70169_q) * d;
        double d3 = entityLivingBase.field_70167_r + (entityLivingBase.field_70163_u - entityLivingBase.field_70167_r) * d + (double)entityLivingBase.func_70047_e();
        double d4 = entityLivingBase.field_70166_s + (entityLivingBase.field_70161_v - entityLivingBase.field_70166_s) * d;
        double d5 = d2 + (double)(_a * 1.0f);
        double d6 = d3 + (double)(_b * 1.0f);
        double d7 = d4 + (double)(_c * 1.0f);
        return entityLivingBase.field_70170_p.func_82732_R()._a(d5, d6, d7);
    }

    public static int _a(ozlu ozlu2, EntityLivingBase entityLivingBase, float f) {
        float f2;
        float f3;
        ofbx ofbx2 = tfss._a(entityLivingBase, f);
        xtcd xtcd2 = new xtcd(ofbx2);
        int n = ozlu2.func_72798_a(xtcd2._d, xtcd2._e, xtcd2._f);
        if (n != 0 && twgu.field_71973_m[n].field_72018_cp._d() && ofbx2._d >= (double)(f3 = (float)(xtcd2._e + 1) - (f2 = ogyy._a(ozlu2.func_72805_g(xtcd2._d, xtcd2._e, xtcd2._f)) - 0.11111111f))) {
            n = ozlu2.func_72798_a(xtcd2._d, xtcd2._e + 1, xtcd2._f);
        }
        return n;
    }

    static {
        _d = pklh._d(16);
        _e = pklh._e(16);
        _f = pklh._e(16);
        _g = pklh._e(3);
    }
}

