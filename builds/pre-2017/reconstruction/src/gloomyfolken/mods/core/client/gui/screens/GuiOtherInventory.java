/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.tdpx;
import org.lwjgl.opengl.GL11;

@ezey(_a={eidj.CLIENT})
public class GuiOtherInventory
extends InventoryEffectRenderer {
    private float xSize_lo;
    private float ySize_lo;
    private EntityLivingBase entity;

    public GuiOtherInventory(zwyn zwyn2) {
        super(zwyn2);
        this.entity = zwyn2.owner;
        this.allowUserInput = true;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        super.initGui();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
        this.fontRenderer._b(tdpx._a("container.crafting"), 86, 16, 0x404040);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        this.xSize_lo = n;
        this.ySize_lo = n2;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(GuiContainer.field_110408_a);
        int n3 = this.guiLeft;
        int n4 = this.guiTop;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
        cebg._a(n3 + 51, n4 + 75, 30, (float)(n3 + 51) - this.xSize_lo, (float)(n4 + 75 - 50) - this.ySize_lo, this.entity);
    }
}

