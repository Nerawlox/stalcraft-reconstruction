/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import java.util.ArrayList;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.containers.ContainerNpcItemGiver;
import noppes.npcs.roles.JobItemGiver;

public class GuiNpcItemGiver
extends GuiContainerNPCInterface2 {
    private JobItemGiver role;

    public GuiNpcItemGiver(EntityNPCInterface entityNPCInterface, ContainerNpcItemGiver containerNpcItemGiver) {
        super(entityNPCInterface, containerNpcItemGiver);
        this.role = (JobItemGiver)entityNPCInterface.jobInterface;
        this.ySize = 182;
        this.setBackground("npcitemgiver.png");
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addButton(new GuiNpcButton(0, this.guiTop + 6, this.guiLeft + 6, 140, 20, new String[]{"Random Item", "All Items", "Give Not Owned Items", "Give When Doesnt Own Any", "Chained"}, this.role.givingMethod));
        this.addButton(new GuiNpcButton(1, this.guiTop + 6, this.guiLeft + 29, 140, 20, new String[]{"Timer", "Give Only Once", "Daily"}, this.role.cooldownType));
        this.addTextField(new GuiNpcTextField(0, this, this.fontRenderer, this.guiTop + 55, this.guiLeft + 54, 90, 20, this.role.cooldown + ""));
        this.getTextField((int)0).numbersOnly = true;
        this.addLabel(new GuiNpcLabel(0, "Cooldown:", this.guiTop + 6, this.guiLeft + 59, 0x404040));
        this.addLabel(new GuiNpcLabel(1, "Items to give", this.guiTop + 46, this.guiLeft + 79, 0x404040));
        this.getTextField((int)0).numbersOnly = true;
        int n = 0;
        for (String string : this.role.lines) {
            this.addTextField(new GuiNpcTextField(n + 1, this, this.fontRenderer, this.guiTop + 150, this.guiLeft + 6 + n * 24, 236, 20, string));
            ++n;
        }
        while (n < 3) {
            this.addTextField(new GuiNpcTextField(n + 1, this, this.fontRenderer, this.guiTop + 150, this.guiLeft + 6 + n * 24, 236, 20, ""));
            ++n;
        }
        this.getTextField((int)0).enabled = this.role.isOnTimer();
        this.getLabel((int)0).enabled = this.role.isOnTimer();
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)guiButton;
        if (guiButton.id == 0) {
            this.role.givingMethod = guiNpcButton.getValue();
        }
        if (guiButton.id == 1) {
            this.role.cooldownType = guiNpcButton.getValue();
            this.getTextField((int)0).enabled = this.role.isOnTimer();
            this.getLabel((int)0).enabled = this.role.isOnTimer();
        }
    }

    @Override
    public void save() {
        int n;
        ArrayList<String> arrayList = new ArrayList<String>();
        for (n = 1; n < 4; ++n) {
            GuiNpcTextField guiNpcTextField = this.getTextField(n);
            if (guiNpcTextField.isEmpty()) continue;
            arrayList.add(guiNpcTextField.getText());
        }
        this.role.lines = arrayList;
        n = 10;
        if (!this.getTextField(0).isEmpty() && this.getTextField(0).isInteger()) {
            n = this.getTextField(0).getInteger();
        }
        this.role.cooldown = n;
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new NBTTagCompound()));
    }
}

