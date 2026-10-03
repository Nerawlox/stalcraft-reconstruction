/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface;
import noppes.npcs.containers.ContainerCarpentryBench;
import org.lwjgl.opengl.GL11;

public class GuiNpcCarpentryBench
extends GuiContainerNPCInterface {
    private final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/anvil.png");
    private ContainerCarpentryBench container;

    public GuiNpcCarpentryBench(ContainerCarpentryBench containerCarpentryBench) {
        super(null, containerCarpentryBench);
        this.container = containerCarpentryBench;
        this.title = "";
        this.allowUserInput = false;
        this.closeOnEsc = true;
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        super.actionPerformed(guiButton);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(this.resource);
        int n3 = (this.width - this.xSize) / 2;
        int n4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
        super.drawGuiContainerBackgroundLayer(f, n, n2);
    }

    @Override
    public void save() {
    }
}

