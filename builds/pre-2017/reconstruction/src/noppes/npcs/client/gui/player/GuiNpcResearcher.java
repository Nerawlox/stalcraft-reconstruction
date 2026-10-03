/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import gloomyfolken.mods.core.client.gui.engine.GuiContainerAdvanced;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.misc.srli;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.constants.EnumPlayerPacket;
import noppes.npcs.containers.ContainerNpcResearcher;
import org.lwjgl.opengl.GL11;

public class GuiNpcResearcher
extends GuiContainerAdvanced {
    public static final ResourceLocation texture = new ResourceLocation("customnpcs", "textures/gui/research.png");
    private McButton probeButton;
    private ContainerNpcResearcher researcherContainer;

    public GuiNpcResearcher(ContainerNpcResearcher containerNpcResearcher) {
        super(containerNpcResearcher);
        this.researcherContainer = containerNpcResearcher;
        this.xSize = 175;
        this.ySize = 152;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.probeButton = GuiHelper.addButton(this, this.screenWidth / 2 - 90, this.screenHeight / 2 - 54, 180, 32, "\u0418\u0441\u0441\u043b\u0435\u0434\u043e\u0432\u0430\u0442\u044c").onClick(guiActionButtonClick -> NoppesUtilPlayer.sendData(EnumPlayerPacket.ProbeItem, new Object[0]));
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (this.probeButton != null) {
            ItemStack itemStack = this.researcherContainer.getSelectedStack();
            this.probeButton.setEnabled(itemStack != null && itemStack._a() instanceof srli && !((srli)((Object)itemStack._a()))._a(itemStack));
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glDisable(2896);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft minecraft = Minecraft._E();
        htou htou2 = new htou(minecraft._M, minecraft._n, minecraft._o);
        minecraft._h._a(texture);
        this.drawTexturedModalRect((htou2._a() - this.xSize) / 2, (htou2._b() - this.ySize) / 2, 0, 0, this.xSize, this.ySize);
        super.drawGuiContainerBackgroundLayer(f, n, n2);
    }
}

