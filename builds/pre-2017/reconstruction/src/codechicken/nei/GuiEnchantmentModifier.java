/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.ContainerEnchantmentModifier;
import codechicken.nei.GuiNEIButton;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GuiEnchantmentModifier
extends GuiContainer {
    ContainerEnchantmentModifier container;

    public GuiEnchantmentModifier(InventoryPlayer inventoryPlayer, World world, int n, int n2, int n3) {
        super(new ContainerEnchantmentModifier(inventoryPlayer, world, n, n2, n3));
        this.container = (ContainerEnchantmentModifier)this.inventorySlots;
        this.container.parentscreen = this;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
        this.fontRenderer._b(NEIClientUtils.translate("enchant", new Object[0]), 12, 6, 0x404040);
        this.fontRenderer._b(NEIClientUtils.translate("enchant.level", new Object[0]), 19, 20, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(new ResourceLocation("textures/gui/container/enchanting_table.png"));
        GL11.glTranslatef(this.guiLeft, this.guiTop, 0.0f);
        this.drawTexturedModalRect(0, 0, 0, 0, this.xSize, this.ySize);
        this.container.onUpdate(n, n2);
        this.container.drawSlots(this);
        this.container.drawScrollBar(this);
        String string = "" + this.container.level;
        this.fontRenderer._b(string, 33 - this.fontRenderer._b(string) / 2, 34, -10461088);
        GL11.glTranslatef(-this.guiLeft, -this.guiTop, 0.0f);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(new GuiNEIButton(0, this.width / 2 - 78, this.height / 2 - 52, 12, 12, "<"));
        this.buttonList.add(new GuiNEIButton(1, this.width / 2 - 44, this.height / 2 - 52, 12, 12, ">"));
        this.buttonList.add(new GuiNEIButton(2, this.width / 2 - 80, this.height / 2 - 15, 50, 12, this.lockDisplayString()));
    }

    private String lockDisplayString() {
        return GuiEnchantmentModifier.validateEnchantments() ? NEIClientUtils.translate("enchant.locked", new Object[0]) : NEIClientUtils.translate("enchant.unlocked", new Object[0]);
    }

    public static boolean validateEnchantments() {
        return NEIClientConfig.world.nbt._o("validateenchantments");
    }

    public static void toggleEnchantmentValidation() {
        NEIClientConfig.world.nbt._a("validateenchantments", !GuiEnchantmentModifier.validateEnchantments());
        NEIClientConfig.world.saveNBT();
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            this.changeLevel(-1);
        } else if (guiButton.id == 1) {
            this.changeLevel(1);
        } else if (guiButton.id == 2) {
            GuiEnchantmentModifier.toggleEnchantmentValidation();
            this.container.updateEnchantmentOptions(GuiEnchantmentModifier.validateEnchantments());
            guiButton.displayString = this.lockDisplayString();
        }
    }

    private void changeLevel(int n) {
        this.container.level += n;
        ((GuiButton)this.buttonList.get((int)0)).enabled = this.container.level != 1;
        ((GuiButton)this.buttonList.get((int)1)).enabled = this.container.level != 10;
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        if (this.container.clickButton(n, n2, n3)) {
            return;
        }
        if (this.container.clickScrollBar(n, n2, n3)) {
            return;
        }
        super.mouseClicked(n, n2, n3);
    }

    @Override
    protected void mouseMovedOrUp(int n, int n2, int n3) {
        this.container.mouseUp(n, n2, n3);
        super.mouseMovedOrUp(n, n2, n3);
    }
}

