/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Sets;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McRect;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.engine.component.McViewport;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.stalker.clans.pidb;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import mods.chat.ChatMod;
import mods.chat.client.ChatHud;
import mods.pda.client.PdaClient;
import mods.pda.client.component.MapComponent;
import mods.pda.client.component.PdaBackground;
import mods.pda.client.map.render.DefaultMapRenderer;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.lwjgl.util.vector.Vector2f;

public class ogia
extends GuiScreenAdvanced
implements qlgl.kjui {
    public static final ComponentButtonStyle _a = new ComponentButtonStyle(){
        {
            this.setTexture(iedw._a);
            this.setDefaultUv(488, 800);
            this.setMouseOverUv(this.getDefaultUv());
            this.setSize(13, 13);
        }
    };
    private final pidb _c;
    private final amxi _d;
    private McScrollPane _e;
    private GuiComponentsList<McToolTip> _f = new GuiComponentsList(this);
    private List<String> _g = new ArrayList<String>();
    private List<String> _h = new ArrayList<String>();
    private int _i = 0;
    private McButton _j;
    private McLabel _k;
    public long _b;

    public ogia(pidb pidb2, long l) {
        super(new GuiRendererBuilder().setTextureSize(1024, 1024).setFontRenderer(ExternalFont.tahoma12).create());
        this._c = pidb2;
        this._d = pidb2._b();
        this.closeOnEsc = false;
        this._b = l;
        new ncaj(pidb2._q()).sendClientToBackend();
    }

    @Override
    public void initGui() {
        super.initGui();
        this._f.clearElements();
        int n = (this.screenHeight - this._d() - 9) / 2;
        this.addElement(new PdaBackground(this, Point.zeroPoint, new Dimension(379, n), true));
        this.addElement(new PdaBackground(this, new Point(0, n + 4), new Dimension(379, n), true));
        this._b(n);
        this._a(n);
        this._e();
        this._f();
        this.addElement(this._f);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        this._j.setEnabled(this._c._m());
        if (this._j.getEnabled()) {
            int n = this._a();
            boolean bl = n >= 0 && n < this._c._g().size();
            this._j.setEnabled(bl);
            this._k.setVisible(!bl);
        }
        long l = this._c();
        if (this._j.getEnabled()) {
            this._j.setEnabled(l <= 0L);
        }
        this._j.text = "\u0412 \u0431\u043e\u0439!" + (l > 0L ? " [" + (l / 1000L + 1L) + "]" : "");
    }

    @Override
    protected void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        if (ChatMod.instance.chatKeyBinding._d == n) {
            ChatHud chatHud = ChatMod.instance.chatHud;
            chatHud.active = true;
            chatHud.getChat().setParentScreen(this);
            this.mc._a(chatHud.getChat());
        }
    }

    public int _a() {
        return yuch._d;
    }

    private String _b() {
        LocalTime localTime;
        LocalTime localTime2;
        String string;
        boolean bl = this._c._m();
        if (bl) {
            string = "\u0414\u043e \u043e\u043a\u043e\u043d\u0447\u0430\u043d\u0438\u044f \u0431\u043e\u044f: ";
            localTime2 = qlxw._c._d().toLocalTime();
            localTime = this._c._b()._l();
        } else {
            string = "\u0414\u043e \u043d\u0430\u0447\u0430\u043b\u0430 \u0431\u043e\u044f: ";
            localTime2 = qlxw._b._d().toLocalTime();
            localTime = this._c._b()._k();
        }
        long l = Math.max(0L, localTime2.until(localTime, ChronoUnit.MILLIS));
        return string + DurationFormatUtils.formatDuration(l, "HH:mm:ss");
    }

    private long _c() {
        return Math.max(0L, this._b + this._d._y().toMillis() - qlxw._c._e());
    }

    private void _a(int n) {
        String string;
        int n2;
        HashSet<String> hashSet = new HashSet<String>(this._g);
        HashSet<String> hashSet2 = new HashSet<String>(this._h);
        int n3 = this._i - Sets.union(hashSet, hashSet2).size();
        this.addElement(new McLabel((IAdvancedGui)this, "\u0421\u0432\u043e\u0431\u043e\u0434\u043d\u043e: " + n3, new Point(189, 6 + n + 3), 0x939393).setFontRenderer(ExternalFont.tahoma16).setCentered());
        ArrayList<String> arrayList = new ArrayList<String>(Sets.difference(hashSet2, hashSet));
        int n4 = this._g.size() + arrayList.size();
        McScrollPane mcScrollPane = GuiHelper.createScrollPane((IAdvancedGui)this, new Point(10, n + 41), new Dimension(363, n - 45), new Dimension(363, n4 * 21), true, iedw._j, iedw._k);
        for (n2 = 0; n2 < this._g.size(); ++n2) {
            String string2 = this._g.get(n2);
            string = n2 + 1 + ". " + string2;
            mcScrollPane.getViewport().addElement(new McLabel((IAdvancedGui)this, string, new Point(0, n2 * 21), 0x939393));
            if (string2.equals(this.mc._t.username) || !yuch._a._c.contains((Object)amww._g)) continue;
            McButton mcButton = GuiHelper.addButton(mcScrollPane.getViewport(), new Point(330, n2 * 21 + 5), new Dimension(13, 13), _a, "").onClick(guiActionButtonClick -> {
                new rols(string2).sendClientToBackend();
                this._g.remove(string2);
                this.setWorldAndResolution(this.mc, this.width, this.height);
            });
            this._f.addElement(new McToolTip((IAdvancedGui)this, Collections.singletonList("\u0418\u0441\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u0441 \u0437\u0430\u0445\u0432\u0430\u0442\u0430"), mcButton));
        }
        for (n2 = 0; n2 < arrayList.size(); ++n2) {
            int n5 = this._g.size() + n2;
            string = n2 + 1 + ". \u0417\u0430\u0440\u0435\u0437\u0435\u0440\u0432\u0438\u0440\u043e\u0432\u0430\u043d\u043e \u0434\u043b\u044f " + (String)arrayList.get(n2);
            mcScrollPane.getViewport().addElement(new McLabel((IAdvancedGui)this, string, new Point(0, n5 * 21), 0x939393));
        }
        if (mcScrollPane.getVerticalScrollBar() != null) {
            mcScrollPane.getTopButton().move(0, -16);
            mcScrollPane.getBottomButton().move(0, -4);
            mcScrollPane.getVerticalScrollBar().move(0, -16);
            mcScrollPane.getVerticalScrollBar().setLength(mcScrollPane.getVerticalScrollBar().getLength() + 10);
            mcScrollPane.getVerticalScrollBar().setSliderLength(16);
            if (this._e != null && this._e.getVerticalScrollBar() != null) {
                mcScrollPane.getVerticalScrollBar().pos = this._e.getVerticalScrollBar().pos;
            }
        }
        this.addElement(mcScrollPane);
        this._e = mcScrollPane;
    }

    private void _b(int n) {
        this.addElement(new McLabel((IAdvancedGui)this, this::_b, new Point(189, 6), 0x939393).setFontRenderer(ExternalFont.tahoma16).setCentered());
        this.addElement(new McLabel((IAdvancedGui)this, this._d._e(), new Point(189, 50), 0x939393).setFontRenderer(ExternalFont.tahoma18).setCentered());
        this.addElement(new McRect(this, new Point(10, 91), new Dimension(343, 1), 0x33939393));
        List<pidb.pidb> list = this._c._c();
        int n2 = list.size();
        McScrollPane mcScrollPane = GuiHelper.createScrollPane((IAdvancedGui)this, new Point(10, 100), new Dimension(363, n - 108), new Dimension(363, n2 * 87), true, iedw._j, iedw._k);
        for (int i = 0; i < n2; ++i) {
            pidb.pidb pidb2 = list.get(i);
            int n3 = this._c._l().get(pidb2._b());
            String string = pidb2._b();
            Point point = new Point(0, i * 87);
            Dimension dimension = new Dimension(343, 82);
            McViewport mcViewport = mcScrollPane.getViewport();
            mcViewport.addElement(new McBackground(this, point, dimension).setTexture(iedw._a).setTextureCoords(new Point(128, 931)).setTextureSize(new Dimension(64, 27)).setResizeBorder(5));
            mcViewport.addElement(new McBackground(this, point.add(18, 13), new Dimension(34, 19)).setTexture(iedw._a).setTextureCoords(new Point(128, 931)).setTextureSize(new Dimension(64, 27)).setResizeBorder(5));
            mcViewport.addElement(new McRect(this, point.add(20, 15), new Dimension(30, 15), n3));
            mcViewport.addElement(new McLabel((IAdvancedGui)this, "\"" + string + "\"", point.add(60, 15), 0x939393));
            mcViewport.addElement(new McLabel((IAdvancedGui)this, () -> "\u041e\u0447\u043a\u043e\u0432: " + (int)pidb2._c(), point.add(18, 38), 0x939393));
            mcViewport.addElement(new McLabel((IAdvancedGui)this, () -> "\u0411\u0430\u0437 \u043f\u043e\u0434 \u043a\u043e\u043d\u0442\u0440\u043e\u043b\u0435\u043c: " + pidb2._a().size(), point.add(18, 58), 0x939393));
        }
        if (mcScrollPane.getVerticalScrollBar() != null) {
            mcScrollPane.getTopButton().move(0, -80);
            mcScrollPane.getBottomButton().move(0, -4);
            mcScrollPane.getVerticalScrollBar().move(0, -80);
            mcScrollPane.getVerticalScrollBar().setLength(mcScrollPane.getVerticalScrollBar().getLength() + 74);
            mcScrollPane.getVerticalScrollBar().setSliderLength(16);
        }
        this.addElement(mcScrollPane);
    }

    private int _d() {
        return (int)(0.11666667f * (float)this.screenHeight);
    }

    private void _e() {
        Object object;
        Point point = new Point(380, 0);
        Dimension dimension = new Dimension(this.screenWidth - 382, this.screenHeight - this._d() - 5);
        this.addElement(new PdaBackground(this, point, dimension, true));
        this.addElement(new McBackground(this, point.add(10, dimension.height - 25), new Dimension(dimension.width - 35, 17)).setTexture(iedw._a).setTextureSize(new Dimension(62, 14)).setResizeBorder(2).setTextureCoords(new Point(0, 796)));
        MapComponent mapComponent = new MapComponent(this, point.add(10, 35), dimension.add(-35, -65));
        mapComponent.setEnablePageSwitches(false);
        mapComponent.canvas().setMapPage(this._c._p(), true);
        mapComponent.canvas().displayPlayerPos();
        mapComponent.canvas().addObjectRenderer(new DefaultMapRenderer(PdaClient.mapSettings));
        mapComponent.canvas().setZoom(mapComponent.canvas().getMaxZoom() / 2.0f);
        int n = this._a();
        if (n != -1) {
            object = yuch._c._g().get(n)._h();
            mapComponent.canvas().setInitialMapCoords(new Vector2f((float)((einh)object)._c, (float)((einh)object)._e));
        } else {
            mapComponent.canvas().displayPlayerPos();
        }
        object = new McScrollBar((IAdvancedGui)this, (IScrollable)mapComponent, McScrollBar.ScrollBarType.VERTICAL, point.add(dimension.width - 17, 23), dimension.height - 35, iedw._j.getVerticalBarStyle());
        ((McScrollBar)object).setEnableWheelHandling(false);
        this.addElement((GuiComponent)object);
        mapComponent.setVerticalBar((McScrollBar)object);
        McScrollBar mcScrollBar = new McScrollBar((IAdvancedGui)this, (IScrollable)mapComponent, McScrollBar.ScrollBarType.HORIZONTAL, mapComponent.getLocation().add(2, mapComponent.getSize().height + 9), mapComponent.getSize().width - 5, iedw._j.getHorizontalBarStyle());
        mcScrollBar.setEnableWheelHandling(false);
        this.addElement(mcScrollBar);
        mapComponent.setHorizontalBar(mcScrollBar);
        this.addElement(mapComponent);
        mapComponent.init();
    }

    private void _f() {
        int n = this._d();
        GuiRenderer guiRenderer = this.renderer.setFont(ExternalFont.tahoma18);
        int n2 = this.screenWidth / 4;
        Dimension dimension = new Dimension(n2, n);
        int n3 = this.screenHeight - n - 3;
        GuiHelper.addButton(this, new Point(0, n3), dimension, iedw._l, "\u0417\u0430\u0440\u0435\u0437\u0435\u0440\u0432\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u044b\u0435 \u0441\u043b\u043e\u0442\u044b").onClick(guiActionButtonClick -> this.mc._a(new zxjf(this, this._c._q(), true))).setRenderer(guiRenderer).setEnabled(yuch._a._c.contains((Object)amww._g));
        GuiHelper.addButton(this, new Point(n2, n3), dimension, iedw._l, "\u041f\u043e\u043a\u0438\u043d\u0443\u0442\u044c \u0431\u043e\u0439").onClick(guiActionButtonClick -> new srot().sendToServer()).setRenderer(guiRenderer);
        GuiHelper.addButton(this, new Point(2 * n2, n3), dimension, iedw._l, "\u0421\u043d\u0430\u0440\u044f\u0436\u0435\u043d\u0438\u0435").onClick(guiActionButtonClick -> this.mc._a(new oxjw(this))).setRenderer(guiRenderer);
        this._j = GuiHelper.addButton(this, new Point(3 * n2, n3), dimension, iedw._l, "\u0412 \u0431\u043e\u0439!").onClick(guiActionButtonClick -> new sros(this._a()).sendToServer());
        this._j.setRenderer(guiRenderer);
        this._j.setEnabled(this._c._m());
        this._k = new McLabel((IAdvancedGui)this, "\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0442\u043e\u0447\u043a\u0443 \u0432\u043e\u0437\u0440\u043e\u0436\u0434\u0435\u043d\u0438\u044f", Point.zeroPoint, -65536);
        this._k.setCentered(3 * n2 + dimension.width / 2, n3 + n / 4 * 3);
        this.addElement(this._k);
        this._k.setVisible(false);
    }

    @Override
    public void _a(List<String> list, List<String> list2, List<String> list3, int n) {
        this._h = list;
        this._g = list2;
        this._i = n;
        this.setWorldAndResolution(this.mc, this.width, this.height);
    }
}

