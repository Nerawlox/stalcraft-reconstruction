/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNpcMobSpawnerSelector;
import noppes.npcs.client.gui.GuiNpcMusicSelection;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.client.gui.util.SubGuiInterface;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.roles.JobSpawner;

public class GuiNpcSpawner
extends GuiNPCInterface2
implements ITextfieldListener {
    private JobSpawner job;
    private GuiNpcMusicSelection gui;
    private int slot = -1;

    public GuiNpcSpawner(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        this.job = (JobSpawner)entityNPCInterface.jobInterface;
    }

    @Override
    public void initGui() {
        super.initGui();
        int n = this.guiTop + 6;
        this.addButton(new GuiNpcButton(20, this.guiLeft + 25, n, 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(0, "1:", this.guiLeft + 4, n + 5, 0x404040));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 50, n, this.getTitle(this.job.compound1)));
        this.addButton(new GuiNpcButton(21, this.guiLeft + 25, n += 23, 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(1, "2:", this.guiLeft + 4, n + 5, 0x404040));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 50, n, this.getTitle(this.job.compound2)));
        this.addButton(new GuiNpcButton(22, this.guiLeft + 25, n += 23, 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(2, "3:", this.guiLeft + 4, n + 5, 0x404040));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 50, n, this.getTitle(this.job.compound3)));
        this.addButton(new GuiNpcButton(23, this.guiLeft + 25, n += 23, 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(3, "4:", this.guiLeft + 4, n + 5, 0x404040));
        this.addButton(new GuiNpcButton(3, this.guiLeft + 50, n, this.getTitle(this.job.compound4)));
        this.addButton(new GuiNpcButton(24, this.guiLeft + 25, n += 23, 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(4, "5:", this.guiLeft + 4, n + 5, 0x404040));
        this.addButton(new GuiNpcButton(4, this.guiLeft + 50, n, this.getTitle(this.job.compound5)));
        this.addButton(new GuiNpcButton(25, this.guiLeft + 25, n += 23, 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(5, "6:", this.guiLeft + 4, n + 5, 0x404040));
        this.addButton(new GuiNpcButton(5, this.guiLeft + 50, n, this.getTitle(this.job.compound6)));
        this.addLabel(new GuiNpcLabel(6, "Dies after spawning", this.guiLeft + 4, (n += 23) + 5, 0x404040));
        this.addButton(new GuiNpcButton(26, this.guiLeft + 75, n, 40, 20, new String[]{"gui.yes", "gui.no"}, this.job.doesntDie ? 1 : 0));
        this.addLabel(new GuiNpcLabel(7, "Position Offset X:", this.guiLeft + 4, (n += 23) + 5, 0x404040));
        this.addTextField(new GuiNpcTextField(7, this, this.fontRenderer, this.guiLeft + 99, n, 24, 20, this.job.xOffset + ""));
        this.getTextField((int)7).numbersOnly = true;
        this.getTextField(7).setMinMaxDefault(-9, 9, 0);
        this.addLabel(new GuiNpcLabel(8, "Y:", this.guiLeft + 125, n + 5, 0x404040));
        this.addTextField(new GuiNpcTextField(8, this, this.fontRenderer, this.guiLeft + 135, n, 24, 20, this.job.yOffset + ""));
        this.getTextField((int)8).numbersOnly = true;
        this.getTextField(8).setMinMaxDefault(-9, 9, 0);
        this.addLabel(new GuiNpcLabel(9, "Z:", this.guiLeft + 161, n + 5, 0x404040));
        this.addTextField(new GuiNpcTextField(9, this, this.fontRenderer, this.guiLeft + 171, n, 24, 20, this.job.zOffset + ""));
        this.getTextField((int)9).numbersOnly = true;
        this.getTextField(9).setMinMaxDefault(-9, 9, 0);
        this.addLabel(new GuiNpcLabel(10, "SpawnType", this.guiLeft + 4, (n += 23) + 5, 0x404040));
        this.addButton(new GuiNpcButton(10, this.guiLeft + 80, n, 100, 20, new String[]{"One by One", "All", "Random"}, this.job.spawnType));
    }

    private String getTitle(NBTTagCompound nBTTagCompound) {
        return nBTTagCompound != null && nBTTagCompound._c("ClonedName") ? nBTTagCompound._j("ClonedName") : "gui.selectnpc";
    }

    @Override
    public void elementClicked() {
        this.gui.getSelected();
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)guiButton;
        if (guiNpcButton.id >= 0 && guiNpcButton.id < 6) {
            this.slot = guiNpcButton.id + 1;
            this.setSubGui(new GuiNpcMobSpawnerSelector());
        }
        if (guiNpcButton.id >= 20 && guiNpcButton.id < 26) {
            this.job.setJobCompound(guiNpcButton.id - 19, null);
            this.initGui();
        }
        if (guiNpcButton.id == 26) {
            boolean bl = this.job.doesntDie = guiNpcButton.getValue() == 1;
        }
        if (guiNpcButton.id == 10) {
            this.job.spawnType = guiNpcButton.getValue();
        }
    }

    @Override
    public void closeSubGui(SubGuiInterface subGuiInterface) {
        super.closeSubGui(subGuiInterface);
        NBTTagCompound nBTTagCompound = ((GuiNpcMobSpawnerSelector)subGuiInterface).getCompound();
        if (nBTTagCompound != null) {
            this.job.setJobCompound(this.slot, nBTTagCompound);
        }
        this.initGui();
    }

    @Override
    public void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 7) {
            this.job.xOffset = guiNpcTextField.getInteger();
        }
        if (guiNpcTextField.id == 8) {
            this.job.yOffset = guiNpcTextField.getInteger();
        }
        if (guiNpcTextField.id == 9) {
            this.job.zOffset = guiNpcTextField.getInteger();
        }
    }
}

