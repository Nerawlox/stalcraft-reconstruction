/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.HashMap;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNPCDialogSelection;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.GuiSelectionListener;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.constants.EnumOptionType;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogOption;

public class GuiNPCDialogOptions
extends GuiNPCInterface
implements GuiSelectionListener,
ITextfieldListener {
    public HashMap options = new HashMap();
    private gqjz parent;
    private Dialog dialog;
    private int selectedSlot;

    public GuiNPCDialogOptions(EntityNPCInterface entityNPCInterface, gqjz gqjz2, Dialog dialog) {
        super(entityNPCInterface);
        this.parent = gqjz2;
        this.dialog = dialog;
        this.options = dialog.options;
        this.title = "";
        this.drawDefaultBackground = false;
    }

    @Override
    public void func_73866_w_() {
        int n;
        super.func_73866_w_();
        for (n = 0; n < 6; ++n) {
            if (this.options.containsKey(n)) continue;
            this.options.put(n, new DialogOption());
        }
        for (n = 0; n < 6; ++n) {
            DialogOption dialogOption = (DialogOption)this.options.get(n);
            int n2 = 6 + n % 3 * 70;
            int n3 = (this.field_73880_f - 420) / 4 + this.field_73880_f / 2 + 1;
            if (n > 2) {
                n3 -= this.field_73880_f / 2;
            }
            this.addButton(new GuiNpcButton(n, n3, n2, 92, 20, new String[]{"dialog.quitoption", "dialog.option", " gui.disabled", "dialog.roleoption", "dialogcommandoption"}, dialogOption.optionType.ordinal()));
            this.addTextField(new GuiNpcTextField(n, this, this.field_73886_k, n3 + 2, n2 + 22, 196, 20, dialogOption.title));
            this.addButton(new GuiNpcButton(n + 6, n3, n2 + 44, 196, 20, "dialog.selectoption"));
            String string = Integer.toHexString(dialogOption.optionColor);
            while (string.length() < 6) {
                string = 0 + string;
            }
            this.addLabel(new GuiNpcLabel(n, "gui.color", n3 + 98, n2 + 4, 0xFFFFFF));
            this.addTextField(new GuiNpcTextField(n + 6, this, this.field_73886_k, n3 + 130, n2, 45, 20, string));
            this.addTextField(new GuiNpcTextField(n + 12, this, this.field_73886_k, n3 + 2, n2 + 44, 196, 20, dialogOption.command));
            this.getTextField((int)(n + 12)).enabled = dialogOption.optionType == EnumOptionType.CommandBlock;
            this.getButton((int)(n + 6)).field_73748_h = dialogOption.optionType == EnumOptionType.DialogOption;
            this.getButton((int)(n + 6)).field_73742_g = this.getButton((int)(n + 6)).field_73748_h;
            this.getTextField((int)n).enabled = dialogOption.optionType != EnumOptionType.Disabled;
            this.getTextField((int)(n + 6)).enabled = dialogOption.optionType != EnumOptionType.Disabled;
            this.getLabel((int)n).enabled = dialogOption.optionType != EnumOptionType.Disabled;
        }
        this.addButton(new GuiNpcButton(66, this.field_73880_f / 2 - 49, 215, 98, 20, "gui.back"));
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        this.func_73728_b(this.field_73880_f / 2, 0, this.field_73881_g, -1);
        this.func_73730_a(0, this.field_73880_f, 74, -1);
        this.func_73730_a(0, this.field_73880_f, 144, -1);
        super.func_73863_a(n, n2, f);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        DialogOption dialogOption;
        GuiNpcButton guiNpcButton = (GuiNpcButton)jiok2;
        if (jiok2.field_73741_f >= 0 && jiok2.field_73741_f < 6) {
            dialogOption = (DialogOption)this.options.get(jiok2.field_73741_f);
            dialogOption.optionType = EnumOptionType.values()[guiNpcButton.getValue()];
            this.func_73866_w_();
        }
        if (jiok2.field_73741_f >= 6 && jiok2.field_73741_f < 12) {
            this.save();
            this.selectedSlot = jiok2.field_73741_f - 6;
            dialogOption = (DialogOption)this.options.get(this.selectedSlot);
            int n = -1;
            if (dialogOption != null) {
                n = dialogOption.dialogId;
            }
            NoppesUtil.openGUI(this.player, new GuiNPCDialogSelection(this.npc, this, n));
        }
        if (jiok2.field_73741_f == 66) {
            this.save();
            NoppesUtil.openGUI(this.player, this.parent);
        }
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        DialogOption dialogOption;
        if (guiNpcTextField.id >= 0 && guiNpcTextField.id < 6) {
            dialogOption = (DialogOption)this.options.get(guiNpcTextField.id);
            if (guiNpcTextField.isEmpty()) {
                dialogOption.optionType = EnumOptionType.Disabled;
                this.func_73866_w_();
            } else {
                dialogOption.title = guiNpcTextField.func_73781_b();
            }
        }
        if (guiNpcTextField.id >= 6 && guiNpcTextField.id < 12) {
            dialogOption = (DialogOption)this.options.get(guiNpcTextField.id - 6);
            int n = 0xE0E0E0;
            try {
                n = Integer.parseInt(guiNpcTextField.func_73781_b(), 16);
            }
            catch (NumberFormatException numberFormatException) {
                n = 0xE0E0E0;
            }
            dialogOption.optionColor = n;
            String string = Integer.toHexString(dialogOption.optionColor);
            while (string.length() < 6) {
                string = 0 + string;
            }
            guiNpcTextField.func_73782_a(string);
        }
        if (guiNpcTextField.id >= 12 && guiNpcTextField.id < 18) {
            dialogOption = (DialogOption)this.options.get(guiNpcTextField.id - 12);
            dialogOption.command = guiNpcTextField.func_73781_b();
        }
    }

    @Override
    public void save() {
        this.dialog.options = this.options;
    }

    @Override
    public void selected(int n) {
        if (!this.options.containsKey(this.selectedSlot)) {
            this.options.put(this.selectedSlot, new DialogOption());
        }
        DialogOption dialogOption = (DialogOption)this.options.get(this.selectedSlot);
        dialogOption.dialogId = n;
    }
}

