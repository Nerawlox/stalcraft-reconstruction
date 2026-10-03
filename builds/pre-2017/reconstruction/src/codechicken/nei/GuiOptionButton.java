/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import net.minecraft.client.Minecraft;

public class GuiOptionButton
extends baxz {
    public GuiOptionButton(int n, int n2, int n3, String string) {
        super(n, n2, n3, string);
    }

    @Override
    public boolean mousePressed(Minecraft minecraft, int n, int n2) {
        return this.drawButton && n >= this.xPosition && n2 >= this.yPosition && n < this.xPosition + this.width && n2 < this.yPosition + this.height;
    }
}

