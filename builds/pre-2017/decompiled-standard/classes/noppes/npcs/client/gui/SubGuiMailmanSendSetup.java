/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.global.GuiNPCQuestSelection;
import noppes.npcs.client.gui.player.GuiMailmanWrite;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.GuiSelectionListener;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.client.gui.util.SubGuiInterface;
import noppes.npcs.controllers.PlayerMail;

public class SubGuiMailmanSendSetup
extends SubGuiInterface
implements GuiSelectionListener,
ITextfieldListener {
    private PlayerMail mail;
    private GuiNPCQuestSelection questSelection;

    public SubGuiMailmanSendSetup(PlayerMail playerMail, gqjz gqjz2) {
        this.parent = gqjz2;
        this.xSize = 256;
        this.setBackground("menubg.png");
        this.mail = playerMail;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addLabel(new GuiNpcLabel(1, "mailbox.subject", this.guiLeft + 4, this.guiTop + 19, 0x404040));
        this.addTextField(new GuiNpcTextField(1, this, this.field_73886_k, this.guiLeft + 60, this.guiTop + 14, 180, 20, this.mail.subject));
        this.addLabel(new GuiNpcLabel(0, "mailbox.sender", this.guiLeft + 4, this.guiTop + 41, 0x404040));
        this.addTextField(new GuiNpcTextField(0, this, this.field_73886_k, this.guiLeft + 60, this.guiTop + 36, 180, 20, this.mail.sender));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 29, this.guiTop + 100, "mailbox.write"));
        this.addLabel(new GuiNpcLabel(3, "quest.quest", this.guiLeft + 13, this.guiTop + 135, 0x404040));
        String string = this.mail.questTitle;
        if (string.isEmpty()) {
            string = "gui.select";
        }
        this.addButton(new GuiNpcButton(3, this.guiLeft + 70, this.guiTop + 130, 100, 20, string));
        this.addButton(new GuiNpcButton(4, this.guiLeft + 171, this.guiTop + 130, 20, 20, "X"));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 26, this.guiTop + 190, 100, 20, "gui.done"));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 130, this.guiTop + 190, 100, 20, "gui.cancel"));
    }

    @Override
    public void buttonEvent(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            this.close();
        }
        if (jiok2.field_73741_f == 1) {
            this.mail.questId = -1;
            this.mail.questTitle = "";
            this.mail.message = new qoac();
            this.close();
        }
        if (jiok2.field_73741_f == 2) {
            this.field_73882_e._a(new GuiMailmanWrite(this.parent, this.mail.message, true));
        }
        if (jiok2.field_73741_f == 3) {
            this.questSelection = new GuiNPCQuestSelection(this.npc, this.parent, this.mail.questId);
            NoppesUtil.openGUI(this.player, this.questSelection);
            this.questSelection.listener = this;
        }
        if (jiok2.field_73741_f == 4) {
            this.mail.questId = -1;
            this.mail.questTitle = "";
            this.func_73866_w_();
        }
    }

    @Override
    public void selected(int n) {
        this.mail.questId = n;
        this.mail.questTitle = this.questSelection.getSelected();
        this.func_73866_w_();
    }

    @Override
    public void save() {
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 0) {
            this.mail.sender = guiNpcTextField.func_73781_b();
        }
        if (guiNpcTextField.id == 1) {
            this.mail.subject = guiNpcTextField.func_73781_b();
        }
    }
}

