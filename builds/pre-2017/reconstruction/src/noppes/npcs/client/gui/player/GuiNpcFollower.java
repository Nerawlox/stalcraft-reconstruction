/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.tdpx;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcSkinPreviewInterface;
import noppes.npcs.constants.EnumPlayerPacket;
import noppes.npcs.containers.ContainerNPCFollower;
import noppes.npcs.roles.RoleFollower;
import org.lwjgl.opengl.GL11;

public class GuiNpcFollower
extends GuiContainerNPCInterface
implements GuiNpcSkinPreviewInterface {
    private final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/follower.png");
    private EntityNPCInterface npc;
    private RoleFollower role;
    private float xSize_lo;
    private float ySize_lo;

    public GuiNpcFollower(EntityNPCInterface entityNPCInterface, ContainerNPCFollower containerNPCFollower) {
        super(entityNPCInterface, containerNPCFollower);
        this.npc = entityNPCInterface;
        this.role = (RoleFollower)entityNPCInterface.roleInterface;
        this.closeOnEsc = true;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.clear();
        this.addButton(new GuiNpcButton(4, this.guiLeft + 100, this.guiTop + 110, 50, 20, new String[]{tdpx._a("follower.waiting"), tdpx._a("follower.following")}, this.role.isFollowing ? 1 : 0));
        this.addButton(new GuiNpcButton(5, this.guiLeft + 8, this.guiTop + 30, 50, 20, tdpx._a("follower.hire")));
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        super.actionPerformed(guiButton);
        if (guiButton.id == 4) {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.FollowerState, new Object[0]);
            this.close();
        }
        if (guiButton.id == 5) {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.FollowerExtend, new Object[0]);
            this.close();
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
        this.fontRenderer._b(tdpx._a("follower.health") + ": " + this.npc.getHealth() + "/" + this.npc.getMaxHealth(), 62, 70, 0x404040);
        if (this.role.getDaysLeft() <= 1) {
            this.fontRenderer._b(tdpx._a("follower.daysleft") + ": " + tdpx._a("follower.lastday"), 62, 94, 0x404040);
        } else {
            this.fontRenderer._b(tdpx._a("follower.daysleft") + ": " + (this.role.getDaysLeft() - 1), 62, 94, 0x404040);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(this.resource);
        int n3 = this.guiLeft;
        int n4 = this.guiTop;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
        int n5 = 0;
        for (int n6 : this.role.inventory.items.keySet()) {
            ItemStack itemStack = this.role.inventory.items.get(n6);
            if (itemStack == null) continue;
            int n7 = 1;
            if (this.role.rates.containsKey(n6)) {
                n7 = (Integer)this.role.rates.get(n6);
            }
            int n8 = n5 * 20;
            int n9 = this.guiLeft + 68;
            int n10 = this.guiTop + n8 + 4;
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
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef(n3 + 33, n4 + 131, 50.0f);
        float f2 = 30.0f;
        GL11.glScalef(-f2, f2, f2);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        float f3 = this.npc.renderYawOffset;
        float f4 = this.npc.rotationYaw;
        float f5 = this.npc.rotationPitch;
        float f6 = (float)(n3 + 33) - this.xSize_lo;
        float f7 = (float)(n4 + 131 - 50) - this.ySize_lo;
        GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
        qnon._b();
        GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-((float)Math.atan(f7 / 40.0f)) * 20.0f, 1.0f, 0.0f, 0.0f);
        this.npc.renderYawOffset = (float)Math.atan(f6 / 40.0f) * 20.0f;
        this.npc.rotationYaw = (float)Math.atan(f6 / 40.0f) * 40.0f;
        this.npc.rotationPitch = -((float)Math.atan(f7 / 40.0f)) * 20.0f;
        this.npc.rotationYawHead = this.npc.rotationYaw;
        GL11.glTranslatef(0.0f, this.npc.yOffset, 0.0f);
        RenderManager._b._l = 180.0f;
        RenderManager._b._a(this.npc, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        this.npc.renderYawOffset = f3;
        this.npc.rotationYaw = f4;
        this.npc.rotationPitch = f5;
        GL11.glPopMatrix();
        qnon._a();
        GL11.glDisable(32826);
        iwya._a(iwya._b);
        GL11.glDisable(3553);
        iwya._a(iwya._a);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        this.xSize_lo = n;
        this.ySize_lo = n2;
    }

    @Override
    public void save() {
    }
}

