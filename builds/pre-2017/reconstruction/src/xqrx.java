/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.screens.GuiOptionsSlider;
import net.minecraftforge.common.Configuration;

public class xqrx
extends hbdd {
    private String name;
    protected String localizedName;
    private int minValue;
    private int maxValue;
    public int value;
    private int changeStep = 1;

    public xqrx(String string, String string2, int n, int n2, int n3) {
        this.name = string;
        this.localizedName = string2;
        this.value = n;
        this.minValue = n2;
        this.maxValue = n3;
    }

    @Override
    public void onSliderChanged(GuiOptionsSlider guiOptionsSlider) {
        this.setFromSliderValue(guiOptionsSlider.sliderValue);
        guiOptionsSlider.displayString = this.getName();
    }

    @Override
    public String getOptionName() {
        return this.localizedName;
    }

    @Override
    public String getName() {
        return this.localizedName + ": " + this.value;
    }

    @Override
    public String getUnlocalizedName() {
        return this.name;
    }

    @Override
    public void save(Configuration configuration) {
        configuration.get("general", this.name, 0).set(this.value);
    }

    @Override
    public void load(Configuration configuration) {
        this.value = configuration.get("general", this.name, this.value).getInt(this.value);
    }

    @Override
    public float getSliderValue() {
        return (float)(this.value - this.minValue) / (float)(this.maxValue - this.minValue);
    }

    public void setFromSliderValue(float f) {
        this.value = this.minValue + (int)(f * (float)(this.maxValue - this.minValue));
    }

    public int getMinValue() {
        return this.minValue;
    }

    public int getMaxValue() {
        return this.maxValue;
    }

    public int getChangeStep() {
        return this.changeStep;
    }

    public xqrx setChangeStep(int n) {
        this.changeStep = n;
        return this;
    }
}

