/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abk
 *  abl
 *  abm
 *  aut
 *  axx
 *  bjo
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ea
 *  org.lwjgl.opengl.GL11
 *  ud
 *  vz
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class axw
extends awy {
    private static final bjo t = new bjo("textures/gui/container/villager.png");
    private abk u;
    private axx v;
    private axx w;
    private int x;
    private String y;

    public axw(ud par1InventoryPlayer, abk par2IMerchant, abw par3World, String par4Str) {
        super((uy)new vz(par1InventoryPlayer, par2IMerchant, par3World));
        this.u = par2IMerchant;
        this.y = par4Str != null && par4Str.length() >= 1 ? par4Str : bkb.a((String)"entity.Villager.name");
    }

    @Override
    public void A_() {
        super.A_();
        int i = (this.g - this.c) / 2;
        int j2 = (this.h - this.d) / 2;
        this.v = new axx(1, i + 120 + 27, j2 + 24 - 1, true);
        this.i.add(this.v);
        this.w = new axx(2, i + 36 - 19, j2 + 24 - 1, false);
        this.i.add(this.w);
        this.v.h = false;
        this.w.h = false;
    }

    @Override
    protected void b(int par1, int par2) {
        this.o.b(this.y, this.c / 2 - this.o.a(this.y) / 2, 6, 0x404040);
        this.o.b(bkb.a((String)"container.inventory"), 8, this.d - 96 + 2, 0x404040);
    }

    @Override
    public void c() {
        super.c();
        abm merchantrecipelist = this.u.b((uf)this.f.h);
        if (merchantrecipelist != null) {
            this.v.h = this.x < merchantrecipelist.size() - 1;
            this.w.h = this.x > 0;
        }
    }

    @Override
    protected void a(aut par1GuiButton) {
        boolean flag = false;
        if (par1GuiButton == this.v) {
            ++this.x;
            flag = true;
        } else if (par1GuiButton == this.w) {
            --this.x;
            flag = true;
        }
        if (flag) {
            ((vz)this.e).e(this.x);
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
            try {
                dataoutputstream.writeInt(this.x);
                this.f.q().c((ey)new ea("MC|TrSel", bytearrayoutputstream.toByteArray()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    protected void a(float par1, int par2, int par3) {
        int i1;
        abl merchantrecipe;
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.f.J().a(t);
        int k = (this.g - this.c) / 2;
        int l = (this.h - this.d) / 2;
        this.b(k, l, 0, 0, this.c, this.d);
        abm merchantrecipelist = this.u.b((uf)this.f.h);
        if (merchantrecipelist != null && !merchantrecipelist.isEmpty() && (merchantrecipe = (abl)merchantrecipelist.get(i1 = this.x)).g()) {
            this.f.J().a(t);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDisable((int)2896);
            this.b(this.p + 83, this.q + 21, 212, 0, 28, 21);
            this.b(this.p + 83, this.q + 51, 212, 0, 28, 21);
        }
    }

    @Override
    public void a(int par1, int par2, float par3) {
        super.a(par1, par2, par3);
        abm merchantrecipelist = this.u.b((uf)this.f.h);
        if (merchantrecipelist != null && !merchantrecipelist.isEmpty()) {
            int k = (this.g - this.c) / 2;
            int l = (this.h - this.d) / 2;
            int i1 = this.x;
            abl merchantrecipe = (abl)merchantrecipelist.get(i1);
            GL11.glPushMatrix();
            ye itemstack = merchantrecipe.a();
            ye itemstack1 = merchantrecipe.b();
            ye itemstack2 = merchantrecipe.d();
            att.c();
            GL11.glDisable((int)2896);
            GL11.glEnable((int)32826);
            GL11.glEnable((int)2903);
            GL11.glEnable((int)2896);
            axw.b.f = 100.0f;
            b.b(this.o, this.f.J(), itemstack, k + 36, l + 24);
            b.c(this.o, this.f.J(), itemstack, k + 36, l + 24);
            if (itemstack1 != null) {
                b.b(this.o, this.f.J(), itemstack1, k + 62, l + 24);
                b.c(this.o, this.f.J(), itemstack1, k + 62, l + 24);
            }
            b.b(this.o, this.f.J(), itemstack2, k + 120, l + 24);
            b.c(this.o, this.f.J(), itemstack2, k + 120, l + 24);
            axw.b.f = 0.0f;
            GL11.glDisable((int)2896);
            if (this.c(36, 24, 16, 16, par1, par2)) {
                this.a(itemstack, par1, par2);
            } else if (itemstack1 != null && this.c(62, 24, 16, 16, par1, par2)) {
                this.a(itemstack1, par1, par2);
            } else if (this.c(120, 24, 16, 16, par1, par2)) {
                this.a(itemstack2, par1, par2);
            }
            GL11.glPopMatrix();
            GL11.glEnable((int)2896);
            GL11.glEnable((int)2929);
            att.b();
        }
    }

    public abk g() {
        return this.u;
    }

    static bjo h() {
        return t;
    }
}

