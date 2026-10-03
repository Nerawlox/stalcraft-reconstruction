/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.tdpx;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumPlayerPacket;
import noppes.npcs.containers.ContainerNPCBankInterface;
import org.lwjgl.opengl.GL11;

public class GuiNPCBankChest
extends GuiContainerNPCInterface
implements IGuiData {
    private final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/bankchest.png");
    private ContainerNPCBankInterface container;
    private int availableSlots = 0;
    private int maxSlots = 1;
    private int unlockedSlots = 1;
    private ItemStack currency;

    public GuiNPCBankChest(EntityNPCInterface entityNPCInterface, ContainerNPCBankInterface containerNPCBankInterface) {
        super(entityNPCInterface, containerNPCBankInterface);
        this.container = containerNPCBankInterface;
        this.title = "";
        this.allowUserInput = false;
        this.ySize = 235;
        this.closeOnEsc = true;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.availableSlots = 0;
        if (this.maxSlots > 1) {
            for (int i = 0; i < this.maxSlots; ++i) {
                GuiNpcButton guiNpcButton = new GuiNpcButton(i, this.guiLeft - 60, this.guiTop + 10 + i * 24, 60, 20, "\u041f\u043e\u043b\u043a\u0430 #" + (i + 1));
                if (i > this.unlockedSlots) {
                    guiNpcButton.enabled = false;
                }
                this.addButton(guiNpcButton);
                ++this.availableSlots;
            }
            if (this.availableSlots == 1) {
                this.buttonList.clear();
            }
        }
        if (!this.container.isAvailable()) {
            this.addButton(new GuiNpcButton(8, this.guiLeft + 48, this.guiTop + 48, 80, 20, tdpx._a("bank.unlock")));
        } else if (this.container.canBeUpgraded()) {
            this.addButton(new GuiNpcButton(9, this.guiLeft + 48, this.guiTop + 48, 80, 20, tdpx._a("bank.upgrade")));
        }
        if (this.maxSlots > 1) {
            this.getButton((int)this.container.slot).enabled = false;
        }
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        super.actionPerformed(guiButton);
        if (guiButton.id < 6) {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.BankSlotOpen, guiButton.id, this.container.bankid);
        }
        if (guiButton.id == 8) {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.BankUnlock, new Object[0]);
        }
        if (guiButton.id == 9) {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.BankUpgrade, new Object[0]);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        int n3;
        int n4;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(this.resource);
        int n5 = (this.width - this.xSize) / 2;
        int n6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n5, n6, 0, 0, this.xSize, 6);
        if (!this.container.isAvailable()) {
            this.drawTexturedModalRect(n5, n6 + 6, 0, 6, this.xSize, 64);
            this.drawTexturedModalRect(n5, n6 + 70, 0, 124, this.xSize, 98);
            n4 = this.guiLeft + 30;
            n3 = this.guiTop + 8;
            this.fontRenderer._b(tdpx._a("bank.unlockCosts") + ":", n4, n3 + 4, 0x404040);
            this.drawItem(n4 + 90, n3, this.currency, n, n2);
        } else if (this.container.isUpgraded()) {
            this.drawTexturedModalRect(n5, n6 + 60, 0, 60, this.xSize, 162);
            this.drawTexturedModalRect(n5, n6 + 6, 0, 60, this.xSize, 64);
        } else if (this.container.canBeUpgraded()) {
            this.drawTexturedModalRect(n5, n6 + 6, 0, 6, this.xSize, 216);
            n4 = this.guiLeft + 30;
            n3 = this.guiTop + 8;
            this.fontRenderer._b(tdpx._a("bank.upgradeCosts") + ":", n4, n3 + 4, 0x404040);
            this.drawItem(n4 + 90, n3, this.currency, n, n2);
        } else {
            this.drawTexturedModalRect(n5, n6 + 6, 0, 60, this.xSize, 162);
        }
        if (this.maxSlots > 1) {
            for (n4 = 0; n4 < this.maxSlots && this.availableSlots != n4; ++n4) {
                this.fontRenderer._b("\u041f\u043e\u043b\u043a\u0430 #" + (n4 + 1), this.guiLeft - 40, this.guiTop + 16 + n4 * 24, 0xFFFFFF);
            }
        }
        super.drawGuiContainerBackgroundLayer(f, n, n2);
    }

    private void drawItem(int n, int n2, ItemStack itemStack, int n3, int n4) {
        if (itemStack != null) {
            GL11.glEnable(32826);
            qnon._c();
            GuiContainer.itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc._h, itemStack, n, n2);
            GuiContainer.itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc._h, itemStack, n, n2);
            qnon._a();
            GL11.glDisable(32826);
            if (this.isPointInRegion(n - this.guiLeft, n2 - this.guiTop, 16, 16, n3, n4)) {
                this.drawItemStackTooltip(itemStack, n3, n4);
            }
        }
    }

    @Override
    public void save() {
    }

    @Override
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        this.maxSlots = nBTTagCompound._f("MaxSlots");
        this.unlockedSlots = nBTTagCompound._f("UnlockedSlots");
        this.currency = nBTTagCompound._c("Currency") ? ItemStack._a(nBTTagCompound._m("Currency")) : null;
        if (this.container.currency != null) {
            this.container.currency.item = this.currency;
        }
        this.initGui();
    }
}

