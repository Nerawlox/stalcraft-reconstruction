/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import net.minecraft.client.gui.GuiButton;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNPCLinesEdit;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;

public class GuiNPCLinesMenu
extends GuiNPCInterface2 {
    public GuiNPCLinesMenu(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addButton(new GuiNpcButton(0, this.guiLeft + 85, this.guiTop + 20, "World Lines"));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 85, this.guiTop + 43, "Attack Lines"));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 85, this.guiTop + 66, "Interact Lines"));
        this.addButton(new GuiNpcButton(5, this.guiLeft + 85, this.guiTop + 89, "Killed Lines"));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            NoppesUtil.openGUI(this.player, new GuiNPCLinesEdit(this.npc, this.npc.advanced.worldLines));
        }
        if (guiButton.id == 1) {
            NoppesUtil.openGUI(this.player, new GuiNPCLinesEdit(this.npc, this.npc.advanced.attackLines));
        }
        if (guiButton.id == 2) {
            NoppesUtil.openGUI(this.player, new GuiNPCLinesEdit(this.npc, this.npc.advanced.interactLines));
        }
        if (guiButton.id == 5) {
            NoppesUtil.openGUI(this.player, new GuiNPCLinesEdit(this.npc, this.npc.advanced.killedLines));
        }
    }

    @Override
    public void save() {
    }
}

