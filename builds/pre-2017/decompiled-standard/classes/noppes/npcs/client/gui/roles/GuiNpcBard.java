/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.controllers.MusicController;
import noppes.npcs.client.gui.GuiNpcMusicSelection;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.roles.JobBard;

public class GuiNpcBard
extends GuiNPCInterface2 {
    private JobBard job;
    private GuiNpcMusicSelection gui;

    public GuiNpcBard(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        this.job = (JobBard)entityNPCInterface.jobInterface;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addButton(new GuiNpcButton(1, this.guiLeft + 55, this.guiTop + 15, 20, 20, "X"));
        this.addLabel(new GuiNpcLabel(0, this.job.song, this.guiLeft + 80, this.guiTop + 20, 0x404040));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 75, this.guiTop + 50, "Select Music"));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 75, this.guiTop + 71, new String[]{"None", "Banjo", "Violin", "Guitar", "Harp"}, this.job.getInstrument().ordinal()));
        this.addButton(new GuiNpcButton(3, this.guiLeft + 75, this.guiTop + 92, new String[]{"Play in background", "Play as jukebox"}, this.job.isStreamer ? 1 : 0));
        this.addLabel(new GuiNpcLabel(2, "On Distance:", this.guiLeft + 60, this.guiTop + 143, 0x404040));
        this.addTextField(new GuiNpcTextField(2, this, this.field_73886_k, this.guiLeft + 130, this.guiTop + 138, 40, 20, this.job.minRange + ""));
        this.getTextField((int)2).numbersOnly = true;
        this.getTextField(2).setMinMaxDefault(2, 64, 5);
        this.addLabel(new GuiNpcLabel(3, "Off Distance:", this.guiLeft + 60, this.guiTop + 166, 0x404040));
        this.addTextField(new GuiNpcTextField(3, this, this.field_73886_k, this.guiLeft + 130, this.guiTop + 161, 40, 20, this.job.maxRange + ""));
        this.getTextField((int)3).numbersOnly = true;
        this.getTextField(3).setMinMaxDefault(2, 64, 10);
        this.getLabel((int)3).enabled = this.job.isStreamer;
        this.getTextField((int)3).enabled = this.job.isStreamer;
    }

    @Override
    public void elementClicked() {
        this.job.song = this.gui.getSelected();
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)jiok2;
        if (jiok2.field_73741_f == 0) {
            this.gui = new GuiNpcMusicSelection(this.npc, this, this.job.song);
            NoppesUtil.openGUI(this.player, this.gui);
            this.job.song = "";
            MusicController.Instance.stopMusic();
        }
        if (jiok2.field_73741_f == 1) {
            this.job.song = "";
            this.getLabel((int)0).label = "";
            MusicController.Instance.stopMusic();
        }
        if (jiok2.field_73741_f == 2) {
            this.job.setInstrument(guiNpcButton.getValue());
        }
        if (jiok2.field_73741_f == 3) {
            this.getLabel((int)3).enabled = this.job.isStreamer = guiNpcButton.getValue() == 1;
            this.getTextField((int)3).enabled = this.job.isStreamer;
        }
    }

    @Override
    public void save() {
        this.job.minRange = this.getTextField(2).getInteger();
        this.job.maxRange = this.getTextField(3).getInteger();
        if (this.job.minRange > this.job.maxRange) {
            this.job.maxRange = this.job.minRange;
        }
        MusicController.Instance.stopMusic();
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new qoac()));
    }
}

