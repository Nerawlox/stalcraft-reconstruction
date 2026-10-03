/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.screens.GuiOptionsSlider;
import net.minecraft.client.gui.GuiButton;

public abstract class hbdd
extends anpn {
    @ezey(_a={eidj.CLIENT})
    public abstract void onSliderChanged(GuiOptionsSlider var1);

    public abstract float getSliderValue();

    @Override
    @ezey(_a={eidj.CLIENT})
    public GuiButton createButton(int n, int n2, int n3) {
        return new GuiOptionsSlider(n, n2, n3, this.getName(), this.getSliderValue(), this);
    }

    @Override
    public void onButtonPressed() {
    }
}

