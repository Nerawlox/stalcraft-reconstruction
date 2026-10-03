/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.WrongMinecraftVersionException;

public class GuiWrongMinecraft
extends hchw {
    private WrongMinecraftVersionException wrongMC;

    public GuiWrongMinecraft(WrongMinecraftVersionException wrongMinecraftVersionException) {
        super(null, null);
        this.wrongMC = wrongMinecraftVersionException;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        int n3 = 75;
        this.func_73732_a(this.field_73886_k, "Forge Mod Loader has found a problem with your minecraft installation", this.field_73880_f / 2, n3, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, String.format("The mod listed below does not want to run in Minecraft version %s", Loader.instance().getMinecraftModContainer().getVersion()), this.field_73880_f / 2, n3 += 10, 0xFFFFFF);
        n3 += 5;
        this.func_73732_a(this.field_73886_k, String.format("%s (%s) wants Minecraft %s", this.wrongMC.mod.getName(), this.wrongMC.mod.getModId(), this.wrongMC.mod.acceptableMinecraftVersionRange()), this.field_73880_f / 2, n3 += 10, 0xEEEEEE);
        this.func_73732_a(this.field_73886_k, "The file 'ForgeModLoader-client-0.log' contains more information", this.field_73880_f / 2, n3 += 20, 0xFFFFFF);
    }
}

