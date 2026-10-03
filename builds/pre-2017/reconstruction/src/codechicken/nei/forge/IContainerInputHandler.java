/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.forge;

import net.minecraft.client.gui.inventory.GuiContainer;

public interface IContainerInputHandler {
    public boolean keyTyped(GuiContainer var1, char var2, int var3);

    public void onKeyTyped(GuiContainer var1, char var2, int var3);

    public boolean lastKeyTyped(GuiContainer var1, char var2, int var3);

    public boolean mouseClicked(GuiContainer var1, int var2, int var3, int var4);

    public void onMouseClicked(GuiContainer var1, int var2, int var3, int var4);

    public void onMouseUp(GuiContainer var1, int var2, int var3, int var4);

    public boolean mouseScrolled(GuiContainer var1, int var2, int var3, int var4);

    public void onMouseScrolled(GuiContainer var1, int var2, int var3, int var4);

    public void onMouseDragged(GuiContainer var1, int var2, int var3, int var4, long var5);
}

