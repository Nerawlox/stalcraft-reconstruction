/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEICPH;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.forge.IContainerInputHandler;
import net.minecraft.client.gui.inventory.GuiContainer;

public class PopupInputHandler
implements IContainerInputHandler {
    @Override
    public boolean keyTyped(GuiContainer guiContainer, char c, int n) {
        return false;
    }

    @Override
    public boolean mouseClicked(GuiContainer guiContainer, int n, int n2, int n3) {
        return false;
    }

    @Override
    public void onKeyTyped(GuiContainer guiContainer, char c, int n) {
    }

    @Override
    public boolean lastKeyTyped(GuiContainer guiContainer, char c, int n) {
        if (n == NEIClientConfig.getKeyBinding("gui.enchant") && NEIClientConfig.canPerformAction("enchant")) {
            NEICPH.sendOpenEnchantmentWindow();
            return true;
        }
        if (n == NEIClientConfig.getKeyBinding("gui.potion") && NEIClientConfig.canPerformAction("potion")) {
            NEICPH.sendOpenPotionWindow();
            return true;
        }
        return false;
    }

    @Override
    public void onMouseClicked(GuiContainer guiContainer, int n, int n2, int n3) {
    }

    @Override
    public void onMouseUp(GuiContainer guiContainer, int n, int n2, int n3) {
    }

    @Override
    public boolean mouseScrolled(GuiContainer guiContainer, int n, int n2, int n3) {
        return false;
    }

    @Override
    public void onMouseScrolled(GuiContainer guiContainer, int n, int n2, int n3) {
    }

    @Override
    public void onMouseDragged(GuiContainer guiContainer, int n, int n2, int n3, long l) {
    }
}

