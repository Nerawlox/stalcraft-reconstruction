/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aas
 *  aau
 *  aaw
 *  bu
 *  cl
 *  com.google.common.collect.HashMultimap
 *  com.google.common.collect.Multimap
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  la
 *  ms
 *  net.minecraftforge.event.ForgeEventFactory
 *  od
 *  ot
 *  wp
 */
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraftforge.event.ForgeEventFactory;

public final class ye {
    public static final DecimalFormat a = new DecimalFormat("#.###");
    public int b;
    public int c;
    public int d;
    public by e;
    int f;
    private od g;

    public ye(aqz par1Block) {
        this(par1Block, 1);
    }

    public ye(aqz par1Block, int par2) {
        this(par1Block.cF, par2, 0);
    }

    public ye(aqz par1Block, int par2, int par3) {
        this(par1Block.cF, par2, par3);
    }

    public ye(yc par1Item) {
        this(par1Item.cv, 1, 0);
    }

    public ye(yc par1Item, int par2) {
        this(par1Item.cv, par2, 0);
    }

    public ye(yc par1Item, int par2, int par3) {
        this(par1Item.cv, par2, par3);
    }

    public ye(int par1, int par2, int par3) {
        this.d = par1;
        this.b = par2;
        this.f = par3;
        if (this.f < 0) {
            this.f = 0;
        }
    }

    public static ye a(by par0NBTTagCompound) {
        ye itemstack = new ye();
        itemstack.c(par0NBTTagCompound);
        return itemstack.b() != null ? itemstack : null;
    }

    private ye() {
    }

    public ye a(int par1) {
        ye itemstack = new ye(this.d, par1, this.f);
        if (this.e != null) {
            itemstack.e = (by)this.e.b();
        }
        this.b -= par1;
        return itemstack;
    }

    public yc b() {
        return yc.g[this.d];
    }

    @SideOnly(value=Side.CLIENT)
    public ms c() {
        return this.b().h(this);
    }

    @SideOnly(value=Side.CLIENT)
    public int d() {
        return this.b().l();
    }

    public boolean a(uf par1EntityPlayer, abw par2World, int par3, int par4, int par5, int par6, float par7, float par8, float par9) {
        boolean flag = this.b().a(this, par1EntityPlayer, par2World, par3, par4, par5, par6, par7, par8, par9);
        if (flag) {
            par1EntityPlayer.a(la.E[this.d], 1);
        }
        return flag;
    }

    public float a(aqz par1Block) {
        return this.b().a(this, par1Block);
    }

    public ye a(abw par1World, uf par2EntityPlayer) {
        return this.b().a(this, par1World, par2EntityPlayer);
    }

    public ye b(abw par1World, uf par2EntityPlayer) {
        return this.b().b(this, par1World, par2EntityPlayer);
    }

    public by b(by par1NBTTagCompound) {
        par1NBTTagCompound.a("id", (short)this.d);
        par1NBTTagCompound.a("Count", (byte)this.b);
        par1NBTTagCompound.a("Damage", (short)this.f);
        if (this.e != null) {
            par1NBTTagCompound.a("tag", (cl)this.e);
        }
        return par1NBTTagCompound;
    }

    public void c(by par1NBTTagCompound) {
        this.d = par1NBTTagCompound.d("id");
        this.b = par1NBTTagCompound.c("Count");
        this.f = par1NBTTagCompound.d("Damage");
        if (this.f < 0) {
            this.f = 0;
        }
        if (par1NBTTagCompound.b("tag")) {
            this.e = par1NBTTagCompound.l("tag");
        }
    }

    public int e() {
        return this.b().getItemStackLimit(this);
    }

    public boolean f() {
        return this.e() > 1 && (!this.g() || !this.i());
    }

    public boolean g() {
        return yc.g[this.d].getMaxDamage(this) > 0;
    }

    public boolean h() {
        return yc.g[this.d].n();
    }

    public boolean i() {
        boolean damaged;
        boolean bl2 = damaged = this.f > 0;
        if (this.b() != null) {
            damaged = this.b().isDamaged(this);
        }
        return this.g() && damaged;
    }

