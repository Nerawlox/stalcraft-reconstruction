/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.tdpx;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.constants.EnumPlayerPacket;
import noppes.npcs.containers.ContainerNPCFollowerHire;
import noppes.npcs.roles.RoleFollower;
import org.lwjgl.opengl.GL11;

public class GuiNpcFollowerHire
extends GuiContainerNPCInterface {
    private final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/followerhire.png");
    private EntityNPCInterface npc;
    private ContainerNPCFollowerHire container;
    private RoleFollower role;

    public GuiNpcFollowerHire(EntityNPCInterface entityNPCInterface, ContainerNPCFollowerHire containerNPCFollowerHire) {
        super(entityNPCInterface, containerNPCFollowerHire);
        this.container = containerNPCFollowerHire;
        this.npc = entityNPCInterface;
        this.role = (RoleFollower)entityNPCInterface.roleInterface;
        this.closeOnEsc = true;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addButton(new GuiNpcButton(5, this.guiLeft + 26, this.guiTop + 60, 50, 20, tdpx._a("follower.hire")));
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        super.actionPerformed(guiButton);
        if (guiButton.id == 5) {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.FollowerHire, new Object[0]);
            this.close();
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(this.resource);
        int n3 = (this.width - this.xSize) / 2;
        int n4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
        int n5 = 0;
        for (int n6 : this.role.inventory.items.keySet()) {
            ItemStack itemStack = this.role.inventory.items.get(n6);
            if (itemStack == null) continue;
            int n7 = 1;
            if (this.role.rates.containsKey(n6)) {
                n7 = (Integer)this.role.rates.get(n6);
            }
            int n8 = n5 * 26;
            int n9 = this.guiLeft + 78;
            int n10 = this.guiTop + n8 + 10;
            GL11.glEnable(32826);
            qnon._c();
            GuiContainer.itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc._h, itemStack, n9 + 11, n10);
            GuiContainer.itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc._h, itemStack, n9 + 11, n10);
            qnon._a();
            GL11.glDisable(32826);
            String string = n7 + " " + (n7 == 1 ? tdpx._a("follower.day") : tdpx._a("follower.days"));
            this.fontRenderer._b(" = " + string, n9 + 27, n10 + 4, 0x404040);
            ++n5;
        }
    }

    @Override
    public void save() {
    }
}

