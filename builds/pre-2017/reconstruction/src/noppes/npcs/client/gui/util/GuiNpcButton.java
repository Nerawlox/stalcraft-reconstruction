/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.tdpx;

public class GuiNpcButton
extends GuiButton {
    public boolean shown = true;
    private String[] display;
    private int displayValue = 0;

    public GuiNpcButton(int n, int n2, int n3, String string) {
        super(n, n2, n3, tdpx._a(string));
    }

    public GuiNpcButton(int n, int n2, int n3, String[] stringArray, int n4) {
        super(n, n2, n3, stringArray[n4]);
        this.display = stringArray;
        this.displayValue = n4;
    }

    public GuiNpcButton(int n, int n2, int n3, int n4, int n5, String string) {
        super(n, n2, n3, n4, n5, tdpx._a(string));
    }

    public GuiNpcButton(int n, int n2, int n3, int n4, int n5, String[] stringArray, int n6) {
        this(n, n2, n3, n4, n5, stringArray[n6 % stringArray.length]);
        this.display = stringArray;
        this.displayValue = n6 % stringArray.length;
    }

    public void setDisplayText(String string) {
        this.displayString = tdpx._a(string);
    }

    public int getValue() {
        return this.displayValue;
    }

    @Override
    public void drawButton(Minecraft minecraft, int n, int n2) {
        if (this.shown) {
            super.drawButton(minecraft, n, n2);
        }
    }

    @Override
    public boolean mousePressed(Minecraft minecraft, int n, int n2) {
        boolean bl = super.mousePressed(minecraft, n, n2);
        if (bl && this.display != null) {
            this.displayValue = (this.displayValue + 1) % this.display.length;
            this.displayString = tdpx._a(this.display[this.displayValue]);
        }
        return bl;
    }

    public void setDisplay(int n) {
        this.displayValue = n;
        this.displayString = tdpx._a(this.display[n]);
    }
}

