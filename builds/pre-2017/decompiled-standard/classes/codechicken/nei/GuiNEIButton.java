/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiNEIButton
extends jiok {
    protected static ResourceLocation guiTex = new ResourceLocation("textures/gui/widgets.png");

    public GuiNEIButton(int n, int n2, int n3, int n4, int n5, String string) {
        super(n, n2, n3, n4, n5, string);
    }

    @Override
    public void func_73737_a(xpzm xpzm2, int n, int n2) {
        if (!this.field_73748_h) {
            return;
        }
        qncw qncw2 = xpzm2._z;
        xpzm2._h._a(guiTex);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        boolean bl = n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + this.field_73747_a && n2 < this.field_73743_d + this.field_73745_b;
        int n3 = this.func_73738_a(bl);
        this.func_73729_b(this.field_73746_c, this.field_73743_d, 0, 46 + n3 * 20, this.field_73747_a / 2, this.field_73745_b / 2);
        this.func_73729_b(this.field_73746_c + this.field_73747_a / 2, this.field_73743_d, 200 - this.field_73747_a / 2, 46 + n3 * 20, this.field_73747_a / 2, this.field_73745_b / 2);
        this.func_73729_b(this.field_73746_c, this.field_73743_d + this.field_73745_b / 2, 0, 46 + n3 * 20 + 20 - this.field_73745_b / 2, this.field_73747_a / 2, this.field_73745_b / 2);
        this.func_73729_b(this.field_73746_c + this.field_73747_a / 2, this.field_73743_d + this.field_73745_b / 2, 200 - this.field_73747_a / 2, 46 + n3 * 20 + 20 - this.field_73745_b / 2, this.field_73747_a / 2, this.field_73745_b / 2);
        this.func_73739_b(xpzm2, n, n2);
        if (!this.field_73742_g) {
            this.func_73732_a(qncw2, this.field_73744_e, this.field_73746_c + this.field_73747_a / 2, this.field_73743_d + (this.field_73745_b - 8) / 2, -6250336);
        } else if (bl) {
            this.func_73732_a(qncw2, this.field_73744_e, this.field_73746_c + this.field_73747_a / 2, this.field_73743_d + (this.field_73745_b - 8) / 2, 0xFFFFA0);
        } else {
            this.func_73732_a(qncw2, this.field_73744_e, this.field_73746_c + this.field_73747_a / 2, this.field_73743_d + (this.field_73745_b - 8) / 2, 0xE0E0E0);
        }
    }
}

