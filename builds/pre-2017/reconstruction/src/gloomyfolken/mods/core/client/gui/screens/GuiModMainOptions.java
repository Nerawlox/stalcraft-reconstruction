/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import gloomyfolken.mods.core.client.gui.screens.GuiModGameOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiModPerformanceOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiModSoundOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiModVideoOptions;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiModMainOptions
extends GuiScreen {
    private GuiScreen parentGuiScreen;
    protected String screenTitle = "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438";

    public GuiModMainOptions(GuiScreen guiScreen) {
        this.parentGuiScreen = guiScreen;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(100, this.width / 2 - 100, this.height / 6 + 168, 200, 20, "\u0413\u043e\u0442\u043e\u0432\u043e"));
        this.buttonList.add(new GuiButton(101, this.width / 2 - 60, this.height / 6 + 10, 120, 20, "\u0418\u0433\u0440\u0430"));
        this.buttonList.add(new GuiButton(102, this.width / 2 - 60, this.height / 6 + 35, 120, 20, "\u0417\u0432\u0443\u043a"));
        this.buttonList.add(new GuiButton(103, this.width / 2 - 60, this.height / 6 + 60, 120, 20, "\u0413\u0440\u0430\u0444\u0438\u043a\u0430"));
        this.buttonList.add(new GuiButton(104, this.width / 2 - 60, this.height / 6 + 85, 120, 20, "\u041f\u0440\u043e\u0438\u0437\u0432\u043e\u0434\u0438\u0442\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u044c"));
        this.buttonList.add(new GuiButton(105, this.width / 2 - 60, this.height / 6 + 110, 120, 20, "\u0423\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435"));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 100) {
            this.mc._a(this.parentGuiScreen);
        } else if (guiButton.id == 101) {
            this.mc._a(new GuiModGameOptions(this));
        } else if (guiButton.id == 102) {
            this.mc._a(new GuiModSoundOptions(this));
        } else if (guiButton.id == 103) {
            this.mc._a(new GuiModVideoOptions(this));
        } else if (guiButton.id == 104) {
            this.mc._a(new GuiModPerformanceOptions(this));
        } else if (guiButton.id == 105) {
            this.mc._a(new nuzu(this, this.mc._M));
        } else if (guiButton.id == 106) {
            this.mc._a(new ekou(this, this.mc._M));
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 15, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }
}

