/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiControlsScrollPanel
extends GuiSlot {
    protected static final ResourceLocation WIDGITS = new ResourceLocation("textures/gui/widgets.png");
    private nuzu controls;
    private GameSettings options;
    private Minecraft mc;
    private String[] message;
    private int _mouseX;
    private int _mouseY;
    private int selected = -1;

    public GuiControlsScrollPanel(nuzu nuzu2, GameSettings gameSettings, Minecraft minecraft) {
        super(minecraft, nuzu2.width, nuzu2.height, 16, nuzu2.height - 32 + 4, 25);
        this.controls = nuzu2;
        this.options = gameSettings;
        this.mc = minecraft;
    }

    @Override
    protected int getSize() {
        return this.options.keyBindings.length;
    }

    @Override
    protected void elementClicked(int n, boolean bl) {
        if (!bl) {
            if (this.selected == -1) {
                this.selected = n;
            } else {
                this.options.setKeyBinding(this.selected, -100);
                this.selected = -1;
                KeyBinding._b();
            }
        }
    }

    @Override
    protected boolean isSelected(int n) {
        return false;
    }

    @Override
    protected void drawBackground() {
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this._mouseX = n;
        this._mouseY = n2;
        if (this.selected != -1 && !Mouse.isButtonDown(0) && Mouse.getDWheel() == 0 && Mouse.next() && Mouse.getEventButtonState()) {
            this.options.setKeyBinding(this.selected, -100 + Mouse.getEventButton());
            this.selected = -1;
            KeyBinding._b();
        }
        super.drawScreen(n, n2, f);
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, Tessellator tessellator) {
        int n5 = 70;
        int n6 = 20;
        boolean bl = this._mouseX >= (n2 -= 20) && this._mouseY >= n3 && this._mouseX < n2 + n5 && this._mouseY < n3 + n6;
        int n7 = bl ? 2 : 1;
        this.mc._h._a(WIDGITS);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.controls.drawTexturedModalRect(n2, n3, 0, 46 + n7 * 20, n5 / 2, n6);
        this.controls.drawTexturedModalRect(n2 + n5 / 2, n3, 200 - n5 / 2, 46 + n7 * 20, n5 / 2, n6);
        this.controls.drawString(this.mc._z, this.options.getKeyBindingDescription(n), n2 + n5 + 4, n3 + 6, -1);
        boolean bl2 = false;
        for (int i = 0; i < this.options.keyBindings.length; ++i) {
            if (i == n || this.options.keyBindings[i]._d != this.options.keyBindings[n]._d) continue;
            bl2 = true;
            break;
        }
        String string = (bl2 ? EnumChatFormatting._m : "") + this.options.getOptionDisplayString(n);
        string = n == this.selected ? (Object)((Object)EnumChatFormatting._p) + "> " + (Object)((Object)EnumChatFormatting._o) + "??? " + (Object)((Object)EnumChatFormatting._p) + "<" : string;
        this.controls.drawCenteredString(this.mc._z, string, n2 + n5 / 2, n3 + (n6 - 8) / 2, -1);
    }

    public boolean keyTyped(char c, int n) {
        if (this.selected != -1) {
            this.options.setKeyBinding(this.selected, n);
            this.selected = -1;
            KeyBinding._b();
            return false;
        }
        return true;
    }
}

