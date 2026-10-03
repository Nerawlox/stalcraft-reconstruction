/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.roles.JobHealer;

public class GuiNpcHealer
extends GuiNPCInterface2 {
    private JobHealer job;

    public GuiNpcHealer(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        this.job = (JobHealer)entityNPCInterface.jobInterface;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addLabel(new GuiNpcLabel(1, "Healing Speed:", this.guiLeft + 60, this.guiTop + 110, 0x404040));
        this.addTextField(new GuiNpcTextField(1, this, this.fontRenderer, this.guiLeft + 130, this.guiTop + 105, 40, 20, this.job.speed + ""));
        this.getTextField((int)1).numbersOnly = true;
        this.getTextField(1).setMinMaxDefault(1, 10, 8);
        this.addLabel(new GuiNpcLabel(2, "Range:", this.guiLeft + 60, this.guiTop + 133, 0x404040));
        this.addTextField(new GuiNpcTextField(2, this, this.fontRenderer, this.guiLeft + 130, this.guiTop + 128, 40, 20, this.job.range + ""));
        this.getTextField((int)2).numbersOnly = true;
        this.getTextField(2).setMinMaxDefault(2, 20, 5);
    }

    @Override
    public void elementClicked() {
    }

    @Override
    public void save() {
        this.job.speed = this.getTextField(1).getInteger();
        this.job.range = this.getTextField(2).getInteger();
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new NBTTagCompound()));
    }
}

