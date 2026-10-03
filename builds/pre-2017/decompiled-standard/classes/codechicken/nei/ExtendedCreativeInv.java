/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEIClientConfig;
import codechicken.nei.PlayerSave;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;

public class ExtendedCreativeInv
implements mssh {
    PlayerSave playerSave;
    Side side;

    public ExtendedCreativeInv(PlayerSave playerSave, Side side) {
        this.playerSave = playerSave;
        this.side = side;
    }

    @Override
    public int func_70302_i_() {
        return 54;
    }

    @Override
    public cvzo func_70301_a(int n) {
        if (this.side.isClient()) {
            return NEIClientConfig.creativeInv[n];
        }
        return this.playerSave.creativeInv[n];
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        cvzo cvzo2 = this.func_70301_a(n);
        if (cvzo2 != null) {
            if (cvzo2._b <= n2) {
                cvzo cvzo3 = cvzo2;
                this.func_70299_a(n, null);
                this.func_70296_d();
                return cvzo3;
            }
            cvzo cvzo4 = cvzo2._a(n2);
            if (cvzo2._b == 0) {
                this.func_70299_a(n, null);
            }
            this.func_70296_d();
            return cvzo4;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public cvzo func_70304_b(int n) {
        ExtendedCreativeInv extendedCreativeInv = this;
        synchronized (extendedCreativeInv) {
            cvzo cvzo2 = this.func_70301_a(n);
            this.func_70299_a(n, null);
            return cvzo2;
        }
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        if (this.side.isClient()) {
            NEIClientConfig.creativeInv[n] = cvzo2;
        } else {
            this.playerSave.creativeInv[n] = cvzo2;
        }
        this.func_70296_d();
    }

    @Override
    public String func_70303_b() {
        return "Extended Creative";
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public void func_70296_d() {
        if (this.side.isServer()) {
            this.playerSave.setCreativeDirty();
        }
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return true;
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

    @Override
    public boolean func_94042_c() {
        return true;
    }
}

