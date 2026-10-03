/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.client.gui.util.SubGuiInterface;
import noppes.npcs.controllers.Faction;

public class SubGuiNpcFactionPoints
extends SubGuiInterface
implements ITextfieldListener {
    private Faction faction;

    public SubGuiNpcFactionPoints(Faction faction) {
        this.faction = faction;
        this.setBackground("menubg.png");
        this.xSize = 256;
        this.ySize = 216;
        this.closeOnEsc = true;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addTextField(new GuiNpcTextField(2, this, this.field_73886_k, this.guiLeft + 48, this.guiTop + 48, 70, 20, this.faction.defaultPoints + ""));
        this.addLabel(new GuiNpcLabel(2, "faction.default", this.guiLeft + 8, this.guiTop + 48 + 5, 0x404040));
        this.getTextField(2).func_73804_f(6);
        this.getTextField((int)2).numbersOnly = true;
        this.addLabel(new GuiNpcLabel(3, "faction.unfriendly", this.guiLeft + 48, this.guiTop + 72, 0xFF0000));
        this.addTextField(new GuiNpcTextField(3, this, this.field_73886_k, this.guiLeft + 48, this.guiTop + 82, 70, 20, this.faction.neutralPoints + ""));
        this.addLabel(new GuiNpcLabel(4, "faction.neutral", this.guiLeft + 48, this.guiTop + 104, 0xF2FF00));
        this.addTextField(new GuiNpcTextField(4, this, this.field_73886_k, this.guiLeft + 48, this.guiTop + 114, 70, 20, this.faction.friendlyPoints + ""));
        this.addLabel(new GuiNpcLabel(5, "faction.friendly", this.guiLeft + 48, this.guiTop + 136, 65280));
        this.getTextField((int)3).numbersOnly = true;
        this.getTextField((int)4).numbersOnly = true;
        this.getLabel(3).center(70);
        this.getLabel(4).center(70);
        this.getLabel(5).center(70);
        this.addButton(new GuiNpcButton(66, this.guiLeft + 20, this.guiTop + 192, 90, 20, "gui.done"));
        this.addLabel(new GuiNpcLabel(6, "faction.unfriendly", this.guiLeft + 130, this.guiTop + 72, 0xFF0000));
        this.addTextField(new GuiNpcTextField(5, this, this.field_73886_k, this.guiLeft + 140, this.guiTop + 82, 70, 20, this.faction.neutralReputation + ""));
        this.addLabel(new GuiNpcLabel(7, "faction.neutral", this.guiLeft + 130, this.guiTop + 104, 0xF2FF00));
        this.addTextField(new GuiNpcTextField(6, this, this.field_73886_k, this.guiLeft + 140, this.guiTop + 114, 70, 20, this.faction.friendlyReputation + ""));
        this.addLabel(new GuiNpcLabel(8, "faction.friendly", this.guiLeft + 130, this.guiTop + 136, 65280));
        this.addTextField(new GuiNpcTextField(7, this, this.field_73886_k, this.guiLeft + 140, this.guiTop + 48, 70, 20, this.faction.reputationForKill + ""));
        this.addLabel(new GuiNpcLabel(9, "\u0420\u0435\u043f\u0443\u0442\u0430\u0446\u0438\u044f \u0437\u0430 \u0443\u0431\u0438\u0439\u0441\u0442\u0432\u043e", this.guiLeft + 118, this.guiTop + 36, 0xFFFFFF));
        this.getTextField((int)5).numbersOnly = true;
        this.getTextField((int)6).numbersOnly = true;
        this.getTextField((int)7).numbersOnly = true;
        this.getTextField((int)5).min = Integer.MIN_VALUE;
        this.getTextField((int)6).min = Integer.MIN_VALUE;
        this.getTextField((int)7).min = Integer.MIN_VALUE;
        this.getLabel(6).center(120);
        this.getLabel(7).center(120);
        this.getLabel(8).center(120);
        this.getLabel(9).center(120);
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 2) {
            this.faction.defaultPoints = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 3) {
            this.faction.neutralPoints = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 4) {
            this.faction.friendlyPoints = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 5) {
            this.faction.neutralReputation = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 6) {
            this.faction.friendlyReputation = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 7) {
            this.faction.reputationForKill = guiNpcTextField.getInteger();
        }
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 66) {
            this.close();
        }
    }
}

