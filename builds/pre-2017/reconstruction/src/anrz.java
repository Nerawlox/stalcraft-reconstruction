/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@Cancelable
public class anrz
extends Event {
    public final kjui _a;
    public final pidb _b;
    private static ListenerList _c;

    public anrz(kjui kjui2, pidb pidb2) {
        this._a = kjui2;
        this._b = pidb2;
    }

    public anrz() {
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

    public static enum kjui {
        _a,
        _b,
        _c;

    }

    public static enum pidb {
        _a,
        _b,
        _c;

    }
}

