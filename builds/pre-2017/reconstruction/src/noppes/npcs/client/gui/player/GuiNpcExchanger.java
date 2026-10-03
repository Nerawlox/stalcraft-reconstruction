/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface;
import noppes.npcs.containers.ContainerNpcExchanger;
import noppes.npcs.roles.RoleExchanger;
import org.lwjgl.opengl.GL11;

public class GuiNpcExchanger
extends GuiContainerNPCInterface {
    private final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/npcexchanger.png");
    private RoleExchanger exchanger;
    private ContainerNpcExchanger container;

    public GuiNpcExchanger(EntityNPCInterface entityNPCInterface, ContainerNpcExchanger containerNpcExchanger) {
        super(entityNPCInterface, containerNpcExchanger);
        this.exchanger = (RoleExchanger)entityNPCInterface.roleInterface;
        this.container = containerNpcExchanger;
        this.closeOnEsc = true;
        this.ySize = 232;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        this.drawWorldBackground(0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(this.resource);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        GL11.glEnable(32826);
        for (int i = 0; i < 18; ++i) {
            ItemStack itemStack = this.exchanger.invCurrency.items.get(i);
            ItemStack itemStack2 = this.exchanger.invSold.items.get(i);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            if (itemStack == null || itemStack2 == null) continue;
            qnon._c();
            int n3 = this.guiLeft + i % 3 * 45 + 10;
            int n4 = this.guiTop + i / 3 * 22 + 8;
            GuiContainer.itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc._h, itemStack, n3, n4);
            GuiContainer.itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc._h, itemStack, n3, n4);
            qnon._a();
            this.fontRenderer._b("=", n3 + 18, n4 + 4, 0x939393);
        }
        GL11.glDisable(32826);
        super.drawGuiContainerBackgroundLayer(f, n, n2);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        for (int n3 : this.exchanger.invCurrency.items.keySet()) {
            ItemStack itemStack = this.exchanger.invCurrency.items.get(n3);
            if (itemStack == null || this.exchanger.invSold.items.get(n3) == null) continue;
            int n4 = this.guiLeft + n3 % 3 * 45 + 10;
            int n5 = this.guiTop + n3 / 3 * 22 + 8;
            if (n <= n4 || n >= n4 + 16 || n2 <= n5 || n2 >= n5 + 16) continue;
            this.drawItemStackTooltip(itemStack, n, n2);
        }
    }

    @Override
    public void save() {
    }
}

