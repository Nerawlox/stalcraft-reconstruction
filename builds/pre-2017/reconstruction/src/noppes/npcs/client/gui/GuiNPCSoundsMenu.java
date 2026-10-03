/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNpcSoundSelection;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.constants.EnumPacketType;

public class GuiNPCSoundsMenu
extends GuiNPCInterface2
implements ITextfieldListener {
    private GuiNpcSoundSelection gui;
    private GuiNpcTextField selectedField;

    public GuiNPCSoundsMenu(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addLabel(new GuiNpcLabel(0, "advanced.idlesound", this.guiLeft + 5, this.guiTop + 20, 0x404040));
        this.addTextField(new GuiNpcTextField(0, this, this.fontRenderer, this.guiLeft + 80, this.guiTop + 15, 200, 20, this.npc.advanced.idleSound));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 290, this.guiTop + 15, 80, 20, "gui.selectSound"));
        this.addLabel(new GuiNpcLabel(2, "advanced.angersound", this.guiLeft + 5, this.guiTop + 45, 0x404040));
        this.addTextField(new GuiNpcTextField(2, this, this.fontRenderer, this.guiLeft + 80, this.guiTop + 40, 200, 20, this.npc.advanced.angrySound));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 290, this.guiTop + 40, 80, 20, "gui.selectSound"));
        this.addLabel(new GuiNpcLabel(3, "advanced.hurtsound", this.guiLeft + 5, this.guiTop + 70, 0x404040));
        this.addTextField(new GuiNpcTextField(3, this, this.fontRenderer, this.guiLeft + 80, this.guiTop + 65, 200, 20, this.npc.advanced.hurtSound));
        this.addButton(new GuiNpcButton(3, this.guiLeft + 290, this.guiTop + 65, 80, 20, "gui.selectSound"));
        this.addLabel(new GuiNpcLabel(4, "advanced.deathsound", this.guiLeft + 5, this.guiTop + 95, 0x404040));
        this.addTextField(new GuiNpcTextField(4, this, this.fontRenderer, this.guiLeft + 80, this.guiTop + 90, 200, 20, this.npc.advanced.deathSound));
        this.addButton(new GuiNpcButton(4, this.guiLeft + 290, this.guiTop + 90, 80, 20, "gui.selectSound"));
        this.addLabel(new GuiNpcLabel(5, "advanced.stepsound", this.guiLeft + 5, this.guiTop + 120, 0x404040));
        this.addTextField(new GuiNpcTextField(5, this, this.fontRenderer, this.guiLeft + 80, this.guiTop + 115, 200, 20, this.npc.advanced.stepSound));
        this.addButton(new GuiNpcButton(5, this.guiLeft + 290, this.guiTop + 115, 80, 20, "gui.selectSound"));
    }

    @Override
    public void buttonEvent(GuiButton guiButton) {
        this.selectedField = this.getTextField(guiButton.id);
        this.gui = new GuiNpcSoundSelection(this.npc, this, this.selectedField.getText());
        NoppesUtil.openGUI(this.player, this.gui);
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 0) {
            this.npc.advanced.idleSound = guiNpcTextField.getText();
        }
        if (guiNpcTextField.id == 2) {
            this.npc.advanced.angrySound = guiNpcTextField.getText();
        }
        if (guiNpcTextField.id == 3) {
            this.npc.advanced.hurtSound = guiNpcTextField.getText();
        }
        if (guiNpcTextField.id == 4) {
            this.npc.advanced.deathSound = guiNpcTextField.getText();
        }
        if (guiNpcTextField.id == 5) {
            this.npc.advanced.stepSound = guiNpcTextField.getText();
        }
    }

    @Override
    public void elementClicked() {
        this.selectedField.setText(this.gui.getSelected());
        this.unFocused(this.selectedField);
    }

    @Override
    public void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new NBTTagCompound()));
    }
}

