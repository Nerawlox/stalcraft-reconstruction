/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.dwan;

public class vlpj
extends scgt {
    public dwan _a;

    public vlpj(int n) {
        super(n, false);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n2 >= 6) {
            return this._a;
        }
        return this.field_94336_cN;
    }

    @Override
    public void func_94332_a(nege nege2) {
        super.func_94332_a(nege2);
        this._a = nege2._b(this.func_111023_E() + "_turned");
    }

    @Override
    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5, int n6) {
        if (n6 > 0 && twgu.field_71973_m[n6].func_71853_i() && new hcdc(this, ozlu2, n, n2, n3)._b() == 3) {
            this._a(ozlu2, n, n2, n3, false);
        }
    }
}

