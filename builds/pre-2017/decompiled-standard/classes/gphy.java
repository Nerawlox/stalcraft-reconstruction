/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;

public class gphy
extends twgu
implements stgn {
    public String _a;
    public boolean _b;
    public boolean _c;
    public int _d;
    public boolean _e;
    public kjui _f;
    public String _g = "";
    private float[] _h = new float[6];

    public gphy(int n, boolean bl) {
        super(n, bl ? tflj._f : tflj._l);
        this._c = bl;
    }

    @Override
    public int func_71857_b() {
        return GloomyHooks._a[this.field_71990_ca];
    }

    public void _a(int n) {
        GloomyHooks._a[this.field_71990_ca] = n;
    }

    @Override
    public boolean func_71926_d() {
        return this._b;
    }

    @Override
    public void func_94332_a(nege nege2) {
        if (this._a != null) {
            this.field_94336_cN = nege2._b("customitems:" + this._a);
        }
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return this._c ? super.func_71872_e(ozlu2, n, n2, n3) : null;
    }

    @Override
    public boolean func_71886_c() {
        return this.func_71857_b() == 0;
    }

    @Override
    public int getLightValue(sdrg sdrg2, int n, int n2, int n3) {
        return this._d;
    }

    public void _a(float f, float f2, float f3, float f4, float f5, float f6) {
        this._h[0] = f;
        this._h[1] = f2;
        this._h[2] = f3;
        this._h[3] = f4;
        this._h[4] = f5;
        this._h[5] = f6;
        this._b(0);
    }

    public void _b(int n) {
        switch (n) {
            case 0: {
                this.field_72026_ch = this._h[0];
                this.field_72021_ck = this._h[3];
                this.field_72024_cj = this._h[2];
                this.field_72019_cm = this._h[5];
                break;
            }
            case 1: {
                this.field_72026_ch = this._h[2];
                this.field_72021_ck = this._h[5];
                this.field_72024_cj = 1.0f - this._h[3];
                this.field_72019_cm = 1.0f - this._h[0];
                break;
            }
            case 2: {
                this.field_72026_ch = 1.0f - this._h[3];
                this.field_72021_ck = 1.0f - this._h[0];
                this.field_72024_cj = 1.0f - this._h[5];
                this.field_72019_cm = 1.0f - this._h[2];
                break;
            }
            case 3: {
                this.field_72026_ch = 1.0f - this._h[5];
                this.field_72021_ck = 1.0f - this._h[2];
                this.field_72024_cj = this._h[0];
                this.field_72019_cm = this._h[3];
            }
        }
        this.field_72023_ci = this._h[1];
        this.field_72022_cl = this._h[4];
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (this._f == kjui._a) {
            this._a(ozlu2, entityPlayer);
            return true;
        }
        if (this._f == kjui._b) {
            this._b(ozlu2, entityPlayer);
            return true;
        }
        return false;
    }

    private void _a(ozlu ozlu2, EntityPlayer entityPlayer) {
        InvokeSideOnly.frontend(!ozlu2.field_72995_K, () -> {});
    }

    private void _b(ozlu ozlu2, EntityPlayer entityPlayer) {
        InvokeSideOnly.client(ozlu2.field_72995_K, () -> xpzm._E()._a(new cdew(this._g)));
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        if (this._e) {
            int n4 = sdrg2.func_72805_g(n, n2, n3);
            this._b(n4);
        }
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        if (this._e) {
            int n4 = sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 2.5) & 3;
            ozlu2.func_72921_c(n, n2, n3, n4, 2);
        }
    }

    @Override
    public boolean hasTileEntity(int n) {
        return this.func_71857_b() == -1;
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        if (this.func_71857_b() == -1) {
            return new uhov();
        }
        return null;
    }

    public static enum kjui {
        _a,
        _b;

    }
}

