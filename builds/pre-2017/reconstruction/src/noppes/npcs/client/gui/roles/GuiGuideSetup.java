/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
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
    public void initGui() {
        super.initGui();
        if (!this.locations.isEmpty()) {
            RoleGuide roleGuide = (RoleGuide)this.npc.roleInterface;
            int n = 0;
            for (int i = 0; i < this.locations.size(); ++i) {
                if (!this.locations.get(i).equals(roleGuide.currentSavezone)) continue;
                n = i;
            }
            this.addButton(new GuiNpcButton(0, this.width / 2 - 150, this.height / 2 - 80, 80, 20, this.locations.toArray(new String[0]), n));
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        super.actionPerformed(guiButton);
        if (guiButton.id == 0) {
            ((RoleGuide)this.npc.roleInterface).currentSavezone = this.locations.get(((GuiNpcButton)guiButton).getValue());
        }
    }

    @Override
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        this.locations.clear();
        NBTTagList nBTTagList = nBTTagCompound._n("Locations");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            this.locations.add(((NBTTagString)nBTTagList._b((int)i))._c);
        }
        this.initGui();
    }

    @Override
    public void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new NBTTagCompound()));
    }
}

