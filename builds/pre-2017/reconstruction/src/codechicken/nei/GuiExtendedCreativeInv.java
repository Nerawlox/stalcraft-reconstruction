/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.VisiblityData;
import codechicken.nei.api.INEIGuiHandler;
import codechicken.nei.api.TaggedInventoryArea;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiExtendedCreativeInv
extends GuiContainer
implements INEIGuiHandler {
    public GuiExtendedCreativeInv(Container container) {
        super(container);
        this.ySize = 198;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(new ResourceLocation("nei:textures/gui/inv.png"));
        int n3 = this.guiLeft;
        int n4 = this.guiTop - 4;
        this.drawTexturedModalRect(n3 - 23, n4, 0, 0, 199, 204);
    }

    @Override
    public VisiblityData modifyVisiblity(GuiContainer guiContainer, VisiblityData visiblityData) {
        return visiblityData;
    }

    @Override
    public int getItemSpawnSlot(GuiContainer guiContainer, ItemStack itemStack) {
        return NEIServerUtils.getSlotForStack(guiContainer.inventorySlots, 0, 54, itemStack);
    }

    @Override
    public List<TaggedInventoryArea> getInventoryAreas(GuiContainer guiContainer) {
        return Arrays.asList(new TaggedInventoryArea("ExtendedCreativeInv", 0, 54, this.inventorySlots));
    }

    @Override
    public boolean handleDragNDrop(GuiContainer guiContainer, int n, int n2, ItemStack itemStack, int n3) {
        return false;
    }

    @Override
    public boolean hideItemPanelSlot(GuiContainer guiContainer, int n, int n2, int n3, int n4) {
        return false;
    }
}

