/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import gloomyfolken.mods.stalker.clans.zwat;
import gloomyfolken.mods.stalker.misc.tupg;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;

public class bret
extends sbsh<kkzc.kjui> {
    private static String _b = "\u0420\u0430\u0437 \u0432 \u043f\u044f\u0442\u044c \u043c\u0438\u043d\u0443\u0442 \u0432\u044b \u043c\u043e\u0436\u0435\u0442\u0435 \u043c\u0433\u043d\u043e\u0432\u0435\u043d\u043d\u043e \u043f\u0435\u0440\u0435\u043c\u0435\u0449\u0430\u0442\u044c\u0441\u044f \u043c\u0435\u0436\u0434\u0443 \u0431\u0430\u0437\u0430\u043c\u0438 \u0432\u0430\u0448\u0435\u0439 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0438 \u0437\u0430 2500 \u0440\u0443\u0431.";
    private McTextArea _c;
    private McButton _d;
    private String _e = null;

    public bret(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui, (Class<? extends pjlq>)bret.class);
    }

    public bret(IAdvancedGui iAdvancedGui, String string) {
        this(iAdvancedGui);
        this._e = string;
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        this._d();
        if (this._e != null) {
            kkzc.kjui kjui3 = this._a.getLines().stream().filter(kjui2 -> kjui2._a._a.equals(this._e)).findFirst().orElse(null);
            if (kjui3 == null) {
                return;
            }
            this._a.setSelectedLineId(this._a.getLines().indexOf(kjui3));
            this._e = null;
        }
    }

    @Override
    public void tick() {
        super.tick();
        this._c();
    }

    @Override
    public void _a(kkzc.kjui kjui2) {
        this._a(this._a(kjui2._a));
    }

    @Override
    public List<kkzc.kjui> _b() {
        return yuch._a._q;
    }

    private List<String> _a(zfdc.kjui kjui2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.addAll(Arrays.asList("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435: " + kjui2._a, "\u041b\u043e\u043a\u0430\u0446\u0438\u044f: " + kjui2._d, "\u041a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u044b: " + kjui2._e + ", " + kjui2._g, "\u0412\u043b\u0430\u0434\u0435\u043b\u0435\u0446: " + (kjui2._i.isEmpty() ? "\u043d\u0435\u0442" : kjui2._i), "\u041e\u0447\u043a\u0438 \u0440\u0435\u0441\u0443\u0440\u0441\u043e\u0432: " + kjui2._o));
        if (kjui2._m) {
            arrayList.addAll(Arrays.asList("\u0414\u0435\u043d\u044c \u0437\u0430\u0445\u0432\u0430\u0442\u0430: " + (kjui2._j == null ? "\u0435\u0436\u0435\u0434\u043d\u0435\u0432\u043d\u043e" : kjui2._j.getDisplayName(TextStyle.FULL, new Locale("ru"))), "\u0412\u0440\u0435\u043c\u044f \u0437\u0430\u0445\u0432\u0430\u0442\u0430: " + kjui2._k, "\u0414\u043b\u0438\u0442\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u044c \u0437\u0430\u0445\u0432\u0430\u0442\u0430: " + kjui2._l.toMinutes() + " \u043c\u0438\u043d."));
        } else {
            arrayList.addAll(Arrays.asList("", "", ""));
        }
        return arrayList;
    }

    @Override
    protected void _a() {
        super._a();
        GuiHelper.addLabel(this.parent, "##", this._a.getLocation().add(15, -25), iedw._h);
        GuiHelper.addLabel(this.parent, "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435", this._a.getLocation().add(40, -25), iedw._h);
    }

    @Override
    public void requestInformation() {
        super.requestInformation();
        new flmy().sendToServer();
    }

    private void _c() {
        kkzc.kjui kjui2 = (kkzc.kjui)this._a.getSelectedLine();
        this._d.setVisible(kjui2 != null);
        this._c.setVisible(kjui2 != null);
        if (kjui2 != null) {
            this._d.setEnabled(this._b(kjui2));
        }
    }

    private void _d() {
        this._c = new McTextArea(this.parent, this.pdaScreenStart.add((int)((double)this.pdaScreen.width * 0.6) + 10, this.pdaScreen.height - 155), new Dimension((int)((double)this.pdaScreen.width * 0.4) - 55, 120));
        this._c.setStyle(iedw._i);
        this._c.setText(_b);
        this._c.drawBackground = false;
        this.parent.getElementsList().addElement(this._c);
        this._d = new McButton(this.parent, this._c.getLocation().add(10, 105), iedw._l, "\u0422\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f").onClick(guiActionButtonClick -> {
            int n = yuch._a._q.get((int)this._a.getSelectedLineId())._a._b;
            new ropb(n).sendToServer();
        });
        this._d.setSize(new Dimension((int)((double)this.pdaScreen.width * 0.4) - 55, 30));
        this.parent.getElementsList().addElement(this._d);
    }

    private boolean _b(kkzc.kjui kjui3) {
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        zwat zwat2 = zwat._b(entityClientPlayerMP);
        kkzc kkzc2 = yuch._a;
        zfdc.kjui kjui4 = kjui3._a;
        return !kjui4._i.isEmpty() && kjui4._i.equals(kkzc2._a) && !zwat2._a() && zwat2._b() && kkzc2._q.stream().anyMatch(kjui2 -> entityClientPlayerMP.getDistance(kjui2._a._e, kjui2._a._f, kjui2._a._g) < 15.0) && !tupg._a(entityClientPlayerMP)._g();
    }
}

