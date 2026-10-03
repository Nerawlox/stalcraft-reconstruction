/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.eidj;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiControlsScrollPanel
extends wovy {
    protected static final ResourceLocation WIDGITS = new ResourceLocation("textures/gui/widgets.png");
    private nuzu controls;
    private GameSettings options;
    private xpzm field_77233_a;
    private String[] message;
    private int _mouseX;
    private int _mouseY;
    private int selected = -1;

    public GuiControlsScrollPanel(nuzu nuzu2, GameSettings gameSettings, xpzm xpzm2) {
        super(xpzm2, nuzu2.field_73880_f, nuzu2.field_73881_g, 16, nuzu2.field_73881_g - 32 + 4, 25);
        this.controls = nuzu2;
        this.options = gameSettings;
        this.field_77233_a = xpzm2;
    }

    @Override
    protected int func_77217_a() {
        return this.options.field_74324_K.length;
    }

    @Override
    protected void func_77213_a(int n, boolean bl) {
        if (!bl) {
            if (this.selected == -1) {
                this.selected = n;
            } else {
                this.options.func_74307_a(this.selected, -100);
                this.selected = -1;
                eidj._b();
            }
        }
    }

    @Override
    protected boolean func_77218_a(int n) {
        return false;
    }

    @Override
    protected void func_77221_c() {
    }

    @Override
    public void func_77211_a(int n, int n2, float f) {
        this._mouseX = n;
        this._mouseY = n2;
        if (this.selected != -1 && !Mouse.isButtonDown(0) && Mouse.getDWheel() == 0 && Mouse.next() && Mouse.getEventButtonState()) {
            this.options.func_74307_a(this.selected, -100 + Mouse.getEventButton());
            this.selected = -1;
            eidj._b();
        }
        super.func_77211_a(n, n2, f);
    }

    @Override
    protected void func_77214_a(int n, int n2, int n3, int n4, htvf htvf2) {
        int n5 = 70;
        int n6 = 20;
        boolean bl = this._mouseX >= (n2 -= 20) && this._mouseY >= n3 && this._mouseX < n2 + n5 && this._mouseY < n3 + n6;
        int n7 = bl ? 2 : 1;
        this.field_77233_a._h._a(WIDGITS);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.controls.func_73729_b(n2, n3, 0, 46 + n7 * 20, n5 / 2, n6);
        this.controls.func_73729_b(n2 + n5 / 2, n3, 200 - n5 / 2, 46 + n7 * 20, n5 / 2, n6);
        this.controls.func_73731_b(this.field_77233_a._z, this.options.func_74302_a(n), n2 + n5 + 4, n3 + 6, -1);
        boolean bl2 = false;
        for (int i = 0; i < this.options.field_74324_K.length; ++i) {
            if (i == n || this.options.field_74324_K[i]._d != this.options.field_74324_K[n]._d) continue;
            bl2 = true;
            break;
        }
        String string = (bl2 ? ezfc._m : "") + this.options.func_74301_b(n);
        string = n == this.selected ? (Object)((Object)ezfc._p) + "> " + (Object)((Object)ezfc._o) + "??? " + (Object)((Object)ezfc._p) + "<" : string;
        this.controls.func_73732_a(this.field_77233_a._z, string, n2 + n5 / 2, n3 + (n6 - 8) / 2, -1);
    }

    public boolean keyTyped(char c, int n) {
        if (this.selected != -1) {
            this.options.func_74307_a(this.selected, n);
            this.selected = -1;
            eidj._b();
            return false;
        }
        return true;
    }
}

