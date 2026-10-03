/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aau
 *  aaw
 *  aut
 *  axl
 *  axn
 *  axo
 *  bjo
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  kp
 *  ku
 *  mo
 *  mu
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 *  ud
 *  vi
 *  we
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class axm
extends axp {
    private static final bjo t = new bjo("textures/gui/container/creative_inventory/tabs.png");
    private static mu u = new mu("tmp", true, 45);
    private static int v = ww.b.a();
    private float w;
    private boolean x;
    private boolean y;
    private avf z;
    private List A;
    private we B;
    private boolean C;
    private axl D;
    private static int tabPage = 0;
    private int maxPages = 0;

    public axm(uf par1EntityPlayer) {
        super((uy)new axn(par1EntityPlayer));
        par1EntityPlayer.bp = this.e;
        this.j = true;
        par1EntityPlayer.a((ku)kp.f, 1);
        this.d = 136;
        this.c = 195;
    }

    @Override
    public void c() {
        if (!this.f.c.h()) {
            this.f.a(new axv((uf)this.f.h));
        }
    }

    @Override
    protected void a(we par1Slot, int par2, int par3, int par4) {
        this.C = true;
        boolean flag = par4 == 1;
        int n = par4 = par2 == -999 && par4 == 0 ? 4 : par4;
        if (par1Slot == null && v != ww.m.a() && par4 != 5) {
            ud inventoryplayer = this.f.h.bn;
            if (inventoryplayer.o() != null) {
                if (par3 == 0) {
                    this.f.h.b(inventoryplayer.o());
                    this.f.c.a(inventoryplayer.o());
                    inventoryplayer.b((ye)null);
                }
                if (par3 == 1) {
                    ye itemstack = inventoryplayer.o().a(1);
                    this.f.h.b(itemstack);
                    this.f.c.a(itemstack);
                    if (inventoryplayer.o().b == 0) {
                        inventoryplayer.b((ye)null);
                    }
                }
            }
        } else if (par1Slot == this.B && flag) {
            for (int l = 0; l < this.f.h.bo.a().size(); ++l) {
                this.f.c.a((ye)null, l);
            }
        } else if (v == ww.m.a()) {
            if (par1Slot == this.B) {
                this.f.h.bn.b((ye)null);
            } else if (par4 == 4 && par1Slot != null && par1Slot.e()) {
                ye itemstack1 = par1Slot.a(par3 == 0 ? 1 : par1Slot.d().e());
                this.f.h.b(itemstack1);
                this.f.c.a(itemstack1);
            } else if (par4 == 4 && this.f.h.bn.o() != null) {
                this.f.h.b(this.f.h.bn.o());
                this.f.c.a(this.f.h.bn.o());
                this.f.h.bn.b((ye)null);
            } else {
                this.f.h.bo.a(par1Slot == null ? par2 : axo.a((axo)((axo)par1Slot)).g, par3, par4, (uf)this.f.h);
                this.f.h.bo.b();
            }
        } else if (par4 != 5 && par1Slot.f == u) {
            ud inventoryplayer = this.f.h.bn;
            ye itemstack = inventoryplayer.o();
            ye itemstack2 = par1Slot.d();
            if (par4 == 2) {
                if (itemstack2 != null && par3 >= 0 && par3 < 9) {
                    ye itemstack3 = itemstack2.m();
                    itemstack3.b = itemstack3.e();
                    this.f.h.bn.a(par3, itemstack3);
                    this.f.h.bo.b();
                }
                return;
            }
            if (par4 == 3) {
                if (inventoryplayer.o() == null && par1Slot.e()) {
                    ye itemstack3 = par1Slot.d().m();
                    itemstack3.b = itemstack3.e();
                    inventoryplayer.b(itemstack3);
                }
                return;
            }
            if (par4 == 4) {
                if (itemstack2 != null) {
                    ye itemstack3 = itemstack2.m();
                    itemstack3.b = par3 == 0 ? 1 : itemstack3.e();
                    this.f.h.b(itemstack3);
                    this.f.c.a(itemstack3);
                }
                return;
            }
            if (itemstack != null && itemstack2 != null && itemstack.a(itemstack2) && ye.a(itemstack, itemstack2)) {
                if (par3 == 0) {
                    if (flag) {
                        itemstack.b = itemstack.e();
                    } else if (itemstack.b < itemstack.e()) {
                        ++itemstack.b;
                    }
                } else if (itemstack.b <= 1) {
                    inventoryplayer.b((ye)null);
                } else {
                    --itemstack.b;
                }
            } else if (itemstack2 != null && itemstack == null) {
                inventoryplayer.b(ye.b(itemstack2));
                itemstack = inventoryplayer.o();
                if (flag) {
                    itemstack.b = itemstack.e();
                }
            } else {
                inventoryplayer.b((ye)null);
            }
        } else {
            this.e.a(par1Slot == null ? par2 : par1Slot.g, par3, par4, (uf)this.f.h);
            if (uy.c(par3) == 2) {
                for (int l = 0; l < 9; ++l) {
                    this.f.c.a(this.e.a(45 + l).d(), 36 + l);
                }
            } else if (par1Slot != null) {
                ye itemstack1 = this.e.a(par1Slot.g).d();
                this.f.c.a(itemstack1, par1Slot.g - this.e.c.size() + 9 + 36);
            }
        }
    }

    @Override
    public void A_() {
        if (this.f.c.h()) {
            super.A_();
            this.i.clear();
            Keyboard.enableRepeatEvents((boolean)true);
            this.z = new avf(this.o, this.p + 82, this.q + 6, 89, this.o.a);
            this.z.f(15);
            this.z.a(false);
            this.z.e(false);
            this.z.g(0xFFFFFF);
            int i = v;
            v = -1;
            this.b(ww.a[i]);
            this.D = new axl(this.f);
            this.f.h.bo.a((vi)this.D);
            int tabCount = ww.a.length;
            if (tabCount > 12) {
                this.i.add(new aut(101, this.p, this.q - 50, 20, 20, "<"));
                this.i.add(new aut(102, this.p + this.c - 20, this.q - 50, 20, 20, ">"));
                this.maxPages = (tabCount - 12) / 10 + 1;
            }
        } else {
            this.f.a(new axv((uf)this.f.h));
        }
    }

    @Override
    public void b() {
        super.b();
        if (this.f.h != null && this.f.h.bn != null) {
            this.f.h.bo.b((vi)this.D);
        }
        Keyboard.enableRepeatEvents((boolean)false);
    }

    @Override
    protected void a(char par1, int par2) {
        if (!ww.a[v].hasSearchBar()) {
            if (aul.a(this.f.u.P)) {
                this.b(ww.g);
            } else {
                super.a(par1, par2);
            }
        } else {
            if (this.C) {
                this.C = false;
                this.z.a("");
            }
            if (!this.a(par2)) {
                if (this.z.a(par1, par2)) {
                    this.i();
                } else {
                    super.a(par1, par2);
                }
            }
        }
    }

    private void i() {
        axn containercreative = (axn)this.e;
        containercreative.a.clear();
        ww tab = ww.a[v];
        if (tab.hasSearchBar() && tab != ww.g) {
            tab.a(containercreative.a);
            this.updateFilteredItems(containercreative);
            return;
        }
        for (yc item : yc.g) {
            if (item == null || item.y() == null) continue;
            item.a(item.cv, (ww)null, containercreative.a);
        }
        for (aau enchantment : aau.b) {
            if (enchantment == null || enchantment.A == null) continue;
            yc.bY.a(enchantment, containercreative.a);
        }
        this.updateFilteredItems(containercreative);
    }

    private void updateFilteredItems(axn containercreative) {
        Iterator iterator = containercreative.a.iterator();
        String s2 = this.z.b().toLowerCase();
        while (iterator.hasNext()) {
            ye itemstack = (ye)iterator.next();
            boolean flag = false;
            for (String s1 : itemstack.a((uf)this.f.h, this.f.u.x)) {
                if (!s1.toLowerCase().contains(s2)) continue;
                flag = true;
                break;
            }
            if (flag) continue;
            iterator.remove();
        }
        this.w = 0.0f;
        containercreative.a(0.0f);
    }

    @Override
    protected void b(int par1, int par2) {
        ww creativetabs = ww.a[v];
        if (creativetabs != null && creativetabs.g()) {
            this.o.b(bkb.a((String)creativetabs.c()), 8, 6, 0x404040);
        }
    }

    @Override
    protected void a(int par1, int par2, int par3) {
        if (par3 == 0) {
            int l = par1 - this.p;
            int i1 = par2 - this.q;
            for (ww creativetabs : ww.a) {
                if (!this.a(creativetabs, l, i1)) continue;
                return;
            }
        }
        super.a(par1, par2, par3);
    }

    @Override
    protected void b(int par1, int par2, int par3) {
        if (par3 == 0) {
            int l = par1 - this.p;
            int i1 = par2 - this.q;
            for (ww creativetabs : ww.a) {
                if (creativetabs == null || !this.a(creativetabs, l, i1)) continue;
                this.b(creativetabs);
                return;
            }
        }
        super.b(par1, par2, par3);
    }

    private boolean j() {
        if (ww.a[v] == null) {
            return false;
        }
        return v != ww.m.a() && ww.a[v].i() && ((axn)this.e).e();
    }

    private void b(ww par1CreativeTabs) {
        if (par1CreativeTabs == null) {
            return;
        }
        int i = v;
        v = par1CreativeTabs.a();
        axn containercreative = (axn)this.e;
        this.r.clear();
        containercreative.a.clear();
        par1CreativeTabs.a(containercreative.a);
        if (par1CreativeTabs == ww.m) {
            uy container = this.f.h.bo;
            if (this.A == null) {
                this.A = containercreative.c;
            }
            containercreative.c = new ArrayList();
            for (int j2 = 0; j2 < container.c.size(); ++j2) {
                int i1;
                int l;
                int k;
                axo slotcreativeinventory = new axo(this, (we)container.c.get(j2), j2);
                containercreative.c.add(slotcreativeinventory);
                if (j2 >= 5 && j2 < 9) {
                    k = j2 - 5;
                    l = k / 2;
                    i1 = k % 2;
                    slotcreativeinventory.h = 9 + l * 54;
                    slotcreativeinventory.i = 6 + i1 * 27;
                    continue;
                }
                if (j2 >= 0 && j2 < 5) {
                    slotcreativeinventory.i = -2000;
                    slotcreativeinventory.h = -2000;
                    continue;
                }
                if (j2 >= container.c.size()) continue;
                k = j2 - 9;
                l = k % 9;
                i1 = k / 9;
                slotcreativeinventory.h = 9 + l * 18;
                slotcreativeinventory.i = j2 >= 36 ? 112 : 54 + i1 * 18;
            }
            this.B = new we((mo)u, 0, 173, 112);
            containercreative.c.add(this.B);
        } else if (i == ww.m.a()) {
            containercreative.c = this.A;
            this.A = null;
        }
        if (this.z != null) {
            if (par1CreativeTabs.hasSearchBar()) {
                this.z.e(true);
                this.z.d(false);
                this.z.b(true);
                this.z.a("");
                this.i();
            } else {
                this.z.e(false);
                this.z.d(true);
                this.z.b(false);
            }
        }
        this.w = 0.0f;
        containercreative.a(0.0f);
    }

    @Override
    public void d() {
        super.d();
        int i = Mouse.getEventDWheel();
        if (i != 0 && this.j()) {
            int j2 = ((axn)this.e).a.size() / 9 - 5 + 1;
            if (i > 0) {
                i = 1;
            }
            if (i < 0) {
                i = -1;
            }
            this.w = (float)((double)this.w - (double)i / (double)j2);
            if (this.w < 0.0f) {
                this.w = 0.0f;
            }
            if (this.w > 1.0f) {
                this.w = 1.0f;
            }
            ((axn)this.e).a(this.w);
        }
    }

    @Override
    public void a(int par1, int par2, float par3) {
        boolean flag = Mouse.isButtonDown((int)0);
        int k = this.p;
        int l = this.q;
        int i1 = k + 175;
        int j1 = l + 18;
        int k1 = i1 + 14;
        int l1 = j1 + 112;
        if (!this.y && flag && par1 >= i1 && par2 >= j1 && par1 < k1 && par2 < l1) {
            this.x = this.j();
        }
        if (!flag) {
            this.x = false;
        }
        this.y = flag;
        if (this.x) {
            this.w = ((float)(par2 - j1) - 7.5f) / ((float)(l1 - j1) - 15.0f);
            if (this.w < 0.0f) {
                this.w = 0.0f;
            }
            if (this.w > 1.0f) {
                this.w = 1.0f;
            }
            ((axn)this.e).a(this.w);
        }
        super.a(par1, par2, par3);
        ww[] acreativetabs = ww.a;
        int start = tabPage * 10;
        int i2 = Math.min(acreativetabs.length, (tabPage + 1) * 10 + 2);
        if (tabPage != 0) {
            start += 2;
        }
        boolean rendered = false;
        for (int j2 = start; j2 < i2; ++j2) {
            ww creativetabs = acreativetabs[j2];
            if (creativetabs == null || !this.b(creativetabs, par1, par2)) continue;
            rendered = true;
            break;
        }
        if (!rendered && !this.b(ww.g, par1, par2)) {
            this.b(ww.m, par1, par2);
        }
        if (this.B != null && v == ww.m.a() && this.c(this.B.h, this.B.i, 16, 16, par1, par2)) {
            this.a(bkb.a((String)"inventory.binSlot"), par1, par2);
        }
        if (this.maxPages != 0) {
            String page = String.format("%d / %d", tabPage + 1, this.maxPages + 1);
            int width = this.o.a(page);
            GL11.glDisable((int)2896);
            this.n = 300.0f;
            axm.b.f = 300.0f;
            this.o.b(page, this.p + this.c / 2 - width / 2, this.q - 44, -1);
            this.n = 0.0f;
            axm.b.f = 0.0f;
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)2896);
    }

    @Override
    protected void a(ye par1ItemStack, int par2, int par3) {
        if (v == ww.g.a()) {
            Map map;
            List list = par1ItemStack.a((uf)this.f.h, this.f.u.x);
            ww creativetabs = par1ItemStack.b().y();
            if (creativetabs == null && par1ItemStack.d == yc.bY.cv && (map = aaw.a((ye)par1ItemStack)).size() == 1) {
                aau enchantment = aau.b[(Integer)map.keySet().iterator().next()];
                for (ww creativetabs1 : ww.a) {
                    if (!creativetabs1.a(enchantment.A)) continue;
                    creativetabs = creativetabs1;
                    break;
                }
            }
            if (creativetabs != null) {
                list.add(1, "" + (Object)((Object)a.r) + (Object)((Object)a.j) + bkb.a((String)creativetabs.c()));
            }
            for (int i1 = 0; i1 < list.size(); ++i1) {
                if (i1 == 0) {
                    list.set(i1, "\u00a7" + Integer.toHexString(par1ItemStack.w().e) + (String)list.get(i1));
                    continue;
                }
                list.set(i1, (Object)((Object)a.h) + (String)list.get(i1));
            }
            this.a(list, par2, par3);
        } else {
            super.a(par1ItemStack, par2, par3);
        }
    }

    @Override
    protected void a(float par1, int par2, int par3) {
        int l;
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        att.c();
        ww creativetabs = ww.a[v];
        ww[] acreativetabs = ww.a;
        int k = acreativetabs.length;
        int start = tabPage * 10;
        k = Math.min(acreativetabs.length, (tabPage + 1) * 10 + 2);
        if (tabPage != 0) {
            start += 2;
        }
        for (l = start; l < k; ++l) {
            ww creativetabs1 = acreativetabs[l];
            this.f.J().a(t);
            if (creativetabs1 == null || creativetabs1.a() == v) continue;
            this.a(creativetabs1);
        }
        if (tabPage != 0) {
            if (creativetabs != ww.g) {
                this.f.J().a(t);
                this.a(ww.g);
            }
            if (creativetabs != ww.m) {
                this.f.J().a(t);
                this.a(ww.m);
            }
        }
        this.f.J().a(new bjo("textures/gui/container/creative_inventory/tab_" + creativetabs.f()));
        this.b(this.p, this.q, 0, 0, this.c, this.d);
        this.z.f();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int i1 = this.p + 175;
        k = this.q + 18;
        l = k + 112;
        this.f.J().a(t);
        if (creativetabs.i()) {
            this.b(i1, k + (int)((float)(l - k - 17) * this.w), 232 + (this.j() ? 0 : 12), 0, 12, 15);
        }
        if ((creativetabs == null || creativetabs.getTabPage() != tabPage) && creativetabs != ww.g && creativetabs != ww.m) {
            return;
        }
        this.a(creativetabs);
        if (creativetabs == ww.m) {
            axv.a(this.p + 43, this.q + 45, 20, this.p + 43 - par2, this.q + 45 - 30 - par3, (of)this.f.h);
        }
    }

    protected boolean a(ww par1CreativeTabs, int par2, int par3) {
        if (par1CreativeTabs.getTabPage() != tabPage && par1CreativeTabs != ww.g && par1CreativeTabs != ww.m) {
            return false;
        }
        int k = par1CreativeTabs.k();
        int l = 28 * k;
        int b0 = 0;
        if (k == 5) {
            l = this.c - 28 + 2;
        } else if (k > 0) {
            l += k;
        }
        int i1 = par1CreativeTabs.l() ? b0 - 32 : b0 + this.d;
        return par2 >= l && par2 <= l + 28 && par3 >= i1 && par3 <= i1 + 32;
    }

    protected boolean b(ww par1CreativeTabs, int par2, int par3) {
        int k = par1CreativeTabs.k();
        int l = 28 * k;
        int b0 = 0;
        if (k == 5) {
            l = this.c - 28 + 2;
        } else if (k > 0) {
            l += k;
        }
        int i1 = par1CreativeTabs.l() ? b0 - 32 : b0 + this.d;
        if (this.c(l + 3, i1 + 3, 23, 27, par2, par3)) {
            this.a(bkb.a((String)par1CreativeTabs.c()), par2, par3);
            return true;
        }
        return false;
    }

    protected void a(ww par1CreativeTabs) {
        boolean flag = par1CreativeTabs.a() == v;
        boolean flag1 = par1CreativeTabs.l();
        int i = par1CreativeTabs.k();
        int j2 = i * 28;
        int k = 0;
        int l = this.p + 28 * i;
        int i1 = this.q;
        int b0 = 32;
        if (flag) {
            k += 32;
        }
        if (i == 5) {
            l = this.p + this.c - 28;
        } else if (i > 0) {
            l += i;
        }
        if (flag1) {
            i1 -= 28;
        } else {
            k += 64;
            i1 += this.d - 4;
        }
        GL11.glDisable((int)2896);
        GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
        this.b(l, i1, j2, k, 28, b0);
        this.n = 100.0f;
        axm.b.f = 100.0f;
        int n = flag1 ? 1 : -1;
        GL11.glEnable((int)2896);
        GL11.glEnable((int)32826);
        ye itemstack = par1CreativeTabs.getIconItemStack();
        b.b(this.o, this.f.J(), itemstack, l += 6, i1 += 8 + n);
        b.c(this.o, this.f.J(), itemstack, l, i1);
        GL11.glDisable((int)2896);
        axm.b.f = 0.0f;
        this.n = 0.0f;
    }

    @Override
    protected void a(aut par1GuiButton) {
        if (par1GuiButton.g == 0) {
            this.f.a(new awq(this.f.y));
        }
        if (par1GuiButton.g == 1) {
            this.f.a(new awr(this, this.f.y));
        }
        if (par1GuiButton.g == 101) {
            tabPage = Math.max(tabPage - 1, 0);
        } else if (par1GuiButton.g == 102) {
            tabPage = Math.min(tabPage + 1, this.maxPages);
        }
    }

    public int g() {
        return v;
    }

    static mu h() {
        return u;
    }
}

