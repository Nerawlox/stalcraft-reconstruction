/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.gui;

import eu.ha3.matmos.game.system.MAtMod;
import eu.ha3.mc.gui.HDisplayStringProvider;
import eu.ha3.mc.gui.HGuiSliderControl;
import eu.ha3.mc.gui.HSliderListener;

public class MAtGuiBiomeSlider
implements HDisplayStringProvider,
HSliderListener {
    protected final MAtMod mod;
    protected final int maxBiomes = this.calculateMaxBiomes();
    protected int definedBiomeID;

    public MAtGuiBiomeSlider(MAtMod mAtMod, int n) {
        this.mod = mAtMod;
        this.definedBiomeID = n;
    }

    @Override
    public void sliderValueChanged(HGuiSliderControl hGuiSliderControl, float f) {
        int n;
        this.definedBiomeID = n = (int)(Math.floor(f * (float)this.maxBiomes) - 1.0);
        hGuiSliderControl.updateDisplayString();
    }

    @Override
    public void sliderPressed(HGuiSliderControl hGuiSliderControl) {
    }

    @Override
    public void sliderReleased(HGuiSliderControl hGuiSliderControl) {
        this.mod.getConfig().setProperty("useroptions.biome.override", this.definedBiomeID);
        this.mod.saveConfig();
    }

    @Override
    public String provideDisplayString() {
        String string = "Override biome detection: ";
        if (this.definedBiomeID >= 0 && this.definedBiomeID < foqh._a.length) {
            foqh foqh2 = foqh._a[this.definedBiomeID];
            if (foqh2 == null) {
                return "Override biome detection: Undefined biome (" + this.definedBiomeID + ")";
            }
            if (foqh2._y.equals("")) {
                return "Override biome detection: Unnamed biome (" + this.definedBiomeID + ")";
            }
            return "Override biome detection: Only " + foqh2._y + " (" + this.definedBiomeID + ")";
        }
        if (this.definedBiomeID == -1) {
            return "Override biome detection: Disabled (use current biome)";
        }
        return "";
    }

    public float calculateSliderLocation(int n) {
        return ((float)n + 1.0f) / (float)this.maxBiomes;
    }

    private int calculateMaxBiomes() {
        foqh[] foqhArray = foqh._a;
        int n = 0;
        for (int i = 0; i < foqhArray.length; ++i) {
            if (foqhArray[i] == null) continue;
            n = i + 1;
        }
        return n;
    }
}

