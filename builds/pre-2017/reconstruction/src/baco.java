/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McRect;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.engine.component.McViewport;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.party.zwat;
import gloomyfolken.mods.stalker.clans.pidb;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import mods.pda.client.component.PdaBackground;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;

public class baco
extends GuiScreenAdvanced
implements owwh {
    private pidb _a;
    private GuiComponentsList<McToolTip> _b = new GuiComponentsList(this);

    public baco(pidb pidb2) {
        super(new GuiRendererBuilder().setTextureSize(1024, 1024).setFontRenderer(ExternalFont.tahoma12).create());
        this._a = pidb2;
    }

    @Override
    public void initGui() {
        super.initGui();
        this._b.clearElements();
        int n = (int)((float)this.screenWidth / 1920.0f * 1482.0f);
        int n2 = (int)((float)this.screenHeight / 1080.0f * 980.0f);
        int n3 = (int)((float)this.screenHeight / 1080.0f * 44.0f);
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        this.addElement(new McBackground(this, point.add(-n / 2, -n2 / 2), new Dimension(n, n2)).setTexture(iedw._a).setTextureSize(new Dimension(64, 64)).setTextureCoords(new Point(613, 954)).setResizeBorder(20));
        Point point2 = point.add(-n / 2 + 20, -n2 / 2 + 20);
        this.addElement(new McLabel((IAdvancedGui)this, "\u0421\u0442\u0430\u0442\u0438\u0441\u0442\u0438\u043a\u0430 \u0431\u043e\u044f", point2, 0x939393).setFontRenderer(ExternalFont.tahoma16));
        String string = DateFormatUtils.format(new Date(), "dd/MM/yy");
        this.addElement(new McLabel((IAdvancedGui)this, string, point2.add(0, 30), 0x939393).setFontRenderer(ExternalFont.tahoma16));
        this.addElement(new McLabel((IAdvancedGui)this, " " + this._a._b()._e(), Point.zeroPoint, 0x939393).setFontRenderer(ExternalFont.tahoma18).setCentered(point.x, point.y - n2 / 2 + 30));
        this.addElement(new McLabel((IAdvancedGui)this, this::_b, Point.zeroPoint, 0x939393).setFontRenderer(ExternalFont.tahoma18).setCentered(point.x, point.y - n2 / 2 + 60));
        Point point3 = point.add(0, n3);
        List<pidb.pidb> list2 = this._a._c();
        int n4 = list2.size();
        int n5 = n4 > 1 ? n / 2 : n;
        int n6 = n2 - n3 * 2;
        int n7 = n4 > 2 ? n6 / 2 : n6;
        for (int i = 0; i < list2.size(); ++i) {
            pidb.pidb pidb2 = list2.get(i);
            int n8 = (-1 + i % 2) * (n4 == 1 ? n5 / 2 : n5);
            int n9 = (-1 + i / 2) * (n4 <= 2 ? n7 / 2 : n7);
            this._a(point3.x + n8, point3.y + n9, n5, n7, pidb2);
        }
        this.addElement(this._b);
    }

    private String _b() {
        LocalTime localTime = qlxw._c._d().toLocalTime();
        LocalTime localTime2 = this._a._b()._l();
        return "\u041e\u0441\u0442\u0430\u0432\u0448\u0435\u0435\u0441\u044f \u0432\u0440\u0435\u043c\u044f: " + DurationFormatUtils.formatDuration(localTime.until(localTime2, ChronoUnit.MILLIS), "HH:mm:ss");
    }

    private void _a(int n, int n2, int n3, int n4, pidb.pidb pidb2) {
        List<pidb.zwaw.kjui> list2 = this._a._h()._a(pidb2);
        int n5 = 0x939393;
        this.addElement(new PdaBackground(this, new Point(n, n2), new Dimension(n3, n4), true, false));
        int n6 = (int)pidb2._c();
        int n7 = n + 20;
        ExternalFont externalFont = ExternalFont.tahoma14;
        this.addElement(new McLabel((IAdvancedGui)this, pidb2._b(), new Point(n7, n2 + 10), n5).setFontRenderer(externalFont));
        this.addElement(new McImage((IAdvancedGui)this, new Point(n7 += 14 + externalFont.getStringWidth(pidb2._b()) * 2, n2 + 8), new Point(469, 768), new Dimension(11, 23), iedw._a));
        this.addElement(new McLabel((IAdvancedGui)this, String.valueOf(n6), new Point(n7 += 15, n2 + 10), n5).setFontRenderer(externalFont));
        this._a(new Point(n + n3 - 125, n2 + 8));
        int n8 = 27;
        int n9 = n3 - 16;
        Dimension dimension = new Dimension(n9, n4 - 44);
        Dimension dimension2 = new Dimension(n9, list2.size() * n8);
        McScrollPane mcScrollPane = GuiHelper.createScrollPane((IAdvancedGui)this, new Point(n + 10, n2 + 37), dimension, dimension2, true, iedw._j, iedw._k);
        int n10 = 0;
        for (pidb.zwaw.kjui kjui2 : list2) {
            Point point = new Point(3, n10 * n8);
            McViewport mcViewport = mcScrollPane.getViewport();
            mcViewport.addElement(new kjui(this, point, new Dimension(n9, n8), kjui2));
            mcViewport.addElement(new McRect(this, new Point(0, n10 * n8 + n8), new Dimension(n3 - 6, 1), 1083413395));
            ++n10;
        }
        if (mcScrollPane.getVerticalScrollBar() != null) {
            mcScrollPane.getTopButton().move(0, -15);
            mcScrollPane.getBottomButton().move(0, -6);
            mcScrollPane.getVerticalScrollBar().move(0, -14);
            mcScrollPane.getVerticalScrollBar().setLength(mcScrollPane.getVerticalScrollBar().getLength() + 6);
            mcScrollPane.getVerticalScrollBar().setSliderLength(16);
        }
        this.addElement(mcScrollPane);
    }

    private void _a(Point point) {
        int n = 0x939393;
        ExternalFont externalFont = ExternalFont.tahoma16;
        McLabel mcLabel = new McLabel((IAdvancedGui)this, "\u0423", point.add(-85, 0), n).setFontRenderer(externalFont);
        mcLabel.noMouseInteraction = false;
        this.addElement(mcLabel);
        this._b.addElement(new McToolTip((IAdvancedGui)this, Collections.singletonList("\u0423\u0431\u0438\u0439\u0441\u0442\u0432\u0430"), mcLabel));
        McLabel mcLabel2 = new McLabel((IAdvancedGui)this, "\u041f", point.add(-55, 0), n).setFontRenderer(externalFont);
        mcLabel2.noMouseInteraction = false;
        this.addElement(mcLabel2);
        this._b.addElement(new McToolTip((IAdvancedGui)this, Collections.singletonList("\u041f\u043e\u043c\u043e\u0449\u044c \u0432 \u0443\u0431\u0438\u0439\u0441\u0442\u0432\u0430\u0445"), mcLabel2));
        McLabel mcLabel3 = new McLabel((IAdvancedGui)this, "\u0421", point.add(-25, 0), n).setFontRenderer(externalFont);
        mcLabel3.noMouseInteraction = false;
        this.addElement(mcLabel3);
        this._b.addElement(new McToolTip((IAdvancedGui)this, Collections.singletonList("\u0421\u043c\u0435\u0440\u0442\u0438"), mcLabel3));
        McLabel mcLabel4 = new McLabel((IAdvancedGui)this, "\u0421\u0447\u0435\u0442", point.add(0, 0), n).setFontRenderer(externalFont);
        mcLabel4.noMouseInteraction = false;
        this.addElement(mcLabel4);
        McImage mcImage = new McImage((IAdvancedGui)this, point.add(58, 0), new Point(484, 769), new Dimension(28, 20), iedw._a);
        this.addElement(mcImage);
        this._b.addElement(new McToolTip((IAdvancedGui)this, Collections.singletonList("\u041f\u0438\u043d\u0433"), mcImage));
    }

    @Override
    public void handleKeyboardInput() {
        this._a();
    }

    private class kjui
    extends GuiComponent {
        private final pidb.zwaw.kjui _b;

        public kjui(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, pidb.zwaw.kjui kjui2) {
            super(iAdvancedGui, point, dimension);
            this._b = kjui2;
            this.setRenderer(this.getRenderer().setFont(ExternalFont.tahoma12));
        }

        @Override
        public void drawComponent(Point point, float f) {
            super.drawComponent(point, f);
            int n = -1;
            if (!this._b._a(pidb.zwat._i)._c()) {
                n = -9145228;
            } else if (this._b._c().equals(baco.this.mc._t.username)) {
                n = 44975;
            } else if (zwat._a._a.containsKey(this._b._c())) {
                n = 44800;
            } else if (this.isMouseOver()) {
                n = -1;
            }
            int n2 = this._b._a(pidb.zwat._a)._b();
            int n3 = this._b._a(pidb.zwat._b)._b();
            int n4 = this._b._a(pidb.zwat._c)._b();
            int n5 = this._b._b();
            this.renderer.drawString(this._b._c(), this.getLocation().add(0, 6), n);
            int n6 = this.getLocation().x + this.getSize().width - 100;
            int n7 = this.getLocation().y + 16;
            this.renderer.drawCenteredString(String.valueOf(n2), n6 - 100, n7, n);
            this.renderer.drawCenteredString(String.valueOf(n3), n6 - 70, n7, n);
            this.renderer.drawCenteredString(String.valueOf(n4), n6 - 40, n7, n);
            this.renderer.drawCenteredString(String.valueOf(n5), n6, n7, n);
            this.renderer.drawCenteredString(this._a(), n6 + 49, n7, n);
        }

        private String _a() {
            if (baco.this.mc._t == null) {
                return "-";
            }
            maza maza2 = (maza)baco.this.mc._t.sendQueue._h.get(this._b._c());
            if (maza2 == null || maza2._c <= 0 || maza2._c > 1000) {
                return "-";
            }
            return String.valueOf(maza2._c);
        }
    }
}

