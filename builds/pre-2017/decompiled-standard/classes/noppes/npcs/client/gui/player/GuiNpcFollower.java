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
    public void func_73866_w_() {
        super.func_73866_w_();
        this.field_73887_h.clear();
        this.addButton(new GuiNpcButton(4, this.field_74198_m + 100, this.field_74197_n + 110, 50, 20, new String[]{tdpx._a("follower.waiting"), tdpx._a("follower.following")}, this.role.isFollowing ? 1 : 0));
        this.addButton(new GuiNpcButton(5, this.field_74198_m + 8, this.field_74197_n + 30, 50, 20, tdpx._a("follower.hire")));
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        super.func_73875_a(jiok2);
        if (jiok2.field_73741_f == 4) {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.FollowerState, new Object[0]);
            this.close();
        }
        if (jiok2.field_73741_f == 5) {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.FollowerExtend, new Object[0]);
            this.close();
        }
    }

    @Override
    protected void func_74189_g(int n, int n2) {
        this.field_73886_k._b(tdpx._a("follower.health") + ": " + this.npc.func_110143_aJ() + "/" + this.npc.func_110138_aP(), 62, 70, 0x404040);
        if (this.role.getDaysLeft() <= 1) {
            this.field_73886_k._b(tdpx._a("follower.daysleft") + ": " + tdpx._a("follower.lastday"), 62, 94, 0x404040);
        } else {
            this.field_73886_k._b(tdpx._a("follower.daysleft") + ": " + (this.role.getDaysLeft() - 1), 62, 94, 0x404040);
        }
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(this.resource);
        int n3 = this.field_74198_m;
        int n4 = this.field_74197_n;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
        int n5 = 0;
        for (int n6 : this.role.inventory.items.keySet()) {
            cvzo cvzo2 = this.role.inventory.items.get(n6);
            if (cvzo2 == null) continue;
            int n7 = 1;
            if (this.role.rates.containsKey(n6)) {
                n7 = (Integer)this.role.rates.get(n6);
            }
            int n8 = n5 * 20;
            int n9 = this.field_74198_m + 68;
            int n10 = this.field_74197_n + n8 + 4;
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
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef(n3 + 33, n4 + 131, 50.0f);
        float f2 = 30.0f;
        GL11.glScalef(-f2, f2, f2);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        float f3 = this.npc.field_70761_aq;
        float f4 = this.npc.field_70177_z;
        float f5 = this.npc.field_70125_A;
        float f6 = (float)(n3 + 33) - this.xSize_lo;
        float f7 = (float)(n4 + 131 - 50) - this.ySize_lo;
        GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
        qnon._b();
        GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-((float)Math.atan(f7 / 40.0f)) * 20.0f, 1.0f, 0.0f, 0.0f);
        this.npc.field_70761_aq = (float)Math.atan(f6 / 40.0f) * 20.0f;
        this.npc.field_70177_z = (float)Math.atan(f6 / 40.0f) * 40.0f;
        this.npc.field_70125_A = -((float)Math.atan(f7 / 40.0f)) * 20.0f;
        this.npc.field_70759_as = this.npc.field_70177_z;
        GL11.glTranslatef(0.0f, this.npc.field_70129_M, 0.0f);
        gqqu._b._l = 180.0f;
        gqqu._b._a(this.npc, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        this.npc.field_70761_aq = f3;
        this.npc.field_70177_z = f4;
        this.npc.field_70125_A = f5;
        GL11.glPopMatrix();
        qnon._a();
        GL11.glDisable(32826);
        iwya._a(iwya._b);
        GL11.glDisable(3553);
        iwya._a(iwya._a);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        this.xSize_lo = n;
        this.ySize_lo = n2;
    }

    @Override
    public void save() {
    }
}

