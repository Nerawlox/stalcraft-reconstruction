/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.constants.EnumOptionType;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogController;

public class DialogOption {
    public int dialogId = -1;
    public String title = "Talk";
    public EnumOptionType optionType = EnumOptionType.Disabled;
    public int optionColor = 0xE0E0E0;
    public String command = "";
    public boolean closeDialog = false;

    public void readNBT(qoac qoac2) {
        if (qoac2 != null) {
            this.title = qoac2._j("Title");
            this.dialogId = qoac2._f("Dialog");
            this.optionColor = qoac2._f("DialogColor");
            this.optionType = EnumOptionType.values()[qoac2._f("OptionType")];
            this.command = qoac2._j("DialogCommand");
            if (this.optionColor == 0) {
                this.optionColor = 0xE0E0E0;
            }
            this.closeDialog = qoac2._o("CloseDialog");
        }
    }

    public qoac writeNBT() {
        qoac qoac2 = new qoac();
        qoac2._a("Title", this.title);
        qoac2._a("OptionType", this.optionType.ordinal());
        qoac2._a("Dialog", this.dialogId);
        qoac2._a("DialogColor", this.optionColor);
        qoac2._a("DialogCommand", this.command);
        qoac2._a("CloseDialog", this.closeDialog);
        return qoac2;
    }

    public boolean shouldClose() {
        return this.closeDialog || this.optionType == EnumOptionType.QuitOption || this.optionType == EnumOptionType.Disabled;
    }

    public boolean hasDialog() {
        if (this.dialogId <= 0) {
            return false;
        }
        if (!DialogController.instance.hasDialog(this.dialogId)) {
            this.dialogId = -1;
            return false;
        }
        return true;
    }

    public Dialog getDialog() {
        return !this.hasDialog() ? null : DialogController.instance.dialogs.get(this.dialogId);
    }

    public boolean isAvailable(EntityPlayer entityPlayer) {
        Dialog dialog = this.getDialog();
        return dialog != null && dialog.isAvailable(entityPlayer);
    }
}

