/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.options;

import gloomyfolken.mods.core.client.gui.engine.GuiActionHandler;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionCheckboxToggle;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionRadiopanelSwitch;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioButton;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioGroup;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentCheckboxStyle;
import gloomyfolken.mods.core.client.gui.screens.GuiModVideoOptions;
import gloomyfolken.mods.effects.client.main.pidb;
import gloomyfolken.mods.options.OptionsSet;
import java.util.HashMap;

public class kjui
extends GuiScreenAdvanced {
    private gqjz _b;
    protected String _a = "\u041a\u0430\u0447\u0435\u0441\u0442\u0432\u043e \u0433\u0440\u0430\u0444\u0438\u043a\u0438";
    private McRadioGroup _c;
    private McCheckBox _d;
    private McTextArea _e;
    private boolean _f;
    private HashMap<Integer, String> _g = new HashMap();
    private static final String _h = "\u0414\u043b\u044f \u0442\u043e\u0433\u043e, \u0447\u0442\u043e\u0431\u044b \u0432\u0441\u0435 \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0438\u044f \u0432\u0441\u0442\u0443\u043f\u0438\u043b\u0438 \u0432 \u0441\u0438\u043b\u0443, \u043d\u0435\u043e\u0431\u0445\u043e\u0434\u0438\u043c\u043e \u043f\u0435\u0440\u0435\u0437\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u044c \u0438\u0433\u0440\u0443!";

    public kjui(gqjz gqjz2) {
        this._b = gqjz2;
        this._g.put(0, "\u0420\u0435\u0436\u0438\u043c \u0434\u043b\u044f \u0442\u0435\u0445 \u0441\u043b\u0443\u0447\u0430\u0435\u0432, \u043a\u043e\u0433\u0434\u0430 \u043d\u0438\u043a\u0430\u043a \u0438\u043d\u0430\u0447\u0435 \u043d\u0435 \u0440\u0430\u0431\u043e\u0442\u0430\u0435\u0442. \u0412\u0441\u0435 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0441\u043d\u0438\u0436\u0435\u043d\u044b \u0434\u043e \u0440\u0430\u0437\u0443\u043c\u043d\u043e\u0433\u043e \u043c\u0438\u043d\u0438\u043c\u0443\u043c\u0430. \u041a\u0440\u043e\u043c\u0435 \u0442\u043e\u0433\u043e, \u0432 \u044d\u0442\u043e\u043c \u0440\u0435\u0436\u0438\u043c\u0435 \u0442\u0435\u043a\u0441\u0442\u0443\u0440\u044b \u043d\u0435 \u0437\u0430\u0433\u0440\u0443\u0436\u0430\u044e\u0442\u0441\u044f \u0437\u0430\u0440\u0430\u043d\u0435\u0435. \u042d\u0442\u043e \u0437\u043d\u0430\u0447\u0438\u0442, \u0447\u0442\u043e \u0434\u0430\u0436\u0435 \u043d\u0430 \u043c\u043e\u0449\u043d\u044b\u0445 \u043a\u043e\u043c\u043f\u044c\u044e\u0442\u0435\u0440\u0430\u0445 \u0438\u0433\u0440\u0430 \u0431\u0443\u0434\u0435\u0442 \u043f\u0435\u0440\u0438\u043e\u0434\u0438\u0447\u0435\u0441\u043a\u0438 \u0437\u0430\u0432\u0438\u0441\u0430\u0442\u044c \u043d\u0430 \u0434\u043e\u043b\u0438 \u0441\u0435\u043a\u0443\u043d\u0434\u044b.");
        this._g.put(1, "\u0412 \u044d\u0442\u043e\u043c \u0440\u0435\u0436\u0438\u043c\u0435 \u0441\u0434\u0435\u043b\u0430\u043d\u043e \u0432\u0441\u0435 \u0440\u0430\u0434\u0438 \u0442\u043e\u0433\u043e, \u0447\u0442\u043e\u0431\u044b \u043f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u043a\u0430\u043a \u043c\u043e\u0436\u043d\u043e \u0431\u043e\u043b\u0435\u0435 \u0432\u044b\u0441\u043e\u043a\u0438\u0439 \u0438 \u0441\u0442\u0430\u0431\u0438\u043b\u044c\u043d\u044b\u0439 FPS. \u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0441\u043d\u0438\u0436\u0435\u043d\u044b \u043f\u043e\u0447\u0442\u0438 \u0434\u043e \u0442\u043e\u0433\u043e \u0436\u0435 \u0443\u0440\u043e\u0432\u043d\u044f, \u0447\u0442\u043e \u0438 \u0432 \u043c\u0438\u043d\u0438\u043c\u0430\u043b\u044c\u043d\u043e\u043c \u0440\u0435\u0436\u0438\u043c\u0435, \u043d\u043e \u043e\u0441\u043d\u043e\u0432\u043d\u044b\u0435 \u0442\u0435\u043a\u0441\u0442\u0443\u0440\u044b \u0437\u0430\u0433\u0440\u0443\u0436\u0430\u044e\u0442\u0441\u044f \u0437\u0430\u0440\u0430\u043d\u0435\u0435. \u0420\u0435\u043a\u043e\u043c\u0435\u043d\u0434\u0443\u0435\u043c \u044d\u0442\u043e\u0442 \u0440\u0435\u0436\u0438\u043c, \u0435\u0441\u043b\u0438 \u0432\u0430\u0441 \u043d\u0435 \u0432\u043e\u043e\u0431\u0449\u0435 \u043d\u0435 \u0432\u043e\u043b\u043d\u0443\u0435\u0442 \u043a\u0430\u0447\u0435\u0441\u0442\u0432\u043e \u0433\u0440\u0430\u0444\u0438\u043a\u0438.");
        this._g.put(2, "\u041a\u043e\u043c\u043f\u0440\u043e\u043c\u0438\u0441\u0441 \u043c\u0435\u0436\u0434\u0443 \u0431\u043e\u043b\u044c\u0448\u0438\u043c FPS \u0438 \u043a\u0430\u0447\u0435\u0441\u0442\u0432\u0435\u043d\u043d\u043e\u0439 \u0433\u0440\u0430\u0444\u0438\u043a\u043e\u0439. \u0423\u0432\u0435\u043b\u0438\u0447\u0435\u043d\u0430 \u0434\u0430\u043b\u044c\u043d\u043e\u0441\u0442\u044c \u043f\u0440\u043e\u0440\u0438\u0441\u043e\u0432\u043a\u0438, \u0432\u043a\u043b\u044e\u0447\u0435\u043d\u0430 \u0442\u0440\u0430\u0432\u0430 \u0438 \u043d\u0435\u043a\u043e\u0442\u043e\u0440\u044b\u0435 \u0434\u0440\u0443\u0433\u0438\u0435 \u043e\u043f\u0446\u0438\u0438, \u043d\u043e \u0432\u0441\u0435 \u0435\u0449\u0435 \u043e\u0442\u043a\u043b\u044e\u0447\u0435\u043d\u043e \u0441\u0433\u043b\u0430\u0436\u0438\u0432\u0430\u043d\u0438\u0435 \u0442\u0435\u043a\u0441\u0442\u0443\u0440 \u0438 \u0434\u0440\u0443\u0433\u0438\u0435 \u0440\u0435\u0441\u0443\u0440\u0441\u043e\u0437\u0430\u0442\u0440\u0430\u0442\u043d\u044b\u0435 \u0432\u043e\u0437\u043c\u043e\u0436\u043d\u043e\u0441\u0442\u0438.");
        this._g.put(3, "\u041b\u0443\u0447\u0448\u0438\u0439 \u0440\u0435\u0436\u0438\u043c \u0434\u043b\u044f \u0431\u043e\u043b\u044c\u0448\u0438\u043d\u0441\u0442\u0432\u0430 \u0441\u043e\u0432\u0440\u0435\u043c\u0435\u043d\u043d\u044b\u0445 \u043a\u043e\u043c\u043f\u044c\u044e\u0442\u0435\u0440\u043e\u0432. \u0412\u043a\u043b\u044e\u0447\u0435\u043d\u044b \u0443\u043f\u0440\u043e\u0449\u0435\u043d\u043d\u043e\u0435 \u0441\u0433\u043b\u0430\u0436\u0438\u0432\u0430\u043d\u0438\u0435 \u0442\u0435\u043a\u0441\u0442\u0443\u0440, \u043c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u043e \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u0430\u044f \u043d\u0430 \u0441\u0435\u0440\u0432\u0435\u0440\u0435 \u0434\u0430\u043b\u044c\u043d\u043e\u0441\u0442\u044c \u043f\u0440\u043e\u0440\u0438\u0441\u043e\u0432\u043a\u0438 \u0438 \u043c\u043d\u043e\u0433\u043e\u0435 \u0434\u0440\u0443\u0433\u043e\u0435.");
        this._g.put(4, "\u0412\u0441\u0435 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u044b \u043d\u0430 \u043c\u0430\u043a\u0441\u0438\u043c\u0443\u043c. \u0412\u0438\u0437\u0443\u0430\u043b\u044c\u043d\u043e \u043d\u0435 \u0441\u0438\u043b\u044c\u043d\u043e \u043e\u0442\u043b\u0438\u0447\u0430\u0435\u0442\u0441\u044f \u043e\u0442 \u043f\u0440\u0435\u0434\u044b\u0434\u0443\u0449\u0435\u0433\u043e \u0440\u0435\u0436\u0438\u043c\u0430, \u043d\u043e FPS \u0437\u0430\u043c\u0435\u0442\u043d\u043e \u043d\u0438\u0436\u0435. \u041d\u0435 \u0440\u0435\u043a\u043e\u043c\u0435\u043d\u0434\u0443\u0435\u043c \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c, \u0435\u0441\u043b\u0438 \u0443 \u0432\u0430\u0441 \u043d\u0435 \u0442\u043e\u043f\u043e\u0432\u0430\u044f \u0432\u0438\u0434\u0435\u043e\u043a\u0430\u0440\u0442\u0430.");
        this._g.put(5, "\u041a\u043e\u043c\u0431\u0438\u043d\u0430\u0446\u0438\u044f \u043d\u0430\u0441\u0442\u0440\u043e\u0435\u043a, \u043a\u043e\u0442\u043e\u0440\u0430\u044f \u043d\u0435 \u0441\u043e\u0432\u043f\u0430\u0434\u0430\u0435\u0442 \u043d\u0438 \u0441 \u043e\u0434\u043d\u0438\u043c \u0438\u0437 \u043f\u0440\u0435\u0434\u044b\u0434\u0443\u0449\u0438\u0445 \u043f\u044f\u0442\u0438 \u0440\u0435\u0436\u0438\u043c\u043e\u0432.");
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 100, this.field_73881_g / 6 + 180, 200, 20, "\u0413\u043e\u0442\u043e\u0432\u043e"));
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 - 100, this.field_73881_g / 6 + 156, 200, 20, "\u0420\u0430\u0441\u0448\u0438\u0440\u0435\u043d\u043d\u044b\u0435 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438"));
        this._c = new McRadioGroup(this);
        ComponentCheckboxStyle componentCheckboxStyle = new ComponentCheckboxStyle(){
            {
                this.setSize(16, 16);
                this.setTexture(GuiHelper.clanButtons);
                this.setDefaultUv(0, 196);
                this.setMouseOverUv(16, 196);
                this.setActiveUv(32, 196);
            }
        };
        ComponentCheckboxStyle componentCheckboxStyle2 = new ComponentCheckboxStyle(){
            {
                this.setSize(16, 16);
                this.setTexture(GuiHelper.clanButtons);
                this.setDefaultUv(0, 180);
                this.setMouseOverUv(16, 180);
                this.setActiveUv(32, 180);
            }
        };
        this._c.addElement(new McRadioButton(this._c, "\u041c\u0438\u043d\u0438\u043c\u0430\u043b\u044c\u043d\u043e\u0435", this.field_73880_f - 66, this.field_73881_g / 3 - 10, componentCheckboxStyle));
        this._c.addElement(new McRadioButton(this._c, "\u041d\u0438\u0436\u0435 \u0441\u0440\u0435\u0434\u043d\u0435\u0433\u043e", this.field_73880_f - 66, this.field_73881_g / 3 + 18, componentCheckboxStyle));
        this._c.addElement(new McRadioButton(this._c, "\u0421\u0440\u0435\u0434\u043d\u0435\u0435", this.field_73880_f - 66, this.field_73881_g / 3 + 46, componentCheckboxStyle));
        this._c.addElement(new McRadioButton(this._c, "\u0412\u044b\u0448\u0435 \u0441\u0440\u0435\u0434\u043d\u0435\u0433\u043e", this.field_73880_f - 66, this.field_73881_g / 3 + 74, componentCheckboxStyle));
        this._c.addElement(new McRadioButton(this._c, "\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u043e\u0435", this.field_73880_f - 66, this.field_73881_g / 3 + 102, componentCheckboxStyle));
        this._c.addElement(new McRadioButton(this._c, "\u041f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044c\u0441\u043a\u043e\u0435", this.field_73880_f - 66, this.field_73881_g / 3 + 130, componentCheckboxStyle));
        this.addElement(this._c);
        this._d = new McCheckBox(this, "OpenGL 3", this.field_73880_f - 66, this.field_73881_g / 3 + 160, componentCheckboxStyle2);
        this._d.setActive(pidb._e());
        this.addElement(this._d);
        this.getActionManager().registerActionHandler(this._d, GuiActionCheckboxToggle.class, guiActionCheckboxToggle -> pidb._c(guiActionCheckboxToggle.newState));
        this._e = new McTextArea(this, this.field_73880_f - 200, this.field_73881_g / 3 + 184, 400, 400);
        this._e.drawBackground = false;
        this._e.isCentered = true;
        this.addElement(this._e);
        for (int i = 0; i < OptionsSet.optionsSets.length; ++i) {
            OptionsSet optionsSet = OptionsSet.optionsSets[i];
            if (!optionsSet.equalsToGameSettings()) continue;
            this._c.setActiveButton(i);
            return;
        }
        this._c.setActiveButton(this._c.getElements().size() - 1);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            if (this._b instanceof xayo) {
                this.field_73882_e._a(this._b);
            }
        } else if (jiok2.field_73741_f == 1) {
            this.field_73882_e._a(new GuiModVideoOptions(this));
        }
    }

    @GuiActionHandler
    public void _a(GuiActionRadiopanelSwitch guiActionRadiopanelSwitch) {
        this._f = true;
        int n = this._c.getElements().indexOf(guiActionRadiopanelSwitch.newActive);
        if (n >= 0 && n < OptionsSet.optionsSets.length) {
            OptionsSet.optionsSets[n].applyOptions();
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, this._a, this.field_73880_f / 2, 15, 0xFFFFFF);
        boolean bl = false;
        for (int i = 0; i < this._c.getElements().size(); ++i) {
            McRadioButton mcRadioButton = (McRadioButton)this._c.getElements().get(i);
            if (!mcRadioButton.isMouseOver()) continue;
            this._e.setText(this._g.get(i));
            this._e.color = 0xFFFFFF;
            bl = true;
        }
        if (this._d.isMouseOver()) {
            this._e.setText("\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c \u043b\u0438 \u0432\u043e\u0437\u043c\u043e\u0436\u043d\u043e\u0441\u0442\u0438 OpenGL 3. \u0412\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0435 \u044d\u0442\u043e\u0439 \u043e\u043f\u0446\u0438\u0438 \u043e\u0431\u044b\u0447\u043d\u043e \u043f\u043e\u0432\u044b\u0448\u0430\u0435\u0442 \u043f\u0440\u043e\u0438\u0437\u0432\u043e\u0434\u0438\u0442\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u044c, \u043d\u043e \u043c\u043e\u0433\u0443\u0442 \u0432\u043e\u0437\u043d\u0438\u043a\u043d\u0443\u0442\u044c \u043f\u0440\u043e\u0431\u043b\u0435\u043c\u044b \u0441 \u0433\u0440\u0430\u0444\u0438\u043a\u043e\u0439 (\u043d\u0430\u043f\u0440\u0438\u043c\u0435\u0440, \u043f\u0440\u043e\u043f\u0430\u0441\u0442\u044c \u043d\u0435\u043a\u043e\u0442\u043e\u0440\u044b\u0435 \u043c\u043e\u0434\u0435\u043b\u0438).");
            this._e.color = 0xFFFFFF;
            bl = true;
        }
        if (!bl) {
            if (this._f) {
                this._e.setText(_h);
                this._e.color = 0xCC1111;
            } else {
                this._e.setText("");
                this._e.color = 0xFFFFFF;
            }
        }
        super.func_73863_a(n, n2, f);
    }
}

