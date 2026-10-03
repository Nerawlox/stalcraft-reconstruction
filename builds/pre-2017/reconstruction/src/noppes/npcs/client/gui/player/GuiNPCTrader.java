/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import gloomyfolken.mods.money.zwat;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface;
import noppes.npcs.containers.ContainerNPCTrader;
import noppes.npcs.roles.RoleTrader;
import org.lwjgl.opengl.GL11;

public class GuiNPCTrader
extends GuiContainerNPCInterface {
    private final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/npctrader.png");
    private RoleTrader role;

    public GuiNPCTrader(EntityNPCInterface entityNPCInterface, ContainerNPCTrader containerNPCTrader) {
        super(entityNPCInterface, containerNPCTrader);
        this.role = (RoleTrader)entityNPCInterface.roleInterface;
        this.closeOnEsc = true;
        this.ySize = 232;
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(this.resource);
        int n3 = (this.width - this.xSize) / 2;
        int n4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
        this.drawCenteredString(this.fontRenderer, "\u0421\u0447\u0435\u0442: " + zwat._a(this.player)._b(), this.guiLeft + 127, this.guiTop + 4, 0xFFFFFF);
        Slot slot = this.getTheSlot(n, n2);
        if (slot != null && slot.getHasStack()) {
            if (slot.slotNumber < 63) {
                int n5 = this.role.sellPrices[slot.slotNumber];
                String string = "\u0426\u0435\u043d\u0430 \u043f\u043e\u043a\u0443\u043f\u043a\u0438: " + n5 + "\u0440\u0443\u0431.";
                this.drawCenteredString(this.fontRenderer, string, this.guiLeft + 48, this.guiTop + 4, (long)n5 > zwat._a(this.player)._a() ? 0xAA1111 : 0xFFFFFF);
            } else {
                int n6 = this.role.getBuyPrice(slot.getStack());
                if (n6 > 0) {
                    String string = "\u0426\u0435\u043d\u0430 \u043f\u0440\u043e\u0434\u0430\u0436\u0438: " + n6 + "\u0440\u0443\u0431.";
                    this.drawCenteredString(this.fontRenderer, string, this.guiLeft + 48, this.guiTop + 4, 0xFFFFFF);
                }
            }
        }
        this.drawCenteredString(this.fontRenderer, "\u0427\u0442\u043e\u0431\u044b \u043f\u0440\u043e\u0434\u0430\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442, \u043a\u043b\u0438\u043a\u043d\u0438\u0442\u0435 \u043f\u043e \u043d\u0435\u043c\u0443 \u041f\u041a\u041c", this.width / 2, this.guiTop - 12, 0xFFFFFF);
    }

    private Slot getTheSlot(int n, int n2) {
        for (int i = 0; i < this.inventorySlots.inventorySlots.size(); ++i) {
            Slot slot = (Slot)this.inventorySlots.inventorySlots.get(i);
            if (!this.isPointInRegion(slot.xDisplayPosition, slot.yDisplayPosition, 16, 16, n, n2) || !slot.func_111238_b()) continue;
            return slot;
        }
        return null;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
    }

    @Override
    public void save() {
    }
}

