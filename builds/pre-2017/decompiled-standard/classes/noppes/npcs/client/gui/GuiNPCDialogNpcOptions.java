/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.HashMap;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNPCDialogSelection;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiSelectionListener;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.DialogOption;

public class GuiNPCDialogNpcOptions
extends GuiNPCInterface2
implements GuiSelectionListener,
IGuiData {
    private gqjz parent;
    private HashMap data = new HashMap();
    private int selectedSlot;

    public GuiNPCDialogNpcOptions(EntityNPCInterface entityNPCInterface, gqjz gqjz2) {
        super(entityNPCInterface);
        this.parent = gqjz2;
        this.drawDefaultBackground = true;
        NoppesUtil.sendData(EnumPacketType.DialogNpcGet, new Object[0]);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        for (int i = 0; i < 12; ++i) {
            int n = i >= 6 ? 200 : 0;
            this.addButton(new GuiNpcButton(i + 20, this.guiLeft + 20 + n, this.guiTop + 13 + i % 6 * 22, 20, 20, "X"));
            this.addLabel(new GuiNpcLabel(i, "" + i, this.guiLeft + 6 + n, this.guiTop + 18 + i % 6 * 22, 0));
            String string = "dialog.selectoption";
            if (this.data.containsKey(i)) {
                string = ((DialogOption)this.data.get((Object)Integer.valueOf((int)i))).title;
            }
            this.addButton(new GuiNpcButton(i, this.guiLeft + 44 + n, this.guiTop + 13 + i % 6 * 22, 140, 20, string));
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        int n;
        if (jiok2.field_73741_f == 1) {
            NoppesUtil.openGUI(this.player, this.parent);
        }
        if (jiok2.field_73741_f >= 0 && jiok2.field_73741_f < 20) {
            this.close();
            this.selectedSlot = jiok2.field_73741_f;
            n = -1;
            if (this.data.containsKey(jiok2.field_73741_f)) {
                n = ((DialogOption)this.data.get((Object)Integer.valueOf((int)jiok2.field_73741_f))).dialogId;
            }
            NoppesUtil.openGUI(this.player, new GuiNPCDialogSelection(this.npc, this, n));
        }
        if (jiok2.field_73741_f >= 20 && jiok2.field_73741_f < 40) {
            n = jiok2.field_73741_f - 20;
            this.data.remove(n);
            NoppesUtil.sendData(EnumPacketType.DialogNpcRemove, n);
            this.func_73866_w_();
        }
    }

    @Override
    public void save() {
    }

    @Override
    public void selected(int n) {
        NoppesUtil.sendData(EnumPacketType.DialogNpcSet, this.selectedSlot, n);
    }

    @Override
    public void setGuiData(qoac qoac2) {
        int n = qoac2._f("Position");
        DialogOption dialogOption = new DialogOption();
        dialogOption.readNBT(qoac2);
        this.data.put(n, dialogOption);
        this.func_73866_w_();
    }
}

