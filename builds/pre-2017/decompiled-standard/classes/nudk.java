/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class nudk
extends htys {
    private IModelCustom _a = AdvancedModelLoader.loadModel("/assets/stalkerclans/models/flag.mcsa");
    private ResourceLocation _b = new ResourceLocation("stalkerclans", "models/flag_down.dds");
    private ResourceLocation _c = new ResourceLocation("stalkerclans", "models/flag_up.dds");

    public nudk() {
        fmib._b(this._b);
        fmib._b(this._c);
    }

    @Override
    public void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        htvf htvf2 = htvf.field_78398_a;
        fmle fmle2 = (fmle)hurg2;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5f, (float)d2, (float)d3 + 0.5f);
        xpzm._E()._h._a(this._b);
        this._a.renderPart("palka");
        xpzm._E()._h._a(this._c);
        this._a.renderPart("flag");
        float f2 = fmle2.field_70331_k.func_72976_f(fmle2.field_70329_l, fmle2.field_70327_n) - fmle2.field_70330_m + 10;
        GL11.glTranslatef(0.0f, f2, 0.0f);
        float f3 = 1.0f;
        double d4 = -90.0 - Math.toDegrees(Math.atan2(-d3 - 0.5, -d - 0.5));
        GL11.glRotated(d4, 0.0, 1.0, 0.0);
        GL11.glDisable(2896);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glDepthMask(false);
        htvf2.func_78382_b();
        htvf2.func_78369_a(0.0f, 0.0f, 0.0f, 0.5f);
        htvf2.func_78374_a(-f3, -f3, 0.0, 1.0, 0.0);
        htvf2.func_78374_a(-f3, f3, 0.0, 0.0, 0.0);
        htvf2.func_78374_a(f3, f3, 0.0, 0.0, 1.0);
        htvf2.func_78374_a(f3, -f3, 0.0, 1.0, 1.0);
        htvf2.func_78381_a();
        mcmy mcmy2 = yfpk._i;
        htvf2.func_78369_a(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glScalef(0.03f, 0.03f, 0.03f);
        GL11.glRotated(180.0, 0.0, 0.0, 1.0);
        if (fmle2._a != null) {
            mcmy2._b(fmle2._a, 0.0, -10.0, -1, 1.0f);
        }
        if (fmle2._b != null) {
            mcmy2._b(fmle2._b, 0.0, 10.0, -1, 1.0f);
        }
        GL11.glDisable(3042);
        GL11.glEnable(3553);
        GL11.glDepthMask(true);
        GL11.glEnable(2896);
        GL11.glPopMatrix();
        if (xpzm._E()._t.field_71075_bZ._d || fmle2._i) {
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glPushMatrix();
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glTranslated(d + (double)(fmle2._c - fmle2.field_70329_l), d2 + (double)(fmle2._d - fmle2.field_70330_m), d3 + (double)(fmle2._e - fmle2.field_70327_n));
            GL11.glLineWidth(3.0f);
            htvf2.func_78371_b(1);
            htvf2.func_78369_a(0.0f, 0.75f, 0.0f, 0.25f);
            double d5 = fmle2._f - fmle2._c;
            double d6 = fmle2._g - fmle2._d;
            double d7 = fmle2._h - fmle2._e;
            owxf._a(0.0, 0.0, 0.0, 0.0, d6, d7);
            owxf._a(0.0 + d5, 0.0, 0.0, 0.0, d6, d7);
            owxf._a(0.0, 0.0, 0.0, d5, d6, 0.0);
            owxf._a(0.0, 0.0, 0.0 + d7, d5, d6, 0.0);
            htvf2.func_78381_a();
            GL11.glPopMatrix();
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
    }
}

