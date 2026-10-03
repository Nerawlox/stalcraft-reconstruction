/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mods.pda.client.screens.GuiPda;

public class cugv
extends sbsh<kkzc.eidj> {
    private static final int _b = 0;
    private static final int _c = 1;
    private static final String _d = "\u041e\u0431\u044a\u044f\u0432\u0438\u0442\u044c \u0432\u043e\u0439\u043d\u0443";
    private List<McButton> _e = new ArrayList<McButton>();
    private owak[] _f = new owak[2];

    public cugv(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui, (Class<? extends pjlq>)cugv.class);
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        this._e.clear();
        for (int i = 0; i < 2; ++i) {
            int n = i;
            McButton mcButton = new McButton((IAdvancedGui)guiPda, this.pdaScreenStart.add((int)((double)this.pdaScreen.width * 0.6) + 20, this.pdaScreen.height - 100 + i * 35), iedw._l, "");
            guiPda.getActionManager().registerActionHandler(mcButton, GuiActionButtonClick.class, guiActionButtonClick -> this._a(n));
            mcButton.setSize(new Dimension((int)((double)this.pdaScreen.width * 0.4) - 55, 30));
            mcButton.setVisible(false);
            mcButton.setEnabled(false);
            guiPda.addElement(mcButton);
            this._e.add(mcButton);
        }
    }

    @Override
    protected void _a() {
        super._a();
        GuiHelper.addLabel(this.parent, "##", this._a.getLocation().add(15, -25), iedw._h);
        GuiHelper.addLabel(this.parent, "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435", this._a.getLocation().add(40, -25), iedw._h);
    }

    @Override
    public void tick() {
        super.tick();
        kkzc.eidj eidj2 = (kkzc.eidj)this._a.getSelectedLine();
        if (eidj2 != null) {
            this._a(eidj2);
        }
    }

    @Override
    public void _a(kkzc.eidj eidj2) {
        this._a(Arrays.asList("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435: " + eidj2._a._a, "\u0424\u0440\u0430\u043a\u0446\u0438\u044f: " + eidj2._a._f._d, "\u041b\u0438\u0434\u0435\u0440: " + eidj2._a._b, "\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0443\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u043e\u0432: " + eidj2._a._d, "\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0431\u0430\u0437: " + eidj2._a._e, "\u041e\u0447\u043a\u0438 \u0440\u0435\u0441\u0443\u0440\u0441\u043e\u0432: " + eidj2._a._g, "\u041e\u0442\u043d\u043e\u0448\u0435\u043d\u0438\u044f: " + eidj2._a._c._j));
        kkzc kkzc2 = yuch._a;
        if (!eidj2._a._a.equals(kkzc2._a) && kkzc2._c.contains((Object)amww._c)) {
            this._a(eidj2._a._c);
        } else {
            this._b(0);
            this._b(1);
        }
    }

    @Override
    private void _a(owak owak2) {
        switch (owak2) {
            case _g: {
                this._a(0, _d, owak._a);
                this._a(1, "\u041f\u0440\u0435\u0434\u043b\u043e\u0436\u0438\u0442\u044c \u0441\u043e\u044e\u0437", owak._d);
                break;
            }
            case _a: {
                this._b(0);
                this._a(1, "\u041f\u0440\u0435\u0434\u043b\u043e\u0436\u0438\u0442\u044c \u043c\u0438\u0440", owak._g);
                break;
            }
            case _b: {
                this._a(0, "\u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c \u0432\u043e\u0439\u043d\u0443", owak._a);
                this._b(1);
                break;
            }
            case _c: {
                this._a(0, _d, owak._a);
                this._a(1, "\u0417\u0430\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u043c\u0438\u0440", owak._g);
                break;
            }
            case _e: {
                this._a(0, _d, owak._a);
                this._a(1, "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c \u043f\u0440\u0435\u0434\u043b\u043e\u0436\u0435\u043d\u043d\u044b\u0439 \u0441\u043e\u044e\u0437", owak._g);
                break;
            }
            case _f: {
                this._a(0, _d, owak._a);
                this._a(1, "\u0417\u0430\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u0441\u043e\u044e\u0437", owak._d);
                break;
            }
            case _d: {
                this._a(0, _d, owak._a);
                this._a(1, "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c \u0441\u043e\u044e\u0437", owak._g);
            }
        }
    }

    @Override
    private void _a(int n) {
        kkzc.eidj eidj2 = (kkzc.eidj)this._a.getSelectedLine();
        owak owak2 = this._f[n];
        if (eidj2 == null || owak2 == null) {
            return;
        }
        if (eidj2._a._c != owak._b && owak2 == owak._a) {
            this.pda.dialog.setText("\u0412\u044b \u0443\u0432\u0435\u0440\u0435\u043d\u044b, \u0447\u0442\u043e \u0445\u043e\u0442\u0438\u0442\u0435 \u043e\u0431\u044a\u044f\u0432\u0438\u0442\u044c \u0432\u043e\u0439\u043d\u0443 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0435 " + eidj2._a._a + "?").setOnConfirm(() -> new eigw(eidj2._a._a, owak._a).sendClientToBackend()).setOnDecline(null).setTitle("\u041e\u0431\u044a\u044f\u0432\u043b\u0435\u043d\u0438\u0435 \u0432\u043e\u0439\u043d\u044b").setStatus(true);
        } else if (eidj2._a._c == owak._f && owak2 == owak._g) {
            this.pda.dialog.setText("\u0412\u044b \u0443\u0432\u0435\u0440\u0435\u043d\u044b, \u0447\u0442\u043e \u0445\u043e\u0442\u0438\u0442\u0435 \u0440\u0430\u0437\u043e\u0440\u0432\u0430\u0442\u044c \u0441\u043e\u044e\u0437 \u0441 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u043e\u0439 " + eidj2._a._a + "?").setOnConfirm(() -> new eigw(eidj2._a._a, owak._g).sendClientToBackend()).setOnDecline(null).setTitle("\u0420\u0430\u0441\u0442\u043e\u0440\u0436\u0435\u043d\u0438\u0435 \u0441\u043e\u044e\u0437\u0430").setStatus(true);
        } else {
            new eigw(eidj2._a._a, owak2).sendClientToBackend();
        }
        this._a(eidj2);
    }

    private void _a(int n, String string, owak owak2) {
        McButton mcButton = this._e.get(n);
        mcButton.setVisible(true);
        mcButton.setEnabled(true);
        mcButton.text = string;
        this._f[n] = owak2;
    }

    private void _b(int n) {
        McButton mcButton = this._e.get(n);
        mcButton.setEnabled(false);
        mcButton.setVisible(false);
        mcButton.text = "";
        this._f[n] = null;
    }

    @Override
    public List<kkzc.eidj> _b() {
        return yuch._a._s;
    }

    @Override
    public void requestInformation() {
        super.requestInformation();
        new tdqj().sendToServer();
    }
}

