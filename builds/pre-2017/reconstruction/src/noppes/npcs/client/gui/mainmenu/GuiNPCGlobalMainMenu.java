/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.mainmenu;

import net.minecraft.client.gui.GuiButton;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.global.GuiNpcManagePlayerData;
import noppes.npcs.client.gui.replica.GuiSoundPresets;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.constants.EnumGuiType;

public class GuiNPCGlobalMainMenu
extends GuiNPCInterface2 {
    public GuiNPCGlobalMainMenu(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface, 5);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addButton(new GuiNpcButton(2, this.guiLeft + 85, this.guiTop + 20, "global.banks"));
        this.addButton(new GuiNpcButton(3, this.guiLeft + 85, this.guiTop + 42, "menu.factions"));
        this.addButton(new GuiNpcButton(4, this.guiLeft + 85, this.guiTop + 64, "dialog.dialogs"));
        this.addButton(new GuiNpcButton(11, this.guiLeft + 85, this.guiTop + 86, "quest.quests"));
        this.addButton(new GuiNpcButton(12, this.guiLeft + 85, this.guiTop + 108, "global.transport"));
        this.addButton(new GuiNpcButton(13, this.guiLeft + 85, this.guiTop + 130, "global.playerdata"));
        this.addButton(new GuiNpcButton(14, this.guiLeft + 85, this.guiTop + 152, "global.recipes"));
        this.addButton(new GuiNpcButton(15, this.guiLeft + 85, this.guiTop + 174, "\u041f\u0440\u0435\u0441\u0435\u0442\u044b \u0440\u0435\u043f\u043b\u0438\u043a"));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 11) {
            NoppesUtil.requestOpenGUI(EnumGuiType.ManageQuests);
        }
        if (guiButton.id == 2) {
            NoppesUtil.requestOpenGUI(EnumGuiType.ManageBanks);
        }
        if (guiButton.id == 3) {
            NoppesUtil.requestOpenGUI(EnumGuiType.ManageFactions);
        }
        if (guiButton.id == 4) {
            NoppesUtil.requestOpenGUI(EnumGuiType.ManageDialogs);
        }
        if (guiButton.id == 12) {
            NoppesUtil.requestOpenGUI(EnumGuiType.ManageTransport);
        }
        if (guiButton.id == 13) {
            NoppesUtil.openGUI(this.player, new GuiNpcManagePlayerData(this.npc, this));
        }
        if (guiButton.id == 14) {
            NoppesUtil.requestOpenGUI(EnumGuiType.ManageRecipes, 4, 0, 0);
        }
        if (guiButton.id == 15) {
            NoppesUtil.openGUI(this.player, new GuiSoundPresets(this));
        }
    }

    @Override
    public void save() {
    }
}

