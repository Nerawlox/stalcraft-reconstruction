/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.Nullable;

public class ogej
extends hsnd<zxbe>
implements nuct {
    public final hsnd<? extends jhuw> _a;
    public final hsnd<iest>[] _b;
    private List<uhrn> _c = new ArrayList<uhrn>(2);
    private List<uhrn> _d = new ArrayList<uhrn>(2);

    @SafeVarargs
    public ogej(hsnd<? extends jhuw> hsnd2, hsnd<iest> ... hsndArray) {
        this._a = hsnd2;
        this._b = hsndArray;
    }

    @Override
    protected void _d() {
        kjui kjui2 = new kjui();
        this._a._a((jhuw)((Object)((Consumer<jhuw>)kjui2::_a)));
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i]._a((iest)((Object)((Consumer<iest>)kjui2::_a)));
        }
    }

    @Override
    protected void _a(zxbe zxbe2) {
        this._a._k();
        for (hsnd<iest> hsnd2 : this._b) {
            hsnd2._k();
        }
    }

    @Override
    public void _b() {
        zxbe zxbe2 = (zxbe)this._u_();
        if (zxbe2 != null) {
            zxbe2._b();
        }
    }

    @Override
    @Nullable
    public jhuw _a() {
        zxbe zxbe2 = (zxbe)this._u_();
        return zxbe2 == null ? null : zxbe2._a();
    }

    @Override
    @Nullable
    public wnxc _a(String string) {
        zxbe zxbe2 = (zxbe)this._u_();
        return zxbe2 == null ? null : zxbe2._a(string);
    }

    @Override
    public List<uhrn> _v_() {
        return this._c;
    }

    @Override
    public List<uhrn> _e() {
        return this._d;
    }

    @Override
    @Nullable
    public ivtm _a(float f) {
        zxbe zxbe2 = (zxbe)this._u_();
        return zxbe2 == null ? null : zxbe2._a(f);
    }

    public String toString() {
        return "{DynamicAnimationContext for " + this._a + "}";
    }

    private class kjui {
        private jhuw _b;
        private List<iest> _c = new ArrayList<iest>(1);
        private int _d;

        private kjui() {
        }

        void _a(jhuw jhuw2) {
            this._b = jhuw2;
            this._a();
        }

        void _a(iest iest2) {
            if (iest2 != null) {
                this._c.add(iest2);
            }
            this._a();
        }

        private void _a() {
            if (++this._d == ogej.this._b.length + 1) {
                if (this._b == null) {
                    ogej.this._a(null, oxca.kjui._d);
                } else {
                    zxbe zxbe2 = new zxbe(this._b, this._c.toArray(new iest[0]));
                    zxbe2._a = ogej.this._c;
                    zxbe2._b = ogej.this._d;
                    ogej.this._a(zxbe2, oxca.kjui._c);
                }
            }
        }
    }
}

