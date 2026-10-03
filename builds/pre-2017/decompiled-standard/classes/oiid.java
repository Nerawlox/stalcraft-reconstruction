/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.zwat;
import net.minecraft.util.zwaw;

public class oiid
extends hurg
implements nemo {
    public int _a;
    public String _b = "";
    public String _c = "@";

    public void _a(String string) {
        this._b = string;
        this.func_70296_d();
    }

    public String _a() {
        return this._b;
    }

    public int _a(ozlu ozlu2) {
        if (ozlu2.field_72995_K) {
            return 0;
        }
        dzfd dzfd2 = dzfd._I();
        if (dzfd2 != null && dzfd2.__ac()) {
            zyqp zyqp2 = dzfd2._J();
            return zyqp2.func_71556_a(this, this._b);
        }
        return 0;
    }

    @Override
    public String func_70005_c_() {
        return this._c;
    }

    public void _b(String string) {
        this._c = string;
    }

    @Override
    public void func_70006_a(zwat zwat2) {
    }

    @Override
    public boolean func_70003_b(int n, String string) {
        return n <= 2;
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("Command", this._b);
        qoac2._a("SuccessCount", this._a);
        qoac2._a("CustomName", this._c);
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this._b = qoac2._j("Command");
        this._a = qoac2._f("SuccessCount");
        if (qoac2._c("CustomName")) {
            this._c = qoac2._j("CustomName");
        }
    }

    @Override
    public zwaw func_82114_b() {
        return new zwaw(this.field_70329_l, this.field_70330_m, this.field_70327_n);
    }

    @Override
    public ozlu func_130014_f_() {
        return this.func_70314_l();
    }

    @Override
    public cezg func_70319_e() {
        qoac qoac2 = new qoac();
        this.func_70310_b(qoac2);
        return new wpte(this.field_70329_l, this.field_70330_m, this.field_70327_n, 2, qoac2);
    }

    public int _b() {
        return this._a;
    }

    public void _a(int n) {
        this._a = n;
    }
}

