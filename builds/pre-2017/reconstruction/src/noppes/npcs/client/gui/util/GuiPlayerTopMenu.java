/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.player.GuiFaction;
import noppes.npcs.client.gui.player.GuiQuestLog;
import noppes.npcs.client.gui.util.GuiMenuTopButton;
import noppes.npcs.client.gui.util.ITopButtonListener;

public class GuiPlayerTopMenu
extends GuiScreen
implements ITopButtonListener {
    private int x;
    private int y;
    private int active;
    private EntityPlayer player;
    private HashMap topButtons = new HashMap();

    public GuiPlayerTopMenu(int n, int n2, int n3, EntityPlayer entityPlayer) {
        this.player = entityPlayer;
        this.x = n;
        this.y = n2;
        this.active = n3;
        this.initGui();
        this.mc = Minecraft._E();
    }

    @Override
    public void initGui() {
        super.initGui();
        this.topButtons.clear();
        GuiMenuTopButton guiMenuTopButton = new GuiMenuTopButton(1, this.x, this.y, "menu.inventory");
        GuiMenuTopButton guiMenuTopButton2 = new GuiMenuTopButton(2, guiMenuTopButton, "quest.quests");
        GuiMenuTopButton guiMenuTopButton3 = new GuiMenuTopButton(3, guiMenuTopButton2, "menu.factions");
        this.topButtons.put(1, guiMenuTopButton);
        this.topButtons.put(2, guiMenuTopButton2);
        this.topButtons.put(3, guiMenuTopButton3);
        ((GuiMenuTopButton)this.topButtons.get((Object)Integer.valueOf((int)this.active))).active = true;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        for (GuiMenuTopButton guiMenuTopButton : this.topButtons.values()) {
            guiMenuTopButton.drawButton(this.mc, n, n2);
        }
    }

    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        if (n3 == 0) {
            for (GuiMenuTopButton guiMenuTopButton : this.topButtons.values()) {
                if (!guiMenuTopButton.mousePressed(this.mc, n, n2)) continue;
                this.topButtonPressed(guiMenuTopButton);
            }
        }
    }

    private void topButtonPressed(GuiMenuTopButton guiMenuTopButton) {
        if (!guiMenuTopButton.active) {
            this.mc._N._a("random.click", 1.0f, 1.0f);
            if (guiMenuTopButton.id == 1) {
                NoppesUtil.openGUI(this.player, new cebg(this.player));
            }
            if (guiMenuTopButton.id == 2) {
                NoppesUtil.openGUI(this.player, new GuiQuestLog(this.mc._t));
            }
            if (guiMenuTopButton.id == 3) {
                NoppesUtil.openGUI(this.player, new GuiFaction());
            }
        }
    }
}

