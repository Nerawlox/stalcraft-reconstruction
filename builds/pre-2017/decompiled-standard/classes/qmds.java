/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class qmds
extends Event {
    private static ListenerList _a;

    @Override
    protected void setup() {
        super.setup();
        if (_a != null) {
            return;
        }
        _a = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return _a;
    }

    public static class pidb
    extends qmds {
        public final float _a;
        private static ListenerList _b;

        public pidb(float f) {
            this._a = f;
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

    public static class kjui
    extends Event {
        public boolean _a = false;
        private static ListenerList _b;

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

