/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class zfdc
extends zwat {
    public ArrayList<kjui> _a;

    @Override
    public void read(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        this._a = new ArrayList(n);
        for (int i = 0; i < n; ++i) {
            this._a.add(new kjui(dataInput));
        }
        Collections.sort(this._a);
    }

    @Override
    public void processClient(boolean bl) {
        yuch._a._b(this._a);
    }

    public static class kjui
    implements Comparable<kjui> {
        public final String _a;
        public final int _b;
        public final String _c;
        public final String _d;
        public final int _e;
        public final int _f;
        public final int _g;
        public final dfkn _h = new dfkn();
        public final String _i;
        public final DayOfWeek _j;
        public final LocalTime _k;
        public final Duration _l;
        public final boolean _m;
        public final String _n;
        public final int _o;

        public kjui(DataInput dataInput) throws IOException {
            this._a = dataInput.readUTF();
            this._b = dataInput.readInt();
            this._d = dataInput.readUTF();
            this._e = dataInput.readInt();
            this._f = dataInput.readInt();
            this._g = dataInput.readInt();
            this._i = dataInput.readUTF();
            this._m = dataInput.readBoolean();
            if (this._m) {
                byte by = dataInput.readByte();
                this._j = by == -1 ? null : DayOfWeek.values()[by];
                this._k = LocalTime.ofSecondOfDay(dataInput.readInt());
                this._l = Duration.ofSeconds(dataInput.readInt());
                this._h.read(dataInput);
            } else {
                this._j = null;
                this._k = null;
                this._l = null;
            }
            this._n = dataInput.readUTF();
            this._o = dataInput.readInt();
            this._c = dataInput.readUTF();
        }

        public int _a(kjui kjui2) {
            return this._a.compareTo(kjui2._a);
        }

        @Override
        public /* synthetic */ int compareTo(Object object) {
            return this._a((kjui)object);
        }
    }
}

