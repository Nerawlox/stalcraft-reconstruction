/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import java.util.Arrays;
import java.util.List;
import mods.pda.client.screens.GuiPda;
import org.apache.commons.lang3.tuple.Pair;

public class mack
extends pjlq {
    private static String _a = "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c";
    private static String _b = "\u0420\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c";
    private McTextField _c;
    private int _d = 0;
    private boolean _e = false;
    private McTextArea _f;
    private McButton _g;
    private boolean _h;
    private String _i;

    public mack(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui, (Class<? extends pjlq>)mack.class);
    }

    public mack(IAdvancedGui iAdvancedGui, boolean bl) {
        super(iAdvancedGui, (Class<? extends pjlq>)mack.class);
        this._e = bl;
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        kkzc kkzc2 = yuch._a;
        if (kkzc2._c.contains((Object)amww._a)) {
            this._a();
        }
        this._i = kkzc2._p;
        this._h = false;
        this._c();
        if (kkzc2._c.contains((Object)amww._b)) {
            this._d();
        }
        this._a(Arrays.asList(Pair.of("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435:", kkzc2._a), Pair.of("\u041b\u0438\u0434\u0435\u0440:", kkzc2._d), Pair.of("\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0431\u0430\u0437:", kkzc2._f), Pair.of("\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u043e\u0447\u043a\u043e\u0432 \u0440\u0435\u0441\u0443\u0440\u0441\u043e\u0432 (\u041e\u0420):", kkzc2._k), Pair.of("\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0443\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u043e\u0432", kkzc2._h), Pair.of("\u041c\u0430\u043a\u0441\u0438\u043c\u0443\u043c \u0443\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u043e\u0432:", kkzc2._i), Pair.of("\u0423\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u043e\u0432 \u043e\u043d\u043b\u0430\u0439\u043d", kkzc2._j), Pair.of("\u0412\u0430\u0448\u0438 \u043e\u0447\u043a\u0438 \u043b\u043e\u044f\u043b\u044c\u043d\u043e\u0441\u0442\u0438:", kkzc2._l), Pair.of("\u041d\u0430\u043a\u043e\u043f\u043b\u0435\u043d\u043d\u044b\u0435 \u0432\u0430\u043c\u0438 \u041e\u0420 (\u0437\u0430 \u043c\u0435\u0441\u044f\u0446):", kkzc2._o), Pair.of("\u041e\u041b \u0437\u0430 \u0443\u0431\u0438\u0439\u0441\u0442\u0432\u0430 \u043d\u0430 \u0437\u0430\u0445\u0432\u0430\u0442\u0435 \u0431\u0430\u0437\u044b:", kkzc2._m), Pair.of("\u041e\u041b \u0437\u0430 \u0441\u0435\u043a\u0443\u043d\u0434\u0443 \u0437\u0430\u0445\u0432\u0430\u0442\u0430 \u0431\u0430\u0437\u044b:", kkzc2._n)));
        if (kkzc2._c.contains((Object)amww._l)) {
            GuiHelper.addButton(this.pda, this.pdaScreenStart.add(10, this.pdaScreen.height - 80), new Dimension(182, 30), iedw._l, "\u0426\u0435\u043d\u044b").onClick(guiActionButtonClick -> this.pda.openTab(new xabf(this.pda)));
            GuiHelper.addButton(this.pda, this.pdaScreenStart.add(197, this.pdaScreen.height - 80), new Dimension(182, 30), iedw._l, "\u041e\u0447\u043a\u0438 \u043b\u043e\u044f\u043b\u044c\u043d\u043e\u0441\u0442\u0438").onClick(guiActionButtonClick -> this.pda.openTab(new gprk(this.pda)));
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!this._i.equals(yuch._a._p)) {
            this.pda.openTab(this);
        }
    }

    private void _a() {
        this._c = new McTextField(this.pda, this.pdaScreenStart.x + 10, this.pdaScreenStart.y + this.pdaScreen.height - 40, 182, 30);
        this._c.setStyle(iedw._i);
        this._c.setMaxStringLength(32);
        this.pda.addElement(this._c);
        McButton mcButton = new McButton(this.pda, this.pdaScreenStart.x + 10 + 182 + 5, this.pdaScreenStart.y + this.pdaScreen.height - 40, iedw._l, "\u041f\u0440\u0438\u0433\u043b\u0430\u0441\u0438\u0442\u044c");
        mcButton.setSize(new Dimension(182, 30));
        this.pda.getActionManager().registerActionHandler(mcButton, GuiActionButtonClick.class, guiActionButtonClick -> this._b());
        this.pda.addElement(mcButton);
    }

    private void _a(List<Pair<String, Object>> list) {
        this._d = list.size();
        for (int i = 0; i < list.size(); ++i) {
            Pair<String, Object> pair = list.get(i);
            this._a(pair.getKey(), pair.getValue().toString(), i);
        }
    }

    private void _a(String string, String string2, int n) {
        GuiHelper.addLabel((IAdvancedGui)this.pda, string, new Point(this.pdaScreenStart.x + 15, this.pdaScreenStart.y + 50 + 26 * n), iedw._h);
        GuiHelper.addLabel((IAdvancedGui)this.pda, string2, new Point(this.pdaScreenStart.x + 10 + this.pdaScreen.width / 2 - this.renderer.getStringWidth(string2), this.pdaScreenStart.y + 50 + 26 * n), iedw._h);
    }

    private void _b() {
        ncul._b(new ncdg(this._c.getText()));
    }

    private void _c() {
        this._f = new McTextArea(this.parent, this.pdaScreenStart.add(25 + this.pdaScreen.width / 2, 80), this.pdaScreen.add(-this.pdaScreen.width / 2 - 60, -135));
        this.pda.addElement(this._f);
        this.pda.addElement(new McLabel((IAdvancedGui)this.pda, "\u041f\u0440\u0430\u0432\u0438\u043b\u0430:", this._f.getLocation().add(0, -30), 0x939393).setFontRenderer(ExternalFont.tahoma14));
        McScrollBar mcScrollBar = new McScrollBar(this.parent, (IScrollable)this._f, McScrollBar.ScrollBarType.VERTICAL, this.pdaScreenStart.add(this.pdaScreen.width - 17, 23), this.pdaScreen.height - 35, iedw._j.getVerticalBarStyle());
        mcScrollBar.setSliderLength(16);
        this.pda.addElement(mcScrollBar);
        this._f.setSlider(mcScrollBar);
        this._f.setStyle(iedw._i);
        this._f.setText(this._i);
    }

    private void _d() {
        this._g = GuiHelper.addButton(this.parent, this._f.getLocation().add(0, this.pdaScreen.height - 120), new Dimension(150, 30), iedw._l, _b);
        this.parent.getActionManager().registerActionHandler(this._g, GuiActionButtonClick.class, guiActionButtonClick -> this._f());
        this._g.setEnabled(yuch._a._c.contains((Object)amww._b));
        McButton mcButton = GuiHelper.addButton(this.parent, this._g.getLocation().add(161, 0), new Dimension(150, 30), iedw._l, "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c");
        this.parent.getActionManager().registerActionHandler(mcButton, GuiActionButtonClick.class, guiActionButtonClick -> this._e());
    }

    private void _e() {
        yuch._a._p = this._f.getText();
        ncul._b(new dwim(this._f.getText()));
        if (this._h) {
            this._f();
        }
    }

    private void _f() {
        boolean bl = this._h = !this._h;
        if (this._h) {
            this._g.text = _a;
            this._f.isEditable = true;
            this._f.setFocused(true);
        } else {
            this._g.text = _b;
            this._f.isEditable = false;
            this._f.setFocused(false);
            this._f.setText(yuch._a._p);
        }
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, this.pdaScreen, true);
        super.drawComponent(point, f);
        for (int i = 0; i < this._d; ++i) {
            this.renderer.drawRect(this.pdaScreenStart.add(15, 50 + this.renderer.getFontHeight() - 2 + i * (this.renderer.getFontHeight() + 6)), new Dimension(this.pdaScreen.width / 2, 1), 0x64646464);
        }
    }

    @Override
    public void requestInformation() {
        super.requestInformation();
        new zffj().sendToServer();
        if (!this._e) {
            new pzku().sendToServer();
        }
    }
}

