/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.gui;

import eu.ha3.matmos.game.gui.MAtGuiBiomeSlider;
import eu.ha3.matmos.game.system.MAtMod;
import eu.ha3.mc.gui.HGuiSliderControl;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class MAtGuiMore
extends GuiScreen {
    private final int IDS_PER_PAGE = 5;
    private GuiScreen parentScreen;
    protected String screenTitle = "MAtmos Advanced options";
    private MAtMod mod;
    private int buttonId = -1;

    public MAtGuiMore(GuiScreen guiScreen, MAtMod mAtMod) {
        this.parentScreen = guiScreen;
        this.mod = mAtMod;
    }

    @Override
    public void initGui() {
        int n = 2;
        int n2 = 20;
        int n3 = 310;
        int n4 = 22;
        int n5 = this.width / 2 - 155;
        int n6 = 10;
        int n7 = 62;
        this.buttonList.add(new GuiButton(211, n5 + 22, 22, 266, 20, this.mod.getConfig().getBoolean("reversed.controls") ? "Menu: Hold Down Key to open" : "Menu: Press Key to open"));
        this.buttonList.add(new GuiButton(212, n5 + 22, 44, 266, 20, this.mod.getConfig().getBoolean("useroptions.altitudes.low") ? "Low-altitude ambiences: ON" : "Low-altitude ambiences: OFF"));
        this.buttonList.add(new GuiButton(213, n5 + 22, 66, 266, 20, this.mod.getConfig().getBoolean("useroptions.altitudes.high") ? "High-altitude ambiences: ON" : "High-altitude ambiences: OFF"));
        MAtGuiBiomeSlider mAtGuiBiomeSlider = new MAtGuiBiomeSlider(this.mod, this.mod.getConfig().getInteger("useroptions.biome.override"));
        HGuiSliderControl hGuiSliderControl = new HGuiSliderControl(214, n5, 88, 310, 20, "", mAtGuiBiomeSlider.calculateSliderLocation(this.mod.getConfig().getInteger("useroptions.biome.override")));
        hGuiSliderControl.setListener(mAtGuiBiomeSlider);
        hGuiSliderControl.setDisplayStringProvider(mAtGuiBiomeSlider);
        hGuiSliderControl.updateDisplayString();
        this.buttonList.add(hGuiSliderControl);
        this.buttonList.add(new GuiButton(220, n5 + 22, 132, 266, 20, this.mod.getConfig().getBoolean("dump.sheets.enabled") ? "Data dump: " + (this.mod.isDumpReady() ? "Enabled (this will slow down Minecraft)" : "Enabled when Minecraft restarts") : "Data dump: Disabled"));
        if (this.mod.isDumpReady()) {
            this.buttonList.add(new GuiButton(215, n5 + 22, 154, 266, 20, "Generate data dump now"));
        } else {
            this.buttonList.add(new GuiButton(215, n5 + 22, 154, 266, 20, "Generate PARTIAL data dump now"));
        }
        this.buttonList.add(new GuiButton(200, n5 + 22, 10 + 22 * (this.IDS_PER_PAGE + 4), 202, 20, "Done"));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 200) {
            this.mc._a(this.parentScreen);
        } else if (guiButton.id == 211) {
            this.mod.getConfig().setProperty("reversed.controls", !this.mod.getConfig().getBoolean("reversed.controls"));
            guiButton.displayString = this.mod.getConfig().getBoolean("reversed.controls") ? "Menu: Hold Down Key to open" : "Menu: Press Key to open";
            this.mod.saveConfig();
        } else if (guiButton.id == 212) {
            this.mod.getConfig().setProperty("useroptions.altitudes.low", !this.mod.getConfig().getBoolean("useroptions.altitudes.low"));
            guiButton.displayString = this.mod.getConfig().getBoolean("useroptions.altitudes.low") ? "Low-altitude ambiences: ON" : "Low-altitude ambiences: OFF";
            this.mod.saveConfig();
        } else if (guiButton.id == 213) {
            this.mod.getConfig().setProperty("useroptions.altitudes.high", !this.mod.getConfig().getBoolean("useroptions.altitudes.high"));
            guiButton.displayString = this.mod.getConfig().getBoolean("useroptions.altitudes.high") ? "High-altitude ambiences: ON" : "High-altitude ambiences: OFF";
            this.mod.saveConfig();
        } else if (guiButton.id == 215) {
            if (this.mod.isDumpReady()) {
                this.mod.createDataDump(false);
            } else {
                this.mod.createDataDump(true);
            }
        } else if (guiButton.id == 220) {
            this.mod.getConfig().setProperty("dump.sheets.enabled", !this.mod.getConfig().getBoolean("dump.sheets.enabled"));
            guiButton.displayString = this.mod.getConfig().getBoolean("dump.sheets.enabled") ? "Data dump: " + (this.mod.isDumpReady() ? "Enabled (this will slow down Minecraft)" : "Enabled when Minecraft restarts") : "Data dump: Disabled";
            this.mod.saveConfig();
        }
    }

    private void aboutToClose() {
        this.mod.saveConfig();
    }

    @Override
    public void onGuiClosed() {
        this.aboutToClose();
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        if (this.buttonId < 0) {
            super.mouseClicked(n, n2, n3);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 8, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }
}

