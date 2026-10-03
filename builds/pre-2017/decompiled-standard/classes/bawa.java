/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.ItemAtlasHooks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import org.lwjgl.opengl.GL11;

public class bawa {
    public static final ResourceLocation field_110325_k = new ResourceLocation("textures/gui/options_background.png");
    public static final ResourceLocation field_110323_l = new ResourceLocation("textures/gui/container/stats_icons.png");
    public static final ResourceLocation field_110324_m = new ResourceLocation("textures/gui/icons.png");
    public float field_73735_i;

    public void func_73730_a(int n, int n2, int n3, int n4) {
        if (n2 < n) {
            int n5 = n;
            n = n2;
            n2 = n5;
        }
        bawa.func_73734_a(n, n3, n2 + 1, n3 + 1, n4);
    }

    public void func_73728_b(int n, int n2, int n3, int n4) {
        if (n3 < n2) {
            int n5 = n2;
            n2 = n3;
            n3 = n5;
        }
        bawa.func_73734_a(n, n2 + 1, n + 1, n3, n4);
    }

    public static void func_73734_a(int n, int n2, int n3, int n4, int n5) {
        int n6;
        if (n < n3) {
            n6 = n;
            n = n3;
            n3 = n6;
        }
        if (n2 < n4) {
            n6 = n2;
            n2 = n4;
            n4 = n6;
        }
        float f = (float)(n5 >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        htvf htvf2 = htvf.field_78398_a;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(f2, f3, f4, f);
        htvf2.func_78382_b();
        htvf2.func_78377_a(n, n4, 0.0);
        htvf2.func_78377_a(n3, n4, 0.0);
        htvf2.func_78377_a(n3, n2, 0.0);
        htvf2.func_78377_a(n, n2, 0.0);
        htvf2.func_78381_a();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }

    public void func_73733_a(int n, int n2, int n3, int n4, int n5, int n6) {
        float f = (float)(n5 >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        float f5 = (float)(n6 >> 24 & 0xFF) / 255.0f;
        float f6 = (float)(n6 >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n6 >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n6 & 0xFF) / 255.0f;
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78369_a(f2, f3, f4, f);
        htvf2.func_78377_a(n3, n2, this.field_73735_i);
        htvf2.func_78377_a(n, n2, this.field_73735_i);
        htvf2.func_78369_a(f6, f7, f8, f5);
        htvf2.func_78377_a(n, n4, this.field_73735_i);
        htvf2.func_78377_a(n3, n4, this.field_73735_i);
        htvf2.func_78381_a();
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
    }

    public void func_73732_a(qncw qncw2, String string, int n, int n2, int n3) {
        qncw2._a(string, n - qncw2._b(string) / 2, n2, n3);
    }

    public void func_73731_b(qncw qncw2, String string, int n, int n2, int n3) {
        qncw2._a(string, n, n2, n3);
    }

    public void func_73729_b(int n, int n2, int n3, int n4, int n5, int n6) {
        float f = 0.00390625f;
        float f2 = 0.00390625f;
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78374_a(n + 0, n2 + n6, this.field_73735_i, (float)(n3 + 0) * f, (float)(n4 + n6) * f2);
        htvf2.func_78374_a(n + n5, n2 + n6, this.field_73735_i, (float)(n3 + n5) * f, (float)(n4 + n6) * f2);
        htvf2.func_78374_a(n + n5, n2 + 0, this.field_73735_i, (float)(n3 + n5) * f, (float)(n4 + 0) * f2);
        htvf2.func_78374_a(n + 0, n2 + 0, this.field_73735_i, (float)(n3 + 0) * f, (float)(n4 + 0) * f2);
        htvf2.func_78381_a();
    }

    public void func_94065_a(int n, int n2, dwan dwan2, int n3, int n4) {
        ItemAtlasHooks.drawTexturedModelRectFromIcon(this, n, n2, dwan2, n3, n4);
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78374_a(n + 0, n2 + n4, this.field_73735_i, dwan2.func_94209_e(), dwan2.func_94210_h());
        htvf2.func_78374_a(n + n3, n2 + n4, this.field_73735_i, dwan2.func_94212_f(), dwan2.func_94210_h());
        htvf2.func_78374_a(n + n3, n2 + 0, this.field_73735_i, dwan2.func_94212_f(), dwan2.func_94206_g());
        htvf2.func_78374_a(n + 0, n2 + 0, this.field_73735_i, dwan2.func_94209_e(), dwan2.func_94206_g());
        htvf2.func_78381_a();
    }
}

