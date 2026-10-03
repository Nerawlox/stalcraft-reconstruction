/*
 * Decompiled with CFR 0.152.
 */
public class dgwv
extends twgu {
    public boolean _a;
    public String _b;

    public dgwv(int n, String string, tflj tflj2, boolean bl) {
        super(n, tflj2);
        this._a = bl;
        this._b = string;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        int n5 = sdrg2.func_72798_a(n, n2, n3);
        if (!this._a && n5 == this.field_71990_ca) {
            return false;
        }
        return super.func_71877_c(sdrg2, n, n2, n3, n4);
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this._b);
    }
}

