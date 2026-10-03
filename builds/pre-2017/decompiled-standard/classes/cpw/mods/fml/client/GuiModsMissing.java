/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import cpw.mods.fml.common.MissingModsException;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.DefaultArtifactVersion;

public class GuiModsMissing
extends hchw {
    private MissingModsException modsMissing;

    public GuiModsMissing(MissingModsException missingModsException) {
        super(null, null);
        this.modsMissing = missingModsException;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        int n3 = Math.max(85 - this.modsMissing.missingMods.size() * 10, 10);
        this.func_73732_a(this.field_73886_k, "Forge Mod Loader has found a problem with your minecraft installation", this.field_73880_f / 2, n3, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, "The mods and versions listed below could not be found", this.field_73880_f / 2, n3 += 10, 0xFFFFFF);
        n3 += 5;
        for (ArtifactVersion artifactVersion : this.modsMissing.missingMods) {
            DefaultArtifactVersion defaultArtifactVersion;
            n3 += 10;
            if (artifactVersion instanceof DefaultArtifactVersion && (defaultArtifactVersion = (DefaultArtifactVersion)artifactVersion).getRange() != null && defaultArtifactVersion.getRange().isUnboundedAbove()) {
                this.func_73732_a(this.field_73886_k, String.format("%s : minimum version required is %s", artifactVersion.getLabel(), defaultArtifactVersion.getRange().getLowerBoundString()), this.field_73880_f / 2, n3, 0xEEEEEE);
                continue;
            }
            this.func_73732_a(this.field_73886_k, String.format("%s : %s", artifactVersion.getLabel(), artifactVersion.getRangeString()), this.field_73880_f / 2, n3, 0xEEEEEE);
        }
        this.func_73732_a(this.field_73886_k, "The file 'ForgeModLoader-client-0.log' contains more information", this.field_73880_f / 2, n3 += 20, 0xFFFFFF);
    }
}

