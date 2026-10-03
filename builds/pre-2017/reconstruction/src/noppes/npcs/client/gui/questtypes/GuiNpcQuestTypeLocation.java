/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.questtypes;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.controllers.Quest;
import noppes.npcs.quests.QuestLocation;

public class GuiNpcQuestTypeLocation
extends GuiNPCInterface
implements ITextfieldListener {
    private GuiScreen parent;
    private QuestLocation quest;

    public GuiNpcQuestTypeLocation(EntityNPCInterface entityNPCInterface, Quest quest, GuiScreen guiScreen) {
        super(entityNPCInterface);
        this.parent = guiScreen;
        this.title = "Quest Location Setup";
        this.quest = (QuestLocation)quest.questInterface;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addTextField(new GuiNpcTextField(0, this, this.fontRenderer, this.guiLeft - 100, this.guiTop + 70, 180, 20, this.quest.location));
        this.addTextField(new GuiNpcTextField(1, this, this.fontRenderer, this.guiLeft - 100, this.guiTop + 92, 180, 20, this.quest.location2));
        this.addTextField(new GuiNpcTextField(2, this, this.fontRenderer, this.guiLeft - 100, this.guiTop + 114, 180, 20, this.quest.location3));
        this.addButton(new GuiNpcButton(0, this.guiLeft - 100, this.guiTop + 140, 98, 20, "gui.back"));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        super.actionPerformed(guiButton);
        if (guiButton.id == 0) {
            NoppesUtil.openGUI(this.player, this.parent);
        }
    }

    @Override
    public void save() {
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 0) {
            this.quest.location = guiNpcTextField.getText();
        }
        if (guiNpcTextField.id == 1) {
            this.quest.location2 = guiNpcTextField.getText();
        }
        if (guiNpcTextField.id == 2) {
            this.quest.location3 = guiNpcTextField.getText();
        }
    }
}

