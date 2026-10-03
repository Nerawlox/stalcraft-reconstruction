/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.questtypes;

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
    private gqjz parent;
    private QuestLocation quest;

    public GuiNpcQuestTypeLocation(EntityNPCInterface entityNPCInterface, Quest quest, gqjz gqjz2) {
        super(entityNPCInterface);
        this.parent = gqjz2;
        this.title = "Quest Location Setup";
        this.quest = (QuestLocation)quest.questInterface;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addTextField(new GuiNpcTextField(0, this, this.field_73886_k, this.guiLeft - 100, this.guiTop + 70, 180, 20, this.quest.location));
        this.addTextField(new GuiNpcTextField(1, this, this.field_73886_k, this.guiLeft - 100, this.guiTop + 92, 180, 20, this.quest.location2));
        this.addTextField(new GuiNpcTextField(2, this, this.field_73886_k, this.guiLeft - 100, this.guiTop + 114, 180, 20, this.quest.location3));
        this.addButton(new GuiNpcButton(0, this.guiLeft - 100, this.guiTop + 140, 98, 20, "gui.back"));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        super.func_73875_a(jiok2);
        if (jiok2.field_73741_f == 0) {
            NoppesUtil.openGUI(this.player, this.parent);
        }
    }

    @Override
    public void save() {
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 0) {
            this.quest.location = guiNpcTextField.func_73781_b();
        }
        if (guiNpcTextField.id == 1) {
            this.quest.location2 = guiNpcTextField.func_73781_b();
        }
        if (guiNpcTextField.id == 2) {
            this.quest.location3 = guiNpcTextField.func_73781_b();
        }
    }
}

