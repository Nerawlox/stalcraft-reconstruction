/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public abstract class tego
extends jjgc {
    public final xqsf _a;
    public final mssh _b;
    protected int _c = 1;

    public tego(mssh mssh2, xqsf xqsf2) {
        this._b = mssh2;
        this._a = xqsf2;
        xqsf2.func_70295_k_();
        this._b();
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return this._a.func_70300_a(entityPlayer);
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        return null;
    }

    @Override
    public void func_75134_a(EntityPlayer entityPlayer) {
        super.func_75134_a(entityPlayer);
        this._a.func_70305_f();
    }

    public void _a() {
        this.field_75151_b.clear();
        this.field_75153_a.clear();
    }

    public void _b() {
        int n;
        int n2;
        int n3 = -18;
        int n4 = (this._c - 1) * this._a.func_70302_i_();
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.func_75146_a(this._a(n4 + n + n2 * 9, 8 + n * 18, 18 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.func_75146_a(new yeso(this._b, n + n2 * 9 + 9, 8 + n * 18, 103 + n2 * 18 + n3));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.func_75146_a(new yeso(this._b, n2, 8 + n2 * 18, 161 + n3));
        }
    }

    public void _a(int n) {
        if (n > 0) {
            this._c = n;
            this._a();
            this._b();
        }
    }

    public int _c() {
        return this._c;
    }

    protected abstract yeso _a(int var1, int var2, int var3);
}

