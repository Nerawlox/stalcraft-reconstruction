/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mo
 *  ud
 *  vi
 *  we
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class uy {
    public List b = new ArrayList();
    public List c = new ArrayList();
    public int d;
    @SideOnly(value=Side.CLIENT)
    private short a;
    private int f = -1;
    private int g;
    private final Set h = new HashSet();
    protected List e = new ArrayList();
    private Set i = new HashSet();

    protected we a(we par1Slot) {
        par1Slot.g = this.c.size();
        this.c.add(par1Slot);
        this.b.add(null);
        return par1Slot;
    }

    public void a(vi par1ICrafting) {
        if (this.e.contains(par1ICrafting)) {
            throw new IllegalArgumentException("Listener already listening");
        }
        this.e.add(par1ICrafting);
        par1ICrafting.a(this, this.a());
        this.b();
    }

    public List a() {
        ArrayList<ye> arraylist = new ArrayList<ye>();
        for (int i2 = 0; i2 < this.c.size(); ++i2) {
            arraylist.add(((we)this.c.get(i2)).d());
        }
        return arraylist;
    }

    @SideOnly(value=Side.CLIENT)
    public void b(vi par1ICrafting) {
        this.e.remove(par1ICrafting);
    }

    public void b() {
        for (int i2 = 0; i2 < this.c.size(); ++i2) {
            ye itemstack = ((we)this.c.get(i2)).d();
            ye itemstack1 = (ye)this.b.get(i2);
            if (ye.b(itemstack1, itemstack)) continue;
            itemstack1 = itemstack == null ? null : itemstack.m();
            this.b.set(i2, itemstack1);
            for (int j2 = 0; j2 < this.e.size(); ++j2) {
                ((vi)this.e.get(j2)).a(this, i2, itemstack1);
            }
        }
    }

    public boolean a(uf par1EntityPlayer, int par2) {
        return false;
    }

    public we a(mo par1IInventory, int par2) {
        for (int j2 = 0; j2 < this.c.size(); ++j2) {
            we slot = (we)this.c.get(j2);
            if (!slot.a(par1IInventory, par2)) continue;
            return slot;
        }
        return null;
    }

    public we a(int par1) {
        return (we)this.c.get(par1);
    }

    public ye b(uf par1EntityPlayer, int par2) {
        we slot = (we)this.c.get(par2);
        return slot != null ? slot.d() : null;
    }

    public ye a(int par1, int par2, int par3, uf par4EntityPlayer) {
        ye itemstack = null;
        ud inventoryplayer = par4EntityPlayer.bn;
        if (par3 == 5) {
            int i1 = this.g;
            this.g = uy.c(par2);
            if ((i1 != 1 || this.g != 2) && i1 != this.g) {
                this.d();
            } else if (inventoryplayer.o() == null) {
                this.d();
            } else if (this.g == 0) {
                this.f = uy.b(par2);
                if (uy.d(this.f)) {
                    this.g = 1;
                    this.h.clear();
                } else {
                    this.d();
                }
            } else if (this.g == 1) {
                we slot = (we)this.c.get(par1);
                if (slot != null && uy.a(slot, inventoryplayer.o(), true) && slot.a(inventoryplayer.o()) && inventoryplayer.o().b > this.h.size() && this.b(slot)) {
                    this.h.add(slot);
                }
            } else if (this.g == 2) {
                if (!this.h.isEmpty()) {
                    ye itemstack1 = inventoryplayer.o().m();
                    int l2 = inventoryplayer.o().b;
                    for (we slot1 : this.h) {
                        if (slot1 == null || !uy.a(slot1, inventoryplayer.o(), true) || !slot1.a(inventoryplayer.o()) || inventoryplayer.o().b < this.h.size() || !this.b(slot1)) continue;
                        ye itemstack2 = itemstack1.m();
                        int j1 = slot1.e() ? slot1.d().b : 0;
                        uy.a(this.h, this.f, itemstack2, j1);
                        if (itemstack2.b > itemstack2.e()) {
                            itemstack2.b = itemstack2.e();
                        }
                        if (itemstack2.b > slot1.a()) {
                            itemstack2.b = slot1.a();
                        }
                        l2 -= itemstack2.b - j1;
                        slot1.c(itemstack2);
                    }
                    itemstack1.b = l2;
                    if (itemstack1.b <= 0) {
                        itemstack1 = null;
                    }
                    inventoryplayer.b(itemstack1);
                }
                this.d();
            } else {
                this.d();
            }
        } else if (this.g != 0) {
            this.d();
        } else if (!(par3 != 0 && par3 != 1 || par2 != 0 && par2 != 1)) {
            if (par1 == -999) {
                if (inventoryplayer.o() != null && par1 == -999) {
                    if (par2 == 0) {
                        par4EntityPlayer.b(inventoryplayer.o());
                        inventoryplayer.b((ye)null);
                    }
                    if (par2 == 1) {
                        par4EntityPlayer.b(inventoryplayer.o().a(1));
                        if (inventoryplayer.o().b == 0) {
                            inventoryplayer.b((ye)null);
                        }
                    }
                }
            } else if (par3 == 1) {
                ye itemstack1;
                if (par1 < 0) {
                    return null;
                }
                we slot2 = (we)this.c.get(par1);
                if (slot2 != null && slot2.a(par4EntityPlayer) && (itemstack1 = this.b(par4EntityPlayer, par1)) != null) {
                    int l3 = itemstack1.d;
                    itemstack = itemstack1.m();
                    if (slot2 != null && slot2.d() != null && slot2.d().d == l3) {
                        this.a(par1, par2, true, par4EntityPlayer);
                    }
                }
            } else {
                if (par1 < 0) {
                    return null;
                }
                we slot2 = (we)this.c.get(par1);
                if (slot2 != null) {
                    ye itemstack1 = slot2.d();
                    ye itemstack4 = inventoryplayer.o();
                    if (itemstack1 != null) {
                        itemstack = itemstack1.m();
                    }
                    if (itemstack1 == null) {
                        if (itemstack4 != null && slot2.a(itemstack4)) {
                            int k1;
                            int n2 = k1 = par2 == 0 ? itemstack4.b : 1;
                            if (k1 > slot2.a()) {
                                k1 = slot2.a();
                            }
                            if (itemstack4.b >= k1) {
                                slot2.c(itemstack4.a(k1));
                            }
                            if (itemstack4.b == 0) {
                                inventoryplayer.b((ye)null);
                            }
                        }
                    } else if (slot2.a(par4EntityPlayer)) {
                        int k1;
                        if (itemstack4 == null) {
                            int k12 = par2 == 0 ? itemstack1.b : (itemstack1.b + 1) / 2;
                            ye itemstack3 = slot2.a(k12);
                            inventoryplayer.b(itemstack3);
                            if (itemstack1.b == 0) {
                                slot2.c((ye)null);
                            }
                            slot2.a(par4EntityPlayer, inventoryplayer.o());
                        } else if (slot2.a(itemstack4)) {
                            if (itemstack1.d == itemstack4.d && itemstack1.k() == itemstack4.k() && ye.a(itemstack1, itemstack4)) {
                                int k13;
                                int n3 = k13 = par2 == 0 ? itemstack4.b : 1;
                                if (k13 > slot2.a() - itemstack1.b) {
                                    k13 = slot2.a() - itemstack1.b;
                                }
                                if (k13 > itemstack4.e() - itemstack1.b) {
                                    k13 = itemstack4.e() - itemstack1.b;
                                }
                                itemstack4.a(k13);
                                if (itemstack4.b == 0) {
                                    inventoryplayer.b((ye)null);
                                }
                                itemstack1.b += k13;
                            } else if (itemstack4.b <= slot2.a()) {
                                slot2.c(itemstack4);
                                inventoryplayer.b(itemstack1);
                            }
                        } else if (itemstack1.d == itemstack4.d && itemstack4.e() > 1 && (!itemstack1.h() || itemstack1.k() == itemstack4.k()) && ye.a(itemstack1, itemstack4) && (k1 = itemstack1.b) > 0 && k1 + itemstack4.b <= itemstack4.e()) {
                            itemstack4.b += k1;
                            itemstack1 = slot2.a(k1);
                            if (itemstack1.b == 0) {
                                slot2.c((ye)null);
                            }
                            slot2.a(par4EntityPlayer, inventoryplayer.o());
                        }
                    }
                    slot2.f();
                }
            }
        } else if (par3 == 2 && par2 >= 0 && par2 < 9) {
            we slot2 = (we)this.c.get(par1);
            if (slot2.a(par4EntityPlayer)) {
                ye itemstack1 = inventoryplayer.a(par2);
                boolean flag = itemstack1 == null || slot2.f == inventoryplayer && slot2.a(itemstack1);
                int k1 = -1;
                if (!flag) {
                    k1 = inventoryplayer.j();
                    flag |= k1 > -1;
                }
                if (slot2.e() && flag) {
                    ye itemstack3 = slot2.d();
                    inventoryplayer.a(par2, itemstack3.m());
                    if (!(slot2.f == inventoryplayer && slot2.a(itemstack1) || itemstack1 == null)) {
                        if (k1 > -1) {
                            inventoryplayer.a(itemstack1);
                            slot2.a(itemstack3.b);
                            slot2.c((ye)null);
                            slot2.a(par4EntityPlayer, itemstack3);
                        }
                    } else {
                        slot2.a(itemstack3.b);
                        slot2.c(itemstack1);
                        slot2.a(par4EntityPlayer, itemstack3);
                    }
                } else if (!slot2.e() && itemstack1 != null && slot2.a(itemstack1)) {
                    inventoryplayer.a(par2, (ye)null);
                    slot2.c(itemstack1);
                }
            }
        } else if (par3 == 3 && par4EntityPlayer.bG.d && inventoryplayer.o() == null && par1 >= 0) {
            we slot2 = (we)this.c.get(par1);
            if (slot2 != null && slot2.e()) {
                ye itemstack1 = slot2.d().m();
                itemstack1.b = itemstack1.e();
                inventoryplayer.b(itemstack1);
            }
        } else if (par3 == 4 && inventoryplayer.o() == null && par1 >= 0) {
            we slot2 = (we)this.c.get(par1);
            if (slot2 != null && slot2.e() && slot2.a(par4EntityPlayer)) {
                ye itemstack1 = slot2.a(par2 == 0 ? 1 : slot2.d().b);
                slot2.a(par4EntityPlayer, itemstack1);
                par4EntityPlayer.b(itemstack1);
            }
        } else if (par3 == 6 && par1 >= 0) {
            we slot2 = (we)this.c.get(par1);
            ye itemstack1 = inventoryplayer.o();
            if (!(itemstack1 == null || slot2 != null && slot2.e() && slot2.a(par4EntityPlayer))) {
                int l4 = par2 == 0 ? 0 : this.c.size() - 1;
                int k1 = par2 == 0 ? 1 : -1;
                for (int l1 = 0; l1 < 2; ++l1) {
                    for (int i2 = l4; i2 >= 0 && i2 < this.c.size() && itemstack1.b < itemstack1.e(); i2 += k1) {
                        we slot3 = (we)this.c.get(i2);
                        if (!slot3.e() || !uy.a(slot3, itemstack1, true) || !slot3.a(par4EntityPlayer) || !this.a(itemstack1, slot3) || l1 == 0 && slot3.d().b == slot3.d().e()) continue;
                        int j2 = Math.min(itemstack1.e() - itemstack1.b, slot3.d().b);
                        ye itemstack5 = slot3.a(j2);
                        itemstack1.b += j2;
                        if (itemstack5.b <= 0) {
                            slot3.c((ye)null);
                        }
                        slot3.a(par4EntityPlayer, itemstack5);
                    }
                }
            }
            this.b();
        }
        return itemstack;
    }

    public boolean a(ye par1ItemStack, we par2Slot) {
        return true;
    }

    protected void a(int par1, int par2, boolean par3, uf par4EntityPlayer) {
        this.a(par1, par2, 1, par4EntityPlayer);
    }

    public void b(uf par1EntityPlayer) {
        ud inventoryplayer = par1EntityPlayer.bn;
        if (inventoryplayer.o() != null) {
            par1EntityPlayer.b(inventoryplayer.o());
            inventoryplayer.b((ye)null);
        }
    }

    public void a(mo par1IInventory) {
        this.b();
    }

    public void a(int par1, ye par2ItemStack) {
        this.a(par1).c(par2ItemStack);
    }

    @SideOnly(value=Side.CLIENT)
    public void a(ye[] par1ArrayOfItemStack) {
        for (int i2 = 0; i2 < par1ArrayOfItemStack.length; ++i2) {
            this.a(i2).c(par1ArrayOfItemStack[i2]);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void b(int par1, int par2) {
    }

    @SideOnly(value=Side.CLIENT)
    public short a(ud par1InventoryPlayer) {
        this.a = (short)(this.a + 1);
        return this.a;
    }

    public boolean c(uf par1EntityPlayer) {
        return !this.i.contains(par1EntityPlayer);
    }

    public void a(uf par1EntityPlayer, boolean par2) {
        if (par2) {
            this.i.remove(par1EntityPlayer);
        } else {
            this.i.add(par1EntityPlayer);
        }
    }

    public abstract boolean a(uf var1);

    protected boolean a(ye par1ItemStack, int par2, int par3, boolean par4) {
        ye itemstack1;
        we slot;
        boolean flag1 = false;
        int k2 = par2;
        if (par4) {
            k2 = par3 - 1;
        }
        if (par1ItemStack.f()) {
            while (par1ItemStack.b > 0 && (!par4 && k2 < par3 || par4 && k2 >= par2)) {
                slot = (we)this.c.get(k2);
                itemstack1 = slot.d();
                if (itemstack1 != null && itemstack1.d == par1ItemStack.d && (!par1ItemStack.h() || par1ItemStack.k() == itemstack1.k()) && ye.a(par1ItemStack, itemstack1)) {
                    int l2 = itemstack1.b + par1ItemStack.b;
                    if (l2 <= par1ItemStack.e()) {
                        par1ItemStack.b = 0;
                        itemstack1.b = l2;
                        slot.f();
                        flag1 = true;
                    } else if (itemstack1.b < par1ItemStack.e()) {
                        par1ItemStack.b -= par1ItemStack.e() - itemstack1.b;
                        itemstack1.b = par1ItemStack.e();
                        slot.f();
                        flag1 = true;
                    }
                }
                if (par4) {
                    --k2;
                    continue;
                }
                ++k2;
            }
        }
        if (par1ItemStack.b > 0) {
            k2 = par4 ? par3 - 1 : par2;
            while (!par4 && k2 < par3 || par4 && k2 >= par2) {
                slot = (we)this.c.get(k2);
                itemstack1 = slot.d();
                if (itemstack1 == null) {
                    slot.c(par1ItemStack.m());
                    slot.f();
                    par1ItemStack.b = 0;
                    flag1 = true;
                    break;
                }
                if (par4) {
                    --k2;
                    continue;
                }
                ++k2;
            }
        }
        return flag1;
    }

    public static int b(int par0) {
        return par0 >> 2 & 3;
    }

    public static int c(int par0) {
        return par0 & 3;
    }

    @SideOnly(value=Side.CLIENT)
    public static int d(int par0, int par1) {
        return par0 & 3 | (par1 & 3) << 2;
    }

    public static boolean d(int par0) {
        return par0 == 0 || par0 == 1;
    }

    protected void d() {
        this.g = 0;
        this.h.clear();
    }

    public static boolean a(we par0Slot, ye par1ItemStack, boolean par2) {
        boolean flag1;
        boolean bl2 = flag1 = par0Slot == null || !par0Slot.e();
        if (par0Slot != null && par0Slot.e() && par1ItemStack != null && par1ItemStack.a(par0Slot.d()) && ye.a(par0Slot.d(), par1ItemStack)) {
            int i2 = par2 ? 0 : par1ItemStack.b;
            flag1 |= par0Slot.d().b + i2 <= par1ItemStack.e();
        }
        return flag1;
    }

    public static void a(Set par0Set, int par1, ye par2ItemStack, int par3) {
        switch (par1) {
            case 0: {
                par2ItemStack.b = ls.d((float)par2ItemStack.b / (float)par0Set.size());
                break;
            }
            case 1: {
                par2ItemStack.b = 1;
            }
        }
        par2ItemStack.b += par3;
    }

    public boolean b(we par1Slot) {
        return true;
    }

    public static int b(mo par0IInventory) {
        if (par0IInventory == null) {
            return 0;
        }
        int i2 = 0;
        float f2 = 0.0f;
        for (int j2 = 0; j2 < par0IInventory.j_(); ++j2) {
            ye itemstack = par0IInventory.a(j2);
            if (itemstack == null) continue;
            f2 += (float)itemstack.b / (float)Math.min(par0IInventory.d(), itemstack.e());
            ++i2;
        }
        return ls.d((f2 /= (float)par0IInventory.j_()) * 14.0f) + (i2 > 0 ? 1 : 0);
    }
}

