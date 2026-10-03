/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;
import gloomyfolken.mods.core.misc.vjsq;
import java.util.List;
import mods.pda.client.screens.GuiPda;

public abstract class sbsh<T extends vjsq>
extends pjlq {
    private String _b = "";
    protected McScrollList<T> _a;
    private GuiComponentsList<McLabel> _c;

    public sbsh(IAdvancedGui iAdvancedGui, Class<? extends pjlq> clazz) {
        super(iAdvancedGui, clazz);
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        this._c();
        this._a();
        this._b = "";
    }

    @Override
    public void tick() {
        T t;
        super.tick();
        if (this._a.getSelectedLineId() >= this._a.getLines().size()) {
            this._a.setSelectedLineId(-1);
        }
        if ((t = this._a.getSelectedLine()) != null && !t.getString().equals(this._b)) {
            this._a(t);
            this._b = t.getString();
        } else if (t == null && !"".equals(this._b)) {
            this._c.clearElements();
            this._b = "";
        }
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, new Dimension(443, this.pdaScreen.height), true);
        this.drawScreenBackground(this.pdaScreenStart.add(443, 0), new Dimension(298, this.pdaScreen.height), true);
        super.drawComponent(point, f);
        this.renderer.drawRect(this._a.getLocation().add(0, -6), new Dimension(this._a.getSize().width, 1), 0x64646464);
    }

    public abstract void _a(T var1);

    public abstract List<T> _b();

    public void _a(List<String> list) {
        this._c.clearElements();
        int n = 0;
        for (int i = 0; i < list.size(); ++i) {
            String string = list.get(i);
            if (string.isEmpty()) continue;
            this._c.addElement(new McLabel((IAdvancedGui)this.pda, string, new Point(0, n++ * 18), 0x939393));
        }
    }

    protected void _a() {
        Point point = this.pdaScreenStart.add(5, 23);
        Dimension dimension = new Dimension((int)((double)this.pdaScreen.width * 0.6) - 23, this.pdaScreen.height - 35);
        int n = -1;
        if (this._a != null) {
            n = this._a.getSelectedLineId();
        }
        this._a = new McScrollList<T>(this.parent, iedw._g, this._b(), point.add(5, 38), dimension.add(-13, -35));
        this._a.setSelectedLineId(n);
        McScrollBar mcScrollBar = new McScrollBar(this.parent, this._a, McScrollBar.ScrollBarType.VERTICAL, point.add(dimension.width, 14), dimension.height - 28, iedw._j.getVerticalBarStyle());
        mcScrollBar.setSliderLength(16);
        this._a.setSlider(mcScrollBar);
        this._a.setDrawLineSeparators(true);
        this.pda.addElement(this._a);
        this.pda.addElement(mcScrollBar);
        this.pda.addElement(new McScrollButton(this.parent, mcScrollBar, McScrollButton.ScrollButtonDirection.TOP, new Point(point.x + dimension.width, point.y), iedw._k.getTopArrowStyle()));
        this.pda.addElement(new McScrollButton(this.parent, mcScrollBar, McScrollButton.ScrollButtonDirection.BOTTOM, new Point(point.x + dimension.width, point.y + dimension.height - 14), iedw._k.getBottomArrowStyle()));
    }

    private void _c() {
        this._c = new GuiComponentsList(this.pda);
        this._c.setLocation(this.pdaScreenStart.add((int)((double)this.pdaScreen.width * 0.6) + 20, 60));
        this.pda.addElement(this._c);
    }
}

