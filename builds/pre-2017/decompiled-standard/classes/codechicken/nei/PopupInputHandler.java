/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEICPH;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.forge.IContainerInputHandler;

public class PopupInputHandler
implements IContainerInputHandler {
    @Override
    public boolean keyTyped(zybc zybc2, char c, int n) {
        return false;
    }

    @Override
    public boolean mouseClicked(zybc zybc2, int n, int n2, int n3) {
        return false;
    }

    @Override
    public void onKeyTyped(zybc zybc2, char c, int n) {
    }

    @Override
    public boolean lastKeyTyped(zybc zybc2, char c, int n) {
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
    public void onMouseClicked(zybc zybc2, int n, int n2, int n3) {
    }

    @Override
    public void onMouseUp(zybc zybc2, int n, int n2, int n3) {
    }

    @Override
    public boolean mouseScrolled(zybc zybc2, int n, int n2, int n3) {
        return false;
    }

    @Override
    public void onMouseScrolled(zybc zybc2, int n, int n2, int n3) {
    }

    @Override
    public void onMouseDragged(zybc zybc2, int n, int n2, int n3, long l) {
    }
}

