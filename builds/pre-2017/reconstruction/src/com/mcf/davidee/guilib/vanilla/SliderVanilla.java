/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.vanilla;

import com.mcf.davidee.guilib.core.Slider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class SliderVanilla
extends Slider {
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/widgets.png");

    public SliderVanilla(int n, int n2, float f, Slider.SliderFormat sliderFormat) {
        super(n, n2, f, sliderFormat);
    }

    public SliderVanilla(float f, Slider.SliderFormat sliderFormat) {
        this(150, 20, f, sliderFormat);
    }

    @Override
    public void handleClick(int n, int n2) {
        super.handleClick(n, n2);
        this.mc._N._a("random.click", 1.0f, 1.0f);
    }

    @Override
    public void draw(int n, int n2) {
        if (this.dragging) {
            this.value = (float)(n - (this.x + 4)) / (float)(this.width - 8);
            this.value = sajh._a(this.value, 0.0f, 1.0f);
        }
        this.mc._h._a(TEXTURE);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.drawTexturedModalRect(this.x, this.y, 0, 46, this.width / 2, this.height);
        this.drawTexturedModalRect(this.x + this.width / 2, this.y, 200 - this.width / 2, 46, this.width / 2, this.height);
        this.drawTexturedModalRect(this.x + (int)(this.value * (float)(this.width - 8)), this.y, 0, 66, 4, 20);
        this.drawTexturedModalRect(this.x + (int)(this.value * (float)(this.width - 8)) + 4, this.y, 196, 66, 4, 20);
        this.drawCenteredString(this.mc._z, this.format.format(this), this.x + this.width / 2, this.y + (this.height - 8) / 2, this.inBounds(n, n2) ? 0xFFFFA0 : 0xFFFFFF);
    }
}

