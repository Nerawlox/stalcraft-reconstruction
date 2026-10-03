/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import mods.pda.client.screens.GuiPda;

public class gprk
extends pjlq {
    private McNumberField _a;
    private McNumberField _b;

    public gprk(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui, (Class<? extends pjlq>)mack.class);
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        kkzc kkzc2 = yuch._a;
        Point point = this.pdaScreenStart.add(20, 40);
        Dimension dimension = new Dimension(150, 30);
        GuiHelper.addLabel((IAdvancedGui)this.pda, (String)"\u041e\u0447\u043a\u043e\u0432 \u043b\u043e\u044f\u043b\u044c\u043d\u043e\u0441\u0442\u0438 \u0437\u0430 \u0443\u0431\u0438\u0439\u0441\u0442\u0432\u043e \u043d\u0430 \u0437\u0430\u0445\u0432\u0430\u0442\u0435 \u0431\u0430\u0437\u044b:", (Point)point.add((int)0, (int)20)).color = 0x939393;
        this._a = this._a(point.add(0, 50), dimension, kkzc2._m);
        this.pda.addElement(this._a);
        GuiHelper.addLabel((IAdvancedGui)this.pda, (String)"\u041e\u0447\u043a\u043e\u0432 \u043b\u043e\u044f\u043b\u044c\u043d\u043e\u0441\u0442\u0438 \u0437\u0430 \u0441\u0435\u043a\u0443\u043d\u0434\u0443 \u0437\u0430\u0445\u0432\u0430\u0442\u0430 \u0431\u0430\u0437\u044b:", (Point)point.add((int)0, (int)110)).color = 0x939393;
        this._b = this._a(point.add(0, 140), dimension, kkzc2._n);
        this.pda.addElement(this._b);
        GuiHelper.addButton(this.pda, this.pdaScreenStart.add(15, this.pdaScreen.height - 45), new Dimension(182, 30), iedw._l, "\u0413\u043e\u0442\u043e\u0432\u043e").onClick(guiActionButtonClick -> this._a());
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, this.pdaScreen, true);
        super.drawComponent(point, f);
    }

    private void _a() {
        int n = (int)this._a.getValue();
        int n2 = (int)this._b.getValue();
        yuch._a._m = n;
        yuch._a._n = n2;
        new mqbb(n, n2).sendClientToBackend();
        this.pda.openTab(new mack((IAdvancedGui)this.pda, true));
    }

    private McNumberField _a(Point point, Dimension dimension, int n) {
        McNumberField mcNumberField = new McNumberField(this.pda, point, dimension);
        mcNumberField.setStyle(iedw._i);
        mcNumberField.setMinValue(0L);
        mcNumberField.setMaxValue(1000000000L);
        mcNumberField.setNumber(n);
        return mcNumberField;
    }
}

