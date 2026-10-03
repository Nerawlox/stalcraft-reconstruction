/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import noppes.npcs.blocks.TileWaypoint;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.constants.EnumPacketType;

public class GuiNpcWaypoint
extends GuiNPCInterface {
    private TileWaypoint tile;

    public GuiNpcWaypoint(int n, int n2, int n3) {
        this.tile = (TileWaypoint)this.player.field_70170_p.func_72796_p(n, n2, n3);
        this.xSize = 265;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addLabel(new GuiNpcLabel(0, "gui.name", this.guiLeft + 1, this.guiTop + 76, 0xFFFFFF));
        this.addTextField(new GuiNpcTextField(0, this, this.field_73886_k, this.guiLeft + 60, this.guiTop + 71, 200, 20, this.tile.name));
        this.addLabel(new GuiNpcLabel(1, "gui.range", this.guiLeft + 1, this.guiTop + 97, 0xFFFFFF));
        this.addTextField(new GuiNpcTextField(1, this, this.field_73886_k, this.guiLeft + 60, this.guiTop + 92, 200, 20, this.tile.range + ""));
        this.getTextField((int)1).numbersOnly = true;
        this.getTextField(1).setMinMaxDefault(2, 60, 10);
        this.addButton(new GuiNpcButton(0, this.guiLeft + 40, this.guiTop + 190, 120, 20, "Done"));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            this.close();
        }
    }

    @Override
    public void save() {
        if (this.tile != null) {
            this.tile.name = this.getTextField(0).func_73781_b();
            this.tile.range = this.getTextField(1).getInteger();
            qoac qoac2 = new qoac();
            this.tile.func_70310_b(qoac2);
            NoppesUtil.sendData(EnumPacketType.SaveTileEntity, qoac2);
        }
    }
}

