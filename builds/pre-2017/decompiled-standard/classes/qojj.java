/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;

public class qojj
extends plne {
    public fojy _a;
    public qoac _b;

    public qojj() {
        this("scoreboard");
    }

    public qojj(String string) {
        super(string);
    }

    public void _a(fojy fojy2) {
        this._a = fojy2;
        if (this._b != null) {
            this.func_76184_a(this._b);
        }
    }

    @Override
    public void func_76184_a(qoac qoac2) {
        if (this._a == null) {
            this._b = qoac2;
            return;
        }
        this._b(qoac2._n("Objectives"));
        this._c(qoac2._n("PlayerScores"));
        if (qoac2._c("DisplaySlots")) {
            this._a(qoac2._m("DisplaySlots"));
        }
        if (qoac2._c("Teams")) {
            this._a(qoac2._n("Teams"));
        }
    }

    public void _a(bsyv bsyv2) {
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            dzew dzew2 = this._a._e(qoac2._j("Name"));
            dzew2._a(qoac2._j("DisplayName"));
            dzew2._b(qoac2._j("Prefix"));
            dzew2._c(qoac2._j("Suffix"));
            if (qoac2._c("AllowFriendlyFire")) {
                dzew2._a(qoac2._o("AllowFriendlyFire"));
            }
            if (qoac2._c("SeeFriendlyInvisibles")) {
                dzew2._b(qoac2._o("SeeFriendlyInvisibles"));
            }
            this._a(dzew2, qoac2._n("Players"));
        }
    }

    public void _a(dzew dzew2, bsyv bsyv2) {
        for (int i = 0; i < bsyv2._d(); ++i) {
            this._a._a(((xsxy)bsyv2._b((int)i))._c, dzew2);
        }
    }

    public void _a(qoac qoac2) {
        for (int i = 0; i < 3; ++i) {
            if (!qoac2._c("slot_" + i)) continue;
            String string = qoac2._j("slot_" + i);
            igri igri2 = this._a._a(string);
            this._a._a(i, igri2);
        }
    }

    public void _b(bsyv bsyv2) {
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            nwbn nwbn2 = (nwbn)nwbn._b.get(qoac2._j("CriteriaName"));
            igri igri2 = this._a._a(qoac2._j("Name"), nwbn2);
            igri2._a(qoac2._j("DisplayName"));
        }
    }

    public void _c(bsyv bsyv2) {
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            igri igri2 = this._a._a(qoac2._j("Objective"));
            cwdc cwdc2 = this._a._a(qoac2._j("Name"), igri2);
            cwdc2._c(qoac2._f("Score"));
        }
    }

    @Override
    public void func_76187_b(qoac qoac2) {
        if (this._a == null) {
            dzfd._I()._O()._b("Tried to save scoreboard without having a scoreboard...");
            return;
        }
        qoac2._a("Objectives", this._b());
        qoac2._a("PlayerScores", this._c());
        qoac2._a("Teams", this._a());
        this._b(qoac2);
    }

    public bsyv _a() {
        bsyv bsyv2 = new bsyv();
        Collection collection = this._a._e();
        for (dzew dzew2 : collection) {
            qoac qoac2 = new qoac();
            qoac2._a("Name", dzew2._a());
            qoac2._a("DisplayName", dzew2._b());
            qoac2._a("Prefix", dzew2._d());
            qoac2._a("Suffix", dzew2._e());
            qoac2._a("AllowFriendlyFire", dzew2._f());
            qoac2._a("SeeFriendlyInvisibles", dzew2._g());
            bsyv bsyv3 = new bsyv();
            for (String string : dzew2._c()) {
                bsyv3._a(new xsxy("", string));
            }
            qoac2._a("Players", bsyv3);
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public void _b(qoac qoac2) {
        qoac qoac3 = new qoac();
        boolean bl = false;
        for (int i = 0; i < 3; ++i) {
            igri igri2 = this._a._a(i);
            if (igri2 == null) continue;
            qoac3._a("slot_" + i, igri2._b());
            bl = true;
        }
        if (bl) {
            qoac2._a("DisplaySlots", qoac3);
        }
    }

    public bsyv _b() {
        bsyv bsyv2 = new bsyv();
        Collection collection = this._a._a();
        for (igri igri2 : collection) {
            qoac qoac2 = new qoac();
            qoac2._a("Name", igri2._b());
            qoac2._a("CriteriaName", igri2._c()._a());
            qoac2._a("DisplayName", igri2._d());
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public bsyv _c() {
        bsyv bsyv2 = new bsyv();
        Collection collection = this._a._c();
        for (cwdc cwdc2 : collection) {
            qoac qoac2 = new qoac();
            qoac2._a("Name", cwdc2._d());
            qoac2._a("Objective", cwdc2._c()._b());
            qoac2._a("Score", cwdc2._b());
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }
}

