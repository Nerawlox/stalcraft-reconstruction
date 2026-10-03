/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.global;

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

public class GuiNPCQuestSelection
extends GuiNPCInterface
implements IScrollData {
    public GuiSelectionListener listener;
    private GuiNPCStringSlot slot;
    private gqjz parent;
    private HashMap data;
    private boolean selectCategory = true;
    private int quest;

    public GuiNPCQuestSelection(EntityNPCInterface entityNPCInterface, gqjz gqjz2, int n) {
        super(entityNPCInterface);
        this.drawDefaultBackground = false;
        this.title = "Select Quest Category";
        this.parent = gqjz2;
        this.data = new HashMap();
        this.quest = n;
        if (n >= 0) {
            NoppesUtil.sendData(EnumPacketType.QuestsGetFromQuest, n);
            this.selectCategory = false;
            this.title = "Select Dialog";
        } else {
            NoppesUtil.sendData(EnumPacketType.QuestCategoriesGet, n);
        }
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
            if (this.selectCategory) {
                this.close();
                NoppesUtil.openGUI(this.player, this.parent);
            } else {
                this.title = "Select Dialog Category";
                this.selectCategory = true;
                NoppesUtil.sendData(EnumPacketType.QuestCategoriesGet, this.quest);
            }
        }
        if (jiok2.field_73741_f == 4) {
            if (this.slot.selected == null || this.slot.selected.isEmpty()) {
                return;
            }
            this.doubleClicked();
        }
    }

    public String getSelected() {
        return this.slot.selected;
    }

    @Override
    public void setSelected(String string) {
    }

    @Override
    public void doubleClicked() {
        if (this.slot.selected != null && !this.slot.selected.isEmpty()) {
            if (this.selectCategory) {
                this.selectCategory = false;
                this.title = "Select Quest";
                NoppesUtil.sendData(EnumPacketType.QuestsGet, this.data.get(this.slot.selected));
            } else {
                this.quest = (Integer)this.data.get(this.slot.selected);
                this.close();
                NoppesUtil.openGUI(this.player, this.parent);
            }
        }
    }

    @Override
    public void save() {
        if (this.quest >= 0 && this.listener != null) {
            this.listener.selected(this.quest);
        }
    }

    @Override
    public void setData(Vector vector, HashMap hashMap) {
        this.data = hashMap;
        this.slot.setList(vector);
        if (this.quest >= 0) {
            for (String string : hashMap.keySet()) {
                if ((Integer)hashMap.get(string) != this.quest) continue;
                this.slot.selected = string;
            }
        }
    }
}

