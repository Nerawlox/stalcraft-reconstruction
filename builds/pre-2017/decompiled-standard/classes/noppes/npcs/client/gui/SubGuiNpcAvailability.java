/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.function.Consumer;
import net.minecraft.client.xpzm;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiDialogAvailabilityRules;
import noppes.npcs.client.gui.GuiFactionAvailability;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.GuiSelectionListener;
import noppes.npcs.client.gui.util.GuiTimeRangesField;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.client.gui.util.SubGuiInterface;
import noppes.npcs.constants.EnumDayTime;
import noppes.npcs.controllers.Availability;

public class SubGuiNpcAvailability
extends SubGuiInterface
implements GuiSelectionListener,
ITextfieldListener {
    public gqjz parent2;
    private Availability availabitily;
    private boolean selectDialog = false;
    private boolean selectFaction = false;
    private int slot = 0;
    private Consumer<Availability> closeListener;

    public SubGuiNpcAvailability(Availability availability) {
        this.availabitily = availability;
        this.setBackground("menubg.png");
        this.xSize = 256;
        this.ySize = 216;
        this.closeOnEsc = true;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addLabel(new GuiNpcLabel(1, "availability.available", this.guiLeft, this.guiTop + 4, 0x404040));
        this.getLabel(1).center(this.xSize);
        this.addLabel(new GuiNpcLabel(50, "availability.daytime", this.guiLeft + 10, this.guiTop + 35, 0x404040));
        this.addTextField(new GuiTimeRangesField(52, (gqjz)this, this.field_73886_k, this.guiLeft + 70, this.guiTop + 30, 150, 20, this.availabitily.timeRanges));
        this.addLabel(new GuiNpcLabel(2, "(\u0432\u0440\u0435\u043c\u0435\u043d\u043d\u044b\u0435 \u043e\u0442\u0440\u0435\u0437\u043a\u0438 \u0432 24-\u0447\u0430\u0441\u043e\u0432\u043e\u043c \u0444\u043e\u0440\u043c\u0430\u0442\u0435 \u0447\u0435\u0440\u0435\u0437 ';')", this.guiLeft + 50, this.guiTop + 50, 0x404040));
        this.addButton(new GuiNpcButton(102, this.guiLeft + 70, this.guiTop + 70, 150, 20, "\u0423\u0441\u043b\u043e\u0432\u0438\u044f"));
        this.addButton(new GuiNpcButton(101, this.guiLeft + 70, this.guiTop + 100, 150, 20, "\u0421\u0442\u0430\u043b\u043a\u0435\u0440\u043e\u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438"));
        this.addButton(new GuiNpcButton(66, this.guiLeft + 82, this.guiTop + 180, 98, 20, "gui.done"));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)jiok2;
        if (jiok2.field_73741_f == 50) {
            this.availabitily.daytime = EnumDayTime.values()[guiNpcButton.getValue()];
        }
        if (jiok2.field_73741_f == 101) {
            this.field_73882_e._a(new GuiFactionAvailability(this.parent, this.availabitily));
        }
        if (jiok2.field_73741_f == 102) {
            this.field_73882_e._a(new GuiDialogAvailabilityRules(this.parent == null ? this : this.parent, this.npc, this.availabitily));
        }
        if (jiok2.field_73741_f == 66) {
            this.close();
            if (this.closeListener != null) {
                this.closeListener.accept(this.availabitily);
            }
            if (this.parent2 != null) {
                NoppesUtil.openGUI(this.player, this.parent2);
            } else if (this.parent == null) {
                xpzm._E()._o();
            }
        }
    }

    public SubGuiNpcAvailability setCloseListener(Consumer<Availability> consumer) {
        this.closeListener = consumer;
        return this;
    }

    @Override
    public void selected(int n) {
        this.selectDialog = false;
        this.selectFaction = false;
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 51) {
            this.availabitily.minPlayerLevel = guiNpcTextField.getInteger();
        }
    }
}

