/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.money;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class ezey
extends GuiButton {
    public ezey(int n, int n2, String string) {
        super(123, n, n2, 0, 0, string);
    }

    @Override
    public void drawButton(Minecraft minecraft, int n, int n2) {
        if (this.drawButton) {
            minecraft._z._a(this.displayString, this.xPosition, this.yPosition, 0xFFFFFF);
        }
    }

    @Override
    public boolean mousePressed(Minecraft minecraft, int n, int n2) {
        return false;
    }
}

