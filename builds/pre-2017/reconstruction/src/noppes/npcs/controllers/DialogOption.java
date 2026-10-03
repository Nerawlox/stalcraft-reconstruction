/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
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

    public void readNBT(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound != null) {
            this.title = nBTTagCompound._j("Title");
            this.dialogId = nBTTagCompound._f("Dialog");
            this.optionColor = nBTTagCompound._f("DialogColor");
            this.optionType = EnumOptionType.values()[nBTTagCompound._f("OptionType")];
            this.command = nBTTagCompound._j("DialogCommand");
            if (this.optionColor == 0) {
                this.optionColor = 0xE0E0E0;
            }
            this.closeDialog = nBTTagCompound._o("CloseDialog");
        }
    }

    public NBTTagCompound writeNBT() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("Title", this.title);
        nBTTagCompound._a("OptionType", this.optionType.ordinal());
        nBTTagCompound._a("Dialog", this.dialogId);
        nBTTagCompound._a("DialogColor", this.optionColor);
        nBTTagCompound._a("DialogCommand", this.command);
        nBTTagCompound._a("CloseDialog", this.closeDialog);
        return nBTTagCompound;
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

