/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  awf
 *  bjo
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.clans;

import java.util.List;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.client.clans.GuiClanTab;
import ru.stalcraft.client.clans.GuiTabClanInfo;
import ru.stalcraft.client.clans.GuiTabClanLands;
import ru.stalcraft.client.clans.GuiTabClanMembers;
import ru.stalcraft.client.clans.GuiTabClanRules;
import ru.stalcraft.client.clans.GuiTabClansList;
import ru.stalcraft.client.clans.TabType;

public class GuiClans
extends awe {
    static final bjo buttonsTexture = new bjo("stalker", "textures/clans/buttons.png");
    private GuiClanTab currentTab;
    private awf sr;
    private boolean wasMouseDown = false;
    private int guiScale;

    public GuiClans() {
        this.guiScale = atv.w().u.al;
        atv.w().u.al = 2;
    }

    public List getButtonsList() {
        return this.i;
    }

    @Override
    public void A_() {
        Keyboard.enableRepeatEvents((boolean)true);
        if (this.currentTab == null) {
            this.switchToTab(TabType.INFO);
        } else {
            this.switchToTab(this.currentTab.getTabType());
        }
        this.wasMouseDown = Mouse.isButtonDown((int)0);
    }

    @Override
    public void a(int x2, int y2, float frame) {
        this.b(0);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)2896);
        this.sr = new awf(this.f.u, this.f.d, this.f.e);
        this.handleMouseUp(x2, y2);
        this.handleWheel();
        this.currentTab.drawTabBackground();
        this.drawTabList(x2, y2);
        this.currentTab.drawTabForeground(x2 * 2, y2 * 2);
        super.a(x2, y2, frame);
    }

    private void drawTabList(int x2, int y2) {
        this.f.N.a(buttonsTexture);
        this.drawTexturedModalRect(this.g - 400 + 10 + 138 * this.currentTab.getTabType().ordinal(), this.h - 300 + 34, this.currentTab.getTabType().ordinal() % 3 * 138, this.currentTab.getTabType().ordinal() / 3 * 90 + 60, 138, 30, 512);
        TabType tabMouseOver = this.getTabMouseOver(x2, y2);
        if (tabMouseOver != null && tabMouseOver != this.currentTab.getTabType()) {
            this.drawTexturedModalRect(this.g - 400 + 10 + 138 * tabMouseOver.ordinal(), this.h - 300 + 34, tabMouseOver.ordinal() % 3 * 138, tabMouseOver.ordinal() / 3 * 90 + 30, 138, 30, 512);
        }
    }

    private TabType getTabMouseOver(int x2, int y2) {
        if (y2 >= this.h / 2 - 150 + 17 && y2 <= this.h / 2 - 150 + 31 && x2 >= this.g / 2 - 200 + 4 && x2 <= this.g / 2 - 200 + 348) {
            int position = (x2 - this.g / 2 + 200 - 4) / 69;
            return TabType.values()[position];
        }
        return null;
    }

    @Override
    protected void a(char par1, int par2) {
        super.a(par1, par2);
        this.currentTab.keyTyped(par1, par2);
    }

    @Override
    protected void a(int x2, int y2, int button) {
        TabType tabMouseOver;
        super.a(x2, y2, button);
        if (button == 0 && (tabMouseOver = this.getTabMouseOver(x2, y2)) != null) {
            this.switchToTab(tabMouseOver);
        }
        this.currentTab.mouseClicked(x2 * 2, y2 * 2, button);
    }

    private void switchToTab(TabType tab) {
        if (this.currentTab != null) {
            this.currentTab.onClose();
        }
        switch (NamelessClass1062016702.$SwitchMap$mods$ru$gloomyfolken$stalker$client$clans$TabType[tab.ordinal()]) {
            case 1: {
                this.currentTab = new GuiTabClansList(this);
                break;
            }
            case 2: {
                this.currentTab = new GuiTabClanInfo(this);
                break;
            }
            case 3: {
                this.currentTab = new GuiTabClanLands(this);
                break;
            }
            case 4: {
                this.currentTab = new GuiTabClanMembers(this);
                break;
            }
            case 5: {
                this.currentTab = new GuiTabClanRules(this);
            }
        }
        this.i.clear();
        this.currentTab.switchToTab();
    }

    @Override
    public boolean f() {
        return false;
    }

    public void drawTexturedModalRect(int x2, int y2, int u2, int v2, int i2, int j2, int textureSize) {
        double d2 = 1.0 / (double)textureSize;
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a((double)(x2 + 0) / 2.0, (double)(y2 + j2) / 2.0, this.n, (double)(u2 + 0) * d2, (double)(v2 + j2) * d2);
        tessellator.a((double)(x2 + i2) / 2.0, (double)(y2 + j2) / 2.0, this.n, (double)(u2 + i2) * d2, (double)(v2 + j2) * d2);
        tessellator.a((double)(x2 + i2) / 2.0, (double)(y2 + 0) / 2.0, this.n, (double)(u2 + i2) * d2, (double)(v2 + 0) * d2);
        tessellator.a((double)(x2 + 0) / 2.0, (double)(y2 + 0) / 2.0, this.n, (double)(u2 + 0) * d2, (double)(v2 + 0) * d2);
        tessellator.a();
    }

    @Override
    protected void a(aut btn) {
        this.currentTab.actionPerformed(btn);
    }

    @Override
    protected void b(int x2, int y2, int action) {
        super.b(x2, y2, action);
        if (action == 0) {
            this.currentTab.mouseUp(x2 * 2, y2 * 2);
        }
    }

    private void handleMouseUp(int x2, int y2) {
        if (!Mouse.isButtonDown((int)0) && this.wasMouseDown) {
            this.currentTab.mouseUp(x2 * 2, y2 * 2);
        }
        this.wasMouseDown = Mouse.isButtonDown((int)0);
    }

    @Override
    public void c() {
        this.currentTab.updateScreen();
    }

    private void handleWheel() {
        if (!Mouse.isButtonDown((int)0) && !Mouse.isButtonDown((int)1)) {
            int amountScrolled = 0;
            while (!this.f.u.A && Mouse.next()) {
                int l2 = Mouse.getEventDWheel();
                if (l2 == 0) continue;
                if (l2 > 0) {
                    l2 = -1;
                } else if (l2 < 0) {
                    l2 = 1;
                }
                amountScrolled += l2;
            }
            this.currentTab.handleWheel(amountScrolled);
        }
    }

    @Override
    public void b() {
        atv.w().u.al = this.guiScale;
        Keyboard.enableRepeatEvents((boolean)false);
    }

    static class NamelessClass1062016702 {
        static final int[] $SwitchMap$mods$ru$gloomyfolken$stalker$client$clans$TabType = new int[TabType.values().length];

        NamelessClass1062016702() {
        }

        static {
            try {
                NamelessClass1062016702.$SwitchMap$mods$ru$gloomyfolken$stalker$client$clans$TabType[TabType.CLANS.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1062016702.$SwitchMap$mods$ru$gloomyfolken$stalker$client$clans$TabType[TabType.INFO.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1062016702.$SwitchMap$mods$ru$gloomyfolken$stalker$client$clans$TabType[TabType.LANDS.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1062016702.$SwitchMap$mods$ru$gloomyfolken$stalker$client$clans$TabType[TabType.MEMBERS.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1062016702.$SwitchMap$mods$ru$gloomyfolken$stalker$client$clans$TabType[TabType.RULES.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

