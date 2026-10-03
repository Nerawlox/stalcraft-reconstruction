/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import java.util.HashMap;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.player.GuiFaction;
import noppes.npcs.client.gui.player.GuiQuestLog;
import noppes.npcs.client.gui.util.GuiMenuTopButton;
import noppes.npcs.client.gui.util.ITopButtonListener;

public class GuiPlayerTopMenu
extends gqjz
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
        this.func_73866_w_();
        this.field_73882_e = xpzm._E();
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
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
    public void func_73863_a(int n, int n2, float f) {
        for (GuiMenuTopButton guiMenuTopButton : this.topButtons.values()) {
            guiMenuTopButton.func_73737_a(this.field_73882_e, n, n2);
        }
    }

    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        if (n3 == 0) {
            for (GuiMenuTopButton guiMenuTopButton : this.topButtons.values()) {
                if (!guiMenuTopButton.func_73736_c(this.field_73882_e, n, n2)) continue;
                this.topButtonPressed(guiMenuTopButton);
            }
        }
    }

    private void topButtonPressed(GuiMenuTopButton guiMenuTopButton) {
        if (!guiMenuTopButton.active) {
            this.field_73882_e._N._a("random.click", 1.0f, 1.0f);
            if (guiMenuTopButton.field_73741_f == 1) {
                NoppesUtil.openGUI(this.player, new cebg(this.player));
            }
            if (guiMenuTopButton.field_73741_f == 2) {
                NoppesUtil.openGUI(this.player, new GuiQuestLog(this.field_73882_e._t));
            }
            if (guiMenuTopButton.field_73741_f == 3) {
                NoppesUtil.openGUI(this.player, new GuiFaction());
            }
        }
    }
}

