/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import cpw.mods.fml.common.MissingModsException;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
import net.minecraft.client.gui.GuiErrorScreen;

public class GuiModsMissing
extends GuiErrorScreen {
    private MissingModsException modsMissing;

    public GuiModsMissing(MissingModsException missingModsException) {
        super(null, null);
        this.modsMissing = missingModsException;
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        int n3 = Math.max(85 - this.modsMissing.missingMods.size() * 10, 10);
        this.drawCenteredString(this.fontRenderer, "Forge Mod Loader has found a problem with your minecraft installation", this.width / 2, n3, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "The mods and versions listed below could not be found", this.width / 2, n3 += 10, 0xFFFFFF);
        n3 += 5;
        for (ArtifactVersion artifactVersion : this.modsMissing.missingMods) {
            DefaultArtifactVersion defaultArtifactVersion;
            n3 += 10;
            if (artifactVersion instanceof DefaultArtifactVersion && (defaultArtifactVersion = (DefaultArtifactVersion)artifactVersion).getRange() != null && defaultArtifactVersion.getRange().isUnboundedAbove()) {
                this.drawCenteredString(this.fontRenderer, String.format("%s : minimum version required is %s", artifactVersion.getLabel(), defaultArtifactVersion.getRange().getLowerBoundString()), this.width / 2, n3, 0xEEEEEE);
                continue;
            }
            this.drawCenteredString(this.fontRenderer, String.format("%s : %s", artifactVersion.getLabel(), artifactVersion.getRangeString()), this.width / 2, n3, 0xEEEEEE);
        }
        this.drawCenteredString(this.fontRenderer, "The file 'ForgeModLoader-client-0.log' contains more information", this.width / 2, n3 += 20, 0xFFFFFF);
    }
}

