/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class ccvb
extends Event {
    public final zxbe _a;
    private static ListenerList _b;

    public ccvb(zxbe zxbe2) {
        this._a = zxbe2;
    }

    public ccvb() {
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

