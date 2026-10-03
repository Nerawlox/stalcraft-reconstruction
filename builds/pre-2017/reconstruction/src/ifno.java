/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;

public class ifno
extends GuiScreen {
    public final GuiScreen _a;
    public final GameSettings _b;
    public final List _c = new ArrayList();
    public final List _d = new ArrayList();
    public String _e;
    public String[] _f;
    public aoxf _g;
    public GuiButton _h;

    public ifno(GuiScreen guiScreen, GameSettings gameSettings) {
        this._a = guiScreen;
        this._b = gameSettings;
    }

    @Override
    public void initGui() {
        this._e = wpcz._a("options.snooper.title");
        String string = wpcz._a("options.snooper.desc");
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Iterator iterator2 : this.fontRenderer._c(string, this.width - 30)) {
            arrayList.add((String)((Object)iterator2));
        }
        this._f = arrayList.toArray(new String[0]);
        this._c.clear();
        this._d.clear();
        this._h = new GuiButton(1, this.width / 2 - 152, this.height - 30, 150, 20, this._b.getKeyBinding(EnumOptions._x));
        this.buttonList.add(this._h);
        this.buttonList.add(new GuiButton(2, this.width / 2 + 2, this.height - 30, 150, 20, wpcz._a("gui.done")));
        boolean bl = this.mc._J() != null && this.mc._J().__am() != null;
        for (Map.Entry entry : new TreeMap(this.mc._L()._e()).entrySet()) {
            this._c.add((bl ? "C " : "") + (String)entry.getKey());
            this._d.add(this.fontRenderer._a((String)entry.getValue(), this.width - 220));
        }
        if (bl) {
            for (Map.Entry entry : new TreeMap(this.mc._J().__am()._e()).entrySet()) {
                this._c.add("S " + (String)entry.getKey());
                this._d.add(this.fontRenderer._a((String)entry.getValue(), this.width - 220));
            }
        }
        this._g = new aoxf(this);
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == 2) {
            this._b.saveOptions();
            this._b.saveOptions();
            this.mc._a(this._a);
        }
        if (guiButton.id == 1) {
            this._b.setOptionValue(EnumOptions._x, 1);
            this._h.displayString = this._b.getKeyBinding(EnumOptions._x);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this._g.drawScreen(n, n2, f);
        this.drawCenteredString(this.fontRenderer, this._e, this.width / 2, 8, 0xFFFFFF);
        int n3 = 22;
        for (String string : this._f) {
            this.drawCenteredString(this.fontRenderer, string, this.width / 2, n3, 0x808080);
            n3 += this.fontRenderer._c;
        }
        super.drawScreen(n, n2, f);
    }

    public static /* synthetic */ List _a(ifno ifno2) {
        return ifno2._c;
    }

    public static /* synthetic */ List _b(ifno ifno2) {
        return ifno2._d;
    }
}

