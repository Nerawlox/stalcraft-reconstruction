/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.gui;

import eu.ha3.matmos.game.gui.MAtGuiBiomeSlider;
import eu.ha3.matmos.game.system.MAtMod;
import eu.ha3.mc.gui.HGuiSliderControl;

public class MAtGuiMore
extends gqjz {
    private final int IDS_PER_PAGE = 5;
    private gqjz parentScreen;
    protected String screenTitle = "MAtmos Advanced options";
    private MAtMod mod;
    private int buttonId = -1;

    public MAtGuiMore(gqjz gqjz2, MAtMod mAtMod) {
        this.parentScreen = gqjz2;
        this.mod = mAtMod;
    }

    @Override
    public void func_73866_w_() {
        int n = 2;
        int n2 = 20;
        int n3 = 310;
        int n4 = 22;
        int n5 = this.field_73880_f / 2 - 155;
        int n6 = 10;
        int n7 = 62;
        this.field_73887_h.add(new jiok(211, n5 + 22, 22, 266, 20, this.mod.getConfig().getBoolean("reversed.controls") ? "Menu: Hold Down Key to open" : "Menu: Press Key to open"));
        this.field_73887_h.add(new jiok(212, n5 + 22, 44, 266, 20, this.mod.getConfig().getBoolean("useroptions.altitudes.low") ? "Low-altitude ambiences: ON" : "Low-altitude ambiences: OFF"));
        this.field_73887_h.add(new jiok(213, n5 + 22, 66, 266, 20, this.mod.getConfig().getBoolean("useroptions.altitudes.high") ? "High-altitude ambiences: ON" : "High-altitude ambiences: OFF"));
        MAtGuiBiomeSlider mAtGuiBiomeSlider = new MAtGuiBiomeSlider(this.mod, this.mod.getConfig().getInteger("useroptions.biome.override"));
        HGuiSliderControl hGuiSliderControl = new HGuiSliderControl(214, n5, 88, 310, 20, "", mAtGuiBiomeSlider.calculateSliderLocation(this.mod.getConfig().getInteger("useroptions.biome.override")));
        hGuiSliderControl.setListener(mAtGuiBiomeSlider);
        hGuiSliderControl.setDisplayStringProvider(mAtGuiBiomeSlider);
        hGuiSliderControl.updateDisplayString();
        this.field_73887_h.add(hGuiSliderControl);
        this.field_73887_h.add(new jiok(220, n5 + 22, 132, 266, 20, this.mod.getConfig().getBoolean("dump.sheets.enabled") ? "Data dump: " + (this.mod.isDumpReady() ? "Enabled (this will slow down Minecraft)" : "Enabled when Minecraft restarts") : "Data dump: Disabled"));
        if (this.mod.isDumpReady()) {
            this.field_73887_h.add(new jiok(215, n5 + 22, 154, 266, 20, "Generate data dump now"));
        } else {
            this.field_73887_h.add(new jiok(215, n5 + 22, 154, 266, 20, "Generate PARTIAL data dump now"));
        }
        this.field_73887_h.add(new jiok(200, n5 + 22, 10 + 22 * (this.IDS_PER_PAGE + 4), 202, 20, "Done"));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 200) {
            this.field_73882_e._a(this.parentScreen);
        } else if (jiok2.field_73741_f == 211) {
            this.mod.getConfig().setProperty("reversed.controls", !this.mod.getConfig().getBoolean("reversed.controls"));
            jiok2.field_73744_e = this.mod.getConfig().getBoolean("reversed.controls") ? "Menu: Hold Down Key to open" : "Menu: Press Key to open";
            this.mod.saveConfig();
        } else if (jiok2.field_73741_f == 212) {
            this.mod.getConfig().setProperty("useroptions.altitudes.low", !this.mod.getConfig().getBoolean("useroptions.altitudes.low"));
            jiok2.field_73744_e = this.mod.getConfig().getBoolean("useroptions.altitudes.low") ? "Low-altitude ambiences: ON" : "Low-altitude ambiences: OFF";
            this.mod.saveConfig();
        } else if (jiok2.field_73741_f == 213) {
            this.mod.getConfig().setProperty("useroptions.altitudes.high", !this.mod.getConfig().getBoolean("useroptions.altitudes.high"));
            jiok2.field_73744_e = this.mod.getConfig().getBoolean("useroptions.altitudes.high") ? "High-altitude ambiences: ON" : "High-altitude ambiences: OFF";
            this.mod.saveConfig();
        } else if (jiok2.field_73741_f == 215) {
            if (this.mod.isDumpReady()) {
                this.mod.createDataDump(false);
            } else {
                this.mod.createDataDump(true);
            }
        } else if (jiok2.field_73741_f == 220) {
            this.mod.getConfig().setProperty("dump.sheets.enabled", !this.mod.getConfig().getBoolean("dump.sheets.enabled"));
            jiok2.field_73744_e = this.mod.getConfig().getBoolean("dump.sheets.enabled") ? "Data dump: " + (this.mod.isDumpReady() ? "Enabled (this will slow down Minecraft)" : "Enabled when Minecraft restarts") : "Data dump: Disabled";
            this.mod.saveConfig();
        }
    }

    private void aboutToClose() {
        this.mod.saveConfig();
    }

    @Override
    public void func_73874_b() {
        this.aboutToClose();
    }

    @Override
    protected void func_73864_a(int n, int n2, int n3) {
        if (this.buttonId < 0) {
            super.func_73864_a(n, n2, n3);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, this.screenTitle, this.field_73880_f / 2, 8, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }
}

