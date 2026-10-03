/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.IMerchant;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.containers.ContainerMerchantAdd;
import noppes.npcs.events.ItemInteractEvent;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class GuiMerchantAdd
extends GuiContainer {
    private static final ResourceLocation merchantGuiTextures = new ResourceLocation("textures/gui/container/villager.png");
    private IMerchant theIMerchant = ItemInteractEvent.Merchant;
    private pkae nextRecipeButtonIndex;
    private pkae previousRecipeButtonIndex;
    private int currentRecipeIndex;
    private String field_94082_v = wpcz._a("entity.Villager.name");

    public GuiMerchantAdd() {
        super(new ContainerMerchantAdd(Minecraft._E()._t.inventory, ItemInteractEvent.Merchant, Minecraft._E()._r));
    }

    static ResourceLocation func_110417_h() {
        return merchantGuiTextures;
    }

    @Override
    public void initGui() {
        super.initGui();
        int n = (this.width - this.xSize) / 2;
        int n2 = (this.height - this.ySize) / 2;
        this.nextRecipeButtonIndex = new pkae(1, n + 120 + 27, n2 + 24 - 1, true);
        this.buttonList.add(this.nextRecipeButtonIndex);
        this.previousRecipeButtonIndex = new pkae(2, n + 36 - 19, n2 + 24 - 1, false);
        this.buttonList.add(this.previousRecipeButtonIndex);
        this.buttonList.add(new GuiNpcButton(4, n + this.xSize, n2 + 20, 60, 20, "gui.remove"));
        this.buttonList.add(new GuiNpcButton(5, n + this.xSize, n2 + 50, 60, 20, "gui.add"));
        this.nextRecipeButtonIndex.enabled = false;
        this.previousRecipeButtonIndex.enabled = false;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
        this.fontRenderer._b(this.field_94082_v, this.xSize / 2 - this.fontRenderer._b(this.field_94082_v) / 2, 6, 0x404040);
        this.fontRenderer._b(wpcz._a("container.inventory"), 8, this.ySize - 96 + 2, 0x404040);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        MerchantRecipeList merchantRecipeList = this.theIMerchant.getRecipes(this.mc._t);
        if (merchantRecipeList != null) {
            this.nextRecipeButtonIndex.enabled = this.currentRecipeIndex < merchantRecipeList.size() - 1;
            this.previousRecipeButtonIndex.enabled = this.currentRecipeIndex > 0;
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        Object object;
        Object object2;
        boolean bl = false;
        if (guiButton == this.nextRecipeButtonIndex) {
            ++this.currentRecipeIndex;
            bl = true;
        } else if (guiButton == this.previousRecipeButtonIndex) {
            --this.currentRecipeIndex;
            bl = true;
        }
        if (guiButton.id == 4 && this.currentRecipeIndex < ((ArrayList)(object2 = this.theIMerchant.getRecipes(this.mc._t))).size()) {
            ((ArrayList)object2).remove(this.currentRecipeIndex);
            if (this.currentRecipeIndex > 0) {
                --this.currentRecipeIndex;
            }
            NoppesUtil.sendData(EnumPacketType.MerchantUpdate, ItemInteractEvent.Merchant.entityId, object2);
        }
        if (guiButton.id == 5) {
            object2 = this.inventorySlots.getSlot(0).getStack();
            object = this.inventorySlots.getSlot(1).getStack();
            ItemStack itemStack = this.inventorySlots.getSlot(2).getStack();
            if (object2 == null && object != null) {
                object2 = object;
                object = null;
            }
            if (object2 != null && itemStack != null) {
                object2 = ((ItemStack)object2)._l();
                itemStack = itemStack._l();
                if (object != null) {
                    object = ((ItemStack)object)._l();
                }
                MerchantRecipe merchantRecipe = new MerchantRecipe((ItemStack)object2, (ItemStack)object, itemStack);
                merchantRecipe._a(0x7FFFFFF7);
                MerchantRecipeList merchantRecipeList = this.theIMerchant.getRecipes(this.mc._t);
                merchantRecipeList.add(merchantRecipe);
                NoppesUtil.sendData(EnumPacketType.MerchantUpdate, ItemInteractEvent.Merchant.entityId, merchantRecipeList);
            }
        }
        if (bl) {
            ((ContainerMerchantAdd)this.inventorySlots).setCurrentRecipeIndex(this.currentRecipeIndex);
            object2 = new ByteArrayOutputStream();
            object = new DataOutputStream((OutputStream)object2);
            try {
                ((DataOutputStream)object).writeInt(this.currentRecipeIndex);
                this.mc._z()._b(new Packet250CustomPayload("MC|TrSel", ((ByteArrayOutputStream)object2).toByteArray()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        int n3;
        MerchantRecipe merchantRecipe;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(merchantGuiTextures);
        int n4 = (this.width - this.xSize) / 2;
        int n5 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n4, n5, 0, 0, this.xSize, this.ySize);
        MerchantRecipeList merchantRecipeList = this.theIMerchant.getRecipes(this.mc._t);
        if (merchantRecipeList != null && !merchantRecipeList.isEmpty() && (merchantRecipe = (MerchantRecipe)merchantRecipeList.get(n3 = this.currentRecipeIndex))._f()) {
            this.mc._R()._a(merchantGuiTextures);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(2896);
            this.drawTexturedModalRect(this.guiLeft + 83, this.guiTop + 21, 212, 0, 28, 21);
            this.drawTexturedModalRect(this.guiLeft + 83, this.guiTop + 51, 212, 0, 28, 21);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        MerchantRecipeList merchantRecipeList = this.theIMerchant.getRecipes(this.mc._t);
        if (merchantRecipeList != null && !merchantRecipeList.isEmpty()) {
            int n3 = (this.width - this.xSize) / 2;
            int n4 = (this.height - this.ySize) / 2;
            int n5 = this.currentRecipeIndex;
            MerchantRecipe merchantRecipe = (MerchantRecipe)merchantRecipeList.get(n5);
            GL11.glPushMatrix();
            ItemStack itemStack = merchantRecipe._a();
            ItemStack itemStack2 = merchantRecipe._b();
            ItemStack itemStack3 = merchantRecipe._d();
            qnon._c();
            GL11.glDisable(2896);
            GL11.glEnable(32826);
            GL11.glEnable(2903);
            GL11.glEnable(2896);
            GuiContainer.itemRenderer.zLevel = 100.0f;
            GuiContainer.itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc._R(), itemStack, n3 + 36, n4 + 24);
            GuiContainer.itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc._R(), itemStack, n3 + 36, n4 + 24);
            if (itemStack2 != null) {
                GuiContainer.itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc._R(), itemStack2, n3 + 62, n4 + 24);
                GuiContainer.itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc._R(), itemStack2, n3 + 62, n4 + 24);
            }
            GuiContainer.itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc._R(), itemStack3, n3 + 120, n4 + 24);
            GuiContainer.itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc._R(), itemStack3, n3 + 120, n4 + 24);
            GuiContainer.itemRenderer.zLevel = 0.0f;
            GL11.glDisable(2896);
            if (this.isPointInRegion(36, 24, 16, 16, n, n2)) {
                this.drawItemStackTooltip(itemStack, n, n2);
            } else if (itemStack2 != null && this.isPointInRegion(62, 24, 16, 16, n, n2)) {
                this.drawItemStackTooltip(itemStack2, n, n2);
            } else if (this.isPointInRegion(120, 24, 16, 16, n, n2)) {
                this.drawItemStackTooltip(itemStack3, n, n2);
            }
            GL11.glPopMatrix();
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            qnon._b();
        }
    }

    public IMerchant getIMerchant() {
        return this.theIMerchant;
    }
}

