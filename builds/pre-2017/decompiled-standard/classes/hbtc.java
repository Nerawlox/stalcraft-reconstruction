/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McDummySlot;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.component.McRect;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.stalker.clans.pidb;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import mods.pda.client.component.MapComponent;
import mods.pda.client.component.PdaBackground;
import mods.pda.client.component.dialog.Dialog;
import mods.pda.client.map.MapSettings;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;
import net.minecraft.client.xpzm;
import net.minecraft.util.ezfc;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

public class hbtc
extends AbstractPdaTab
implements gokg.kjui {
    private static int _a = 370;
    private static int _b = 371;
    private String _c;
    private sajz _d;

    public hbtc(IAdvancedGui iAdvancedGui, sajz sajz2) {
        super(iAdvancedGui);
        this._d = sajz2;
        this._c = sajz2._i()._d();
        this.allowParentJump = true;
    }

    public hbtc(IAdvancedGui iAdvancedGui, String string) {
        super(iAdvancedGui);
        this._c = string;
    }

    @Override
    public void requestInformation() {
        if (this._d == null && this._c != null) {
            new eigm(this._c).sendClientToBackend();
        }
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        if (this._d == null) {
            return;
        }
        this._e();
        this._d();
        this._c();
    }

    private boolean _b() {
        return this._d._c() == sajz.eidj._c || this._d._c() == sajz.eidj._d;
    }

    private void _c() {
        String string;
        Point point = this.pdaScreenStart.add(13, 38);
        int n = 0;
        if (this._d._a() == null) {
            string = "\u0421\u0432\u043e\u0431\u043e\u0434\u043d\u0430\u044f \u043b\u043e\u043a\u0430\u0446\u0438\u044f";
        } else {
            string = "\u041f\u043e\u0434 \u043a\u043e\u043d\u0442\u0440\u043e\u043b\u0435\u043c " + this._d._a();
            int n2 = this._d._b() - 1;
            if (n2 > 0) {
                String string2 = "\u0437\u0430\u0449\u0438\u0442\u0438\u043b " + n2 + " ";
                string2 = n2 > 1 && n2 < 5 ? string2 + "\u0440\u0430\u0437\u0430" : string2 + "\u0440\u0430\u0437";
                string = string + ", " + string2;
            }
        }
        this.pda.addElement(new McLabel((IAdvancedGui)this.pda, this._d._i()._e(), point.add(0, n++ * 20), 0x939393).setFontRenderer(ExternalFont.tahoma14));
        this.pda.addElement(new McRect(this.pda, point.add(-3, 26), new Dimension(335, 1), 0x44939393));
        point = point.add(0, 13);
        this.pda.addElement(new McLabel((IAdvancedGui)this.pda, string, point.add(0, n++ * 20), 0x939393));
        this.pda.addElement(new McLabel((IAdvancedGui)this.pda, "\u0412\u0440\u0435\u043c\u044f: " + bred._a(this._d, DateTimeFormatter.ofPattern("HH:mm")), point.add(0, n++ * 20), 0x939393));
        String string3 = this._d._i()._q().stream().map(pidb2 -> String.valueOf(pidb2._d())).collect(Collectors.joining("/"));
        this.pda.addElement(new McLabel((IAdvancedGui)this.pda, "\u0414\u0435\u043b\u0435\u043d\u0438\u0435 \u0443\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u043e\u0432: " + string3, point.add(0, n++ * 20), 0x939393));
    }

    private void _d() {
        MapComponent mapComponent = new MapComponent(this.pda, this.pdaScreenStart.add(_a + 10, 38), new Dimension(_b - 34, this.pdaScreen.height - 93));
        amxi amxi2 = this._d._i();
        Vector2f vector2f = new Vector2f(amxi2._s(), amxi2._t());
        Vector2f vector2f2 = new Vector2f(amxi2._u(), amxi2._v());
        mapComponent.canvas().setMapPage(new MapSettings.MapPage("battle_preview_" + amxi2._d(), amxi2._f(), 10, vector2f, vector2f2), true);
        mapComponent.canvas().setInitialMapCoords(new Vector2f(amxi2._b(), amxi2._c()));
        mapComponent.canvas().addObjectRenderer(new eidj(new gloomyfolken.mods.stalker.clans.pidb(amxi2._d())));
        mapComponent.canvas().setZoom(6.0f);
        mapComponent.setEnablePageSwitches(false);
        this.pda.addElement(mapComponent);
        mapComponent.init();
        boolean bl = this._b();
        Point point = this.pdaScreenStart.add(_a + 10, this.pdaScreen.height - 50);
        GuiHelper.addButton(this.pda, point, new Dimension(335, 38), iedw._l, "\u0412 \u0431\u043e\u0439").onClick(guiActionButtonClick -> new iutg(this._c, "").sendToServer()).setRenderer(this.renderer.setFont(ExternalFont.tahoma16)).setEnabled(bl);
    }

    private void _e() {
        ExternalFont externalFont;
        Point point;
        Object object;
        boolean bl;
        Point point2 = this.pdaScreenStart.add(13, 5 + this.pdaScreen.height * 7 / 24);
        this.pda.addElement(new McLabel((IAdvancedGui)this.pda, "\u0421\u043f\u0438\u0441\u043e\u043a \u0441\u0442\u0430\u0432\u043e\u043a", point2.add(0, 2), 0x939393).setFontRenderer(ExternalFont.tahoma14));
        this.pda.addElement(new McRect(this.pda, point2.add(-3, 29), new Dimension(335, 1), 0x44939393));
        Point point3 = point2.add(0, 35);
        List<Point> list2 = Arrays.asList(point3.add(39, 0), point3.add(89, 0), point3.add(155, 0), point3.add(225, 0), point3.add(276, 0));
        GuiRenderer guiRenderer = this.renderer.setFont(ExternalFont.tahoma11);
        int n = 0;
        this._a("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435", list2.get(n++), guiRenderer);
        this._a("//", list2.get(n++), guiRenderer);
        this._a("\u0422\u0435\u043a\u0443\u0449\u0430\u044f \u0441\u0442\u0430\u0432\u043a\u0430", list2.get(n++), guiRenderer);
        this._a("//", list2.get(n++), guiRenderer);
        this._a("\u0414\u0435\u0439\u0441\u0442\u0432\u0438\u0435", list2.get(n++), guiRenderer);
        this.pda.addElement(new McRect(this.pda, point3.add(-3, 21), new Dimension(335, 1), 0x44939393));
        boolean bl2 = bl = this._d._d() != null && this._d._c() != sajz.eidj._a;
        if (bl) {
            object = this._d._d()._a();
            for (int i = 0; i < object.size(); ++i) {
                this._a(point3, list2, i);
            }
            point = this.pdaScreenStart.add(179, this.pdaScreen.height - 105);
            externalFont = ExternalFont.tahoma12;
        } else {
            point = this.pdaScreenStart.add(179, this.pdaScreen.height - 210);
            externalFont = ExternalFont.tahoma14;
        }
        this.pda.addElement(new McLabel((IAdvancedGui)this.pda, () -> bred._a(this._d), point, 0x939393).setFontRenderer(externalFont).setCentered());
        object = this.pdaScreenStart.add(12, this.pdaScreen.height - 105);
        Dimension dimension = new Dimension(332, 27);
        GuiHelper.addButton(this.pda, ((Point)object).add(0, 30), dimension, iedw._l, "\u0421\u043f\u0438\u0441\u043e\u043a \u043d\u0430\u0433\u0440\u0430\u0434").onClick(guiActionButtonClick -> this.pda.addElement(new pidb(this.pda, this.pdaScreenStart.add(this.pdaScreen.width / 2, this.pdaScreen.height / 2), this._d)));
        GuiHelper.addButton(this.pda, ((Point)object).add(0, 64), dimension, iedw._l, "\u0420\u0435\u0437\u0443\u043b\u044c\u0442\u0430\u0442\u044b \u043f\u043e\u0441\u043b\u0435\u0434\u043d\u0435\u0433\u043e \u0431\u043e\u044f").onClick(guiActionButtonClick -> new eigd(this._d._i()._d()).sendClientToBackend()).setEnabled(this._d._a() != null);
    }

    private void _a(Point point, List<Point> list2, int n) {
        boolean bl;
        String string;
        String string2;
        String string3 = yuch._a._a;
        List<sajz.kjui.kjui> list3 = this._d._d()._a();
        sajz.kjui.kjui kjui2 = list3.get(n);
        boolean bl2 = kjui2._a() == null;
        boolean bl3 = !bl2 && kjui2._d()._b();
        String string4 = string2 = bl2 ? "<\u0421\u0432\u043e\u0431\u043e\u0434\u043d\u043e>" : kjui2._a();
        String string5 = bl2 ? "-" : (string = bl3 ? "\u0417\u0430\u0449\u0438\u0442\u0430" : kjui2._b() + " \u041e\u0420");
        if (!bl2) {
            if (bl3) {
                string2 = (Object)((Object)ezfc._l) + string2;
            } else if (kjui2._a().equals(string3)) {
                string2 = (Object)((Object)ezfc._k) + string2;
            }
        }
        GuiRenderer guiRenderer = this.renderer.setFont(ExternalFont.tahoma9);
        string2 = guiRenderer.trimToWidth(string2, 75, true);
        int n2 = 335;
        int n3 = n * 30 + 33;
        this.pda.addElement(new McBackground(this.pda, point.add(0, n3), new Dimension(n2, 27)).setTexture(iedw._a).setTextureCoords(new Point(64, 768)).setTextureSize(new Dimension(64, 27)).setResizeBorder(23, 0));
        int n4 = 0;
        this._a(string2, list2.get(n4++).add(0, n3 += 8), guiRenderer);
        this._a("//", list2.get(n4++).add(0, n3), guiRenderer);
        this._a(string, list2.get(n4++).add(0, n3), guiRenderer);
        this._a("//", list2.get(n4++).add(0, n3), guiRenderer);
        boolean bl4 = bl = this._d._c() == sajz.eidj._b && yuch._a._c.contains((Object)amww._g);
        if (string3.isEmpty() || bl3 || !bl) {
            return;
        }
        Point point2 = list2.get(n4++).add(0, n3);
        Dimension dimension = new Dimension(138, 20);
        boolean bl5 = bl2 || !kjui2._a().equals(string3);
        String string6 = bl5 ? "\u0441\u0434\u0435\u043b\u0430\u0442\u044c \u0441\u0442\u0430\u0432\u043a\u0443" : "\u043f\u043e\u0432\u044b\u0441\u0438\u0442\u044c";
        McButton mcButton = GuiHelper.addButton(this.pda, point2.add(-69, -2), dimension, iedw._f, string6);
        mcButton.onClick(guiActionButtonClick -> this._a(kjui2));
        mcButton.mouseOverTextColor = 0xFFFFFF;
        mcButton.setRenderer(guiRenderer);
    }

    private McLabel _a(String string, Point point, GuiRenderer guiRenderer) {
        McLabel mcLabel = new McLabel((IAdvancedGui)this.pda, string, point, 0x939393);
        mcLabel.setRenderer(guiRenderer);
        this.pda.addElement(mcLabel);
        mcLabel.setCentered();
        return mcLabel;
    }

    private Map<cvzo, tdmn.kjui> _a(satl satl2, int n) {
        LinkedHashMap<cvzo, tdmn.kjui> linkedHashMap = new LinkedHashMap<cvzo, tdmn.kjui>();
        Comparator<Map.Entry> comparator = Comparator.comparing(entry -> ((tdmn.kjui)entry.getValue())._a.length == 0);
        comparator = comparator.thenComparing(entry -> Float.valueOf(-((tdmn.kjui)entry.getValue())._a(n)));
        comparator = comparator.thenComparing(entry -> ((wnce)entry.getKey())._c());
        satl2._a.stream().flatMap(flpm2 -> flpm2._b.stream()).collect(Collectors.toMap(pzne2 -> pzne2._a(false)._a(1), pzne2 -> (tdmn.kjui)pzne2, (kjui2, kjui3) -> kjui2)).entrySet().stream().sorted(comparator).filter(entry -> !((tdmn.kjui)entry.getValue())._a()).forEach(entry -> {
            tdmn.kjui cfr_ignored_0 = (tdmn.kjui)linkedHashMap.put(((wnce)entry.getKey())._a(), (tdmn.kjui)entry.getValue());
        });
        return linkedHashMap;
    }

    public void _a(String string, qoac qoac2) {
        if (string.equals(this._d._i()._d()) && this._d._d() != null) {
            this._d._d()._a(qoac2);
            this.pda.openTab(this);
        }
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, new Dimension(_a, this.pdaScreen.height * 7 / 24), true);
        this._a(this.pdaScreenStart.add(0, this.pdaScreen.height * 7 / 24), new Dimension(_a, this.pdaScreen.height * 17 / 24));
        this.drawScreenBackground(this.pdaScreenStart.add(_a, 0), new Dimension(_b, this.pdaScreen.height), true);
        super.drawComponent(point, f);
    }

    private void _a(Point point, Dimension dimension) {
        GL11.glEnable(3042);
        xpzm._E()._R()._a(iedw._a);
        this.renderer.drawTiledRect(point, new Point(128, 959), dimension, new Dimension(64, 64), 20);
        this.renderer.drawTiledRect(point.add(dimension.width - 18, 20), new Point(24, 832), new Dimension(15, dimension.height - 30), new Dimension(15, 64), 2);
        this.renderer.drawRect(point.add(10, dimension.height - 8), new Dimension(dimension.width - 35, 1), 0x64646464);
        xpzm._E()._R()._a(iedw._b);
        this.renderer.drawTiledRect(point.add(5, 5), new Point(0, 0), dimension.add(-25, -20), new Dimension(718, 450), 5, 0);
        GL11.glDisable(3042);
    }

    @Override
    public void _a(String string, sajz sajz2) {
        if (this._c.equals(string) && this._d == null) {
            this._d = sajz2;
            this.pda.openTab(this);
        }
    }

    public void _a(sajz.kjui.kjui kjui2) {
        Point point = this.pdaScreenStart.add(this.pdaScreen.width / 2 - 140, this.pdaScreen.height / 2 - 130);
        this.pda.addElement(new kjui(this.pda, point, kjui2));
    }

    public void _a(sajz.kjui.kjui kjui2, int n) {
        int n2 = this._d._d()._a().indexOf(kjui2);
        new qljc(this._d._i()._d(), n2, n).sendClientToBackend();
    }

    private class pidb
    extends Dialog {
        private sajz _b;

        public pidb(IAdvancedGui iAdvancedGui, Point point, sajz sajz2) {
            super(iAdvancedGui, point.add(-180, -120), new Dimension(370, 320));
            this._b = sajz2;
            this.init();
        }

        @Override
        protected void setupDialog() {
            GuiComponentsList<McToolTip> guiComponentsList = new GuiComponentsList<McToolTip>(this.parent);
            this.add(new PdaBackground(this.parent, Point.zeroPoint, this.getSize(), true, true));
            this.add(new McLabel(this.parent, "\u041f\u043e\u0431\u0435\u0434\u0438\u0442\u0435\u043b\u044f\u043c \u043c\u043e\u0433\u0443\u0442 \u0434\u043e\u0441\u0442\u0430\u0442\u044c\u0441\u044f:", new Point(20, 10), 0x939393));
            Point point = new Point(10, 28);
            String string = this._b._i()._o();
            satl satl2 = tdmn._a(string);
            int n = this._b._b();
            Map map = satl2 != null ? hbtc.this._a(satl2, n) : Collections.emptyMap();
            int n2 = map.size() / 9 * 37;
            McScrollPane mcScrollPane = GuiHelper.createScrollPane(this.parent, point.add(0, 20), new Dimension(_a - 25, ((hbtc)hbtc.this).pdaScreen.height / 2 - 35), new Dimension(_a - 25, n2), true, iedw._j, iedw._k);
            int n3 = 0;
            for (Map.Entry entry : map.entrySet()) {
                int n4 = n3 % 9 * 37;
                int n5 = n3 / 9 * 37;
                this._a(mcScrollPane, (tdmn.kjui)entry.getValue(), (cvzo)entry.getKey(), n4, n5, n, guiComponentsList);
                ++n3;
            }
            this.add(mcScrollPane);
            McScrollBar mcScrollBar = mcScrollPane.getVerticalScrollBar();
            if (mcScrollBar != null) {
                mcScrollPane.getTopButton().move(9, -25);
                mcScrollBar.move(9, -25);
                mcScrollBar.setLength(257);
                mcScrollBar.setSliderLength(16);
                mcScrollPane.getBottomButton().move(9, 42);
            }
            GuiHelper.addButton(this, new Point(this.getSize().width / 2 - 90, 280), new Dimension(180, 27), iedw._l, "\u0417\u0430\u043a\u0440\u044b\u0442\u044c").onClick(guiActionButtonClick -> this.parent.getElementsList().removeElement(this));
            this.add(guiComponentsList);
        }

        private void _a(McScrollPane mcScrollPane, tdmn.kjui kjui2, cvzo cvzo2, int n, int n2, int n3, GuiComponentsList<McToolTip> guiComponentsList) {
            McDummySlot mcDummySlot = GuiHelper.addSlot(mcScrollPane.getViewport(), cvzo2, new Point(n, n2), 1.0f);
            guiComponentsList.addElement(mcDummySlot.createToolTip());
            if (kjui2._a.length > 0) {
                ArrayList<String> arrayList = new ArrayList<String>();
                float f = kjui2._a(n3);
                if (f > 1.0f) {
                    arrayList.add((Object)((Object)ezfc._g) + String.format("\u0428\u0430\u043d\u0441 x%.2f", Float.valueOf(f)));
                }
                Point point = f > 1.0f ? new Point(591, 843) : new Point(591, 832);
                McImage mcImage = new McImage((IAdvancedGui)hbtc.this.pda, mcDummySlot.getLocation().add(22, 0), point, new Dimension(10, 10), iedw._a);
                mcImage.noMouseInteraction = false;
                mcImage.color = -1000650;
                mcImage.blending = true;
                mcScrollPane.getViewport().addElement(mcImage);
                arrayList.add("\u0428\u0430\u043d\u0441 \u0432\u044b\u043f\u0430\u0434\u0435\u043d\u0438\u044f \u044d\u0442\u043e\u0433\u043e \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u0430 \u0443\u0432\u0435\u043b\u0438\u0447\u0438\u0432\u0430\u0435\u0442\u0441\u044f");
                arrayList.add("\u043f\u0440\u0438 \u0443\u0441\u043f\u0435\u0448\u043d\u043e\u0439 \u0437\u0430\u0449\u0438\u0442\u0435 \u043b\u043e\u043a\u0430\u0446\u0438\u0438");
                guiComponentsList.addElement(new McToolTip((IAdvancedGui)hbtc.this.pda, arrayList, mcImage));
            }
        }
    }

    private class kjui
    extends Dialog {
        private sajz.kjui.kjui _b;
        private int _c;
        private McNumberField _d;
        private McButton _e;
        private McLabel _f;

        public kjui(IAdvancedGui iAdvancedGui, Point point, sajz.kjui.kjui kjui2) {
            super(iAdvancedGui, point, new Dimension(280, 260));
            this.setTitle("\u0421\u0442\u0430\u0432\u043a\u0430");
            this._b = kjui2;
            this._c = kjui2._c();
            this.init();
        }

        @Override
        protected void setupDialog() {
            this.addElement(new McLabel(this.parent, "\u0423\u043a\u0430\u0436\u0438\u0442\u0435 \u0441\u0442\u0430\u0432\u043a\u0443", new Point(this.getSize().width / 2, 60), 0x939393).setFontRenderer(ExternalFont.tahoma14).setCentered());
            this.addElement(new McLabel(this.parent, "(\u043d\u0435 \u043c\u0435\u043d\u0435\u0435 " + this._c + ")", new Point(this.getSize().width / 2, 80), 0x939393).setFontRenderer(ExternalFont.tahoma12).setCentered());
            this._f = new McLabel(this.parent, "\u041d\u0435\u0434\u043e\u0441\u0442\u0430\u0442\u043e\u0447\u043d\u043e \u041e\u0420 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438", new Point(this.getSize().width / 2, 105), -65536).setFontRenderer(ExternalFont.tahoma10).setCentered();
            this.addElement(this._f);
            this._d = GuiHelper.createNumberField(this.parent, new Point(this.getSize().width / 2 - 75, 130), new Dimension(150, 27), this._c, Long.MAX_VALUE, Long.MIN_VALUE);
            this._d.setStyle(iedw._i);
            this.addElement(this._d);
            this._e = GuiHelper.addButton(this, new Point(this.getSize().width / 2 - 90, 176), new Dimension(180, 27), iedw._l, "\u041f\u0440\u0438\u043c\u0435\u043d\u0438\u0442\u044c").onClick(guiActionButtonClick -> {
                hbtc.this._a(this._b, (int)this._d.getValue());
                this.parent.getElementsList().removeElement(this);
            });
            GuiHelper.addButton(this, new Point(this.getSize().width / 2 - 90, 210), new Dimension(180, 27), iedw._l, "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c").onClick(guiActionButtonClick -> this.parent.getElementsList().removeElement(this));
        }

        @Override
        public void tick() {
            super.tick();
            long l = this._d.getValue();
            boolean bl = l <= (long)yuch._a._k;
            this._e.setEnabled(l >= (long)this._c && bl);
            this._f.setVisible(!bl);
        }
    }

    private class eidj
    extends oxgc {
        private gloomyfolken.mods.stalker.clans.pidb _b;

        public eidj(gloomyfolken.mods.stalker.clans.pidb pidb2) {
            this._b = pidb2;
        }

        @Override
        public gloomyfolken.mods.stalker.clans.pidb _a() {
            return this._b;
        }

        @Override
        public int _b() {
            return -1;
        }

        @Override
        public void _a(int n) {
        }

        @Override
        public boolean _c() {
            return false;
        }

        @Override
        protected String _a(int n, pidb.tupg tupg2) {
            if (tupg2 instanceof pidb.ezey && hbtc.this._d._d() != null && hbtc.this._d._c() != sajz.eidj._a) {
                sajz.kjui.kjui kjui2 = hbtc.this._d._d()._a().get(n);
                String string = kjui2._a();
                boolean bl = kjui2._d()._b();
                return (string == null ? "\u041d\u0435 \u0437\u0430\u043d\u044f\u0442\u043e" : "\u0417\u0430\u043d\u044f\u0442: " + string) + "\n" + (bl ? "\u0417\u0430\u0449\u0438\u0442\u0430" : "\u0421\u0442\u0430\u0432\u043a\u0430: " + (string == null ? "-" : kjui2._b() + " \u041e\u0420")) + "\n" + kjui2._d()._d() + " \u0447\u0435\u043b.";
            }
            return null;
        }
    }
}

