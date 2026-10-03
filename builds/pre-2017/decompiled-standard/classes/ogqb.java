/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.sajh;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

public class ogqb {
    @Hook(injectOnExit=true)
    @ezey(_a={eidj.CLIENT})
    public static void _a(bscn bscn2, hdmk hdmk2) {
        MinecraftForge.EVENT_BUS.post(new zxrk(hdmk2._a, hdmk2._b, hdmk2._c, hdmk2._d, hdmk2._e));
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void _a(tfsl tfsl2, float f) {
        float f2;
        EntityLivingBase entityLivingBase = tfsl2.field_78531_r._u;
        float f3 = (float)entityLivingBase.field_70737_aN - f;
        if (entityLivingBase.func_110143_aJ() <= 0.0f) {
            f2 = entityLivingBase.field_70725_aQ;
            GL11.glRotatef(40.0f - 8000.0f / (f2 + 200.0f), 0.0f, 0.0f, 1.0f);
        }
        if (f3 >= 0.0f) {
            f3 /= (float)entityLivingBase.field_70738_aO;
            f3 = sajh._a(f3 * f3 * f3 * f3 * (float)Math.PI);
            f2 = entityLivingBase.field_70739_aP;
            GL11.glRotatef(-f2, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-f3 * 14.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static float _a(tfsl tfsl2, float f, boolean bl) {
        int n;
        if (tfsl2.field_78532_q > 0) {
            return 90.0f;
        }
        EntityLivingBase entityLivingBase = tfsl2.field_78531_r._u;
        float f2 = 70.0f;
        if (bl) {
            f2 += tfsl2.field_78531_r._M.field_74334_X * 40.0f;
            f2 *= tfsl2.field_78506_S + (tfsl2.field_78507_R - tfsl2.field_78506_S) * f;
        }
        if (entityLivingBase.func_110143_aJ() <= 0.0f) {
            float f3 = entityLivingBase.field_70725_aQ;
            f2 /= (1.0f - 500.0f / (f3 + 500.0f)) * 2.0f + 1.0f;
        }
        if ((n = tfss._a(tfsl2.field_78531_r._r, entityLivingBase, f)) != 0 && twgu.field_71973_m[n].field_72018_cp == tflj._h) {
            f2 = f2 * 60.0f / 70.0f;
        }
        return f2 + tfsl2.field_78494_N + (tfsl2.field_78493_M - tfsl2.field_78494_N) * f;
    }
}

