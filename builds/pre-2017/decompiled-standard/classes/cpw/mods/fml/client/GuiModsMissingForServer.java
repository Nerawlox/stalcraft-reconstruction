/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.ModMissingPacket;
import cpw.mods.fml.common.versioning.ArtifactVersion;

public class GuiModsMissingForServer
extends gqjz {
    private ModMissingPacket modsMissing;

    public GuiModsMissingForServer(ModMissingPacket modMissingPacket) {
        this.modsMissing = modMissingPacket;
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.add(new baxz(1, this.field_73880_f / 2 - 75, this.field_73881_g - 38, wpcz._a("gui.done")));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73742_g && jiok2.field_73741_f == 1) {
            FMLClientHandler.instance().getClient()._a((gqjz)null);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        int n3 = Math.max(85 - this.modsMissing.getModList().size() * 10, 10);
        this.func_73732_a(this.field_73886_k, "Forge Mod Loader could not connect to this server", this.field_73880_f / 2, n3, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, "The mods and versions listed below could not be found", this.field_73880_f / 2, n3 += 10, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, "They are required to play on this server", this.field_73880_f / 2, n3 += 10, 0xFFFFFF);
        n3 += 5;
        for (ArtifactVersion artifactVersion : this.modsMissing.getModList()) {
            this.func_73732_a(this.field_73886_k, String.format("%s : %s", artifactVersion.getLabel(), artifactVersion.getRangeString()), this.field_73880_f / 2, n3 += 10, 0xEEEEEE);
        }
        super.func_73863_a(n, n2, f);
    }
}

