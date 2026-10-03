/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

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
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addButton(new GuiNpcButton(5, this.field_74198_m + 26, this.field_74197_n + 60, 50, 20, tdpx._a("follower.hire")));
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        super.func_73875_a(jiok2);
        if (jiok2.field_73741_f == 5) {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.FollowerHire, new Object[0]);
            this.close();
        }
    }

    @Override
    protected void func_74189_g(int n, int n2) {
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(this.resource);
        int n3 = (this.field_73880_f - this.field_74194_b) / 2;
        int n4 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
        int n5 = 0;
        for (int n6 : this.role.inventory.items.keySet()) {
            cvzo cvzo2 = this.role.inventory.items.get(n6);
            if (cvzo2 == null) continue;
            int n7 = 1;
            if (this.role.rates.containsKey(n6)) {
                n7 = (Integer)this.role.rates.get(n6);
            }
            int n8 = n5 * 26;
            int n9 = this.field_74198_m + 78;
            int n10 = this.field_74197_n + n8 + 10;
            GL11.glEnable(32826);
            qnon._c();
            zybc.field_74196_a.func_77015_a(this.field_73886_k, this.field_73882_e._h, cvzo2, n9 + 11, n10);
            zybc.field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e._h, cvzo2, n9 + 11, n10);
            qnon._a();
            GL11.glDisable(32826);
            String string = n7 + " " + (n7 == 1 ? tdpx._a("follower.day") : tdpx._a("follower.days"));
            this.field_73886_k._b(" = " + string, n9 + 27, n10 + 4, 0x404040);
            ++n5;
        }
    }

    @Override
    public void save() {
    }
}

