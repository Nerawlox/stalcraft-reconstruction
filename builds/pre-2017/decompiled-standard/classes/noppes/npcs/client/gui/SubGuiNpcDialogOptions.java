/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import noppes.npcs.client.gui.SubGuiNpcDialogOption;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.SubGuiInterface;
import noppes.npcs.constants.EnumOptionType;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogOption;

public class SubGuiNpcDialogOptions
extends SubGuiInterface {
    private Dialog dialog;

    public SubGuiNpcDialogOptions(Dialog dialog) {
        this.dialog = dialog;
        this.setBackground("menubg.png");
        this.xSize = 256;
        this.ySize = 216;
        this.closeOnEsc = true;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addLabel(new GuiNpcLabel(66, "dialog.options", this.guiLeft, this.guiTop + 4, 0x404040));
        this.getLabel(66).center(this.xSize);
        for (int i = 0; i < 6; ++i) {
            String string = "";
            DialogOption dialogOption = this.dialog.options.get(i);
            if (dialogOption != null && dialogOption.optionType != EnumOptionType.Disabled) {
                string = string + dialogOption.title;
            }
            this.addLabel(new GuiNpcLabel(i + 10, i + 1 + ": ", this.guiLeft + 4, this.guiTop + 16 + i * 32, 0x404040));
            this.addLabel(new GuiNpcLabel(i, string, this.guiLeft + 14, this.guiTop + 12 + i * 32, 0x404040));
            this.addButton(new GuiNpcButton(i, this.guiLeft + 13, this.guiTop + 21 + i * 32, 60, 20, "selectServer.edit"));
        }
        this.addButton(new GuiNpcButton(66, this.guiLeft + 82, this.guiTop + 194, 98, 20, "gui.done"));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f < 6) {
            if (!this.dialog.options.containsKey(jiok2.field_73741_f)) {
                this.dialog.options.put(jiok2.field_73741_f, new DialogOption());
            }
            this.changeSubGui(new SubGuiNpcDialogOption(this.dialog.options.get(jiok2.field_73741_f)));
        }
        if (jiok2.field_73741_f == 66) {
            this.close();
        }
    }
}

