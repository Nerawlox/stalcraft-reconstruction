/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  bjo
 */
package ru.stalcraft.client.clans;

import ru.stalcraft.client.clans.GuiClans;
import ru.stalcraft.client.clans.TabType;

public abstract class GuiClanTab {
    protected final GuiClans parent;
    protected static bjo texture;
    private avi fontRenderer;

    public GuiClanTab(GuiClans parent) {
        this.parent = parent;
        this.fontRenderer = atv.w().l;
    }

    abstract void actionPerformed(aut var1);

    abstract void drawTabForeground(int var1, int var2);

    abstract void switchToTab();

    abstract TabType getTabType();

    void drawTabBackground() {
        atv.w().N.a(texture);
        this.parent.drawTexturedModalRect(this.parent.g - 400, this.parent.h - 300, 0, 0, 800, 600, 1024);
    }

    void updateScreen() {
    }

    void keyTyped(char par1, int par2) {
    }

    void mouseClicked(int x2, int y2, int button) {
    }

    void onClose() {
    }

    void mouseUp(int x2, int y2) {
    }

    void handleWheel(int wheel) {
    }

    protected void drawString(String str, int x2, int y2, int color) {
        this.fontRenderer.b(str, x2, y2, color);
    }
}

