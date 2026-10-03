/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNPCDialogSelection;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.GuiSelectionListener;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.client.gui.util.SubGuiInterface;
import noppes.npcs.constants.EnumOptionType;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogOption;

public class SubGuiNpcDialogOption
extends SubGuiInterface
implements GuiSelectionListener,
IGuiData,
ITextfieldListener {
    private DialogOption option;

    public SubGuiNpcDialogOption(DialogOption dialogOption) {
        this.option = dialogOption;
        this.setBackground("menubg.png");
        this.xSize = 256;
        this.ySize = 216;
        this.closeOnEsc = true;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addLabel(new GuiNpcLabel(66, "dialog.editoption", this.guiLeft, this.guiTop + 4, 0x404040));
        this.getLabel(66).center(this.xSize);
        this.addLabel(new GuiNpcLabel(0, "gui.title", this.guiLeft + 4, this.guiTop + 20, 0x404040));
        this.addTextField(new GuiNpcTextField(0, this, this.field_73886_k, this.guiLeft + 40, this.guiTop + 15, 196, 20, this.option.title));
        String string = Integer.toHexString(this.option.optionColor);
        while (string.length() < 6) {
            this.addLabel(new GuiNpcLabel(2, "gui.color", this.guiLeft + 4, this.guiTop + 45, 0x404040));
            string = 0 + string;
        }
        this.addTextField(new GuiNpcTextField(2, this, this.field_73886_k, this.guiLeft + 62, this.guiTop + 40, 92, 20, string));
        this.getTextField(2).func_73794_g(this.option.optionColor);
        this.addLabel(new GuiNpcLabel(1, "dialog.optiontype", this.guiLeft + 4, this.guiTop + 67, 0x404040));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 62, this.guiTop + 62, 92, 20, new String[]{"gui.close", "dialog.dialog", "gui.disabled", "menu.role", "tile.commandBlock.name"}, this.option.optionType.ordinal()));
        if (this.option.optionType == EnumOptionType.DialogOption) {
            this.addButton(new GuiNpcButton(3, this.guiLeft + 4, this.guiTop + 84, "availability.selectdialog"));
            if (this.option.dialogId >= 0) {
                NoppesUtil.sendData(EnumPacketType.DialogGet, this.option.dialogId);
            }
        }
        if (this.option.optionType == EnumOptionType.CommandBlock) {
            this.addTextField(new GuiNpcTextField(4, this, this.field_73886_k, this.guiLeft + 4, this.guiTop + 84, 248, 20, this.option.command));
            this.getTextField(4).func_73804_f(Short.MAX_VALUE);
            this.addLabel(new GuiNpcLabel(4, "advMode.command", this.guiLeft + 8, this.guiTop + 110, 0x404040));
            this.addLabel(new GuiNpcLabel(5, "advMode.nearestPlayer", this.guiLeft + 8, this.guiTop + 120, 0x404040));
            this.addLabel(new GuiNpcLabel(6, "advMode.randomPlayer", this.guiLeft + 8, this.guiTop + 130, 0x404040));
            this.addLabel(new GuiNpcLabel(7, "advMode.allPlayers", this.guiLeft + 8, this.guiTop + 140, 0x404040));
            this.addLabel(new GuiNpcLabel(8, "dialogcommandoptionplayer", this.guiLeft + 8, this.guiTop + 150, 0x404040));
            this.addButton(new GuiNpcButton(100, this.guiLeft + 8, this.guiTop + 165, 100, 20, new String[]{"\u0417\u0430\u043a\u0440\u044b\u0432\u0430\u0442\u044c \u0434\u0438\u0430\u043b\u043e\u0433: \u041d\u0435\u0442", "\u0417\u0430\u043a\u0440\u044b\u0432\u0430\u0442\u044c \u0434\u0438\u0430\u043b\u043e\u0433: \u0414\u0430"}, this.option.closeDialog ? 1 : 0));
        }
        this.addButton(new GuiNpcButton(66, this.guiLeft + 82, this.guiTop + 190, 98, 20, "gui.done"));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)jiok2;
        if (guiNpcButton.field_73741_f == 1) {
            this.option.optionType = EnumOptionType.values()[guiNpcButton.getValue()];
            this.func_73866_w_();
        }
        if (guiNpcButton.field_73741_f == 3) {
            GuiNPCDialogSelection guiNPCDialogSelection = new GuiNPCDialogSelection(this.npc, this.parent, this.option.dialogId);
            guiNPCDialogSelection.listener = this;
            NoppesUtil.openGUI(this.player, guiNPCDialogSelection);
        }
        if (jiok2.field_73741_f == 66) {
            this.close();
        }
        if (jiok2.field_73741_f == 100) {
            this.option.closeDialog = ((GuiNpcButton)jiok2).getValue() == 1;
        }
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 0) {
            if (guiNpcTextField.isEmpty()) {
                guiNpcTextField.func_73782_a(this.option.title);
            } else {
                this.option.title = guiNpcTextField.func_73781_b();
            }
        }
        if (guiNpcTextField.id == 2) {
            int n = 0xE0E0E0;
            try {
                n = Integer.parseInt(guiNpcTextField.func_73781_b(), 16);
            }
            catch (NumberFormatException numberFormatException) {
                n = 0xE0E0E0;
            }
            this.option.optionColor = n;
            String string = Integer.toHexString(this.option.optionColor);
            while (string.length() < 6) {
                string = 0 + string;
            }
            guiNpcTextField.func_73782_a(string);
            guiNpcTextField.func_73794_g(n);
        }
        if (guiNpcTextField.id == 4) {
            this.option.command = guiNpcTextField.func_73781_b();
        }
    }

    @Override
    public void setGuiData(qoac qoac2) {
        if (qoac2._c("DialogId")) {
            Dialog dialog = new Dialog();
            dialog.readNBT(qoac2);
            this.option.dialogId = dialog.id;
            if (this.getButton(3) != null) {
                this.getButton((int)3).field_73744_e = dialog.title;
            }
        }
    }

    @Override
    public void selected(int n) {
        this.option.dialogId = n;
    }
}

