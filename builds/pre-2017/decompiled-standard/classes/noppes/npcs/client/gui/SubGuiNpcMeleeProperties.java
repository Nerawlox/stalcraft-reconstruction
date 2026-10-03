/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import noppes.npcs.DataStats;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.client.gui.util.SubGuiInterface;
import noppes.npcs.constants.EnumPotionType;

public class SubGuiNpcMeleeProperties
extends SubGuiInterface
implements ITextfieldListener {
    private DataStats stats;
    private String[] potionNames = new String[]{"gui.none", "tile.fire.name", "potion.poison", "potion.hunger", "potion.weakness", "potion.moveSlowdown", "potion.confusion", "potion.blindness", "potion.wither"};

    public SubGuiNpcMeleeProperties(DataStats dataStats) {
        this.stats = dataStats;
        this.setBackground("menubg.png");
        this.xSize = 256;
        this.ySize = 216;
        this.closeOnEsc = true;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addLabel(new GuiNpcLabel(1, "stats.meleestrength", this.guiLeft + 5, this.guiTop + 15, 0x404040));
        this.addTextField(new GuiNpcTextField(1, this, this.field_73886_k, this.guiLeft + 85, this.guiTop + 10, 50, 18, this.stats.attackStrength + ""));
        this.getTextField((int)1).numbersOnly = true;
        this.getTextField(1).setMinMaxDefault(0, 99999, 5);
        this.addLabel(new GuiNpcLabel(2, "stats.meleerange", this.guiLeft + 5, this.guiTop + 45, 0x404040));
        this.addTextField(new GuiNpcTextField(2, this, this.field_73886_k, this.guiLeft + 85, this.guiTop + 40, 50, 18, this.stats.attackRange + ""));
        this.getTextField((int)2).numbersOnly = true;
        this.getTextField(2).setMinMaxDefault(1, 30, 2);
        this.addLabel(new GuiNpcLabel(3, "stats.meleespeed", this.guiLeft + 5, this.guiTop + 75, 0x404040));
        this.addTextField(new GuiNpcTextField(3, this, this.field_73886_k, this.guiLeft + 85, this.guiTop + 70, 50, 18, this.stats.attackSpeed + ""));
        this.getTextField((int)3).numbersOnly = true;
        this.getTextField(3).setMinMaxDefault(1, 1000, 20);
        this.addLabel(new GuiNpcLabel(4, "enchantment.knockback", this.guiLeft + 5, this.guiTop + 105, 0x404040));
        this.addTextField(new GuiNpcTextField(4, this, this.field_73886_k, this.guiLeft + 85, this.guiTop + 100, 50, 18, this.stats.knockback + ""));
        this.getTextField((int)4).numbersOnly = true;
        this.getTextField(4).setMinMaxDefault(0, 4, 0);
        this.addLabel(new GuiNpcLabel(5, "stats.meleeeffect", this.guiLeft + 5, this.guiTop + 135, 0x404040));
        this.addButton(new GuiNpcButton(5, this.guiLeft + 85, this.guiTop + 130, 52, 20, this.potionNames, this.stats.potionType.ordinal()));
        if (this.stats.potionType != EnumPotionType.None) {
            this.addLabel(new GuiNpcLabel(6, "gui.time", this.guiLeft + 5, this.guiTop + 165, 0x404040));
            this.addTextField(new GuiNpcTextField(6, this, this.field_73886_k, this.guiLeft + 85, this.guiTop + 160, 50, 18, this.stats.potionDuration + ""));
            this.getTextField((int)6).numbersOnly = true;
            this.getTextField(6).setMinMaxDefault(1, 99999, 5);
            if (this.stats.potionType != EnumPotionType.Fire) {
                this.addLabel(new GuiNpcLabel(7, "stats.amplify", this.guiLeft + 5, this.guiTop + 195, 0x404040));
                this.addButton(new GuiNpcButton(7, this.guiLeft + 85, this.guiTop + 190, 52, 20, new String[]{"gui.no", "gui.yes"}, this.stats.potionAmp));
            }
        }
        this.addButton(new GuiNpcButton(66, this.guiLeft + 165, this.guiTop + 192, 90, 20, "gui.done"));
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 1) {
            this.stats.attackStrength = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 2) {
            this.stats.attackRange = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 3) {
            this.stats.attackSpeed = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 4) {
            this.stats.knockback = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 6) {
            this.stats.potionDuration = guiNpcTextField.getInteger();
        }
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)jiok2;
        if (guiNpcButton.field_73741_f == 5) {
            this.stats.potionType = EnumPotionType.values()[guiNpcButton.getValue()];
            this.func_73866_w_();
        }
        if (guiNpcButton.field_73741_f == 7) {
            this.stats.potionAmp = guiNpcButton.getValue();
        }
        if (jiok2.field_73741_f == 66) {
            this.close();
        }
    }
}

