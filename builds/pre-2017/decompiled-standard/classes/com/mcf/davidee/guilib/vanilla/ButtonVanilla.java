/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.vanilla;

import com.mcf.davidee.guilib.core.Button;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ButtonVanilla
extends Button {
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/widgets.png");
    protected String str;

    public ButtonVanilla(int n, int n2, String string, Button.ButtonHandler buttonHandler) {
        super(n, n2, buttonHandler);
        this.str = string;
    }

    public ButtonVanilla(String string, Button.ButtonHandler buttonHandler) {
        this(200, 20, string, buttonHandler);
    }

    @Override
    public void draw(int n, int n2) {
        this.mc._h._a(TEXTURE);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        boolean bl = this.inBounds(n, n2);
        int n3 = 0;
        int n4 = 46 + this.getStateOffset(bl);
        if (this.width == 200 && this.height == 20) {
            this.func_73729_b(this.x, this.y, n3, n4, this.width, this.height);
        } else {
            this.func_73729_b(this.x, this.y, n3, n4, this.width / 2, this.height / 2);
            this.func_73729_b(this.x + this.width / 2, this.y, n3 + 200 - this.width / 2, n4, this.width / 2, this.height / 2);
            this.func_73729_b(this.x, this.y + this.height / 2, n3, n4 + 20 - this.height / 2, this.width / 2, this.height / 2);
            this.func_73729_b(this.x + this.width / 2, this.y + this.height / 2, n3 + 200 - this.width / 2, n4 + 20 - this.height / 2, this.width / 2, this.height / 2);
        }
        this.func_73732_a(this.mc._z, this.str, this.x + this.width / 2, this.y + (this.height - 8) / 2, this.getTextColor(bl));
    }

    private int getStateOffset(boolean bl) {
        return this.enabled ? (bl ? 40 : 20) : 0;
    }

    private int getTextColor(boolean bl) {
        return this.enabled ? (bl ? 0xFFFFA0 : 0xE0E0E0) : 6250336;
    }

    @Override
    public String getText() {
        return this.str;
    }

    @Override
    public void setText(String string) {
        this.str = string;
    }

    @Override
    public void handleClick(int n, int n2) {
        this.mc._N._a("random.click", 1.0f, 1.0f);
        super.handleClick(n, n2);
    }
}

