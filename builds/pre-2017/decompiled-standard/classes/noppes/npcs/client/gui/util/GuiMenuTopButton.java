/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.tdpx;
import noppes.npcs.client.gui.util.IButtonListener;
import org.lwjgl.opengl.GL11;

public class GuiMenuTopButton
extends jiok {
    public static final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/menutopbutton.png");
    public boolean active = false;
    public boolean hover = false;
    public boolean rotated = false;
    public IButtonListener listener;
    protected int field_73745_b;

    public GuiMenuTopButton(int n, int n2, int n3, String string) {
        super(n, n2, n3, tdpx._a(string));
        this.field_73747_a = xpzm._E()._z._b(this.field_73744_e) + 12;
        this.field_73745_b = 20;
    }

    public GuiMenuTopButton(int n, GuiMenuTopButton guiMenuTopButton, String string) {
        this(n, guiMenuTopButton.field_73746_c + guiMenuTopButton.field_73747_a, guiMenuTopButton.field_73743_d, string);
    }

    public GuiMenuTopButton(int n, GuiMenuTopButton guiMenuTopButton, String string, IButtonListener iButtonListener) {
        this(n, guiMenuTopButton, string);
        this.listener = iButtonListener;
    }

    @Override
    protected int func_73738_a(boolean bl) {
        int n = 1;
        if (this.active) {
            n = 0;
        } else if (bl) {
            n = 2;
        }
        return n;
    }

    @Override
    public void func_73737_a(xpzm xpzm2, int n, int n2) {
        if (this.field_73748_h) {
            GL11.glPushMatrix();
            xpzm2._h._a(resource);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            int n3 = this.field_73745_b - (this.active ? 0 : 2);
            this.hover = n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + this.field_73747_a && n2 < this.field_73743_d + n3;
            int n4 = this.func_73738_a(this.hover);
            this.func_73729_b(this.field_73746_c, this.field_73743_d, 0, n4 * 20, this.field_73747_a / 2, n3);
            this.func_73729_b(this.field_73746_c + this.field_73747_a / 2, this.field_73743_d, 200 - this.field_73747_a / 2, n4 * 20, this.field_73747_a / 2, n3);
            this.func_73739_b(xpzm2, n, n2);
            qncw qncw2 = xpzm2._z;
            if (this.rotated) {
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            }
            if (this.active) {
                this.func_73732_a(qncw2, this.field_73744_e, this.field_73746_c + this.field_73747_a / 2, this.field_73743_d + (n3 - 8) / 2, 0xFFFFA0);
            } else if (this.hover) {
                this.func_73732_a(qncw2, this.field_73744_e, this.field_73746_c + this.field_73747_a / 2, this.field_73743_d + (n3 - 8) / 2, 0xFFFFA0);
            } else {
                this.func_73732_a(qncw2, this.field_73744_e, this.field_73746_c + this.field_73747_a / 2, this.field_73743_d + (n3 - 8) / 2, 0xE0E0E0);
            }
            GL11.glPopMatrix();
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
        boolean bl;
        boolean bl2 = bl = !this.active && this.field_73748_h && this.hover;
        if (bl && this.listener != null) {
            this.listener.actionPerformed(this);
            return false;
        }
        return bl;
    }

    public int getWidth() {
        return this.field_73747_a;
    }
}

