/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.inventory;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiBeacon
extends GuiContainer {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/beacon.png");
    public TileEntityBeacon _b;
    public tfod _c;
    public boolean _d;

    public GuiBeacon(InventoryPlayer inventoryPlayer, TileEntityBeacon tileEntityBeacon) {
        super(new ixdv(inventoryPlayer, tileEntityBeacon));
        this._b = tileEntityBeacon;
        this.xSize = 230;
        this.ySize = 219;
    }

    @Override
    public void initGui() {
        super.initGui();
        this._c = new tfod(this, -1, this.guiLeft + 164, this.guiTop + 107);
        this.buttonList.add(this._c);
        this.buttonList.add(new htob(this, -2, this.guiLeft + 190, this.guiTop + 107));
        this._d = true;
        this._c.enabled = false;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (this._d && this._b._f() >= 0) {
            hclx hclx2;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            this._d = false;
            for (n5 = 0; n5 <= 2; ++n5) {
                n4 = TileEntityBeacon._a[n5].length;
                n3 = n4 * 22 + (n4 - 1) * 2;
                for (n2 = 0; n2 < n4; ++n2) {
                    n = TileEntityBeacon._a[n5][n2]._H;
                    hclx2 = new hclx(this, n5 << 8 | n, this.guiLeft + 76 + n2 * 24 - n3 / 2, this.guiTop + 22 + n5 * 25, n, n5);
                    this.buttonList.add(hclx2);
                    if (n5 >= this._b._f()) {
                        hclx2.enabled = false;
                        continue;
                    }
                    if (n != this._b._d()) continue;
                    hclx2._a(true);
                }
            }
            n5 = 3;
            n4 = TileEntityBeacon._a[n5].length + 1;
            n3 = n4 * 22 + (n4 - 1) * 2;
            for (n2 = 0; n2 < n4 - 1; ++n2) {
                n = TileEntityBeacon._a[n5][n2]._H;
                hclx2 = new hclx(this, n5 << 8 | n, this.guiLeft + 167 + n2 * 24 - n3 / 2, this.guiTop + 47, n, n5);
                this.buttonList.add(hclx2);
                if (n5 >= this._b._f()) {
                    hclx2.enabled = false;
                    continue;
                }
                if (n != this._b._e()) continue;
                hclx2._a(true);
            }
            if (this._b._d() > 0) {
                hclx hclx3 = new hclx(this, n5 << 8 | this._b._d(), this.guiLeft + 167 + (n4 - 1) * 24 - n3 / 2, this.guiTop + 47, this._b._d(), n5);
                this.buttonList.add(hclx3);
                if (n5 >= this._b._f()) {
                    hclx3.enabled = false;
                } else if (this._b._d() == this._b._e()) {
                    hclx3._a(true);
                }
            }
        }
        this._c.enabled = this._b.getStackInSlot(0) != null && this._b._d() > 0;
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == -2) {
            this.mc._a((GuiScreen)null);
        } else if (guiButton.id == -1) {
            String string = "MC|Beacon";
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(this._b._d());
                dataOutputStream.writeInt(this._b._e());
                this.mc._z()._b(new Packet250CustomPayload(string, byteArrayOutputStream.toByteArray()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            this.mc._a((GuiScreen)null);
        } else if (guiButton instanceof hclx) {
            if (((hclx)guiButton)._a()) {
                return;
            }
            int n = guiButton.id;
            int n2 = n & 0xFF;
            int n3 = n >> 8;
            if (n3 < 3) {
                this._b._b(n2);
            } else {
                this._b._c(n2);
            }
            this.buttonList.clear();
            this.initGui();
            this.updateScreen();
        }
    }

    @Override
    public void drawGuiContainerForegroundLayer(int n, int n2) {
        qnon._a();
        this.drawCenteredString(this.fontRenderer, wpcz._a("tile.beacon.primary"), 62, 10, 0xE0E0E0);
        this.drawCenteredString(this.fontRenderer, wpcz._a("tile.beacon.secondary"), 169, 10, 0xE0E0E0);
        for (GuiButton guiButton : this.buttonList) {
            if (!guiButton.func_82252_a()) continue;
            guiButton.func_82251_b(n - this.guiLeft, n2 - this.guiTop);
            break;
        }
        qnon._c();
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(_a);
        int n3 = (this.width - this.xSize) / 2;
        int n4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
        GuiBeacon.itemRenderer.zLevel = 100.0f;
        itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc._R(), new ItemStack(Item.emerald), n3 + 42, n4 + 109);
        itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc._R(), new ItemStack(Item.diamond), n3 + 42 + 22, n4 + 109);
        itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc._R(), new ItemStack(Item.ingotGold), n3 + 42 + 44, n4 + 109);
        itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc._R(), new ItemStack(Item.ingotIron), n3 + 42 + 66, n4 + 109);
        GuiBeacon.itemRenderer.zLevel = 0.0f;
    }

    public static /* synthetic */ ResourceLocation _a() {
        return _a;
    }
}

