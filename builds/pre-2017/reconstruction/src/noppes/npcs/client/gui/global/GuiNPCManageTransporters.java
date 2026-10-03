/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.global;

import java.util.HashMap;
import java.util.Vector;
import net.minecraft.client.gui.GuiButton;
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
    public void initGui() {
        super.initGui();
        Vector vector = new Vector();
        this.slot = new GuiNPCStringSlot(vector, this, this.npc, false, 18);
        this.slot.registerScrollButtons(4, 5);
        this.addButton(0, new GuiNpcButton(0, this.width / 2 - 100, this.height - 52, 65, 20, "gui.add"));
        this.addButton(1, new GuiNpcButton(1, this.width / 2 - 33, this.height - 52, 65, 20, "selectServer.edit"));
        this.getButton((int)0).enabled = this.selectCategory;
        this.getButton((int)1).enabled = this.selectCategory;
        this.addButton(3, new GuiNpcButton(3, this.width / 2 + 33, this.height - 52, 65, 20, "gui.remove"));
        this.addButton(2, new GuiNpcButton(2, this.width / 2 - 100, this.height - 31, 98, 20, "gui.open"));
        this.getButton((int)2).enabled = this.selectCategory;
        this.addButton(4, new GuiNpcButton(4, this.width / 2 + 2, this.height - 31, 98, 20, "gui.back"));
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.slot.drawScreen(n, n2, f);
        super.drawScreen(n, n2, f);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0 && this.selectCategory) {
            NoppesUtil.openGUI(this.player, new GuiNPCTransportCategoryEdit(this.npc, this, "", -1));
        }
        if (guiButton.id == 1) {
            if (this.slot.selected == null || this.slot.selected.isEmpty()) {
                return;
            }
            if (this.selectCategory) {
                NoppesUtil.openGUI(this.player, new GuiNPCTransportCategoryEdit(this.npc, this, this.slot.selected, (Integer)this.data.get(this.slot.selected)));
            }
        }
        if (guiButton.id == 4) {
            if (this.selectCategory) {
                this.close();
                NoppesUtil.openGUI(this.player, new GuiNPCGlobalMainMenu(this.npc));
            } else {
                this.title = "Transport Categories";
                this.selectCategory = true;
                NoppesUtil.sendData(EnumPacketType.TransportCategoriesGet, new Object[0]);
                this.initGui();
            }
        }
        if (guiButton.id == 3) {
            if (this.slot.selected == null || this.slot.selected.isEmpty()) {
                return;
            }
            this.save();
            if (this.selectCategory) {
                NoppesUtil.sendData(EnumPacketType.TransportCategoryRemove, this.data.get(this.slot.selected));
            } else {
                NoppesUtil.sendData(EnumPacketType.TransportRemove, this.data.get(this.slot.selected));
            }
            this.initGui();
        }
        if (guiButton.id == 2) {
            this.doubleClicked();
        }
    }

    @Override
    public void doubleClicked() {
        if (this.slot.selected != null && !this.slot.selected.isEmpty() && this.selectCategory) {
            this.selectCategory = false;
            this.title = "TransportLocations";
            NoppesUtil.sendData(EnumPacketType.TransportsGet, this.data.get(this.slot.selected));
            this.initGui();
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

