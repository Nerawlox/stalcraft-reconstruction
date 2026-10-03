/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.constants.EnumPacketType;

public class GuiNPCTransportCategoryEdit
extends GuiNPCInterface {
    private gqjz parent;
    private String name;
    private int id;

    public GuiNPCTransportCategoryEdit(EntityNPCInterface entityNPCInterface, gqjz gqjz2, String string, int n) {
        super(entityNPCInterface);
        this.parent = gqjz2;
        this.name = string;
        this.id = n;
        this.title = "Npc Transport Category";
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addTextField(1, new GuiNpcTextField(1, this, this.field_73886_k, this.field_73880_f / 2 - 40, 100, 140, 20, this.name));
        this.addLabel(new GuiNpcLabel(1, "Title:", this.field_73880_f / 2 - 100 + 4, 105, 0xFFFFFF));
        this.addButton(2, new GuiNpcButton(2, this.field_73880_f / 2 - 100, 210, 98, 20, "gui.back"));
        this.addButton(3, new GuiNpcButton(3, this.field_73880_f / 2 + 2, 210, 98, 20, "Save"));
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 2) {
            NoppesUtil.openGUI(this.player, this.parent);
            NoppesUtil.sendData(EnumPacketType.TransportCategoriesGet, new Object[0]);
        }
        if (jiok2.field_73741_f == 3) {
            this.save();
            NoppesUtil.openGUI(this.player, this.parent);
            NoppesUtil.sendData(EnumPacketType.TransportCategoriesGet, new Object[0]);
        }
    }

    @Override
    public void save() {
        String string = this.getTextField(1).func_73781_b();
        if (!string.trim().isEmpty()) {
            NoppesUtil.sendData(EnumPacketType.TransportCategorySave, string, this.id);
        }
    }

    @Override
    public void func_73873_v_() {
        this.func_73871_c(0);
    }
}

