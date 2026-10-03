/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ea
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 *  ud
 *  va
 *  vi
 *  we
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class awz
extends awy
implements vi {
    private static final bjo t = new bjo("textures/gui/container/anvil.png");
    private va u;
    private avf v;
    private ud w;

    public awz(ud par1InventoryPlayer, abw par2World, int par3, int par4, int par5) {
        super((uy)new va(par1InventoryPlayer, par2World, par3, par4, par5, (uf)atv.w().h));
        this.w = par1InventoryPlayer;
        this.u = (va)this.e;
    }

    @Override
    public void A_() {
        super.A_();
        Keyboard.enableRepeatEvents((boolean)true);
        int i = (this.g - this.c) / 2;
        int j2 = (this.h - this.d) / 2;
        this.v = new avf(this.o, i + 62, j2 + 24, 103, 12);
        this.v.g(-1);
        this.v.h(-1);
        this.v.a(false);
        this.v.f(40);
        this.e.b(this);
        this.e.a(this);
    }

    @Override
    public void b() {
        super.b();
        Keyboard.enableRepeatEvents((boolean)false);
        this.e.b(this);
    }

    @Override
    protected void b(int par1, int par2) {
        GL11.glDisable((int)2896);
        this.o.b(bkb.a((String)"container.repair"), 60, 6, 0x404040);
        if (this.u.a > 0) {
            int k = 8453920;
            boolean flag = true;
            String s2 = bkb.a((String)"container.repair.cost", (Object[])new Object[]{this.u.a});
            if (this.u.a >= 40 && !this.f.h.bG.d) {
                s2 = bkb.a((String)"container.repair.expensive");
                k = 0xFF6060;
            } else if (!this.u.a(2).e()) {
                flag = false;
            } else if (!this.u.a(2).a(this.w.d)) {
                k = 0xFF6060;
            }
            if (flag) {
                int l = 0xFF000000 | (k & 0xFCFCFC) >> 2 | k & 0xFF000000;
                int i1 = this.c - 8 - this.o.a(s2);
                int b0 = 67;
                if (this.o.a()) {
                    awz.a(i1 - 3, b0 - 2, this.c - 7, b0 + 10, -16777216);
                    awz.a(i1 - 2, b0 - 1, this.c - 8, b0 + 9, -12895429);
                } else {
                    this.o.b(s2, i1, b0 + 1, l);
                    this.o.b(s2, i1 + 1, b0, l);
                    this.o.b(s2, i1 + 1, b0 + 1, l);
                }
                this.o.b(s2, i1, b0, k);
            }
        }
        GL11.glEnable((int)2896);
    }

    @Override
    protected void a(char par1, int par2) {
        if (this.v.a(par1, par2)) {
            this.g();
        } else {
            super.a(par1, par2);
        }
    }

    private void g() {
        String s2 = this.v.b();
        we slot = this.u.a(0);
        if (slot != null && slot.e() && !slot.d().u() && s2.equals(slot.d().s())) {
            s2 = "";
        }
        this.u.a(s2);
        this.f.h.a.c((ey)new ea("MC|ItemName", s2.getBytes()));
    }

    @Override
    protected void a(int par1, int par2, int par3) {
        super.a(par1, par2, par3);
        this.v.a(par1, par2, par3);
    }

    @Override
    public void a(int par1, int par2, float par3) {
        super.a(par1, par2, par3);
        GL11.glDisable((int)2896);
        this.v.f();
    }

    @Override
    protected void a(float par1, int par2, int par3) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.f.J().a(t);
        int k = (this.g - this.c) / 2;
        int l = (this.h - this.d) / 2;
        this.b(k, l, 0, 0, this.c, this.d);
        this.b(k + 59, l + 20, 0, this.d + (this.u.a(0).e() ? 0 : 16), 110, 16);
        if ((this.u.a(0).e() || this.u.a(1).e()) && !this.u.a(2).e()) {
            this.b(k + 99, l + 45, this.c, 0, 28, 21);
        }
    }

    public void a(uy par1Container, List par2List) {
        this.a(par1Container, 0, par1Container.a(0).d());
    }

    public void a(uy par1Container, int par2, ye par3ItemStack) {
        if (par2 == 0) {
            this.v.a(par3ItemStack == null ? "" : par3ItemStack.s());
            this.v.c(par3ItemStack != null);
            if (par3ItemStack != null) {
                this.g();
            }
        }
    }

    public void a(uy par1Container, int par2, int par3) {
    }
}

