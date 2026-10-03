/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public abstract class rpct
extends Event {
    public final float _a;
    private static ListenerList _b;

    protected rpct(float f) {
        this._a = f;
    }

    public rpct() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (_b != null) {
            return;
        }
        _b = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _b;
    }

    public static class kjui
    extends rpct {
        private static ListenerList _b;

        public kjui(float f) {
            super(f);
        }

        public kjui() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (_b != null) {
                return;
            }
            _b = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return _b;
        }
    }

    public static class pidb
    extends rpct {
        private static ListenerList _b;

        public pidb(float f) {
            super(f);
        }

        public pidb() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (_b != null) {
                return;
            }
            _b = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return _b;
        }
    }
}