    public int j() {
        if (this.b() != null) {
            return this.b().getDisplayDamage(this);
        }
        return this.f;
    }

    public int k() {
        if (this.b() != null) {
            return this.b().getDamage(this);
        }
        return this.f;
    }

    public void b(int par1) {
        if (this.b() != null) {
            this.b().setDamage(this, par1);
            return;
        }
        this.f = par1;
        if (this.f < 0) {
            this.f = 0;
        }
    }

    public int l() {
        return this.b().getMaxDamage(this);
    }

    public boolean a(int par1, Random par2Random) {
        if (!this.g()) {
            return false;
        }
        if (par1 > 0) {
            int j2 = aaw.a((int)aau.t.z, (ye)this);
            int k2 = 0;
            for (int l2 = 0; j2 > 0 && l2 < par1; ++l2) {
                if (!aas.a((ye)this, (int)j2, (Random)par2Random)) continue;
                ++k2;
            }
            if ((par1 -= k2) <= 0) {
                return false;
            }
        }
        this.b(this.k() + par1);
        return this.k() > this.l();
    }

    public void a(int par1, of par2EntityLivingBase) {
        if ((!(par2EntityLivingBase instanceof uf) || !((uf)par2EntityLivingBase).bG.d) && this.g() && this.a(par1, par2EntityLivingBase.aD())) {
            par2EntityLivingBase.a(this);
            --this.b;
            if (par2EntityLivingBase instanceof uf) {
                uf entityplayer = (uf)par2EntityLivingBase;
                entityplayer.a(la.F[this.d], 1);
                if (this.b == 0 && this.b() instanceof wp) {
                    entityplayer.bz();
                }
            }
            if (this.b < 0) {
                this.b = 0;
            }
            this.f = 0;
        }
    }

    public void a(of par1EntityLivingBase, uf par2EntityPlayer) {
        boolean flag = yc.g[this.d].a(this, par1EntityLivingBase, (of)par2EntityPlayer);
        if (flag) {
            par2EntityPlayer.a(la.E[this.d], 1);
        }
    }

    public void a(abw par1World, int par2, int par3, int par4, int par5, uf par6EntityPlayer) {
        boolean flag = yc.g[this.d].a(this, par1World, par2, par3, par4, par5, par6EntityPlayer);
        if (flag) {
            par6EntityPlayer.a(la.E[this.d], 1);
        }
    }

    public boolean b(aqz par1Block) {
        return yc.g[this.d].canHarvestBlock(par1Block, this);
    }

    public boolean a(uf par1EntityPlayer, of par2EntityLivingBase) {
        return yc.g[this.d].a(this, par1EntityPlayer, par2EntityLivingBase);
    }

    public ye m() {
        ye itemstack = new ye(this.d, this.b, this.f);
        if (this.e != null) {
            itemstack.e = (by)this.e.b();
        }
        return itemstack;
    }

    public static boolean a(ye par0ItemStack, ye par1ItemStack) {
        return par0ItemStack == null && par1ItemStack == null ? true : (par0ItemStack != null && par1ItemStack != null ? (par0ItemStack.e == null && par1ItemStack.e != null ? false : par0ItemStack.e == null || par0ItemStack.e.equals((Object)par1ItemStack.e)) : false);
    }

    public static boolean b(ye par0ItemStack, ye par1ItemStack) {
        return par0ItemStack == null && par1ItemStack == null ? true : (par0ItemStack != null && par1ItemStack != null ? par0ItemStack.d(par1ItemStack) : false);
    }

    private boolean d(ye par1ItemStack) {
        return this.b != par1ItemStack.b ? false : (this.d != par1ItemStack.d ? false : (this.f != par1ItemStack.f ? false : (this.e == null && par1ItemStack.e != null ? false : this.e == null || this.e.equals((Object)par1ItemStack.e))));
    }

    public boolean a(ye par1ItemStack) {
        return this.d == par1ItemStack.d && this.f == par1ItemStack.f;
    }

