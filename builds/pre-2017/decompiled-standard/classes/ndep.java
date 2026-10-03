/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.xpzm;
import net.minecraft.util.sajh;

public class ndep
extends sbsh<kkzc.pidb> {
    private int _b = 0;
    private List<pidb> _c = new ArrayList<pidb>();
    private McNumberField _d;

    public ndep(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui, (Class<? extends pjlq>)ndep.class);
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        this._d = new McNumberField(this.parent, this.pdaScreenStart.add((int)((double)this.pdaScreen.width * 0.6) + 20, this.pdaScreen.height - 180), new Dimension((int)((double)this.pdaScreen.width * 0.4) - 55, 30));
        this._d.setStyle(iedw._i);
        this._d.setVisible(false);
        this._d.setEnabled(false);
        this._d.setMinValue(-1000000000L);
        this._d.setMaxValue(1000000000L);
        guiPda.addElement(this._d);
    }

    @Override
    protected void _a() {
        super._a();
        GuiHelper.addLabel(this.parent, "##", this._a.getLocation().add(15, -25), iedw._h);
        GuiHelper.addLabel(this.parent, "\u041d\u0438\u043a", this._a.getLocation().add(40, -25), iedw._h);
    }

    @Override
    public void tick() {
        super.tick();
        kkzc.pidb pidb2 = (kkzc.pidb)this._a.getSelectedLine();
        if (pidb2 != null) {
            this._a(pidb2);
        }
    }

    private void _c() {
        this._b = 0;
        this._c.stream().filter(Objects::nonNull).forEach(this.parent.getElementsList()::removeElement);
        this._c.clear();
        kkzc.pidb pidb2 = (kkzc.pidb)this._a.getSelectedLine();
        if (pidb2 == null) {
            return;
        }
        kkzc kkzc2 = yuch._a;
        String string = xpzm._E()._t.field_71092_bJ;
        if (kkzc2._b != vjsq._d && pidb2._a.equals(string)) {
            this._a(kjui._b);
        }
        if (kkzc2._c.contains((Object)amww._d) && pidb2._b != vjsq._d && !pidb2._a.equals(string)) {
            this._a(kjui._a);
        }
        if (kkzc2._c.contains((Object)amww._g)) {
            if (pidb2._f) {
                this._a(kjui._i);
            } else {
                this._a(kjui._j);
            }
        }
        if (kkzc2._c.contains((Object)amww._i) && !pidb2._a.equals(string)) {
            this._a(kjui._f);
        }
        if (kkzc2._c.contains((Object)amww._h) && pidb2._a.equals(string)) {
            this._a(kjui._g);
        }
        if (kkzc2._c.contains((Object)amww._e) && !pidb2._a.equals(string) && pidb2._b != vjsq._d) {
            if (pidb2._b != vjsq._a) {
                this._a(kjui._c);
            }
            if (pidb2._b != vjsq._b) {
                this._a(kjui._d);
            }
            if (pidb2._b != vjsq._c) {
                this._a(kjui._e);
            }
        }
        if (kkzc2._c.contains((Object)amww._l)) {
            this._d.setVisible(true);
            this._d.setEnabled(true);
            this._a(kjui._h);
            this._d.setLocation(new Point(this._d.getLocation().x, this.pdaScreenStart.y + this.pdaScreen.height - 40 - this._b * 33 - 30));
        } else {
            this._d.setEnabled(false);
            this._d.setVisible(false);
        }
    }

    @Override
    private void _a(pidb pidb2) {
        kjui kjui2 = pidb2._b;
        kkzc.pidb pidb3 = (kkzc.pidb)this._a.getSelectedLine();
        if (kjui2 == null || pidb3 == null) {
            return;
        }
        switch (kjui2) {
            case _a: {
                this.pda.dialog.setText("\u0412\u044b \u0443\u0432\u0435\u0440\u0435\u043d\u044b, \u0447\u0442\u043e \u0445\u043e\u0442\u0438\u0442\u0435 \u0438\u0441\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u0438\u0433\u0440\u043e\u043a\u0430 " + pidb3._a + " \u0438\u0437 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438?").setOnConfirm(() -> ncul._b(new eikd(pidb2._a))).setOnDecline(null).setTitle("\u0418\u0441\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0435 \u0443\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u0430").setStatus(true);
                break;
            }
            case _b: {
                ncul._b(new ctfo());
                break;
            }
            case _c: {
                ncul._b(new piir(pidb3._a, vjsq._a));
                break;
            }
            case _d: {
                ncul._b(new piir(pidb3._a, vjsq._b));
                break;
            }
            case _e: {
                ncul._b(new piir(pidb3._a, vjsq._c));
                break;
            }
            case _f: {
                this.pda.dialog.setText("\u0412\u044b \u0443\u0432\u0435\u0440\u0435\u043d\u044b, \u0447\u0442\u043e \u0445\u043e\u0442\u0438\u0442\u0435 \u043f\u0435\u0440\u0435\u0434\u0430\u0442\u044c \u043f\u0440\u0430\u0432\u0430 \u043b\u0438\u0434\u0435\u0440\u0430 \u0438\u0433\u0440\u043e\u043a\u0443 " + pidb3._a + "?").setOnConfirm(() -> ncul._b(new piir(pidb2._a, vjsq._d))).setOnDecline(null).setTitle("\u0421\u043c\u0435\u043d\u0430 \u043b\u0438\u0434\u0435\u0440\u0430").setStatus(true);
                break;
            }
            case _g: {
                this.pda.dialog.setText("\u0412\u044b \u0443\u0432\u0435\u0440\u0435\u043d\u044b, \u0447\u0442\u043e \u0445\u043e\u0442\u0438\u0442\u0435 \u0440\u0430\u0441\u043f\u0443\u0441\u0442\u0438\u0442\u044c \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0443?").setOnConfirm(() -> ncul._b(new hrpq())).setOnDecline(null).setTitle("\u0423\u0434\u0430\u043b\u0435\u043d\u0438\u0435 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438").setStatus(true);
                break;
            }
            case _h: {
                int n = (int)this._d.getValue();
                pidb3._d = sajh._a(pidb3._d + n, -1000000000, 1000000000);
                ncul._b(new fljj(pidb3._a, n));
                break;
            }
            case _i: {
                pidb3._f = false;
                ncul._b(new dwfp(pidb3._a, false));
                this.pda.openTab(this);
                break;
            }
            case _j: {
                pidb3._f = true;
                ncul._b(new dwfp(pidb3._a, true));
                this.pda.openTab(this);
            }
        }
    }

    @Override
    public void _a(kkzc.pidb pidb2) {
        this._c();
        this._a(Arrays.asList("\u041d\u0438\u043a: " + pidb2._a, "\u0420\u0430\u043d\u0433: " + pidb2._b._e, "\u0414\u043e\u0431\u044b\u0442\u044b\u0435 \u041e\u0420: " + pidb2._e, "\u041e\u0447\u043a\u0438 \u043b\u043e\u044f\u043b\u044c\u043d\u043e\u0441\u0442\u0438: " + pidb2._d, pidb2._f ? "\u041e\u0442\u0441\u0442\u0440\u0430\u043d\u0435\u043d \u043e\u0442 \u0437\u0430\u0445\u0432\u0430\u0442\u043e\u0432" : "", pidb2._c == -1L ? "\u0418\u0433\u0440\u043e\u043a \u0432 \u0441\u0435\u0442\u0438" : "\u0418\u0433\u0440\u043e\u043a \u043d\u0435 \u0432 \u0441\u0435\u0442\u0438", pidb2._c == -1L ? "" : "\u0411\u044b\u043b \u0432 \u0441\u0435\u0442\u0438 " + andg._a(pidb2._c) + " \u043d\u0430\u0437\u0430\u0434"));
    }

    @Override
    private void _a(kjui kjui2) {
        int n = this._b++;
        pidb pidb2 = new pidb(this.parent, this.pdaScreenStart.add((int)((double)this.pdaScreen.width * 0.6) + 20, this.pdaScreen.height - 50 - n * 33), iedw._l, kjui2._k, kjui2);
        pidb2.setSize(new Dimension((int)((double)this.pdaScreen.width * 0.4) - 55, 30));
        this.parent.getActionManager().registerActionHandler(pidb2, GuiActionButtonClick.class, guiActionButtonClick -> this._a(pidb2));
        this.parent.getElementsList().addElement(pidb2);
        this._c.add(pidb2);
    }

    @Override
    public List<kkzc.pidb> _b() {
        return yuch._a._r;
    }

    @Override
    public void requestInformation() {
        super.requestInformation();
        new eijo().sendToServer();
    }

    private static enum kjui {
        _a("\u0418\u0441\u043a\u043b\u044e\u0447\u0438\u0442\u044c"),
        _b("\u041f\u043e\u043a\u0438\u043d\u0443\u0442\u044c \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0443"),
        _c("\u0423\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c \u0440\u0430\u043d\u0433: " + vjsq._a._e),
        _d("\u0423\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c \u0440\u0430\u043d\u0433: " + vjsq._b._e),
        _e("\u0423\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c \u0440\u0430\u043d\u0433: " + vjsq._c._e),
        _f("\u0421\u0434\u0435\u043b\u0430\u0442\u044c \u043b\u0438\u0434\u0435\u0440\u043e\u043c"),
        _g("\u0420\u0430\u0441\u043f\u0443\u0441\u0442\u0438\u0442\u044c \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0443"),
        _h("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u043e\u0447\u043a\u0438 \u043b\u043e\u044f\u043b\u044c\u043d\u043e\u0441\u0442\u0438"),
        _i("\u0414\u043e\u043f\u0443\u0441\u0442\u0438\u0442\u044c \u0434\u043e \u0437\u0430\u0445\u0432\u0430\u0442\u043e\u0432"),
        _j("\u041e\u0442\u0441\u0442\u0440\u0430\u043d\u0438\u0442\u044c \u043e\u0442 \u0437\u0430\u0445\u0432\u0430\u0442\u043e\u0432");

        private final String _k;

        private kjui(String string2) {
            this._k = string2;
        }
    }

    private class pidb
    extends McButton {
        private kjui _b;

        public pidb(IAdvancedGui iAdvancedGui, Point point, ComponentButtonStyle componentButtonStyle, String string, kjui kjui2) {
            super(iAdvancedGui, point, componentButtonStyle, string);
            this._b = kjui2;
        }

        public kjui _a() {
            return this._b;
        }

        public pidb _a(kjui kjui2) {
            this._b = kjui2;
            return this;
        }
    }
}

