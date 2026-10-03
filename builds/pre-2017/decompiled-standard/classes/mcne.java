/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.weapon.ugqx;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

public class mcne {
    private xpzm _g;
    public ihfz _a;
    public divz _b;
    public mcqq _c;
    public boolean _d = false;
    public boolean _e = false;
    public static String _f = "\u041c\u0438\u0448\u0435\u043d\u044c";
    private ResourceLocation _h = new ResourceLocation("stalkerguide", "textures/gui/overlay_medicine.png");
    private ResourceLocation _i = new ResourceLocation("stalkerguide", "textures/gui/overlay_arts.png");
    private ResourceLocation _j = new ResourceLocation("stalkerguide", "textures/gui/overlay_backpack.png");
    private ResourceLocation _k = new ResourceLocation("stalkerguide", "textures/gui/overlay_detectors.png");

    public mcne() {
        this._g = xpzm._E();
    }

    public void _a(Configuration configuration) {
        Logger.info("Stalkerguide client init!", new Object[0]);
        _f = configuration.get("other", "dummy", _f).getString();
        this._b = new divz();
        this._c = new mcqq(this._b, configuration);
        this._a = ihfz._c;
        this._a._a(this._b);
        MinecraftForge.EVENT_BUS.register(new ihco(this._b, this._c));
    }

    public void _a(boolean bl, int n) {
        this._d = !bl;
        this._c._a();
        if (this._d) {
            this._c._a(xpzm._E()._t, n);
        }
    }

    public void _a(int n) {
        if (this._d) {
            this._c._f = n;
        }
    }

    public void _a(nuis nuis2, int n, int n2, float f) {
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        qnon._a();
        iwya._a(iwya._b, 240.0f, 240.0f);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        if (this._b._i() != null) {
            switch (this._b._i()._b().toLowerCase()) {
                case "eatShit": 
                case "medicine": {
                    xpzm._E()._h._a(this._h);
                    break;
                }
                case "backpack": {
                    xpzm._E()._h._a(this._j);
                    break;
                }
                case "detector": {
                    xpzm._E()._h._a(this._k);
                    break;
                }
                default: {
                    return;
                }
            }
            GL11.glTranslated(nuis2.field_74198_m, nuis2.field_74197_n, 0.0);
            this._a(n, n2);
            GL11.glTranslated(-nuis2.field_74198_m, -nuis2.field_74197_n, 0.0);
        }
        if (this._g._t.field_71071_by._g() == null && nuis2._a(n, n2) != null && nuis2._a(n, n2).func_75216_d()) {
            Object object = nuis2._a(n, n2).func_75211_c();
            nuis2._a((cvzo)object, n, n2);
        }
        GL11.glDisable(3042);
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        qnon._b();
    }

    private void _a(int n, int n2) {
        GuiRenderer guiRenderer = new GuiRendererBuilder().setTextureSize(454, 397).create();
        guiRenderer.drawTexturedModalRect(0, -34, 0, 0, 454, 397);
    }

    public void _a() {
        ugqx ugqx2 = ugqx._a(xpzm._E()._t);
        if (this._g._t.func_70694_bm() == null) {
            return;
        }
        nusq nusq2 = wolf._C(this._g._t.func_70694_bm());
        if (nusq2 == null) {
            return;
        }
        if (nusq2._b == nusq.kjui._a) {
            if (ugqx2._g().equals((Object)ugqx.kjui._b)) {
                this._a(3);
            } else {
                this._a(1);
            }
        } else if (nusq2._b == nusq.kjui._b) {
            if (ugqx2._g().equals((Object)ugqx.kjui._b)) {
                this._a(8);
            } else {
                this._a(2);
            }
        }
    }
}

