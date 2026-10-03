/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.settings.GameSettings;

public class twpa
extends GuiScreen {
    public GuiScreen _a;
    public jiqn _b;
    public final GameSettings _c;
    public final LanguageManager _d;
    public baxz _e;

    public twpa(GuiScreen guiScreen, GameSettings gameSettings, LanguageManager languageManager) {
        this._a = guiScreen;
        this._c = gameSettings;
        this._d = languageManager;
    }

    @Override
    public void initGui() {
        this._e = new baxz(6, this.width / 2 - 75, this.height - 38, wpcz._a("gui.done"));
        this.buttonList.add(this._e);
        this._b = new jiqn(this);
        this._b.registerScrollButtons(7, 8);
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        switch (guiButton.id) {
            case 5: {
                break;
            }
            case 6: {
                this.mc._a(this._a);
                break;
            }
            default: {
                this._b.actionPerformed(guiButton);
            }
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this._b.drawScreen(n, n2, f);
        this.drawCenteredString(this.fontRenderer, wpcz._a("options.language"), this.width / 2, 16, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "(" + wpcz._a("options.languageWarning") + ")", this.width / 2, this.height - 56, 0x808080);
        super.drawScreen(n, n2, f);
    }

    public static /* synthetic */ LanguageManager _a(twpa twpa2) {
        return twpa2._d;
    }

    public static /* synthetic */ GameSettings _b(twpa twpa2) {
        return twpa2._c;
    }

    public static /* synthetic */ baxz _c(twpa twpa2) {
        return twpa2._e;
    }
}

