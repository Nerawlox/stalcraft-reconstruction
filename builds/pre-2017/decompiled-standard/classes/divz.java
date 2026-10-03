/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import java.util.List;

public class divz
extends ywuo {
    private List<thfd> _c = Lists.newArrayList();
    private thfd _d;

    public void _a(thfd thfd2) {
        this._d = thfd2;
        this._e();
        if (thfd2 != null) {
            this._d._a(this);
        }
    }

    public void _f() {
        this._c.clear();
    }

    public void _b(thfd thfd2) {
        this._c.add(thfd2);
    }

    public void _g() {
        thfd thfd2 = this._h();
        if (thfd2 != null) {
            this._a(thfd2);
            this._c.remove(thfd2);
        }
    }

    public thfd _h() {
        if (this._c.isEmpty()) {
            return null;
        }
        return this._c.get(0);
    }

    public thfd _i() {
        return this._d;
    }

    public void _c(thfd thfd2) {
        if (thfd2._j() != null) {
            for (cfum object : thfd2._j()) {
                if (object._f() == null) continue;
                object._f().run();
            }
        }
        if (thfd2._i() != null) {
            for (ywts ywts2 : thfd2._i()) {
                this._a(ywts2);
            }
        }
    }

    @Override
    public void _a_(lnrm.kjui kjui2) {
        if (this._d != null) {
            if (this._d._d() != null) {
                this._d._d()._a_(kjui2);
            }
            new xcpd(2, this._d._a(), this._d._b()).sendToServer();
        }
        super._a_(kjui2);
    }
}

