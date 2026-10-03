/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import java.util.HashMap;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class fmea
extends htys {
    public static fmea _a;
    public static int _b;
    public float _c;
    private HashMap<twgu, kjui> _d = new HashMap();

    public fmea() {
        _a = this;
    }

    public void _a(gphy gphy2, String string, String string2, String string3, float f) {
        this._d.put(gphy2, new kjui(string, string2, string3, f));
    }

    @Override
    public void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        boolean bl;
        boolean bl2 = bl = uhoc._a._b && hurg2 instanceof hbio;
        if (bl) {
            int n = ((hbio)hurg2)._a() ? -26368 : -16711681;
            this._a(d, d2, d3, n);
            GL11.glDisable(2929);
        }
        this._a(hurg2, d, d2, d3, !bl);
        if (bl) {
            GL11.glEnable(2929);
        }
    }

    private void _a(double d, double d2, double d3, int n) {
        float f = (float)(d + gqqu._d);
        float f2 = (float)(d2 + gqqu._e);
        float f3 = (float)(d3 + gqqu._f);
        owxf._a((double)f - 0.5, (double)f2 - 0.5, (double)f3 - 0.5, (double)f + 0.5, (double)f2 + 0.5, (double)f3 + 0.5, n, 1.0f);
    }

    private void _a(hurg hurg2, double d, double d2, double d3, boolean bl) {
        gphy gphy2 = (gphy)hurg2.field_70324_q;
        if (gphy2 == null) {
            return;
        }
        gloomyfolken.mods.effects.client.mcsa.kjui kjui2 = this._d.get((Object)gphy2)._a;
        ezfc._a();
        if (kjui2 != null) {
            ezfc._a((float)d + 0.5f, (float)d2, (float)d3 + 0.5f);
            if (gphy2._e) {
                int n = hurg2.field_70331_k.func_72805_g(hurg2.field_70329_l, hurg2.field_70330_m, hurg2.field_70327_n);
                ezfc._a(90.0f * (float)n, 0.0f, 1.0f, 0.0f);
            }
            (bl ? kjui2._c : kjui2._d).renderAll();
        }
        ezfc._b();
        ++_b;
    }

    public float _a(twgu twgu2) {
        kjui kjui2 = this._d.get(twgu2);
        if (kjui2 == null) {
            return 0.0f;
        }
        return kjui2._b;
    }

    private static class kjui {
        final gloomyfolken.mods.effects.client.mcsa.kjui _a;
        final float _b;

        public kjui(String string, String string2, String string3, float f) {
            ResourceLocation resourceLocation = new ResourceLocation(string);
            if (string3 == null) {
                if (string2 == null) {
                    this._a = new gloomyfolken.mods.effects.client.mcsa.kjui(resourceLocation);
                } else {
                    ResourceLocation resourceLocation2 = new ResourceLocation(string2);
                    this._a = new gloomyfolken.mods.effects.client.mcsa.kjui(resourceLocation, resourceLocation2);
                }
            } else {
                ResourceLocation resourceLocation3 = new ResourceLocation(string3);
                this._a = gloomyfolken.mods.effects.client.mcsa.kjui._a(resourceLocation, resourceLocation3);
            }
            this._b = f * f;
        }
    }
}

