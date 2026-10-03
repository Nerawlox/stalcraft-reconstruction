/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.client.gui.util.GuiNpcButton;
import org.lwjgl.opengl.GL11;

public class GuiMenuSideButton
extends GuiNpcButton {
    public static final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/menusidebutton.png");
    public int field_73746_c;
    public int field_73743_d;
    public String field_73744_e;
    public int field_73741_f;
    public boolean active = false;
    public boolean field_73748_h = true;
    public boolean hover = false;
    protected int field_73747_a = 200;
    protected int field_73745_b = 20;

    public GuiMenuSideButton(int n, int n2, int n3, String string) {
        this(n, n2, n3, 200, 20, string);
    }

    public GuiMenuSideButton(int n, int n2, int n3, int n4, int n5, String string) {
        super(n, n2, n3, n4, n5, string);
        this.field_73741_f = n;
        this.field_73746_c = n2;
        this.field_73743_d = n3;
        this.field_73747_a = n4;
        this.field_73745_b = n5;
        this.field_73744_e = string;
    }

    @Override
    protected int func_73738_a(boolean bl) {
        int n = 1;
        if (this.active) {
            n = 0;
        } else if (bl) {
            n = 1;
        }
        return n;
    }

    @Override
    public void func_73737_a(xpzm xpzm2, int n, int n2) {
        if (this.field_73748_h) {
            qncw qncw2 = xpzm2._z;
            xpzm2._h._a(resource);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            int n3 = this.field_73747_a + (this.active ? 2 : 0);
            this.hover = n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + n3 && n2 < this.field_73743_d + this.field_73745_b;
            int n4 = this.func_73738_a(this.hover);
            this.func_73729_b(this.field_73746_c, this.field_73743_d, 0, n4 * 22, n3, this.field_73745_b);
            this.func_73739_b(xpzm2, n, n2);
            if (this.active) {
                this.func_73732_a(qncw2, this.field_73744_e, this.field_73746_c + n3 / 2, this.field_73743_d + (this.field_73745_b - 8) / 2, 0xFFFFA0);
            } else if (this.hover) {
                this.func_73732_a(qncw2, this.field_73744_e, this.field_73746_c + n3 / 2, this.field_73743_d + (this.field_73745_b - 8) / 2, 0xFFFFA0);
            } else {
                this.func_73732_a(qncw2, this.field_73744_e, this.field_73746_c + n3 / 2, this.field_73743_d + (this.field_73745_b - 8) / 2, 0xE0E0E0);
            }
        }
    }

    @Override
    protected void func_73739_b(xpzm xpzm2, int n, int n2) {
    }

    @Override
    public void func_73740_a(int n, int n2) {
    }

    @Override
    public boolean func_73736_c(xpzm xpzm2, int n, int n2) {
        return !this.active && this.field_73748_h && this.hover;
    }
}

