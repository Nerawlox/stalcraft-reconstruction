/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import net.minecraft.client.gui.GuiButton;
import noppes.npcs.DataStats;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNpcSoundSelection;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.client.gui.util.NpcTextFieldDecimal;
import noppes.npcs.client.gui.util.SubGuiInterface;

public class SubGuiNpcRangeProperties
extends SubGuiInterface
implements ITextfieldListener {
    private DataStats stats;
    private GuiNpcSoundSelection gui;

    public SubGuiNpcRangeProperties(DataStats dataStats) {
        this.stats = dataStats;
        this.setBackground("menubg.png");
        this.xSize = 256;
        this.ySize = 216;
        this.closeOnEsc = true;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addLabel(new GuiNpcLabel(1, "stats.accuracy", this.guiLeft + 8, this.guiTop + 11, 0x404040));
        this.addTextField(new NpcTextFieldDecimal(1, this, this.fontRenderer, this.guiLeft + 85, this.guiTop + 6, 50, 18, String.valueOf(this.stats.accuracy)));
        this.getTextField((int)1).numbersOnly = true;
        this.getTextField(1).setMinMaxDefault(0, 100, 90);
        this.addLabel(new GuiNpcLabel(2, "stats.rangedrange", this.guiLeft + 8, this.guiTop + 35, 0x404040));
        this.addTextField(new GuiNpcTextField(2, this, this.fontRenderer, this.guiLeft + 85, this.guiTop + 30, 50, 18, this.stats.rangedRange + ""));
        this.getTextField((int)2).numbersOnly = true;
        this.getTextField(2).setMinMaxDefault(1, 64, 2);
        this.addLabel(new GuiNpcLabel(3, "stats.firedelay", this.guiLeft + 8, this.guiTop + 59, 0x404040));
        this.addTextField(new GuiNpcTextField(3, this, this.fontRenderer, this.guiLeft + 85, this.guiTop + 54, 50, 18, this.stats.fireDelay + ""));
        this.getTextField((int)3).numbersOnly = true;
        this.getTextField(3).setMinMaxDefault(1, 1000, 20);
        this.addLabel(new GuiNpcLabel(4, "stats.delayvariance", this.guiLeft + 8, this.guiTop + 83, 0x404040));
        this.addTextField(new GuiNpcTextField(4, this, this.fontRenderer, this.guiLeft + 85, this.guiTop + 78, 50, 18, this.stats.delayVariance + ""));
        this.getTextField((int)4).numbersOnly = true;
        this.getTextField(4).setMinMaxDefault(0, 1000, 20);
        this.addLabel(new GuiNpcLabel(5, "stats.burstspeed", this.guiLeft + 8, this.guiTop + 107, 0x404040));
        this.addTextField(new GuiNpcTextField(5, this, this.fontRenderer, this.guiLeft + 85, this.guiTop + 102, 50, 18, this.stats.fireRate + ""));
        this.getTextField((int)5).numbersOnly = true;
        this.getTextField(5).setMinMaxDefault(0, 100, 0);
        this.addLabel(new GuiNpcLabel(6, "stats.burstcount", this.guiLeft + 8, this.guiTop + 131, 0x404040));
        this.addTextField(new GuiNpcTextField(6, this, this.fontRenderer, this.guiLeft + 85, this.guiTop + 126, 50, 18, this.stats.burstCount + ""));
        this.getTextField((int)6).numbersOnly = true;
        this.getTextField(6).setMinMaxDefault(1, 1000, 20);
        this.addLabel(new GuiNpcLabel(7, "\u0428\u0430\u043d\u0441 \u043a\u0440\u043e\u0432\u043e\u0442\u0435\u0447\u0435\u043d\u0438\u044f:", this.guiLeft + 8, this.guiTop + 155, 0x404040));
        this.addTextField(new NpcTextFieldDecimal(7, this, this.fontRenderer, this.guiLeft + 85, this.guiTop + 150, 50, 20, String.valueOf(this.stats.bleedingChance)));
        this.getTextField((int)7).numbersOnly = true;
        this.getTextField(7).setMinMaxDefault(0, 100, 5);
        this.addLabel(new GuiNpcLabel(8, "\u0423\u0440\u043e\u043d", this.guiLeft + 155, this.guiTop + 11, 0x404040));
        this.addTextField(new GuiNpcTextField(8, this, this.fontRenderer, this.guiLeft + 195, this.guiTop + 6, 50, 18, String.valueOf(this.stats.pDamage)));
        this.getTextField((int)8).numbersOnly = true;
        this.getTextField(8).setMinMaxDefault(0, 9999, 5);
        this.addLabel(new GuiNpcLabel(9, "\u041f\u043e\u0442\u0435\u0440\u044f", this.guiLeft + 155, this.guiTop + 35, 0x404040));
        this.addTextField(new NpcTextFieldDecimal(9, this, this.fontRenderer, this.guiLeft + 195, this.guiTop + 30, 50, 18, String.valueOf(this.stats.damageLoss)));
        this.getTextField((int)9).numbersOnly = true;
        this.getTextField(9).setMinMaxDefault(0, 100, 0);
        this.addButton(new GuiNpcButton(66, this.guiLeft + 190, this.guiTop + 190, 60, 20, "gui.done"));
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 1) {
            this.stats.accuracy = ((NpcTextFieldDecimal)guiNpcTextField).getDouble();
        } else if (guiNpcTextField.id == 2) {
            this.stats.rangedRange = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 3) {
            this.stats.fireDelay = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 4) {
            this.stats.delayVariance = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 5) {
            this.stats.fireRate = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 6) {
            this.stats.burstCount = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 7) {
            this.stats.bleedingChance = ((NpcTextFieldDecimal)guiNpcTextField).getDouble();
        } else if (guiNpcTextField.id == 8) {
            this.stats.pDamage = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 9) {
            this.stats.damageLoss = ((NpcTextFieldDecimal)guiNpcTextField).getDouble();
        }
    }

    @Override
    public void elementClicked() {
        this.getTextField(7).setText(this.gui.getSelected());
        this.unFocused(this.getTextField(7));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 7) {
            this.gui = new GuiNpcSoundSelection(this.npc, this.parent, this.getTextField(7).getText());
            NoppesUtil.openGUI(this.player, this.gui);
        }
        if (guiButton.id == 66) {
            this.close();
        }
    }
}

