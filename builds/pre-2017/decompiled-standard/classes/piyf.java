/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

public class piyf
extends Event {
    public final tgdv _a;
    public final rpaa _b;
    private static ListenerList _c;

    public piyf(tgdv tgdv2, rpaa rpaa2) {
        this._a = tgdv2;
        this._b = rpaa2;
    }

    public piyf() {
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

