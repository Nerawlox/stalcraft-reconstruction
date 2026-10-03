/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.HashMap;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNpcMusicSelection;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.Line;
import noppes.npcs.controllers.Lines;

public class GuiNPCLinesEdit
extends GuiNPCInterface2
implements IGuiData {
    private Lines lines;
    private GuiNpcTextField field;
    private GuiNpcMusicSelection gui;

    public GuiNPCLinesEdit(EntityNPCInterface entityNPCInterface, Lines lines) {
        super(entityNPCInterface);
        this.lines = lines;
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedGet, new Object[0]);
    }

    @Override
    public void initGui() {
        super.initGui();
        for (int i = 0; i < 8; ++i) {
            String string = "";
            String string2 = "";
            if (this.lines.lines.containsKey(i)) {
                Line line = (Line)this.lines.lines.get(i);
                string = line.text;
                string2 = line.sound;
            }
            this.addTextField(new GuiNpcTextField(i, this, this.fontRenderer, this.guiLeft + 4, this.guiTop + 4 + i * 24, 200, 20, string));
            this.addTextField(new GuiNpcTextField(i + 8, this, this.fontRenderer, this.guiLeft + 208, this.guiTop + 4 + i * 24, 146, 20, string2));
            this.addButton(new GuiNpcButton(i, this.guiLeft + 358, this.guiTop + 4 + i * 24, 60, 20, "mco.template.button.select"));
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)guiButton;
        this.field = this.getTextField(guiNpcButton.id + 8);
        this.gui = new GuiNpcMusicSelection(this.npc, this, this.field.getText());
        NoppesUtil.openGUI(this.player, this.gui);
    }

    @Override
    public void elementClicked() {
        this.field.setText(this.gui.getSelected());
        this.saveLines();
    }

    @Override
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        this.npc.advanced.readToNBT(nBTTagCompound);
        this.initGui();
    }

    private void saveLines() {
        HashMap<Integer, Line> hashMap = new HashMap<Integer, Line>();
        for (int i = 0; i < 8; ++i) {
            GuiNpcTextField guiNpcTextField = this.getTextField(i);
            GuiNpcTextField guiNpcTextField2 = this.getTextField(i + 8);
            if (guiNpcTextField.isEmpty() && guiNpcTextField2.isEmpty()) continue;
            Line line = new Line();
            line.text = guiNpcTextField.getText();
            line.sound = guiNpcTextField2.getText();
            hashMap.put(i, line);
        }
        this.lines.lines = hashMap;
    }

    @Override
    public void save() {
        this.saveLines();
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new NBTTagCompound()));
    }
}

