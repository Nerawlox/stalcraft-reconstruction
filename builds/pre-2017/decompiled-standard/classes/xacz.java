/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.font.SdfFont;
import mods.regions.Region;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;

public class xacz {
    private Region _a;
    private klcb _b;
    private long _c = 0L;
    private GuiRenderer _d = new GuiRendererBuilder().setTextureSize(512, 512).create();

    @ForgeSubscribe
    public void _a(RenderGameOverlayEvent.Post post) {
        boolean bl;
        if (post.type != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        long l = 40L;
        long l2 = ntte._b - this._c;
        boolean bl2 = bl = this._a != null || l2 < l;
        if (!bl) {
            return;
        }
        boolean bl3 = this._a == null;
        float f = jywc._a(l2 - 1L, (float)l2, post.partialTicks);
        float f2 = f > (float)l ? 1.0f : zftb._g._a(f, 0.0f, 1.0f, l);
        float f3 = 0.2f * f;
        float f4 = (float)((double)f3 * Math.exp(1.0f - f3) * 0.4 + 0.6);
        if (bl3) {
            f2 = 1.0f - f2;
        }
        String string = "\u041e\u043f\u0430\u0441\u043d\u0430\u044f \u0437\u043e\u043d\u0430!";
        String string2 = "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0439\u0442\u0435 \u0441\u0440\u0435\u0434\u0441\u0442\u0432\u0430 \u0437\u0430\u0449\u0438\u0442\u044b";
        float f5 = (float)Math.cos(f * 0.25f);
        int n = post.resolution._a() / 2;
        int n2 = (int)((float)post.resolution._b() / 7.0f) + (this._b != null ? 40 : 0);
        if (this._b != null) {
            this._a(n, n2, f4, f2, f5);
        }
        SdfFont sdfFont = SdfFont.tahoma;
        SdfFont.FontWeight.Bold bold = SdfFont.FontWeight.Bold.INSTANCE;
        boolean bl4 = true;
        float f6 = 14.0f;
        f6 = (float)((double)f6 + (double)f5 * 0.1);
        int n3 = ((int)(f2 * 240.0f * f4 + 5.0f) << 24) + 0xFF0000;
        sdfFont.renderCenteredString(n, n2, string, n3, bl4, f6 * 1.1818181f, bold);
        sdfFont.renderCenteredString(n, n2 + 20, string2, n3, bl4, f6, bold);
    }

    private void _a(int n, int n2, float f, float f2, float f3) {
        Point point = cumr._k.get(this._b.name().toLowerCase());
        if (point != null) {
            GL11.glEnable(3042);
            GL11.glColor4d(1.0, 1.0, 1.0, (0.9 + (double)f3 * 0.1) * (double)f2 * (double)f);
            this._d.bindTexture(jzaw._b);
            this._d.drawTexturedModalRect(n * 2 - 80, n2 * 2 - 90 - 69, point.x, point.y, 160, 138);
            GL11.glColor4d(1.0, 1.0, 1.0, 1.0);
        }
    }

    public void _a(Region region) {
        if (this._a != region) {
            this._c = ntte._b;
            if (region != null) {
                this._b = null;
                yulf yulf2 = (yulf)region.get(klcd._a._d());
                if (yulf2 != null) {
                    this._b = this._a(yulf2);
                }
            }
        }
        this._a = region;
    }

    private klcb _a(yulf yulf2) {
        int n = -1;
        float[] fArray = yulf2._b();
        for (int i = 0; i < fArray.length; ++i) {
            if (!(fArray[i] > 0.0f) || n != -1 && !(fArray[n] < fArray[i])) continue;
            n = i;
        }
        if (n >= 0) {
            return klcb.values()[n];
        }
        return null;
    }
}

