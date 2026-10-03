/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.nbt.NBTTagCompound;
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

    public SubGuiMailmanSendSetup(PlayerMail playerMail, GuiScreen guiScreen) {
        this.parent = guiScreen;
        this.xSize = 256;
        this.setBackground("menubg.png");
        this.mail = playerMail;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addLabel(new GuiNpcLabel(1, "mailbox.subject", this.guiLeft + 4, this.guiTop + 19, 0x404040));
        this.addTextField(new GuiNpcTextField(1, this, this.fontRenderer, this.guiLeft + 60, this.guiTop + 14, 180, 20, this.mail.subject));
        this.addLabel(new GuiNpcLabel(0, "mailbox.sender", this.guiLeft + 4, this.guiTop + 41, 0x404040));
        this.addTextField(new GuiNpcTextField(0, this, this.fontRenderer, this.guiLeft + 60, this.guiTop + 36, 180, 20, this.mail.sender));
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
    public void buttonEvent(GuiButton guiButton) {
        if (guiButton.id == 0) {
            this.close();
        }
        if (guiButton.id == 1) {
            this.mail.questId = -1;
            this.mail.questTitle = "";
            this.mail.message = new NBTTagCompound();
            this.close();
        }
        if (guiButton.id == 2) {
            this.mc._a(new GuiMailmanWrite(this.parent, this.mail.message, true));
        }
        if (guiButton.id == 3) {
            this.questSelection = new GuiNPCQuestSelection(this.npc, this.parent, this.mail.questId);
            NoppesUtil.openGUI(this.player, this.questSelection);
            this.questSelection.listener = this;
        }
        if (guiButton.id == 4) {
            this.mail.questId = -1;
            this.mail.questTitle = "";
            this.initGui();
        }
    }

    @Override
    public void selected(int n) {
        this.mail.questId = n;
        this.mail.questTitle = this.questSelection.getSelected();
        this.initGui();
    }

    @Override
    public void save() {
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 0) {
            this.mail.sender = guiNpcTextField.getText();
        }
        if (guiNpcTextField.id == 1) {
            this.mail.subject = guiNpcTextField.getText();
        }
    }
}