    public String a() {
        return yc.g[this.d].d(this);
    }

    public static ye b(ye par0ItemStack) {
        return par0ItemStack == null ? null : par0ItemStack.m();
    }

    public String toString() {
        return this.b + "x" + yc.g[this.d].a() + "@" + this.f;
    }

    public void a(abw par1World, nn par2Entity, int par3, boolean par4) {
        if (this.c > 0) {
            --this.c;
        }
        yc.g[this.d].a(this, par1World, par2Entity, par3, par4);
    }

    public void a(abw par1World, uf par2EntityPlayer, int par3) {
        par2EntityPlayer.a(la.D[this.d], par3);
        yc.g[this.d].d(this, par1World, par2EntityPlayer);
    }

    public int n() {
        return this.b().d_(this);
    }

    public zj o() {
        return this.b().c_(this);
    }

    public void b(abw par1World, uf par2EntityPlayer, int par3) {
        this.b().a(this, par1World, par2EntityPlayer, par3);
    }

    public boolean p() {
        return this.e != null;
    }

    public by q() {
        return this.e;
    }

    public cg r() {
        return this.e == null ? null : (cg)this.e.a("ench");
    }

    public void d(by par1NBTTagCompound) {
        this.e = par1NBTTagCompound;
    }

    public String s() {
        by nbttagcompound;
        String s2 = this.b().l(this);
        if (this.e != null && this.e.b("display") && (nbttagcompound = this.e.l("display")).b("Name")) {
            s2 = nbttagcompound.i("Name");
        }
        return s2;
    }

    public void c(String par1Str) {
        if (this.e == null) {
            this.e = new by("tag");
        }
        if (!this.e.b("display")) {
            this.e.a("display", new by());
        }
        this.e.l("display").a("Name", par1Str);
    }

    public void t() {
        if (this.e != null && this.e.b("display")) {
            by nbttagcompound = this.e.l("display");
            nbttagcompound.o("Name");
            if (nbttagcompound.d()) {
                this.e.o("display");
                if (this.e.d()) {
                    this.d((by)null);
                }
            }
        }
    }

    public boolean u() {
        return this.e == null ? false : (!this.e.b("display") ? false : this.e.l("display").b("Name"));
    }

