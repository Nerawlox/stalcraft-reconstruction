/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.util.Arrays;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.turb;

public class ydir
implements mssh {
    public cvzo[] _a = new cvzo[13];
    public EntityPlayer _b;
    public boolean _c;

    public ydir(EntityPlayer entityPlayer) {
        this._b = entityPlayer;
    }

    private int _c(int n) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null || this._a[i]._d != n) continue;
            return i;
        }
        return -1;
    }

    @ezey(_a={eidj.CLIENT})
    private int _b(int n, int n2) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null || this._a[i]._d != n || this._a[i]._j() != n2) continue;
            return i;
        }
        return -1;
    }

    private int _d(cvzo cvzo2) {
        return -1;
    }

    public int _a() {
        return -1;
    }

    public int _a(int n, int n2) {
        int n3 = 0;
        for (int i = 0; i < this._a.length; ++i) {
            cvzo cvzo2 = this._a[i];
            if (cvzo2 == null || n > -1 && cvzo2._d != n || n2 > -1 && cvzo2._j() != n2) continue;
            n3 += cvzo2._b;
            this._a[i] = null;
        }
        return n3;
    }

    private int _e(cvzo cvzo2) {
        int n = cvzo2._d;
        int n2 = cvzo2._b;
        if (cvzo2._d() == 1) {
            int n3 = this._a();
            if (n3 < 0) {
                return n2;
            }
            if (this._a[n3] == null) {
                this._a[n3] = cvzo._c(cvzo2);
            }
            return 0;
        }
        int n4 = this._d(cvzo2);
        if (n4 < 0) {
            n4 = this._a();
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

    public void _b() {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null) continue;
            this._a[i]._a(this._b.field_70170_p, this._b, i, false);
        }
    }

    public boolean _a(int n) {
        int n2 = this._c(n);
        if (n2 < 0) {
            return false;
        }
        if (--this._a[n2]._b <= 0) {
            this._a[n2] = null;
        }
        return true;
    }

    public boolean _b(int n) {
        int n2 = this._c(n);
        return n2 >= 0;
    }

    public boolean _a(cvzo cvzo2) {
        if (cvzo2 == null) {
            return false;
        }
        if (cvzo2._b == 0) {
            return false;
        }
        try {
            int n;
            if (cvzo2._h()) {
                int n2 = this._a();
                if (n2 >= 0) {
                    this._a[n2] = cvzo._c(cvzo2);
                    this._a[n2]._c = 5;
                    cvzo2._b = 0;
                    return true;
                }
                if (this._b.field_71075_bZ._d) {
                    cvzo2._b = 0;
                    return true;
                }
                return false;
            }
            do {
                n = cvzo2._b;
                cvzo2._b = this._e(cvzo2);
            } while (cvzo2._b > 0 && cvzo2._b < n);
            if (cvzo2._b == n && this._b.field_71075_bZ._d) {
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
            throw new turb(crashReport);
        }
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        cvzo[] cvzoArray = this._a;
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
        if (cvzoArray[n] != null) {
            cvzo cvzo2 = cvzoArray[n];
            cvzoArray[n] = null;
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this._a[n] = cvzo2;
    }

    public bsyv _a(bsyv bsyv2) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null) continue;
            qoac qoac2 = new qoac();
            qoac2._a("Slot", (byte)i);
            this._a[i]._b(qoac2);
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public void _b(bsyv bsyv2) {
        this._a = new cvzo[13];
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            int n = qoac2._d("Slot") & 0xFF;
            cvzo cvzo2 = cvzo._a(qoac2);
            if (cvzo2 == null || n >= this._a.length) continue;
            this._a[n] = cvzo2;
        }
    }

    @Override
    public int func_70302_i_() {
        return this._a.length;
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this._a[n];
    }

    @Override
    public String func_70303_b() {
        return "container.stalkerinventory";
    }

    @Override
    public boolean func_94042_c() {
        return false;
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    public void _c() {
        for (int i = 0; i < 12; ++i) {
            if (this._a[i] == null) continue;
            this._b.func_71019_a(this._a[i], true);
            this._a[i] = null;
        }
    }

    @Override
    public void func_70296_d() {
        this._c = true;
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return this._b.field_70128_L ? false : entityPlayer.func_70068_e(this._b) <= 64.0;
    }

    public boolean _b(cvzo cvzo2) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null || !this._a[i]._b(cvzo2)) continue;
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

    public void _a(ydir ydir2) {
        for (int i = 0; i < this._a.length; ++i) {
            this._a[i] = cvzo._c(ydir2._a[i]);
        }
    }

    public cvzo[] _d() {
        return Arrays.copyOfRange(this._a, 5, 8);
    }

    public cvzo _e() {
        return this._a[12];
    }

    public void _c(cvzo cvzo2) {
        this._a[12] = cvzo2;
    }
}

