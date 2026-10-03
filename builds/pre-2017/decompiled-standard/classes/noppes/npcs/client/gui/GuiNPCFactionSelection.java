/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.HashMap;
import java.util.Vector;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNPCStringSlot;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiSelectionListener;
import noppes.npcs.client.gui.util.IScrollData;
import noppes.npcs.constants.EnumPacketType;

public class GuiNPCFactionSelection
extends GuiNPCInterface
implements IScrollData {
    public GuiSelectionListener listener;
    private GuiNPCStringSlot slot;
    private gqjz parent;
    private HashMap data = new HashMap();
    private int dialog;

    public GuiNPCFactionSelection(EntityNPCInterface entityNPCInterface, gqjz gqjz2, int n) {
        super(entityNPCInterface);
        this.drawDefaultBackground = false;
        this.title = "Select Dialog Category";
        this.parent = gqjz2;
        this.dialog = n;
        NoppesUtil.sendData(EnumPacketType.FactionsGet, new Object[0]);
        if (gqjz2 instanceof GuiSelectionListener) {
            this.listener = (GuiSelectionListener)((Object)gqjz2);
        }
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        Vector vector = new Vector();
        this.slot = new GuiNPCStringSlot(vector, this, this.npc, false, 18);
        this.slot.func_77220_a(4, 5);
        this.addButton(2, new GuiNpcButton(2, this.field_73880_f / 2 - 100, this.field_73881_g - 41, 98, 20, "gui.back"));
        this.addButton(4, new GuiNpcButton(4, this.field_73880_f / 2 + 2, this.field_73881_g - 41, 98, 20, "mco.template.button.select"));
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.slot.func_77211_a(n, n2, f);
        super.func_73863_a(n, n2, f);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 2) {
            this.close();
            NoppesUtil.openGUI(this.player, this.parent);
        }
        if (jiok2.field_73741_f == 4) {
            this.doubleClicked();
        }
    }

    @Override
    public void doubleClicked() {
        if (this.slot.selected != null && !this.slot.selected.isEmpty()) {
            this.dialog = (Integer)this.data.get(this.slot.selected);
            this.close();
            NoppesUtil.openGUI(this.player, this.parent);
        }
    }

    @Override
    public void save() {
        if (this.dialog >= 0 && this.listener != null) {
            this.listener.selected(this.dialog);
        }
    }

    @Override
    public void setData(Vector vector, HashMap hashMap) {
        this.data = hashMap;
        this.slot.setList(vector);
        if (this.dialog >= 0) {
            for (String string : hashMap.keySet()) {
                if ((Integer)hashMap.get(string) != this.dialog) continue;
                this.slot.selected = string;
            }
        }
    }

    @Override
    public void setSelected(String string) {
    }
}

