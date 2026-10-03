/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class xqrl
extends Event {
    public final int _a;
    private static ListenerList _b;

    public xqrl(int n) {
        this._a = n;
    }

    public xqrl() {
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

