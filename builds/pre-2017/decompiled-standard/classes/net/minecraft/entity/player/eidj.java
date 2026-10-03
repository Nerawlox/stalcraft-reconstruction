/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.player;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.stalker.misc.qlgf;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.kjui;
import net.minecraft.util.turb;

public class eidj
implements mssh {
    public cvzo[] _a = new cvzo[36];
    public cvzo[] _b = new cvzo[4];
    public int _c;
    @SideOnly(value=Side.CLIENT)
    public cvzo _d;
    public EntityPlayer _e;
    public cvzo _f;
    public boolean _g;

    public eidj(EntityPlayer entityPlayer) {
        this._e = entityPlayer;
    }

    public cvzo _a() {
        return this._c < 9 && this._c >= 0 ? this._a[this._c] : null;
    }

    public static int _b() {
        return 9;
    }

    public int _a(int n) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null || this._a[i]._d != n) continue;
            return i;
        }
        return -1;
    }

    @SideOnly(value=Side.CLIENT)
    public int _a(int n, int n2) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null || this._a[i]._d != n || this._a[i]._j() != n2) continue;
            return i;
        }
        return -1;
    }

    public int _a(cvzo cvzo2) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null || this._a[i]._d != cvzo2._d || !this._a[i]._e() || this._a[i]._b >= this._a[i]._d() || this._a[i]._b >= this.func_70297_j_() || this._a[i]._g() && this._a[i]._j() != cvzo2._j() || !cvzo._a(this._a[i], cvzo2)) continue;
            return i;
        }
        return -1;
    }

    public int _c() {
        int n = GloomyHooks.getFirstEmptyStack(this);
        return n;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(int n, int n2, boolean bl, boolean bl2) {
        boolean bl3 = true;
        this._d = this._a();
        int n3 = bl ? this._a(n, n2) : this._a(n);
        if (n3 >= 0 && n3 < 9) {
            this._c = n3;
        } else if (bl2 && n > 0) {
            int n4 = this._c();
            if (n4 >= 0 && n4 < 9) {
                this._c = n4;
            }
            this._a(tgdv.field_77698_e[n], n2);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void _b(int n) {
        if (n > 0) {
            n = 1;
        }
        if (n < 0) {
            n = -1;
        }
        this._c -= n;
        while (this._c < 0) {
            this._c += 9;
        }
        while (this._c >= 9) {
            this._c -= 9;
        }
        GloomyHooks.changeCurrentItem(this, n);
    }

    public int _b(int n, int n2) {
        cvzo cvzo2;
        int n3;
        int n4 = 0;
        for (n3 = 0; n3 < this._a.length; ++n3) {
            cvzo2 = this._a[n3];
            if (cvzo2 == null || n > -1 && cvzo2._d != n || n2 > -1 && cvzo2._j() != n2) continue;
            n4 += cvzo2._b;
            this._a[n3] = null;
        }
        for (n3 = 0; n3 < this._b.length; ++n3) {
            cvzo2 = this._b[n3];
            if (cvzo2 == null || n > -1 && cvzo2._d != n || n2 > -1 && cvzo2._j() != n2) continue;
            n4 += cvzo2._b;
            this._b[n3] = null;
        }
        if (this._f != null) {
            if (n > -1 && this._f._d != n) {
                return n4;
            }
            if (n2 > -1 && this._f._j() != n2) {
                return n4;
            }
            n4 += this._f._b;
            this._d(null);
        }
        return n4;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(tgdv tgdv2, int n) {
        if (tgdv2 != null) {
            if (this._d != null && this._d._x() && this._a(this._d._d, this._d._i()) == this._c) {
                return;
            }
            int n2 = this._a(tgdv2.field_77779_bT, n);
            if (n2 >= 0) {
                int n3 = this._a[n2]._b;
                this._a[n2] = this._a[this._c];
                this._a[this._c] = new cvzo(tgdv.field_77698_e[tgdv2.field_77779_bT], n3, n);
            } else {
                this._a[this._c] = new cvzo(tgdv.field_77698_e[tgdv2.field_77779_bT], 1, n);
            }
        }
    }

    public int _b(cvzo cvzo2) {
        int n = cvzo2._d;
        int n2 = cvzo2._b;
        if (cvzo2._d() == 1) {
            int n3 = this._c();
            if (n3 < 0) {
                return n2;
            }
            if (this._a[n3] == null) {
                this._a[n3] = cvzo._c(cvzo2);
            }
            return 0;
        }
        int n4 = this._a(cvzo2);
        if (n4 < 0) {
            n4 = this._c();
        }
        if (n4 < 0) {
            return n2;
        }
        if (this._a[n4] == null) {
            this._a[n4] = new cvzo(n, 0, cvzo2._j());
            if (cvzo2._p()) {
                this._a[n4]._d((qoac)cvzo2._q()._c());
            }
        }
        int n5 = n2;
        if (n2 > this._a[n4]._d() - this._a[n4]._b) {
            n5 = this._a[n4]._d() - this._a[n4]._b;
        }
        if (n5 > this.func_70297_j_() - this._a[n4]._b) {
            n5 = this.func_70297_j_() - this._a[n4]._b;
        }
        if (n5 == 0) {
            return n2;
        }
        this._a[n4]._b += n5;
        this._a[n4]._c = 5;
        return n2 -= n5;
    }

    public void _d() {
        int n;
        for (n = 0; n < this._a.length; ++n) {
            if (this._a[n] == null) continue;
            this._a[n]._a(this._e.field_70170_p, this._e, n, this._c == n);
        }
        for (n = 0; n < this._b.length; ++n) {
            if (this._b[n] == null) continue;
            this._b[n]._a().onArmorTickUpdate(this._e.field_70170_p, this._e, this._b[n]);
        }
    }

    public boolean _c(int n) {
        int n2 = this._a(n);
        if (n2 < 0) {
            return false;
        }
        if (--this._a[n2]._b <= 0) {
            this._a[n2] = null;
        }
        return true;
    }

    public boolean _d(int n) {
        int n2 = this._a(n);
        return n2 >= 0;
    }

    public boolean _c(cvzo cvzo2) {
        int n = qlgf._a(this, cvzo2);
        if (n != 0) {
            return qlgf._b(this, cvzo2);
        }
        if (cvzo2 == null) {
            return false;
        }
        if (cvzo2._b == 0) {
            return false;
        }
        try {
            if (cvzo2._h()) {
                n = this._c();
                if (n >= 0) {
                    this._a[n] = cvzo._c(cvzo2);
                    this._a[n]._c = 5;
                    cvzo2._b = 0;
                    return true;
                }
                if (this._e.field_71075_bZ._d) {
                    cvzo2._b = 0;
                    return true;
                }
                return false;
            }
            do {
                n = cvzo2._b;
                cvzo2._b = this._b(cvzo2);
            } while (cvzo2._b > 0 && cvzo2._b < n);
            if (cvzo2._b == n && this._e.field_71075_bZ._d) {
                cvzo2._b = 0;
                return true;
            }
            return cvzo2._b < n;
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.func_85055_a(throwable, "Adding item to inventory");
            jxsn jxsn2 = crashReport.func_85058_a("Item being added");
            jxsn2._a("Item ID", cvzo2._d);
            jxsn2._a("Item data", cvzo2._j());
            jxsn2._a("Item name", new kjui(this, cvzo2));
            throw new turb(crashReport);
        }
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        cvzo[] cvzoArray = this._a;
        if (n >= this._a.length) {
            cvzoArray = this._b;
            n -= this._a.length;
        }
        if (cvzoArray[n] != null) {
            if (cvzoArray[n]._b <= n2) {
                cvzo cvzo2 = cvzoArray[n];
                cvzoArray[n] = null;
                return cvzo2;
            }
            cvzo cvzo3 = cvzoArray[n]._a(n2);
            if (cvzoArray[n]._b == 0) {
                cvzoArray[n] = null;
            }
            return cvzo3;
        }
        return null;
    }

    @Override
    public cvzo func_70304_b(int n) {
        cvzo[] cvzoArray = this._a;
        if (n >= this._a.length) {
            cvzoArray = this._b;
            n -= this._a.length;
        }
        if (cvzoArray[n] != null) {
            cvzo cvzo2 = cvzoArray[n];
            cvzoArray[n] = null;
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        GloomyHooks.setInventorySlotContents(this, n, cvzo2);
        cvzo[] cvzoArray = this._a;
        if (n >= cvzoArray.length) {
            n -= cvzoArray.length;
            cvzoArray = this._b;
        }
        cvzoArray[n] = cvzo2;
    }

    public float _a(twgu twgu2) {
        float f = 1.0f;
        if (this._a[this._c] != null) {
            f *= this._a[this._c]._a(twgu2);
        }
        return f;
    }

    public bsyv _a(bsyv bsyv2) {
        qoac qoac2;
        int n;
        for (n = 0; n < this._a.length; ++n) {
            if (this._a[n] == null) continue;
            qoac2 = new qoac();
            qoac2._a("Slot", (byte)n);
            this._a[n]._b(qoac2);
            bsyv2._a(qoac2);
        }
        for (n = 0; n < this._b.length; ++n) {
            if (this._b[n] == null) continue;
            qoac2 = new qoac();
            qoac2._a("Slot", (byte)(n + 100));
            this._b[n]._b(qoac2);
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public void _b(bsyv bsyv2) {
        this._a = new cvzo[36];
        this._b = new cvzo[4];
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            int n = qoac2._d("Slot") & 0xFF;
            cvzo cvzo2 = cvzo._a(qoac2);
            if (cvzo2 == null) continue;
            if (n >= 0 && n < this._a.length) {
                this._a[n] = cvzo2;
            }
            if (n < 100 || n >= this._b.length + 100) continue;
            this._b[n - 100] = cvzo2;
        }
    }

    @Override
    public int func_70302_i_() {
        return this._a.length + 4;
    }

    @Override
    public cvzo func_70301_a(int n) {
        cvzo[] cvzoArray = this._a;
        if (n >= cvzoArray.length) {
            n -= cvzoArray.length;
            cvzoArray = this._b;
        }
        return cvzoArray[n];
    }

    @Override
    public String func_70303_b() {
        return "container.inventory";
    }

    @Override
    public boolean func_94042_c() {
        return false;
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    public boolean _b(twgu twgu2) {
        if (twgu2.field_72018_cp._l()) {
            return true;
        }
        cvzo cvzo2 = this.func_70301_a(this._c);
        return cvzo2 != null ? cvzo2._b(twgu2) : false;
    }

    public cvzo _e(int n) {
        return this._b[n];
    }

    public int _e() {
        int n = 0;
        for (int i = 0; i < this._b.length; ++i) {
            if (this._b[i] == null || !(this._b[i]._a() instanceof lpno)) continue;
            int n2 = ((lpno)this._b[i]._a()).field_77879_b;
            n += n2;
        }
        return n;
    }

    public void _a(float f) {
        GloomyHooks.damageArmor(this, f);
    }

    public void _f() {
        int n;
        for (n = 0; n < this._a.length; ++n) {
            if (this._a[n] == null) continue;
            this._e.func_71019_a(this._a[n], true);
            this._a[n] = null;
        }
        for (n = 0; n < this._b.length; ++n) {
            if (this._b[n] == null) continue;
            this._e.func_71019_a(this._b[n], true);
            this._b[n] = null;
        }
    }

    @Override
    public void func_70296_d() {
        this._g = true;
    }

    public void _d(cvzo cvzo2) {
        this._f = cvzo2;
    }

    public cvzo _g() {
        return this._f;
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return this._e.field_70128_L ? false : entityPlayer.func_70068_e(this._e) <= 64.0;
    }

    public boolean _e(cvzo cvzo2) {
        int n;
        for (n = 0; n < this._b.length; ++n) {
            if (this._b[n] == null || !this._b[n]._b(cvzo2)) continue;
            return true;
        }
        for (n = 0; n < this._a.length; ++n) {
            if (this._a[n] == null || !this._a[n]._b(cvzo2)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void func_70295_k_() {
    }

    @Override
    public void func_70305_f() {
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return true;
    }

    public void _a(eidj eidj2) {
        int n;
        for (n = 0; n < this._a.length; ++n) {
            this._a[n] = cvzo._c(eidj2._a[n]);
        }
        for (n = 0; n < this._b.length; ++n) {
            this._b[n] = cvzo._c(eidj2._b[n]);
        }
        this._c = eidj2._c;
    }
}

