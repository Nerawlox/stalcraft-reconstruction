/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import java.util.ArrayList;
import java.util.List;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.roles.RoleSupplier;

public class GuiSupplierSetup
extends GuiContainerNPCInterface2
implements IGuiData,
ITextfieldListener {
    private List<String> locations = new ArrayList<String>();
    private RoleSupplier supplier;

    public GuiSupplierSetup(EntityNPCInterface entityNPCInterface, jjgc jjgc2) {
        super(entityNPCInterface, jjgc2);
        NoppesUtil.sendData(EnumPacketType.GetTradeLocations, new Object[0]);
    }

    @Override
    public void func_73866_w_() {
        int n;
        int n2;
        super.func_73866_w_();
        this.supplier = (RoleSupplier)this.npc.roleInterface;
        for (n2 = 0; n2 < 8; ++n2) {
            n = this.supplier.prices[n2];
            this.addTextField(new GuiNpcTextField(n2, this, this.field_73886_k, this.field_73880_f / 2 + 20, this.field_73881_g / 2 - 80 + 22 * n2, 80, 15, String.valueOf(n)));
        }
        if (!this.locations.isEmpty()) {
            n2 = 0;
            for (n = 0; n < this.locations.size(); ++n) {
                if (!this.supplier.location.equals(this.locations.get(n))) continue;
                n2 = n;
            }
            this.addButton(new GuiNpcButton(0, this.field_73880_f / 2 - 150, this.field_73881_g / 2 - 80, 80, 20, this.locations.toArray(new String[0]), n2));
        }
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id < 8) {
            try {
                Integer.parseInt(guiNpcTextField.func_73781_b().trim());
                guiNpcTextField.func_73794_g(-2039584);
            }
            catch (NumberFormatException numberFormatException) {
                guiNpcTextField.func_73794_g(-65536);
            }
        } else if (guiNpcTextField.id == 8) {
            ((RoleSupplier)this.npc.roleInterface).location = guiNpcTextField.func_73781_b();
        }
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            int n = ((GuiNpcButton)jiok2).getValue();
            this.supplier.location = this.locations.get(n);
        }
    }

    @Override
    public void save() {
        for (int i = 0; i < 8; ++i) {
            GuiNpcTextField guiNpcTextField = this.getTextField(i);
            try {
                int n;
                ((RoleSupplier)this.npc.roleInterface).prices[i] = n = Integer.parseInt(guiNpcTextField.func_73781_b().trim());
                continue;
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new qoac()));
    }

    @Override
    public void setGuiData(qoac qoac2) {
        this.locations.clear();
        bsyv bsyv2 = qoac2._n("Locations");
        for (int i = 0; i < bsyv2._d(); ++i) {
            xsxy xsxy2 = (xsxy)bsyv2._b(i);
            this.locations.add(xsxy2._c);
        }
        this.func_73866_w_();
    }
}

