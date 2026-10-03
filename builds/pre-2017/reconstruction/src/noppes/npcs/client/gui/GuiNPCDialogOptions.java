/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.HashMap;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
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
    private GuiScreen parent;
    private Dialog dialog;
    private int selectedSlot;

    public GuiNPCDialogOptions(EntityNPCInterface entityNPCInterface, GuiScreen guiScreen, Dialog dialog) {
        super(entityNPCInterface);
        this.parent = guiScreen;
        this.dialog = dialog;
        this.options = dialog.options;
        this.title = "";
        this.drawDefaultBackground = false;
    }

    @Override
    public void initGui() {
        int n;
        super.initGui();
        for (n = 0; n < 6; ++n) {
            if (this.options.containsKey(n)) continue;
            this.options.put(n, new DialogOption());
        }
        for (n = 0; n < 6; ++n) {
            DialogOption dialogOption = (DialogOption)this.options.get(n);
            int n2 = 6 + n % 3 * 70;
            int n3 = (this.width - 420) / 4 + this.width / 2 + 1;
            if (n > 2) {
                n3 -= this.width / 2;
            }
            this.addButton(new GuiNpcButton(n, n3, n2, 92, 20, new String[]{"dialog.quitoption", "dialog.option", " gui.disabled", "dialog.roleoption", "dialogcommandoption"}, dialogOption.optionType.ordinal()));
            this.addTextField(new GuiNpcTextField(n, this, this.fontRenderer, n3 + 2, n2 + 22, 196, 20, dialogOption.title));
            this.addButton(new GuiNpcButton(n + 6, n3, n2 + 44, 196, 20, "dialog.selectoption"));
            String string = Integer.toHexString(dialogOption.optionColor);
            while (string.length() < 6) {
                string = 0 + string;
            }
            this.addLabel(new GuiNpcLabel(n, "gui.color", n3 + 98, n2 + 4, 0xFFFFFF));
            this.addTextField(new GuiNpcTextField(n + 6, this, this.fontRenderer, n3 + 130, n2, 45, 20, string));
            this.addTextField(new GuiNpcTextField(n + 12, this, this.fontRenderer, n3 + 2, n2 + 44, 196, 20, dialogOption.command));
            this.getTextField((int)(n + 12)).enabled = dialogOption.optionType == EnumOptionType.CommandBlock;
            this.getButton((int)(n + 6)).drawButton = dialogOption.optionType == EnumOptionType.DialogOption;
            this.getButton((int)(n + 6)).enabled = this.getButton((int)(n + 6)).drawButton;
            this.getTextField((int)n).enabled = dialogOption.optionType != EnumOptionType.Disabled;
            this.getTextField((int)(n + 6)).enabled = dialogOption.optionType != EnumOptionType.Disabled;
            this.getLabel((int)n).enabled = dialogOption.optionType != EnumOptionType.Disabled;
        }
        this.addButton(new GuiNpcButton(66, this.width / 2 - 49, 215, 98, 20, "gui.back"));
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawVerticalLine(this.width / 2, 0, this.height, -1);
        this.drawHorizontalLine(0, this.width, 74, -1);
        this.drawHorizontalLine(0, this.width, 144, -1);
        super.drawScreen(n, n2, f);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        DialogOption dialogOption;
        GuiNpcButton guiNpcButton = (GuiNpcButton)guiButton;
        if (guiButton.id >= 0 && guiButton.id < 6) {
            dialogOption = (DialogOption)this.options.get(guiButton.id);
            dialogOption.optionType = EnumOptionType.values()[guiNpcButton.getValue()];
            this.initGui();
        }
        if (guiButton.id >= 6 && guiButton.id < 12) {
            this.save();
            this.selectedSlot = guiButton.id - 6;
            dialogOption = (DialogOption)this.options.get(this.selectedSlot);
            int n = -1;
            if (dialogOption != null) {
                n = dialogOption.dialogId;
            }
            NoppesUtil.openGUI(this.player, new GuiNPCDialogSelection(this.npc, this, n));
        }
        if (guiButton.id == 66) {
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
                this.initGui();
            } else {
                dialogOption.title = guiNpcTextField.getText();
            }
        }
        if (guiNpcTextField.id >= 6 && guiNpcTextField.id < 12) {
            dialogOption = (DialogOption)this.options.get(guiNpcTextField.id - 6);
            int n = 0xE0E0E0;
            try {
                n = Integer.parseInt(guiNpcTextField.getText(), 16);
            }
            catch (NumberFormatException numberFormatException) {
                n = 0xE0E0E0;
            }
            dialogOption.optionColor = n;
            String string = Integer.toHexString(dialogOption.optionColor);
            while (string.length() < 6) {
                string = 0 + string;
            }
            guiNpcTextField.setText(string);
        }
        if (guiNpcTextField.id >= 12 && guiNpcTextField.id < 18) {
            dialogOption = (DialogOption)this.options.get(guiNpcTextField.id - 12);
            dialogOption.command = guiNpcTextField.getText();
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

