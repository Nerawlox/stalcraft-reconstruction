/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import java.util.HashMap;
import java.util.Iterator;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.containers.ContainerNPCFollowerSetup;
import noppes.npcs.roles.RoleFollower;

public class GuiNpcFollowerSetup
extends GuiContainerNPCInterface2 {
    private static final ResourceLocation field_110422_t = new ResourceLocation("textures/gui/followersetup.png");
    private RoleFollower role;

    public GuiNpcFollowerSetup(EntityNPCInterface entityNPCInterface, ContainerNPCFollowerSetup containerNPCFollowerSetup) {
        super(entityNPCInterface, containerNPCFollowerSetup);
        this.role = (RoleFollower)entityNPCInterface.roleInterface;
        this.field_74195_c = 180;
        this.setBackground("followersetup.png");
    }

    @Override
    public void func_73866_w_() {
        int n;
        int n2;
        super.func_73866_w_();
        for (n2 = 0; n2 < 3; ++n2) {
            int n3 = this.guiTop + 66;
            n = this.guiLeft + 37;
            GuiNpcTextField guiNpcTextField = new GuiNpcTextField(n2, this, this.field_73886_k, n3, n += n2 * 25, 24, 20, "1");
            guiNpcTextField.numbersOnly = true;
            guiNpcTextField.setMinMaxDefault(1, Integer.MAX_VALUE, 1);
            this.addTextField(guiNpcTextField);
        }
        n2 = 0;
        Iterator iterator = this.role.rates.values().iterator();
        while (iterator.hasNext()) {
            n = (Integer)iterator.next();
            this.getTextField(n2).func_73782_a(n + "");
            ++n2;
        }
        this.addTextField(new GuiNpcTextField(3, this, this.field_73886_k, this.guiTop + 100, this.guiLeft + 6, 286, 20, this.role.dialogHire));
        this.addTextField(new GuiNpcTextField(4, this, this.field_73886_k, this.guiTop + 100, this.guiLeft + 30, 286, 20, this.role.dialogFarewell));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
    }

    @Override
    public void func_73874_b() {
    }

    @Override
    protected void func_74189_g(int n, int n2) {
    }

    @Override
    public void save() {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < this.role.inventory.func_70302_i_(); ++i) {
            cvzo cvzo2 = this.role.inventory.func_70301_a(i);
            if (cvzo2 == null) continue;
            int n = 1;
            if (!this.getTextField(i).isEmpty() && this.getTextField(i).isInteger()) {
                n = this.getTextField(i).getInteger();
            }
            if (n <= 0) {
                n = 1;
            }
            hashMap.put(i, n);
        }
        this.role.rates = hashMap;
        this.role.dialogHire = this.getTextField(3).func_73781_b();
        this.role.dialogFarewell = this.getTextField(4).func_73781_b();
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new qoac()));
    }
}

