/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import mods.pda.client.screens.GuiPda;
import net.minecraft.util.ResourceLocation;

public class ndex
extends pjlq {
    private pzdf _a = new pzdf(Collections.emptyList());

    public ndex(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui, (Class<? extends pjlq>)ndex.class);
    }

    @Override
    public void requestInformation() {
        new dfdf().sendClientToBackend();
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        int n = this._a._a().size();
        McScrollPane mcScrollPane = GuiHelper.createScrollPane((IAdvancedGui)this.pda, this.pdaScreenStart.add(10, 40), this.pdaScreen.add(-25, -50), new Dimension(this.pdaScreen.width - 25, n * 138), true, iedw._j, iedw._k);
        int n2 = 0;
        ArrayList<sajz> arrayList = new ArrayList<sajz>(this._a._a().values());
        arrayList.sort((sajz2, sajz3) -> {
            if (sajz2._c() != sajz3._c()) {
                return -Integer.compare(sajz2._c().ordinal(), sajz3._c().ordinal());
            }
            rotc rotc2 = qlxw._b;
            return sajz2._a(rotc2).compareTo(sajz3._a(rotc2));
        });
        for (sajz sajz4 : arrayList) {
            mcScrollPane.getViewport().addElement(new kjui(this.pda, new Point(0, n2++ * 138), new Dimension(this.pdaScreen.width - 36, 136), sajz4));
        }
        this.pda.addElement(mcScrollPane);
        if (mcScrollPane.getVerticalScrollBar() != null) {
            mcScrollPane.getBottomButton().move(9, -3);
            mcScrollPane.getTopButton().move(9, -18);
            mcScrollPane.getVerticalScrollBar().move(9, -18);
            mcScrollPane.getVerticalScrollBar().setLength(mcScrollPane.getVerticalScrollBar().getLength() + 14);
        }
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, this.pdaScreen, true);
        super.drawComponent(point, f);
    }

    private void _a(sajz sajz2) {
        this.pda.openTab(new hbtc((IAdvancedGui)this.pda, sajz2));
    }

    public void _a(pzdf pzdf2) {
        this._a = pzdf2;
        this.pda.openTab(this);
    }

    private class kjui
    extends GuiComponentsList {
        private DateTimeFormatter _b;
        private final sajz _c;
        private McLabel _d;

        protected kjui(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, sajz sajz2) {
            super(iAdvancedGui, point, dimension);
            this._b = DateTimeFormatter.ofPattern("HH:mm");
            this._c = sajz2;
            this._b();
        }

        private void _b() {
            int n;
            String string;
            amxi amxi2 = this._c._i();
            this.addElement(new McImage(this.parent, new Point(4, 4), Point.zeroPoint, new Dimension(128, 128), new ResourceLocation("stalkerclans", "battlefields/icons/" + amxi2._h())).setRenderer(new GuiRendererBuilder().setTextureSize(128, 128).create()));
            this.addElement(new McLabel(this.parent, amxi2._e(), new Point(140, 15), 0x939393).setFontRenderer(ExternalFont.tahoma14));
            if (this._c._c() == sajz.eidj._d) {
                string = "\u0432\u0435\u0434\u0435\u0442\u0441\u044f \u0431\u0438\u0442\u0432\u0430 \u0437\u0430 \u043b\u043e\u043a\u0430\u0446\u0438\u044e";
            } else if (this._c._a() != null) {
                string = "\u043f\u043e\u0434 \u043a\u043e\u043d\u0442\u0440\u043e\u043b\u0435\u043c \"" + this._c._a() + "\"";
                n = this._c._b() - 1;
                if (n > 0) {
                    String string2 = "\u0437\u0430\u0449\u0438\u0449\u0435\u043d\u043e " + n + " ";
                    string2 = n > 1 && n < 5 ? string2 + "\u0440\u0430\u0437\u0430" : string2 + "\u0440\u0430\u0437";
                    this.addElement(new McLabel(this.parent, string2, new Point(140, 60), 0x939393));
                }
            } else {
                string = "\u0441\u0432\u043e\u0431\u043e\u0434\u043d\u0430\u044f \u043b\u043e\u043a\u0430\u0446\u0438\u044f";
            }
            this.addElement(new McLabel(this.parent, string, new Point(140, 40), 0x939393));
            n = 0;
            int n2 = 400;
            this.addElement(new McLabel(this.parent, bred._a(this._c, this._b), new Point(n2, n++ * 20 + 15), 0x939393));
            int n3 = amxi2._q().stream().mapToInt(amxi.pidb::_d).sum();
            this.addElement(new McLabel(this.parent, "\u0412\u0441\u0435\u0433\u043e \u0443\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u043e\u0432: " + n3, new Point(n2, n++ * 20 + 15), 0x939393));
            this._d = new McLabel(this.parent, bred._a(this._c), new Point(n2, n++ * 20 + 15 + 2), 0x939393).setFontRenderer(ExternalFont.tahoma11);
            this.addElement(this._d);
            if (this._c._d() != null) {
                int n4 = this._c._d()._a().size();
                int n5 = (int)this._c._d()._a().stream().filter(kjui2 -> kjui2._a() == null).count();
                this.addElement(new McLabel(this.parent, "\u0414\u043e\u0441\u0442\u0443\u043f\u043d\u043e \u0441\u043b\u043e\u0442\u043e\u0432: " + n5 + "/" + n4, new Point(n2, n++ * 20 + 15), 0x939393));
            }
            Dimension dimension = new Dimension(150, 27);
            if (this._c._a() != null) {
                GuiHelper.addButton(this, new Point(this.getSize().width - 312, 100), dimension, iedw._l, "\u0420\u0435\u0437\u0443\u043b\u044c\u0442\u0430\u0442\u044b \u0431\u043e\u044f").onClick(guiActionButtonClick -> new eigd(this._c._i()._d()).sendClientToBackend());
            }
            GuiHelper.addButton(this, new Point(this.getSize().width - 156, 100), dimension, iedw._l, "\u041f\u043e\u0434\u0440\u043e\u0431\u043d\u0435\u0435").onClick(guiActionButtonClick -> ndex.this._a(this._c));
        }

        public boolean _a() {
            sajz.eidj eidj2 = this._c._c();
            return eidj2 == sajz.eidj._b || eidj2 == sajz.eidj._c || eidj2 == sajz.eidj._d;
        }

        @Override
        public void drawComponent(Point point, float f) {
            this.renderer.bindTexture(iedw._a);
            this.renderer.drawTiledRect(this.getLocation(), new Point(128, 931), this.getSize(), new Dimension(64, 27), 4);
            super.drawComponent(point, f);
        }

        @Override
        public void tick() {
            super.tick();
            this._d.setText(bred._a(this._c));
        }
    }
}

