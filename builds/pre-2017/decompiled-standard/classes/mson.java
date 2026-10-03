/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;
import net.minecraftforge.common.ForgeHooks;

public class mson
extends jjgc {
    public mssh field_75168_e = new dyyu(this, "Enchant", true, 1);
    public ozlu field_75172_h;
    public int field_75173_i;
    public int field_75170_j;
    public int field_75171_k;
    public Random field_75169_l = new Random();
    public long field_75166_f;
    public int[] field_75167_g = new int[3];

    public mson(eidj eidj2, ozlu ozlu2, int n, int n2, int n3) {
        int n4;
        this.field_75172_h = ozlu2;
        this.field_75173_i = n;
        this.field_75170_j = n2;
        this.field_75171_k = n3;
        this.func_75146_a(new xbpi(this, this.field_75168_e, 0, 25, 47));
        for (n4 = 0; n4 < 3; ++n4) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(eidj2, i + n4 * 9 + 9, 8 + i * 18, 84 + n4 * 18));
            }
        }
        for (n4 = 0; n4 < 9; ++n4) {
            this.func_75146_a(new yeso(eidj2, n4, 8 + n4 * 18, 142));
        }
    }

    @Override
    public void func_75132_a(sdcd sdcd2) {
        super.func_75132_a(sdcd2);
        sdcd2.func_71112_a(this, 0, this.field_75167_g[0]);
        sdcd2.func_71112_a(this, 1, this.field_75167_g[1]);
        sdcd2.func_71112_a(this, 2, this.field_75167_g[2]);
    }

    @Override
    public void func_75142_b() {
        super.func_75142_b();
        for (int i = 0; i < this.field_75149_d.size(); ++i) {
            sdcd sdcd2 = (sdcd)this.field_75149_d.get(i);
            sdcd2.func_71112_a(this, 0, this.field_75167_g[0]);
            sdcd2.func_71112_a(this, 1, this.field_75167_g[1]);
            sdcd2.func_71112_a(this, 2, this.field_75167_g[2]);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_75137_b(int n, int n2) {
        if (n >= 0 && n <= 2) {
            this.field_75167_g[n] = n2;
        } else {
            super.func_75137_b(n, n2);
        }
    }

    @Override
    public void func_75130_a(mssh mssh2) {
        if (mssh2 == this.field_75168_e) {
            cvzo cvzo2 = mssh2.func_70301_a(0);
            if (cvzo2 != null && cvzo2._x()) {
                this.field_75166_f = this.field_75169_l.nextLong();
                if (!this.field_75172_h.field_72995_K) {
                    int n;
                    boolean bl = false;
                    float f = 0.0f;
                    for (n = -1; n <= 1; ++n) {
                        for (int i = -1; i <= 1; ++i) {
                            if (n == 0 && i == 0 || !this.field_75172_h.func_72799_c(this.field_75173_i + i, this.field_75170_j, this.field_75171_k + n) || !this.field_75172_h.func_72799_c(this.field_75173_i + i, this.field_75170_j + 1, this.field_75171_k + n)) continue;
                            f += ForgeHooks.getEnchantPower(this.field_75172_h, this.field_75173_i + i * 2, this.field_75170_j, this.field_75171_k + n * 2);
                            f += ForgeHooks.getEnchantPower(this.field_75172_h, this.field_75173_i + i * 2, this.field_75170_j + 1, this.field_75171_k + n * 2);
                            if (i == 0 || n == 0) continue;
                            f += ForgeHooks.getEnchantPower(this.field_75172_h, this.field_75173_i + i * 2, this.field_75170_j, this.field_75171_k + n);
                            f += ForgeHooks.getEnchantPower(this.field_75172_h, this.field_75173_i + i * 2, this.field_75170_j + 1, this.field_75171_k + n);
                            f += ForgeHooks.getEnchantPower(this.field_75172_h, this.field_75173_i + i, this.field_75170_j, this.field_75171_k + n * 2);
                            f += ForgeHooks.getEnchantPower(this.field_75172_h, this.field_75173_i + i, this.field_75170_j + 1, this.field_75171_k + n * 2);
                        }
                    }
                    for (n = 0; n < 3; ++n) {
                        this.field_75167_g[n] = zhty._a(this.field_75169_l, n, (int)f, cvzo2);
                    }
                    this.func_75142_b();
                }
            } else {
                for (int i = 0; i < 3; ++i) {
                    this.field_75167_g[i] = 0;
                }
            }
        }
    }

    @Override
    public boolean func_75140_a(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = this.field_75168_e.func_70301_a(0);
        if (this.field_75167_g[n] > 0 && cvzo2 != null && (entityPlayer.field_71068_ca >= this.field_75167_g[n] || entityPlayer.field_71075_bZ._d)) {
            if (!this.field_75172_h.field_72995_K) {
                boolean bl;
                List list = zhty._b(this.field_75169_l, cvzo2, this.field_75167_g[n]);
                boolean bl2 = bl = cvzo2._d == tgdv.field_77760_aL.field_77779_bT;
                if (list != null) {
                    entityPlayer.func_82242_a(-this.field_75167_g[n]);
                    if (bl) {
                        cvzo2._d = tgdv.field_92105_bW.field_77779_bT;
                    }
                    int n2 = bl ? this.field_75169_l.nextInt(list.size()) : -1;
                    for (int i = 0; i < list.size(); ++i) {
                        ixcc ixcc2 = (ixcc)list.get(i);
                        if (bl && i != n2) continue;
                        if (bl) {
                            tgdv.field_92105_bW._a(cvzo2, ixcc2);
                            continue;
                        }
                        cvzo2._a(ixcc2._a, ixcc2._b);
                    }
                    this.func_75130_a(this.field_75168_e);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void func_75134_a(EntityPlayer entityPlayer) {
        cvzo cvzo2;
        super.func_75134_a(entityPlayer);
        if (!this.field_75172_h.field_72995_K && (cvzo2 = this.field_75168_e.func_70304_b(0)) != null) {
            entityPlayer.func_71021_b(cvzo2);
        }
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return this.field_75172_h.func_72798_a(this.field_75173_i, this.field_75170_j, this.field_75171_k) != twgu.field_72096_bE.field_71990_ca ? false : entityPlayer.func_70092_e((double)this.field_75173_i + 0.5, (double)this.field_75170_j + 0.5, (double)this.field_75171_k + 0.5) <= 64.0;
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (n == 0) {
                if (!this.func_75135_a(cvzo3, 1, 37, true)) {
                    return null;
                }
            } else {
                if (((yeso)this.field_75151_b.get(0)).func_75216_d() || !((yeso)this.field_75151_b.get(0)).func_75214_a(cvzo3)) {
                    return null;
                }
                if (cvzo3._p() && cvzo3._b == 1) {
                    ((yeso)this.field_75151_b.get(0)).func_75215_d(cvzo3._l());
                    cvzo3._b = 0;
                } else if (cvzo3._b >= 1) {
                    ((yeso)this.field_75151_b.get(0)).func_75215_d(new cvzo(cvzo3._d, 1, cvzo3._j()));
                    --cvzo3._b;
                }
            }
            if (cvzo3._b == 0) {
                yeso2.func_75215_d(null);
            } else {
                yeso2.func_75218_e();
            }
            if (cvzo3._b == cvzo2._b) {
                return null;
            }
            yeso2.func_82870_a(entityPlayer, cvzo3);
        }
        return cvzo2;
    }
}

