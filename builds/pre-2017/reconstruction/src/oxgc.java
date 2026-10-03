/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.font.SdfFont;
import gloomyfolken.mods.stalker.clans.pidb;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import mods.pda.client.minimap.MapCanvas;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

public abstract class oxgc
implements MapCanvas.MapRenderer {
    private long _a = 0L;

    @Override
    public boolean mouseClicked(MapCanvas mapCanvas, int n2, int n3, int n4) {
        if (this._a() == null || !this._c()) {
            return false;
        }
        List<pidb.tupg> list2 = this._a()._g();
        Integer n5 = (Integer)mapCanvas.findObjectUnderMouse(IntStream.range(0, list2.size()).filter(n -> ((pidb.tupg)list2.get(n))._a(Minecraft._E()._t)).mapToObj(n -> {
            pidb.tupg tupg2 = (pidb.tupg)list2.get(n);
            Vector2f vector2f = new Vector2f(tupg2._h()._c(), tupg2._h()._e());
            float f = tupg2 instanceof pidb.ezey ? 28.0f : 20.0f;
            return pzop._a(n, vector2f, Float.valueOf(f));
        }).collect(Collectors.toList()), new Point(n2, n3));
        if (n5 == null) {
            return false;
        }
        this._a(n5);
        this._a = System.currentTimeMillis();
        return true;
    }

    @Override
    public void drawMapObjects(MapCanvas mapCanvas, float f) {
        if (this._a() == null) {
            return;
        }
        this._a(mapCanvas);
    }

    private void _a(MapCanvas mapCanvas) {
        pidb pidb2 = this._a();
        int n = 0;
        List<pidb.tupg> list2 = pidb2._g();
        int n2 = this._b();
        for (int i = 0; i < list2.size(); ++i) {
            pidb.tupg tupg2 = list2.get(i);
            einh einh2 = tupg2._h();
            Vector2f vector2f = mapCanvas.worldCoordsToScreen(einh2._c(), einh2._e());
            float f = 14.0f;
            int n3 = tupg2._g();
            boolean bl = i == n2;
            boolean bl2 = mapCanvas.getMapName().contains("minimap");
            boolean bl3 = mapCanvas.isMapUnderCursor(vector2f.x - f, vector2f.y - f, vector2f.x + f, vector2f.y + f);
            if (bl3) {
                mapCanvas.pendingTooltip = this._a(i, tupg2);
            }
            if (mapCanvas.pendingTooltip != null && !mapCanvas.pendingTooltip.isEmpty()) {
                n3 |= 0x646464;
            }
            if (tupg2 instanceof pidb.eidj) {
                pidb.eidj eidj2 = (pidb.eidj)tupg2;
                String string = eidj2._j()._c();
                if (bl3 && !string.isEmpty()) {
                    mapCanvas.pendingTooltip = (Object)((Object)EnumChatFormatting._o) + string + (mapCanvas.pendingTooltip != null ? "\n" + mapCanvas.pendingTooltip : "");
                }
                this._a(mapCanvas, vector2f, eidj2, bl2, n++, f, n3, bl);
                continue;
            }
            if (!(tupg2 instanceof pidb.ezey)) continue;
            this._a(mapCanvas, vector2f, (pidb.ezey)tupg2, bl2, f, n3, bl);
        }
    }

    protected String _a(int n, pidb.tupg tupg2) {
        if (n != this._b() && tupg2._a(Minecraft._E()._t)) {
            return "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 \u0447\u0442\u043e\u0431\u044b \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c \u0442\u043e\u0447\u043a\u0443 \u0432\u043e\u0437\u0440\u043e\u0436\u0434\u0435\u043d\u0438\u044f";
        }
        return null;
    }

    private void _a(MapCanvas mapCanvas, Vector2f vector2f, pidb.eidj eidj2, boolean bl, int n, float f, int n2, boolean bl2) {
        float f2 = (float)(eidj2._a() == null ? 1.0 : eidj2._c());
        float f3 = 0.5f / (bl ? mapCanvas.getZoom() : 1.0f);
        if (bl) {
            this._a(mapCanvas, eidj2);
        }
        yuch._a(vector2f.x * 2.0f, vector2f.y * 2.0f, f2, n2, n2, 106, 261, 4, 261, 91, 91.0f * f3);
        String string = String.valueOf((char)(n + 65));
        if (bl2 && !bl) {
            f = (float)((double)f - 4.5);
            iedw._a(vector2f.x - (f *= this._d()), vector2f.y - f, 135);
            iedw._a(vector2f.x + f, vector2f.y + f, 315);
            iedw._a(vector2f.x + f, vector2f.y - f, 225);
            iedw._a(vector2f.x - f, vector2f.y + f, 45);
        }
        SdfFont.tahoma.renderCenteredString(vector2f.x - 1.5f, vector2f.y - 6.5f, string, -1358954496L, false, 10.0f, SdfFont.FontWeight.Bold.INSTANCE);
    }

    private void _a(MapCanvas mapCanvas, pidb.eidj eidj2) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawing(2);
        tessellator.setColorRGBA_I(0x939393, 175);
        List<Point2D> list2 = eidj2._j()._k();
        ArrayList<Vector2f> arrayList = new ArrayList<Vector2f>(list2.size());
        for (Point2D object : list2) {
            Vector2f vector2f = mapCanvas.worldCoordsToScreen((float)object.getX(), (float)object.getY(), new Vector2f());
            arrayList.add(vector2f);
            tessellator.addVertex(vector2f.x, vector2f.y, 0.0);
        }
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        tessellator.draw();
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        Minecraft._E()._R()._a(iedw._a);
        tessellator.startDrawingQuads();
        for (Vector2f vector2f : arrayList) {
            float f = vector2f.x - 1.25f;
            float f2 = vector2f.y - 1.25f;
            float f3 = 2.5f;
            float f4 = 2.5f;
            float f5 = 390.0f;
            float f6 = 815.0f;
            float f7 = 9.765625E-4f;
            tessellator.setColorRGBA_I(0x939393, 175);
            tessellator.addVertexWithUV(f + f3, f2, 0.0, (f5 + f3 * 4.0f) * f7, f6 * f7);
            tessellator.addVertexWithUV(f, f2, 0.0, f5 * f7, f6 * f7);
            tessellator.addVertexWithUV(f, f2 + f4, 0.0, f5 * f7, (f6 + f4 * 4.0f) * f7);
            tessellator.addVertexWithUV(f + f3, f2 + f4, 0.0, (f5 + f3 * 4.0f) * f7, (f6 + f4 * 4.0f) * f7);
        }
        tessellator.draw();
    }

    private void _a(MapCanvas mapCanvas, Vector2f vector2f, pidb.ezey ezey2, boolean bl, float f, int n, boolean bl2) {
        GL11.glEnable(3042);
        float f2 = 0.5f;
        Minecraft._E()._R()._a(hbqf._a);
        GL11.glColor4f((float)(n >> 16 & 0xFF) / 255.0f, (float)(n >> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f, (float)(n >> 24 & 0xFF) / 255.0f);
        float f3 = vector2f.x - 22.5f * f2;
        float f4 = vector2f.y - 22.5f * f2;
        qozx._a(f3, f4, 45.0f * f2, 45.0f * f2, 1.0, 188.0, 71.0, 258.0, 512.0, 512.0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        if (bl2 && !bl) {
            iedw._a(vector2f.x - (f *= this._d()), vector2f.y, 90);
            iedw._a(vector2f.x + f, vector2f.y, 270);
            iedw._a(vector2f.x, vector2f.y - f, 180);
            iedw._a(vector2f.x, vector2f.y + f, 0);
        }
    }

    private float _d() {
        return zftb._f._a(Math.min(System.currentTimeMillis() - this._a, 499L), 1.5f, -0.5f, 500.0f);
    }

    public abstract pidb _a();

    public abstract int _b();

    public abstract void _a(int var1);

    public abstract boolean _c();
}

