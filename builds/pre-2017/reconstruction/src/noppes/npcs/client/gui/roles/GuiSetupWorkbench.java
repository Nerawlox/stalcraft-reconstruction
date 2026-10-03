/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.roles.RoleWorkbench;

public class GuiSetupWorkbench
extends GuiNPCInterface2
implements ITextfieldListener {
    public GuiSetupWorkbench(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
    }

    @Override
    public void initGui() {
        super.initGui();
        RoleWorkbench roleWorkbench = (RoleWorkbench)this.npc.roleInterface;
        this.addTextField(new GuiNpcTextField(0, this, this.fontRenderer, this.width / 2 - 150, this.height / 2 - 80, 80, 20, roleWorkbench.workbenchId));
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        ((RoleWorkbench)this.npc.roleInterface).workbenchId = guiNpcTextField.getText();
    }

    @Override
    public void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new NBTTagCompound()));
    }
}

