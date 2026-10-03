/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ni
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;

public class nj {
    private int a;
    public int b;
    private int c;
    private boolean d;
    private boolean e;
    @SideOnly(value=Side.CLIENT)
    private boolean f;
    private List<ye> curativeItems;

    public nj(int par1, int par2) {
        this(par1, par2, 0);
    }

    public nj(int par1, int par2, int par3) {
        this(par1, par2, par3, false);
    }

    public nj(int par1, int par2, int par3, boolean par4) {
        this.a = par1;
        this.b = par2;
        this.c = par3;
        this.e = par4;
        this.curativeItems = new ArrayList<ye>();
        this.curativeItems.add(new ye(yc.aI));
    }

    public nj(nj par1PotionEffect) {
        this.a = par1PotionEffect.a;
        this.b = par1PotionEffect.b;
        this.c = par1PotionEffect.c;
        this.curativeItems = par1PotionEffect.getCurativeItems();
    }

    public void a(nj par1PotionEffect) {
        if (this.a != par1PotionEffect.a) {
            System.err.println("This method should only be called for matching effects!");
        }
        if (par1PotionEffect.c > this.c) {
            this.c = par1PotionEffect.c;
            this.b = par1PotionEffect.b;
        } else if (par1PotionEffect.c == this.c && this.b < par1PotionEffect.b) {
            this.b = par1PotionEffect.b;
        } else if (!par1PotionEffect.e && this.e) {
            this.e = par1PotionEffect.e;
        }
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public List<ye> getCurativeItems() {
        return this.curativeItems;
    }

    public boolean isCurativeItem(ye stack) {
        boolean found = false;
        for (ye curativeItem : this.curativeItems) {
            if (!curativeItem.a(stack)) continue;
            found = true;
        }
        return found;
    }

    public void setCurativeItems(List<ye> curativeItems) {
        this.curativeItems = curativeItems;
    }

    public void addCurativeItem(ye stack) {
        boolean found = false;
        for (ye curativeItem : this.curativeItems) {
            if (!curativeItem.a(stack)) continue;
            found = true;
        }
        if (!found) {
            this.curativeItems.add(stack);
        }
    }

    public void a(boolean par1) {
        this.d = par1;
    }

    public boolean e() {
        return this.e;
    }

    public boolean a(of par1EntityLivingBase) {
        if (this.b > 0) {
            if (ni.a[this.a].a(this.b, this.c)) {
                this.b(par1EntityLivingBase);
            }
            this.h();
        }
        return this.b > 0;
    }

    private int h() {
        return --this.b;
    }

    public void b(of par1EntityLivingBase) {
        if (this.b > 0) {
            ni.a[this.a].a(par1EntityLivingBase, this.c);
        }
    }

    public String f() {
        return ni.a[this.a].a();
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        String s2 = "";
        s2 = this.c() > 0 ? this.f() + " x " + (this.c() + 1) + ", Duration: " + this.b() : this.f() + ", Duration: " + this.b();
        if (this.d) {
            s2 = s2 + ", Splash: true";
        }
        return ni.a[this.a].i() ? "(" + s2 + ")" : s2;
    }

    public boolean equals(Object par1Obj) {
        if (!(par1Obj instanceof nj)) {
            return false;
        }
        nj potioneffect = (nj)par1Obj;
        return this.a == potioneffect.a && this.c == potioneffect.c && this.b == potioneffect.b && this.d == potioneffect.d && this.e == potioneffect.e;
    }

    public by a(by par1NBTTagCompound) {
        par1NBTTagCompound.a("Id", (byte)this.a());
        par1NBTTagCompound.a("Amplifier", (byte)this.c());
        par1NBTTagCompound.a("Duration", this.b());
        par1NBTTagCompound.a("Ambient", this.e());
        return par1NBTTagCompound;
    }

    public static nj b(by par0NBTTagCompound) {
        byte b0 = par0NBTTagCompound.c("Id");
        byte b1 = par0NBTTagCompound.c("Amplifier");
        int i2 = par0NBTTagCompound.e("Duration");
        boolean flag = par0NBTTagCompound.n("Ambient");
        return new nj(b0, i2, b1, flag);
    }

    @SideOnly(value=Side.CLIENT)
    public void b(boolean par1) {
        this.f = par1;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean g() {
        return this.f;
    }
}

