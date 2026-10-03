/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.faction.pidb;
import gloomyfolken.mods.stalker.misc.tupg;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class nuis
extends cebg {
    public jzak _a;
    public static final int _b = 227;
    public static final int _c = 181;
    public static final ResourceLocation _d = new ResourceLocation("stalker", "textures/gui/inventory.png");
    protected EntityPlayer _e;

    public nuis(EntityPlayer entityPlayer) {
        super(entityPlayer);
        this._e = entityPlayer;
        this._a = (jzak)entityPlayer.inventoryContainer;
    }

    public Slot _a(int n, int n2) {
        for (int i = 0; i < this._a.inventorySlots.size(); ++i) {
            Slot slot = (Slot)this._a.inventorySlots.get(i);
            if (!this.isMouseOverSlot(slot, n, n2) || !slot.func_111238_b()) continue;
            return slot;
        }
        return null;
    }

    @Override
    protected boolean isMouseOverSlot(Slot slot, int n, int n2) {
        return this.isPointInRegion(slot.xDisplayPosition, slot.yDisplayPosition, 16, 16, n, n2);
    }

    public void _a(ItemStack itemStack, int n, int n2) {
        List list2 = itemStack._a((EntityPlayer)this.mc._t, this.mc._M.advancedItemTooltips);
        for (int i = 0; i < list2.size(); ++i) {
            if (i == 0) {
                list2.set(i, "\u00a7" + Integer.toHexString(itemStack._w()._e) + (String)list2.get(i));
                continue;
            }
            list2.set(i, (Object)((Object)EnumChatFormatting._h) + (String)list2.get(i));
        }
        FontRenderer fontRenderer = itemStack._a().getFontRenderer(itemStack);
        this.drawHoveringText(list2, n, n2, fontRenderer == null ? this.fontRenderer : fontRenderer);
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.xSize = 227;
        this.ySize = 181;
        this.guiLeft = this.width / 2 - this.xSize / 2;
        this.guiTop = this.height / 2 - this.ySize / 2;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        int n3;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        Minecraft._E()._h._a(_d);
        this.drawTexturedModalRect(this.width / 2 - 113, this.height / 2 - 90, 0, 0, 227, 181);
        for (int i = n3 = this._a.getArtefaktSlots(); i < 5; ++i) {
            this.drawTexturedModalRect(this.width / 2 - 113 + 7 + i * 18, this.height / 2 - 90 + 107, 228, 154, 18, 18);
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        tupg tupg2 = tupg._a(this._e);
        String string = pidb._a((EntityPlayer)this._e)._a()._e;
        this.drawString(this.mc._z, "\u0412\u0435\u0441: " + (int)tupg2._i() + "/" + (int)tupg2._j() + " \u043a\u0433", 126, 159, 0xFFFFFF);
        this.drawCenteredString(this.mc._z, string + " " + this.mc._t.getDisplayName(), 113, -28, 0xFFFFFF);
    }
}

