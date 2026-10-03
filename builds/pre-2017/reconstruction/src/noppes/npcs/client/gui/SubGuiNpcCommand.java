/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import net.minecraft.client.gui.GuiButton;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.client.gui.util.SubGuiInterface;

public class SubGuiNpcCommand
extends SubGuiInterface
implements ITextfieldListener {
    public String command;

    public SubGuiNpcCommand(String string) {
        this.command = string;
        this.setBackground("menubg.png");
        this.xSize = 256;
        this.ySize = 216;
        this.closeOnEsc = true;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addTextField(new GuiNpcTextField(4, this, this.fontRenderer, this.guiLeft + 4, this.guiTop + 84, 248, 20, this.command));
        this.getTextField(4).setMaxStringLength(Short.MAX_VALUE);
        this.addLabel(new GuiNpcLabel(4, "advMode.command", this.guiLeft + 4, this.guiTop + 110, 0x404040));
        this.addLabel(new GuiNpcLabel(5, "advMode.nearestPlayer", this.guiLeft + 4, this.guiTop + 125, 0x404040));
        this.addLabel(new GuiNpcLabel(6, "advMode.randomPlayer", this.guiLeft + 4, this.guiTop + 140, 0x404040));
        this.addLabel(new GuiNpcLabel(7, "advMode.allPlayers", this.guiLeft + 4, this.guiTop + 155, 0x404040));
        this.addLabel(new GuiNpcLabel(8, "dialogcommandoptionplayer", this.guiLeft + 4, this.guiTop + 170, 0x404040));
        this.addButton(new GuiNpcButton(66, this.guiLeft + 82, this.guiTop + 190, 98, 20, "gui.done"));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 66) {
            this.close();
        }
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 4) {
            this.command = guiNpcTextField.getText();
        }
    }
}

