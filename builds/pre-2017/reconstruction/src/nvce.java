/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

public class nvce
extends GuiScreen {
    public final GuiScreen _a;
    public near _b;
    public List _c = Lists.newArrayList();
    public int _d = -1;

    public nvce(GuiScreen guiScreen) {
        this._a = guiScreen;
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this._b = new near(this);
        new vlxo(this).start();
        this._a();
    }

    public void _a() {
        this.buttonList.add(new GuiButton(1, this.width / 2 - 154, this.height - 52, 153, 20, wpcz._a("mco.invites.button.accept")));
        this.buttonList.add(new GuiButton(2, this.width / 2 + 6, this.height - 52, 153, 20, wpcz._a("mco.invites.button.reject")));
        this.buttonList.add(new GuiButton(0, this.width / 2 - 75, this.height - 28, 153, 20, wpcz._a("gui.back")));
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
            this._c();
        } else if (guiButton.id == 0) {
            this.mc._a(this._a);
        } else if (guiButton.id == 2) {
            this._b();
        } else {
            this._b._a(guiButton);
        }
    }

    public void _b() {
        if (this._d >= 0 && this._d < this._c.size()) {
            new iwtq(this).start();
        }
    }

    public void _c() {
        if (this._d >= 0 && this._d < this._c.size()) {
            new ekhw(this).start();
        }
    }

    public void _d() {
        int n = this._d;
        if (this._c.size() - 1 == this._d) {
            --this._d;
        }
        this._c.remove(n);
        if (this._c.size() == 0) {
            this._d = -1;
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this._b._a(n, n2, f);
        this.drawCenteredString(this.fontRenderer, wpcz._a("mco.invites.title"), this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }

    public static /* synthetic */ Minecraft _a(nvce nvce2) {
        return nvce2.mc;
    }

    public static /* synthetic */ List _a(nvce nvce2, List list) {
        nvce2._c = list;
        return nvce2._c;
    }

    public static /* synthetic */ Minecraft _b(nvce nvce2) {
        return nvce2.mc;
    }

    public static /* synthetic */ Minecraft _c(nvce nvce2) {
        return nvce2.mc;
    }

    public static /* synthetic */ int _d(nvce nvce2) {
        return nvce2._d;
    }

    public static /* synthetic */ List _e(nvce nvce2) {
        return nvce2._c;
    }

    public static /* synthetic */ void _f(nvce nvce2) {
        nvce2._d();
    }

    public static /* synthetic */ Minecraft _g(nvce nvce2) {
        return nvce2.mc;
    }

    public static /* synthetic */ Minecraft _h(nvce nvce2) {
        return nvce2.mc;
    }

    public static /* synthetic */ Minecraft _i(nvce nvce2) {
        return nvce2.mc;
    }

    public static /* synthetic */ Minecraft _j(nvce nvce2) {
        return nvce2.mc;
    }

    public static /* synthetic */ int _a(nvce nvce2, int n) {
        nvce2._d = n;
        return nvce2._d;
    }

    public static /* synthetic */ FontRenderer _k(nvce nvce2) {
        return nvce2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _l(nvce nvce2) {
        return nvce2.fontRenderer;
    }
}

