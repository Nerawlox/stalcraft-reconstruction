/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNpcMobSpawnerSelector;
import noppes.npcs.client.gui.GuiNpcMusicSelection;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.SubGuiInterface;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.roles.JobBoss;

public class GuiNpcBoss
extends GuiNPCInterface2 {
    private JobBoss job;
    private GuiNpcMusicSelection gui;
    private int slot = -1;

    public GuiNpcBoss(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        this.job = (JobBoss)entityNPCInterface.jobInterface;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addLabel(new GuiNpcLabel(40, "Show name", this.guiLeft + 300, this.guiTop + 25, 0x404040));
        this.addButton(new GuiNpcButton(40, this.guiLeft + 355, this.guiTop + 20, 40, 20, new String[]{"gui.no", "gui.yes"}, this.job.hideName ? 0 : 1));
        int n = 6;
        this.addButton(new GuiNpcButton(20, this.guiLeft + 55, this.guiTop + n, 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(0, "90%", this.guiLeft + 4, this.guiTop + n + 5, 0x404040));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 80, this.guiTop + n, this.getTitle(this.job.compound9)));
        int n2 = n + 23;
        this.addButton(new GuiNpcButton(21, this.guiLeft + 55, this.guiTop + n2, 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(1, "80%", this.guiLeft + 4, this.guiTop + n2 + 5, 0x404040));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 80, this.guiTop + n2, this.getTitle(this.job.compound8)));
        this.addButton(new GuiNpcButton(22, this.guiLeft + 55, this.guiTop + (n2 += 23), 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(2, "70%", this.guiLeft + 4, this.guiTop + n2 + 5, 0x404040));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 80, this.guiTop + n2, this.getTitle(this.job.compound7)));
        this.addButton(new GuiNpcButton(23, this.guiLeft + 55, this.guiTop + (n2 += 23), 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(3, "60%", this.guiLeft + 4, this.guiTop + n2 + 5, 0x404040));
        this.addButton(new GuiNpcButton(3, this.guiLeft + 80, this.guiTop + n2, this.getTitle(this.job.compound6)));
        this.addButton(new GuiNpcButton(24, this.guiLeft + 55, this.guiTop + (n2 += 23), 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(4, "50%", this.guiLeft + 4, this.guiTop + n2 + 5, 0x404040));
        this.addButton(new GuiNpcButton(4, this.guiLeft + 80, this.guiTop + n2, this.getTitle(this.job.compound5)));
        this.addButton(new GuiNpcButton(25, this.guiLeft + 55, this.guiTop + (n2 += 23), 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(5, "40%", this.guiLeft + 4, this.guiTop + n2 + 5, 0x404040));
        this.addButton(new GuiNpcButton(5, this.guiLeft + 80, this.guiTop + n2, this.getTitle(this.job.compound4)));
        this.addButton(new GuiNpcButton(26, this.guiLeft + 55, this.guiTop + (n2 += 23), 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(6, "30%", this.guiLeft + 4, this.guiTop + n2 + 5, 0x404040));
        this.addButton(new GuiNpcButton(6, this.guiLeft + 80, this.guiTop + n2, this.getTitle(this.job.compound3)));
        this.addButton(new GuiNpcButton(27, this.guiLeft + 55, this.guiTop + (n2 += 23), 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(7, "20%", this.guiLeft + 4, this.guiTop + n2 + 5, 0x404040));
        this.addButton(new GuiNpcButton(7, this.guiLeft + 80, this.guiTop + n2, this.getTitle(this.job.compound2)));
        this.addButton(new GuiNpcButton(28, this.guiLeft + 55, this.guiTop + (n2 += 23), 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(8, "10%", this.guiLeft + 4, this.guiTop + n2 + 5, 0x404040));
        this.addButton(new GuiNpcButton(8, this.guiLeft + 80, this.guiTop + n2, this.getTitle(this.job.compound1)));
    }

    private String getTitle(qoac qoac2) {
        return qoac2 != null && qoac2._c("ClonedName") ? qoac2._j("ClonedName") : "gui.selectnpc";
    }

    @Override
    public void elementClicked() {
        this.gui.getSelected();
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)jiok2;
        if (guiNpcButton.field_73741_f >= 0 && guiNpcButton.field_73741_f < 9) {
            this.slot = 9 - guiNpcButton.field_73741_f;
            this.setSubGui(new GuiNpcMobSpawnerSelector());
        }
        if (guiNpcButton.field_73741_f >= 20 && guiNpcButton.field_73741_f < 29) {
            this.job.setNBT(29 - guiNpcButton.field_73741_f, null);
            this.func_73866_w_();
        }
        if (guiNpcButton.field_73741_f == 40) {
            this.job.hideName = guiNpcButton.getValue() == 0;
        }
    }

    @Override
    public void closeSubGui(SubGuiInterface subGuiInterface) {
        super.closeSubGui(subGuiInterface);
        qoac qoac2 = ((GuiNpcMobSpawnerSelector)subGuiInterface).getCompound();
        if (qoac2 != null) {
            this.job.setNBT(this.slot, qoac2);
        }
        this.func_73866_w_();
    }

    @Override
    public void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new qoac()));
    }
}

