/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class xayk
extends GuiContainer {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/villager.png");
    public IMerchant _b;
    public pkae _c;
    public pkae _d;
    public int _e;
    public String _f;

    public xayk(InventoryPlayer inventoryPlayer, IMerchant iMerchant, World world, String string) {
        super(new ContainerMerchant(inventoryPlayer, iMerchant, world));
        this._b = iMerchant;
        this._f = string == null || string.length() < 1 ? wpcz._a("entity.Villager.name") : string;
    }

    @Override
    public void initGui() {
        super.initGui();
        int n = (this.width - this.xSize) / 2;
        int n2 = (this.height - this.ySize) / 2;
        this._c = new pkae(1, n + 120 + 27, n2 + 24 - 1, true);
        this.buttonList.add(this._c);
        this._d = new pkae(2, n + 36 - 19, n2 + 24 - 1, false);
        this.buttonList.add(this._d);
        this._c.enabled = false;
        this._d.enabled = false;
    }

    @Override
    public void drawGuiContainerForegroundLayer(int n, int n2) {
        this.fontRenderer._b(this._f, this.xSize / 2 - this.fontRenderer._b(this._f) / 2, 6, 0x404040);
        this.fontRenderer._b(wpcz._a("container.inventory"), 8, this.ySize - 96 + 2, 0x404040);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        MerchantRecipeList merchantRecipeList = this._b.getRecipes(this.mc._t);
        if (merchantRecipeList != null) {
            this._c.enabled = this._e < merchantRecipeList.size() - 1;
            this._d.enabled = this._e > 0;
        }
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        boolean bl = false;
        if (guiButton == this._c) {
            ++this._e;
            bl = true;
        } else if (guiButton == this._d) {
            --this._e;
            bl = true;
        }
        if (bl) {
            ((ContainerMerchant)this.inventorySlots)._a(this._e);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(this._e);
                this.mc._z()._b(new Packet250CustomPayload("MC|TrSel", byteArrayOutputStream.toByteArray()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        int n3;
        MerchantRecipe merchantRecipe;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(_a);
        int n4 = (this.width - this.xSize) / 2;
        int n5 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n4, n5, 0, 0, this.xSize, this.ySize);
        MerchantRecipeList merchantRecipeList = this._b.getRecipes(this.mc._t);
        if (merchantRecipeList != null && !merchantRecipeList.isEmpty() && (merchantRecipe = (MerchantRecipe)merchantRecipeList.get(n3 = this._e))._f()) {
            this.mc._R()._a(_a);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(2896);
            this.drawTexturedModalRect(this.guiLeft + 83, this.guiTop + 21, 212, 0, 28, 21);
            this.drawTexturedModalRect(this.guiLeft + 83, this.guiTop + 51, 212, 0, 28, 21);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        MerchantRecipeList merchantRecipeList = this._b.getRecipes(this.mc._t);
        if (merchantRecipeList != null && !merchantRecipeList.isEmpty()) {
            int n3 = (this.width - this.xSize) / 2;
            int n4 = (this.height - this.ySize) / 2;
            int n5 = this._e;
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
            xayk.itemRenderer.zLevel = 100.0f;
            itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc._R(), itemStack, n3 + 36, n4 + 24);
            itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc._R(), itemStack, n3 + 36, n4 + 24);
            if (itemStack2 != null) {
                itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc._R(), itemStack2, n3 + 62, n4 + 24);
                itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc._R(), itemStack2, n3 + 62, n4 + 24);
            }
            itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc._R(), itemStack3, n3 + 120, n4 + 24);
            itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc._R(), itemStack3, n3 + 120, n4 + 24);
            xayk.itemRenderer.zLevel = 0.0f;
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

    public IMerchant _a() {
        return this._b;
    }

    public static /* synthetic */ ResourceLocation _b() {
        return _a;
    }
}

