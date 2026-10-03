/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.paintinggui.gui;

import com.mcf.davidee.guilib.core.Button;
import com.mcf.davidee.guilib.core.Scrollbar;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ugqi;
import org.lwjgl.opengl.GL11;

public class PaintingButton
extends Button
implements Scrollbar.Shiftable {
    public static ResourceLocation TEXTURE = new ResourceLocation("textures/painting/paintings_kristoffer_zetterstrand.png");
    public static int KZ_WIDTH = 256;
    public static int KZ_HEIGHT = 256;
    private static final int BORDER = 3;
    private static final int YELLOW = -256;
    public final ugqi art;

    public PaintingButton(ugqi ugqi2, Button.ButtonHandler buttonHandler) {
        super(ugqi2.__aL, ugqi2.__aM, buttonHandler);
        this.art = ugqi2;
    }

    @Override
    public void draw(int n, int n2) {
        this.mc._h._a(TEXTURE);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.func_73729_b(this.x, this.y, this.art.__aN, this.art.__aO, this.width, this.height);
        if (this.inBounds(n, n2)) {
            PaintingButton.func_73734_a(this.x - 3, this.y - 3, this.x + this.width + 3, this.y, -256);
            PaintingButton.func_73734_a(this.x - 3, this.y + this.height, this.x + this.width + 3, this.y + this.height + 3, -256);
            PaintingButton.func_73734_a(this.x - 3, this.y, this.x, this.y + this.height, -256);
            PaintingButton.func_73734_a(this.x + this.width, this.y, this.x + this.width + 3, this.y + this.height, -256);
        }
    }

    @Override
    public void handleClick(int n, int n2) {
        this.mc._N._a("random.click", 1.0f, 1.0f);
        super.handleClick(n, n2);
    }

    @Override
    public void func_73729_b(int n, int n2, int n3, int n4, int n5, int n6) {
        float f = 1.0f / (float)KZ_WIDTH;
        float f2 = 1.0f / (float)KZ_HEIGHT;
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78374_a(n + 0, n2 + n6, this.field_73735_i, (float)(n3 + 0) * f, (float)(n4 + n6) * f2);
        htvf2.func_78374_a(n + n5, n2 + n6, this.field_73735_i, (float)(n3 + n5) * f, (float)(n4 + n6) * f2);
        htvf2.func_78374_a(n + n5, n2 + 0, this.field_73735_i, (float)(n3 + n5) * f, (float)(n4 + 0) * f2);
        htvf2.func_78374_a(n + 0, n2 + 0, this.field_73735_i, (float)(n3 + 0) * f, (float)(n4 + 0) * f2);
        htvf2.func_78381_a();
    }

    @Override
    public void shiftY(int n) {
        this.y += n;
    }

    public void shiftX(int n) {
        this.x += n;
    }
}

