/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.stats.StatsType;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McDummySlot;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.stalker.respawn.RespawnMod;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import mods.pda.PdaMod;
import mods.pda.client.component.MapComponent;
import mods.pda.client.minimap.MapCanvas;
import mods.pda.client.waypoint.DeathWaypoint;
import mods.pda.client.waypoint.MapWaypoint;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

public class jzaw<T extends vlfg>
extends GuiScreenAdvanced
implements MapCanvas.MapRenderer {
    public static final ResourceLocation _a = new ResourceLocation("stalker", "textures/gui/death_bg.png");
    public static final ResourceLocation _b = new ResourceLocation("stalker", "textures/gui/death_elements.png");
    public static final GuiRenderer _c = new GuiRendererBuilder().setFontRenderer(ExternalFont.tahoma14).setTextureSize(512, 512).create();
    public static final GuiRenderer _d = new GuiRendererBuilder(GuiHelper.mcWidgetsRenderer).setFontRenderer(ExternalFont.tahoma12).create();
    public static final GuiRenderer _e = GuiHelper.mcWidgetsRenderer;
    private static final int _k = 200;
    private static final float _l = 50.0f;
    private static final String _m = "\u0412\u043e\u0437\u0440\u043e\u0434\u0438\u0442\u044c\u0441\u044f";
    protected GuiComponentsList<McToolTip> _f;
    private List<Pair<String, String>> _n;
    private int _o = 0;
    private int _p = 0;
    private int _q = 200;
    protected MapComponent _g;
    private kjui _r;
    protected T _h = new vlfg();
    protected boolean _i = false;
    protected DeathWaypoint _j;

    public jzaw() {
        super(_c);
        if (RespawnMod.instance._e != null) {
            this._h = RespawnMod.instance._e;
        }
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this._n = new ArrayList<Pair<String, String>>();
        this._f = new GuiComponentsList(this);
        this._r = new kjui((IAdvancedGui)this, new Point(this.screenWidth / 2 - 220, this.screenHeight / 2 + 200), GuiHelper.mcButtonStyle, _m);
        this._r.setSize(new Dimension(190, 38));
        this._r.onClick(guiActionButtonClick -> this.field_73882_e._t.field_71174_a._b(new ndnf(1)));
        this._r.setEnabled(false);
        this._r.setRenderer(_d);
        this.addElement(this._r);
        McButton mcButton = GuiHelper.addButton(this, new Point(this.screenWidth / 2 + 30, this.screenHeight / 2 + 200), new Dimension(190, 38), "\u0413\u043b\u0430\u0432\u043d\u043e\u0435 \u043c\u0435\u043d\u044e").onClick(guiActionButtonClick -> this._b());
        mcButton.setRenderer(_d);
        boolean bl = this._i = ((vlfg)this._h)._b != null;
        if (this._i) {
            this._c();
            this._a();
            this._d();
        }
        this.addElement(this._f);
    }

    protected void _a() {
        GuiRenderer guiRenderer = new GuiRendererBuilder().setFontRenderer(ExternalFont.tahoma18).create();
        String string = "\u0412\u044b \u043f\u043e\u0433\u0438\u0431\u043b\u0438";
        GuiHelper.addLabel((IAdvancedGui)this, string, new Point(this.screenWidth / 2 - guiRenderer.getStringWidth(string) / 2 - 91, this.screenHeight / 2 - 100), -1).setRenderer(guiRenderer);
    }

    private void _b() {
        this.field_73882_e._r.func_72882_A();
        this.field_73882_e._a((pkix)null);
        this.field_73882_e._a(new fngq());
    }

    private void _c() {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        this._g = new MapComponent(this, new Point(this.screenWidth / 2 + 81, this.screenHeight / 2 - 242), new Dimension(163, 163), false, "death_map");
        this._g.canvas().setInitialMapCoords(new Vector2f((float)entityClientPlayerMP.field_70165_t, (float)entityClientPlayerMP.field_70161_v));
        this._g.setEnablePageSwitches(false);
        this._g.canvas().addObjectRenderer(this);
        this._g.canvas().setZoom(1.0f);
        this._g.canvas().playerIconScale = 0.0f;
        this._g.canvas().setBoundsRestriction(false);
        this.addElement(this._g);
        this._g.init();
        this._g.setEnabled(false);
    }

    private void _d() {
        Map<String, Pair<Object, Object>> map = ((vlfg)this._h)._b._a();
        for (Map.Entry<String, Pair<Object, Object>> entry : map.entrySet()) {
            Stat stat = Stat.getById(entry.getKey());
            if (stat == null) continue;
            StatsType statsType = stat.type;
            Pair<Object, Object> pair = entry.getValue();
            String string = statsType.diff(pair.getLeft(), pair.getRight());
            this._n.add(Pair.of(stat.title, (Object)((Object)ezfc._o) + string));
        }
        this._o = (int)Math.ceil((double)this._n.size() / 4.0);
    }

    protected void _a(oxoq oxoq2) {
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        String string = "\u041f\u0440\u0438 \u043f\u043e\u0434\u0434\u0435\u0440\u0436\u043a\u0435:";
        GuiHelper.addLabel((IAdvancedGui)this, string, point.add(-this.renderer.getStringWidth(string) / 2 + 165, -65), -1);
        String string2 = oxoq2._d();
        GuiHelper.addLabel((IAdvancedGui)this, (Object)((Object)ezfc._o) + string2, point.add(-this.renderer.getStringWidth(string2) / 2 + 165, -40), -1);
        this._a(oxoq2._e(), point.add(120, 0), 1.0f, true);
        this._a(oxoq2._f(), point.add(165, 0), 1.0f, true);
    }

    protected void _a(cvzo cvzo2, Point point, float f, boolean bl) {
        Object object;
        if (bl) {
            object = f == 2.0f ? new Dimension(76, 76) : new Dimension(44, 44);
            Point point2 = f == 2.0f ? new Point(128, 1) : new Point(30, 17);
            McImage mcImage = new McImage((IAdvancedGui)this, point.add(-2, -1), point2, (Dimension)object, _b);
            this.addElement(mcImage);
        }
        object = new McDummySlot(this, cvzo2, point.x + 4, point.y + 4, f);
        ((McDummySlot)object).setRenderer(_e);
        this.addElement((GuiComponent)object);
        if (cvzo2 != null) {
            this._f.addElement(((McDummySlot)object).createToolTip());
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73733_a(0, 0, this.field_73880_f, this.field_73881_g, 0x60500000, -1602211792);
        GL11.glEnable(3042);
        _c.bindTexture(_a);
        _c.drawTexturedModalRect(this.screenWidth / 2 - 256, this.screenHeight / 2 - 256, 0, 0, 512, 512);
        this._e();
        super.func_73863_a(n, n2, f);
    }

    private boolean _e() {
        if (this._n.isEmpty()) {
            return false;
        }
        int n = this._p * 4;
        Point point = new Point(this.screenWidth / 2 - 235, this.screenHeight / 2 + 93);
        float f = this._o > 1 ? 1.0f - Math.max(0.0f, (float)(-this._q) + 50.0f) / 50.0f : 1.0f;
        int n2 = 0xFFFFFF + ((int)(f * 250.0f) << 24);
        for (int i = n; i < n + 4; ++i) {
            if (i >= this._n.size()) continue;
            Pair<String, String> pair = this._n.get(i);
            _d.drawString(pair.getLeft(), point.x, point.y + i % 4 * 23, n2);
            _d.drawString(pair.getRight(), point.x + 470 - _d.getStringWidth(pair.getRight()), point.y + i % 4 * 23, n2);
        }
        return true;
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        --this._q;
        if (this._q <= 0 && this._o > 0) {
            this._p = (this._p + 1) % this._o;
            this._q = 200;
        }
        this._r._a = (float)((vlfg)this._h)._d / (float)((vlfg)this._h)._c;
        if (((vlfg)this._h)._d > 0) {
            --((vlfg)this._h)._d;
            this._r.text = "\u0412\u043e\u0437\u0440\u043e\u0434\u0438\u0442\u044c\u0441\u044f [" + (((vlfg)this._h)._d / 20 + 1 >= 60 ? ((vlfg)this._h)._d / 1200 + " \u043c\u0438\u043d." : ((vlfg)this._h)._d / 20 + 1 + " \u0441\u0435\u043a.") + "]";
            this._r.setEnabled(false);
        } else {
            this._r.text = _m;
            this._r.setEnabled(true);
        }
    }

    @Override
    protected void func_73869_a(char c, int n) {
        this.elementsList.keyTyped(c, n);
    }

    @Override
    public void drawMapObjects(MapCanvas mapCanvas, float f) {
        List<MapWaypoint> list = PdaMod.getClientPda().waypoints.getWaypointList();
        for (int i = list.size() - 1; i >= 0; --i) {
            MapWaypoint mapWaypoint = list.get(i);
            if (!(mapWaypoint instanceof DeathWaypoint)) continue;
            if (mapWaypoint != this._j) {
                this._j = (DeathWaypoint)mapWaypoint;
                mapCanvas.setInitialMapCoords(new Vector2f(this._j.worldPos().x, this._j.worldPos().z));
            }
            mapCanvas.drawWaypoints(Collections.singletonList(mapWaypoint), false);
            break;
        }
    }

    public static class kjui
    extends McButton {
        public float _a = 0.0f;

        public kjui(IAdvancedGui iAdvancedGui, Point point, ComponentButtonStyle componentButtonStyle, String string) {
            super(iAdvancedGui, point, componentButtonStyle, string);
        }

        @Override
        public void drawComponent(Point point, float f) {
            super.drawComponent(point, f);
            if (this.getVisible()) {
                this.renderer.drawRect(this.getLocation().x + 5, this.getLocation().y + 5, (float)(this.getSize().width - 10) * this._a, this.getSize().height - 10, 0x7FFF0000);
            }
        }
    }
}

