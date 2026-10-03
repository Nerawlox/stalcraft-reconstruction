/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@Cancelable
public abstract class jylm
extends Event {
    public final tfsl _a;
    public final float _b;
    public final int _c;
    private static ListenerList _d;

    public jylm(tfsl tfsl2, float f, int n) {
        this._a = tfsl2;
        this._b = f;
        this._c = n;
    }

    public jylm() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (_d != null) {
            return;
        }
        _d = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _d;
    }

    public static class pidb
    extends jylm {
        private static ListenerList _d;

        public pidb(tfsl tfsl2, float f, int n) {
            super(tfsl2, f, n);
        }

        public pidb() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (_d != null) {
                return;
            }
            _d = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return _d;
        }
    }

    public static class kjui
    extends jylm {
        public int _d;
        private static ListenerList _e;

        public kjui(tfsl tfsl2, float f, int n, int n2) {
            super(tfsl2, f, n);
            this._d = n2;
        }

        public kjui() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (_e != null) {
                return;
            }
            _e = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return _e;
        }
    }

    public static class eidj
    extends jylm {
        private static ListenerList _d;

        public eidj(tfsl tfsl2, float f, int n) {
            super(tfsl2, f, n);
        }

        public eidj() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (_d != null) {
                return;
            }
            _d = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return _d;
        }
    }
}

