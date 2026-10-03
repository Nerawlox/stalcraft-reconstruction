/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;
import net.minecraft.util.sajh;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public abstract class ofxs
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

    public static class kjui
    extends ofxs {
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
    }

    public static class pidb
    extends ofxs {
        public HashMap<String, Float> _a;
        private float _b;
        private static ListenerList _c;

        public pidb(float f) {
            this._a = new HashMap(2);
            this._b = 0.0f;
            this._b = f;
            this._a.put("sun", Float.valueOf(1.0f - f));
            this._a.put("rain", Float.valueOf(f));
            this._a(1.0f);
        }

        public void _a(float f) {
            this._a.put("stars", Float.valueOf(Math.max(0.0f, f - this._b)));
            this._a.put("nostars", Float.valueOf(Math.min(1.0f, 1.0f - f + this._b)));
        }

        public void _a(String string, float f) {
            f = sajh._a(f, 0.0f, 1.0f);
            float f2 = 1.0f - f;
            for (Map.Entry<String, Float> entry : this._a.entrySet()) {
                entry.setValue(Float.valueOf(entry.getValue().floatValue() * f2));
            }
            this._a.put(string, Float.valueOf(f));
        }

        public pidb() {
        }

        @Override
        protected void setup() {
            super.setup();
            if (_c != null) {
                return;
            }
            _c = new ListenerList(super.getListenerList());
        }

        @Override
        public ListenerList getListenerList() {
            return _c;
        }
    }
}

