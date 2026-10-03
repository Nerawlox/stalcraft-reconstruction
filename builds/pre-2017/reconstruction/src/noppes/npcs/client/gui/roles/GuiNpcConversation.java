/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.SubGuiNpcAvailability;
import noppes.npcs.client.gui.global.GuiNPCQuestSelection;
import noppes.npcs.client.gui.roles.SubGuiNpcConversationLine;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.GuiSelectionListener;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.client.gui.util.SubGuiInterface;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.roles.JobConversation;

public class GuiNpcConversation
extends GuiNPCInterface2
implements GuiSelectionListener,
ITextfieldListener {
    private JobConversation job;
    private int slot = -1;
    private GuiNPCQuestSelection questSelection;

    public GuiNpcConversation(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        this.job = (JobConversation)entityNPCInterface.jobInterface;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addLabel(new GuiNpcLabel(40, "gui.name", this.guiLeft + 40, this.guiTop + 4, 0x404040));
        this.addLabel(new GuiNpcLabel(41, "gui.name", this.guiLeft + 240, this.guiTop + 4, 0x404040));
        this.addLabel(new GuiNpcLabel(42, "\u0417\u0430\u0434\u0435\u0440\u0436\u043a\u0430 (\u0441\u0435\u043a.)", this.guiLeft + 156, this.guiTop + 4, 0x404040));
        this.addLabel(new GuiNpcLabel(43, "\u0417\u0430\u0434\u0435\u0440\u0436\u043a\u0430 (\u0441\u0435\u043a.)", this.guiLeft + 356, this.guiTop + 4, 0x404040));
        for (int i = 0; i < 14; ++i) {
            JobConversation.ConversationLine conversationLine = this.job.getLine(i);
            int n = i >= 7 ? 200 : 0;
            this.addLabel(new GuiNpcLabel(i, "" + i, this.guiLeft + 5 + n - (i > 9 ? 6 : 0), this.guiTop + 18 + i % 7 * 22, 0));
            this.addTextField(new GuiNpcTextField(i, this, this.fontRenderer, this.guiLeft + 13 + n, this.guiTop + 13 + i % 7 * 22, 100, 20, conversationLine.npc));
            this.addButton(new GuiNpcButton(i, this.guiLeft + 115 + n, this.guiTop + 13 + i % 7 * 22, 46, 20, "conversation.line"));
            if (i == 13) break;
            this.addTextField(new GuiNpcTextField(i + 14, this, this.fontRenderer, this.guiLeft + 164 + n, this.guiTop + 13 + i % 7 * 22, 30, 20, conversationLine.delay + ""));
            this.getTextField((int)(i + 14)).numbersOnly = true;
            this.getTextField(i + 14).setMinMaxDefault(1, 60, 4);
        }
        this.addLabel(new GuiNpcLabel(50, "\u0417\u0430\u0434\u0435\u0440\u0436\u043a\u0430 (\u0441\u0435\u043a.)", this.guiLeft + 195, this.guiTop + 175, 0x404040));
        this.addTextField(new GuiNpcTextField(50, this, this.fontRenderer, this.guiLeft + 255, this.guiTop + 170, 50, 20, this.job.generalDelay + ""));
        this.getTextField((int)50).numbersOnly = true;
        this.getTextField(50).setMinMaxDefault(0, 86400, 10);
        this.addLabel(new GuiNpcLabel(54, "gui.range", this.guiLeft + 195, this.guiTop + 196, 0x404040));
        this.addTextField(new GuiNpcTextField(54, this, this.fontRenderer, this.guiLeft + 255, this.guiTop + 191, 50, 20, this.job.range + ""));
        this.getTextField((int)54).numbersOnly = true;
        this.getTextField(54).setMinMaxDefault(4, 60, 20);
        this.addLabel(new GuiNpcLabel(51, "quest.quest", this.guiLeft + 13, this.guiTop + 175, 0x404040));
        String string = this.job.questTitle;
        if (string.isEmpty()) {
            string = "gui.select";
        }
        this.addButton(new GuiNpcButton(51, this.guiLeft + 70, this.guiTop + 170, 100, 20, string));
        this.addButton(new GuiNpcButton(52, this.guiLeft + 171, this.guiTop + 170, 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(53, "availability.name", this.guiLeft + 13, this.guiTop + 196, 0x404040));
        this.addButton(new GuiNpcButton(53, this.guiLeft + 110, this.guiTop + 191, 60, 20, "selectServer.edit"));
        this.addLabel(new GuiNpcLabel(57, "\u0414\u043e\u043b\u0436\u0435\u043d \u0432\u0438\u0434\u0435\u0442\u044c \u0438\u0433\u0440\u043e\u043a\u0430?", this.guiLeft + 320, this.guiTop + 175, 0x404040));
        this.addButton(new GuiNpcButton(57, this.guiLeft + 360, this.guiTop + 190, 50, 20, new String[]{"\u041d\u0435\u0442", "\u0414\u0430"}, this.job.visiblityCheck ? 1 : 0));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)guiButton;
        if (guiNpcButton.id >= 0 && guiNpcButton.id < 14) {
            this.slot = guiNpcButton.id;
            JobConversation.ConversationLine conversationLine = this.job.getLine(this.slot);
            this.setSubGui(new SubGuiNpcConversationLine(conversationLine.text, conversationLine.sound));
        }
        if (guiNpcButton.id == 51) {
            this.questSelection = new GuiNPCQuestSelection(this.npc, this, this.job.quest);
            NoppesUtil.openGUI(this.player, this.questSelection);
        }
        if (guiNpcButton.id == 52) {
            this.job.quest = -1;
            this.job.questTitle = "";
            this.initGui();
        }
        if (guiNpcButton.id == 53) {
            this.setSubGui(new SubGuiNpcAvailability(this.job.availability));
        }
        if (guiNpcButton.id == 57) {
            this.job.visiblityCheck = guiNpcButton.getValue() == 1;
        }
    }

    @Override
    public void selected(int n) {
        this.job.quest = n;
        this.job.questTitle = this.questSelection.getSelected();
        this.initGui();
    }

    @Override
    public void closeSubGui(SubGuiInterface subGuiInterface) {
        super.closeSubGui(subGuiInterface);
        if (subGuiInterface instanceof SubGuiNpcConversationLine) {
            SubGuiNpcConversationLine subGuiNpcConversationLine = (SubGuiNpcConversationLine)subGuiInterface;
            JobConversation.ConversationLine conversationLine = this.job.getLine(this.slot);
            conversationLine.text = subGuiNpcConversationLine.line;
            conversationLine.sound = subGuiNpcConversationLine.sound;
        }
    }

    @Override
    public void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        JobConversation.ConversationLine conversationLine;
        if (guiNpcTextField.id >= 0 && guiNpcTextField.id < 14) {
            conversationLine = this.job.getLine(guiNpcTextField.id);
            conversationLine.npc = guiNpcTextField.getText();
        }
        if (guiNpcTextField.id >= 14 && guiNpcTextField.id < 28) {
            conversationLine = this.job.getLine(guiNpcTextField.id - 14);
            conversationLine.delay = guiNpcTextField.getInteger();
        }
        if (guiNpcTextField.id == 50) {
            this.job.generalDelay = guiNpcTextField.getInteger();
        }
        if (guiNpcTextField.id == 54) {
            this.job.range = guiNpcTextField.getInteger();
        }
    }
}

