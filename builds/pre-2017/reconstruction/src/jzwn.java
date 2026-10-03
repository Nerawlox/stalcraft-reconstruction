/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collections;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

public class jzwn
extends GuiScreen {
    public final rqmv _a;
    public ekjj _b;
    public List _c = Collections.emptyList();
    public vlxd _d;
    public int _e = -1;
    public GuiButton _f;

    public jzwn(rqmv rqmv2, ekjj ekjj2) {
        this._a = rqmv2;
        this._b = ekjj2;
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this._d = new vlxd(this);
        new tfrc(this).start();
        this._a();
    }

    public void _a() {
        this.buttonList.add(new GuiButton(0, this.width / 2 + 6, this.height - 52, 153, 20, wpcz._a("gui.cancel")));
        this._f = new GuiButton(1, this.width / 2 - 154, this.height - 52, 153, 20, wpcz._a("mco.template.button.select"));
        this.buttonList.add(this._f);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == 1) {
            this._b();
        } else if (guiButton.id == 0) {
            this._a._a(null);
            this.mc._a(this._a);
        } else {
            this._d._a(guiButton);
        }
    }

    public void _b() {
        if (this._e >= 0 && this._e < this._c.size()) {
            this._a._a(this._c.get(this._e));
            this.mc._a(this._a);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this._d._a(n, n2, f);
        this.drawCenteredString(this.fontRenderer, wpcz._a("mco.template.title"), this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }

    public static /* synthetic */ Minecraft _a(jzwn jzwn2) {
        return jzwn2.mc;
    }

    public static /* synthetic */ List _a(jzwn jzwn2, List list) {
        jzwn2._c = list;
        return jzwn2._c;
    }

    public static /* synthetic */ Minecraft _b(jzwn jzwn2) {
        return jzwn2.mc;
    }

    public static /* synthetic */ Minecraft _c(jzwn jzwn2) {
        return jzwn2.mc;
    }

    public static /* synthetic */ List _d(jzwn jzwn2) {
        return jzwn2._c;
    }

    public static /* synthetic */ int _a(jzwn jzwn2, int n) {
        jzwn2._e = n;
        return jzwn2._e;
    }

    public static /* synthetic */ ekjj _a(jzwn jzwn2, ekjj ekjj2) {
        jzwn2._b = ekjj2;
        return jzwn2._b;
    }

    public static /* synthetic */ ekjj _e(jzwn jzwn2) {
        return jzwn2._b;
    }

    public static /* synthetic */ int _f(jzwn jzwn2) {
        return jzwn2._e;
    }

    public static /* synthetic */ FontRenderer _g(jzwn jzwn2) {
        return jzwn2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _h(jzwn jzwn2) {
        return jzwn2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _i(jzwn jzwn2) {
        return jzwn2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _j(jzwn jzwn2) {
        return jzwn2.fontRenderer;
    }
}

