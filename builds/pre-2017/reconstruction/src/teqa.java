/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.shop.eidj;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;

public class teqa
extends htjl {
    private static GuiRenderer _c = GuiHelper.mcWidgetsRenderer;
    private static final List<String> _d = Collections.singletonList((Object)((Object)EnumChatFormatting._m) + "\u0412\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0442\u0435 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c \u043f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0439 \u0441\u043a\u043b\u0430\u0434 \u0437\u0430 \u043f\u0440\u0435\u0434\u0435\u043b\u0430\u043c\u0438 \u0441\u0435\u0439\u0432\u0437\u043e\u043d\u044b!");
    private boolean _e;
    private boolean _f;
    private GuiButton _g;

    @Override
    public void initGui() {
        this._e = eidj._a(this.mc._t);
        this._f = eidj._b(this.mc._t);
        this.buttonList.clear();
        int n = 0;
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 136 + n, wpcz._a("menu.returnToMenu")));
        if (!this.mc._H()) {
            ((GuiButton)this.buttonList.get((int)0)).displayString = wpcz._a("menu.disconnect");
        }
        this.buttonList.add(new GuiButton(4, this.width / 2 - 100, this.height / 4 + 31 + n, wpcz._a("menu.returnToGame")));
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 112 + n, 98, 20, wpcz._a("menu.options")));
        GuiButton guiButton = new GuiButton(7, this.width / 2 + 2, this.height / 4 + 112 + n, 98, 20, wpcz._a("menu.shareToLan"));
        this.buttonList.add(guiButton);
        guiButton.enabled = this.mc._I() && !this.mc._J()._b();
        GuiButton guiButton2 = new GuiButton(10, this.width / 2 - 100, this.height / 4 + 60 + n, 98, 20, "\u041c\u0430\u0433\u0430\u0437\u0438\u043d");
        GuiButton guiButton3 = new GuiButton(11, this.width / 2 + 2, this.height / 4 + 60 + n, 98, 20, "\u041a\u0435\u0439\u0441\u044b");
        if (!this._e) {
            guiButton2.enabled = false;
            guiButton3.enabled = false;
        }
        this.buttonList.add(guiButton2);
        this.buttonList.add(guiButton3);
        this._g = new GuiButton(12, this.width / 2 - 100, this.height / 4 + 84 + n, "\u0421\u043a\u043b\u0430\u0434 \u043f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0445 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432");
        this.buttonList.add(this._g);
        if (!this._f) {
            this._g.enabled = false;
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        if (!this._e) {
            this.drawCenteredString(this.fontRenderer, "\u0412\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0442\u0435 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c \u0432\u043d\u0443\u0442\u0440\u0438\u0438\u0433\u0440\u043e\u0432\u043e\u0439", this.width / 2, this.height / 4 + 11, 0xFFFFFF);
            this.drawCenteredString(this.fontRenderer, "\u043c\u0430\u0433\u0430\u0437\u0438\u043d, \u043f\u043e\u043a\u0430 \u043d\u0435 \u0437\u0430\u0432\u0435\u0440\u0448\u0438\u0442\u0435 \u043e\u0431\u0443\u0447\u0435\u043d\u0438\u0435.", this.width / 2, this.height / 4 + 19, 0xFFFFFF);
        }
        if (!this._f) {
            boolean bl;
            boolean bl2 = bl = n > this._g.xPosition && n < this._g.xPosition + this._g.width && n2 > this._g.yPosition && n2 < this._g.yPosition + this._g.height;
            if (bl) {
                _c.drawHoveringText(_d, n * 2, n2 * 2, this.width, this.height);
            }
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        super.actionPerformed(guiButton);
        switch (guiButton.id) {
            case 10: {
                Minecraft._E()._a(new ivwa(null));
                break;
            }
            case 11: {
                Minecraft._E()._a(new oxhq(null));
                break;
            }
            case 12: {
                this.mc._a((GuiScreen)null);
                new nudp().sendToServer();
            }
        }
    }
}

