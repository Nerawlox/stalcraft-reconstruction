/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@Cancelable
public class anrg
extends Event {
    public final boolean _a;
    public final int _b;
    public final int _c;
    private static ListenerList _d;

    public anrg(int n, int n2, boolean bl) {
        this._b = n;
        this._c = n2;
        this._a = bl;
    }

    public anrg() {
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

