/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.vanilla;

import com.mcf.davidee.guilib.core.Checkbox;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CheckboxVanilla
extends Checkbox {
    private static final ResourceLocation TEXTURE = new ResourceLocation("guilib", "textures/gui/checkbox.png");
    public static final int SIZE = 10;

    public CheckboxVanilla(String string) {
        super(12 + Minecraft._E()._z._b(string), 10, string);
    }

    public CheckboxVanilla(String string, boolean bl) {
        this(string);
        this.check = bl;
    }

    @Override
    public void handleClick(int n, int n2) {
        this.mc._N._a("random.click", 1.0f, 1.0f);
        super.handleClick(n, n2);
    }

    @Override
    public void draw(int n, int n2) {
        this.mc._h._a(TEXTURE);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.drawTexturedModalRect(this.x, this.y, 0, this.check ? 10 : 0, 10, 10);
        this.mc._z._a(this.str, this.x + 10 + 1, this.y + 1, this.inBounds(n, n2) ? 0xFFFFA0 : 0xFFFFFF);
    }
}

