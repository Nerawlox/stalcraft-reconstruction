/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.money.zwat;
import java.util.List;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.xpzm;

public class dxjw
extends pjlq {
    static final String _a = "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0434\u043e\u043b\u0436\u043d\u043e \u0431\u044b\u0442\u044c \u0434\u043b\u0438\u043d\u043e\u0439 \u043e\u0442 4 \u0434\u043e 16 \u0441\u0438\u043c\u0432\u043e\u043b\u043e\u0432, \u0441\u043e\u0441\u0442\u043e\u044f\u0442\u044c \u0446\u0435\u043b\u0438\u043a\u043e\u043c \u0438\u0437 \u0440\u0443\u0441\u0441\u043a\u0438\u0445 \u043b\u0438\u0431\u043e \u0430\u043d\u0433\u043b\u0438\u0439\u0441\u043a\u0438\u0445 \u0431\u0443\u043a\u0432, \u0442\u0430\u043a\u0436\u0435 \u0434\u043e\u043f\u0443\u0441\u043a\u0430\u044e\u0442\u0441\u044f \u043f\u0440\u043e\u0431\u0435\u043b\u044b";
    private McTextField _b;
    private McButton _c;
    private McLabel _d;

    public dxjw(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui, (Class<? extends pjlq>)dxjw.class);
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        this._a();
        this._b();
        this._a(300000);
    }

    @Override
    public void tick() {
        super.tick();
        long l = zwat._a(xpzm._E()._t)._a();
        int n = iedw._h.getFontColor().getRGB();
        if (l < 300000L) {
            n = 0xFF0000;
        }
        this._d.color = n;
        this._c.setEnabled(this._d());
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, this.pdaScreen, true);
        super.drawComponent(point, f);
    }

    private void _a() {
        List<String> list2 = this.renderer.getFontRenderer().wrapString(_a, this.pdaScreen.width / 4);
        for (int i = 0; i < list2.size(); ++i) {
            String string = list2.get(i);
            GuiHelper.addLabel((IAdvancedGui)this.parent, (String)string, (Point)this.pdaScreenStart.add((int)(this.pdaScreen.width / 2 - this.renderer.getStringWidth((String)string) / 2), (int)(this.pdaScreen.height / 2 - 50 + 17 * i))).color = iedw._e.getRGB();
        }
    }

    private void _b() {
        this._b = new McTextField(this.parent, this.pdaScreenStart.add(this.pdaScreen.width / 2 - 150, this.pdaScreen.height / 2 + 10), new Dimension(300, 30));
        this.parent.getElementsList().addElement(this._b);
        this._b.setStyle(iedw._i);
        this._c = GuiHelper.addButton(this.parent, this.pdaScreenStart.add(this.pdaScreen.width / 2 - 150, this.pdaScreen.height / 2 + 45), new Dimension(145, 30), iedw._l, "\u0421\u043e\u0437\u0434\u0430\u0442\u044c");
        this.parent.getActionManager().registerActionHandler(this._c, GuiActionButtonClick.class, guiActionButtonClick -> this._c());
        McButton mcButton = GuiHelper.addButton(this.parent, this.pdaScreenStart.add(this.pdaScreen.width / 2 + 5, this.pdaScreen.height / 2 + 45), new Dimension(145, 30), iedw._l, "\u041e\u0442\u043c\u0435\u043d\u0430");
        this.parent.getActionManager().registerActionHandler(mcButton, GuiActionButtonClick.class, guiActionButtonClick -> xpzm._E()._a((gqjz)null));
    }

    private void _a(int n) {
        String string = "\u0421\u0442\u043e\u0438\u043c\u043e\u0441\u0442\u044c \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438: " + n + " \u0440\u0443\u0431.";
        this._d = GuiHelper.addLabel(this.parent, string, this.pdaScreenStart.add(this.pdaScreen.width / 2 - this.renderer.getStringWidth(string) / 2, this.pdaScreen.height / 2 + 80), 0xFF0000);
    }

    private void _c() {
        new sanm(this._b.getText().trim()).sendToServer();
    }

    private boolean _d() {
        long l = zwat._a(xpzm._E()._t)._a();
        String string = this._b.getText();
        boolean bl = string.length() >= 4 && string.length() <= 16 && (string.matches("[a-zA-Z\\s]*") || string.matches("[\u0430-\u044f\u0410-\u042f\\s]*"));
        return bl && l >= 300000L;
    }
}

