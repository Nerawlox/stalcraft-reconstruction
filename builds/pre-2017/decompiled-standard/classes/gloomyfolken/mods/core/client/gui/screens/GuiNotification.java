/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public abstract class GuiNotification
extends gqjz {
    public static final ResourceLocation texture = new ResourceLocation("gloomycore", "textures/gui/yesno.png");
    protected boolean answered;
    protected String line1;
    protected String line2;

    public GuiNotification(String string, String string2) {
        this.line1 = string;
        this.line2 = string2;
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 76, this.field_73881_g / 2 + 40, 74, 20, "\u041e\u041a"));
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 + 2, this.field_73881_g / 2 + 40, 74, 20, "\u041e\u0442\u043c\u0435\u043d\u0430"));
    }

    @Override
    protected void func_73869_a(char c, int n) {
        super.func_73869_a(c, n);
        if (n == 28) {
            this.success();
            this.answered = true;
            this.field_73882_e._a((gqjz)null);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73859_b(0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        xpzm._E()._h._a(texture);
        this.func_73729_b(this.field_73880_f / 2 - 95, this.field_73881_g / 2 - 25, 0, 0, 190, 110);
        this.func_73732_a(this.field_73886_k, this.line1, this.field_73880_f / 2, this.field_73881_g / 2 - 2, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, this.line2, this.field_73880_f / 2, this.field_73881_g / 2 + 10, 0xFFFFFF);
        super.func_73863_a(n, n2, f);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            this.success();
        } else if (jiok2.field_73741_f == 1) {
            this.fail();
        }
        this.answered = true;
        xpzm._E()._a((gqjz)null);
    }

    @Override
    public void func_73874_b() {
        if (!this.answered) {
            this.fail();
        }
    }

    public abstract void fail();

    public abstract void success();
}

