/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import java.util.HashMap;
import java.util.Vector;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.mainmenu.GuiNpcAdvanced;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNPCStringSlot;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.client.gui.util.IScrollData;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.TransportLocation;

public class GuiNpcTransporter
extends GuiNPCInterface
implements IGuiData,
IScrollData {
    public TransportLocation location = new TransportLocation();
    private GuiNPCStringSlot slot;
    private HashMap data = new HashMap();

    public GuiNpcTransporter(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        this.title = "Npc Transporter";
        NoppesUtil.sendData(EnumPacketType.TransportCategoriesGet, new Object[0]);
        NoppesUtil.sendData(EnumPacketType.TransportGetLocation, new Object[0]);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        Vector vector = new Vector();
        vector.addAll(this.data.keySet());
        this.slot = new GuiNPCStringSlot(vector, this, this.npc, false, 18);
        this.slot.func_77220_a(4, 5);
        this.addLabel(new GuiNpcLabel(0, "Name:", this.guiLeft - 30, this.field_73881_g - 49, 0xFFFFFF));
        this.addTextField(new GuiNpcTextField(0, this, this.field_73886_k, this.guiLeft + 1, this.field_73881_g - 54, 198, 20, this.location.name));
        this.addButton(new GuiNpcButton(0, this.guiLeft, this.field_73881_g - 31, new String[]{"Available when discovered", "Available from the start", "Available after interaction"}, this.location.type));
        this.addButton(new GuiNpcButton(4, this.guiLeft + 210, this.field_73881_g - 42, 98, 20, "Back"));
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.slot.func_77211_a(n, n2, f);
        super.func_73863_a(n, n2, f);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)jiok2;
        if (guiNpcButton.field_73741_f == 0) {
            this.location.type = guiNpcButton.getValue();
        }
        if (guiNpcButton.field_73741_f == 4) {
            this.close();
            NoppesUtil.openGUI(this.player, new GuiNpcAdvanced(this.npc));
        }
    }

    @Override
    public void save() {
        if (this.slot.selected != null && !this.slot.selected.isEmpty()) {
            String string = this.getTextField(0).func_73781_b();
            if (!string.isEmpty()) {
                this.location.name = string;
            }
            this.location.npcX = this.npc.startPos[0];
            this.location.npcY = this.npc.startPos[1];
            this.location.npcZ = this.npc.startPos[2];
            this.location.posX = this.player.field_70165_t;
            this.location.posY = this.player.field_70163_u;
            this.location.posZ = this.player.field_70161_v;
            this.location.dimension = this.player.field_71093_bK;
            int n = (Integer)this.data.get(this.slot.selected);
            NoppesUtil.sendData(EnumPacketType.TransportSave, n, this.location.writeNBT());
        }
    }

    @Override
    public void func_73873_v_() {
    }

    @Override
    public void setData(Vector vector, HashMap hashMap) {
        this.data = hashMap;
        this.slot.setList(vector);
    }

    @Override
    public void setSelected(String string) {
        this.slot.selected = string;
    }

    @Override
    public void setGuiData(qoac qoac2) {
        TransportLocation transportLocation = new TransportLocation();
        transportLocation.readNBT(qoac2);
        this.location = transportLocation;
        System.out.println(this.location.name);
        this.func_73866_w_();
    }
}

