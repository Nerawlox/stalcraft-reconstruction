/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GuiCrafting
extends GuiContainer {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/crafting_table.png");

    public GuiCrafting(InventoryPlayer inventoryPlayer, World world, int n, int n2, int n3) {
        super(new ContainerWorkbench(inventoryPlayer, world, n, n2, n3));
    }

    @Override
    public void drawGuiContainerForegroundLayer(int n, int n2) {
        this.fontRenderer._b(wpcz._a("container.crafting"), 28, 6, 0x404040);
        this.fontRenderer._b(wpcz._a("container.inventory"), 8, this.ySize - 96 + 2, 0x404040);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(_a);
        int n3 = (this.width - this.xSize) / 2;
        int n4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
    }
}

