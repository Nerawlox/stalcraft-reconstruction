/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiRepair
extends GuiContainer
implements ICrafting {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/anvil.png");
    public ContainerRepair _b;
    public GuiTextField _c;
    public InventoryPlayer _d;

    public GuiRepair(InventoryPlayer inventoryPlayer, World world, int n, int n2, int n3) {
        super(new ContainerRepair(inventoryPlayer, world, n, n2, n3, Minecraft._E()._t));
        this._d = inventoryPlayer;
        this._b = (ContainerRepair)this.inventorySlots;
    }

    @Override
    public void initGui() {
        super.initGui();
        Keyboard.enableRepeatEvents(true);
        int n = (this.width - this.xSize) / 2;
        int n2 = (this.height - this.ySize) / 2;
        this._c = new GuiTextField(this.fontRenderer, n + 62, n2 + 24, 103, 12);
        this._c.setTextColor(-1);
        this._c.setDisabledTextColour(-1);
        this._c.setEnableBackgroundDrawing(false);
        this._c.setMaxStringLength(40);
        this.inventorySlots.removeCraftingFromCrafters(this);
        this.inventorySlots.func_75132_a(this);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
        this.inventorySlots.removeCraftingFromCrafters(this);
    }

    @Override
    public void drawGuiContainerForegroundLayer(int n, int n2) {
        GL11.glDisable(2896);
        this.fontRenderer._b(wpcz._a("container.repair"), 60, 6, 0x404040);
        if (this._b._g > 0) {
            int n3 = 8453920;
            boolean bl = true;
            String string = wpcz._a("container.repair.cost", this._b._g);
            if (this._b._g >= 40 && !this.mc._t.capabilities._d) {
                string = wpcz._a("container.repair.expensive");
                n3 = 0xFF6060;
            } else if (!this._b.getSlot(2).getHasStack()) {
                bl = false;
            } else if (!this._b.getSlot(2).canTakeStack(this._d._e)) {
                n3 = 0xFF6060;
            }
            if (bl) {
                int n4 = 0xFF000000 | (n3 & 0xFCFCFC) >> 2 | n3 & 0xFF000000;
                int n5 = this.xSize - 8 - this.fontRenderer._b(string);
                int n6 = 67;
                if (this.fontRenderer._d()) {
                    GuiRepair.drawRect(n5 - 3, n6 - 2, this.xSize - 7, n6 + 10, -16777216);
                    GuiRepair.drawRect(n5 - 2, n6 - 1, this.xSize - 8, n6 + 9, -12895429);
                } else {
                    this.fontRenderer._b(string, n5, n6 + 1, n4);
                    this.fontRenderer._b(string, n5 + 1, n6, n4);
                    this.fontRenderer._b(string, n5 + 1, n6 + 1, n4);
                }
                this.fontRenderer._b(string, n5, n6, n3);
            }
        }
        GL11.glEnable(2896);
    }

    @Override
    public void keyTyped(char c, int n) {
        if (this._c.textboxKeyTyped(c, n)) {
            this._a();
        } else {
            super.keyTyped(c, n);
        }
    }

    public void _a() {
        String string = this._c.getText();
        Slot slot = this._b.getSlot(0);
        if (slot != null && slot.getHasStack() && !slot.getStack()._u() && string.equals(slot.getStack()._s())) {
            string = "";
        }
        this._b._a(string);
        this.mc._t.sendQueue._b(new Packet250CustomPayload("MC|ItemName", string.getBytes()));
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this._c.mouseClicked(n, n2, n3);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        GL11.glDisable(2896);
        this._c.drawTextBox();
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(_a);
        int n3 = (this.width - this.xSize) / 2;
        int n4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
        this.drawTexturedModalRect(n3 + 59, n4 + 20, 0, this.ySize + (this._b.getSlot(0).getHasStack() ? 0 : 16), 110, 16);
        if ((this._b.getSlot(0).getHasStack() || this._b.getSlot(1).getHasStack()) && !this._b.getSlot(2).getHasStack()) {
            this.drawTexturedModalRect(n3 + 99, n4 + 45, this.xSize, 0, 28, 21);
        }
    }

    @Override
    public void func_71110_a(Container container, List list) {
        this.sendSlotContents(container, 0, container.getSlot(0).getStack());
    }

    @Override
    public void sendSlotContents(Container container, int n, ItemStack itemStack) {
        if (n == 0) {
            this._c.setText(itemStack == null ? "" : itemStack._s());
            this._c.setEnabled(itemStack != null);
            if (itemStack != null) {
                this._a();
            }
        }
    }

    @Override
    public void sendProgressBarUpdate(Container container, int n, int n2) {
    }
}

