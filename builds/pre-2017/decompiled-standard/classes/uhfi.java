/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class uhfi {
    private static final ResourceLocation _a = new ResourceLocation("textures/environment/moon_phases.png");
    private static final ResourceLocation _b = new ResourceLocation("effects", "textures/sun.dds");
    private static final ResourceLocation _c = new ResourceLocation("effects", "textures/sunglare.dds");

    public static void _a(pkix pkix2, float f) {
        xpzm xpzm2 = xpzm._E();
        apbu apbu2 = xpzm2._h;
        htvf htvf2 = htvf.field_78398_a;
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glDisable(2912);
        GL11.glColor3f(0.0f, 0.0f, 0.0f);
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        qnon._a();
        float[] fArray = pkix2.field_73011_w._a(pkix2.func_72826_c(f), f);
        if (fArray != null) {
            // empty if block
        }
        GL11.glEnable(3553);
        GL11.glBlendFunc(770, 1);
        GL11.glPushMatrix();
        float f2 = pkix2.func_72867_j(f);
        float f3 = 1.0f - pkix2.func_72867_j(f);
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, f2);
        GL11.glTranslatef(f4, f5, f6);
        GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
        ytsw._a(pkix2, pkix2.func_72826_c(f), f2);
        GL11.glRotatef(pkix2.func_72826_c(f) * 360.0f, 1.0f, 0.0f, 0.0f);
        float f7 = 30.0f;
        apbu2._a(_b);
        htvf2.func_78382_b();
        htvf2.func_78374_a(-f7, 100.0, -f7, 0.0, 0.0);
        htvf2.func_78374_a(f7, 100.0, -f7, 1.0, 0.0);
        htvf2.func_78374_a(f7, 100.0, f7, 1.0, 1.0);
        htvf2.func_78374_a(-f7, 100.0, f7, 0.0, 1.0);
        htvf2.func_78381_a();
        f7 = 20.0f;
        apbu2._a(_a);
        int n = pkix2.func_72853_d();
        int n2 = n % 4;
        int n3 = n / 4 % 2;
        float f8 = (float)(n2 + 0) / 4.0f;
        float f9 = (float)(n3 + 0) / 2.0f;
        float f10 = (float)(n2 + 1) / 4.0f;
        float f11 = (float)(n3 + 1) / 2.0f;
        htvf2.func_78382_b();
        htvf2.func_78374_a(-f7, -100.0, f7, f10, f11);
        htvf2.func_78374_a(f7, -100.0, f7, f8, f11);
        htvf2.func_78374_a(f7, -100.0, -f7, f8, f9);
        htvf2.func_78374_a(-f7, -100.0, -f7, f10, f9);
        htvf2.func_78381_a();
        GL11.glDisable(3553);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(2912);
        GL11.glPopMatrix();
        GL11.glDisable(3553);
        GL11.glColor3f(0.0f, 0.0f, 0.0f);
        double d = xpzm2._t.func_70666_h((float)f)._d - pkix2.func_72919_O();
        GL11.glEnable(3553);
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
    }
}

