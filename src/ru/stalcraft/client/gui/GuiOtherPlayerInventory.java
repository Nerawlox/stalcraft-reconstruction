/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.inventory.ICustomContainer;

@SideOnly(value=Side.CLIENT)
public class GuiOtherPlayerInventory
extends axp {
    private float xSize_lo;
    private float ySize_lo;
    public ICustomContainer customContainer;
    private static final int X_INV_SIZE = 227;
    private static final int Y_INV_SIZE = 181;
    public static final bjo commonInventory = new bjo("stalker", "textures/inventory.png");
    public static final bjo backpackInventory = new bjo("stalker", "textures/backpack.png");

    public GuiOtherPlayerInventory(uy container, ICustomContainer customContainer) {
        super(container);
        this.j = true;
        this.customContainer = customContainer;
    }

    @Override
    public void c() {
    }

    @Override
    public void A_() {
        this.i.clear();
        this.c = 227;
        this.d = 181;
        this.p = this.g / 2 - this.c / 2;
        this.q = this.h / 2 - this.d / 2;
    }

    @Override
    public void a(int par1, int par2, float par3) {
        super.a(par1, par2, par3);
        this.xSize_lo = par1;
        this.ySize_lo = par2;
    }

    @Override
    protected void a(float par1, int par2, int par3) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)2896);
        if (this.customContainer.hasBackpack()) {
            atv.w().N.a(backpackInventory);
        } else {
            atv.w().N.a(commonInventory);
        }
        this.b(this.g / 2 - 113, this.h / 2 - 90, 0, 0, 227, 181);
    }

    @Override
    protected void b(int par1, int par2) {
    }

    @Override
    protected void a(aut par1GuiButton) {
        if (par1GuiButton.g == 0) {
            this.f.a(new awq(this.f.y));
        }
        if (par1GuiButton.g == 1) {
            this.f.a(new awr(this, this.f.y));
        }
    }
}

