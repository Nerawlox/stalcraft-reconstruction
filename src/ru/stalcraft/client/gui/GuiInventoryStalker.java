/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.gui;

import org.lwjgl.opengl.GL11;
import ru.stalcraft.inventory.ICustomContainer;
import ru.stalcraft.inventory.StalkerContainer;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;

public class GuiInventoryStalker
extends awy {
    public StalkerContainer container;
    public ICustomContainer customContainer;
    private static final int X_INV_SIZE = 227;
    private static final int Y_INV_SIZE = 181;
    public static final bjo commonInventory = new bjo("stalker", "textures/inventory.png");
    public static final bjo backpackInventory = new bjo("stalker", "textures/backpack.png");

    public GuiInventoryStalker(uf player) {
        super(PlayerUtils.getInfo((uf)player).inventoryContainer);
        PlayerInfo par2 = PlayerUtils.getInfo(player);
        this.container = par2.inventoryContainer;
        this.customContainer = par2.inventoryContainer;
    }

    @Override
    public void A_() {
        super.A_();
        this.i.clear();
        this.c = 227;
        this.d = 181;
        this.p = this.g / 2 - this.c / 2;
        this.q = this.h / 2 - this.d / 2;
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
    public void c() {
    }

    @Override
    protected void b(int par1, int par2) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)2896);
        this.b(atv.w().l, "\u0412\u0435\u0441: " + (int)this.container.info.getWeight() + "/" + (int)this.container.info.getMaxWeight() + " \u043a\u0433", 126, 159, 0xFFFFFF);
    }
}

