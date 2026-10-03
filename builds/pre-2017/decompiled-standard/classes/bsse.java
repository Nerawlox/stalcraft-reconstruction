/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class bsse
implements mssh {
    public cvzo[] field_70466_a;
    public int field_70464_b;
    public jjgc field_70465_c;

    public bsse(jjgc jjgc2, int n, int n2) {
        int n3 = n * n2;
        this.field_70466_a = new cvzo[n3];
        this.field_70465_c = jjgc2;
        this.field_70464_b = n;
    }

    @Override
    public int func_70302_i_() {
        return this.field_70466_a.length;
    }

    @Override
    public cvzo func_70301_a(int n) {
        if (n >= this.func_70302_i_()) {
            return null;
        }
        return this.field_70466_a[n];
    }

    public cvzo func_70463_b(int n, int n2) {
        if (n < 0 || n >= this.field_70464_b) {
            return null;
        }
        int n3 = n + n2 * this.field_70464_b;
        return this.func_70301_a(n3);
    }

    @Override
    public String func_70303_b() {
        return "container.crafting";
    }

    @Override
    public boolean func_94042_c() {
        return false;
    }

    @Override
    public cvzo func_70304_b(int n) {
        if (this.field_70466_a[n] != null) {
            cvzo cvzo2 = this.field_70466_a[n];
            this.field_70466_a[n] = null;
            return cvzo2;
        }
        return null;
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (this.field_70466_a[n] != null) {
            if (this.field_70466_a[n]._b <= n2) {
                cvzo cvzo2 = this.field_70466_a[n];
                this.field_70466_a[n] = null;
                this.field_70465_c.func_75130_a(this);
                return cvzo2;
            }
            cvzo cvzo3 = this.field_70466_a[n]._a(n2);
            if (this.field_70466_a[n]._b == 0) {
                this.field_70466_a[n] = null;
            }
            this.field_70465_c.func_75130_a(this);
            return cvzo3;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this.field_70466_a[n] = cvzo2;
        this.field_70465_c.func_75130_a(this);
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public void func_70296_d() {
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
}

