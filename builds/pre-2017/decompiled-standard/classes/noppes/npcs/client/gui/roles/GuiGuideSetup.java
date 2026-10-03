/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import java.util.ArrayList;
import java.util.List;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.roles.RoleGuide;

public class GuiGuideSetup
extends GuiNPCInterface2
implements IGuiData {
    private List<String> locations = new ArrayList<String>();

    public GuiGuideSetup(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        NoppesUtil.sendData(EnumPacketType.GetGuideLocations, new Object[0]);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        if (!this.locations.isEmpty()) {
            RoleGuide roleGuide = (RoleGuide)this.npc.roleInterface;
            int n = 0;
            for (int i = 0; i < this.locations.size(); ++i) {
                if (!this.locations.get(i).equals(roleGuide.currentSavezone)) continue;
                n = i;
            }
            this.addButton(new GuiNpcButton(0, this.field_73880_f / 2 - 150, this.field_73881_g / 2 - 80, 80, 20, this.locations.toArray(new String[0]), n));
        }
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        super.func_73875_a(jiok2);
        if (jiok2.field_73741_f == 0) {
            ((RoleGuide)this.npc.roleInterface).currentSavezone = this.locations.get(((GuiNpcButton)jiok2).getValue());
        }
    }

    @Override
    public void setGuiData(qoac qoac2) {
        this.locations.clear();
        bsyv bsyv2 = qoac2._n("Locations");
        for (int i = 0; i < bsyv2._d(); ++i) {
            this.locations.add(((xsxy)bsyv2._b((int)i))._c);
        }
        this.func_73866_w_();
    }

    @Override
    public void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new qoac()));
    }
}

