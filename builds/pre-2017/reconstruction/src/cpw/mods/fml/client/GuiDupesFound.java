/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import cpw.mods.fml.common.DuplicateModsFoundException;
import cpw.mods.fml.common.ModContainer;
import java.io.File;
import java.util.Map;
import net.minecraft.client.gui.GuiErrorScreen;

public class GuiDupesFound
extends GuiErrorScreen {
    private DuplicateModsFoundException dupes;

    public GuiDupesFound(DuplicateModsFoundException duplicateModsFoundException) {
        super(null, null);
        this.dupes = duplicateModsFoundException;
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        int n3 = Math.max(85 - this.dupes.dupes.size() * 10, 10);
        this.drawCenteredString(this.fontRenderer, "Forge Mod Loader has found a problem with your minecraft installation", this.width / 2, n3, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "You have mod sources that are duplicate within your system", this.width / 2, n3 += 10, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "Mod Id : File name", this.width / 2, n3 += 10, 0xFFFFFF);
        n3 += 5;
        for (Map.Entry<ModContainer, File> entry : this.dupes.dupes.entries()) {
            this.drawCenteredString(this.fontRenderer, String.format("%s : %s", entry.getKey().getModId(), entry.getValue().getName()), this.width / 2, n3 += 10, 0xEEEEEE);
        }
    }
}

