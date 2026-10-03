/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.party;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.party.kjui;
import gloomyfolken.mods.party.zwat;
import java.util.ArrayList;
import java.util.List;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;
import net.minecraft.client.Minecraft;

@ezey(_a={eidj.CLIENT})
public class tupg
extends AbstractPdaTab {
    private static final int _a = 1;
    private static final int _b = 2;
    private static final int _c = 3;
    private McTextField _d;
    private McButton _e;
    private List<kjui.kjui> _f = new ArrayList<kjui.kjui>();

    protected tupg(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui);
        this._f = new ArrayList<kjui.kjui>(zwat._a._a.values());
    }

    @Override
    public void init(GuiPda guiPda) {
        boolean bl;
        super.init(guiPda);
        boolean bl2 = !this._f.isEmpty();
        boolean bl3 = bl = bl2 && Minecraft._E()._t.username.equals(this._f.get((int)0)._a);
        if (bl2) {
            this._a(this._f, this.pdaScreenStart.add(6, 37), new Dimension(this.pdaScreen.width - 15, this.pdaScreen.height));
        }
        boolean bl4 = !bl2 || bl && this._f.size() < 5;
        this._b();
        this._e.setVisible(bl4);
        this._e.setEnabled(bl4);
        this._d.setVisible(bl4);
        this._d.setEnabled(bl4);
        if (!bl2) {
            this._d.setFocused(true);
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        if (n == 28 && this._d.isFocused()) {
            this._c();
        }
    }

    public void _a(List<kjui.kjui> list) {
        this._f = new ArrayList<kjui.kjui>(list);
        this.pda.openTab(this);
    }

    private void _a(List<kjui.kjui> list, Point point, Dimension dimension) {
        Dimension dimension2 = new Dimension(dimension.width, 27);
        int n = 0;
        String string = Minecraft._E()._t.username;
        boolean bl = list.get((int)0)._a.equals(string);
        for (int i = 0; i < Math.max(list.size(), 5); ++i) {
            if (i < list.size()) {
                boolean bl2;
                kjui.kjui kjui2 = list.get(i);
                boolean bl3 = i == 0;
                boolean bl4 = kjui2._a.equals(string);
                boolean bl5 = bl2 = !kjui2._c;
                int n2 = bl3 ? 1 : (bl2 ? 3 : 2);
                kjui kjui3 = new kjui(this.pda, point.add(0, n), dimension2, bl, bl4, kjui2._a, n2);
                this.pda.addElement(kjui3);
                kjui3._a();
            } else {
                this.pda.addElement(new kjui(this.pda, point.add(0, n), dimension2, false, false, "", 0));
            }
            n += 33;
        }
    }

    private void _b() {
        boolean bl = !this._f.isEmpty();
        Point point = bl ? this.pdaScreenStart.add(10, this.pdaScreen.height - 40) : this.pdaScreenStart.add(this.pdaScreen.width / 2 - 150, this.pdaScreen.height / 2 + 10);
        Dimension dimension = bl ? new Dimension(182, 30) : new Dimension(300, 30);
        this._d = new McTextField(this.pda, point, dimension);
        this._d.setStyle(iedw._i);
        this._d.tipText = "\u041d\u0438\u043a...";
        this.pda.addElement(this._d);
        Point point2 = bl ? this.pdaScreenStart.add(197, this.pdaScreen.height - 40) : this.pdaScreenStart.add(this.pdaScreen.width / 2 - 150, this.pdaScreen.height / 2 + 45);
        Dimension dimension2 = bl ? new Dimension(150, 30) : new Dimension(300, 30);
        this._e = GuiHelper.addButton(this.pda, point2, dimension2, iedw._l, "\u041f\u0440\u0438\u0433\u043b\u0430\u0441\u0438\u0442\u044c");
        this._e.onClick(guiActionButtonClick -> this._c());
        if (!bl) {
            String string = "\u0414\u043b\u044f \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f \u043e\u0442\u0440\u044f\u0434\u0430 \u043e\u0442\u043f\u0440\u0430\u0432\u044c\u0442\u0435 \u043f\u0440\u0438\u0433\u043b\u0430\u0448\u0435\u043d\u0438\u0435 \u0434\u0440\u0443\u0433\u043e\u043c\u0443 \u0438\u0433\u0440\u043e\u043a\u0443";
            List<String> list = this.renderer.wrapString(string, 300);
            for (int i = 0; i < list.size(); ++i) {
                String string2 = list.get(i);
                GuiHelper.addLabel((IAdvancedGui)this.pda, string2, this.pdaScreenStart.add(this.pdaScreen.width / 2 - this.renderer.getStringWidth(string2) / 2, this.pdaScreen.height / 2 - 20 * list.size() + 20 * i), 0x939393);
            }
        }
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, this.pdaScreen, true);
        super.drawComponent(point, f);
    }

    private void _c() {
        String string = this._d.getText().trim();
        if (string.isEmpty()) {
            return;
        }
        new cthk(string).sendClientToBackend();
    }

    public void _a() {
        new ofhw().sendClientToBackend();
    }

    private void _d() {
        new iuxx().sendClientToBackend();
    }

    private void _a(String string) {
        new xqcm(string).sendClientToBackend();
    }

    private void _b(String string) {
        new xqcq(string).sendClientToBackend();
    }

    private void _c(String string) {
        this._a(string);
    }

    private class kjui
    extends GuiComponent {
        private boolean _b;
        private boolean _c;
        private String _d;
        private int _e;

        public kjui(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, boolean bl, boolean bl2, String string, int n) {
            super(iAdvancedGui, point, dimension);
            this._b = bl;
            this._c = bl2;
            this._d = string;
            this._e = n;
        }

        private void _a() {
            GuiComponent guiComponent;
            if (this._e == 1) {
                guiComponent = new McImage(this.parent, this.getLocation().add(20, 8), new Point(250, 796), new Dimension(20, 19), iedw._a);
                this.parent.getElementsList().addElement(guiComponent);
            }
            GuiHelper.addLabel((IAdvancedGui)this.parent, (String)this._d, (Point)this.getLocation().add((int)43, (int)10)).color = this._b();
            if (this._c) {
                if (this._b) {
                    guiComponent = GuiHelper.addButton(this.parent, this.getLocation().add(this.getSize().width - 313, 8), new Dimension(138, 20), iedw._f, "\u0440\u0430\u0441\u043f\u0443\u0441\u0442\u0438\u0442\u044c \u043e\u0442\u0440\u044f\u0434");
                    ((McButton)guiComponent).onClick(guiActionButtonClick -> tupg.this._a());
                    ((McButton)guiComponent).mouseOverTextColor = 0xFFFFFF;
                    ((McButton)guiComponent).onClick(guiActionButtonClick -> tupg.this._a(this._d));
                    this.parent.getElementsList().addElement(new McImage(this.parent, this.getLocation().add(this.getSize().width - 173, 10), new Point(65, 878), new Dimension(14, 18), iedw._a));
                }
                guiComponent = GuiHelper.addButton(this.parent, this.getLocation().add(this.getSize().width - 165, 8), new Dimension(138, 20), iedw._f, "\u043f\u043e\u043a\u0438\u043d\u0443\u0442\u044c \u043e\u0442\u0440\u044f\u0434");
                ((McButton)guiComponent).mouseOverTextColor = 0xFFFFFF;
                ((McButton)guiComponent).onClick(guiActionButtonClick -> tupg.this._d());
            }
            if (this._b) {
                if (this._e == 2) {
                    guiComponent = GuiHelper.addButton(this.parent, this.getLocation().add(this.getSize().width - 318, 8), new Dimension(138, 20), iedw._f, "\u0438\u0441\u043a\u043b\u044e\u0447\u0438\u0442\u044c");
                    ((McButton)guiComponent).mouseOverTextColor = 0xFFFFFF;
                    ((McButton)guiComponent).onClick(guiActionButtonClick -> tupg.this._a(this._d));
                    this.parent.getElementsList().addElement(new McImage(this.parent, this.getLocation().add(this.getSize().width - 203, 10), new Point(65, 878), new Dimension(14, 18), iedw._a));
                    McButton mcButton = GuiHelper.addButton(this.parent, this.getLocation().add(this.getSize().width - 180, 8), new Dimension(138, 20), iedw._f, "\u043d\u0430\u0437\u043d\u0430\u0447\u0438\u0442\u044c \u043b\u0438\u0434\u0435\u0440\u043e\u043c");
                    mcButton.mouseOverTextColor = 0xFFFFFF;
                    mcButton.onClick(guiActionButtonClick -> tupg.this._b(this._d));
                } else if (this._e == 3) {
                    guiComponent = GuiHelper.addButton(this.parent, this.getLocation().add(this.getSize().width - 200, 8), new Dimension(138, 20), iedw._f, "\u043e\u0442\u043c\u0435\u043d\u0438\u0442\u044c \u043f\u0440\u0438\u0433\u043b\u0430\u0448\u0435\u043d\u0438\u0435");
                    ((McButton)guiComponent).mouseOverTextColor = 0xFFFFFF;
                    ((McButton)guiComponent).onClick(guiActionButtonClick -> tupg.this._c(this._d));
                }
            }
        }

        @Override
        public void drawComponent(Point point, float f) {
            Minecraft._E()._R()._a(iedw._a);
            this.renderer.drawTiledRect(this.getLocation().add(5, 5), new Point(64, 768), new Dimension(this.getSize().width - 18, 27), new Dimension(64, 27), 23, 0);
            super.drawComponent(point, f);
        }

        private int _b() {
            switch (this._e) {
                case 1: {
                    return 15195904;
                }
                case 2: {
                    return 0x109101;
                }
            }
            return iedw._e.getRGB();
        }
    }
}

