/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;
import net.minecraft.util.sajh;

public abstract class jjgc {
    public List field_75153_a = new ArrayList();
    public List field_75151_b = new ArrayList();
    public int field_75152_c;
    public short field_75150_e;
    public int field_94535_f = -1;
    public int field_94536_g;
    public final Set field_94537_h = new HashSet();
    public List field_75149_d = new ArrayList();
    public Set field_75148_f = new HashSet();

    public yeso func_75146_a(yeso yeso2) {
        yeso2.field_75222_d = this.field_75151_b.size();
        this.field_75151_b.add(yeso2);
        this.field_75153_a.add(null);
        return yeso2;
    }

    public void func_75132_a(sdcd sdcd2) {
        if (this.field_75149_d.contains(sdcd2)) {
            throw new IllegalArgumentException("Listener already listening");
        }
        this.field_75149_d.add(sdcd2);
        sdcd2.func_71110_a(this, this.func_75138_a());
        this.func_75142_b();
    }

    public void func_82847_b(sdcd sdcd2) {
        this.field_75149_d.remove(sdcd2);
    }

    public List func_75138_a() {
        ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
        for (int i = 0; i < this.field_75151_b.size(); ++i) {
            arrayList.add(((yeso)this.field_75151_b.get(i)).func_75211_c());
        }
        return arrayList;
    }

    public void func_75142_b() {
        for (int i = 0; i < this.field_75151_b.size(); ++i) {
            cvzo cvzo2 = ((yeso)this.field_75151_b.get(i)).func_75211_c();
            cvzo cvzo3 = (cvzo)this.field_75153_a.get(i);
            if (cvzo._b(cvzo3, cvzo2)) continue;
            cvzo3 = cvzo2 == null ? null : cvzo2._l();
            this.field_75153_a.set(i, cvzo3);
            for (int j = 0; j < this.field_75149_d.size(); ++j) {
                ((sdcd)this.field_75149_d.get(j)).func_71111_a(this, i, cvzo3);
            }
        }
    }

    public boolean func_75140_a(EntityPlayer entityPlayer, int n) {
        return false;
    }

    public yeso func_75147_a(mssh mssh2, int n) {
        for (int i = 0; i < this.field_75151_b.size(); ++i) {
            yeso yeso2 = (yeso)this.field_75151_b.get(i);
            if (!yeso2.func_75217_a(mssh2, n)) continue;
            return yeso2;
        }
        return null;
    }

