/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

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
    public void func_73866_w_() {
        super.func_73866_w_();
        RoleWorkbench roleWorkbench = (RoleWorkbench)this.npc.roleInterface;
        this.addTextField(new GuiNpcTextField(0, this, this.field_73886_k, this.field_73880_f / 2 - 150, this.field_73881_g / 2 - 80, 80, 20, roleWorkbench.workbenchId));
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        ((RoleWorkbench)this.npc.roleInterface).workbenchId = guiNpcTextField.func_73781_b();
    }

    @Override
    public void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new qoac()));
    }
}

