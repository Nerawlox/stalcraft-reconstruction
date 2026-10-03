/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.WrongMinecraftVersionException;
import net.minecraft.client.gui.GuiErrorScreen;

public class GuiWrongMinecraft
extends GuiErrorScreen {
    private WrongMinecraftVersionException wrongMC;

    public GuiWrongMinecraft(WrongMinecraftVersionException wrongMinecraftVersionException) {
        super(null, null);
        this.wrongMC = wrongMinecraftVersionException;
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        int n3 = 75;
        this.drawCenteredString(this.fontRenderer, "Forge Mod Loader has found a problem with your minecraft installation", this.width / 2, n3, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, String.format("The mod listed below does not want to run in Minecraft version %s", Loader.instance().getMinecraftModContainer().getVersion()), this.width / 2, n3 += 10, 0xFFFFFF);
        n3 += 5;
        this.drawCenteredString(this.fontRenderer, String.format("%s (%s) wants Minecraft %s", this.wrongMC.mod.getName(), this.wrongMC.mod.getModId(), this.wrongMC.mod.acceptableMinecraftVersionRange()), this.width / 2, n3 += 10, 0xEEEEEE);
        this.drawCenteredString(this.fontRenderer, "The file 'ForgeModLoader-client-0.log' contains more information", this.width / 2, n3 += 20, 0xFFFFFF);
    }
}

