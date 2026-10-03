/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.global;

import java.util.HashMap;
import java.util.Vector;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNPCTransportCategoryEdit;
import noppes.npcs.client.gui.mainmenu.GuiNPCGlobalMainMenu;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNPCStringSlot;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.IScrollData;
import noppes.npcs.constants.EnumPacketType;

public class GuiNPCManageTransporters
extends GuiNPCInterface
implements IScrollData {
    private GuiNPCStringSlot slot;
    private HashMap data;
    private boolean selectCategory = true;

    public GuiNPCManageTransporters(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        NoppesUtil.sendData(EnumPacketType.TransportCategoriesGet, new Object[0]);
        this.drawDefaultBackground = false;
        this.title = "Transport Categories";
        this.data = new HashMap();
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        Vector vector = new Vector();
        this.slot = new GuiNPCStringSlot(vector, this, this.npc, false, 18);
        this.slot.func_77220_a(4, 5);
        this.addButton(0, new GuiNpcButton(0, this.field_73880_f / 2 - 100, this.field_73881_g - 52, 65, 20, "gui.add"));
        this.addButton(1, new GuiNpcButton(1, this.field_73880_f / 2 - 33, this.field_73881_g - 52, 65, 20, "selectServer.edit"));
        this.getButton((int)0).field_73742_g = this.selectCategory;
        this.getButton((int)1).field_73742_g = this.selectCategory;
        this.addButton(3, new GuiNpcButton(3, this.field_73880_f / 2 + 33, this.field_73881_g - 52, 65, 20, "gui.remove"));
        this.addButton(2, new GuiNpcButton(2, this.field_73880_f / 2 - 100, this.field_73881_g - 31, 98, 20, "gui.open"));
        this.getButton((int)2).field_73742_g = this.selectCategory;
        this.addButton(4, new GuiNpcButton(4, this.field_73880_f / 2 + 2, this.field_73881_g - 31, 98, 20, "gui.back"));
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.slot.func_77211_a(n, n2, f);
        super.func_73863_a(n, n2, f);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 0 && this.selectCategory) {
            NoppesUtil.openGUI(this.player, new GuiNPCTransportCategoryEdit(this.npc, this, "", -1));
        }
        if (jiok2.field_73741_f == 1) {
            if (this.slot.selected == null || this.slot.selected.isEmpty()) {
                return;
            }
            if (this.selectCategory) {
                NoppesUtil.openGUI(this.player, new GuiNPCTransportCategoryEdit(this.npc, this, this.slot.selected, (Integer)this.data.get(this.slot.selected)));
            }
        }
        if (jiok2.field_73741_f == 4) {
            if (this.selectCategory) {
                this.close();
                NoppesUtil.openGUI(this.player, new GuiNPCGlobalMainMenu(this.npc));
            } else {
                this.title = "Transport Categories";
                this.selectCategory = true;
                NoppesUtil.sendData(EnumPacketType.TransportCategoriesGet, new Object[0]);
                this.func_73866_w_();
            }
        }
        if (jiok2.field_73741_f == 3) {
            if (this.slot.selected == null || this.slot.selected.isEmpty()) {
                return;
            }
            this.save();
            if (this.selectCategory) {
                NoppesUtil.sendData(EnumPacketType.TransportCategoryRemove, this.data.get(this.slot.selected));
            } else {
                NoppesUtil.sendData(EnumPacketType.TransportRemove, this.data.get(this.slot.selected));
            }
            this.func_73866_w_();
        }
        if (jiok2.field_73741_f == 2) {
            this.doubleClicked();
        }
    }

    @Override
    public void doubleClicked() {
        if (this.slot.selected != null && !this.slot.selected.isEmpty() && this.selectCategory) {
            this.selectCategory = false;
            this.title = "TransportLocations";
            NoppesUtil.sendData(EnumPacketType.TransportsGet, this.data.get(this.slot.selected));
            this.func_73866_w_();
        }
    }

    @Override
    public void save() {
    }

    @Override
    public void setData(Vector vector, HashMap hashMap) {
        this.data = hashMap;
        this.slot.setList(vector);
    }

    @Override
    public void setSelected(String string) {
    }
}

