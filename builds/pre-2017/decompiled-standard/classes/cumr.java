/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.ImmutableMap;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.stalker.respawn.RespawnMod;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import org.lwjgl.opengl.GL11;

public class cumr
extends jzaw<cupm> {
    private static final Dimension _l = new Dimension(160, 138);
    public static final Map<String, Point> _k = ImmutableMap.builder().put("psycho", new Point(7, 177)).put("thermal", new Point(167, 177)).put("radiation", new Point(6, 345)).put("biological", new Point(165, 345)).put("bleeding", new Point(325, 345)).build();
    private int _m = 20;
    private Point _n = null;

    @Override
    protected void _a() {
        if (this._i) {
            this._b();
            if (((cupm)this._h)._f != null) {
                this._a(((cupm)this._h)._f);
            }
        }
    }

    private void _b() {
        String string = ((cupm)this._h)._e;
        this._n = _k.get(string);
        boolean bl = this._n != null;
        ArrayList<String> arrayList = new ArrayList<String>(RespawnMod.instance._f.get(string));
        if (arrayList.isEmpty()) {
            return;
        }
        GuiRenderer guiRenderer = bl ? this.renderer : new GuiRendererBuilder().setFontRenderer(ExternalFont.tahoma18).create();
        String string2 = (String)arrayList.get(ThreadLocalRandom.current().nextInt(arrayList.size()));
        List<String> list = guiRenderer.wrapString(string2, 300);
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        for (int i = 0; i < list.size(); ++i) {
            String string3 = list.get(i);
            GuiHelper.addLabel(this, string3, point.add(-91 - guiRenderer.getStringWidth(string3) / 2, (bl ? -220 : -100) + 25 * i)).setRenderer(guiRenderer);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        if (this._n != null) {
            this.renderer.bindTexture(jzaw._b);
            float f2 = 1.0f - (float)this._m / 20.0f;
            GL11.glColor4f(1.0f, 1.0f, 1.0f, f2);
            this.renderer.drawTexturedModalRect(this.screenWidth / 2 - 91 - cumr._l.width / 2, this.screenHeight / 2 - 140, this._n.x, this._n.y, cumr._l.width, cumr._l.height);
        }
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        if (this._i && this._m > 0) {
            --this._m;
        }
    }
}

