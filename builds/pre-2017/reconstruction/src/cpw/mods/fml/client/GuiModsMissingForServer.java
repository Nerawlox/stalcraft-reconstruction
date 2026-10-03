/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.ModMissingPacket;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiModsMissingForServer
extends GuiScreen {
    private ModMissingPacket modsMissing;

    public GuiModsMissingForServer(ModMissingPacket modMissingPacket) {
        this.modsMissing = modMissingPacket;
    }

    @Override
    public void initGui() {
        this.buttonList.add(new baxz(1, this.width / 2 - 75, this.height - 38, wpcz._a("gui.done")));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.enabled && guiButton.id == 1) {
            FMLClientHandler.instance().getClient()._a((GuiScreen)null);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        int n3 = Math.max(85 - this.modsMissing.getModList().size() * 10, 10);
        this.drawCenteredString(this.fontRenderer, "Forge Mod Loader could not connect to this server", this.width / 2, n3, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "The mods and versions listed below could not be found", this.width / 2, n3 += 10, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "They are required to play on this server", this.width / 2, n3 += 10, 0xFFFFFF);
        n3 += 5;
        for (ArtifactVersion artifactVersion : this.modsMissing.getModList()) {
            this.drawCenteredString(this.fontRenderer, String.format("%s : %s", artifactVersion.getLabel(), artifactVersion.getRangeString()), this.width / 2, n3 += 10, 0xEEEEEE);
        }
        super.drawScreen(n, n2, f);
    }
}