    public yeso func_75139_a(int n) {
        return (yeso)this.field_75151_b.get(n);
    }

    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null) {
            return yeso2.func_75211_c();
        }
        return null;
    }

    public cvzo func_75144_a(int n, int n2, int n3, EntityPlayer entityPlayer) {
        cvzo cvzo2 = GloomyHooks.slotClick(this, n, n2, n3, entityPlayer);
        return cvzo2;
    }

    public boolean func_94530_a(cvzo cvzo2, yeso yeso2) {
        return true;
    }

    public void func_75133_b(int n, int n2, boolean bl, EntityPlayer entityPlayer) {
        this.func_75144_a(n, n2, 1, entityPlayer);
    }

    public void func_75134_a(EntityPlayer entityPlayer) {
        eidj eidj2 = entityPlayer.field_71071_by;
        if (eidj2._g() != null) {
            entityPlayer.func_71021_b(eidj2._g());
            eidj2._d(null);
        }
    }

    public void func_75130_a(mssh mssh2) {
        this.func_75142_b();
    }

    public void func_75141_a(int n, cvzo cvzo2) {
        this.func_75139_a(n).func_75215_d(cvzo2);
    }

    public void func_75131_a(cvzo[] cvzoArray) {
        for (int i = 0; i < cvzoArray.length; ++i) {
            this.func_75139_a(i).func_75215_d(cvzoArray[i]);
        }
    }

    public void func_75137_b(int n, int n2) {
    }

    public short func_75136_a(eidj eidj2) {
        this.field_75150_e = (short)(this.field_75150_e + 1);
        return this.field_75150_e;
    }

    public boolean func_75129_b(EntityPlayer entityPlayer) {
        return !this.field_75148_f.contains(entityPlayer);
    }

    public void func_75128_a(EntityPlayer entityPlayer, boolean bl) {
        if (bl) {
            this.field_75148_f.remove(entityPlayer);
        } else {
            this.field_75148_f.add(entityPlayer);
        }
    }

    public abstract boolean func_75145_c(EntityPlayer var1);

    public boolean func_75135_a(cvzo cvzo2, int n, int n2, boolean bl) {
        cvzo cvzo3;
        yeso yeso2;
        boolean bl2 = false;
        int n3 = n;
        if (bl) {
            n3 = n2 - 1;
        }
        if (cvzo2._e()) {
            while (cvzo2._b > 0 && (!bl && n3 < n2 || bl && n3 >= n)) {
                yeso2 = (yeso)this.field_75151_b.get(n3);
                cvzo3 = yeso2.func_75211_c();
                if (cvzo3 != null && cvzo3._d == cvzo2._d && (!cvzo2._g() || cvzo2._j() == cvzo3._j()) && cvzo._a(cvzo2, cvzo3)) {
                    int n4 = cvzo3._b + cvzo2._b;
                    if (n4 <= cvzo2._d()) {
                        cvzo2._b = 0;
                        cvzo3._b = n4;
                        yeso2.func_75218_e();
                        bl2 = true;
                    } else if (cvzo3._b < cvzo2._d()) {
                        cvzo2._b -= cvzo2._d() - cvzo3._b;
                        cvzo3._b = cvzo2._d();
                        yeso2.func_75218_e();
                        bl2 = true;
                    }
                }
                if (bl) {
                    --n3;
                    continue;
                }
                ++n3;
            }
        }
        if (cvzo2._b > 0) {
            n3 = bl ? n2 - 1 : n;
            while (!bl && n3 < n2 || bl && n3 >= n) {
                yeso2 = (yeso)this.field_75151_b.get(n3);
                cvzo3 = yeso2.func_75211_c();
                if (cvzo3 == null) {
                    yeso2.func_75215_d(cvzo2._l());
                    yeso2.func_75218_e();
                    cvzo2._b = 0;
                    bl2 = true;
                    break;
                }
                if (bl) {
                    --n3;
                    continue;
                }
                ++n3;
            }
        }
        return bl2;
    }

    public static int func_94529_b(int n) {
        return n >> 2 & 3;
    }

    public static int func_94532_c(int n) {
        return n & 3;
    }

    public static int func_94534_d(int n, int n2) {
        return n & 3 | (n2 & 3) << 2;
    }

    public static boolean func_94528_d(int n) {
        return n == 0 || n == 1;
    }

    public void func_94533_d() {
        this.field_94536_g = 0;
        this.field_94537_h.clear();
    }

    public static boolean func_94527_a(yeso yeso2, cvzo cvzo2, boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = yeso2 == null || !yeso2.func_75216_d();
        if (yeso2 != null && yeso2.func_75216_d() && cvzo2 != null && cvzo2._b(yeso2.func_75211_c()) && cvzo._a(yeso2.func_75211_c(), cvzo2)) {
            bl2 |= yeso2.func_75211_c()._b + (bl ? 0 : cvzo2._b) <= cvzo2._d();
        }
        return bl2;
    }

    public static void func_94525_a(Set set, int n, cvzo cvzo2, int n2) {
        switch (n) {
            case 0: {
                cvzo2._b = sajh._d((float)cvzo2._b / (float)set.size());
                break;
            }
            case 1: {
                cvzo2._b = 1;
            }
        }
        cvzo2._b += n2;
    }

    public boolean func_94531_b(yeso yeso2) {
        return true;
    }

    public static int func_94526_b(mssh mssh2) {
        if (mssh2 == null) {
            return 0;
        }
        int n = 0;
        float f = 0.0f;
        for (int i = 0; i < mssh2.func_70302_i_(); ++i) {
            cvzo cvzo2 = mssh2.func_70301_a(i);
            if (cvzo2 == null) continue;
            f += (float)cvzo2._b / (float)Math.min(mssh2.func_70297_j_(), cvzo2._d());
            ++n;
        }
        return sajh._d((f /= (float)mssh2.func_70302_i_()) * 14.0f) + (n > 0 ? 1 : 0);
    }
}