    @SideOnly(value=Side.CLIENT)
    public List a(uf par1EntityPlayer, boolean par2) {
        Multimap multimap;
        ArrayList<String> arraylist = new ArrayList<String>();
        yc item = yc.g[this.d];
        String s2 = this.s();
        if (this.u()) {
            s2 = (Object)((Object)a.u) + s2 + (Object)((Object)a.v);
        }
        if (par2) {
            String s1 = "";
            if (s2.length() > 0) {
                s2 = s2 + " (";
                s1 = ")";
            }
            s2 = this.h() ? s2 + String.format("#%04d/%d%s", this.d, this.f, s1) : s2 + String.format("#%04d%s", this.d, s1);
        } else if (!this.u() && this.d == yc.bf.cv) {
            s2 = s2 + " #" + this.f;
        }
        arraylist.add(s2);
        item.a(this, par1EntityPlayer, arraylist, par2);
        if (this.p()) {
            cg nbttaglist = this.r();
            if (nbttaglist != null) {
                for (int i2 = 0; i2 < nbttaglist.c(); ++i2) {
                    short short1 = ((by)nbttaglist.b(i2)).d("id");
                    short short2 = ((by)nbttaglist.b(i2)).d("lvl");
                    if (aau.b[short1] == null) continue;
                    arraylist.add(aau.b[short1].c((int)short2));
                }
            }
            if (this.e.b("display")) {
                cg nbttaglist1;
                by nbttagcompound = this.e.l("display");
                if (nbttagcompound.b("color")) {
                    if (par2) {
                        arraylist.add("Color: #" + Integer.toHexString(nbttagcompound.e("color")).toUpperCase());
                    } else {
                        arraylist.add((Object)((Object)a.u) + bu.a((String)"item.dyed"));
                    }
                }
                if (nbttagcompound.b("Lore") && (nbttaglist1 = nbttagcompound.m("Lore")).c() > 0) {
                    for (int j2 = 0; j2 < nbttaglist1.c(); ++j2) {
                        arraylist.add((Object)((Object)a.f) + "" + (Object)((Object)a.u) + ((ck)nbttaglist1.b((int)j2)).a);
                    }
                }
            }
        }
        if (!(multimap = this.D()).isEmpty()) {
            arraylist.add("");
            for (Map.Entry entry : multimap.entries()) {
                ot attributemodifier = (ot)entry.getValue();
                double d0 = attributemodifier.d();
                double d1 = attributemodifier.c() != 1 && attributemodifier.c() != 2 ? attributemodifier.d() : attributemodifier.d() * 100.0;
                if (d0 > 0.0) {
                    arraylist.add((Object)((Object)a.j) + bu.a((String)("attribute.modifier.plus." + attributemodifier.c()), (Object[])new Object[]{a.format(d1), bu.a((String)("attribute.name." + (String)entry.getKey()))}));
                    continue;
                }
                if (!(d0 < 0.0)) continue;
                arraylist.add((Object)((Object)a.m) + bu.a((String)("attribute.modifier.take." + attributemodifier.c()), (Object[])new Object[]{a.format(d1 *= -1.0), bu.a((String)("attribute.name." + (String)entry.getKey()))}));
            }
        }
        if (par2 && this.i()) {
            arraylist.add("Durability: " + (this.l() - this.j()) + " / " + this.l());
        }
        ForgeEventFactory.onItemTooltip((ye)this, (uf)par1EntityPlayer, arraylist, (boolean)par2);
        return arraylist;
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public boolean v() {
        return this.hasEffect(0);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean hasEffect(int pass) {
        return this.b().hasEffect(this, pass);
    }

    @SideOnly(value=Side.CLIENT)
    public yq w() {
        return this.b().f(this);
    }

    public boolean x() {
        return !this.b().e_(this) ? false : !this.y();
    }

    public void a(aau par1Enchantment, int par2) {
        if (this.e == null) {
            this.d(new by());
        }
        if (!this.e.b("ench")) {
            this.e.a("ench", new cg("ench"));
        }
        cg nbttaglist = (cg)this.e.a("ench");
        by nbttagcompound = new by();
        nbttagcompound.a("id", (short)par1Enchantment.z);
        nbttagcompound.a("lvl", (short)((byte)par2));
        nbttaglist.a(nbttagcompound);
    }

    public boolean y() {
        return this.e != null && this.e.b("ench");
    }

    public void a(String par1Str, cl par2NBTBase) {
        if (this.e == null) {
            this.d(new by());
        }
        this.e.a(par1Str, par2NBTBase);
    }

    public boolean z() {
        return this.b().z();
    }

    public boolean A() {
        return this.g != null;
    }

    public void a(od par1EntityItemFrame) {
        this.g = par1EntityItemFrame;
    }

    public od B() {
        return this.g;
    }

    public int C() {
        return this.p() && this.e.b("RepairCost") ? this.e.e("RepairCost") : 0;
    }

    public void c(int par1) {
        if (!this.p()) {
            this.e = new by("tag");
        }
        this.e.a("RepairCost", par1);
    }

    public Multimap D() {
        Multimap object;
        if (this.p() && this.e.b("AttributeModifiers")) {
            object = HashMultimap.create();
            cg nbttaglist = this.e.m("AttributeModifiers");
            for (int i2 = 0; i2 < nbttaglist.c(); ++i2) {
                by nbttagcompound = (by)nbttaglist.b(i2);
                ot attributemodifier = tp.a(nbttagcompound);
                if (attributemodifier.a().getLeastSignificantBits() == 0L || attributemodifier.a().getMostSignificantBits() == 0L) continue;
                object.put((Object)nbttagcompound.i("AttributeName"), (Object)attributemodifier);
            }
        } else {
            object = this.b().h();
        }
        return object;
    }
}

