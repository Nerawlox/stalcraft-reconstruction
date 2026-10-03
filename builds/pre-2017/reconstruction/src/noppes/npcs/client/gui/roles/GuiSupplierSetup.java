/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
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

    public GuiSupplierSetup(EntityNPCInterface entityNPCInterface, Container container) {
        super(entityNPCInterface, container);
        NoppesUtil.sendData(EnumPacketType.GetTradeLocations, new Object[0]);
    }

    @Override
    public void initGui() {
        int n;
        int n2;
        super.initGui();
        this.supplier = (RoleSupplier)this.npc.roleInterface;
        for (n2 = 0; n2 < 8; ++n2) {
            n = this.supplier.prices[n2];
            this.addTextField(new GuiNpcTextField(n2, this, this.fontRenderer, this.width / 2 + 20, this.height / 2 - 80 + 22 * n2, 80, 15, String.valueOf(n)));
        }
        if (!this.locations.isEmpty()) {
            n2 = 0;
            for (n = 0; n < this.locations.size(); ++n) {
                if (!this.supplier.location.equals(this.locations.get(n))) continue;
                n2 = n;
            }
            this.addButton(new GuiNpcButton(0, this.width / 2 - 150, this.height / 2 - 80, 80, 20, this.locations.toArray(new String[0]), n2));
        }
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id < 8) {
            try {
                Integer.parseInt(guiNpcTextField.getText().trim());
                guiNpcTextField.setTextColor(-2039584);
            }
            catch (NumberFormatException numberFormatException) {
                guiNpcTextField.setTextColor(-65536);
            }
        } else if (guiNpcTextField.id == 8) {
            ((RoleSupplier)this.npc.roleInterface).location = guiNpcTextField.getText();
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            int n = ((GuiNpcButton)guiButton).getValue();
            this.supplier.location = this.locations.get(n);
        }
    }

    @Override
    public void save() {
        for (int i = 0; i < 8; ++i) {
            GuiNpcTextField guiNpcTextField = this.getTextField(i);
            try {
                int n;
                ((RoleSupplier)this.npc.roleInterface).prices[i] = n = Integer.parseInt(guiNpcTextField.getText().trim());
                continue;
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        this.locations.clear();
        NBTTagList nBTTagList = nBTTagCompound._n("Locations");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagString nBTTagString = (NBTTagString)nBTTagList._b(i);
            this.locations.add(nBTTagString._c);
        }
        this.initGui();
    }
}

