/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public abstract class tvms
extends Event {
    public final jysc _a;
    private static ListenerList _b;

    private tvms(jysc jysc2) {
        this._a = jysc2;
    }

    public tvms() {
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
    extends tvms {
        private static ListenerList _b;

        public kjui(jysc jysc2) {
            super(jysc2);
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
    extends tvms {
        private static ListenerList _b;

        public pidb(jysc jysc2) {
            super(jysc2);
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

