/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import cpw.mods.fml.client.CustomModLoadingErrorDisplayException;
import net.minecraft.client.gui.GuiErrorScreen;

public class GuiCustomModLoadingErrorScreen
extends GuiErrorScreen {
    private CustomModLoadingErrorDisplayException customException;

    public GuiCustomModLoadingErrorScreen(CustomModLoadingErrorDisplayException customModLoadingErrorDisplayException) {
        super(null, null);
        this.customException = customModLoadingErrorDisplayException;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.customException.initGui(this, this.fontRenderer);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.customException.drawScreen(this, this.fontRenderer, n, n2, f);
    }
}

