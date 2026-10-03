/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  avw
 *  awh
 *  bjo
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.gui;

import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.client.gui.GuiMainMenuButton;

public class GuiStalkerMenu
extends blt {
    private static bjo background = new bjo("stalker", "textures/background.png");
    private static bjo buttonTexture1 = new bjo("stalker", "textures/menu_buttons1.png");
    private static bjo buttonTexture2 = new bjo("stalker", "textures/menu_buttons2.png");
    private static bjo buttonTexture3 = new bjo("stalker", "textures/menu_buttons3.png");
    private static bjo buttonTexture4 = new bjo("stalker", "textures/menu_buttons4.png");
    private List customButtons = new ArrayList();

    @Override
    public void A_() {
        super.A_();
        this.f.u.al = 2;
        this.i.clear();
        this.customButtons.clear();
        this.customButtons.add(new GuiMainMenuButton(0, this, this.g - 20 - 197, 25, 197, 69, 0, 0, buttonTexture1, buttonTexture3));
        this.customButtons.add(new GuiMainMenuButton(1, this, this.g - 20 - 156, 119, 156, 69, 0, 128, buttonTexture1, buttonTexture3));
        this.customButtons.add(new GuiMainMenuButton(2, this, this.g - 20 - 71, 213, 71, 69, 0, 0, buttonTexture2, buttonTexture4));
        this.customButtons.add(new GuiMainMenuButton(3, this, this.g - 20 - 94, 307, 94, 69, 0, 128, buttonTexture2, buttonTexture4));
    }

    @Override
    public void a(int par1, int par2, float par3) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.f.N.a(background);
        bfq tessellator = bfq.a;
        tessellator.b();
        double minX = 0.0;
        double minY = 0.0;
        double maxX = 1.0;
        double maxY = 1.0;
        double screenRatio = (double)this.g / (double)this.h;
        double textureRatio = 1.7777777777777777;
        if (screenRatio > textureRatio) {
            minY = (1.0 - textureRatio / screenRatio) / 2.0;
            maxY = 1.0 - (1.0 - textureRatio / screenRatio) / 2.0;
        } else if (textureRatio > screenRatio) {
            minX = (1.0 - screenRatio / textureRatio) / 2.0;
            maxX = 1.0 - (1.0 - screenRatio / textureRatio) / 2.0;
        }
        tessellator.a(0.0, this.h, this.n, minX, maxY);
        tessellator.a(this.g, this.h, this.n, maxX, maxY);
        tessellator.a(this.g, 0.0, this.n, maxX, minY);
        tessellator.a(0.0, 0.0, this.n, minX, minY);
        tessellator.a();
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        for (GuiMainMenuButton button : this.customButtons) {
            button.drawButton(par1, par2);
        }
        GL11.glDisable((int)3042);
    }

    @Override
    public void a(char par1, int par2) {
        super.a(par1, par2);
    }

    @Override
    public void a(int x2, int y2, int buttonId) {
        for (GuiMainMenuButton button : this.customButtons) {
            button.mouseClick(x2, y2, buttonId);
        }
    }

    public void buttonClick(GuiMainMenuButton button) {
        if (button.id == 0) {
            this.f.a((awe)new awh((awe)this));
        } else if (button.id == 1) {
            this.f.a((awe)new avw((awe)this, this.f.u));
        } else if (button.id != 2 && button.id == 3) {
            this.f.f();
        }
    }
}

