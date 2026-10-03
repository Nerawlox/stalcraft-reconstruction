/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import java.util.HashMap;
import java.util.Iterator;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
    private static final ResourceLocation craftingTableGuiTextures = new ResourceLocation("textures/gui/followersetup.png");
    private RoleFollower role;

    public GuiNpcFollowerSetup(EntityNPCInterface entityNPCInterface, ContainerNPCFollowerSetup containerNPCFollowerSetup) {
        super(entityNPCInterface, containerNPCFollowerSetup);
        this.role = (RoleFollower)entityNPCInterface.roleInterface;
        this.ySize = 180;
        this.setBackground("followersetup.png");
    }

    @Override
    public void initGui() {
        int n;
        int n2;
        super.initGui();
        for (n2 = 0; n2 < 3; ++n2) {
            int n3 = this.guiTop + 66;
            n = this.guiLeft + 37;
            GuiNpcTextField guiNpcTextField = new GuiNpcTextField(n2, this, this.fontRenderer, n3, n += n2 * 25, 24, 20, "1");
            guiNpcTextField.numbersOnly = true;
            guiNpcTextField.setMinMaxDefault(1, Integer.MAX_VALUE, 1);
            this.addTextField(guiNpcTextField);
        }
        n2 = 0;
        Iterator iterator = this.role.rates.values().iterator();
        while (iterator.hasNext()) {
            n = (Integer)iterator.next();
            this.getTextField(n2).setText(n + "");
            ++n2;
        }
        this.addTextField(new GuiNpcTextField(3, this, this.fontRenderer, this.guiTop + 100, this.guiLeft + 6, 286, 20, this.role.dialogHire));
        this.addTextField(new GuiNpcTextField(4, this, this.fontRenderer, this.guiTop + 100, this.guiLeft + 30, 286, 20, this.role.dialogFarewell));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
    }

    @Override
    public void onGuiClosed() {
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
    }

    @Override
    public void save() {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < this.role.inventory.getSizeInventory(); ++i) {
            ItemStack itemStack = this.role.inventory.getStackInSlot(i);
            if (itemStack == null) continue;
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
        this.role.dialogHire = this.getTextField(3).getText();
        this.role.dialogFarewell = this.getTextField(4).getText();
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new NBTTagCompound()));
    }
}

