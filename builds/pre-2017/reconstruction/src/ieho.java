/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class ieho
extends Event {
    public String _a;
    private static ListenerList _b;

    public ieho(String string) {
        this._a = string;
    }

    public ieho() {
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

